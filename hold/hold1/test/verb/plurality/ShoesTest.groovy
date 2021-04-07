package cherokee.dictionary.verb.plurality

import cherokee.dictionary.hold.ConjugateBase

class ShoesTest extends ConjugateBase {
    public void testShoes() {
        def partofspeechc = "v.t."
        def verbTense = "PRESENT"

        println conj("SG1", "SG3AN", wearShoes, verbTense, partofspeechc)
        println conj("SG2", "SG3AN", wearShoes, verbTense, partofspeechc)
        println conj("SG3", "SG3AN", wearShoes, verbTense, partofspeechc)
        println conj("DL1INCL", "SG3AN", wearShoes, verbTense, partofspeechc)
        println conj("DL1EXCL", "SG3AN", wearShoes, verbTense, partofspeechc)
        println conj("DL2", "SG3AN", wearShoes, verbTense, partofspeechc)
        println conj("PL1INCL", "SG3AN", wearShoes, verbTense, partofspeechc)
        println conj("PL1EXCL", "SG3AN", wearShoes, verbTense, partofspeechc)
        println conj("PL2", "SG3AN", wearShoes, verbTense, partofspeechc)
        println conj("PL3", "SG3AN", wearShoes, verbTense, partofspeechc)
        println conj("SG1", "PL3AN", wearShoes, verbTense, partofspeechc)
        println conj("SG2", "PL3AN", wearShoes, verbTense, partofspeechc)
        println conj("SG3", "PL3AN", wearShoes, verbTense, partofspeechc)
        println conj("DL1INCL", "PL3AN", wearShoes, verbTense, partofspeechc)
        println conj("DL1EXCL", "PL3AN", wearShoes, verbTense, partofspeechc)
        println conj("DL2", "PL3AN", wearShoes, verbTense, partofspeechc)
        println conj("PL1INCL", "PL3AN", wearShoes, verbTense, partofspeechc)
        println conj("PL1EXCL", "PL3AN", wearShoes, verbTense, partofspeechc)
        println conj("PL2", "PL3AN", wearShoes, verbTense, partofspeechc)
        println conj("PL3", "PL3AN", wearShoes, verbTense, partofspeechc)
    }
}
