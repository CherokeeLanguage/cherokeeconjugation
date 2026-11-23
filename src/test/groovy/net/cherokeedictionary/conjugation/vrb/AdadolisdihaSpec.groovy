// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72194 (entrya adadolisdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec
import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdadolisdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Praying",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadadolisdiha'],
            [subject: 'SG1', object: '', present: 'gadadolisdiha', habitual: 'gadadolisdisgoi', remote_past: 'agwadadolistanvi', imperative: 'gadadolisda', infinitive: 'agwadadolisdohdi'],
            [subject: 'SG2', object: '', present: 'hadadolisdiha', habitual: 'hadadolisdisgoi', remote_past: 'jadadolistanvi', imperative: 'hadadolisda', infinitive: 'jadadolisdohdi'],
            [subject: 'SG3', object: '', habitual: 'adadolisdisgoi', imperative: 'hadadolisda', infinitive: 'udadolisdohdi', present: 'adadolisdiha', remote_past: 'udadolistanvi'],
            [subject: 'PL3', object: '', present: 'anadadolisdiha', habitual: 'anadadolisdisgoi', remote_past: 'unadadolistanvi', imperative: 'anadadolisda', infinitive: 'unadadolisdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idadadolisdiha', habitual: 'idadadolisdisgoi', remote_past: 'igadadolistanvi', imperative: 'idadadolisda', infinitive: 'igadadolisdohdi']
        ]
    ]

    @Unroll
    def "conjugating Adadolisdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:

        def tenz = tense.toString()
        def syllabary = SyllabaryUtil.tsalagiToSyllabary(expected)


        conjugateVerb("Adadolisdiha", details, subj, obj, tenz, expected) == syllabary

        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadadolisdiha"
        "SG1" | "" | Tense.HABITUAL        | "gadadolisdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadadolistanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadadolistanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwadadolisdohdi"
        "SG2" | "" | Tense.PRESENT         | "hadadolisdiha"
        "SG2" | "" | Tense.HABITUAL        | "hadadolisdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadadolistanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadadolistanvi"
        "SG2" | "" | Tense.INFINITIVE      | "jadadolisdohdi"
        "SG3" | "" | Tense.PRESENT         | "adadolisdiha"
        "SG3" | "" | Tense.HABITUAL        | "adadolisdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udadolistanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adadolistanvi"
        "SG3" | "" | Tense.INFINITIVE      | "udadolisdohdi"
        "PL3" | "" | Tense.PRESENT         | "anadadolisdiha"
        "PL3" | "" | Tense.HABITUAL        | "anadadolisdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadadolistanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadadolistanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadadolisdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadadolisdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadadolisdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadadolistanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadadolistanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadadolisdohdi"
    }
}
