package cherokee.dictionary.affixes.prefixes.verb.initialprefixes

import cherokee.conjugation.util.StringUtility
import cherokee.conjugation.verbal.containers.VerbPrefixTableSubject
import cherokee.dictionary.affixes.Affix
import cherokee.conjugation.verbal.Verb

/**
 * since -- pp 255 & 256 Durbin Feeling Dictionary
 */
class PrefixGa implements Affix {
    String ga

    String toSyllabary(String baseReturnValue, Verb word) {
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

    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return ga
    }


}
