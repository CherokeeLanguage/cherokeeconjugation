// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73296 (entrya gvhnisdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GvhnisdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Cooking (A Food)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gvnisdiha'],
            [subject: 'SG1', object: '', present: 'gvnisdiha', habitual: 'gvnisdisgoi', remote_past: 'agwvhnistanvi', imperative: 'gvnisda', infinitive: 'agwvhnisdohdi'],
            [subject: 'SG2', object: '', present: 'hvhnisdiha', habitual: 'hvhnisdisgoi', remote_past: 'jvhnistanvi', imperative: 'hvhnisda', infinitive: 'jvhnisdohdi'],
            [subject: 'SG3', object: '', habitual: 'gvhnisdisgoi', imperative: 'hvhnisda', infinitive: 'uwahnisdohdi', present: 'gvhnisdiha', remote_past: 'uwahnistanvi'],
            [subject: 'PL3', object: '', present: 'anvhnisdiha', habitual: 'anvhnisdisgoi', remote_past: 'unvhnistanvi', imperative: 'anvhnisda', infinitive: 'unvhnisdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idvhnisdiha', habitual: 'idvhnisdisgoi', remote_past: 'igvhnistanvi', imperative: 'idvhnisda', infinitive: 'igvhnisdohdi']
        ]
    ]

    @Unroll
    def "conjugating Gvhnisdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gvhnisdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gvnisdiha"
        "SG1" | "" | Tense.HABITUAL        | "gvnisdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwvhnistanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gvnistanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwvhnisdohdi"
        "SG2" | "" | Tense.PRESENT         | "hvhnisdiha"
        "SG2" | "" | Tense.HABITUAL        | "hvhnisdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jvhnistanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hvnistanvi"
        "SG2" | "" | Tense.INFINITIVE      | "jvhnisdohdi"
        "SG3" | "" | Tense.PRESENT         | "gvhnisdiha"
        "SG3" | "" | Tense.HABITUAL        | "gvhnisdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwahnistanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "vnistanvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwahnisdohdi"
        "PL3" | "" | Tense.PRESENT         | "anvhnisdiha"
        "PL3" | "" | Tense.HABITUAL        | "anvhnisdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unvhnistanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anvnistanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unvhnisdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idvhnisdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idvhnisdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igvhnistanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idvnistanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igvhnisdohdi"
    }
}
