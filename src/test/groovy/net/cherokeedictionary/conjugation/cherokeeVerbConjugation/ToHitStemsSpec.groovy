package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Hit" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.77
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToHit*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHitStemsSpec extends VerbBaseSpec {

    static final String VERB = "to hit"
    static final String SOURCE_PAGE = "p.77"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-vhni-h-", tenseForm: "-vhnih-a", tenses: ["PRESENT"]],
            [stem: "-vhni-h-", tenseForm: "-vhnih-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-vhni-l-", tenseForm: "-vhnil-v'i", tenses: ["REMOTE_PAST", "FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-vhni-l-", tenseForm: "-vhnil-i", tenses: ["FUTURE"]],
            [stem: "-vhni-g-", tenseForm: "-vhnig-a", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-vhni-s-", tenseForm: "-vhns-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-vhni-h-", "Present"],
            ["-vhni-h-", "Present Habitual"],
            ["-vhni-l-", "Remote Past"],
            ["-vhni-l-", "Future Imperative/Volative"],
            ["-vhni-l-", "Future"],
            ["-vhni-g-", "Immediate Past"],
            ["-vhni-g-", "Immediate Imperative/Volative"],
            ["-vhni-s-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToHitPresentSpec.STEM == "-vhni-h-"
        ToHitPresentSpec.TENSE_FORM == "-vhnih-a"
        ToHitRemotePastSpec.STEM == "-vhni-l-"
        ToHitRemotePastSpec.TENSE_FORM == "-vhnil-v'i"
        ToHitFutureSpec.STEM == "-vhni-l-"
        ToHitFutureSpec.TENSE_FORM == "-vhnil-i"
        ToHitFutureImperativeVolativeSpec.STEM == "-vhni-l-"
        ToHitFutureImperativeVolativeSpec.TENSE_FORM == "-vhnil-v'i"
        ToHitPresentHabitualSpec.STEM == "-vhni-h-"
        ToHitPresentHabitualSpec.TENSE_FORM == "-vhnih-o'i"
        ToHitImmediateImperativeVolativeSpec.STEM == "-vhni-g-"
        ToHitImmediateImperativeVolativeSpec.TENSE_FORM == "-vhnig-a"
        ToHitImmediatePastSpec.STEM == "-vhni-g-"
        ToHitImmediatePastSpec.TENSE_FORM == "-vhnig-a"
        ToHitInfinitiveSpec.STEM == "-vhni-s-"
        ToHitInfinitiveSpec.TENSE_FORM == "-vhns-di"
    }

    def "the six tense forms derive from the five stem entries (four distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-vhni-h-", "-vhni-l-", "-vhni-g-", "-vhni-s-"]
    }
}
