package net.cherokeedictionary.verb.affixes.suffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.affixes.SuffixResult

/**
 * Infinitive Suffixes: -di / -sdi
 * Used to form the infinitive ("to [verb]").
 */
class SuffixDi implements Affix {
    String di = "Ꮧ"

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
    	// Simple append logic for infinitive
        if (!baseReturnValue.endsWith(di)) {
            return baseReturnValue + di
        }
        return baseReturnValue
        return null
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

        // Check for Ꮧ (infinitive marker)
        if (!fullWord.endsWith("Ꮧ")) {
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
        result.detectedSuffix = "Ꮧ"
        result.type = "INFINITIVE_MARKER"
        return result
    }

    String toString() {
        return di
    }
}
