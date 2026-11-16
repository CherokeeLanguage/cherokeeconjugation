// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73509 (entrya kdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Using",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gvdiha'],
            [subject: 'SG1', object: '', present: 'gvdiha', habitual: 'gvdisgoi', remote_past: 'aktanvi', imperative: 'gvda', infinitive: 'akhdohdi'],
            [subject: 'SG2', object: '', present: 'hvdiha', habitual: 'hvdisgoi', remote_past: 'jvtanvi', imperative: '/', infinitive: 'tstanvi'],
            [subject: 'SG3', object: '', habitual: 'kdisgoi', imperative: 'hvhda', infinitive: 'uwhdohdi', present: 'kdiha', remote_past: 'uwhtanvi'],
            [subject: 'PL3', object: '', present: 'anvdiha', habitual: 'anvdisgoi', remote_past: 'unvtanvi', imperative: 'anvhda', infinitive: 'unvhdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idvdiha', habitual: 'idvdisgoi', remote_past: 'iktanvi', imperative: 'idvhda', infinitive: 'ikhdohdi']
        ]
    ]

    @Unroll
    def "conjugating Kdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsigidiha"
        "SG1" | "" | Tense.HABITUAL        | "tsigidisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquuwetanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "guwetanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwedodi"
        "SG2" | "" | Tense.PRESENT         | "higidiha"
        "SG2" | "" | Tense.HABITUAL        | "higidisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsuwetanvi"
        // "SG2" | "" | Tense.FUTURE_COMMAND      | "huwetanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawedodi"
        "SG3" | "" | Tense.PRESENT         | "gidiha"
        "SG3" | "" | Tense.HABITUAL        | "gidisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwuwetanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwetanvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwedodi"
        "PL3" | "" | Tense.PRESENT         | "anigidiha"
        "PL3" | "" | Tense.HABITUAL        | "anigidisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unuwetanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anuwetanvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwedodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idigidiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idigidisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iguwetanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iduwetanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwedodi"
    }
}
