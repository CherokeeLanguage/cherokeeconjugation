package cherokee.dictionary.conjugation.hold
/**
 * test the /d-/ /w-/ and /n-/ prefixes
 *
 * todo: fix so that the prefixes are getting through to the conjugation process and then preserved
 *
 * Created by torr on 10/21/2015.
 */

class WNDPrefixTest extends WNDPrefixBase {
    private void printAll(partofspeechc, verbTense, verb) {
        println conj("SG1", "SG3AN", verb, verbTense, partofspeechc)
        println conj("SG2", "SG3AN", verb, verbTense, partofspeechc)
        println conj("SG3", "SG3AN", verb, verbTense, partofspeechc)
        println conj("DL1INCL", "SG3AN", verb, verbTense, partofspeechc)
        println conj("DL1EXCL", "SG3AN", verb, verbTense, partofspeechc)
        println conj("DL2", "SG3AN", verb, verbTense, partofspeechc)
        println conj("PL1INCL", "SG3AN", verb, verbTense, partofspeechc)
        println conj("PL1EXCL", "SG3AN", verb, verbTense, partofspeechc)
        println conj("PL2", "SG3AN", verb, verbTense, partofspeechc)
        println conj("PL3", "SG3AN", verb, verbTense, partofspeechc)
        println conj("SG1", "PL3AN", verb, verbTense, partofspeechc)
        println conj("SG2", "PL3AN", verb, verbTense, partofspeechc)
        println conj("SG3", "PL3AN", verb, verbTense, partofspeechc)
        println conj("DL1INCL", "PL3AN", verb, verbTense, partofspeechc)
        println conj("DL1EXCL", "PL3AN", verb, verbTense, partofspeechc)
        println conj("DL2", "PL3AN", verb, verbTense, partofspeechc)
        println conj("PL1INCL", "PL3AN", verb, verbTense, partofspeechc)
        println conj("PL1EXCL", "PL3AN", verb, verbTense, partofspeechc)
        println conj("PL2", "PL3AN", verb, verbTense, partofspeechc)
        println conj("PL3", "PL3AN", verb, verbTense, partofspeechc)
    }
    
    public void testMyTest() {
        def partofspeechc = "v.t."
        def verbTense = "PRESENT"

//        dadanilvga.habitual = new DefinitionLine ( syllabary: "ᏓᏓᏂᎸᎪᎢ" )
//        dadanilvga.imperative = new DefinitionLine ( syllabary: "ᏘᏯᏓᏂᎸᎩ" )
//        dadanilvga.infinitive = new DefinitionLine ( syllabary: "ᏧᏓᏂᎸᏍᏗ" )
//        dadanilvga.present1st = new DefinitionLine ( syllabary: "ᏕᏥᏯᏓᏂᎸᎦ" )
//        dadanilvga.present3rd = new DefinitionLine ( syllabary: "ᏓᏓᏂᎸᎦ" )
//        dadanilvga.remotepast = new DefinitionLine ( syllabary: "ᏚᏓᏂᎸᏨᎢ" )
//        printAll(partofspeechc, verbTense, dadanilvga)

        def conjugated = conj("SG1", "SG3AN", WNDPrefixBase.dadanilvga, verbTense, partofspeechc)

        //todo: take this code and when the verb is finished conjugating
        //      check the first syllable
        //      find the prefix of the root word
        //      add that prefix back onto the conjugated verb
        def wndPrefix = null;

        def verbToCheck = WNDPrefixBase.dadanilvga.present1st.syllabary;
        println verbToCheck

        if (verbToCheck.startsWith("Ꮣ")
                || verbToCheck.startsWith("Ꮥ")
                || verbToCheck.startsWith("Ꮧ")
                || verbToCheck.startsWith("Ꮩ")
                || verbToCheck.startsWith("Ꮪ")
                || verbToCheck.startsWith("Ꮫ")) {
//            wndPrefix = verbToCheck.charAt(0)
//            def tmp = verbToCheck.substring(1)

                wndPrefix = verbToCheck.charAt(0)
//            switch (verbToCheck.charAt(0)) {
//                case "Ꮣ":
////                    verbToCheck = "Ꭰ${tmp}"
//                    break;
//                case "Ꮥ":
////                    verbToCheck = "Ꭱ${tmp}"
//                    break;
//                case "Ꮧ":
////                    verbToCheck = "Ꭲ${tmp}"
//                    break;
//                case "Ꮩ":
////                    verbToCheck = "Ꭲ${tmp}"
//                    break;
//                case "Ꮪ":
//
////                    verbToCheck = "Ꭴ${tmp}"
//                    break;
//                case "Ꮫ":
////                    verbToCheck = "Ꭵ${tmp}"
//                    break;
//            }

            println "${wndPrefix}${conjugated}"
        }
    }
}