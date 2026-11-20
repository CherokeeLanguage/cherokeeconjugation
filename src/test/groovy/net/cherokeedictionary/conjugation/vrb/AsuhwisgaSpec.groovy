// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72637 (entrya asuhwisga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsuhwisgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Painting / Coloring",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jisuhwisga'],
            [subject: 'SG1', object: '', present: 'jisuhwisga', habitual: 'jisuhwisgoi', remote_past: 'aksuhwisvi', imperative: 'jisuhwa', infinitive: 'aksuhwisdi'],
            [subject: 'SG2', object: '', present: 'hisuhwisga', habitual: 'hisuhwisgoi', remote_past: 'jasuhwisvi', imperative: 'hisuhwa', infinitive: 'jasuhwisdi'],
            [subject: 'SG3', object: '', habitual: 'asuhwisgoi', imperative: 'hisuhwa', infinitive: 'usuhwisdi', present: 'asuhwisga', remote_past: 'usuhwisvi'],
            [subject: 'PL3', object: '', present: 'anisuhwisga', habitual: 'anisuhwisgoi', remote_past: 'unsuhwisvi', imperative: 'anisuhwa', infinitive: 'unsuhwisdi'],
            [subject: 'PL1INCL', object: '', present: 'idisuhwisga', habitual: 'idisuhwisgoi', remote_past: 'iksuhwisvi', imperative: 'idisuhwa', infinitive: 'iksuhwisdi']
        ]
    ]

    @Unroll
    def "conjugating Asuhwisga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asuhwisga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jisuhwisga"
        "SG1" | "" | Tense.HABITUAL        | "jisuhwisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aksuhwisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisuwisvi"
        "SG1" | "" | Tense.INFINITIVE      | "aksuhwisdi"
        "SG2" | "" | Tense.PRESENT         | "hisuhwisga"
        "SG2" | "" | Tense.HABITUAL        | "hisuhwisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jasuhwisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisuwisvi"
        "SG2" | "" | Tense.INFINITIVE      | "jasuhwisdi"
        "SG3" | "" | Tense.PRESENT         | "asuhwisga"
        "SG3" | "" | Tense.HABITUAL        | "asuhwisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usuhwisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asuwisvi"
        "SG3" | "" | Tense.INFINITIVE      | "usuhwisdi"
        "PL3" | "" | Tense.PRESENT         | "anisuhwisga"
        "PL3" | "" | Tense.HABITUAL        | "anisuhwisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unsuhwisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisuwisvi"
        "PL3" | "" | Tense.INFINITIVE      | "unsuhwisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisuhwisga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisuhwisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iksuhwisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisuwisvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iksuhwisdi"
    }
}
