package net.cherokeedictionary.verb.affixes.nonFinalSuffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.containers.NonFinalSuffixProcessor

/**
 * C6: -ohn-, completive (grammar guide Figure 1 position 5; p.285):
 *
 *   "-ohn- before vowels, -ohvs- before -g- and before the infinitive suffix"
 *
 *   (33) ᎤᏬᏂᏐᏅᎢ "He finished speaking"          (ohnv before -v'i)
 *   (34) ᎦᏬᏂᏐᎯᏍᎦ "He's finishing speaking"      (ohv- before -sga)
 *   (35) ᎤᏬᏂᏐᎯᏍᏗ "He wants to finish speaking"  (ohv- before -sdi)
 */
class NonFinalSuffixOhn implements Affix {
    String ohn

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        if (!word?.nonFinalSuffixHolder?.ohn) {
            return baseReturnValue
        }

        String allomorph
        if (word.tense == Tense.INFINITIVE) {
            allomorph = "ohvs"
        } else if (word.tense == Tense.PRESENT || word.tense == Tense.PROGRESSIVE_PAST || word.tense == Tense.PROGRESSIVE_FUTURE) {
            // before the progressive -g- (surfaced -sga/-sgv'i/-sgesdi): -ohvs-
            allomorph = "ohvs"
        } else if (NonFinalSuffixProcessor.tailStartsWithVowel(word)) {
            allomorph = "ohn"
        } else {
            allomorph = "ohvs"
        }

        return NonFinalSuffixProcessor.insertBeforeTail(word, allomorph) ?: baseReturnValue
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return ohn
    }
}
