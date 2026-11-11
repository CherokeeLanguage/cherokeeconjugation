package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Teach Someone" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.137
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToTeachSomeone*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToTeachSomeoneStemsSpec extends Specification {

    static final String VERB = "to teach someone"
    static final String SOURCE_PAGE = "p.137"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-eyohv-sg-", tenseForm: "-eyohvsg-a", tenses: ["PRESENT"]],
            [stem: "-eyohv-sg-", tenseForm: "-eyohvsg-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-eyoh[v]-n-", tenseForm: "-eyohn-v'i", tenses: ["REMOTE_PAST", "FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-eyoh[v]-n-", tenseForm: "-eyohn-i", tenses: ["FUTURE"]],
            [stem: "-eyohv-g-", tenseForm: "-eyohvg-a", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-eyo-Ø-", tenseForm: "-eyo-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-eyohv-sg-", "Present"],
            ["-eyohv-sg-", "Present Habitual"],
            ["-eyoh[v]-n-", "Remote Past"],
            ["-eyoh[v]-n-", "Future Imperative/Volative"],
            ["-eyoh[v]-n-", "Future"],
            ["-eyohv-g-", "Immediate Past"],
            ["-eyohv-g-", "Immediate Imperative/Volative"],
            ["-eyo-Ø-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToTeachSomeonePresentSpec.STEM == "-eyohv-sg-"
        ToTeachSomeonePresentSpec.TENSE_FORM == "-eyohvsg-a"
        ToTeachSomeoneRemotePastSpec.STEM == "-eyoh[v]-n-"
        ToTeachSomeoneRemotePastSpec.TENSE_FORM == "-eyohn-v'i"
        ToTeachSomeoneFutureSpec.STEM == "-eyoh[v]-n-"
        ToTeachSomeoneFutureSpec.TENSE_FORM == "-eyohn-i"
        ToTeachSomeoneFutureImperativeVolativeSpec.STEM == "-eyoh[v]-n-"
        ToTeachSomeoneFutureImperativeVolativeSpec.TENSE_FORM == "-eyohn-v'i"
        ToTeachSomeonePresentHabitualSpec.STEM == "-eyohv-sg-"
        ToTeachSomeonePresentHabitualSpec.TENSE_FORM == "-eyohvsg-o'i"
        ToTeachSomeoneImmediateImperativeVolativeSpec.STEM == "-eyohv-g-"
        ToTeachSomeoneImmediateImperativeVolativeSpec.TENSE_FORM == "-eyohvg-a"
        ToTeachSomeoneImmediatePastSpec.STEM == "-eyohv-g-"
        ToTeachSomeoneImmediatePastSpec.TENSE_FORM == "-eyohvg-a"
        ToTeachSomeoneInfinitiveSpec.STEM == "-eyo-Ø-"
        ToTeachSomeoneInfinitiveSpec.TENSE_FORM == "-eyo-di"
    }

    def "the six tense forms derive from the five stem entries (four distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-eyohv-sg-", "-eyoh[v]-n-", "-eyohv-g-", "-eyo-Ø-"]
    }
}
