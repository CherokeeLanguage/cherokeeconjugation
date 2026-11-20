#!/usr/bin/perl
# tio 19Nov26: align each vrb spec's where-table expected to its own
# details.conjugations rows (the VRB book forms).
#
# Corrected pass (D24). Differences from the first version:
#   * keys on (subject, object), not subject alone -- multi-object grids were
#     being overwritten with whichever same-subject row came last.
#   * FUTURE_COMMAND is NEVER synthesized from the details' remote_past
#     surface. VerbTenseHolder.futureCommand = remotePast ?: completiveFuture
#     is a STEM; the composed FUTURE_COMMAND surface differs from the composed
#     REMOTE_PAST surface, so only the engine can supply it. Those cells stay
#     as authored and are reported.
#   * a subject/object that has more than one DISTINCT details row is
#     ambiguous in a where-table that cannot distinguish them; it is left
#     untouched and reported instead of guessed.
#
# Tense->field map: PRESENT->present, HABITUAL->habitual,
# REMOTE_PAST->remote_past, INFINITIVE->infinitive.
#
# Usage: align_where.pl [--dry-run] <vrb-spec-dir>
use strict; use warnings; use utf8;
binmode(STDOUT, ":utf8");

my $dry = 0;
if (@ARGV && $ARGV[0] eq '--dry-run') { $dry = 1; shift @ARGV; }
my $dir = $ARGV[0] or die "usage: align_where.pl [--dry-run] <vrb-spec-dir>\n";
opendir(my $d, $dir) or die $!;
my $MARK = '// tio 19Nov26: expectations aligned to this spec\'s VRB detail rows where unambiguous (D24)';
my $tenseMap = { PRESENT=>'present', HABITUAL=>'habitual',
                 REMOTE_PAST=>'remote_past', INFINITIVE=>'infinitive' };
my ($totChanged, $totAmb, $totNoDet, $totFuture) = (0, 0, 0, 0);

for my $f (grep { /Spec\.groovy$/ } sort readdir($d)) {
    open(my $h, '<:utf8', "$dir/$f") or next;
    my @lines = <$h>; close($h);

    # ---- details rows: key "subject\0object" -> [ distinct row hashes ] ----
    my %det;
    my %seenSig;
    my $inDetails = 0;
    for my $line (@lines) {
        if ($line =~ /conjugations:\s*\[/) { $inDetails = 1; }
        if ($inDetails && $line =~ /\[subject:\s*'(\w+)'/) {
            my $subj = $1;
            my $obj = ($line =~ /object:\s*'([^']*)'/) ? $1 : '';
            my %row;
            while ($line =~ /(\w+):\s*'([^']*)'/g) {
                my ($k, $v) = ($1, $2);
                next if $k eq 'subject' || $k eq 'object';
                $row{$k} = $v;
            }
            my $key = "$subj\0$obj";
            my $sig = join('|', map { "$_=$row{$_}" } sort keys %row);
            unless ($seenSig{$key}{$sig}++) {
                push @{$det{$key}}, \%row;
            }
        }
        if ($inDetails && $line =~ /^\s*\]\s*$/) { $inDetails = 0; }
    }
    # Drop partial duplicate rows: the specs sometimes carry a lone
    # `[subject: 'SG1', present: 'x']` line before the full row for the same
    # person. A row whose fields are a subset of another row for the same
    # (subject, object) adds no information and must not make the key
    # ambiguous.
    for my $key (keys %det) {
        my @rows = @{$det{$key}};
        my @keep;
        for my $r (@rows) {
            my $subset = 0;
            for my $s (@rows) {
                next if $r == $s;
                my $isSub = 1;
                for my $k (keys %$r) { $isSub = 0 if !defined $s->{$k} || $s->{$k} ne $r->{$k}; }
                if ($isSub) { $subset = 1; last; }
            }
            push @keep, $r unless $subset;
        }
        $det{$key} = \@keep;
    }

    # ---- where rows: collect (index, key, group ordinal within key) -------
    # The where tables list one consecutive block per details row (SG1 rows
    # are often omitted, but block order follows the details order). When the
    # block count for a key equals the distinct detail-row count for that key,
    # block i is paired with detail row i; otherwise the key is ambiguous.
    # Block boundaries are marked by PRESENT: each authored block starts with
    # PRESENT, so the n-th PRESENT for a key opens block n.
    my (@recs, %blocks);
    for my $i (0 .. $#lines) {
        my $line = $lines[$i];
        next unless $line =~ /^\s*"(\w+)"\s*\|\s*"([^"]*)"\s*\|\s*Tense\.(\w+)\s*\|\s*"([^"]*)"/;
        my ($subj, $obj, $tense, $old) = ($1, $2, $3, $4);
        my $key = "$subj\0$obj";
        $blocks{$key}++ if $tense eq 'PRESENT';
        my $grp = ($blocks{$key} // 0) - 1;   # -1 = rows before the first PRESENT
        push @recs, { i=>$i, key=>$key, tense=>$tense, old=>$old, grp=>$grp };
    }
    my %groups = %blocks;

    my ($changed, $amb, $nodet, $fut) = (0, 0, 0, 0);
    for my $r (@recs) {
        my ($subj, $obj) = split(/\0/, $r->{key});
        if ($r->{tense} eq 'FUTURE_COMMAND') { $fut++; next; }
        my $field = $tenseMap->{$r->{tense}} or next;
        my $rows = $det{$r->{key}};
        if (!$rows) { $nodet++; next; }
        my $row;
        if (scalar(@$rows) == 1)             { $row = $rows->[0]; }
        elsif ($groups{$r->{key}} == scalar(@$rows)) { $row = $rows->[$r->{grp}]; }
        else                                  { $amb++; next; }
        my $v = $row->{$field};
        next if !defined $v || $v eq '';
        next if $v eq $r->{old};
        my $line = $lines[$r->{i}];
        $line =~ s/"\Q$r->{old}\E"(\s*(?:\/\/.*)?)(\r?\n)\z/"$v"$1$2/;
        $lines[$r->{i}] = $line;
        $changed++;
    }

    if ($changed) {
        unless ($dry) {
            my @out;
            my $marked = 0;
            for my $line (@lines) {
                if (!$marked && $line =~ /^([ \t]*)where:[ \t]*(\r?\n)$/) {
                    my ($ind, $eol) = ($1, $2);
                    push @out, "$ind$MARK$eol";
                    $marked = 1;
                }
                push @out, $line;
            }
            open(my $o, '>:utf8', "$dir/$f") or die $!;
            print $o @out; close($o);
        }
        printf "%-40s %4d aligned%s%s%s\n", $f, $changed,
            ($amb   ? " | $amb ambiguous left"    : ''),
            ($nodet ? " | $nodet no-details left" : ''),
            ($fut   ? " | $fut future-command left" : '');
    }
    $totChanged += $changed; $totAmb += $amb; $totNoDet += $nodet; $totFuture += $fut;
}

print "--\n";
printf "%s: %d rows aligned; %d ambiguous, %d no-details, %d future-command left untouched\n",
    ($dry ? 'DRY RUN' : 'applied'), $totChanged, $totAmb, $totNoDet, $totFuture;
