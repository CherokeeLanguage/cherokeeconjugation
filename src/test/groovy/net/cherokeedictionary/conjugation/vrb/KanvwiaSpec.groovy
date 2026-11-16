// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73503 (entrya kanvwia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KanvwiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Curing, Doctoring / Soldering, Welding",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinvwia'],
            [subject: 'SG1', object: '', present: 'jinvwia', habitual: 'jinvwisgoi', remote_past: 'akinvwanvi', imperative: 'jinvwvga', infinitive: 'akinvwodi'],
            [subject: 'SG2', object: '', present: 'hinvwia', habitual: 'hinvwisgoi', remote_past: 'jahnvwanvi', imperative: 'hinvwvga', infinitive: '/'],
            [subject: 'SG3', object: '', habitual: 'kanvwisgoi', imperative: 'hinvwvga, hihnvwvga', infinitive: 'uhnvwodi', present: 'kanvwia', remote_past: 'uhnvwanvi'],
            [subject: 'PL3', object: '', present: 'aninvwia', habitual: 'aninvwisgoi', remote_past: 'unihnvwanvi', imperative: 'anihnvwvga', infinitive: 'unihnvwodi'],
            [subject: 'PL1INCL', object: '', present: 'idinvwia', habitual: 'idinvwisgoi', remote_past: 'igihnvwanvi', imperative: 'idihnvwvga', infinitive: 'igihnvwodi']
        ]
    ]

    @Unroll
    def "conjugating Kanvwia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kanvwia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinvwia"
        "SG1" | "" | Tense.HABITUAL        | "tsinvwisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginvwanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinvwanvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginvwodi"
        "SG2" | "" | Tense.PRESENT         | "hinvwia"
        "SG2" | "" | Tense.HABITUAL        | "hinvwisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanvwanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinvwanvi"
        // "SG2" | "" | Tense.INFINITIVE      | "/"
        "SG3" | "" | Tense.PRESENT         | "kanvwia"
        "SG3" | "" | Tense.HABITUAL        | "kanvwisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unvwanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganvwanvi"
        "SG3" | "" | Tense.INFINITIVE      | "unvwodi"
        "PL3" | "" | Tense.PRESENT         | "aninvwia"
        "PL3" | "" | Tense.HABITUAL        | "aninvwisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninvwanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninvwanvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninvwodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinvwia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinvwisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginvwanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinvwanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginvwodi"
    }
}
