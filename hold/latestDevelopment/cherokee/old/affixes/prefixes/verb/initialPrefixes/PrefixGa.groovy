package cherokee.old.affixes.prefixes.verb.initialPrefixes

import cherokee.dictionary.affixes.Affix
import cherokee.dictionary.affixes.prefixes.verb.VerbPrefixTableSubject
import cherokee.dictionary.utils.StringUtility
import cherokee.dictionary.word.Word

/**
 * since -- pp 255 & 256 Durbin Feeling Dictionary
 */
class PrefixGa implements Affix {
    String ga

    String toSyllabary(String baseReturnValue, Word word) {
        if (word.initialPrefix.ga) {
            String data = word.pronounPrefixSyllabary + word.verbRootSyllabary
            baseReturnValue = baseReturnValue ?: data

            def charAtZero = baseReturnValue.charAt(0)

            if (word.verbSubject == VerbPrefixTableSubject.SG2) {
                baseReturnValue = "Ꭸ" + baseReturnValue
            } else if (word.verbSubject == VerbPrefixTableSubject.SG3) {
                baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['ᎬᏩ', 'ᎬᏪ', 'ᎬᏫ', 'ᎬᏬ', 'ᎬᏩ', 'ᎬᏮ'])
            } else if (StringUtility.startsWithVowelSyllabary(baseReturnValue)) {
                baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꭼ', 'ᎦᏰ', 'ᎦᏱ', 'ᎦᏲ', 'ᎦᏳ', 'ᎦᏴ'])
            } else {
                baseReturnValue = 'Ꭶ' + baseReturnValue
            }
        }

        return baseReturnValue
    }

    String toEnglish(String baseReturnValue, Word Word) {
        return null
    }

    String toString() {
        return ga
    }


}
