package cherokee.dictionary.affixes.prefixes.verb.initialprefixes

import cherokee.conjugation.constants.Tense
import cherokee.conjugation.util.StringUtility
import cherokee.dictionary.affixes.Affix
import cherokee.dictionary.word.Verb

class PrefixI implements Affix {
    String i;


    String toSyllabary(String baseReturnValue, Verb word) {
        if (word.initialPrefix.i) {
            def de = word.initialPrefix.de
            def verbTense = word.tense

            String data = word.pronounPrefixSyllabary + word.verbRootSyllabary
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
        }

        return baseReturnValue;
    }


    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return i
    }
}
