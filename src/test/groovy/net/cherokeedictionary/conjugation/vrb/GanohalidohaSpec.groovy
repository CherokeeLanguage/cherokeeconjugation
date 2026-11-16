// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73140 (entrya ganohalidoha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanohalidohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Hunting",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinoalidoha'],
            [subject: 'SG1', object: '', present: 'jinoalidoha', habitual: 'jinoalidosgoi', remote_past: 'aginohalidolvi', imperative: 'jinoalida', infinitive: 'aginohalidasdi'],
            [subject: 'SG2', object: '', present: 'hinohalidoha', habitual: 'hinohalidosgoi', remote_past: 'janohalidolvi', imperative: 'hinohalida', infinitive: 'janohalidasdi'],
            [subject: 'SG3', object: '', habitual: 'ganohalidohoi', imperative: 'hinohalida', infinitive: 'unohalidasdi', present: 'ganohalidoha', remote_past: 'unohalidolvi'],
            [subject: 'PL3', object: '', present: 'aninohalidoha', habitual: 'aninohalidosgoi', remote_past: 'uninohalidolvi', imperative: 'aninohalida', infinitive: 'uninohalidasdi'],
            [subject: 'PL1INCL', object: '', present: 'idinohalidoha', habitual: 'idinohalidosgoi', remote_past: 'iginohalidolvi', imperative: 'idinohalida', infinitive: 'iginohalidasdi']
        ]
    ]

    @Unroll
    def "conjugating Ganohalidoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganohalidoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinohalidoha"
        "SG1" | "" | Tense.HABITUAL        | "tsinohalidohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginohalidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinohalidolvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginohalidasdi"
        "SG2" | "" | Tense.PRESENT         | "hinohalidoha"
        "SG2" | "" | Tense.HABITUAL        | "hinohalidohoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanohalidolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinohalidolvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanohalidasdi"
        "SG3" | "" | Tense.PRESENT         | "ganohalidoha"
        "SG3" | "" | Tense.HABITUAL        | "ganohalidohoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unohalidolvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganohalidolvi"
        "SG3" | "" | Tense.INFINITIVE      | "unohalidasdi"
        "PL3" | "" | Tense.PRESENT         | "aninohalidoha"
        "PL3" | "" | Tense.HABITUAL        | "aninohalidohoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninohalidolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninohalidolvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninohalidasdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinohalidoha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinohalidohoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginohalidolvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinohalidolvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginohalidasdi"
    }
}
