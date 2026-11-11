package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Remember" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.112
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToRemember*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToRememberStemsSpec extends Specification {

    static final String VERB = "to remember"
    static final String SOURCE_PAGE = "p.112"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-anvdadi-'-", tenseForm: "-anvdadi'-a", tenses: ["PRESENT"]],
            [stem: "-anvdadi-sg-", tenseForm: "-anvdadisg-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-anvdad-Ø-", tenseForm: "-anvdadisg-v'i", tenses: ["REMOTE_PAST"]],  // the section table prints -anvdad-v'i
            [stem: "-anvdad-Ø-", tenseForm: "-anvdad-v'i", tenses: ["FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-anvdad-Ø-", tenseForm: "-anvdad-i", tenses: ["FUTURE"]],
            [stem: "-anvdad-Ø-", tenseForm: "-anvdad-a", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-anvdadi-s-", tenseForm: "-anvdadis-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-anvdadi-'-", "Present"],
            ["-anvdadi-sg-", "Present Habitual"],
            ["-anvdad-Ø-", "Remote Past"],
            ["-anvdad-Ø-", "Future Imperative/Volative"],
            ["-anvdad-Ø-", "Future"],
            ["-anvdad-Ø-", "Immediate Past"],
            ["-anvdad-Ø-", "Immediate Imperative/Volative"],
            ["-anvdadi-s-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToRememberPresentSpec.STEM == "-anvdadi-'-"
        ToRememberPresentSpec.TENSE_FORM == "-anvdadi'-a"
        ToRememberRemotePastSpec.STEM == "-anvdad-Ø-"
        ToRememberRemotePastSpec.TENSE_FORM == "-anvdad-v'i"
        ToRememberFutureSpec.STEM == "-anvdad-Ø-"
        ToRememberFutureSpec.TENSE_FORM == "-anvdad-i"
        ToRememberFutureImperativeVolativeSpec.STEM == "-anvdad-Ø-"
        ToRememberFutureImperativeVolativeSpec.TENSE_FORM == "-anvdad-v'i"
        ToRememberPresentHabitualSpec.STEM == "-anvdadi-sg-"
        ToRememberPresentHabitualSpec.TENSE_FORM == "-anvdadisg-o'i"
        ToRememberImmediateImperativeVolativeSpec.STEM == "-anvdad-Ø-"
        ToRememberImmediateImperativeVolativeSpec.TENSE_FORM == "-anvdad-a"
        ToRememberImmediatePastSpec.STEM == "-anvdad-Ø-"
        ToRememberImmediatePastSpec.TENSE_FORM == "-anvdad-a"
        ToRememberInfinitiveSpec.STEM == "-anvdadi-s-"
        ToRememberInfinitiveSpec.TENSE_FORM == "-anvdadis-di"
    }

    def "the seven tense forms derive from the five stem entries (four distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-anvdadi-'-", "-anvdadi-sg-", "-anvdad-Ø-", "-anvdadi-s-"]
    }
}
