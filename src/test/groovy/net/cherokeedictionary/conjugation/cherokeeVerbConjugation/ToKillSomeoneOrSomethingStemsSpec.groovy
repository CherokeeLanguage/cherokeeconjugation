package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Kill someone or something" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.87
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToKillSomeoneOrSomething*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Verb-book notes (as printed):
 *   - "Logically impossible forms are italicized."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToKillSomeoneOrSomethingStemsSpec extends Specification {

    static final String VERB = "to kill someone or something"
    static final String SOURCE_PAGE = "p.87"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-h-ih-", tenseForm: "-hih-a", tenses: ["PRESENT"]],
            [stem: "-h-ih-", tenseForm: "-hih-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-(t)l-Ø-", tenseForm: "-(t)l-v'i", tenses: ["REMOTE_PAST", "FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-(t)l-Ø-", tenseForm: "-(t)l-i", tenses: ["FUTURE"]],
            [stem: "-l-ug-", tenseForm: "-lug-a", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-h-is-", tenseForm: "-his-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-h-ih-", "Present"],
            ["-h-ih-", "Present Habitual"],
            ["-(t)l-Ø-", "Remote Past"],
            ["-(t)l-Ø-", "Future Imperative/Volative"],
            ["-(t)l-Ø-", "Future"],
            ["-l-ug-", "Immediate Past"],
            ["-l-ug-", "Immediate Imperative/Volative"],
            ["-h-is-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToKillSomeoneOrSomethingPresentSpec.STEM == "-h-ih-"
        ToKillSomeoneOrSomethingPresentSpec.TENSE_FORM == "-hih-a"
        ToKillSomeoneOrSomethingRemotePastSpec.STEM == "-(t)l-Ø-"
        ToKillSomeoneOrSomethingRemotePastSpec.TENSE_FORM == "-(t)l-v'i"
        ToKillSomeoneOrSomethingFutureSpec.STEM == "-(t)l-Ø-"
        ToKillSomeoneOrSomethingFutureSpec.TENSE_FORM == "-(t)l-i"
        ToKillSomeoneOrSomethingFutureImperativeVolativeSpec.STEM == "-(t)l-Ø-"
        ToKillSomeoneOrSomethingFutureImperativeVolativeSpec.TENSE_FORM == "-(t)l-v'i"
        ToKillSomeoneOrSomethingPresentHabitualSpec.STEM == "-h-ih-"
        ToKillSomeoneOrSomethingPresentHabitualSpec.TENSE_FORM == "-hih-o'i"
        ToKillSomeoneOrSomethingImmediateImperativeVolativeSpec.STEM == "-l-ug-"
        ToKillSomeoneOrSomethingImmediateImperativeVolativeSpec.TENSE_FORM == "-lug-a"
        ToKillSomeoneOrSomethingImmediatePastSpec.STEM == "-l-ug-"
        ToKillSomeoneOrSomethingImmediatePastSpec.TENSE_FORM == "-lug-a"
        ToKillSomeoneOrSomethingInfinitiveSpec.STEM == "-h-is-"
        ToKillSomeoneOrSomethingInfinitiveSpec.TENSE_FORM == "-his-di"
    }

    def "the six tense forms derive from the five stem entries (four distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-h-ih-", "-(t)l-Ø-", "-l-ug-", "-h-is-"]
    }
}
