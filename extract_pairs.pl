use strict; use warnings; use utf8;
use utf8;
binmode(STDOUT, ":utf8");
for my $f (@ARGV) {
    open(my $x, '<:utf8', $f) or next;
    local $/; my $xml = <$x>; close($x);
    for my $chunk (split(/<testcase /, $xml)) {
        my ($m) = $chunk =~ /name="([^"]+)"/ or next;
        my ($msg) = $chunk =~ /<failure message="([^"]*)"/ or next;
        $msg =~ s/&#10;/\n/g; $msg =~ s/&quot;/"/g;
        my ($act) = $msg =~ /([Ꭰ-Ᏼ]+)/ or next;
        my ($exp) = $msg =~ /should be ([\w", ]+?)"/ or next;
        print "$f | $m | engine=$act | book=$exp\n";
    }
}
