package net.cherokeedictionary.verb.affixes.nonFinalSuffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.containers.NonFinalSuffixProcessor

/**
 * C6: -ihl-, "come to" (grammar guide Figure 1 position 8).
 *
 * The printed allomorphy for -ihl- follows the general pattern of the
 * consonant-initial non-final suffixes (-ilo-/-ilos-): -ihl- before vowels,
 * -ihs- before consonants. Flagged as an approximation until the verb-book
 * section is verified. -- timo 10Nov26
 */
class NonFinalSuffixIhi implements Affix {
    String ihi

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        if (!word?.nonFinalSuffixHolder?.ihl) {
            return baseReturnValue
        }

        String allomorph = NonFinalSuffixProcessor.tailStartsWithVowel(word) ? "ihl" : "ihs"

        return NonFinalSuffixProcessor.insertBeforeTail(word, allomorph) ?: baseReturnValue
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return ihi
    }
}
