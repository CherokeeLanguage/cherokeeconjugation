package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Bite (when a human bites)" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.27
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToBite*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Verb-book notes (as printed):
 *   - "Use Class B prefixes when an animal does the biting."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToBiteStemsSpec extends Specification {

    static final String VERB = "to bite (when a human bites)"
    static final String SOURCE_PAGE = "p.27"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-sgahl-g-", tenseForm: "-sgahlg-a", tenses: ["PRESENT"]],
            [stem: "-sgahl-g-", tenseForm: "-sgahlg-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-sgahl-its-", tenseForm: "-sgahlits-v'i", tenses: ["REMOTE_PAST", "FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-sgahl-its-", tenseForm: "-sgahlits-i", tenses: ["FUTURE"]],
            [stem: "-sgahl-Ø-", tenseForm: "-sgal-a", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-sgahl-s-", tenseForm: "-sgahls-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-sgahl-g-", "Present"],
            ["-sgahl-g-", "Present Habitual"],
            ["-sgahl-its-", "Remote Past"],
            ["-sgahl-its-", "Future Imperative/Volative"],
            ["-sgahl-its-", "Future"],
            ["-sgahl-Ø-", "Immediate Past"],
            ["-sgahl-Ø-", "Immediate Imperative/Volative"],
            ["-sgahl-s-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToBitePresentSpec.STEM == "-sgahl-g-"
        ToBitePresentSpec.TENSE_FORM == "-sgahlg-a"
        ToBiteRemotePastSpec.STEM == "-sgahl-its-"
        ToBiteRemotePastSpec.TENSE_FORM == "-sgahlits-v'i"
        ToBiteFutureSpec.STEM == "-sgahl-its-"
        ToBiteFutureSpec.TENSE_FORM == "-sgahlits-i"
        ToBiteFutureImperativeVolativeSpec.STEM == "-sgahl-its-"
        ToBiteFutureImperativeVolativeSpec.TENSE_FORM == "-sgahlits-v'i"
        ToBitePresentHabitualSpec.STEM == "-sgahl-g-"
        ToBitePresentHabitualSpec.TENSE_FORM == "-sgahlg-o'i"
        ToBiteImmediateImperativeVolativeSpec.STEM == "-sgahl-Ø-"
        ToBiteImmediateImperativeVolativeSpec.TENSE_FORM == "-sgal-a"
        ToBiteImmediatePastSpec.STEM == "-sgahl-Ø-"
        ToBiteImmediatePastSpec.TENSE_FORM == "-sgal-a"
        ToBiteInfinitiveSpec.STEM == "-sgahl-s-"
        ToBiteInfinitiveSpec.TENSE_FORM == "-sgahls-di"
    }

    def "the six tense forms derive from the five stem entries (four distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-sgahl-g-", "-sgahl-its-", "-sgahl-Ø-", "-sgahl-s-"]
    }
}
