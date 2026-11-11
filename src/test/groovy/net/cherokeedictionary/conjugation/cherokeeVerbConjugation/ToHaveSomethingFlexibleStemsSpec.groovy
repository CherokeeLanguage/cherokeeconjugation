package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Flexible" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.50
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToHaveSomethingFlexible*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Verb-book notes (as printed):
 *   - "This verb means that the object is physically close to the speaker."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingFlexibleStemsSpec extends VerbBaseSpec {

    static final String VERB = "to have something flexible"
    static final String SOURCE_PAGE = "p.50"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-na-'-", tenseForm: "-na'-a", tenses: ["PRESENT"]],
            [stem: "-na-'-", tenseForm: "-na'-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-na-'-", tenseForm: "-na'-v'i", tenses: ["REMOTE_PAST", "IMMEDIATE_PAST"]],
            [stem: "-na-'-", tenseForm: "-na'-esdi", tenses: ["FUTURE_IMPERATIVE_VOLATIVE", "FUTURE", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-nv-Ø-", tenseForm: "-nv-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-na-'-", "Present"],
            ["-na-'-", "Present Habitual"],
            ["-na-'-", "Remote Past"],
            ["-na-'-", "Future Imperative/Volative"],
            ["-na-'-", "Future"],
            ["-na-'-", "Immediate Past"],
            ["-na-'-", "Immediate Imperative/Volative"],
            ["-nv-Ø-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToHaveSomethingFlexiblePresentSpec.STEM == "-na-'-"
        ToHaveSomethingFlexiblePresentSpec.TENSE_FORM == "-na'-a"
        ToHaveSomethingFlexibleRemotePastSpec.STEM == "-na-'-"
        ToHaveSomethingFlexibleRemotePastSpec.TENSE_FORM == "-na'-v'i"
        ToHaveSomethingFlexibleFutureSpec.STEM == "-na-'-"
        ToHaveSomethingFlexibleFutureSpec.TENSE_FORM == "-na'-esdi"
        ToHaveSomethingFlexibleFutureImperativeVolativeSpec.STEM == "-na-'-"
        ToHaveSomethingFlexibleFutureImperativeVolativeSpec.TENSE_FORM == "-na'-esdi"
        ToHaveSomethingFlexiblePresentHabitualSpec.STEM == "-na-'-"
        ToHaveSomethingFlexiblePresentHabitualSpec.TENSE_FORM == "-na'-o'i"
        ToHaveSomethingFlexibleImmediateImperativeVolativeSpec.STEM == "-na-'-"
        ToHaveSomethingFlexibleImmediateImperativeVolativeSpec.TENSE_FORM == "-na'-esdi"
        ToHaveSomethingFlexibleImmediatePastSpec.STEM == "-na-'-"
        ToHaveSomethingFlexibleImmediatePastSpec.TENSE_FORM == "-na'-v'i"
        ToHaveSomethingFlexibleInfinitiveSpec.STEM == "-nv-Ø-"
        ToHaveSomethingFlexibleInfinitiveSpec.TENSE_FORM == "-nv-di"
    }

    def "the five tense forms derive from the five stem entries (two distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-na-'-", "-nv-Ø-"]
    }
}
