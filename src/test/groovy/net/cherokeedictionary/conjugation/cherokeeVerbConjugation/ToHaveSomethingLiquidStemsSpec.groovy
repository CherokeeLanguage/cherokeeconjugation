package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Liquid, in a container" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.56
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToHaveSomethingLiquid*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Verb-book notes (as printed):
 *   - "This verb means that the object is physically close to the speaker. If the possessed object is not immediately at hand, use a different verb."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingLiquidStemsSpec extends VerbBaseSpec {

    static final String VERB = "to have something liquid, in a container"
    static final String SOURCE_PAGE = "p.56"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-ne-h-", tenseForm: "-neh-a", tenses: ["PRESENT"]],
            [stem: "-ne-h-", tenseForm: "-neh-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-ne-h-", tenseForm: "-neh-v'i", tenses: ["REMOTE_PAST", "IMMEDIATE_PAST"]],
            [stem: "-ne-h-", tenseForm: "-neh-esdi", tenses: ["FUTURE_IMPERATIVE_VOLATIVE", "FUTURE", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-adita-s-", tenseForm: "-aditas-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-ne-h-", "Present"],
            ["-ne-h-", "Present Habitual"],
            ["-ne-h-", "Remote Past"],
            ["-ne-h-", "Future Imperative/Volative"],
            ["-ne-h-", "Future"],
            ["-ne-h-", "Immediate Past"],
            ["-ne-h-", "Immediate Imperative/Volative"],
            ["-adita-s-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToHaveSomethingLiquidPresentSpec.STEM == "-ne-h-"
        ToHaveSomethingLiquidPresentSpec.TENSE_FORM == "-neh-a"
        ToHaveSomethingLiquidRemotePastSpec.STEM == "-ne-h-"
        ToHaveSomethingLiquidRemotePastSpec.TENSE_FORM == "-neh-v'i"
        ToHaveSomethingLiquidFutureSpec.STEM == "-ne-h-"
        ToHaveSomethingLiquidFutureSpec.TENSE_FORM == "-neh-esdi"
        ToHaveSomethingLiquidFutureImperativeVolativeSpec.STEM == "-ne-h-"
        ToHaveSomethingLiquidFutureImperativeVolativeSpec.TENSE_FORM == "-neh-esdi"
        ToHaveSomethingLiquidPresentHabitualSpec.STEM == "-ne-h-"
        ToHaveSomethingLiquidPresentHabitualSpec.TENSE_FORM == "-neh-o'i"
        ToHaveSomethingLiquidImmediateImperativeVolativeSpec.STEM == "-ne-h-"
        ToHaveSomethingLiquidImmediateImperativeVolativeSpec.TENSE_FORM == "-neh-esdi"
        ToHaveSomethingLiquidImmediatePastSpec.STEM == "-ne-h-"
        ToHaveSomethingLiquidImmediatePastSpec.TENSE_FORM == "-neh-v'i"
        ToHaveSomethingLiquidInfinitiveSpec.STEM == "-adita-s-"
        ToHaveSomethingLiquidInfinitiveSpec.TENSE_FORM == "-aditas-di"
    }

    def "the five tense forms derive from the five stem entries (two distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-ne-h-", "-adita-s-"]
    }
}
