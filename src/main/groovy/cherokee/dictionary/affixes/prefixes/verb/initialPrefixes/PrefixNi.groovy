package cherokee.dictionary.affixes.prefixes.verb.initialPrefixes

import cherokee.dictionary.affixes.Affix
import cherokee.dictionary.utils.StringUtility
import cherokee.dictionary.word.Word

class PrefixNi implements Affix {
    String Ni;


    String toSyllabary(String baseReturnValue, Word word) {
        if (word.initialPrefix.ni) {
            String data = word.pronounPrefixSyllabary + word.rootSyllabary
            baseReturnValue = baseReturnValue ?: data

            def charAtZero = baseReturnValue.charAt(0)

            if (StringUtility.startsWithVowelSyllabary(baseReturnValue)) {
                baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮎ', 'Ꮑ', 'Ꮒ', 'Ꮓ', 'Ꮔ', 'Ꮕ'])
            } else {
                baseReturnValue = "Ꮒ" + baseReturnValue
            }
        }

        return baseReturnValue;
    }


    String toEnglish(String baseReturnValue, Word word) {
        return null
    }

    String toString() {
        return Ni
    }
}
