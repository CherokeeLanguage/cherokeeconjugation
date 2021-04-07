package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.Affix

class PrefixI implements Affix {
    String i;

    String toSyllabary(String baseReturnValue, Verb word) {
        if (word.initialPrefixHolder.i) {
            def de = word.initialPrefixHolder.de
            def verbTense = word.tense

            String data = word.pronounReflexiveRoot
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
