package cherokee.dictionary.affixes.prefixes.verb.initialprefixes

import cherokee.dictionary.affixes.Affix
import cherokee.dictionary.utils.StringUtility
import cherokee.dictionary.verb.conjugation.originalconjugation.Tense
import cherokee.dictionary.word.Verb

class PrefixDi implements Affix {
    String di;


    String toSyllabary(String baseReturnValue, Verb word) {
        if (word.initialPrefix.di) {
            def verbTense = word.tense
            String data = word.pronounPrefixSyllabary + word.verbRootSyllabary
            baseReturnValue = baseReturnValue ?: data

            def charAtZero = baseReturnValue.charAt(0)
            def isVowelBeginning = StringUtility.startsWithVowelSyllabary(baseReturnValue)

            if (verbTense == Tense.REMOTE_PAST) {
                if (isVowelBeginning) {
                    baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['', 'Ᏸ', 'Ᏹ', 'Ᏺ', 'Ᏻ', 'Ᏼ'])
                } /*else {
                baseReturnValue =  "Ꮣ" + (baseReturnValue != '' ? baseReturnValue : data);
            }*/

                baseReturnValue = "Ꮣ" + baseReturnValue
            } else {
                if (isVowelBeginning) {
                    baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮧ', 'Ꮴ', 'Ꮧ', 'Ꮶ', 'Ꮷ', 'Ꮸ'])
                } else {
                    baseReturnValue = "Ꮧ" + baseReturnValue
                }
            }
        }

        return baseReturnValue;
    }


    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return di
    }
}