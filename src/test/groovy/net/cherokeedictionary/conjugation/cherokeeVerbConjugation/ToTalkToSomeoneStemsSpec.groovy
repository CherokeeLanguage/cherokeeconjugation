package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Talk to Someone" — stem inventory and affix composition.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.127
 * (printed page numbers of the full 164-page document).
 *
 * This is the "how the verb is conjugated by adding affixes" table: each stem of the
 * verb paired with the tense forms built from it. Every tense spec in this package
 * (ToTalkToSomeone*Spec) carries its own copy of the relevant stem/tense-form pair;
 * this spec records the complete inventory in one place.
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToTalkToSomeoneStemsSpec extends Specification {

    static final String VERB = "to talk to someone"
    static final String SOURCE_PAGE = "p.127"

    /**
     * The complete stem table as printed. Each row pairs a verb stem with the
     * tense form(s) conjugated from it:
     *   stem        - the verb stem as printed
     *   tenseForm   - the tense form as printed (stem + affixes)
     *   tenses      - the tense name(s) heading the conjugation tables built from this stem
     */
    static final List<Map> STEMS = [
            [stem: "-ahlinohehd-ih-", tenseForm: "-ahlinohehdih-a", tenses: ["PRESENT"]],
            [stem: "-ahlinohehd-isg-", tenseForm: "-ahlinohehdisg-o'i", tenses: ["PRESENT_HABITUAL"]],
            [stem: "-ahlinohehd-han- / -ahlinohehd-l-", tenseForm: "-ahlinohetl-v'i", tenses: ["REMOTE_PAST"]],
            [stem: "-ahlinohehd-han- / -ahlinohehd-l-", tenseForm: "-ahlinohehtan-v'i", tenses: ["FUTURE_IMPERATIVE_VOLATIVE"]],
            [stem: "-ahlinohehd-han- / -ahlinohehd-l-", tenseForm: "-ahlinohehtan-i", tenses: ["FUTURE"]],
            [stem: "-ahlinohehd-Ø-", tenseForm: "-ahlinohehd-a", tenses: ["IMMEDIATE_PAST", "IMMEDIATE_IMPERATIVE_VOLATIVE"]],
            [stem: "-ahlinohehd-o-", tenseForm: "-ahlinohehdo-di", tenses: ["INFINITIVE"]],
    ]

    /** Expected row order as printed in the verb book (stem, tense name). */
    static final List<List<String>> PRINTED_ORDER = [
            ["-ahlinohehd-ih-", "Present"],
            ["-ahlinohehd-isg-", "Present Habitual"],
            ["-ahlinohehd-han- / -ahlinohehd-l-", "Remote Past"],
            ["-ahlinohehd-han- / -ahlinohehd-l-", "Future Imperative/Volative"],
            ["-ahlinohehd-han- / -ahlinohehd-l-", "Future"],
            ["-ahlinohehd-Ø-", "Immediate Past"],
            ["-ahlinohehd-Ø-", "Immediate Imperative/Volative"],
            ["-ahlinohehd-o-", "Infinitive"],
    ]

    def "every tense has a recorded stem and tense form (#row.tenses.join(', '))"() {
        expect:
        row.stem && row.tenseForm && row.tenses

        where:
        row << STEMS
    }

    def "the tense spec constants match the section tables as printed"() {
        expect: "each section's stem and tense form are mirrored by a dedicated tense spec"
        ToTalkToSomeonePresentSpec.STEM == "-ahlinohehd-ih-"
        ToTalkToSomeonePresentSpec.TENSE_FORM == "-ahlinohehdih-a"
        ToTalkToSomeoneRemotePastSpec.STEM == "-ahlinohehd-han- / -ahlinohehd-l-"
        ToTalkToSomeoneRemotePastSpec.TENSE_FORM == "-ahlinohetl-v'i"
        ToTalkToSomeoneFutureSpec.STEM == "-ahlinohehd-han- / -ahlinohehd-l-"
        ToTalkToSomeoneFutureSpec.TENSE_FORM == "-ahlinohehtan-i"
        ToTalkToSomeoneFutureImperativeVolativeSpec.STEM == "-ahlinohehd-han- / -ahlinohehd-l-"
        ToTalkToSomeoneFutureImperativeVolativeSpec.TENSE_FORM == "-ahlinohehtan-v'i"
        ToTalkToSomeonePresentHabitualSpec.STEM == "-ahlinohehd-isg-"
        ToTalkToSomeonePresentHabitualSpec.TENSE_FORM == "-ahlinohehdisg-o'i"
        ToTalkToSomeoneImmediateImperativeVolativeSpec.STEM == "-ahlinohehd-Ø-"
        ToTalkToSomeoneImmediateImperativeVolativeSpec.TENSE_FORM == "-ahlinohehd-a"
        ToTalkToSomeoneImmediatePastSpec.STEM == "-ahlinohehd-Ø-"
        ToTalkToSomeoneImmediatePastSpec.TENSE_FORM == "-ahlinohehd-a"
        ToTalkToSomeoneInfinitiveSpec.STEM == "-ahlinohehd-o-"
        ToTalkToSomeoneInfinitiveSpec.TENSE_FORM == "-ahlinohehdo-di"
    }

    def "the seven tense forms derive from the five stem entries (five distinct spellings)"() {
        when: "the distinct stems are collected"
        def distinctStems = STEMS*.stem.unique()

        then: "as printed in the verb book"
        distinctStems == ["-ahlinohehd-ih-", "-ahlinohehd-isg-", "-ahlinohehd-han- / -ahlinohehd-l-", "-ahlinohehd-Ø-", "-ahlinohehd-o-"]
    }
}
