package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Stop someone or something" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.122
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToStopSomeoneOrSomething*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToStopSomeoneOrSomethingStemsSpec extends Specification {

    static final String VERB = "to stop someone or something"
    static final String SOURCE_PAGE = "p.122"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-alehwisdod-ih-", tenseForm: "-alehwisdodih-a", tenses: ["PRESENT"]],
            [stem: "-alehwisdod-isg-", tenseForm: "-alehwisdodisg-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-alehwisdod-han-", tenseForm: "-alehwisdotan-v'i", tenses: ["REMOTE_PAST", "FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-alehwisdod-han-", tenseForm: "-alehwisdotan-i", tenses: ["FUTURE"]],
            [stem: "-alehwisdod-Ø-", tenseForm: "-alehwisdod-a", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-alehwisdod-o-", tenseForm: "-alehwisdodo-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-alehwisdod-ih-", "Present"],
            ["-alehwisdod-isg-", "Present Habitual"],
            ["-alehwisdod-han-", "Remote Past"],
            ["-alehwisdod-han-", "Future Imperative/Volative"],
            ["-alehwisdod-han-", "Future"],
            ["-alehwisdod-Ø-", "Immediate Past"],
            ["-alehwisdod-Ø-", "Immediate Imperative/Volative"],
            ["-alehwisdod-o-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToStopSomeoneOrSomethingPresentSpec.STEM == "-alehwisdod-ih-"
        ToStopSomeoneOrSomethingPresentSpec.TENSE_FORM == "-alehwisdodih-a"
        ToStopSomeoneOrSomethingRemotePastSpec.STEM == "-alehwisdod-han-"
        ToStopSomeoneOrSomethingRemotePastSpec.TENSE_FORM == "-alehwisdotan-v'i"
        ToStopSomeoneOrSomethingFutureSpec.STEM == "-alehwisdod-han-"
        ToStopSomeoneOrSomethingFutureSpec.TENSE_FORM == "-alehwisdotan-i"
        ToStopSomeoneOrSomethingFutureImperativeVolativeSpec.STEM == "-alehwisdod-han-"
        ToStopSomeoneOrSomethingFutureImperativeVolativeSpec.TENSE_FORM == "-alehwisdotan-v'i"
        ToStopSomeoneOrSomethingPresentHabitualSpec.STEM == "-alehwisdod-isg-"
        ToStopSomeoneOrSomethingPresentHabitualSpec.TENSE_FORM == "-alehwisdodisg-o'i"
        ToStopSomeoneOrSomethingImmediateImperativeVolativeSpec.STEM == "-alehwisdod-Ø-"
        ToStopSomeoneOrSomethingImmediateImperativeVolativeSpec.TENSE_FORM == "-alehwisdod-a"
        ToStopSomeoneOrSomethingImmediatePastSpec.STEM == "-alehwisdod-Ø-"
        ToStopSomeoneOrSomethingImmediatePastSpec.TENSE_FORM == "-alehwisdod-a"
        ToStopSomeoneOrSomethingInfinitiveSpec.STEM == "-alehwisdod-o-"
        ToStopSomeoneOrSomethingInfinitiveSpec.TENSE_FORM == "-alehwisdodo-di"
    }

    def "the six tense forms derive from the five stem entries (five distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-alehwisdod-ih-", "-alehwisdod-isg-", "-alehwisdod-han-", "-alehwisdod-Ø-", "-alehwisdod-o-"]
    }
}
