package net.cherokeedictionary.verb.affixes.nonFinalSuffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.containers.NonFinalSuffixProcessor

/**
 * Position 9 (Feeling 1975, Figure 1, grammar guide p. 282): the pre-incipient
 * suffix "-idi-" (marked (f) on the chart, i.e. part of the tense-formant
 * family alongside "-i-" future).
 *
 * Function: Indicates approach toward an action state ("about to", "starting to")
 * 
 * This suffix occupies the same position as the future -i-, and they appear
 * in complementary distribution with other tense markers. The idi- variant
 * is used in more progressive/approach contexts.
 *
 * Form: always -idi- (no documented allomorphy)
 *
 * Insertion point: position 9, after -e-/-ihl- (pos. 8) and alongside/instead
 * of -i- (future).
 *
 * Examples [Guide]:
 *   ᏗᏁᎦᏙᎵᏍᏗ "He's about to stand"         (di-ne-ga- + idi- + sv+di)
 *   ᎠᎾᎦᏘᏙᎵᏍᏗ "They're about to speak"    (an-a-go- + idi- + sv+di)
 */
class NonFinalSuffixIdi implements Affix {
    String idi
    
    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        if (!word?.nonFinalSuffixHolder?.idi) {
            return baseReturnValue
        }

        // Check if this is being used instead of future -i-
        // Position 9 can have either -i- (simple future) or -idi- (pre-incipient)
        
        boolean usingFutureI = word.nonFinalSuffixHolder?.i == true
        
        if (usingFutureI) {
            // Both idi and i set: choose idi over i (idi has semantic priority for "about to")
            // Remove future -i- if present
            baseReturnValue = removeFutureI(baseReturnValue)
        }

        // -idi- is inserted before the tense-final material
        String allomorph = "idi"
        
        // For pre-incipient, insert before final tense markers
        return NonFinalSuffixProcessor.insertBeforeTense(word, allomorph) ?: 
               baseReturnValue
    }

    /**
     * Simple heuristic: remove trailing Ꭲ if it looks like a future tense marker
     */
    private String removeFutureI(String syllabary) {
        if (syllabary.endsWith("Ꭲ") && syllabary.size() > 3) {
            // Check if previous character makes it look like a future ending
            def prevChar = syllabary.charAt(syllabary.size() - 2)
            if ("ᎠᎡᎣᎤᎥ".contains(prevChar.toString())) {
                return syllabary.substring(0, syllabary.size() - 1)
            }
        }
        return syllabary
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return idi ?: "-idi-"
    }
}
