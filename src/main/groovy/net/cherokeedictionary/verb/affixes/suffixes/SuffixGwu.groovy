package net.cherokeedictionary.verb.affixes.suffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.affixes.SuffixResult

class SuffixGwu implements Affix {
    String gwu = "Ꮚ"

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        if (!baseReturnValue) {
            return baseReturnValue
        }
        return baseReturnValue.endsWith(gwu) ? baseReturnValue : baseReturnValue + gwu
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

        // Check if word ends with immediate future ᏳᏍᏗ or remote past Ꮚ variants
        if (!fullWord.endsWith("Ꮚ") && !fullWord.endsWith("ᏳᏍᏗ")) {
            result.result = fullWord
            result.suffixRemoved = false
            result.detectedSuffix = null
            result.type = null
            return result
        }

        // Check for ᏳᏍᏗ (immediate future) first - 3 characters
        if (fullWord.endsWith("ᏳᏍᏗ")) {
            String stem = fullWord.substring(0, fullWord.length() - 3)
            if (stem.isEmpty()) {
                result.result = fullWord
                result.suffixRemoved = false
                result.detectedSuffix = null
                result.type = null
                return result
            }
            result.result = stem
            result.suffixRemoved = true
            result.detectedSuffix = "ᏳᏍᏗ"
            result.type = "IMMEDIATE_FUTURE"
            return result
        }
        
        // Check for Ꮚ (remote past marker)
        if (fullWord.endsWith("Ꮚ")) {
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
            result.detectedSuffix = "Ꮚ"
            result.type = "REMOTE_PAST"
            return result
        }

        result.result = fullWord
        result.suffixRemoved = false
        result.detectedSuffix = null
        result.type = null
        return result
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return gwu
    }
}
