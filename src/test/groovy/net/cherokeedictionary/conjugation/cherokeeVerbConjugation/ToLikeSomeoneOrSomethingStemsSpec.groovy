package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Like someone or something" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.92
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToLikeSomeoneOrSomething*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToLikeSomeoneOrSomethingStemsSpec extends VerbBaseSpec {

    static final String VERB = "to like someone or something"
    static final String SOURCE_PAGE = "p.92"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-lvgwod-Ø-", tenseForm: "-lvgwod-i / -lvkwd-i", tenses: ["PRESENT"]],
            [stem: "-lvgwod-Ø-", tenseForm: "-lvkwd-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-lvgwod-Ø- / -lvgwod-han-", tenseForm: "-lvkwd-v'i", tenses: ["REMOTE_PAST"]],
            [stem: "-lvgwod-Ø- / -lvgwod-han-", tenseForm: "-lvgwod-a", tenses: ["FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-lvgwod-Ø- / -lvgwod-han-", tenseForm: "-lvgwotan-i", tenses: ["FUTURE"]],
            [stem: "-lvgwod-Ø-", tenseForm: "-lvgwod-i", tenses: ["IMMEDIATE_PAST"]],
            [stem: "-lvgwod-Ø-", tenseForm: "-lvkwd-a", tenses: ["IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-lvgwod-o-", tenseForm: "-lvgwodo-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-lvgwod-Ø-", "Present"],
            ["-lvgwod-Ø-", "Present Habitual"],
            ["-lvgwod-Ø- / -lvgwod-han-", "Remote Past"],
            ["-lvgwod-Ø- / -lvgwod-han-", "Future Imperative/Volative"],
            ["-lvgwod-Ø- / -lvgwod-han-", "Future"],
            ["-lvgwod-Ø-", "Immediate Past"],
            ["-lvgwod-Ø-", "Immediate Imperative/Volative"],
            ["-lvgwod-o-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToLikeSomeoneOrSomethingPresentSpec.STEM == "-lvgwod-Ø-"
        ToLikeSomeoneOrSomethingPresentSpec.TENSE_FORM == "-lvgwod-i / -lvkwd-i"
        ToLikeSomeoneOrSomethingRemotePastSpec.STEM == "-lvgwod-Ø- / -lvgwod-han-"
        ToLikeSomeoneOrSomethingRemotePastSpec.TENSE_FORM == "-lvkwd-v'i"
        ToLikeSomeoneOrSomethingFutureSpec.STEM == "-lvgwod-Ø- / -lvgwod-han-"
        ToLikeSomeoneOrSomethingFutureSpec.TENSE_FORM == "-lvgwotan-i"
        ToLikeSomeoneOrSomethingFutureImperativeVolativeSpec.STEM == "-lvgwod-Ø- / -lvgwod-han-"
        ToLikeSomeoneOrSomethingFutureImperativeVolativeSpec.TENSE_FORM == "-lvgwod-a"
        ToLikeSomeoneOrSomethingPresentHabitualSpec.STEM == "-lvgwod-Ø-"
        ToLikeSomeoneOrSomethingPresentHabitualSpec.TENSE_FORM == "-lvkwd-o'i"
        ToLikeSomeoneOrSomethingImmediateImperativeVolativeSpec.STEM == "-lvgwod-Ø-"
        ToLikeSomeoneOrSomethingImmediateImperativeVolativeSpec.TENSE_FORM == "-lvkwd-a"
        ToLikeSomeoneOrSomethingImmediatePastSpec.STEM == "-lvgwod-Ø-"
        ToLikeSomeoneOrSomethingImmediatePastSpec.TENSE_FORM == "-lvgwod-i"
        ToLikeSomeoneOrSomethingInfinitiveSpec.STEM == "-lvgwod-o-"
        ToLikeSomeoneOrSomethingInfinitiveSpec.TENSE_FORM == "-lvgwodo-di"
    }

    def "the eight tense forms derive from the five stem entries (three distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-lvgwod-Ø-", "-lvgwod-Ø- / -lvgwod-han-", "-lvgwod-o-"]
    }
}
