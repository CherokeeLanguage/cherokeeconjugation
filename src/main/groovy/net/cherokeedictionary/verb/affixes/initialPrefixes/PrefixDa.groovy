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
                    // da- merges with a vowel-initial base (da + a -> dv, da + i -> di, ...)
                    baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮣ', 'Ꮥ', 'Ꮧ', 'Ꮩ', 'Ꮪ', 'Ꮫ'])
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
