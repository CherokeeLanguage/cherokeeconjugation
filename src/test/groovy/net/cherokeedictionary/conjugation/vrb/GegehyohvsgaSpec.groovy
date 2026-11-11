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
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyeyohvsga"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyeyohvsgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyeyohnvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyeyohvga"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyeyodi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyehyohvsga"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyehyohvsgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyehyohnvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyehyohvga"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyehyohdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "gegehyohvsga"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "gegehyohvsgoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uwehyohnvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "gegehyohvga"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uwehyohdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "anehyohvsga"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "anehyohvsgoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "unehyohnvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "anehyohvga"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "unehyohdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edehyohvsga"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edehyohvsgoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "edehyohnvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "edehyohvga"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "edehyohdi"
    }
}
