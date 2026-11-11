package net.cherokeedictionary.verb.affixes.nonFinalSuffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.containers.NonFinalSuffixProcessor

/**
 * C6: -e-, "at intervals" (grammar guide Figure 1 position 8; p.287):
 *
 *   "form: -vs- before vowels and before -di; -e- before -g- ... An exception
 *    is the form -es- which appears before the future tense suffix -i (57) ...
 *    A second exception is the change to -ug- before -a, recent past"
 *
 *   (54b) ᎤᏬᏂᏒᏒᎢ "He spoke at intervals"     (vsv- before -v'i)
 *   (56b) ᎦᏬᏂᏎᎬᎢ "He was speaking at intervals" (e- before -sgv'i)
 *   (57) ᏓᎦᏬᏂᏎᏏ "He will speak at intervals"  (es- before future -i)
 */
class NonFinalSuffixE implements Affix {
    String e

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        if (!word?.nonFinalSuffixHolder?.e) {
            return baseReturnValue
        }

        String allomorph
        if (word.tense == Tense.COMPLETIVE_FUTURE || word.tense == Tense.COMPLETED_FUTURE || word.tense == Tense.FUTURE_EXPECTED) {
            // -es- before the future -i
            allomorph = "es"
        } else if (word.tense == Tense.RECENT_PAST_IMPERATIVE || word.tense == Tense.IMMEDIATE_PAST) {
            // -ug- before -a, recent past
            allomorph = "ug"
        } else if (word.tense == Tense.INFINITIVE) {
            // -vs- before -di
            allomorph = "vs"
        } else if (word.tense == Tense.PRESENT || word.tense == Tense.PROGRESSIVE_PAST || word.tense == Tense.PROGRESSIVE_FUTURE) {
            // -e- before the progressive -g- (surfaced -sga/-sgv'i/-sgesdi)
            allomorph = "e"
        } else if (NonFinalSuffixProcessor.tailStartsWithVowel(word)) {
            allomorph = "vs"
        } else {
            allomorph = "vs"
        }

        return NonFinalSuffixProcessor.insertBeforeTail(word, allomorph) ?: baseReturnValue
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return e
    }
}
