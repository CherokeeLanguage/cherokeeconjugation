package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.affixes.PrefixWiResult

class PrefixWi implements Affix {
    String wi;

    String toSyllabary(String baseReturnValue, Verb word) {
        String data = word.pronounReflexiveRoot
        baseReturnValue = baseReturnValue ?: data

        if (!baseReturnValue) {
            return "Ꮻ";
        }

        def latin = SyllabaryUtil.parseSyllabary(baseReturnValue)
        def startsWithH = latin.matches("^h[aeiouv].*")
        if (startsWithH) {
            latin = latin.substring(1)
            baseReturnValue = SyllabaryUtil.tsalagiToSyllabary(latin)
        }
        def charAtZero = baseReturnValue.charAt(0)

        if (StringUtility.startsWithVowelSyllabary(baseReturnValue)) {
            baseReturnValue = StringUtility.getOptionsByVowel(charAtZero, baseReturnValue, ['Ꮹ', 'Ꮺ', 'Ꮻ', 'Ꮼ', 'Ꮽ', 'Ꮾ'])
        } else {
            baseReturnValue = "Ꮻ" + (baseReturnValue != '' ? baseReturnValue : data);
        }

        return baseReturnValue;
    }

    /**
     * DECONSTRUCTION METHOD - Reverses toSyllabary
     */
    PrefixWiResult deconstructFromSyllabary(String fullWord, Verb word) {
        PrefixWiResult result = new PrefixWiResult()
        
        if (!fullWord || fullWord.trim().isEmpty()) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            return result
        }

        // Check if word starts with any wi- variant
        if (!fullWord.startsWith("Ꮹ") && !fullWord.startsWith("Ꮺ") && 
            !fullWord.startsWith("Ꮻ") && !fullWord.startsWith("Ꮼ") && 
            !fullWord.startsWith("Ꮽ") && !fullWord.startsWith("Ꮾ")) {
            // No wi- prefix present
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            return result
        }

        // Extract the initial syllable (first character)
        String initialSyllable = fullWord.charAt(0) as String
        
        List<String> wiVariants = ["Ꮹ", "Ꮺ", "Ꮻ", "Ꮼ", "Ꮽ", "Ꮾ"]
        
        if (wiVariants.contains(initialSyllable)) {
            // Remove the initial syllable - what remains should be the base
            String stripped = fullWord.length() > 1 ? fullWord.substring(1) : ""
            
            String data = word.pronounReflexiveRoot
            if (stripped == "" || stripped == data) {
                result.result = fullWord
                result.prefixRemoved = false
                result.detectedPrefix = initialSyllable
                return result
            }
            
            result.result = stripped
            result.prefixRemoved = true
            result.detectedPrefix = "Ꮻ"
            return result
        }
        
        result.result = fullWord
        result.prefixRemoved = false
        result.detectedPrefix = null
        return result
    }

    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return wi
    }
}
