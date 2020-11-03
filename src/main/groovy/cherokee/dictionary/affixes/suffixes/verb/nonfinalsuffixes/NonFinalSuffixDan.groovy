package cherokee.dictionary.affixes.suffixes.verb.nonfinalsuffixes

import cherokee.dictionary.affixes.Affix
import cherokee.dictionary.utils.StringUtility
import cherokee.dictionary.verb.conjugation.originalconjugation.Tense
import cherokee.dictionary.word.Verb

class NonFinalSuffixDan implements Affix {
    String dan;

    String toString() {
        return dan
    }

    String toSyllabary(String baseReturnValue, Verb word) {
        def nonFinalSuffix = ""

        if (word.nonFinalSuffix.dan) {
            //dan before vowels
            //dis before g
            //present tense dis before g = dih
            //dan plus di (inifinitive suffix) = dohdi
            //  dan before imperative -a = d

            def data = word.verbRootSuffixLatinPhonetic
            if (StringUtility.startsWithVowelLatin(data)) {
                if (word.tense == Tense.IMMEDIATE_COMMAND) {
                    nonFinalSuffix = 'd'
                } else {
                    nonFinalSuffix = 'dan'
                }
            } else {
                if (data.startsWith("g")) {
                    if (word.tense == Tense.PRESENT) {
                        nonFinalSuffix = "dih"
                        word.verbRootSuffixLatinPhonetic = data.substring(1)
                    } else {
                        nonFinalSuffix = "dis"
                    }
                } else if (data.startsWith("di")) {
                    nonFinalSuffix = "do"
                }
            }

//            def data = word.pronounPrefixSyllabary + word.rootSyllabary
//            baseReturnValue = baseReturnValue ?: data
//            def charAtZero = baseReturnValue.charAt(0)
//            def isVowelBeginning = StringUtility.startsWithVowelSyllabary(baseReturnValue)
//
//            if (data.startsWith("Ꭰ")) {//da + a = dv
//                baseReturnValue = "Ꮫ" + baseReturnValue.substring(1);
//            } else {
//                return baseReturnValue = "Ꮣ" + baseReturnValue
//            }
        }

        return nonFinalSuffix
    }

    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }
}
