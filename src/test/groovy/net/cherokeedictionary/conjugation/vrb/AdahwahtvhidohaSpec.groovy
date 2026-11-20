// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72202 (entrya adahwahtvhidoha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdahwahtvhidohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he Is Visiting",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadawahtvhidoha'],
            [subject: 'SG1', object: '', present: 'gadahwahtvhidoha', habitual: 'gadahwahtvhidohoi', remote_past: 'agwadahwahtvhidolvi', imperative: 'gadahwatvhida', infinitive: 'agwadahwahtvhidasdi'],
            [subject: 'SG2', object: '', present: 'hadahwahtvhidoha', habitual: 'hadahwahtvhidohoi', remote_past: 'jadahwahtvhidolvi', imperative: 'hadahwatvhida', infinitive: 'jadahwahtvhidasdi'],
            [subject: 'SG3', object: '', habitual: 'adahwahtvhidohoi', imperative: 'hadahwahtvhida', infinitive: 'udahwahtvhidasdi', present: 'adahwahtvhidoha', remote_past: 'udahwahtvhidolvi'],
            [subject: 'PL3', object: '', present: 'anadahwahtvhidoha', habitual: 'anadahwahtvhidohoi', remote_past: 'unadahwahtvhidolvi', imperative: 'anadahwatvhida', infinitive: 'unadahwahtvhidasdi'],
            [subject: 'PL1INCL', object: '', present: 'idadahwahtvhidoha', habitual: 'idadahwahtvhidohoi', remote_past: 'igadahwahtvhidolvi', imperative: 'idadahwatvhida', infinitive: 'igadahwahtvhidasdi']
        ]
    ]

    @Unroll
    def "conjugating Adahwahtvhidoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adahwahtvhidoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadawadvhidoha"
        "SG1" | "" | Tense.HABITUAL        | "gadawadvhidohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadawadvhidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadawadvhidolvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadawadvhidasdi"
        "SG2" | "" | Tense.PRESENT         | "hadahwahtvhidoha"
        "SG2" | "" | Tense.HABITUAL        | "hadahwahtvhidohoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadahwahtvhidolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadawadvhidolvi"
        "SG2" | "" | Tense.INFINITIVE      | "jadahwahtvhidasdi"
        "SG3" | "" | Tense.PRESENT         | "adahwahtvhidoha"
        "SG3" | "" | Tense.HABITUAL        | "adahwahtvhidohoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udahwahtvhidolvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adawadvhidolvi"
        "SG3" | "" | Tense.INFINITIVE      | "udahwahtvhidasdi"
        "PL3" | "" | Tense.PRESENT         | "anadahwahtvhidoha"
        "PL3" | "" | Tense.HABITUAL        | "anadahwahtvhidohoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadahwahtvhidolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadawadvhidolvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadahwahtvhidasdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadahwahtvhidoha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadahwahtvhidohoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadahwahtvhidolvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadawadvhidolvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadahwahtvhidasdi"
    }
}
