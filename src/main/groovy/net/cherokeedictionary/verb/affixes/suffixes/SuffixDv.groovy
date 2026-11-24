package net.cherokeedictionary.verb.affixes.suffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.affixes.SuffixResult

/**
 * Completive Suffix: -dv
 * Indicates the completive aspect of an action.
 */
class SuffixDv implements Affix {
    String dv = "Ꮫ"

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
	if (!baseReturnValue.endsWith(dv)) {
            return baseReturnValue + dv
        }
	
        return baseReturnValue
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

        // Check for Ꮫ (completive aspect marker)
        if (!fullWord.endsWith("Ꮫ")) {
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
        result.detectedSuffix = "Ꮫ"
        result.type = "COMPLETIVE_ASPECT"
        return result
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return dv
    }
}
