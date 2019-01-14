package cherokee.dictionary.conjugation.affixes.prefixes

import cherokee.dictionary.conjugation.affixes.Affix
import cherokee.dictionary.conjugation.util.StringUtility
import cherokee.dictionary.conjugation.wordFormation.Word

class PrefixDa implements Affix {
    String da;

    String toString() {
        return da
    }

    @Override
    String toSyllabary(String baseReturnValue, Word word) {
        def data = word.pronounPrefix.syllabary + word.rootSyllabary
        baseReturnValue = baseReturnValue ?: data
        def charAtZero = baseReturnValue.charAt(0)
        def isVowelBeginning = StringUtility.startsWithVowelSyllabary(baseReturnValue)

        if (data.startsWith("Ꭰ")) {//da + a = dv
            baseReturnValue = "Ꮫ" + baseReturnValue.substring(1);
        } else {
            return baseReturnValue = "Ꮣ" + baseReturnValue
        }
    }

    @Override
    String toEnglish(String baseReturnValue, Word word) {
        return null
    }
}
