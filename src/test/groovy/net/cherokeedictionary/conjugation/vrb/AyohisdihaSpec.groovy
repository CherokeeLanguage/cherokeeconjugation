// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72712 (entrya ayohisdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyohisdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Taking a Break",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyohisdiha'],
            [subject: 'SG1', object: '', present: 'jiyohisdiha', habitual: 'jiyohisdisgoi', remote_past: 'agiyohisdtanvi', imperative: 'jiyohisda', infinitive: 'agiyohisdohdi'],
            [subject: 'SG2', object: '', present: 'hiyohisdiha', habitual: 'hiyohisdisgoi', remote_past: 'jayohisdtanvi', imperative: 'hiyohisda', infinitive: 'jayohisdohdi'],
            [subject: 'SG3', object: '', habitual: 'ayohisdisgoi', imperative: 'hiyohisda', infinitive: 'uyohisdohdi', present: 'ayohisdiha', remote_past: 'uyohistanvi'],
            [subject: 'PL3', object: '', present: 'aniyohisdiha', habitual: 'aniyohisdisgoi', remote_past: 'uniyohisdtanvi', imperative: 'aniyohisda', infinitive: 'uniyohisdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idiyohisdiha', habitual: 'idiyohisdisgoi', remote_past: 'igiyohisdtanvi', imperative: 'idiyohisda', infinitive: 'igiyohisdohdi']
        ]
    ]

    @Unroll
    def "conjugating Ayohisdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayohisdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsiyohisdiha"
        "SG1" | "" | Tense.HABITUAL        | "tsiyohisdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiyohistanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiyohistanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiyohisdodi"
        "SG2" | "" | Tense.PRESENT         | "hiyohisdiha"
        "SG2" | "" | Tense.HABITUAL        | "hiyohisdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsayohistanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiyohistanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsayohisdodi"
        "SG3" | "" | Tense.PRESENT         | "ayohisdiha"
        "SG3" | "" | Tense.HABITUAL        | "ayohisdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyohistanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ayohistanvi"
        "SG3" | "" | Tense.INFINITIVE      | "uyohisdodi"
        "PL3" | "" | Tense.PRESENT         | "aniyohisdiha"
        "PL3" | "" | Tense.HABITUAL        | "aniyohisdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyohistanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniyohistanvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyohisdodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idiyohisdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idiyohisdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiyohistanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiyohistanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiyohisdodi"
    }
}
