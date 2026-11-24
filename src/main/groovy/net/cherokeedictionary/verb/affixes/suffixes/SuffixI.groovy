package net.cherokeedictionary.verb.affixes.suffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.affixes.SuffixResult

class SuffixI implements Affix {
    String suffix = "Ꭲ"

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

        // Check if word ends with habitual marker Ꭲ
        if (!fullWord.endsWith("Ꭲ")) {
            result.result = fullWord
            result.suffixRemoved = false
            result.detectedSuffix = null
            result.type = null
            return result
        }

        // Remove the final syllable
        String stem = fullWord.length() > 1 ? fullWord.substring(0, fullWord.length() - 1) : ""
        
        // Ensure we don't remove too much (keep at least one character)
        if (stem.isEmpty() || stem.length() < 1) {
            result.result = fullWord
            result.suffixRemoved = false
            result.detectedSuffix = null
            result.type = null
            return result
        }

        result.result = stem
        result.suffixRemoved = true
        result.detectedSuffix = "Ꭲ"
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
