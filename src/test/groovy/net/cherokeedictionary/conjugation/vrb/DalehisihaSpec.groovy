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
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galehisiha"
        "SG1" | "" | Tense.HABITUAL        | "galehisisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aqualehisanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galehisanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agilehisodi"
        "SG2" | "" | Tense.PRESENT         | "halehisiha"
        "SG2" | "" | Tense.HABITUAL        | "halehisisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalehisanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halehisanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsalehisodi"
        "SG3" | "" | Tense.PRESENT         | "dalehisiha"
        "SG3" | "" | Tense.HABITUAL        | "dalehisisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulehisanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alehisanvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulehisodi"
        "PL3" | "" | Tense.PRESENT         | "analehisiha"
        "PL3" | "" | Tense.HABITUAL        | "analehisisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalehisanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analehisanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unilehisodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idalehisiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalehisisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalehisanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalehisanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igilehisodi"
    }
}
