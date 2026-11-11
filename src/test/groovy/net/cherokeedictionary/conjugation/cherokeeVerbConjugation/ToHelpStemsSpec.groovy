package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

import net.cherokeedictionary.util.Tense

/**
 * Verb-book reference spec: "To Help" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.67
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToHelp*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHelpStemsSpec extends Specification {

    static final String VERB = "to help"
    static final String SOURCE_PAGE = "p.67"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-sdeli-h-", tenseForm: "-sdelih-a", tenses: ["PRESENT"]],
            [stem: "-sdeli-sg-", tenseForm: "-sdelisg-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-sdelv-h-", tenseForm: "-sdelvh-v'i", tenses: ["REMOTE_PAST", "FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-sdelv-h-", tenseForm: "-sdelvh-i", tenses: ["FUTURE"]],
            [stem: "-sdel-Ø-", tenseForm: "-sdel-a", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-sdelv-Ø-", tenseForm: "-sdelv-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-sdeli-h-", "Present"],
            ["-sdeli-sg-", "Present Habitual"],
            ["-sdelv-h-", "Remote Past"],
            ["-sdelv-h-", "Future Imperative/Volative"],
            ["-sdelv-h-", "Future"],
            ["-sdel-Ø-", "Immediate Past"],
            ["-sdel-Ø-", "Immediate Imperative/Volative"],
            ["-sdelv-Ø-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToHelpPresentSpec.STEM == "-sdeli-h-"
        ToHelpPresentSpec.TENSE_FORM == "-sdelih-a"
        ToHelpRemotePastSpec.STEM == "-sdelv-h-"
        ToHelpRemotePastSpec.TENSE_FORM == "-sdelvh-v'i"
        ToHelpFutureSpec.STEM == "-sdelv-h-"
        ToHelpFutureSpec.TENSE_FORM == "-sdelvh-i"
        ToHelpFutureImperativeVolativeSpec.STEM == "-sdelv-h-"
        ToHelpFutureImperativeVolativeSpec.TENSE_FORM == "-sdelvh-v'i"
        ToHelpPresentHabitualSpec.STEM == "-sdeli-sg-"
        ToHelpPresentHabitualSpec.TENSE_FORM == "-sdelisg-o'i"
        ToHelpImmediateImperativeVolativeSpec.STEM == "-sdel-Ø-"
        ToHelpImmediateImperativeVolativeSpec.TENSE_FORM == "-sdel-a"
        ToHelpImmediatePastSpec.STEM == "-sdel-Ø-"
        ToHelpImmediatePastSpec.TENSE_FORM == "-sdel-a"
        ToHelpInfinitiveSpec.STEM == "-sdelv-Ø-"
        ToHelpInfinitiveSpec.TENSE_FORM == "-sdelv-di"
    }

    def "the six tense forms derive from the five stem entries (five distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-sdeli-h-", "-sdeli-sg-", "-sdelv-h-", "-sdel-Ø-", "-sdelv-Ø-"]
    }
}
