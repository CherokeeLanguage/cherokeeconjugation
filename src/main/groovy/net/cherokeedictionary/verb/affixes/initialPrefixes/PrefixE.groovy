package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.affixes.PrefixIGaDeDaDiResult

/*
* p256 CED
* e-, distant imperative
form: e-; di- after de-, plural; cf. (128 -129) .
(128) a. sdi 2gowh2q 3ha . "You (dl) see it."
b. e 2sdi 23go 3hwah2ta. "You (dl) see it (facing the speaker)."
(129) a. de 2 sdi 3 gowh 2 t~ 3 ha. "You (dl) see them."
b. do 2 d~ 2 sdi 3 go 2 hwah 3 ta. "You (dl) see them (facing the speaker)."
function: e- is used with imperative forms when the person spoken to is facing
the speaker from a position some distance away.
comments: An alternative to considering e- and di-, position facing speaker, to
be two distinct prefixes is to analyze them as a single prefix di-, with a variant
form e- which occurs in imperative forms when not preceded by another prefix.

*/
class PrefixE implements Affix {
    String toSyllabary(String baseReturnValue, Verb word) {
        if (word.initialPrefixHolder.e) {
            def data = word.pronounReflexiveRoot
            def de = word.initialPrefixHolder.de

            if (de) {
                baseReturnValue = 'Ꮧ' + data;
            } else {
                baseReturnValue = 'Ꭱ' + data;
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

        // Check for E- prefixes: Ꭱ or Ꮧ (when following de-)
        if (!fullWord.startsWith("Ꭱ") && !fullWord.startsWith("Ꮧ")) {
            result.result = fullWord
            result.prefixRemoved = false
            result.detectedPrefix = null
            result.reason = null
            return result
        }

        String firstChar = fullWord.charAt(0) as String
        
        List<String> eVariants = ["Ꭱ", "Ꮧ"]
        
        if (!eVariants.contains(firstChar)) {
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
        return ""
    }

    String toString() {
        return e
    }
}
