package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UdlasitvehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Disbelieving (161)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agwadlasitveha', habitual: 'agwadlasitvehoi', remote_past: 'agwadlasitvelvi', imperative: 'agwadlasitvsi', infinitive: 'agwadlasitvehdi'],
            [subject: 'SG2', object: '', present: 'jadlasitveha', habitual: 'jadlasitvehoi', remote_past: 'jadlasitvelvi', imperative: 'jadlasitvsi', infinitive: 'jadlasitvehdi'],
            [subject: 'SG3', object: '', present: 'udlasitveha', habitual: 'udlasitvehoi', remote_past: 'udlasitvelvi', imperative: 'udlasitvsi', infinitive: 'udlasitvehdi'],
            [subject: 'PL3', object: '', present: 'unadlasitveha', habitual: 'unadlasitvehoi', remote_past: 'unadlasitvelvi', imperative: 'unadlasitvsi', infinitive: 'unadlasitvehdi'],
            [subject: 'PL1INCL', object: '', present: 'igadlasitveha', habitual: 'igadlasitvehoi', remote_past: 'igadlasitvelvi', imperative: 'igadlasitvsi', infinitive: 'igadlasitvehdi']
        ]
    ]

    @Unroll
    def "conjugating Udlasitveha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Udlasitveha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwadlasitveha"
        "SG1" | "" | Tense.HABITUAL        | "agwadlasitvehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadlasitvelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwadlasitvsi"
        "SG1" | "" | Tense.INFINITIVE      | "agwadlasitvehdi"
        "SG2" | "" | Tense.PRESENT         | "jadlasitveha"
        "SG2" | "" | Tense.HABITUAL        | "jadlasitvehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadlasitvelvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jadlasitvsi"
        "SG2" | "" | Tense.INFINITIVE      | "jadlasitvehdi"
        "SG3" | "" | Tense.PRESENT         | "udlasitveha"
        "SG3" | "" | Tense.HABITUAL        | "udlasitvehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udlasitvelvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "udlasitvsi"
        "SG3" | "" | Tense.INFINITIVE      | "udlasitvehdi"
        "PL3" | "" | Tense.PRESENT         | "unadlasitveha"
        "PL3" | "" | Tense.HABITUAL        | "unadlasitvehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadlasitvelvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unadlasitvsi"
        "PL3" | "" | Tense.INFINITIVE      | "unadlasitvehdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igadlasitveha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igadlasitvehoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadlasitvelvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igadlasitvsi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadlasitvehdi"
    }
}
