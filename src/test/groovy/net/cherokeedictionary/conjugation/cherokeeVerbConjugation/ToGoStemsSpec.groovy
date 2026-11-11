package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Go" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.36
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToGo*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToGoStemsSpec extends VerbBaseSpec {

    static final String VERB = "to go"
    static final String SOURCE_PAGE = "p.36"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-e-g-", tenseForm: "-eg-a", tenses: ["PRESENT"]],
            [stem: "-e-g-", tenseForm: "-eg-o'i", tenses: ["PRESENT_HABITUAL"]],  // NB: the Present Habitual is usually Stem II (as printed)
            [stem: "-e-s-", tenseForm: "-es-i", tenses: ["FUTURE_EXPECTED"]],  // NB: the Future is usually Stem III (as printed)
            [stem: "-env-s-", tenseForm: "-envs-v'i", tenses: ["REMOTE_PAST", "FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-e-n-", tenseForm: "-en-a", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-e-nvs-", tenseForm: "-envs-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-e-g-", "Present"],
            ["-e-g-", "Present Habitual"],
            ["-e-s-", "Future"],
            ["-env-s-", "Remote Past"],
            ["-env-s-", "Future Imperative/Volative"],
            ["-e-n-", "Immediate Past"],
            ["-e-n-", "Immediate Imperative/Volative"],
            ["-e-nvs-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToGoPresentSpec.STEM == "-e-g-"
        ToGoPresentSpec.TENSE_FORM == "-eg-a"
        ToGoRemotePastSpec.STEM == "-env-s-"
        ToGoRemotePastSpec.TENSE_FORM == "-envs-v'i"
        ToGoFutureExpectedSpec.STEM == "-e-s-"
        ToGoFutureExpectedSpec.TENSE_FORM == "-es-i"
        ToGoFutureImperativeVolativeSpec.STEM == "-env-s-"
        ToGoFutureImperativeVolativeSpec.TENSE_FORM == "-envs-v'i"
        ToGoPresentHabitualSpec.STEM == "-e-s-"
        ToGoPresentHabitualSpec.TENSE_FORM == "-eg-o'i"
        ToGoImmediateImperativeVolativeSpec.STEM == "-e-n-"
        ToGoImmediateImperativeVolativeSpec.TENSE_FORM == "-en-a"
        ToGoImmediatePastSpec.STEM == "-e-n-"
        ToGoImmediatePastSpec.TENSE_FORM == "-en-a"
        ToGoInfinitiveSpec.STEM == "-e-nvs-"
        ToGoInfinitiveSpec.TENSE_FORM == "-envs-di"
    }

    def "the six tense forms derive from the five stem entries (five distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-e-g-", "-e-s-", "-env-s-", "-e-n-", "-e-nvs-"]
    }
}
