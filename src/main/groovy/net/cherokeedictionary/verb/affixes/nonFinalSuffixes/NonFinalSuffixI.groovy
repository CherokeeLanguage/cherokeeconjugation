package net.cherokeedictionary.verb.affixes.nonFinalSuffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix

/**
 * NOT IMPLEMENTED YET -- stub.
 *
 * Position 9 (Feeling 1975, Figure 1, grammar guide p. 282): the future
 * suffix "-i-" (marked (f) on the chart, i.e. part of the tense-formant
 * family alongside "-idi-" pre-incipient).
 *
 * CAUTION: the engine's future tenses (COMPLETIVE_FUTURE, FUTURE_EXPECTED,
 * COMPLETED_FUTURE, ...) surface their own finals today; whether this
 * position-9 irrealis "-i-" is distinct from what those tenses already
 * compose must be settled before implementation. Until then this stub
 * passes the word through unchanged.
 * KNOWN-GAP(NONFINAL-I)
 */
class NonFinalSuffixI implements Affix {
    String i

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        // NOT IMPLEMENTED YET: future -i- (p. 282 pos. 9)
        return baseReturnValue
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return i
    }
}
