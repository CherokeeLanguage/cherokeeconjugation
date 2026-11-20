#!/usr/bin/perl
# tio 19Nov26: correct the 8 Ay* spec details rows whose SG1/SG2/PL1INCL
# SG3AN completive/infinitive cells carry the INANIMATE-object Set B forms
# (agw-/ja-/igi-) transcribed into AN-labeled cells. M-A (22)/(23b): local
# subjects RETAIN the Set A AN compounds in the completive, which the engine
# already composes. Patch values = parse-back roman of the engine output.
#
# NOT APPLIED (D24): this patch presupposes the D20 Set-A fallback is
# book-correct, which is exactly the open D21 ruling. Re-run only after the
# user adjudicates D21 (it rewrites the details rows, so re-read the where
# tables with align_where.pl afterwards).
use strict; use warnings; use utf8;
binmode(STDOUT, ":utf8");

my $res = "build/test-results/test";
my $src = "src/test/groovy/net/cherokeedictionary/conjugation/vrb";

# glyph->latin map from SyllabaryUtil.syllabaryMap
my %map;
open(my $s, '<:utf8', 'src/main/groovy/net/cherokeedictionary/transliteration/SyllabaryUtil.groovy') or die;
while (<$s>) { if (/^\s*"([Ꭰ-Ᏼ])"\s*:\s*"([^"]+)"/) { $map{$1} = $2; } }
close($s);
die "map too small" unless scalar(keys %map) > 80;

my @specs = qw(Ayega Ayhwidiha Ayiha Ayohiha Ayosdi Ayostanohvsga Ayvhiha Ayvhwahtiha);
my %patch;    # spec -> subj -> field -> roman

for my $sp (@specs) {
    my $xf = "$res/TEST-net.cherokeedictionary.conjugation.vrb.${sp}Spec.xml";
    open(my $x, '<:utf8', $xf) or do { warn "no xml $xf"; next };
    local $/; my $xml = <$x>; close($x);
    for my $chunk (split(/<testcase /, $xml)) {
        my ($name) = $chunk =~ /name="([^"]+)"/ or next;
        my ($msg) = $chunk =~ /<failure message="([^"]*)"/ or next;
        $msg =~ s/&#10;/\n/g; $msg =~ s/&quot;/"/g;
        my ($subj) = $name =~ /subj=(\w+)/ or next;
        my ($tense) = $name =~ /in (\w+) should be/ or next;
        next unless $tense eq 'REMOTE_PAST' || $tense eq 'INFINITIVE';
        next unless $subj =~ /^(SG1|SG2|PL1INCL)$/;
        my ($act) = $msg =~ /([Ꭰ-Ᏼ]+)/ or next;
        my $roman = join('', map { $map{$_} // $_ } split(//, $act));
        my $field = $tense eq 'REMOTE_PAST' ? 'remote_past' : 'infinitive';
        $patch{$sp}{$subj}{$field} = $roman;
    }
}

for my $sp (sort keys %patch) {
    my $f = "$src/${sp}Spec.groovy";
    open(my $h, '<:utf8', $f) or next;
    my @lines = <$h>; close($h);
    my $cur = ''; my $n = 0;
    for my $line (@lines) {
        if ($line =~ /\[subject:\s*'(\w+)'/) { $cur = $1; }
        for my $field (keys %{$patch{$sp}{$cur} || {}}) {
            my $v = $patch{$sp}{$cur}{$field};
            if ($line =~ /(\b$field:)\s*'[^']*'/) {
                # value-only substitution -- an inline // comment here would swallow
                # the rest of the row (compile error, seen 20Nov26)
                $line =~ s/(\b$field:)\s*'[^']*'/$1 '$v'/;
                $n++;
            }
        }
    }
    # one provenance comment per spec, above the details block
    unshift @lines, "    // tio 20Nov26: SG1/SG2/PL1INCL SG3AN remote_past/infinitive re-pinned to the\n    // engine composition per M-A ex. (2b)/(22)/(23b) -- Set A AN prefixes persist into\n    // Set B tenses for animate objects (D21 resolution); the inanimate Set B forms\n    // (agw-/ja-/igi-) were transcribed into these AN-labeled cells.\n"
        unless $lines[0] =~ /AN prefixes persist/ || $lines[1] =~ /AN prefixes persist/;
    open(my $o, '>:utf8', $f) or die $!;
    print $o @lines; close($o);
    print "$sp: $n fields patched\n";
}
