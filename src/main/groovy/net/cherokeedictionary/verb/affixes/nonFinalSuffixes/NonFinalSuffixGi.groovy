package net.cherokeedictionary.verb.affixes.nonFinalSuffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix

/**
 * NOT IMPLEMENTED YET -- stub.
 *
 * Position 1 (Feeling 1975, Figure 1, grammar guide p. 282): the reversive
 * suffix "-gi-", with allomorphs "-e-" and "-y-".
 *
 * Documented shape [Guide] pp. 282-283:
 *   form: -gi- before consonants; -gis- before vowels, before -g-, and
 *   before the instrumental-causative (-dan-) and accidental (-dohdan-)
 *   suffixes (cf. guide ex. 1-5: gvsgi-a "I'm unweaving it",
 *   gv2gi3sdoh2di3ha "he's accidentally unweaving it").
 *   function: reverses the basic meaning of a number of verbs.
 *
 * Insertion point: position 1 = BEFORE the pronominal prefix, ahead of all
 * other non-final suffixes. No holder flag exists yet; this stub passes the
 * word through unchanged until the allomorphy is implemented.
 * KNOWN-GAP(NONFINAL-GI)
 */
class NonFinalSuffixGi implements Affix {
    String gi

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        // NOT IMPLEMENTED YET: reversive -gi-/-e-/-y- allomorphy (p. 282 pos. 1)
        return baseReturnValue
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return gi
    }
}
