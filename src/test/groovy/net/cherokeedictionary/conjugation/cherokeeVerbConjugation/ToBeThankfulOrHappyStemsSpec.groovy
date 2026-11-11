package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Be Thankful or Happy" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.23
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToBeThankfulOrHappy*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Verb-book notes (as printed):
 *   - "Compare verb "to Thank Someone""
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToBeThankfulOrHappyStemsSpec extends Specification {

    static final String VERB = "to be thankful or happy"
    static final String SOURCE_PAGE = "p.23"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-aliheli-g-", tenseForm: "-alihelig-a", tenses: ["PRESENT"]],
            [stem: "-aliheli-g-", tenseForm: "-alihelig-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-aliheli-ts-", tenseForm: "-alihelits-v'i", tenses: ["REMOTE_PAST"]],
            [stem: "-aliheli-ts-", tenseForm: "alihelits-v'i", tenses: ["FUTURE_IMPERATIVE_VOLATIVE"]],  // the section table prints -alihelits-v'i
            [stem: "-aliheli-ts-", tenseForm: "-alihelits-i", tenses: ["FUTURE"]],
            [stem: "-aliheli-g-", tenseForm: "-alihelig-i", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-aliheli-s-", tenseForm: "-alihelis-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-aliheli-g-", "Present"],
            ["-aliheli-g-", "Present Habitual"],
            ["-aliheli-ts-", "Remote Past"],
            ["-aliheli-ts-", "Future Imperative/Volative"],
            ["-aliheli-ts-", "Future"],
            ["-aliheli-g-", "Immediate Past"],
            ["-aliheli-g-", "Immediate Imperative/Volative"],
            ["-aliheli-s-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToBeThankfulOrHappyPresentSpec.STEM == "-aliheli-g-"
        ToBeThankfulOrHappyPresentSpec.TENSE_FORM == "-alihelig-a"
        ToBeThankfulOrHappyRemotePastSpec.STEM == "-aliheli-ts-"
        ToBeThankfulOrHappyRemotePastSpec.TENSE_FORM == "-alihelits-v'i"
        ToBeThankfulOrHappyFutureSpec.STEM == "-aliheli-ts-"
        ToBeThankfulOrHappyFutureSpec.TENSE_FORM == "-alihelits-i"
        ToBeThankfulOrHappyFutureImperativeVolativeSpec.STEM == "-aliheli-ts-"
        ToBeThankfulOrHappyFutureImperativeVolativeSpec.TENSE_FORM == "-alihelits-v'i"
        ToBeThankfulOrHappyPresentHabitualSpec.STEM == "-aliheli-g-"
        ToBeThankfulOrHappyPresentHabitualSpec.TENSE_FORM == "-alihelig-o'i"
        ToBeThankfulOrHappyImmediateImperativeVolativeSpec.STEM == "-aliheli-g-"
        ToBeThankfulOrHappyImmediateImperativeVolativeSpec.TENSE_FORM == "-alihelig-i"
        ToBeThankfulOrHappyImmediatePastSpec.STEM == "-aliheli-g-"
        ToBeThankfulOrHappyImmediatePastSpec.TENSE_FORM == "-alihelig-i"
        ToBeThankfulOrHappyInfinitiveSpec.STEM == "-aliheli-s-"
        ToBeThankfulOrHappyInfinitiveSpec.TENSE_FORM == "-alihelis-di"
    }

    def "the seven tense forms derive from the five stem entries (three distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-aliheli-g-", "-aliheli-ts-", "-aliheli-s-"]
    }
}
