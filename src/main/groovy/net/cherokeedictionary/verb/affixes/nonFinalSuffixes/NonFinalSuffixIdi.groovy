package net.cherokeedictionary.verb.affixes.nonFinalSuffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix

/**
 * NOT IMPLEMENTED YET -- stub.
 *
 * Position 9 (Feeling 1975, Figure 1, grammar guide p. 282): the pre-incipient
 * suffix "-idi-" (marked (f) on the chart, i.e. part of the tense-formant
 * family alongside "-i-" future).
 *
 * Insertion point: position 9, after -e-/-ihl- (pos. 8) and alongside
 * "-g-" progressive and "-i-" future. No holder flag exists yet; this stub
 * passes the word through unchanged until the allomorphy is implemented.
 * KNOWN-GAP(NONFINAL-IDI)
 */
class NonFinalSuffixIdi implements Affix {
    String idi

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        // NOT IMPLEMENTED YET: pre-incipient -idi- (p. 282 pos. 9)
        return baseReturnValue
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return idi
    }
}
