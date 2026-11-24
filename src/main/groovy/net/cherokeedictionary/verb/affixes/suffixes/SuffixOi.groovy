package net.cherokeedictionary.verb.affixes.suffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.affixes.SuffixResult

/**
 * Habitual Suffixes: -oi / -sgo'i
 * Indicates a habitual action (doing something generally or regularly).
 * 
 * Rules:
 * - Usually appends -oi or -sgoi to the stem.
 */
class SuffixOi implements Affix {
    String suffix = "ᎣᎢ"

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        return baseReturnValue.endsWith(suffix) ? baseReturnValue : baseReturnValue + suffix
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

        // Check for ᎣᎢ (habitual marker)
        if (!fullWord.endsWith("ᎣᎢ")) {
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
        result.detectedSuffix = "ᎣᎢ"
        result.type = "HABITUAL_ASPECT"
        return result
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return suffix
    }
}
