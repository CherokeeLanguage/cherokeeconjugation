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
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gvnisdiha"
        "SG1" | "" | Tense.HABITUAL        | "gvnisdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquvnistanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gvnistanvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquvnisdodi"
        "SG2" | "" | Tense.PRESENT         | "hvnisdiha"
        "SG2" | "" | Tense.HABITUAL        | "hvnisdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsvnistanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hvnistanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsvnisdodi"
        "SG3" | "" | Tense.PRESENT         | "gvnisdiha"
        "SG3" | "" | Tense.HABITUAL        | "gvnisdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwanistanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "vnistanvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwanisdodi"
        "PL3" | "" | Tense.PRESENT         | "anvnisdiha"
        "PL3" | "" | Tense.HABITUAL        | "anvnisdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unanistanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anvnistanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unanisdodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idvnisdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idvnisdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igvnistanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idvnistanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igvnisdodi"
    }
}
