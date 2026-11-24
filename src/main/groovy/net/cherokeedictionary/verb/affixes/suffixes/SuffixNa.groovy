package net.cherokeedictionary.verb.affixes.suffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.affixes.SuffixResult

class SuffixNa implements Affix {
    String suffix = "Ꮎ"

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

        // Check for Ꮎ (often used in noun-like verb forms or nominalizations)
        if (!fullWord.endsWith("Ꮎ")) {
            result.result = fullWord
            result.suffixRemoved = false
            result.detectedSuffix = null
            result.type = null
            return result
        }

        String stem = fullWord.length() > 1 ? fullWord.substring(0, fullWord.length() - 1) : ""
        
        if (stem.isEmpty()) {
            result.result = fullWord
            result.suffixRemoved = false
            result.detectedSuffix = null
            result.type = null
            return result
        }

        result.result = stem
        result.suffixRemoved = true
        result.detectedSuffix = "Ꮎ"
        result.type = "NOMINALIZER"
        return result
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return na
    }
}
