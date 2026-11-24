package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.affixes.PrefixIGaDeDaDiResult

class PrefixI implements Affix {
    String i;

    String toSyllabary(String baseReturnValue, Verb word) {
        if (word.initialPrefixHolder.i) {
            def de = word.initialPrefixHolder.de
            def verbTense = word.tense

            String data = word.pronounReflexiveRoot
            baseReturnValue = baseReturnValue ?: data

            def charAtZero = baseReturnValue.charAt(0)

            if (StringUtility.startsWithVowelSyllabary(baseReturnValue)) {
                baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꭲ', 'Ꭲ', 'Ꭲ', 'Ꭲ', 'Ꭲ', 'Ꭲ'])
            } else {
                if (de) {
                    baseReturnValue = 'Ꮩ' + baseReturnValue
                } else if (charAtZero == 'Ꭶ' || verbTense == Tense.REMOTE_PAST) {
                    baseReturnValue = 'Ꭵ' + baseReturnValue
                } else {
                    baseReturnValue = 'Ꭲ' + baseReturnValue
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

        // Check for I- prefixes: Ꭲ, Ꭵ, Ꮩ (when followed by certain conditions)
        if (!fullWord.startsWith("Ꭲ") && !fullWord.startsWith("Ꭵ") && 
            !fullWord.startsWith("Ꮩ")) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            result.reason = null
            return result
        }

        String initialSyllable = fullWord.charAt(0) as String
        
        List<String> iVariants = ["Ꭲ", "Ꭵ", "Ꮩ"]
        
        if (!iVariants.contains(initialSyllable)) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            result.reason = null
            return result
        }

        // For Ꭲ and Ꭵ, always safe to strip
        if (initialSyllable == "Ꭲ" || initialSyllable == "Ꭵ") {
            String remainingAfterInitial = fullWord.length() > 1 ? fullWord.substring(1) : ""
            result.result = remainingAfterInitial
            result.prefixRemoved = true
            result.detectedPrefix = initialSyllable
            result.reason = null
            return result
        }
        
        // For Ꮩ, check if it's actually a da- prefix first
        // Ꮩ can be either I+da or just part of da- compound
        // Heuristic: if next syllable is a vowel, likely I-de combination
        String remainingAfterFirst = fullWord.length() > 1 ? fullWord.substring(1) : ""
        boolean looksLikeIPlusDe = !remainingAfterFirst.isEmpty() && 
                                   StringUtility.startsWithVowelSyllabary(remainingAfterFirst)
        
        if (!looksLikeIPlusDe && remainingAfterFirst.length() > 2) {
            // Likely fused into da-, treat as not an I- prefix
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            result.reason = "likely_da_compound"
            return result
        }

        String remainingAfterInitial = fullWord.length() > 1 ? fullWord.substring(1) : ""
        result.result = remainingAfterInitial
        result.prefixRemoved = true
        result.detectedPrefix = initialSyllable
        result.reason = null
        return result
    }

    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return i
    }
}
