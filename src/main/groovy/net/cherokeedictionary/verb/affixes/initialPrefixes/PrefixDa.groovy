package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.verb.affixes.Affix

/**
 * Grammar Guide pp. 247-248 (61-62):
 *  - da- + consonant-initial base: prepend Ꮣ (da + jigowhtiha -> ᏓᏥᎪᏩᏘᎭ)
 *  - da- + h-initial base: contracts to t- (da + higowhtiha -> ᏘᎪᏩᏘᎭ)
 *  - da- + vowel-initial base: merges with the vowel via the D-map
 * PrefixDe runs after this prefix and prepends Ꮩ before da- (rule 62).
 */
class PrefixDa implements Affix {
    String da;

    String toString() {
        return da
    }

    String toSyllabary(String baseReturnValue, Verb word) {
        // C8: restored from the commented logic (Grammar Guide pp. 247-248, rules 61-62):
        //  - da- + h-initial base contracts to t- (da + higowhtiha -> ᏘᎪᏩᏘᎭ)
        //  - da- + vowel-initial base merges with the vowel (da + a -> dv via Ꮫ)
        //  - da- + consonant-initial base: prepend Ꮣ
        // PrefixDe runs after this prefix and prepends Ꮩ before da- (rule 62).
        if (word.initialPrefixHolder.da) {
            baseReturnValue = baseReturnValue ?: word.pronounReflexiveRoot

            if (baseReturnValue) {
                def charAtZero = baseReturnValue.charAt(0)

                if (['Ꭽ', 'Ꭾ', 'Ꭿ', 'Ꮀ', 'Ꮁ', 'Ꮂ'].contains(String.valueOf(charAtZero))) {
                    // da- + h- contracts to t-: the d and h merge and the a drops
                    baseReturnValue = "Ꮨ" + baseReturnValue.substring(1)
                } else if (StringUtility.startsWithVowelSyllabary(baseReturnValue)) {
                    // tio 12Nov26: future da- allomorphy, book-verified:
                    //  - da + a- -> dv (Ꮫ): guide ex. 63a ᏛᏟ dvtli "he/it's
                    //    coming this way", To Hear p.64 SG3 future ᏛᏛᎦᏂ
                    //    dvtvgani, To Fall p.33 PL3 ᏙᏛᏂᏅᏥ (do+dv+ni), To Hit
                    //    p.81 ex.7 ᏙᏛᏅᏂᎵ. Was Ꮣ (a-drop) — wrong for these.
                    //  - da + i- -> the i deletes (Ꮣ): To Fall p.33 PL2
                    //    ᏙᏓᏥᏅᏥ (da+tsi), DL1INCL ᏙᏓᏂᏅᏥ (da+ni), PL1INCL
                    //    ᏙᏓᏗᏅᏥ (da+di). Was Ꮧ (di-merge).
                    //  - da + o- -> dayo- (y-epenthesis): To Fall p.33
                    //    DL1EXCL ᏙᏓᏲᏍᏗᏅᏥ (da+yo+sdi), PL1EXCL ᏙᏓᏲᏥᏅᏥ. Two
                    //    glyphs, so handled outside the single-glyph map.
                    //  - u keeps du (Ꮪ — the du-verb path re-fuses ᎤᎸ... to
                    //    ᏚᎸ...) and e keeps de (Ꮥ): no book counter-evidence.
                    if (charAtZero == 'Ꭳ') {
                        baseReturnValue = "ᏓᏲ" + baseReturnValue.substring(1)
                    } else {
                        baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮫ', 'Ꮥ', 'Ꮣ', 'Ꮩ', 'Ꮪ', 'Ꮫ'])
                    }
                } else {
                    baseReturnValue = "Ꮣ" + baseReturnValue
                }
            }
        }

        return baseReturnValue
    }

    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }
}
