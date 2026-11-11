package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Want" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.153
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToWant*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Verb-book notes (as printed):
 *   - "When the object is human, there is a sexual connotation."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToWantStemsSpec extends VerbBaseSpec {

    static final String VERB = "to want"
    static final String SOURCE_PAGE = "p.153"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-adul-ih-", tenseForm: "-adulih-a", tenses: ["PRESENT"]],
            [stem: "-adul-ih-", tenseForm: "-adulih-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-adul-vh- / -adul-ih-", tenseForm: "-adulih-v'i", tenses: ["REMOTE_PAST"]],
            [stem: "-adul-vh- / -adul-ih-", tenseForm: "-adulvh-v'i", tenses: ["FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-adul-vh- / -adul-ih-", tenseForm: "-adulvh-i", tenses: ["FUTURE"]],
            [stem: "-adul-Ø-", tenseForm: "-adul-a", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-adul-v-", tenseForm: "-adulv-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-adul-ih-", "Present"],
            ["-adul-ih-", "Present Habitual"],
            ["-adul-vh- / -adul-ih-", "Remote Past"],
            ["-adul-vh- / -adul-ih-", "Future Imperative/Volative"],
            ["-adul-vh- / -adul-ih-", "Future"],
            ["-adul-Ø-", "Immediate Past"],
            ["-adul-Ø-", "Immediate Imperative/Volative"],
            ["-adul-v-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToWantPresentSpec.STEM == "-adul-ih-"
        ToWantPresentSpec.TENSE_FORM == "-adulih-a"
        ToWantRemotePastSpec.STEM == "-adul-vh- / -adul-ih-"
        ToWantRemotePastSpec.TENSE_FORM == "-adulih-v'i"
        ToWantFutureSpec.STEM == "-adul-vh- / -adul-ih-"
        ToWantFutureSpec.TENSE_FORM == "-adulvh-i"
        ToWantFutureImperativeVolativeSpec.STEM == "-adul-vh- / -adul-ih-"
        ToWantFutureImperativeVolativeSpec.TENSE_FORM == "-adulvh-v'i"
        ToWantPresentHabitualSpec.STEM == "-adul-ih-"
        ToWantPresentHabitualSpec.TENSE_FORM == "-adulih-o'i"
        ToWantImmediateImperativeVolativeSpec.STEM == "-adul-Ø-"
        ToWantImmediateImperativeVolativeSpec.TENSE_FORM == "-adul-a"
        ToWantImmediatePastSpec.STEM == "-adul-Ø-"
        ToWantImmediatePastSpec.TENSE_FORM == "-adul-a"
        ToWantInfinitiveSpec.STEM == "-adul-v-"
        ToWantInfinitiveSpec.TENSE_FORM == "-adulv-di"
    }

    def "the seven tense forms derive from the five stem entries (four distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-adul-ih-", "-adul-vh- / -adul-ih-", "-adul-Ø-", "-adul-v-"]
    }
}
