package cherokee.conjugation.verbal.affixes

import cherokee.conjugation.verbal.Verb

class AffixSplitterRewriteTest extends GroovyTestCase {
    def f = new File("affix2.txt")

    //this test should:
    // take the verb given and:
    //    return the correct verbfinalsuffixholderobject
    //    return the correct prefixes
    //    return the correct pronoun prefix
    //    return a verb object
    public void testAffixSplitter() {
        AffixSplitter affixSplitter = new AffixSplitter()
        def processed = affixSplitter.processLine("ᏂᏓᏋᏅᎢ")
        def spl = processed.split(" ")
        spl.each {
            println it
        }
    }
}
