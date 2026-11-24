package net.cherokeedictionary.verb.affixes.suffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.affixes.SuffixResult

class SuffixDina implements Affix {
    String dina = "ᏗᎾ"

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        return baseReturnValue.endsWith(dina) ? baseReturnValue : baseReturnValue + dina
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

        // Check for ᏗᎾ (plural/distributive marker)
        if (!fullWord.endsWith("ᏗᎾ")) {
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
        result.detectedSuffix = "ᏗᎾ"
        result.type = "PLURAL_DISTRIBUTIVE"
        return result
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return dina
    }
}
