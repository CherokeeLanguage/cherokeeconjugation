package net.cherokeedictionary.conjugation


/*This code should be in every file*/

class ConjugateReflexivePrefixPresentTense extends ConjugateBase {
    //todo: check the dictionary for the actual forms - then extrapolate for completeness - find more examples somewhere
    void testReflexivePresentTense() {
        //pass in a stemmer and then conjugate it adding reflexive to the morpheme
        def partofspeechc = "v.t."
        def verbTense = "PRESENT"
        //TODO: fix this to match the reflexive examples
        assertTrue "ᎠᏓᏚᎵᎭ" == conj("SG1", "SG2", heWantsIt, verbTense, partofspeechc, true).pronounReflexiveRoot
        assertTrue "ᎦᏬᏂᎭ" == conj("SG3", "SG3AN", hiwoniha, verbTense, partofspeechc, false).pronounReflexiveRoot
        assertTrue "ᎠᏓᏬᏂᎭ" == conj("SG3", "SG3AN", hiwoniha, verbTense, partofspeechc, true).pronounReflexiveRoot
        assertTrue "ᎠᏓᏛᏂᎭ" == conj("SG1", "SG2", hitting, verbTense, partofspeechc, true).pronounReflexiveRoot

        partofspeechc = "v.i."
        assertTrue "", "ᎠᏓᏬᏂᎭ" == conj("SG1", "", hiwoniha, verbTense, partofspeechc, true).pronounReflexiveRoot
    }
}
