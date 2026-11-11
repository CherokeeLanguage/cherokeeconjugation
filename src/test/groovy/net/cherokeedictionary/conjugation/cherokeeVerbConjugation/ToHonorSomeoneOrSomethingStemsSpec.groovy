package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Honor Someone or Something" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.82
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToHonorSomeoneOrSomething*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Verb-book notes (as printed):
 *   - "This verb connotes positive sentiment between the subject and the object in addition to honor."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHonorSomeoneOrSomethingStemsSpec extends Specification {

    static final String VERB = "to honor someone or something"
    static final String SOURCE_PAGE = "p.82"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-lvgwod-ih-", tenseForm: "-lvgwodih-a / -lvkwdih-a", tenses: ["PRESENT"]],
            [stem: "-lvgwod-isg-", tenseForm: "-lvgwodisg-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-lvgwod-han-", tenseForm: "-lvgwotan-v'i", tenses: ["REMOTE_PAST", "FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-lvgwod-han-", tenseForm: "-lvgwotan-i", tenses: ["FUTURE"]],
            [stem: "-lvgwod-Ø-", tenseForm: "-lvgwod-a", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-lvgwod-o-", tenseForm: "-lvgwodo-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-lvgwod-ih-", "Present"],
            ["-lvgwod-isg-", "Present Habitual"],
            ["-lvgwod-han-", "Remote Past"],
            ["-lvgwod-han-", "Future Imperative/Volative"],
            ["-lvgwod-han-", "Future"],
            ["-lvgwod-Ø-", "Immediate Past"],
            ["-lvgwod-Ø-", "Immediate Imperative/Volative"],
            ["-lvgwod-o-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToHonorSomeoneOrSomethingPresentSpec.STEM == "-lvgwod-ih-"
        ToHonorSomeoneOrSomethingPresentSpec.TENSE_FORM == "-lvgwodih-a / -lvkwdih-a"
        ToHonorSomeoneOrSomethingRemotePastSpec.STEM == "-lvgwod-han-"
        ToHonorSomeoneOrSomethingRemotePastSpec.TENSE_FORM == "-lvgwotan-v'i"
        ToHonorSomeoneOrSomethingFutureSpec.STEM == "-lvgwod-han-"
        ToHonorSomeoneOrSomethingFutureSpec.TENSE_FORM == "-lvgwotan-i"
        ToHonorSomeoneOrSomethingFutureImperativeVolativeSpec.STEM == "-lvgwod-han-"
        ToHonorSomeoneOrSomethingFutureImperativeVolativeSpec.TENSE_FORM == "-lvgwotan-v'i"
        ToHonorSomeoneOrSomethingPresentHabitualSpec.STEM == "-lvgwod-isg-"
        ToHonorSomeoneOrSomethingPresentHabitualSpec.TENSE_FORM == "-lvgwodisg-o'i"
        ToHonorSomeoneOrSomethingImmediateImperativeVolativeSpec.STEM == "-lvgwod-Ø-"
        ToHonorSomeoneOrSomethingImmediateImperativeVolativeSpec.TENSE_FORM == "-lvgwod-a"
        ToHonorSomeoneOrSomethingImmediatePastSpec.STEM == "-lvgwod-Ø-"
        ToHonorSomeoneOrSomethingImmediatePastSpec.TENSE_FORM == "-lvgwod-a"
        ToHonorSomeoneOrSomethingInfinitiveSpec.STEM == "-lvgwod-o-"
        ToHonorSomeoneOrSomethingInfinitiveSpec.TENSE_FORM == "-lvgwodo-di"
    }

    def "the six tense forms derive from the five stem entries (five distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-lvgwod-ih-", "-lvgwod-isg-", "-lvgwod-han-", "-lvgwod-Ø-", "-lvgwod-o-"]
    }
}
