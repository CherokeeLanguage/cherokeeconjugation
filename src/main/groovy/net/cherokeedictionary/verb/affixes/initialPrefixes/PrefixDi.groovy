package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.affixes.PrefixIGaDeDaDiResult

class PrefixDi implements Affix {
    String di;

    String toSyllabary(String baseReturnValue, Verb word) {
        if (word.initialPrefixHolder.di) {
            def verbTense = word.tense
            String data = word.pronounReflexiveRoot
            baseReturnValue = baseReturnValue ?: data

            def charAtZero = baseReturnValue.charAt(0)
            def isVowelBeginning = StringUtility.startsWithVowelSyllabary(baseReturnValue)

            if (verbTense == Tense.REMOTE_PAST) {
                if (isVowelBeginning) {
                    baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['', 'Ᏸ', 'Ᏹ', 'Ᏺ', 'Ᏻ', 'Ᏼ'])
                } /*else {
                baseReturnValue =  "Ꮣ" + (baseReturnValue != '' ? baseReturnValue : data);
            }*/

                baseReturnValue = "Ꮣ" + baseReturnValue
            } else {
                if (isVowelBeginning) {
                    baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮧ', 'Ꮴ', 'Ꮧ', 'Ꮶ', 'Ꮷ', 'Ꮸ'])
                } else {
                    baseReturnValue = "Ꮧ" + baseReturnValue
                }
            }
        }

        return baseReturnValue;
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

        // Check for Di- prefixes: Ꮧ, Ꮪ, Ꮭ (remotes), or Ꮣ in remote past context
        if (!fullWord.startsWith("Ꮧ") && !fullWord.startsWith("Ꮪ")) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            result.reason = null
            return result
        }

        String firstChar = fullWord.charAt(0) as String
        
        List<String> diVariants = ["Ꮧ", "Ꮪ"]
        
        if (!diVariants.contains(firstChar)) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            result.reason = null
            return result
        }

        // Check context
        String remainingAfterInitial = fullWord.length() > 1 ? fullWord.substring(1) : ""
        
        if (remainingAfterInitial.length() < 2) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            result.reason = "too_short"
            return result
        }
        
        // Heuristic: look for fusion patterns
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
        result.detectedPrefix = firstChar
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

    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return di
    }
}
