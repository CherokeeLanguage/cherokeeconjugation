package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.Affix

class PrefixJi implements Affix {
    String ji;

    String toSyllabary(String baseReturnValue, Verb word) {
        // tio 12Nov26: WI-31 — in the imperative tenses the hortative ji- is
        // carried by the pronominal itself (SG1 = Ꮵ-): the guide prints a
        // SINGLE Ꮵ (ex. 31a ᏥᏬᏂᎯ "let me speak") and wi- OUTSIDE it (ex. 31b
        // ᏫᏥᏬᏂᎯ), so no separate initial ji- is applied there. The PRESENT
        // ji- ("still", Durbin pp 242-244, pinned by JiVerbTest ᏥᏥᏬᏂᎭ) is a
        // different morpheme and keeps stacking. RECHECK: if a source attests
        // an imperative-tense initial ji-, gate this no-op by person, not
        // tense.
        if (word.tense == Tense.IMMEDIATE_COMMAND || word.tense == Tense.RECENT_PAST_IMPERATIVE) {
            return baseReturnValue
        }
        String data = word.pronounReflexiveRoot
        baseReturnValue = baseReturnValue ?: data
        def latin = SyllabaryUtil.parseSyllabary(baseReturnValue)

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

        return baseReturnValue
    }

    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return ji
    }
}
