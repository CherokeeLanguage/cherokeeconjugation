package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Point Something Out" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.107
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToPointSomethingOut*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Verb-book notes (as printed):
 *   - "This form indicates pointing something out or showing something to a person or group."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToPointSomethingOutStemsSpec extends Specification {

    static final String VERB = "to point something out"
    static final String SOURCE_PAGE = "p.107"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-asehe-h-", tenseForm: "-aseheh-a", tenses: ["PRESENT"]],
            [stem: "-asehe-h-", tenseForm: "-aseheh-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-asehe-l-", tenseForm: "-asehel-v'i", tenses: ["REMOTE_PAST", "FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-asehe-l-", tenseForm: "-asehel-i", tenses: ["FUTURE"]],
            [stem: "-asehi-s-", tenseForm: "-asehis-i", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-asehe-h-", tenseForm: "-aseheh-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-asehe-h-", "Present"],
            ["-asehe-h-", "Present Habitual"],
            ["-asehe-l-", "Remote Past"],
            ["-asehe-l-", "Future Imperative/Volative"],
            ["-asehe-l-", "Future"],
            ["-asehi-s-", "Immediate Past"],
            ["-asehi-s-", "Immediate Imperative/Volative"],
            ["-asehe-h-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToPointSomethingOutPresentSpec.STEM == "-asehe-h-"
        ToPointSomethingOutPresentSpec.TENSE_FORM == "-aseheh-a"
        ToPointSomethingOutRemotePastSpec.STEM == "-asehe-l-"
        ToPointSomethingOutRemotePastSpec.TENSE_FORM == "-asehel-v'i"
        ToPointSomethingOutFutureSpec.STEM == "-asehe-l-"
        ToPointSomethingOutFutureSpec.TENSE_FORM == "-asehel-i"
        ToPointSomethingOutFutureImperativeVolativeSpec.STEM == "-asehe-l-"
        ToPointSomethingOutFutureImperativeVolativeSpec.TENSE_FORM == "-asehel-v'i"
        ToPointSomethingOutPresentHabitualSpec.STEM == "-asehe-h-"
        ToPointSomethingOutPresentHabitualSpec.TENSE_FORM == "-aseheh-o'i"
        ToPointSomethingOutImmediateImperativeVolativeSpec.STEM == "-asehi-s-"
        ToPointSomethingOutImmediateImperativeVolativeSpec.TENSE_FORM == "-asehis-i"
        ToPointSomethingOutImmediatePastSpec.STEM == "-asehi-s-"
        ToPointSomethingOutImmediatePastSpec.TENSE_FORM == "-asehis-i"
        ToPointSomethingOutInfinitiveSpec.STEM == "-asehe-h-"
        ToPointSomethingOutInfinitiveSpec.TENSE_FORM == "-aseheh-di"
    }

    def "the six tense forms derive from the five stem entries (three distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-asehe-h-", "-asehe-l-", "-asehi-s-"]
    }
}
