package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.verb.affixes.Affix

class PrefixYi implements Affix {
    String yi;

    String toSyllabary(String baseReturnValue, Verb word) {
        String data = word.pronounReflexiveRoot
        baseReturnValue = baseReturnValue ?: data

        if (!word.initialPrefixHolder.ji) {
            def latin = SyllabaryUtil.parseSyllabary(baseReturnValue)
            def startsWithH = latin.startsWith('h')
            if (startsWithH) {
                latin = latin.substring(1)
                baseReturnValue = SyllabaryUtil.tsalagiToSyllabary(latin)
            }

            def charAtZero = baseReturnValue.charAt(0)

            if (StringUtility.startsWithVowelSyllabary(baseReturnValue)) {
                baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮿ', 'Ᏸ', 'Ᏹ', 'Ᏺ', 'Ᏻ', 'Ᏼ'])
            } else {
                if (charAtZero == 'Ꮹ'
                        || charAtZero == 'Ꮺ'
                        || charAtZero == 'Ꮻ'
                        || charAtZero == 'Ꮼ'
                        || charAtZero == 'Ꮽ'
                        || charAtZero == 'Ꮾ') {
                    baseReturnValue = "Ᏻ" + baseReturnValue
                    // tio 12Nov26: WI-28B — guide ex. 28b: after the negative yu-,
                    // the wi- element may be DELETED (ᏳᎦᏬᏂᎭ alongside ᏳᏫᎦᏬᏂᎭ).
                    // Only the plain Ꮻ glyph (wi- before consonants) qualifies, and
                    // only when wi- was actually applied (a stem-initial ᏫᏬ... must
                    // never be deleted). Canonical wholeWord stays the full form
                    // (28a); the optional deletion is recorded as variantWord.
                    if (word.initialPrefixHolder?.wi && charAtZero == 'Ꮻ') {
                        word.variantWord = "Ᏻ" + baseReturnValue.substring(2)
                    }
                } else {
                    baseReturnValue = "Ᏹ" + baseReturnValue
                }
            }
        }

        return baseReturnValue;
    }

    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return yi
    }
}
