package net.cherokeedictionary.verb.affixes.suffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.SuffixResult

/**
 * Position 14 / 15 (Feeling 1975, Figure 1, grammar guide p. 282):
 * the vowel-finalization suffix "-svi" / "-si" after nasal stems.
 *
 * From VRB-RECONCILIATION-MANIFEST.txt notes:
 *   "si and svi are not endings but vi after ni is svi and isi after ni is si"
 *
 * The sv(i)/si suffix appears when combining with certain stem types
 * (particularly those ending in nasals). See comment in FinalSuffixProcessor
 * line 118-119 regarding this pattern.
 *
 * KNOWN-GAP(NONFINAL-SI-SVI): Pattern requires more investigation into
 * the exact conditioning environment (nasal + ? -> svi vs si).
 */
class SuffixSvi implements Affix {
    String svi = "ᏍᎢ"

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        if (!baseReturnValue) {
            return baseReturnValue
        }

        // Apply svi after nasal-final stems (ni -> nvi -> svi)
        // Guard against double-applying if already ends with svi/si
        if (baseReturnValue.endsWith("ᏍᎢ") || baseReturnValue.endsWith("Ꮝ")) {
            return baseReturnValue
        }

        // For now, append svi unconditionally - refine based on testing
        return baseReturnValue + svi
    }

    /**
     * DECONSTRUCTION METHOD - Reverses toSyllabary
     */
    SuffixResult deconstructFromSyllabary(String fullWord, Verb word) {
        SuffixResult result = new SuffixResult()
        
        if (!fullWord || fullWord.trim().isEmpty()) {
            result.result = fullWord
            result.suffixRemoved = false
            result.detectedSuffix = null
            result.type = null
            return result
        }

        // Check for ᏍᎢ (vowel-finalization after nasal stems)
        if (!fullWord.endsWith("ᏍᎢ")) {
            result.result = fullWord
            result.suffixRemoved = false
            result.detectedSuffix = null
            result.type = null
            return result
        }

        String stem = fullWord.length() > 2 ? fullWord.substring(0, fullWord.length() - 2) : ""
        
        if (stem.isEmpty()) {
            result.result = fullWord
            result.suffixRemoved = false
            result.detectedSuffix = null
            result.type = null
            return result
        }

        result.result = stem
        result.suffixRemoved = true
        result.detectedSuffix = "ᏍᎢ"
        result.type = "VOWEL_FINALIZATION_NASAL"
        return result
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return svi
    }
}
