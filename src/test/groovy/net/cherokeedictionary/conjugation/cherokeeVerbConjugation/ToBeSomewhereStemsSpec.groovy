package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Be Somewhere" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations Single Entry (Durbin Feeling verb book), p.19.
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToBeSomewhere*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToBeSomewhereStemsSpec extends VerbBaseSpec {

    static final String VERB = "to be somewhere"
    static final String SOURCE_PAGE = "p.19"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-edo-h-",    tenseForm: "-edoh-a",    tenses: ["PRESENT"]],
            [stem: "-edo-h-",    tenseForm: "-edoh-o'i",  tenses: ["PRESENT_HABITUAL"]],
            [stem: "-edo-h-",    tenseForm: "-edoh-v'i",  tenses: ["REMOTE_PAST"]],
            [stem: "-edo-h-",    tenseForm: "edoh-esdi",  tenses: ["FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-edo-h-",    tenseForm: "-edoh-esdi", tenses: ["FUTURE"]],
            [stem: "-ed[o]-Ø-",  tenseForm: "-ed-a",      tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-ed[o]-as-", tenseForm: "-edas-di",   tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-edo-h-", "Present"],
            ["-edo-h-", "Present Habitual"],
            ["-edo-h-", "Remote Past"],
            ["-edo-h-", "Future Imperative/Volative"],
            ["-edo-h-", "Future"],
            ["-ed[o]-Ø-", "Immediate Past"],
            ["-ed[o]-Ø-", "Immediate Imperative/Volative"],
            ["-ed[o]-as-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec tables agree with the stem table"() {
        expect: "each stem/tenseForm pair is mirrored by a dedicated tense spec"
        ToBeSomewherePresentSpec.TENSE_FORM == "-edoh-a"
        ToBeSomewherePresentHabitualSpec.TENSE_FORM == "-edoh-o'i"
        ToBeSomewhereRemotePastSpec.TENSE_FORM == "-edoh-v'i"
        ToBeSomewhereFutureSpec.TENSE_FORM == "-edoh-esdi"
        ToBeSomewhereFutureImperativeVolativeSpec.TENSE_FORM == "edoh-esdi"
        ToBeSomewhereImmediatePastSpec.TENSE_FORM == "-ed-a"
        ToBeSomewhereImmediateImperativeVolativeSpec.TENSE_FORM == "-ed-a"
        ToBeSomewhereInfinitiveSpec.TENSE_FORM == "-edas-di"
    }

    def "the seven tense forms derive from the five stem entries (three distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "Stems I-III share -edo-h-, so five verb-book stems yield three distinct spellings"
        distinctStems == ["-edo-h-", "-ed[o]-Ø-", "-ed[o]-as-"]
    }
}
