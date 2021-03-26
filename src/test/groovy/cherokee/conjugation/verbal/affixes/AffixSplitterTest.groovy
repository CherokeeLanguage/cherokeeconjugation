package cherokee.conjugation.verbal.affixes

class AffixSplitterTest extends GroovyTestCase {
    public void testAffixSplitter() {
        AffixSplitter affixSplitter = new AffixSplitter()
        def f = new File("affix.txt")
        f.write("", "utf-8")
        f.append(affixSplitter.processLine("ᏂᏓᏋᏅᎢ"), "utf-8")

        println affixSplitter.pronouns
    }
}
