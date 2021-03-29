package cherokee.old.conjugation

import cherokee.dictionary.verb.conjugation.originalConjugation.PrefixTableObject
import cherokee.dictionary.verb.conjugation.originalConjugation.PrefixTableSubject
import cherokee.dictionary.verb.conjugation.originalConjugation.Tense

class ConjugateUwanvga extends ConjugateBase {
    public void testUwanvga() {
        def partofspeechc = "v.i."
        def verbTense = Tense.PRESENT.toString()

//        assertTrue "ᎬᏯᏚᎵᎭ" == conj("SG1", "SG2", heWantsIt, verbTense, partofspeechc)

//        PrefixTableSubject.getEnumConstants().each {
//
//            println "\"conjugation is; \" + conj(PrefixTableSubject.${PrefixTableSubject."$it"}, PrefixTableObject.SG3AN, uwanvga, verbTense, partofspeechc)"
//        }

        println "conjugation is; " + conj(PrefixTableSubject.SG1, PrefixTableObject.SG3AN, uwanvga, verbTense, partofspeechc)
        println "conjugation is; " + conj(PrefixTableSubject.SG2, PrefixTableObject.SG3AN, uwanvga, verbTense, partofspeechc)
        println "conjugation is; " + conj(PrefixTableSubject.SG3, PrefixTableObject.SG3AN, uwanvga, verbTense, partofspeechc)
        println "conjugation is; " + conj(PrefixTableSubject.DL1INCL, PrefixTableObject.SG3AN, uwanvga, verbTense, partofspeechc)
        println "conjugation is; " + conj(PrefixTableSubject.DL1EXCL, PrefixTableObject.SG3AN, uwanvga, verbTense, partofspeechc)
        println "conjugation is; " + conj(PrefixTableSubject.PL1INCL, PrefixTableObject.SG3AN, uwanvga, verbTense, partofspeechc)
        println "conjugation is; " + conj(PrefixTableSubject.PL1EXCL, PrefixTableObject.SG3AN, uwanvga, verbTense, partofspeechc)
        println "conjugation is; " + conj(PrefixTableSubject.DL2, PrefixTableObject.SG3AN, uwanvga, verbTense, partofspeechc)
        println "conjugation is; " + conj(PrefixTableSubject.PL2, PrefixTableObject.SG3AN, uwanvga, verbTense, partofspeechc)
        println "conjugation is; " + conj(PrefixTableSubject.PL3, PrefixTableObject.SG3AN, uwanvga, verbTense, partofspeechc)

        //are these mistakes in the table?  DL2INCL, DL2EXCL, PL2INCL, PL2EXCL, DL3... - where did I pull these from - DF Tables?
//        "conjugation is; " + conj(PrefixTableSubject.DL2INCL, PrefixTableObject.SG3AN, uwanvga, verbTense, partofspeechc)
//        "conjugation is; " + conj(PrefixTableSubject.DL2EXCL, PrefixTableObject.SG3AN, uwanvga, verbTense, partofspeechc)
//        "conjugation is; " + conj(PrefixTableSubject.PL2INCL, PrefixTableObject.SG3AN, uwanvga, verbTense, partofspeechc)
//        "conjugation is; " + conj(PrefixTableSubject.PL2EXCL, PrefixTableObject.SG3AN, uwanvga, verbTense, partofspeechc)
//        "conjugation is; " + conj(PrefixTableSubject.DL3INCL, PrefixTableObject.SG3AN, uwanvga, verbTense, partofspeechc)
//        "conjugation is; " + conj(PrefixTableSubject.DL3EXCL, PrefixTableObject.SG3AN, uwanvga, verbTense, partofspeechc)
//        "conjugation is; " + conj(PrefixTableSubject.PL3INCL, PrefixTableObject.SG3AN, uwanvga, verbTense, partofspeechc)
//        "conjugation is; " + conj(PrefixTableSubject.PL3EXCL, PrefixTableObject.SG3AN, uwanvga, verbTense, partofspeechc)

        println "conjugation is; " + conj(PrefixTableSubject.DL2, PrefixTableObject.SG3AN, uwanvga, verbTense, partofspeechc)
    }
}