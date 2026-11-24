package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.affixes.PrefixJiResult

class PrefixJi implements Affix {
    String ji;

    String toSyllabary(String baseReturnValue, Verb word) {
        if (word.tense == Tense.IMMEDIATE_COMMAND || word.tense == Tense.RECENT_PAST_IMPERATIVE) {
            return baseReturnValue
        }
        String data = word.pronounReflexiveRoot
        baseReturnValue = baseReturnValue ?: data
        def latin = SyllabaryUtil.parseSyllabary(baseReturnValue)

        if (latin.endsWith("ei")) {
            return baseReturnValue
        }

        def charAtZero = baseReturnValue.charAt(0)
        boolean isVowelBeginning = StringUtility.startsWithVowelSyllabary(baseReturnValue)

        if (word.initialPrefixHolder.yi || word.initialPrefixHolder.ga) {
            if (isVowelBeginning) {
                baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮎ', 'Ꮑ', 'Ꮒ', 'Ꮓ', 'Ꮔ', 'Ꮕ'])
            } else {
                baseReturnValue = (word.initialPrefixHolder.yi ? "Ꮒ" : "") + baseReturnValue + (word.initialPrefixHolder.yi ? "Ꮎ" : "") + " ᏥᎩ";
            }
        } else {
            if (isVowelBeginning) {
                baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮳ', 'Ꮴ', 'Ꮵ', 'Ꮶ', 'Ꮷ', 'Ꮸ'])
            } else {
                if (charAtZero == 'Ꮹ'
                    || charAtZero == 'Ꮺ'
                    || charAtZero == 'Ꮻ'
                    || charAtZero == 'Ꮼ'
                    || charAtZero == 'Ꮽ'
                    || charAtZero == 'Ꮾ') {
                    baseReturnValue = "Ꮸ" + baseReturnValue
                } else {
                    baseReturnValue = "Ꮵ" + baseReturnValue
                }
            }
        }

        return baseReturnValue
    }

    /**
     * DECONSTRUCTION METHOD - Reverses toSyllabary
     */
    PrefixJiResult deconstructFromSyllabary(String fullWord, Verb word) {
        PrefixJiResult result = new PrefixJiResult()
        
        if (!fullWord || fullWord.trim().isEmpty()) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            result.reason = null
            return result
        }

        // Check if word starts with any ji- variant
        if (!fullWord.startsWith("Ꮳ") && !fullWord.startsWith("Ꮴ") && 
            !fullWord.startsWith("Ꮵ") && !fullWord.startsWith("Ꮶ") && 
            !fullWord.startsWith("Ꮷ") && !fullWord.startsWith("Ꮸ")) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            result.reason = null
            return result
        }

        String initialSyllable = fullWord.charAt(0) as String
        
        List<String> jiVariants = ["Ꮳ", "Ꮴ", "Ꮵ", "Ꮶ", "Ꮷ", "Ꮸ"]
        
        if (!jiVariants.contains(initialSyllable)) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            result.reason = null
            return result
        }

        // Context-aware check
        String remainingAfterInitial = fullWord.length() > 1 ? fullWord.substring(1) : ""
        
        boolean looksLikeKnownRoot = looksLikeKnownStemOrReflexive(remainingAfterInitial, word)
        
        if (looksLikeKnownRoot) {
            // ji- appears to be FUSED into the root, DO NOT separate
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            result.reason = "fused_into_stem"
            return result
        }
        
        // Safe to strip
        result.result = remainingAfterInitial
        result.prefixRemoved = true
        result.detectedPrefix = initialSyllable
        result.reason = null
        return result
    }
    
    private boolean looksLikeKnownStemOrReflexive(String candidate, Verb word) {
        if (candidate.length() < 2) {
            return false
        }
        
        boolean hasConsonantCluster = candidate.matches(/^[Ꭰ-Ᏼ][Ꭰ-Ᏼ]{2,}$/)
        
        boolean looksReflexive = candidate.contains("ᏩᏘ") || 
                                candidate.contains("Ꮏ") || 
                                candidate.endsWith("Ꭽ") ||  
                                candidate.endsWith("Ꭹ")     
        
        return hasConsonantCluster || looksReflexive
    }

    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return ji
    }
}
