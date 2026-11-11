package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Watch" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.159
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToWatch*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToWatchStemsSpec extends Specification {

    static final String VERB = "to watch"
    static final String SOURCE_PAGE = "p.159"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-agasesd-Ø-", tenseForm: "-agasesd-i", tenses: ["PRESENT"]],
            [stem: "-agasesd-isg-", tenseForm: "-agasesdisg-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-agasesd-han-", tenseForm: "-agasestan-v'i", tenses: ["REMOTE_PAST", "FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-agasesd-han-", tenseForm: "-agasestan-i", tenses: ["FUTURE"]],
            [stem: "-agasesd-Ø-", tenseForm: "-agasesd-a", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-agasesd-o-", tenseForm: "-agasesdo-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-agasesd-Ø-", "Present"],
            ["-agasesd-isg-", "Present Habitual"],
            ["-agasesd-han-", "Remote Past"],
            ["-agasesd-han-", "Future Imperative/Volative"],
            ["-agasesd-han-", "Future"],
            ["-agasesd-Ø-", "Immediate Past"],
            ["-agasesd-Ø-", "Immediate Imperative/Volative"],
            ["-agasesd-o-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToWatchPresentSpec.STEM == "-agasesd-Ø-"
        ToWatchPresentSpec.TENSE_FORM == "-agasesd-i"
        ToWatchRemotePastSpec.STEM == "-agasesd-han-"
        ToWatchRemotePastSpec.TENSE_FORM == "-agasestan-v'i"
        ToWatchFutureSpec.STEM == "-agasesd-han-"
        ToWatchFutureSpec.TENSE_FORM == "-agasestan-i"
        ToWatchFutureImperativeVolativeSpec.STEM == "-agasesd-han-"
        ToWatchFutureImperativeVolativeSpec.TENSE_FORM == "-agasestan-v'i"
        ToWatchPresentHabitualSpec.STEM == "-agasesd-isg-"
        ToWatchPresentHabitualSpec.TENSE_FORM == "-agasesdisg-o'i"
        ToWatchImmediateImperativeVolativeSpec.STEM == "-agasesd-Ø-"
        ToWatchImmediateImperativeVolativeSpec.TENSE_FORM == "-agasesd-a"
        ToWatchImmediatePastSpec.STEM == "-agasesd-Ø-"
        ToWatchImmediatePastSpec.TENSE_FORM == "-agasesd-a"
        ToWatchInfinitiveSpec.STEM == "-agasesd-o-"
        ToWatchInfinitiveSpec.TENSE_FORM == "-agasesdo-di"
    }

    def "the six tense forms derive from the five stem entries (four distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-agasesd-Ø-", "-agasesd-isg-", "-agasesd-han-", "-agasesd-o-"]
    }
}
