// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72688 (entrya atuisdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtuisdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Promising",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jituisdiha'],
            [subject: 'SG1', object: '', present: 'jituisdiha', habitual: 'jituisdisgoi', remote_past: 'aktuistanvi', imperative: 'jituisda', infinitive: 'aktuisdohdi'],
            [subject: 'SG2', object: '', present: 'hituisdiha', habitual: 'hituisdisgoi', remote_past: 'tstuistanvi', imperative: 'hituisda', infinitive: 'tstuisdohdi'],
            [subject: 'SG3', object: '', habitual: 'atuisdisgoi', imperative: 'hituisda', infinitive: 'utuisdohdi', present: 'atuisdiha', remote_past: 'utuistanvi'],
            [subject: 'PL3', object: '', present: 'anituisdiha', habitual: 'anituisdisgoi', remote_past: 'untuistanvi', imperative: 'anituisda', infinitive: 'untuisdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idituisdiha', habitual: 'idituisdisgoi', remote_past: 'iktuistanvi', imperative: 'idituisda', infinitive: 'iktuisdohdi']
        ]
    ]

    @Unroll
    def "conjugating Atuisdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atuisdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jituisdiha"
        "SG1" | "" | Tense.HABITUAL        | "jituisdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aktuistanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiduistanvi"
        "SG1" | "" | Tense.INFINITIVE      | "aktuisdohdi"
        "SG2" | "" | Tense.PRESENT         | "hituisdiha"
        "SG2" | "" | Tense.HABITUAL        | "hituisdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tstuistanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiduistanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tstuisdohdi"
        "SG3" | "" | Tense.PRESENT         | "atuisdiha"
        "SG3" | "" | Tense.HABITUAL        | "atuisdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utuistanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "aduistanvi"
        "SG3" | "" | Tense.INFINITIVE      | "utuisdohdi"
        "PL3" | "" | Tense.PRESENT         | "anituisdiha"
        "PL3" | "" | Tense.HABITUAL        | "anituisdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "untuistanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniduistanvi"
        "PL3" | "" | Tense.INFINITIVE      | "untuisdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idituisdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idituisdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iktuistanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "ididuistanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iktuisdohdi"
    }
}
