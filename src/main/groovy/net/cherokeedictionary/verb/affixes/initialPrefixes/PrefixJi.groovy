package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.verb.affixes.Affix

class PrefixJi implements Affix {
    String ji;

    String toSyllabary(String baseReturnValue, Verb word) {
        if (word.initialPrefixHolder.ji) {
            String data = word.pronounReflexiveRoot
            baseReturnValue = baseReturnValue ?: data
            def latin = new SyllabaryUtil().parseSyllabary(baseReturnValue)

            //check for past tense word.tense =
            //j- cannot be used when reportative past tense suffix ei is used
            // since that tense hasn't been implemented yet - we're just going to check for ei
            if (latin.endsWith("ei")) {
                return baseReturnValue
            }

            def charAtZero = baseReturnValue.charAt(0)
            boolean isVowelBeginning = StringUtility.startsWithVowelSyllabary(baseReturnValue)

            //if yi -add n- or ni- then "-na jigi" unless it's ga- then ga- jigi
            if (word.initialPrefixHolder.yi || word.initialPrefixHolder.ga) {
                if (isVowelBeginning) {
                    baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮎ', 'Ꮑ', 'Ꮒ', 'Ꮓ', 'Ꮔ', 'Ꮕ'])
                } else {
                    baseReturnValue = (word.initialPrefixHolder.yi ? "Ꮒ" : "") + baseReturnValue + (word.initialPrefixHolder.yi ? "Ꮎ" : "") + " ᏥᎩ";
                }
            } else {
                if (isVowelBeginning) {
                    baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮳ', 'Ꮴ', 'Ꮵ', 'Ꮶ', 'Ꮷ', 'Ꮸ'])
                } else {
                    if (charAtZero == 'Ꮹ'
                        || charAtZero == 'Ꮺ'
                        || charAtZero == 'Ꮻ'
                        || charAtZero == 'Ꮼ'
                        || charAtZero == 'Ꮽ'
                        || charAtZero == 'Ꮾ') {
                        baseReturnValue = "Ꮸ" + baseReturnValue
                    } else {
                        baseReturnValue = "Ꮵ" + baseReturnValue
                    }
                }
            }
        }

        return baseReturnValue
    }

    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return ji
    }
}
