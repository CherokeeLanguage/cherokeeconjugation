package cherokee.old.affixes.prefixes.verb.initialPrefixes

import cherokee.dictionary.affixes.Affix
import cherokee.dictionary.utils.StringUtility
import cherokee.dictionary.word.Word
import com.cobradoc.cherokee.SyllabaryUtil

class PrefixJi implements Affix {
    String ji;

    String toSyllabary(String baseReturnValue, Word word) {
        if (word.initialPrefix.ji) {
            String data = word.pronounPrefixSyllabary + word.verbRootSyllabary
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
            if (word.initialPrefix.yi || word.initialPrefix.ga) {
                if (isVowelBeginning) {
                    baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮎ', 'Ꮑ', 'Ꮒ', 'Ꮓ', 'Ꮔ', 'Ꮕ'])
                } else {
                    baseReturnValue = (word.initialPrefix.yi ? "Ꮒ" : "") + baseReturnValue + (word.initialPrefix.yi ? "Ꮎ" : "") + " ᏥᎩ";
                }
            } else {
                if (isVowelBeginning) {
                    baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮳ', 'Ꮴ', 'Ꮵ', 'Ꮶ', 'Ꮷ', 'Ꮸ'])
                } else {
                    if (charAtZero == 'Ꮹ' || charAtZero == 'Ꮺ' || charAtZero == 'Ꮻ' || charAtZero == 'Ꮼ' || charAtZero == 'Ꮽ' || charAtZero == 'Ꮾ') {
                        baseReturnValue = "Ꮸ" + baseReturnValue
                    } else {
                        baseReturnValue = "Ꮵ" + baseReturnValue
                    }
                }
            }
        }

        return baseReturnValue
    }


    String toEnglish(String baseReturnValue, Word word) {
        return null
    }

    String toString() {
        return ji
    }
}
