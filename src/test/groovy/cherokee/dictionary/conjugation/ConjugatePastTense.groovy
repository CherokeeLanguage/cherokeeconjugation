package cherokee.dictionary.conjugation

import cherokee.dictionary.conjugation.cdpbook.Stemmer
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.stem.DefinitionLine

class ConjugatePastTense extends ConjugateBase {
    static def heSeesIt = new Stemmer()

    static def DNM = "FAILURE DID NOT MATCH"
    static {
        heSeesIt.habitual = new DefinitionLine(syllabary: "ᎠᎪᏩᏘᏍᎪᎢ")
        heSeesIt.imperative = new DefinitionLine(syllabary: "ᎯᎪᏩᏔ")
        heSeesIt.infinitive = new DefinitionLine(syllabary: "ᎤᎪᏩᏛᏗ")
        heSeesIt.present1st = new DefinitionLine(syllabary: "ᏥᎪᏩᏘᎭ")
        heSeesIt.present3rd = new DefinitionLine(syllabary: "ᎠᎪᏩᏘᎭ")
        heSeesIt.remotepast = new DefinitionLine(syllabary: "ᎤᎪᎲᎢ")
    }
    public void test() {
//        assertEquals(DNM, "ᏥᎪᏩᏘᏍᎬᎢ", conjPast("SG1", "SG3AN"))
    }

    private String conjPast(subj, obj) {
        Conjugate conjugate = new Conjugate()
        //stemmer failure -- need to fix
        return conjugate.conjugate(subj, obj, heSeesIt, Tense.REMOTE_PAST.toString(), "v.t.")
    }
}
