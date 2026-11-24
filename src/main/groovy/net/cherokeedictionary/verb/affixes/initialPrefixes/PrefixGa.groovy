package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.PrefixTableSubject
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.affixes.PrefixIGaDeDaDiResult

/**
 * since -- pp 255 & 256 Durbin Feeling Dictionary
 */
class PrefixGa implements Affix {
    String ga

    String toSyllabary(String baseReturnValue, Verb word) {
        if (word.initialPrefixHolder.ga) {
            String data = word.pronounReflexiveRoot
            baseReturnValue = baseReturnValue ?: data

            def charAtZero = baseReturnValue.charAt(0)

            if (word.subject == PrefixTableSubject.SG2) {
                baseReturnValue = "Ꭸ" + baseReturnValue
            } else if (word.subject == PrefixTableSubject.SG3) {
                baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['ᎬᏩ', 'ᎬᏪ', 'ᎬᏫ', 'ᎬᏬ', 'ᎬᏩ', 'ᎬᏮ'])
            } else if (StringUtility.startsWithVowelSyllabary(baseReturnValue)) {
                baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꭼ', 'ᎦᏰ', 'ᎦᏱ', 'ᎦᏲ', 'ᎦᏳ', 'ᎦᏴ'])
            } else {
                baseReturnValue = 'Ꭶ' + baseReturnValue
            }
        }

        return baseReturnValue
    }

    /**
     * DECONSTRUCTION METHOD - Reverses toSyllabary
     */
    PrefixIGaDeDaDiResult deconstructFromSyllabary(String fullWord, Verb word) {
        PrefixIGaDeDaDiResult result = new PrefixIGaDeDaDiResult()
        
        if (!fullWord || fullWord.trim().isEmpty()) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            result.reason = null
            return result
        }

        // Check for Ga- prefixes: Ꭶ, Ꭷ, Ꭸ, Ꭹ, Ꭺ, Ꭻ (SG2), or compound forms like ᎬᏩ, ᎬᏪ, etc. (SG3)
        if (!fullWord.startsWith("Ꭶ") && !fullWord.startsWith("Ꭷ") && 
            !fullWord.startsWith("Ꭸ") && !fullWord.startsWith("Ꭹ") && 
            !fullWord.startsWith("Ꭺ") && !fullWord.startsWith("Ꭻ") &&
            !fullWord.startsWith("Ꭼ")) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            result.reason = null
            return result
        }

        String initialChar = fullWord.charAt(0) as String
        
        List<String> gaVariants = ["Ꭶ", "Ꭷ", "Ꭸ", "Ꭹ", "Ꭺ", "Ꭻ", "Ꭼ"]
        
        if (!gaVariants.contains(initialChar)) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            result.reason = null
            return result
        }

        // Check if this is a two-syllable form (ᎬᏩ, ᎬᏪ, etc.)
        boolean isTwoSyllableForm = fullWord.length() > 1 && 
                                    initialChar == "Ꭼ" &&
                                    ["Ꮹ", "Ꮺ", "Ꮻ", "Ꮼ", "Ꮽ", "Ꮾ"].contains(fullWord.substring(1, 2))
        
        String syllableToRemove = isTwoSyllableForm ? fullWord.substring(0, 2) : initialChar
        int removalLength = isTwoSyllableForm ? 2 : 1
        
        String remainingAfterInitial = fullWord.length() > removalLength ? 
                                       fullWord.substring(removalLength) : ""
        
        // For two-syllable forms, always remove
        // For single-syllable forms, check context
        if (isTwoSyllableForm) {
            result.result = remainingAfterInitial
            result.prefixRemoved = true
            result.detectedPrefix = "ᎬᏩ" // Normalize to canonical form
            result.reason = null
            return result
        }
        
        // Single syllable check: look ahead to determine if fused
        if (remainingAfterInitial.length() < 2) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            result.reason = "too_short"
            return result
        }
        
        // Check for fusion patterns
        boolean looksLikeKnownStemOrReflexive = looksLikeKnownStemOrReflexive(remainingAfterInitial, word)
        
        if (looksLikeKnownStemOrReflexive) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            result.reason = "fused_into_stem"
            return result
        }

        result.result = remainingAfterInitial
        result.prefixRemoved = true
        result.detectedPrefix = initialChar
        result.reason = null
        return result
    }
    
    private boolean looksLikeKnownStemOrReflexive(String candidate, Verb word) {
        if (candidate.length() < 2) {
            return false
        }
        
        // Heuristic: longer sequences that look like roots/stems
        boolean hasConsonantCluster = candidate.matches(/^[Ꭰ-Ᏼ][Ꭰ-Ᏼ]{2,}$/)
        
        // Look for known reflexive or verb-final patterns
        boolean looksReflexive = candidate.contains("ᏩᏘ") || 
                                candidate.contains("Ꮏ") || 
                                candidate.endsWith("Ꭽ") ||  
                                candidate.endsWith("Ꭹ") ||
                                candidate.endsWith("ᎢᎭ") ||
                                candidate.endsWith("ᎩᎭ")
        
        return hasConsonantCluster || looksReflexive
    }

    String toEnglish(String baseReturnValue, Verb Word) {
        return null
    }

    String toString() {
        return ga
    }


}
