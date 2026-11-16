// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73912 (entrya unhta) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UnhtaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Know",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agwanhta'],
            [subject: 'SG1', object: '', present: 'agwanhta', habitual: 'agwanhtoi', remote_past: 'agwanhtvi', imperative: 'agwantesdi', infinitive: 'X'],
            [subject: 'SG2', object: '', present: 'janhta', habitual: 'janhtoi', remote_past: 'janhtvi', imperative: 'jantesdi', infinitive: ''],
            [subject: 'SG3', object: '', habitual: 'unhtoi', imperative: 'janhtesdi', infinitive: '----', present: 'unhta', remote_past: 'unhtvi'],
            [subject: 'PL3', object: '', present: 'unanhta', habitual: 'unanhtoi', remote_past: 'unanhtvi', imperative: 'unantesdi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'iganhta', habitual: 'iganhtoi', remote_past: 'iganhtvi', imperative: 'igantesdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Unhta (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Unhta", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aquanita"
        "SG1" | "" | Tense.HABITUAL        | "aquanidoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquanidvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquanidvi"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
        "SG2" | "" | Tense.PRESENT         | "tsanita"
        "SG2" | "" | Tense.HABITUAL        | "tsanidoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanidvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsanidvi"
        // "SG2" | "" | Tense.INFINITIVE      | "X"
        "SG3" | "" | Tense.PRESENT         | "unita"
        "SG3" | "" | Tense.HABITUAL        | "unidoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unidvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "unidvi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "unanita"
        "PL3" | "" | Tense.HABITUAL        | "unanidoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unanidvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unanidvi"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "iganita"
        "PL1INCL" | "" | Tense.HABITUAL        | "iganidoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iganidvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iganidvi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
