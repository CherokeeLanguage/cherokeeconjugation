package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix

class PrefixDa implements Affix {
    String da;

    String toString() {
        return da
    }

    String toSyllabary(String baseReturnValue, Verb word) {
//        if (word.initialPrefix.da) {
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
//        }
    }

    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }
}
