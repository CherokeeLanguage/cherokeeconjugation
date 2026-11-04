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
//        if (word.initialPrefix.da) {
//            def data = word.pronounPrefixSyllabary + word.rootSyllabary
//            baseReturnValue = baseReturnValue ?: data
//            def charAtZero = baseReturnValue.charAt(0)
//            def isVowelBeginning = StringUtility.startsWithVowelSyllabary(baseReturnValue)
//
//            if (data.startsWith("Ꭰ")) {//da + a = dv
//                baseReturnValue = "Ꮫ" + baseReturnValue.substring(1);
//            } else {
//                return baseReturnValue = "Ꮣ" + baseReturnValue
//            }
//        }
/*
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
*/
        return baseReturnValue
    }

    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }
}
