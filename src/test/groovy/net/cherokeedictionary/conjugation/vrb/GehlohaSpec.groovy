// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73215 (entrya gehloha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GehlohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Feeding",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyeloha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyeloha', habitual: 'jiyelohoi', remote_past: 'jiyelalvi', imperative: 'jiyeloga', infinitive: 'jiyelasdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyeloha', habitual: 'hiyelohoi', remote_past: 'hiyelalvi', imperative: 'hiyeloga', infinitive: 'hiyelasdi'],
            [subject: 'SG3', object: '', habitual: 'gehlohoi', imperative: 'hiyeloga', infinitive: 'uwelsdi', present: 'gehloha', remote_past: 'uwehlalvi'],
            [subject: 'PL3', object: 'SG3AN', present: 'anehloha', habitual: 'anehlohoi', remote_past: 'unehlalvi', imperative: 'anehloga', infinitive: 'unelasdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'edehloha', habitual: 'edehlohoi', remote_past: 'edehlalvi', imperative: 'edehloga', infinitive: 'edelasdi']
        ]
    ]

    @Unroll
    def "conjugating Gehloha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gehloha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyeloha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyelohoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyelalvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyetlalvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyelasdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyeloha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyelohoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyelalvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyetlalvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyelasdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "etloha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "getlohoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uwetlalvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "etlalvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uwelisdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "anehloha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "anehlohoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "unehlalvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "anetlalvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "unelasdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edehloha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edehlohoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "edehlalvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "edetlalvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "edelasdi"
    }
}
