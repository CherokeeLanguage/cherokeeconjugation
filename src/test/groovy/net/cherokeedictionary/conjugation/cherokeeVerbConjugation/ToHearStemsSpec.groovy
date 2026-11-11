package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Hear" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.62
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToHear*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHearStemsSpec extends Specification {

    static final String VERB = "to hear"
    static final String SOURCE_PAGE = "p.62"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-atvg-i'-", tenseForm: "-atvgi'-a", tenses: ["PRESENT"]],
            [stem: "-atvg-isg-", tenseForm: "-atvgisg-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-atvg-an-", tenseForm: "-atvgan-v'i", tenses: ["REMOTE_PAST", "FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-atvg-an-", tenseForm: "-atvgan-i", tenses: ["FUTURE"]],
            [stem: "-atvg-vg-", tenseForm: "-atvgvg-a", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-atvg-o-", tenseForm: "-atvgo-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-atvg-i'-", "Present"],
            ["-atvg-isg-", "Present Habitual"],
            ["-atvg-an-", "Remote Past"],
            ["-atvg-an-", "Future Imperative/Volative"],
            ["-atvg-an-", "Future"],
            ["-atvg-vg-", "Immediate Past"],
            ["-atvg-vg-", "Immediate Imperative/Volative"],
            ["-atvg-o-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToHearPresentSpec.STEM == "-atvg-i'-"
        ToHearPresentSpec.TENSE_FORM == "-atvgi'-a"
        ToHearRemotePastSpec.STEM == "-atvg-an-"
        ToHearRemotePastSpec.TENSE_FORM == "-atvgan-v'i"
        ToHearFutureSpec.STEM == "-atvg-an-"
        ToHearFutureSpec.TENSE_FORM == "-atvgan-i"
        ToHearFutureImperativeVolativeSpec.STEM == "-atvg-an-"
        ToHearFutureImperativeVolativeSpec.TENSE_FORM == "-atvgan-v'i"
        ToHearPresentHabitualSpec.STEM == "-atvg-isg-"
        ToHearPresentHabitualSpec.TENSE_FORM == "-atvgisg-o'i"
        ToHearImmediateImperativeVolativeSpec.STEM == "-atvg-vg-"
        ToHearImmediateImperativeVolativeSpec.TENSE_FORM == "-atvgvg-a"
        ToHearImmediatePastSpec.STEM == "-atvg-vg-"
        ToHearImmediatePastSpec.TENSE_FORM == "-atvgvg-a"
        ToHearInfinitiveSpec.STEM == "-atvg-o-"
        ToHearInfinitiveSpec.TENSE_FORM == "-atvgo-di"
    }

    def "the six tense forms derive from the five stem entries (five distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-atvg-i'-", "-atvg-isg-", "-atvg-an-", "-atvg-vg-", "-atvg-o-"]
    }
}
