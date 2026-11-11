package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Long and Rigid, like a stick, a shovel, etc." — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.44
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToHaveSomethingLongAndRigid*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Verb-book notes (as printed):
 *   - "This verb means that the object is physically close to the speaker. If the possessed object is not immediately at hand, use a different verb."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingLongAndRigidStemsSpec extends Specification {

    static final String VERB = "to have something long and rigid, like a stick, a shovel, etc."
    static final String SOURCE_PAGE = "p.44"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-vy-Ø-", tenseForm: "-vy-a", tenses: ["PRESENT"]],
            [stem: "-vy-Ø-", tenseForm: "-vy-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-vy-Ø-", tenseForm: "-vy-v'i", tenses: ["REMOTE_PAST", "IMMEDIATE_PAST"]],
            [stem: "-vy-Ø-", tenseForm: "-vy-esdi", tenses: ["FUTURE_IMPERATIVE_VOLATIVE", "FUTURE", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-vy-Ø-", tenseForm: "-vy-i", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-vy-Ø-", "Present"],
            ["-vy-Ø-", "Present Habitual"],
            ["-vy-Ø-", "Remote Past"],
            ["-vy-Ø-", "Future Imperative/Volative"],
            ["-vy-Ø-", "Future"],
            ["-vy-Ø-", "Immediate Past"],
            ["-vy-Ø-", "Immediate Imperative/Volative"],
            ["-vy-Ø-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToHaveSomethingLongAndRigidPresentSpec.STEM == "-vy-Ø-"
        ToHaveSomethingLongAndRigidPresentSpec.TENSE_FORM == "-vy-a"
        ToHaveSomethingLongAndRigidRemotePastSpec.STEM == "-vy-Ø-"
        ToHaveSomethingLongAndRigidRemotePastSpec.TENSE_FORM == "-vy-v'i"
        ToHaveSomethingLongAndRigidFutureSpec.STEM == "-vy-Ø-"
        ToHaveSomethingLongAndRigidFutureSpec.TENSE_FORM == "-vy-esdi"
        ToHaveSomethingLongAndRigidFutureImperativeVolativeSpec.STEM == "-vy-Ø-"
        ToHaveSomethingLongAndRigidFutureImperativeVolativeSpec.TENSE_FORM == "-vy-esdi"
        ToHaveSomethingLongAndRigidPresentHabitualSpec.STEM == "-vy-Ø-"
        ToHaveSomethingLongAndRigidPresentHabitualSpec.TENSE_FORM == "-vy-o'i"
        ToHaveSomethingLongAndRigidImmediateImperativeVolativeSpec.STEM == "-vy-Ø-"
        ToHaveSomethingLongAndRigidImmediateImperativeVolativeSpec.TENSE_FORM == "-vy-esdi"
        ToHaveSomethingLongAndRigidImmediatePastSpec.STEM == "-vy-Ø-"
        ToHaveSomethingLongAndRigidImmediatePastSpec.TENSE_FORM == "-vy-v'i"
        ToHaveSomethingLongAndRigidInfinitiveSpec.STEM == "-vy-Ø-"
        ToHaveSomethingLongAndRigidInfinitiveSpec.TENSE_FORM == "-vy-i"
    }

    def "the five tense forms derive from the five stem entries (one distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-vy-Ø-"]
    }
}
