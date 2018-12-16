package cherokee.dictionary.conjugation

import cherokee.dictionary.conjugation.cdpbook.Stemmer
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.stem.DefinitionLine

class EgaTest extends GroovyTestCase {
    static def ega = new Stemmer()
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
        println conjugate.conjugate("SG1", "SG3AN", ega, Tense.PRESENT.toString(), "v.i.")
        println conjugate.conjugate("SG1", "SG3IN", ega, Tense.PRESENT.toString(), "v.i.")
        println conjugate.conjugate("SG3", "SG3AN", ega, Tense.PRESENT.toString(), "v.i.")
        println conjugate.conjugate("SG3", "SG3IN", ega, Tense.PRESENT.toString(), "v.i.")
    }
}
