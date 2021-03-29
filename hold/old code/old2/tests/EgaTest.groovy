package cherokee.dictionary.conjugation

import Stemmer
import Tense
import DefinitionLine

class EgaTest extends GroovyTestCase {
    static def ega = new Stemmer()
    static def DNM = "FAILURE DID NOT MATCH"
    static {
        ega.habitual = new DefinitionLine(syllabary: "ᎡᎪᎢ")
        ega.imperative = new DefinitionLine(syllabary: "ᎮᎾ")
        ega.infinitive = new DefinitionLine(syllabary: "ᎤᏪᏅᏍᏗ")
        ega.present1st = new DefinitionLine(syllabary: "ᎨᎦ")
        ega.present3rd = new DefinitionLine(syllabary: "ᎡᎦ")
        ega.remotepast = new DefinitionLine(syllabary: "ᎤᏪᏅᏒᎢ")
    }

    public void testEgaConjugation() {
        //need to figure out why Ega is coming up gega for 3rd person
        Conjugate conjugate = new Conjugate()
        def sg1sg3an = conjugate.conjugate("SG1", "SG3AN", ega, Tense.PRESENT.toString(), "v.i.")
        def sg1sg3in = conjugate.conjugate("SG1", "SG3IN", ega, Tense.PRESENT.toString(), "v.i.")
        def sg3sg3an = conjugate.conjugate("SG3", "SG3AN", ega, Tense.PRESENT.toString(), "v.i.")
        def sg3sg3in =  conjugate.conjugate("SG3", "SG3IN", ega, Tense.PRESENT.toString(), "v.i.")
        def sg2sg3in =  conjugate.conjugate("SG2", "SG3IN", ega, Tense.PRESENT.toString(), "v.i.")

        groovy.util.GroovyTestCase.assertEquals(DNM, "ᎨᎦ" , sg1sg3an)
        groovy.util.GroovyTestCase.assertEquals(DNM, "ᎨᎦ" , sg1sg3in)
        groovy.util.GroovyTestCase.assertEquals(DNM, "ᎮᎦ" , sg2sg3in)
        groovy.util.GroovyTestCase.assertEquals(DNM, "ᎡᎦ" , sg3sg3an)
        groovy.util.GroovyTestCase.assertEquals(DNM, "ᎡᎦ" , sg3sg3in)
    }
}
