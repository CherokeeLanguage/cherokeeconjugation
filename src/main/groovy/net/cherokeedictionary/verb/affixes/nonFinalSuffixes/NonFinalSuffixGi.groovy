package net.cherokeedictionary.verb.affixes.nonFinalSuffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.util.StringUtility

/**
 * Position 1 (Feeling 1975, Figure 1, grammar guide p. 282): the reversive
 * suffix "-gi-", with allomorphs "-e-" and "-y-".
 *
 * Allomorphy rules [Guide] pp. 282-283:
 *   -gi- before consonants (except -g-)
 *   -gis- before vowels, before -g-, and before -dan- (instrumental-causative)
 *          or -dohdan- (unintentional)
 *   -y- in some phonetic environments (stem-initial g-, or after nasal final)
 *
 * Function: reverses the basic meaning of a number of verbs
 *
 * Examples [Guide] ex. 1-5:
 *   gvsgi-a "I'm unweaving it"         (g + sgi- + vsga)
 *   gv2gi3sdoh2di3ha "he's accidentally unweaving it" (g + sgi- + sdohda + ndi)
 *   dyi-la "she/he undoes it"           (y + la)
 *   yv-sda "you undo it"                (y + vsda)
 *   dya-tla "you take off your clothes" (y + tla)
 *
 * Insertion point: position 1 = BEFORE the pronominal prefix, ahead of all
 * other non-final suffixes.
 */
class NonFinalSuffixGi implements Affix {
    String gi
    
    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        if (!word?.nonFinalSuffixHolder?.gi) {
            return baseReturnValue
        }

        // The reversive -gi- appears BEFORE the stem, affecting what comes after
        // For simplicity, we insert it at the beginning (position 1 is pre-pronominal)
        // In practice, this may need more sophisticated handling
        
        // Check next suffix to determine allomorphy
        boolean hasNextVowelSuffix = word.tense == Tense.FUTURE_EXPECTED || 
                                     word.tense == Tense.COMPLETIVE_FUTURE ||
                                     word.tense == Tense.COMPLETED_FUTURE ||
                                     word.tense == Tense.RECENT_PAST_IMPERATIVE
        
        boolean hasDanSuffix = word.nonFinalSuffixHolder?.dan == true
        boolean hasDohdanSuffix = word.nonFinalSuffixHolder?.dohdan == true
        
        boolean tailStartsWithVowel = NonFinalSuffixProcessor.tailStartsWithVowel(word)
        
        String allomorph
        if (tailStartsWithVowel || hasNextVowelSuffix || hasDanSuffix || hasDohdanSuffix) {
            // -gis- before vowels, before future -i, or before -dan-/-dohdan-
            allomorph = "gsi"
        } else if (baseReturnValue.startsWith("Ꭶ") || SyllabaryUtil.vowelSyllable(baseReturnValue.substring(0, 1))) {
            // -y- environment: after vowel stems or before certain consonants
            allomorph = "y"
        } else {
            // Default: -gi- before consonants
            allomorph = "gi"
        }

        // Insert at the beginning (position 1 is before pronominal prefix)
        return allomorph + baseReturnValue
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return gi ?: "-gi-"
    }
}
