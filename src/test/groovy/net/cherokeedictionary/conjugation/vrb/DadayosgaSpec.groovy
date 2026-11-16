// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72743 (entrya dadayosga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DadayosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Giving Up",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'degadayosga'],
            [subject: 'SG1', object: '', present: 'degadayosga', habitual: 'degadayosgoi', remote_past: 'dagwadayosvi', imperative: 'digadayohi', infinitive: 'digwadayohisdi'],
            [subject: 'SG2', object: '', present: 'dahadayosga', habitual: 'dehadayosgoi', remote_past: 'dejadayosvi', imperative: 'tadayohi', infinitive: 'dijadayohisdi'],
            [subject: 'SG3', object: '', habitual: 'dadayosgoi', imperative: 'tadayohi', infinitive: 'judayohisdi', present: 'dadayosga', remote_past: 'dudayosvi'],
            [subject: 'PL3', object: '', present: 'danadayosga', habitual: 'danadayosgoi', remote_past: 'dunadayosvi', imperative: 'dinadayohi', infinitive: 'junadayohisdi'],
            [subject: 'PL1INCL', object: '', present: 'dedadayosga', habitual: 'dedadayosgoi', remote_past: 'degadayosvi', imperative: 'didadayohi', infinitive: 'digadayohisdi']
        ]
    ]

    @Unroll
    def "conjugating Dadayosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dadayosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadayosga"
        "SG1" | "" | Tense.HABITUAL        | "gadayosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadayosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadayosvi"
        "SG1" | "" | Tense.INFINITIVE      | "agidayohisdi"
        "SG2" | "" | Tense.PRESENT         | "hadayosga"
        "SG2" | "" | Tense.HABITUAL        | "hadayosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadayosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadayosvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadayohisdi"
        "SG3" | "" | Tense.PRESENT         | "dadayosga"
        "SG3" | "" | Tense.HABITUAL        | "dadayosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udayosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adayosvi"
        "SG3" | "" | Tense.INFINITIVE      | "udayohisdi"
        "PL3" | "" | Tense.PRESENT         | "anadayosga"
        "PL3" | "" | Tense.HABITUAL        | "anadayosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadayosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadayosvi"
        "PL3" | "" | Tense.INFINITIVE      | "unidayohisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadayosga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadayosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadayosvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadayosvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igidayohisdi"
    }
}
