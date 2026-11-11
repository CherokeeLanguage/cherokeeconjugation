package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Fall (a living being)" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.32
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToFall*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToFallStemsSpec extends Specification {

    static final String VERB = "to fall (a living being)"
    static final String SOURCE_PAGE = "p.32"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-nv-g-", tenseForm: "-nvg-a", tenses: ["PRESENT"]],
            [stem: "-nv-g-", tenseForm: "-nvg-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-nv-ts-", tenseForm: "-nvts-v'i", tenses: ["REMOTE_PAST", "FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-nv-ts-", tenseForm: "-nvts-i", tenses: ["FUTURE"]],
            [stem: "-nv-g-", tenseForm: "-nvg-i", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-nv-'is-", tenseForm: "-nv'is-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-nv-g-", "Present"],
            ["-nv-g-", "Present Habitual"],
            ["-nv-ts-", "Remote Past"],
            ["-nv-ts-", "Future Imperative/Volative"],
            ["-nv-ts-", "Future"],
            ["-nv-g-", "Immediate Past"],
            ["-nv-g-", "Immediate Imperative/Volative"],
            ["-nv-'is-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToFallPresentSpec.STEM == "-nv-g-"
        ToFallPresentSpec.TENSE_FORM == "-nvg-a"
        ToFallRemotePastSpec.STEM == "-nv-ts-"
        ToFallRemotePastSpec.TENSE_FORM == "-nvts-v'i"
        ToFallFutureSpec.STEM == "-nv-ts-"
        ToFallFutureSpec.TENSE_FORM == "-nvts-i"
        ToFallFutureImperativeVolativeSpec.STEM == "-nv-ts-"
        ToFallFutureImperativeVolativeSpec.TENSE_FORM == "-nvts-v'i"
        ToFallPresentHabitualSpec.STEM == "-nv-g-"
        ToFallPresentHabitualSpec.TENSE_FORM == "-nvg-o'i"
        ToFallImmediateImperativeVolativeSpec.STEM == "-nv-g-"
        ToFallImmediateImperativeVolativeSpec.TENSE_FORM == "-nvg-i"
        ToFallImmediatePastSpec.STEM == "-nv-g-"
        ToFallImmediatePastSpec.TENSE_FORM == "-nvg-i"
        ToFallInfinitiveSpec.STEM == "-nv-'is-"
        ToFallInfinitiveSpec.TENSE_FORM == "-nv'is-di"
    }

    def "the six tense forms derive from the five stem entries (three distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-nv-g-", "-nv-ts-", "-nv-'is-"]
    }
}
