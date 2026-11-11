package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Tell something to someone" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.132
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToTellSomethingToSomeone*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Verb-book notes (as printed):
 *   - "Logically improbable forms are italicized."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToTellSomethingToSomeoneStemsSpec extends Specification {

    static final String VERB = "to tell something to someone"
    static final String SOURCE_PAGE = "p.132"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-nohis-eh-", tenseForm: "-nohiseh-a", tenses: ["PRESENT"]],
            [stem: "-nohis-eh-", tenseForm: "-nohiseh-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-nohis-el-", tenseForm: "-nohisel-v'i", tenses: ["REMOTE_PAST", "FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-nohis-el-", tenseForm: "-nohisel-i", tenses: ["FUTURE"]],
            [stem: "-nohis-Ø-", tenseForm: "-nohis-i", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-nohis-e-", tenseForm: "-nohise-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-nohis-eh-", "Present"],
            ["-nohis-eh-", "Present Habitual"],
            ["-nohis-el-", "Remote Past"],
            ["-nohis-el-", "Future Imperative/Volative"],
            ["-nohis-el-", "Future"],
            ["-nohis-Ø-", "Immediate Past"],
            ["-nohis-Ø-", "Immediate Imperative/Volative"],
            ["-nohis-e-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToTellSomethingToSomeonePresentSpec.STEM == "-nohis-eh-"
        ToTellSomethingToSomeonePresentSpec.TENSE_FORM == "-nohiseh-a"
        ToTellSomethingToSomeoneRemotePastSpec.STEM == "-nohis-el-"
        ToTellSomethingToSomeoneRemotePastSpec.TENSE_FORM == "-nohisel-v'i"
        ToTellSomethingToSomeoneFutureSpec.STEM == "-nohis-el-"
        ToTellSomethingToSomeoneFutureSpec.TENSE_FORM == "-nohisel-i"
        ToTellSomethingToSomeoneFutureImperativeVolativeSpec.STEM == "-nohis-el-"
        ToTellSomethingToSomeoneFutureImperativeVolativeSpec.TENSE_FORM == "-nohisel-v'i"
        ToTellSomethingToSomeonePresentHabitualSpec.STEM == "-nohis-eh-"
        ToTellSomethingToSomeonePresentHabitualSpec.TENSE_FORM == "-nohiseh-o'i"
        ToTellSomethingToSomeoneImmediateImperativeVolativeSpec.STEM == "-nohis-Ø-"
        ToTellSomethingToSomeoneImmediateImperativeVolativeSpec.TENSE_FORM == "-nohis-i"
        ToTellSomethingToSomeoneImmediatePastSpec.STEM == "-nohis-Ø-"
        ToTellSomethingToSomeoneImmediatePastSpec.TENSE_FORM == "-nohis-i"
        ToTellSomethingToSomeoneInfinitiveSpec.STEM == "-nohis-e-"
        ToTellSomethingToSomeoneInfinitiveSpec.TENSE_FORM == "-nohise-di"
    }

    def "the six tense forms derive from the five stem entries (four distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-nohis-eh-", "-nohis-el-", "-nohis-Ø-", "-nohis-e-"]
    }
}
