package net.cherokeedictionary.verb.affixes.nonFinalSuffixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.affixes.Affix
import net.cherokeedictionary.verb.containers.NonFinalSuffixProcessor

/**
 * C6: -idol-, "around" (grammar guide Figure 1 position 7; pp.286-287):
 *
 *   "The sequence -idol- plus the infinitive suffix -di yields -idoh- (50) ...
 *    Before -a, imperative, and -a, recent past, -idol- becomes id- (51-52)"
 *
 *   (50) ᎤᏬᏂᏏᏓᏍᏗ "He wants to go around speaking" (ido- before -sdi)
 *   (51) ᎯᏬᏂᏏᏓ "Go around speaking!"              (id- before -a)
 *   (53) ᎦᏬᏂᏏᏙᎭ "He is going around speaking"     (idol- before -ha)
 */
class NonFinalSuffixIdol implements Affix {
    String idol

    @Override
    String toSyllabary(String baseReturnValue, Verb word) {
        if (!word?.nonFinalSuffixHolder?.idol) {
            return baseReturnValue
        }

        String allomorph
        if (word.tense == Tense.INFINITIVE) {
            // -idol- + infinitive -di = -idohdi: insert -idoh-, tail supplies -di
            allomorph = "idoh"
        } else if (word.tense == Tense.IMMEDIATE_COMMAND || word.tense == Tense.RECENT_PAST_IMPERATIVE || word.tense == Tense.IMMEDIATE_PAST) {
            // -id- before the imperative / recent past -a
            allomorph = "id"
        } else if (NonFinalSuffixProcessor.tailStartsWithVowel(word)) {
            allomorph = "idol"
        } else {
            allomorph = "idol"
        }

        return NonFinalSuffixProcessor.insertBeforeTail(word, allomorph) ?: baseReturnValue
    }

    @Override
    String toEnglish(String baseReturnValue, Verb word) {
        return null
    }

    String toString() {
        return idol
    }
}
