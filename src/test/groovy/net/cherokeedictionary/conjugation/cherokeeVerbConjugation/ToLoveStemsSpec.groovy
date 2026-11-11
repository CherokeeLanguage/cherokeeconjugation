package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Love" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.102
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToLove*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToLoveStemsSpec extends Specification {

    static final String VERB = "to love"
    static final String SOURCE_PAGE = "p.102"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-geyu-h-", tenseForm: "-geyuh-a", tenses: ["PRESENT"]],
            [stem: "-geyu-s-", tenseForm: "-geyus-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-geyu-s-", tenseForm: "-geyus-v'i", tenses: ["REMOTE_PAST", "FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-geyu-s-", tenseForm: "-geyus-esdi", tenses: ["FUTURE"]],
            [stem: "-geyuhv-g-", tenseForm: "-geyuhvg-a", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-geyu-h-", tenseForm: "-geyh-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-geyu-h-", "Present"],
            ["-geyu-s-", "Present Habitual"],
            ["-geyu-s-", "Remote Past"],
            ["-geyu-s-", "Future Imperative/Volative"],
            ["-geyu-s-", "Future"],
            ["-geyuhv-g-", "Immediate Past"],
            ["-geyuhv-g-", "Immediate Imperative/Volative"],
            ["-geyu-h-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToLovePresentSpec.STEM == "-geyu-h-"
        ToLovePresentSpec.TENSE_FORM == "-geyuh-a"
        ToLoveRemotePastSpec.STEM == "-geyu-s-"
        ToLoveRemotePastSpec.TENSE_FORM == "-geyus-v'i"
        ToLoveFutureSpec.STEM == "-geyu-s-"
        ToLoveFutureSpec.TENSE_FORM == "-geyus-esdi"
        ToLoveFutureImperativeVolativeSpec.STEM == "-geyu-s-"
        ToLoveFutureImperativeVolativeSpec.TENSE_FORM == "-geyus-v'i"
        ToLovePresentHabitualSpec.STEM == "-geyu-s-"
        ToLovePresentHabitualSpec.TENSE_FORM == "-geyus-o'i"
        ToLoveImmediateImperativeVolativeSpec.STEM == "-geyuhv-g-"
        ToLoveImmediateImperativeVolativeSpec.TENSE_FORM == "-geyuhvg-a"
        ToLoveImmediatePastSpec.STEM == "-geyuhv-g-"
        ToLoveImmediatePastSpec.TENSE_FORM == "-geyuhvg-a"
        ToLoveInfinitiveSpec.STEM == "-geyu-h-"
        ToLoveInfinitiveSpec.TENSE_FORM == "-geyh-di"
    }

    def "the six tense forms derive from the five stem entries (three distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-geyu-h-", "-geyu-s-", "-geyuhv-g-"]
    }
}
