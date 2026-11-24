package net.cherokeedictionary.verb.affixes.suffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.affixes.SuffixResult

class SuffixA implements Affix {
    String suffix = "Ꭰ"

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
    	//does the end of the value need to change based on the suffix - so uu = uw kind of thing?
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

        // Check for Ꭰ (often used in various verb forms or as ending vowel)
        if (!fullWord.endsWith("Ꭰ")) {
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
        result.detectedSuffix = "Ꭰ"
        result.type = "VOWEL_ENDING"
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
