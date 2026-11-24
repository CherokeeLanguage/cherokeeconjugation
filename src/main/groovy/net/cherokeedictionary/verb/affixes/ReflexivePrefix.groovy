package net.cherokeedictionary.verb.affixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.util.Tense

class ReflexivePrefix implements Affix {
    @Override
    String toSyllabary(String verbToConjugate, Verb verb) {
        if (verb.reflexiveHolderObject.isReflexive()) {
            String stem = stripSg3Marker(verbToConjugate)
            def artifactIdx = artifactGlyphIndex(stem)
            if (stem.startsWith("Ꭰ") && artifactIdx != 1) {
                verb.reflexivePrefix = "ᎠᏓ"
                verbToConjugate = "ᎠᏓ" + stem.substring(1)
            } else if (artifactIdx >= 0) {
                verb.reflexivePrefix = "ᎠᏓ"
                verbToConjugate = "ᎠᏓᏛ" + stem.substring(artifactIdx + 1)
            } else if (StringUtility.startsWithVowelSyllabary(stem)) {
                def str = "d" + SyllabaryUtil.parseSyllabary(stem.charAt(0) as String)
                def rv = SyllabaryUtil.tsalagiToSyllabary(str)
                verb.reflexivePrefix = "ᎠᏓ" + rv
                verbToConjugate = "ᎠᏓ" + rv + stem.substring(1)
            } else {
                verb.reflexivePrefix = "ᎠᏓ"
                verbToConjugate = "ᎠᏓ" + stem
            }
        }

        return verbToConjugate
    }

    /**
     * DECONSTRUCTION METHOD - Reverses toSyllabary
     */
    PrefixReflexiveResult deconstructFromSyllabary(String fullWord, Verb word) {
        PrefixReflexiveResult result = new PrefixReflexiveResult()
        
        if (!fullWord || fullWord.length() < 2) {
            result.result = fullWord
            result.hasReflexive = false
            result.detectedAllomorph = null
            return result
        }

        String firstTwo = fullWord.length() > 1 ? fullWord.substring(0, 2) : ""
        String firstThree = fullWord.length() > 2 ? fullWord.substring(0, 3) : ""

        // Pattern 1: ᎠᏓᏛ-
        if (firstThree == "ᎠᏓᏛ") {
            String remainder = fullWord.length() > 3 ? fullWord.substring(3) : ""
            if (remainder) {
                result.result = remainder
                result.hasReflexive = true
                result.detectedAllomorph = "ᎠᏓᏛ"
                return result
            }
        }

        // Pattern 2: ᎠᏓ- followed by vowel (non-a)
        if (firstTwo == "ᎠᏓ") {
            char secondChar = fullWord.charAt(1) as char
            if (isNonAVowel(secondChar)) {
                String remainder = fullWord.length() > 2 ? fullWord.substring(2) : ""
                
                if (remainder && !isLikelyStemContinuation(remainder)) {
                    result.result = fullWord
                    result.hasReflexive = false
                    result.detectedAllomorph = null
                    return result
                }
                
                result.result = remainder
                result.hasReflexive = true
                result.detectedAllomorph = "ᎠᏓ"
                return result
            }
            
            // Pattern 3: ᎠᏓ- before 'a' stem (-ad-)
            if (fullWord.length() > 2 && fullWord.charAt(2) == 'Ꭰ') {
                String remainder = fullWord.length() > 3 ? fullWord.substring(3) : ""
                if (remainder) {
                    result.result = remainder
                    result.hasReflexive = true
                    result.detectedAllomorph = "ᎠᏓ-ad"
                    return result
                }
            }
            
            // Pattern 4: ᎠᏓ- before consonant (ada-)
            if (fullWord.length() > 2 && !isVowel(fullWord.charAt(2) as char)) {
                String remainder = fullWord.length() > 2 ? fullWord.substring(2) : ""
                if (remainder) {
                    result.result = remainder
                    result.hasReflexive = true
                    result.detectedAllomorph = "ᎠᏓ-ada"
                    return result
                }
            }
        }

        result.result = fullWord
        result.hasReflexive = false
        result.detectedAllomorph = null
        return result
    }

    private static boolean isVowel(char c) {
        String vowels = "ᎠᎡᎢᎣᎤᎥ"
        return vowels.contains(c as String)
    }

    private static boolean isNonAVowel(char c) {
        String nonAVowels = "ᎡᎢᎣᎤᎥ"
        return nonAVowels.contains(c as String)
    }

    private static boolean isLikelyStemContinuation(String candidate) {
        if (candidate.length() < 2) {
            return false
        }
        
        boolean hasConsonantVowelPattern = candidate.matches(/^[Ꭰ-Ᏼ][Ꭰ-Ᏼ]{2,}$/)
        boolean startsWithPrefixLike = candidate.startsWith("Ꭰ") || 
                                       candidate.startsWith("Ꭱ") || 
                                       candidate.startsWith("Ꮳ")
        
        return hasConsonantVowelPattern && !startsWithPrefixLike
    }

    private static String stripSg3Marker(String syllabary) {
        if (!syllabary) { return syllabary }
        return syllabary.startsWith("Ꭴ") ? syllabary.substring(1) : syllabary
    }

    private static final List<String> WA_ARTIFACTS = ['Ꮹ', 'Ꮺ', 'Ꮻ', 'Ꮼ', 'Ꮽ', 'Ꮾ', 'Ꭵ']

    private static int artifactGlyphIndex(String stem) {
        if (!stem || stem.size() < 2) { return -1 }
        if (WA_ARTIFACTS.contains(String.valueOf(stem.charAt(0)))) { return 0 }
        if (stem.startsWith("Ꭰ") && WA_ARTIFACTS.contains(String.valueOf(stem.charAt(1)))) { return 1 }
        return -1
    }

    @Override
    String toEnglish(String baseReturnValue, Verb verb) {
        return null
    }
}
