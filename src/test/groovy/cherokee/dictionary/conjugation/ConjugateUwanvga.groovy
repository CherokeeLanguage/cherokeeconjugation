package cherokee.dictionary.conjugation

import cherokee.dictionary.verb.conjugation.originalConjugation.Tense

class ConjugateUwanvga extends ConjugateBase {
    public void testUwanvga() {
        def partofspeechc = "v.i."
        def verbTense = Tense.PRESENT.toString()

//        assertTrue "ᎬᏯᏚᎵᎭ" == conj("SG1", "SG2", heWantsIt, verbTense, partofspeechc)

        println "conjugation is; " + conj("SG1", "SG2", uwanvga, verbTense, partofspeechc)
        println "conjugation is; " + conj("SG3", "SG3", uwanvga, verbTense, partofspeechc)
    }
}
