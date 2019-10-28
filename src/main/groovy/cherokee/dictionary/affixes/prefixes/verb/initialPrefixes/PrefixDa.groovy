package cherokee.dictionary.affixes.prefixes.verb.initialPrefixes

import cherokee.dictionary.affixes.Affix
import cherokee.dictionary.utils.StringUtility
import cherokee.dictionary.word.Word

class PrefixDa implements Affix {
    String da;

    String toString() {
        return da
    }

    String toSyllabary(String baseReturnValue, Word word) {
        if (word.initialPrefix.da) {
            def data = word.pronounPrefixSyllabary + word.rootSyllabary
            baseReturnValue = baseReturnValue ?: data
            def charAtZero = baseReturnValue.charAt(0)
            def isVowelBeginning = StringUtility.startsWithVowelSyllabary(baseReturnValue)

            if (data.startsWith("Ꭰ")) {//da + a = dv
                baseReturnValue = "Ꮫ" + baseReturnValue.substring(1);
            } else {
                return baseReturnValue = "Ꮣ" + baseReturnValue
            }
        }
    }

    String toEnglish(String baseReturnValue, Word word) {
        return null
    }
}
