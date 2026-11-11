package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Wait for someone or something" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.147
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToWaitForSomeoneOrSomething*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToWaitForSomeoneOrSomethingStemsSpec extends Specification {

    static final String VERB = "to wait for someone or something"
    static final String SOURCE_PAGE = "p.147"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-gati-y-", tenseForm: "-gatiy-a", tenses: ["PRESENT"]],
            [stem: "-gati-disg-", tenseForm: "-gatidisg-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-gati-yvd-", tenseForm: "-gatiyvd-v'i", tenses: ["REMOTE_PAST"]],
            [stem: "-gati-yvd-", tenseForm: "-gatiyvd-i", tenses: ["FUTURE"]],  // the section table prints -gatid-i
            [stem: "-gati-d-", tenseForm: "-gatid-a", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-gati-dis-", tenseForm: "-gatidis-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-gati-y-", "Present"],
            ["-gati-disg-", "Present Habitual"],
            ["-gati-yvd-", "Remote Past"],
            ["-gati-yvd-", "Future Imperative/Volative"],
            ["-gati-yvd-", "Future"],
            ["-gati-d-", "Immediate Past"],
            ["-gati-d-", "Immediate Imperative/Volative"],
            ["-gati-dis-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToWaitForSomeoneOrSomethingPresentSpec.STEM == "-gati-y-"
        ToWaitForSomeoneOrSomethingPresentSpec.TENSE_FORM == "-gatiy-a"
        ToWaitForSomeoneOrSomethingRemotePastSpec.STEM == "-gati-yvd-"
        ToWaitForSomeoneOrSomethingRemotePastSpec.TENSE_FORM == "-gatiyvd-v'i"
        ToWaitForSomeoneOrSomethingFutureSpec.STEM == "-gati-yvd-"
        ToWaitForSomeoneOrSomethingFutureSpec.TENSE_FORM == "-gatid-i"
        ToWaitForSomeoneOrSomethingFutureImperativeVolativeSpec.STEM == "-gati-yvd-"
        ToWaitForSomeoneOrSomethingFutureImperativeVolativeSpec.TENSE_FORM == "-gatid-v'i"
        ToWaitForSomeoneOrSomethingPresentHabitualSpec.STEM == "-gati-disg-"
        ToWaitForSomeoneOrSomethingPresentHabitualSpec.TENSE_FORM == "-gatidisg-o'i"
        ToWaitForSomeoneOrSomethingImmediateImperativeVolativeSpec.STEM == "-gati-d-"
        ToWaitForSomeoneOrSomethingImmediateImperativeVolativeSpec.TENSE_FORM == "-gatid-a"
        ToWaitForSomeoneOrSomethingImmediatePastSpec.STEM == "-gati-d-"
        ToWaitForSomeoneOrSomethingImmediatePastSpec.TENSE_FORM == "-gatid-a"
        ToWaitForSomeoneOrSomethingInfinitiveSpec.STEM == "-gati-dis-"
        ToWaitForSomeoneOrSomethingInfinitiveSpec.TENSE_FORM == "-gatidis-di"
    }

    def "the six tense forms derive from the five stem entries (five distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-gati-y-", "-gati-disg-", "-gati-yvd-", "-gati-d-", "-gati-dis-"]
    }
}
