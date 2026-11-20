// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72785 (entrya dalehisiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DalehisihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Recuperating",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'degaleisiha'],
            [subject: 'SG1', object: '', present: 'degaleisiha', habitual: 'degalehisisgoi', remote_past: 'dagwalehisahnvi', imperative: 'digalehisa', infinitive: 'digwalehisohdi'],
            [subject: 'SG2', object: '', present: 'dehaleisiha', habitual: 'dehalehisisgoi', remote_past: 'dejalehisahnvi', imperative: 'talehisa', infinitive: 'dijalehisohdi'],
            [subject: 'SG3', object: '', habitual: 'dalehisisgoi', imperative: 'talehisa', infinitive: 'julehisohdi', present: 'dalehisiha', remote_past: 'dulehisahnvi'],
            [subject: 'PL3', object: '', present: 'danaleisiha', habitual: 'danalehisisgoi', remote_past: 'dunalehisahnvi', imperative: 'dinalehisa', infinitive: 'junalehisohdi'],
            [subject: 'PL1INCL', object: '', present: 'dedaleisiha', habitual: 'dedalehisisgoi', remote_past: 'degalehisahnvi', imperative: 'didalehisa', infinitive: 'digalehisohdi']
        ]
    ]

    @Unroll
    def "conjugating Dalehisiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dalehisiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degaleisiha"
        "SG1" | "" | Tense.HABITUAL        | "degalehisisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwalehisahnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galehisanvi"
        "SG1" | "" | Tense.INFINITIVE      | "digwalehisohdi"
        "SG2" | "" | Tense.PRESENT         | "dehaleisiha"
        "SG2" | "" | Tense.HABITUAL        | "dehalehisisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejalehisahnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halehisanvi"
        "SG2" | "" | Tense.INFINITIVE      | "dijalehisohdi"
        "SG3" | "" | Tense.PRESENT         | "dalehisiha"
        "SG3" | "" | Tense.HABITUAL        | "dalehisisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dulehisahnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alehisanvi"
        "SG3" | "" | Tense.INFINITIVE      | "julehisohdi"
        "PL3" | "" | Tense.PRESENT         | "danaleisiha"
        "PL3" | "" | Tense.HABITUAL        | "danalehisisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunalehisahnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analehisanvi"
        "PL3" | "" | Tense.INFINITIVE      | "junalehisohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedaleisiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedalehisisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degalehisahnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalehisanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digalehisohdi"
    }
}
