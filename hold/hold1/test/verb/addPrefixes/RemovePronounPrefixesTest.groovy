package cherokee.dictionary.verb.addPrefixes

import com.cobradoc.cherokee.SyllabaryUtil

class RemovePronounPrefixesTest extends GroovyTestCase {
    def su = new SyllabaryUtil()
    public void testRemovePronounPrefixesConsonant() {
        Word word = new Word()
        def wholeWord = "ᏥᎪᏩᏘ"
        def pp = PronounProcessor.removePronounPrefix(word, wholeWord)
        assertTrue("ᎪᏩᏘ" == word.rootSyllabary)
    }

    public void testRemovePronounPrefixesVowel() {
        Word word = new Word()
        def wholeWord = "ᏥᎪᏩᏘ"
        def pp = PronounProcessor.removePronounPrefix(word, wholeWord)
        assertTrue("ᎪᏩᏘ" == word.rootSyllabary)
    }

    //finalSuffix and pronounPrefix only
    public void testRootExtraction() {
        removePrefixForCompare("ᏥᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        removePrefixForCompare("ᎠᎪᏩᏘᎭ", "ᎠᎪᏩᏘᎭ")
        removePrefixForCompare("ᎯᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        removePrefixForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩᎠ")
        //TODO: FAILS!!!!!
        removePrefixForCompare("ᎭᏔᏍᎩ", "ᎠᏔᏍᎩ")
        removePrefixForCompare("ᎤᏔᏍᎩᏒᎢ", "ᎠᏔᏍᎩᏒᎢ")
        removePrefixForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩᎠ")
        removePrefixForCompare("ᏥᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")
        removePrefixForCompare("ᏍᏗᎪᏩᏘᎭ", "ᎪᏩᏘᎭ")

        //third person present -- bleed -- rrd
        removePrefixForCompare("ᎠᏔᏍᎩᎠ", "ᎠᏔᏍᎩᎠ")
    }

    public void testSingle() {
        removePrefixForCompare("ᎦᏔᏍᎩᎠ", "ᎠᏔᏍᎩᎠ")
    }

    private void removePrefixForCompare(original, assertion) {
        Word word = new Word()
        PronounProcessor.removePronounPrefix(word, original)

        if (word.rootSyllabary != assertion) {
            println word.rootSyllabary + " -- " + assertion
        }

        assertTrue(word.rootSyllabary == assertion)
    }
}
