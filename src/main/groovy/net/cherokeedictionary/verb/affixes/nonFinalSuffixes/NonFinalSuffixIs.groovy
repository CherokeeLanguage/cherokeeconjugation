package net.cherokeedictionary.verb.affixes.nonFinalSuffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.containers.NonFinalSuffixProcessor

/**
 * Position 2 (Feeling 1975, Figure 1, grammar guide p. 282): the duplicative
 * suffix "-is-", and the homophonous "-is-" "become" (inchoative).
 *
 * Two distinct meanings:
 *   (a) Duplicative: indicates repetition of the action ("do again")
 *   (b) Inchoative ("become"): indicates entering a state
 *
 * Form: always -is- (no documented allomorphy in grammar guide)
 *
 * Insertion point: position 2, after the reversive (-gi-, pos. 1) and before
 * -ilo- (pos. 3).
 *
 * Examples [Guide]:
 *   ᏗᎶᏍᏓᏅ "They do it repeatedly"           (di-l- + is- + da + ndv)
 *   ᎠᏑᏩᏍᏓ "It becomes red"                  (a-suwa- + is- + da)
 *   ᎧᏍᏆᏂᎩ "It begins to become clear"       (gaskwani- + is- + gi)
 */
class NonFinalSuffixIs implements Affix {
    String is
    
    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        if (!word?.nonFinalSuffixHolder?.is) {
            return baseReturnValue
        }

        // The duplicative -is- is relatively simple - no complex allomorphy
        // Insert after the reversive (if present) and before other suffixes
        
        // Check if tail starts with vowel (for positioning decisions)
        boolean tailStartsWithVowel = NonFinalSuffixProcessor.tailStartsWithVowel(word)
        
        // For position 2, we insert -is- after any prefix/reversive elements
        // and before stem-final material
        String allomorph = "is"
        
        // Determine insertion point based on whether there's a reversive prefix
        if (word.nonFinalSuffixHolder?.gi && !tailStartsWithVowel) {
            // If reversive exists and tail doesn't start with vowel,
            // the -is- goes after the reversed form
            return NonFinalSuffixProcessor.insertAfterPrefix(word, allomorph) ?: 
                   baseReturnValue
        } else {
            // Default insertion at standard position 2
            return NonFinalSuffixProcessor.insertBeforeTail(word, allomorph) ?: 
                   baseReturnValue
        }
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return is ?: "-is-"
    }
}
