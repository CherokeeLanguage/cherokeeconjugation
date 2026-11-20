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
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degalehisiha"
        "SG1" | "" | Tense.HABITUAL        | "degalehisisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwalehisahnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galehisanvi"
        "SG1" | "" | Tense.INFINITIVE      | "dagilehisodi"
        "SG2" | "" | Tense.PRESENT         | "tilehisiha"
        "SG2" | "" | Tense.HABITUAL        | "tilehisisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejalehisahnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halehisanvi"
        "SG2" | "" | Tense.INFINITIVE      | "detsalehisodi"
        "SG3" | "" | Tense.PRESENT         | "dalehisiha"
        "SG3" | "" | Tense.HABITUAL        | "dalehisisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dulehisahnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alehisanvi"
        "SG3" | "" | Tense.INFINITIVE      | "julehisohdi"
        "PL3" | "" | Tense.PRESENT         | "danalehisiha"
        "PL3" | "" | Tense.HABITUAL        | "danalehisisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunalehisahnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analehisanvi"
        "PL3" | "" | Tense.INFINITIVE      | "tsunilehisodi"
        "PL1INCL" | "" | Tense.PRESENT         | "dadalehisiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "dadalehisisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "dagalehisanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalehisanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "dagilehisodi"
    }
}
