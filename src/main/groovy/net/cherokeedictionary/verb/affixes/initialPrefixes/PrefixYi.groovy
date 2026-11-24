package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.affixes.PrefixYiResult

class PrefixYi implements Affix {
    String yi;

    String toSyllabary(String baseReturnValue, Verb word) {
        String data = word.pronounReflexiveRoot
        baseReturnValue = baseReturnValue ?: data

        if (!word.initialPrefixHolder.ji) {
            def latin = SyllabaryUtil.parseSyllabary(baseReturnValue)
            def startsWithH = latin.startsWith('h')
            if (startsWithH) {
                latin = latin.substring(1)
                baseReturnValue = SyllabaryUtil.tsalagiToSyllabary(latin)
            }

            def charAtZero = baseReturnValue.charAt(0)

            if (StringUtility.startsWithVowelSyllabary(baseReturnValue)) {
                baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮿ', 'Ᏸ', 'Ᏹ', 'Ᏺ', 'Ᏻ', 'Ᏼ'])
            } else {
                if (charAtZero == 'Ꮹ'
                        || charAtZero == 'Ꮺ'
                        || charAtZero == 'Ꮻ'
                        || charAtZero == 'Ꮼ'
                        || charAtZero == 'Ꮽ'
                        || charAtZero == 'Ꮾ') {
                    baseReturnValue = "Ᏻ" + baseReturnValue
                    // tio 12Nov26: WI-28B — guide ex. 28b: after the negative yu-,
                    // the wi- element may be DELETED (ᏳᎦᏬᏂᎭ alongside ᏳᏫᎦᏬᏂᎭ).
                    // Only the plain Ꮻ glyph (wi- before consonants) qualifies, and
                    // only when wi- was actually applied (a stem-initial ᏫᏬ... must
                    // never be deleted). Canonical wholeWord stays the full form
                    // (28a); the optional deletion is recorded as variantWord.
                    if (word.initialPrefixHolder?.wi && charAtZero == 'Ꮻ') {
                        word.variantWord = "Ᏻ" + baseReturnValue.substring(2)
                    }
                } else {
                    baseReturnValue = "Ᏹ" + baseReturnValue
                }
            }
        }

        return baseReturnValue;
    }

    /**
     * DECONSTRUCTION METHOD - Reverses toSyllabary
     */
    PrefixYiResult deconstructFromSyllabary(String fullWord, Verb word) {
        PrefixYiResult result = new PrefixYiResult()
        
        if (!fullWord || fullWord.trim().isEmpty()) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            result.reason = null
            return result
        }

        // Check if word starts with any yi- variant (Ꮿ, Ᏸ, Ᏹ, Ᏺ, Ᏻ, Ᏼ)
        if (!fullWord.startsWith("Ꮿ") && !fullWord.startsWith("Ᏸ") && 
            !fullWord.startsWith("Ᏹ") && !fullWord.startsWith("Ᏺ") && 
            !fullWord.startsWith("Ᏻ") && !fullWord.startsWith("Ᏼ")) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            result.reason = null
            return result
        }

        String initialSyllable = fullWord.charAt(0) as String
        
        List<String> yiVariants = ["Ꮿ", "Ᏸ", "Ᏹ", "Ᏺ", "Ᏻ", "Ᏼ"]
        
        if (!yiVariants.contains(initialSyllable)) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            result.reason = null
            return result
        }

        // Context-aware check
        String remainingAfterInitial = fullWord.length() > 1 ? fullWord.substring(1) : ""
        
        boolean looksLikeKnownStemOrReflexive = looksLikeKnownStemOrReflexive(remainingAfterInitial, word)
        
        if (looksLikeKnownStemOrReflexive) {
            // yi- appears to be FUSED into the root, DO NOT separate
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
        return yi
    }
}
