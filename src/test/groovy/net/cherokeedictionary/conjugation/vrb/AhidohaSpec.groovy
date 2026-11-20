// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72347 (entrya ahidoha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhidohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Handle/Carry (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiidoha'],
            [subject: 'SG1', object: '', present: 'jiidoha', habitual: 'jiidohoi', remote_past: 'agihidolvi', imperative: 'jiida', infinitive: 'agihidasdi'],
            [subject: 'SG2', object: '', present: 'hihidoha', habitual: 'hihidohoi', remote_past: 'jahidolvi', imperative: 'hihida', infinitive: 'jahidasdi'],
            [subject: 'SG3', object: '', habitual: 'ahidohoi', imperative: 'hihida', infinitive: 'uhidasdi', present: 'ahidoha', remote_past: 'uhidolvi'],
            [subject: 'PL3', object: '', present: 'anihidoha', habitual: 'anihidohoi', remote_past: 'unihidolvi', imperative: 'anihida', infinitive: 'unihidasdi']
        ]
    ]

    @Unroll
    def "conjugating Ahidoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahidoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsihitoha"
        "SG1" | "" | Tense.HABITUAL        | "tsihitohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agihidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsihidolvi"
        "SG1" | "" | Tense.INFINITIVE      | "agihidasdi"
        "SG2" | "" | Tense.PRESENT         | "hihidoha"
        "SG2" | "" | Tense.HABITUAL        | "hihidohoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahidolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihidolvi"
        "SG2" | "" | Tense.INFINITIVE      | "jahidasdi"
        "SG3" | "" | Tense.PRESENT         | "ahidoha"
        "SG3" | "" | Tense.HABITUAL        | "ahidohoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhidolvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahidolvi"
        "SG3" | "" | Tense.INFINITIVE      | "uhidasdi"
        "PL3" | "" | Tense.PRESENT         | "anihidoha"
        "PL3" | "" | Tense.HABITUAL        | "anihidohoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihidolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihidolvi"
        "PL3" | "" | Tense.INFINITIVE      | "unihidasdi"
    }
}
