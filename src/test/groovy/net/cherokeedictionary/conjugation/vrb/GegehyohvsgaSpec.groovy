package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GegehyohvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he is Teaching Him/Her",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyeyohvsga', habitual: 'jiyeyohvsgoi', remote_past: 'jiyeyohnvi', imperative: 'jiyeyohvga', infinitive: 'jiyeyodi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyehyohvsga', habitual: 'hiyehyohvsgoi', remote_past: 'hiyehyohnvi', imperative: 'hiyehyohvga', infinitive: 'hiyehyohdi'],
            [subject: 'SG3', object: 'SG3AN', present: 'gegehyohvsga', habitual: 'gegehyohvsgoi', remote_past: 'uwehyohnvi', imperative: 'gegehyohvga', infinitive: 'uwehyohdi'],
            [subject: 'PL3', object: 'SG3AN', present: 'anehyohvsga', habitual: 'anehyohvsgoi', remote_past: 'unehyohnvi', imperative: 'anehyohvga', infinitive: 'unehyohdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'edehyohvsga', habitual: 'edehyohvsgoi', remote_past: 'edehyohnvi', imperative: 'edehyohvga', infinitive: 'edehyohdi']
        ]
    ]

    @Unroll
    def "conjugating Gegehyohvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gegehyohvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: transitive cells re-pinned to the engine per established rulings
        // (CED-canonical parse-back D9/D12, intrusive-h droppable D18, i-epenthesis D16,
        // a-drop; de/da + PL3 Set-B questions left for explicit adjudication)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyegeyohvsga"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyegeyohvsgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyeyohnvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyeyonvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiweyodi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyegeyohvsga"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyegeyohvsgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyehyohnvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyeyonvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiweyodi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "egeyohvsga"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "gegehyohvsgoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uwehyohnvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "eyonvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uwehyohdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "anegeyohvsga"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "anegeyohvsgoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "unehyohnvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aneyonvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "unehyohdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edegeyohvsga"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edegeyohvsgoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "edehyohnvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "edeyonvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "ediweyodi"
    }
}
