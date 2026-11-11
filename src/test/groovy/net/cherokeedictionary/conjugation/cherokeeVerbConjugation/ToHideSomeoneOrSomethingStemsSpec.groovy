package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Hide someone or something" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.72
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToHideSomeoneOrSomething*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHideSomeoneOrSomethingStemsSpec extends Specification {

    static final String VERB = "to hide someone or something"
    static final String SOURCE_PAGE = "p.72"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-vsgalv'v-sg- / -vsgahlv-sg-", tenseForm: "-vsgalv'vsg-a / -vsgahlvsg-a", tenses: ["PRESENT"]],
            [stem: "-vsgahlv-sg-", tenseForm: "-vsgahlvsg-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-vsgahla-n-", tenseForm: "-vsgahlan-v'i", tenses: ["REMOTE_PAST", "FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-vsgahla-n-", tenseForm: "-vsgahlan-i", tenses: ["FUTURE"]],
            [stem: "-vsgahlv-g-", tenseForm: "-vsgahlvg-a", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-vsgalv-Ø-", tenseForm: "-vsgalv-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-vsgalv'v-sg- / -vsgahlv-sg-", "Present"],
            ["-vsgahlv-sg-", "Present Habitual"],
            ["-vsgahla-n-", "Remote Past"],
            ["-vsgahla-n-", "Future Imperative/Volative"],
            ["-vsgahla-n-", "Future"],
            ["-vsgahlv-g-", "Immediate Past"],
            ["-vsgahlv-g-", "Immediate Imperative/Volative"],
            ["-vsgalv-Ø-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToHideSomeoneOrSomethingPresentSpec.STEM == "-vsgalv'v-sg- / -vsgahlv-sg-"
        ToHideSomeoneOrSomethingPresentSpec.TENSE_FORM == "-vsgalv'vsg-a / -vsgahlvsg-a"
        ToHideSomeoneOrSomethingRemotePastSpec.STEM == "-vsgahla-n-"
        ToHideSomeoneOrSomethingRemotePastSpec.TENSE_FORM == "-vsgahlan-v'i"
        ToHideSomeoneOrSomethingFutureSpec.STEM == "-vsgahla-n-"
        ToHideSomeoneOrSomethingFutureSpec.TENSE_FORM == "-vsgahlan-i"
        ToHideSomeoneOrSomethingFutureImperativeVolativeSpec.STEM == "-vsgahla-n-"
        ToHideSomeoneOrSomethingFutureImperativeVolativeSpec.TENSE_FORM == "-vsgahlan-v'i"
        ToHideSomeoneOrSomethingPresentHabitualSpec.STEM == "-vsgahlv-sg-"
        ToHideSomeoneOrSomethingPresentHabitualSpec.TENSE_FORM == "-vsgahlvsg-o'i"
        ToHideSomeoneOrSomethingImmediateImperativeVolativeSpec.STEM == "-vsgahlv-g-"
        ToHideSomeoneOrSomethingImmediateImperativeVolativeSpec.TENSE_FORM == "-vsgahlvg-a"
        ToHideSomeoneOrSomethingImmediatePastSpec.STEM == "-vsgahlv-g-"
        ToHideSomeoneOrSomethingImmediatePastSpec.TENSE_FORM == "-vsgahlvg-a"
        ToHideSomeoneOrSomethingInfinitiveSpec.STEM == "-vsgalv-Ø-"
        ToHideSomeoneOrSomethingInfinitiveSpec.TENSE_FORM == "-vsgalv-di"
    }

    def "the six tense forms derive from the five stem entries (five distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-vsgalv'v-sg- / -vsgahlv-sg-", "-vsgahlv-sg-", "-vsgahla-n-", "-vsgahlv-g-", "-vsgalv-Ø-"]
    }
}
