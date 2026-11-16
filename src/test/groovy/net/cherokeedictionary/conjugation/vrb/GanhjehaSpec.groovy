// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73125 (entrya ganhjeha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanhjehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Have With / Hold in Hand (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinvjeha'],
            [subject: 'SG1', object: '', present: 'jinejeha', habitual: 'jinejehoi', remote_past: 'jinejehvi', imperative: 'jinejehesdi', infinitive: 'jinejehi'],
            [subject: 'SG2', object: '', present: 'hinhjeha', habitual: 'hinhjehoi', remote_past: 'hinhjehvi', imperative: 'hinhjehesdi', infinitive: 'hinhjehi'],
            [subject: 'SG3', object: '', habitual: 'ganhjehoi', imperative: 'hinhjehesdi', infinitive: '', present: 'ganhjeha', remote_past: ''],
            [subject: 'PL3', object: '', present: 'aninhjeha', habitual: 'aninhjehoi', remote_past: 'aninhjehvi', imperative: 'aninhjehesdi', infinitive: 'aninhjehi']
        ]
    ]

    @Unroll
    def "conjugating Ganhjeha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganhjeha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinitseha"
        "SG1" | "" | Tense.HABITUAL        | "tsinitsehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginitsehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinitse"
        "SG1" | "" | Tense.INFINITIVE      | "aginitsehi"
        "SG2" | "" | Tense.PRESENT         | "hinitseha"
        "SG2" | "" | Tense.HABITUAL        | "hinitsehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanitsehvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinitse"
        "SG2" | "" | Tense.INFINITIVE      | "tsanitsehi"
        "SG1" | "" | Tense.PRESENT         | "tsinitseha"
        "SG1" | "" | Tense.HABITUAL        | "tsinitsehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginitsehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinitse"
        "SG1" | "" | Tense.INFINITIVE      | "aginitsehi"
        "PL3" | "" | Tense.PRESENT         | "aninitseha"
        "PL3" | "" | Tense.HABITUAL        | "aninitsehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninitsehvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninitse"
        "PL3" | "" | Tense.INFINITIVE      | "uninitsehi"
    }
}
