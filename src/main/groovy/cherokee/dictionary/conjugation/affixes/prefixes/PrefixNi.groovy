package cherokee.dictionary.conjugation.affixes.prefixes

import cherokee.dictionary.conjugation.affixes.Affix
import cherokee.dictionary.conjugation.util.StringUtility
import cherokee.dictionary.conjugation.wordFormation.Word

class PrefixNi implements Affix {
    String Ni;

    @Override
    String toSyllabary(String baseReturnValue, Word word) {
        String data = word.pronounPrefix.syllabary + word.rootSyllabary
        baseReturnValue = baseReturnValue ?: data

        def charAtZero = baseReturnValue.charAt(0)

        if (StringUtility.startsWithVowelSyllabary(baseReturnValue)) {
            baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮎ', 'Ꮑ', 'Ꮒ', 'Ꮓ', 'Ꮔ', 'Ꮕ'])
        } else {
            baseReturnValue =  "Ꮒ" + baseReturnValue
        }

        return baseReturnValue;
    }

    @Override
    String toEnglish(String baseReturnValue, Word word) {
        return null
    }

    String toString() {
        return Ni
    }
}
