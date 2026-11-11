package net.cherokeedictionary.verb.affixes.nonFinalSuffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.containers.NonFinalSuffixProcessor

/**
 * C6: -dohdan-, unintentional (grammar guide Figure 1 position 4; p.285):
 *
 *   "-dohdan- before vowels, -dohdis- before -g-; ... -dohdan- plus -g- plus
 *    -a yields -dohdih- (30); -dohdan- plus the infinitive suffix -di yields
 *    -dohdi (31); -dohdan- plus -a, imperative, yields -dohda (32)"
 *
 *   (30) ᎠᎪᏩᏛᏙᎭ "He's seeing it accidentally"     (dohdi- before -ha)
 *   (31) ᎤᎪᏩᏛᏙᏗ "He wants him to see it accidentally" (doh- before -di)
 *   (32) ᎯᏬᏂᎯᏍᏙᏓ "Speak unintentionally"           (dohd- before -a)
 */
class NonFinalSuffixDohdan implements Affix {
    String dohdan

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        if (!word?.nonFinalSuffixHolder?.dohdan) {
            return baseReturnValue
        }

        String allomorph
        if (word.tense == Tense.INFINITIVE) {
            // -dohdan- + infinitive -di = -dohdi: insert -doh-, the -di comes from the tail
            allomorph = "doh"
        } else if (word.tense == Tense.IMMEDIATE_COMMAND || word.tense == Tense.RECENT_PAST_IMPERATIVE) {
            // -dohda before the imperative -a: insert -dohd-, tail supplies -a
            allomorph = "dohd"
        } else if (word.tense == Tense.PRESENT) {
            // -dohdis- + -g- + -a = -dohdih- (the present's surfaced -ha)
            allomorph = "dohdi"
        } else if (NonFinalSuffixProcessor.tailStartsWithVowel(word)) {
            allomorph = "dohdan"
        } else {
            allomorph = "dohdis"
        }

        return NonFinalSuffixProcessor.insertBeforeTail(word, allomorph) ?: baseReturnValue
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return dohdan
    }
}
