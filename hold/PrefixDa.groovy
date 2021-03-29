package net.cherokeedcitionary.verbal.initialprefixes

import net.cherokeedcitionary.core.Verb
import net.cherokeedcitionary.verbal.Affix


class PrefixDa implements Affix {
    String da;

    String toString() {
        return da
    }

    String toSyllabary(String baseReturnValue, Verb word) {
        if (word.initialPrefix.da) {
            def data = word.pronounPrefixSyllabary + word.rootSyllabary
            baseReturnValue = baseReturnValue ?: data
//            def charAtZero = baseReturnValue.charAt(0)
//            def isVowelBeginning = StringUtility.startsWithVowelSyllabary(baseReturnValue)

            println "here"

            if (data.startsWith("Ꭰ")) {//da + a = dv
                baseReturnValue = "Ꮫ" + baseReturnValue.substring(1);
            } else {
                baseReturnValue = "Ꮣ" + baseReturnValue
            }
        }

        return baseReturnValue
    }

    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }
}
