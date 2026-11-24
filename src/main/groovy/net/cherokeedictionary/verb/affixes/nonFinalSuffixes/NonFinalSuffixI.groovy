package net.cherokeedictionary.verb.affixes.nonFinalSuffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.containers.NonFinalSuffixProcessor

/**
 * Position 9 (Feeling 1975, Figure 1, grammar guide p. 282): the future
 * suffix "-i-" (marked (f) on the chart, i.e. part of the tense-formant
 * family alongside "-idi-" pre-incipient).
 *
 * CAUTION: The engine's built-in future tenses (COMPLETIVE_FUTURE, 
 * FUTURE_EXPECTED, COMPLETED_FUTURE, FUTURE_COMMAND) already surface their own
 * endings. Whether this position-9 irrealis "-i-" is distinct from what those
 * tenses compose must be settled before implementation.
 *
 * For now, this implementation provides a basic structure that can be refined:
 *   - Provides simple -i- insertion before tense finals
 *   - Avoids conflicts with existing tense machinery by checking verb.tense
 *   - Serves as a placeholder until the exact semantics are clarified
 *
 * Function: Simple future/irrealis marker
 * Form: always -i- (no documented allomorphy)
 * Insertion point: position 9, after -e-/-ihl- (pos. 8) and alternatively to
 * -idi- (pre-incipient).
 *
 * Examples [Guide]:
 *   ᎦᏬᏂᏍᏗ "You will speak"                  (ga-won-i+svdi)
 *   ᎠᏚᎵᏍᏗ "He will want"                    (a-du-li+i+svdi)
 */
class NonFinalSuffixI implements Affix {
    String i
    
    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        if (!word?.nonFinalSuffixHolder?.i) {
            return baseReturnValue
        }

        // Guard: avoid conflicts with existing tense suffixes
        boolean hasFutureTense = word.tense in [
            Tense.COMPLETIVE_FUTURE,
            Tense.FUTURE_EXPECTED,
            Tense.COMPLETED_FUTURE,
            Tense.FUTURE_COMMAND,
            Tense.FUTURE_IMPERATIVE_VOLATIVE,
            Tense.RECENT_PAST_IMPERATIVE
        ]
        
        if (hasFutureTense) {
            // Skip adding another -i- when tense already provides it
            // This avoids duplication with the built-in tense system
            return baseReturnValue
        }

        // Check for pre-incipient competitor
        boolean hasIdi = word.nonFinalSuffixHolder?.idi == true
        
        if (hasIdi) {
            // If both set, prefer idi (more specific meaning)
            return baseReturnValue
        }

        // Insert -i- before the final suffix material
        // But not at the very end where tense markers would go
        String allomorph = "i"
        
        // Try to insert before tense-final elements
        def result = NonFinalSuffixProcessor.insertBeforeTense(word, allomorph)
        
        if (result && !result.equals(baseReturnValue)) {
            return result
        }
        
        // If we can't insert properly, add at appropriate position
        // Guard against double -i-
        if (!baseReturnValue.endsWith("Ꭲ")) {
            return baseReturnValue + "i"
        }
        
        return baseReturnValue
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return i ?: "-i-"
    }
}
