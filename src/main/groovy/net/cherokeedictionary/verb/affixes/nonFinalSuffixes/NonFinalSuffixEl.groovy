package net.cherokeedictionary.verb.affixes.nonFinalSuffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.containers.NonFinalSuffixProcessor

/**
 * C6: -el-, dative-benefactive (grammar guide Figure 1 position 6; p.286):
 *
 *   "-el- before vowels, -eh- before the infinitive suffix ... The sequence of
 *    -el- plus -g- plus -a yields -eha (41)"
 *
 *   (39) ᏓᎦᏬᏂᏏ "He will speak" (for someone)   (el- before future -i)
 */
class NonFinalSuffixEl implements Affix {
    String el

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        if (!word?.nonFinalSuffixHolder?.el) {
            return baseReturnValue
        }

        String allomorph
        if (word.tense == Tense.INFINITIVE) {
            allomorph = "eh"
        } else if (word.tense == Tense.PRESENT) {
            // -el- + -g- + -a = -eha (the present's surfaced -ha)
            allomorph = "eh"
        } else if (NonFinalSuffixProcessor.tailStartsWithVowel(word)) {
            allomorph = "el"
        } else {
            allomorph = "eh"
        }

        return NonFinalSuffixProcessor.insertBeforeTail(word, allomorph) ?: baseReturnValue
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return el
    }
}
