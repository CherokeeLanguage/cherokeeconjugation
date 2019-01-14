package cherokee.dictionary.conjugation.affixes.prefixes

import cherokee.dictionary.conjugation.affixes.Affix
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.util.StringUtility
import cherokee.dictionary.conjugation.wordFormation.Word

class PrefixDi implements Affix {
    String di;

    @Override
    String toSyllabary(String baseReturnValue, Word word) {
        def verbTense = word.tense
        String data = word.pronounPrefix.syllabary + word.rootSyllabary
        baseReturnValue = baseReturnValue ?: data

        def charAtZero = baseReturnValue.charAt(0)
        def isVowelBeginning = StringUtility.startsWithVowelSyllabary(baseReturnValue)

        if (verbTense == Tense.REMOTE_PAST) {
            if (isVowelBeginning) {
                baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['', 'Ᏸ', 'Ᏹ', 'Ᏺ', 'Ᏻ', 'Ᏼ'])
            } /*else {
                baseReturnValue =  "Ꮣ" + (baseReturnValue != '' ? baseReturnValue : data);
            }*/

            baseReturnValue =  "Ꮣ" + baseReturnValue
        } else {
            if (isVowelBeginning) {
                baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮧ', 'Ꮴ', 'Ꮧ', 'Ꮶ', 'Ꮷ', 'Ꮸ'])
            } else {
                baseReturnValue =  "Ꮧ" + baseReturnValue
            }
        }

        return baseReturnValue;
    }

    @Override
    String toEnglish(String baseReturnValue, Word word) {
        return null
    }

    String toString() {
        return di
    }
}
