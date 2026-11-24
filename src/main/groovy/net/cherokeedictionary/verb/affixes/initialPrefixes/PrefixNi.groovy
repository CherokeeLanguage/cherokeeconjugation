package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.affixes.PrefixNiResult

class PrefixNi implements Affix {
    String Ni;


    String toSyllabary(String baseReturnValue, Verb word) {
        if (word.initialPrefixHolder.ni) {
            String data = word.pronounReflexiveRoot
            baseReturnValue = baseReturnValue ?: data

            def charAtZero = baseReturnValue.charAt(0)

            if (StringUtility.startsWithVowelSyllabary(baseReturnValue)) {
                baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮎ', 'Ꮑ', 'Ꮒ', 'Ꮓ', 'Ꮔ', 'Ꮕ'])
            } else {
                baseReturnValue = "Ꮒ" + baseReturnValue
            }
        }

        return baseReturnValue;
    }

    /**
     * DECONSTRUCTION METHOD - Reverses toSyllabary
     */
    PrefixNiResult deconstructFromSyllabary(String fullWord, Verb word) {
        PrefixNiResult result = new PrefixNiResult()
        
        if (!fullWord || fullWord.trim().isEmpty()) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            return result
        }

        // Check if word starts with ni- variant (Ꮎ, Ꮑ, Ꮒ, Ꮓ, Ꮔ, Ꮕ)
        if (!fullWord.startsWith("Ꮎ") && !fullWord.startsWith("Ꮑ") && 
            !fullWord.startsWith("Ꮒ") && !fullWord.startsWith("Ꮓ") && 
            !fullWord.startsWith("Ꮔ") && !fullWord.startsWith("Ꮕ")) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            return result
        }

        String initialSyllable = fullWord.charAt(0) as String
        
        List<String> niVariants = ["Ꮎ", "Ꮑ", "Ꮒ", "Ꮓ", "Ꮔ", "Ꮕ"]
        
        if (!niVariants.contains(initialSyllable)) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            return result
        }

        // Context-aware check
        String remainingAfterInitial = fullWord.length() > 1 ? fullWord.substring(1) : ""
        
        boolean looksLikeKnownStemOrReflexive = looksLikeKnownStemOrReflexive(remainingAfterInitial, word)
        
        if (looksLikeKnownStemOrReflexive) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            return result
        }
        
        // Safe to strip
        result.result = remainingAfterInitial
        result.prefixRemoved = true
        result.detectedPrefix = initialSyllable
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

    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return Ni
    }
}
