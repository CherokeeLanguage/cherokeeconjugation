package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To See" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.117
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToSee*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToSeeStemsSpec extends VerbBaseSpec {

    static final String VERB = "to see"
    static final String SOURCE_PAGE = "p.117"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-gowt-ih-", tenseForm: "-gowtih-a", tenses: ["PRESENT"]],
            [stem: "-gowt-isg-", tenseForm: "-gowtisg-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-go-h-", tenseForm: "-goh-v'i", tenses: ["REMOTE_PAST", "FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-go-h-", tenseForm: "-goh-i", tenses: ["FUTURE"]],
            [stem: "-gohwaht-Ø-", tenseForm: "-gohwaht-a", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-gowt-vh-", tenseForm: "-gowtvh-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-gowt-ih-", "Present"],
            ["-gowt-isg-", "Present Habitual"],
            ["-go-h-", "Remote Past"],
            ["-go-h-", "Future Imperative/Volative"],
            ["-go-h-", "Future"],
            ["-gohwaht-Ø-", "Immediate Past"],
            ["-gohwaht-Ø-", "Immediate Imperative/Volative"],
            ["-gowt-vh-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToSeePresentSpec.STEM == "-gowt-ih-"
        ToSeePresentSpec.TENSE_FORM == "-gowtih-a"
        ToSeeRemotePastSpec.STEM == "-go-h-"
        ToSeeRemotePastSpec.TENSE_FORM == "-goh-v'i"
        ToSeeFutureSpec.STEM == "-go-h-"
        ToSeeFutureSpec.TENSE_FORM == "-goh-i"
        ToSeeFutureImperativeVolativeSpec.STEM == "-go-h-"
        ToSeeFutureImperativeVolativeSpec.TENSE_FORM == "-goh-v'i"
        ToSeePresentHabitualSpec.STEM == "-gowt-isg-"
        ToSeePresentHabitualSpec.TENSE_FORM == "-gowtisg-o'i"
        ToSeeImmediateImperativeVolativeSpec.STEM == "-gohwaht-Ø-"
        ToSeeImmediateImperativeVolativeSpec.TENSE_FORM == "-gohwaht-a"
        ToSeeImmediatePastSpec.STEM == "-gohwaht-Ø-"
        ToSeeImmediatePastSpec.TENSE_FORM == "-gohwaht-a"
        ToSeeInfinitiveSpec.STEM == "-gowt-vh-"
        ToSeeInfinitiveSpec.TENSE_FORM == "-gowtvh-di"
    }

    def "the six tense forms derive from the five stem entries (five distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-gowt-ih-", "-gowt-isg-", "-go-h-", "-gohwaht-Ø-", "-gowt-vh-"]
    }
}
