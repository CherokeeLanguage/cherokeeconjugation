package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.verb.affixes.Affix

/**
 * since -- pp 255 & 256 Durbin Feeling Dictionary
 */
class PrefixGa implements Affix {
    String ga

    String toSyllabary(String baseReturnValue, Verb word) {
        if (word.initialPrefixHolder.ga) {
            String data = word.pronounReflexiveRoot
            baseReturnValue = baseReturnValue ?: data

            def charAtZero = baseReturnValue.charAt(0)

            if (word.subject == PrefixTableSubject.SG2) {
                baseReturnValue = "Ꭸ" + baseReturnValue
            } else if (word.subject == PrefixTableSubject.SG3) {
                baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['ᎬᏩ', 'ᎬᏪ', 'ᎬᏫ', 'ᎬᏬ', 'ᎬᏩ', 'ᎬᏮ'])
            } else if (StringUtility.startsWithVowelSyllabary(baseReturnValue)) {
                baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꭼ', 'ᎦᏰ', 'ᎦᏱ', 'ᎦᏲ', 'ᎦᏳ', 'ᎦᏴ'])
            } else {
                baseReturnValue = 'Ꭶ' + baseReturnValue
            }
        }

        return baseReturnValue
    }

    String toEnglish(String baseReturnValue, Verb Word) {
        return null
    }

    String toString() {
        return ga
    }


}
