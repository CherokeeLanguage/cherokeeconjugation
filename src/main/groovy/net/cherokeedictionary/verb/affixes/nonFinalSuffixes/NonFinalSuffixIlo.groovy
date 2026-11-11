package net.cherokeedictionary.verb.affixes.nonFinalSuffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.StringUtility
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.containers.NonFinalSuffixProcessor

/**
 * C6: -ilo-, repetitive (grammar guide Figure 1 position 3; pp.283):
 *
 *   "-ilo- before vowels, with a glottal stop inserted; -ilos- before
 *    consonants ... -ilo- changes to -iloj- before the imperative suffix -a"
 *
 *   (20b) ᎤᏬᏂᏎᎶᎡᎢ "He reportedly spoke over and over"
 *   (21b) ᎦᏬᏂᏎᎶᏍᎬᎢ "He was speaking repeatedly"   (ilos before sgv'i)
 *   (22b) ᎯᏬᏂᏏᎶᏣ "Speak repeatedly!"             (iloj before -a)
 */
class NonFinalSuffixIlo implements Affix {
    String ilo

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        if (!word?.nonFinalSuffixHolder?.ilo) {
            return baseReturnValue
        }

        String allomorph
        if (word.tense == Tense.IMMEDIATE_COMMAND || word.tense == Tense.RECENT_PAST_IMPERATIVE) {
            allomorph = "iloj"
        } else if (NonFinalSuffixProcessor.tailStartsWithVowel(word)) {
            allomorph = "ilo"
        } else {
            allomorph = "ilos"
        }

        return NonFinalSuffixProcessor.insertBeforeTail(word, allomorph) ?: baseReturnValue
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return ilo
    }
}
