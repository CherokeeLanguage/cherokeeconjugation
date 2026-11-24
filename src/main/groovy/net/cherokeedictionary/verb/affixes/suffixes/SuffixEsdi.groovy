package net.cherokeedictionary.verb.affixes.suffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.affixes.SuffixResult

/**
 * Suffix: -esdi
 * Used in specific aspectual or future-oriented constructions.
 */
class SuffixEsdi implements Affix {
    String esdi = "ᎡᏍᏗ"

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        if (!baseReturnValue.endsWith(esdi)) {
            return baseReturnValue + esdi
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

        // Check for ᎡᏍᏗ (future-oriented or aspectual marker)
        if (!fullWord.endsWith("ᎡᏍᏗ")) {
            result.result = fullWord
            result.suffixRemoved = false
            result.detectedSuffix = null
            result.type = null
            return result
        }

        String stem = fullWord.length() > 3 ? fullWord.substring(0, fullWord.length() - 3) : ""
        
        if (stem.isEmpty()) {
            result.result = fullWord
            result.suffixRemoved = false
            result.detectedSuffix = null
            result.type = null
            return result
        }

        result.result = stem
        result.suffixRemoved = true
        result.detectedSuffix = "ᎡᏍᏗ"
        result.type = "FUTURE_ORIENTED"
        return result
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return esdi
    }
}
