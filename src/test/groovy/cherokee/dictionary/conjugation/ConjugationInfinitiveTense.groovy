package cherokee.dictionary.conjugation

import cherokee.dictionary.conjugation.conjugate.Tense

class ConjugationInfinitiveTense extends ConjugateBase {
    public void testHiwonihi() {
        def partofspeechc = "vi"
        def verbTense = Tense.FUTURE_COMMAND.toString()
        assertEquals "", "ᎯᏬᏂᎯ", conj("SG2", "", hiwoniha, verbTense, partofspeechc)
    }
}
