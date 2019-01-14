package cherokee.dictionary.conjugation.affixes.prefixes

import cherokee.dictionary.conjugation.affixes.Affix
import cherokee.dictionary.conjugation.conjugate.Tense
import cherokee.dictionary.conjugation.util.StringUtility
import cherokee.dictionary.conjugation.wordFormation.Word

class PrefixI implements Affix {
    String i;

    @Override
    String toSyllabary(String baseReturnValue, Word word) {
        def de = word.prefixHolderObject.de
        def verbTense = word.tense

        String data = word.pronounPrefix.syllabary + word.rootSyllabary
        baseReturnValue = baseReturnValue ?: data

        def charAtZero = baseReturnValue.charAt(0)

        if (StringUtility.startsWithVowelSyllabary(baseReturnValue)) {
            baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꭲ', 'Ꭲ', 'Ꭲ', 'Ꭲ', 'Ꭲ', 'Ꭲ'])
        } else {
            if (de) {
                baseReturnValue = 'Ꮩ' + baseReturnValue
            } else if (charAtZero == 'Ꭶ' || verbTense == Tense.REMOTE_PAST) {
                baseReturnValue = 'Ꭵ' + baseReturnValue
            } else {
                baseReturnValue = 'Ꭲ' + baseReturnValue
            }
        }

        return baseReturnValue;
    }

    @Override
    String toEnglish(String baseReturnValue, Word word) {
        return null
    }

    String toString() {
        return i
    }
}
