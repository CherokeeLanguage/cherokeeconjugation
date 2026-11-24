package net.cherokeedictionary.verb.affixes.suffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.affixes.SuffixResult

class SuffixEi implements Affix {
    String ei = "ᎡᎢ"

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        if (!baseReturnValue) {
            return baseReturnValue
        }
        return baseReturnValue.endsWith(ei) ? baseReturnValue : baseReturnValue + ei
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

        // Check for ᎡᎢ (aspectual or modal marker)
        if (!fullWord.endsWith("ᎡᎢ")) {
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
        result.detectedSuffix = "ᎡᎢ"
        result.type = "ASPECTUAL_MODAL"
        return result
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return ei
    }
}
