    // tio 20Nov26: SG1/SG2/PL1INCL SG3AN remote_past/infinitive re-pinned to the
    // engine composition per M-A ex. (2b)/(22)/(23b) -- Set A AN prefixes persist into
    // Set B tenses for animate objects (D21 resolution); the inanimate Set B forms
    // (agw-/ja-/igi-) were transcribed into these AN-labeled cells.
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyosdiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Breaking It",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyosdiha', habitual: 'jiyosdisoi', remote_past: 'tsiyosdanvi', imperative: 'jiyosda', infinitive: 'tsiyosdodi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyosdiha', habitual: 'hiyosdisoi', remote_past: 'hiyosdanvi', imperative: 'hiyosda', infinitive: 'hiyosdodi'],
            [subject: 'SG3', object: 'SG3AN', present: 'ayosdiha', habitual: 'ayosdihoi', remote_past: 'uyosdanvi', imperative: 'ayosda', infinitive: 'uyosdohdi'],
            [subject: 'PL3', object: 'SG3AN', present: 'aniyosdiha', habitual: 'aniyosdihoi', remote_past: 'uniyosdanvi', imperative: 'aniyosda', infinitive: 'uniyosdohdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'idiyosdiha', habitual: 'idiyosdihoi', remote_past: 'ediyosdanvi', imperative: 'idiyosda', infinitive: 'ediyosdodi']
        ]
    ]

    @Unroll
    def "conjugating Ayosdi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayosdi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyosdiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyosdisoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyosdanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyosdanvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyosdodi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyosdiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyosdisoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyosdanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyosdanvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyosdodi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "ayosdiha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "ayosdihoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uyosdanvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "ayosdanvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uyosdohdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "aniyosdiha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "aniyosdihoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "uniyosdanvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aniyosdanvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "uniyosdohdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "idiyosdiha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "idiyosdihoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "ediyosdanvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "ediyosdanvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "ediyosdodi"
    }
}
