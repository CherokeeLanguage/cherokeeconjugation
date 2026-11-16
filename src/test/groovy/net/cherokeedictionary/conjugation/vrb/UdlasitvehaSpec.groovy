// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73749 (entrya udlasitveha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'agwadlasitveha'],
            [subject: 'SG1', object: '', present: 'agwadlasitveha', habitual: 'agwadlasitvehoi', remote_past: 'agwadlasitvelvi', imperative: 'agwadlasitvsi', infinitive: 'agwadlasitvehdi'],
            [subject: 'SG2', object: '', present: 'jadlasitveha', habitual: 'jadlasitvehoi', remote_past: 'jadlasitvelvi', imperative: 'jadlasitvsi', infinitive: 'jadlasitvehdi'],
            [subject: 'SG3', object: '', habitual: 'udlasitvehoi', imperative: 'jadlasitvsi', infinitive: 'udlasitvehdi', present: 'udlasitveha', remote_past: 'udlasitvelvi'],
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
        "SG1" | "" | Tense.PRESENT         | "aquadlasidveha"
        "SG1" | "" | Tense.HABITUAL        | "aquadlasidvehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadlasidvelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquadlasidvelvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadlasidvedi"
        "SG2" | "" | Tense.PRESENT         | "tsadlasidveha"
        "SG2" | "" | Tense.HABITUAL        | "tsadlasidvehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadlasidvelvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsadlasidvelvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadlasidvedi"
        "SG3" | "" | Tense.PRESENT         | "udlasidveha"
        "SG3" | "" | Tense.HABITUAL        | "udlasidvehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udlasidvelvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "udlasidvelvi"
        "SG3" | "" | Tense.INFINITIVE      | "udlasidvedi"
        "PL3" | "" | Tense.PRESENT         | "unadlasidveha"
        "PL3" | "" | Tense.HABITUAL        | "unadlasidvehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadlasidvelvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unadlasidvelvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadlasidvedi"
        "PL1INCL" | "" | Tense.PRESENT         | "igadlasidveha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igadlasidvehoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadlasidvelvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igadlasidvelvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadlasidvedi"
    }
}
