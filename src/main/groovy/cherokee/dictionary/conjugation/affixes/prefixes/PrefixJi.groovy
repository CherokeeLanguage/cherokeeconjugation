package cherokee.dictionary.conjugation.affixes.prefixes

import cherokee.dictionary.conjugation.affixes.Affix
import cherokee.dictionary.conjugation.util.StringUtility
import cherokee.dictionary.conjugation.wordFormation.Word
import com.cobradoc.cherokee.SyllabaryUtil

class PrefixJi implements Affix {
    String ji;

    @Override
    String toSyllabary(String baseReturnValue, Word word) {
        String data = word.pronounPrefix.syllabary + word.rootSyllabary
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
        if (word.prefixHolderObject.yi || word.prefixHolderObject.ga) {
            if (isVowelBeginning) {
                baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮎ', 'Ꮑ', 'Ꮒ', 'Ꮓ', 'Ꮔ', 'Ꮕ'])
            } else {
                baseReturnValue = (word.prefixHolderObject.yi ? "Ꮒ" : "") + baseReturnValue + (word.prefixHolderObject.yi ? "Ꮎ" : "") + " ᏥᎩ";
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

        return baseReturnValue
    }

    @Override
    String toEnglish(String baseReturnValue, Word word) {
        return null
    }

    String toString() {
        return ji
    }
}
