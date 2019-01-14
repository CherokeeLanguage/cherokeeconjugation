package cherokee.dictionary.conjugation.affixes.prefixes

import cherokee.dictionary.conjugation.affixes.Affix
import cherokee.dictionary.conjugation.util.StringUtility
import cherokee.dictionary.conjugation.wordFormation.Word

class PrefixGa implements Affix {
    String ga;

    @Override
    String toSyllabary(String baseReturnValue, Word word) {
        String data = word.pronounPrefix.syllabary + word.rootSyllabary
        baseReturnValue = baseReturnValue ?: data

        def charAtZero = baseReturnValue.charAt(0)

        if (StringUtility.startsWithVowelSyllabary(baseReturnValue)) {
            baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꭼ', 'ᎦᏰ', 'ᎦᏱ', 'ᎦᏲ', 'ᎦᏳ', 'ᎦᏴ'])
        } else {
            baseReturnValue =  'Ꭶ' + baseReturnValue;
        }

        return baseReturnValue;
    }

    @Override
    String toEnglish(String baseReturnValue, Word Word) {
        return null
    }

    String toString() {
        return ga
    }


}
