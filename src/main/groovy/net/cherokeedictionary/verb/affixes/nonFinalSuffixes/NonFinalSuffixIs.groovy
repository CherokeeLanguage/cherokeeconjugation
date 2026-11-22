package net.cherokeedictionary.verb.affixes.nonFinalSuffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix

/**
 * NOT IMPLEMENTED YET -- stub.
 *
 * Position 2 (Feeling 1975, Figure 1, grammar guide p. 282): the duplicative
 * suffix "-is-", and the homophonous "-is-" "become" (inchoative).
 *
 * Insertion point: position 2, after the reversive (-gi-, pos. 1) and before
 * -ilo- (pos. 3). No holder flag exists yet; this stub passes the word
 * through unchanged until the allomorphy is implemented.
 * KNOWN-GAP(NONFINAL-IS)
 */
class NonFinalSuffixIs implements Affix {
    String is

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        // NOT IMPLEMENTED YET: duplicative / "become" -is- (p. 282 pos. 2)
        return baseReturnValue
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return is
    }
}
