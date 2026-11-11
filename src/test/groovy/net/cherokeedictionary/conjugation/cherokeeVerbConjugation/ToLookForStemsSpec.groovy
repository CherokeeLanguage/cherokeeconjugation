package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Look for" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.97
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToLookFor*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToLookForStemsSpec extends Specification {

    static final String VERB = "to look for"
    static final String SOURCE_PAGE = "p.97"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-yo-h-", tenseForm: "-yoh-a", tenses: ["PRESENT"]],
            [stem: "-yo-h-", tenseForm: "-yoh-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-yo-l-", tenseForm: "-yol-v'i", tenses: ["REMOTE_PAST", "FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-yo-l-", tenseForm: "-yol-i", tenses: ["FUTURE"]],
            [stem: "-yo-g-", tenseForm: "-yog-a", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-yo-s-", tenseForm: "-yos-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-yo-h-", "Present"],
            ["-yo-h-", "Present Habitual"],
            ["-yo-l-", "Remote Past"],
            ["-yo-l-", "Future Imperative/Volative"],
            ["-yo-l-", "Future"],
            ["-yo-g-", "Immediate Past"],
            ["-yo-g-", "Immediate Imperative/Volative"],
            ["-yo-s-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToLookForPresentSpec.STEM == "-yo-h-"
        ToLookForPresentSpec.TENSE_FORM == "-yoh-a"
        ToLookForRemotePastSpec.STEM == "-yo-l-"
        ToLookForRemotePastSpec.TENSE_FORM == "-yol-v'i"
        ToLookForFutureSpec.STEM == "-yo-l-"
        ToLookForFutureSpec.TENSE_FORM == "-yol-i"
        ToLookForFutureImperativeVolativeSpec.STEM == "-yo-l-"
        ToLookForFutureImperativeVolativeSpec.TENSE_FORM == "-yol-v'i"
        ToLookForPresentHabitualSpec.STEM == "-yo-h-"
        ToLookForPresentHabitualSpec.TENSE_FORM == "-yoh-o'i"
        ToLookForImmediateImperativeVolativeSpec.STEM == "-yo-g-"
        ToLookForImmediateImperativeVolativeSpec.TENSE_FORM == "-yog-a"
        ToLookForImmediatePastSpec.STEM == "-yo-g-"
        ToLookForImmediatePastSpec.TENSE_FORM == "-yog-a"
        ToLookForInfinitiveSpec.STEM == "-yo-s-"
        ToLookForInfinitiveSpec.TENSE_FORM == "-yos-di"
    }

    def "the six tense forms derive from the five stem entries (four distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-yo-h-", "-yo-l-", "-yo-g-", "-yo-s-"]
    }
}
