package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Thank someone" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.142
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToThankSomeone*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Verb-book notes (as printed):
 *   - "Logically impossible forms are italicized."
 *   - "Compare to the verb "to be Thankful.""
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToThankSomeoneStemsSpec extends Specification {

    static final String VERB = "to thank someone"
    static final String SOURCE_PAGE = "p.142"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-alihelitse-h-", tenseForm: "-alihelitseh-a", tenses: ["PRESENT"]],
            [stem: "-alihelitse-h-", tenseForm: "-alihelitseh-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-alihelitse-l-", tenseForm: "-alihelitsel-v'i", tenses: ["REMOTE_PAST", "FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-alihelitse-l-", tenseForm: "-alihelitsel-i", tenses: ["FUTURE"]],
            [stem: "-alihelits[e]-is-", tenseForm: "-alihelitsis-i", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-alihelitse-Ø-", tenseForm: "-alihelitse-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-alihelitse-h-", "Present"],
            ["-alihelitse-h-", "Present Habitual"],
            ["-alihelitse-l-", "Remote Past"],
            ["-alihelitse-l-", "Future Imperative/Volative"],
            ["-alihelitse-l-", "Future"],
            ["-alihelits[e]-is-", "Immediate Past"],
            ["-alihelits[e]-is-", "Immediate Imperative/Volative"],
            ["-alihelitse-Ø-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToThankSomeonePresentSpec.STEM == "-alihelitse-h-"
        ToThankSomeonePresentSpec.TENSE_FORM == "-alihelitseh-a"
        ToThankSomeoneRemotePastSpec.STEM == "-alihelitse-l-"
        ToThankSomeoneRemotePastSpec.TENSE_FORM == "-alihelitsel-v'i"
        ToThankSomeoneFutureSpec.STEM == "-alihelitse-l-"
        ToThankSomeoneFutureSpec.TENSE_FORM == "-alihelitsel-i"
        ToThankSomeoneFutureImperativeVolativeSpec.STEM == "-alihelitse-l-"
        ToThankSomeoneFutureImperativeVolativeSpec.TENSE_FORM == "-alihelitsel-v'i"
        ToThankSomeonePresentHabitualSpec.STEM == "-alihelitse-h-"
        ToThankSomeonePresentHabitualSpec.TENSE_FORM == "-alihelitseh-o'i"
        ToThankSomeoneImmediateImperativeVolativeSpec.STEM == "-alihelits[e]-is-"
        ToThankSomeoneImmediateImperativeVolativeSpec.TENSE_FORM == "-alihelitsis-i"
        ToThankSomeoneImmediatePastSpec.STEM == "-alihelits[e]-is-"
        ToThankSomeoneImmediatePastSpec.TENSE_FORM == "-alihelitsis-i"
        ToThankSomeoneInfinitiveSpec.STEM == "-alihelitse-Ø-"
        ToThankSomeoneInfinitiveSpec.TENSE_FORM == "-alihelitse-di"
    }

    def "the six tense forms derive from the five stem entries (four distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-alihelitse-h-", "-alihelitse-l-", "-alihelits[e]-is-", "-alihelitse-Ø-"]
    }
}
