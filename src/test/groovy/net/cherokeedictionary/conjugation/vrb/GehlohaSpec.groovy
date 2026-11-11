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
            [subject: 'SG1', object: 'SG3AN', present: 'jiyeloha', habitual: 'jiyelohoi', remote_past: 'jiyelalvi', imperative: 'jiyeloga', infinitive: 'jiyelasdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyeloha', habitual: 'hiyelohoi', remote_past: 'hiyelalvi', imperative: 'hiyeloga', infinitive: 'hiyelasdi'],
            [subject: 'SG3', object: 'SG3AN', present: 'gehloha', habitual: 'gehlohoi', remote_past: 'uwehlalvi', imperative: 'gehloga', infinitive: 'uwelsdi'],
            [subject: 'PL3', object: 'SG3AN', present: 'anehloha', habitual: 'anehlohoi', remote_past: 'unehlalvi', imperative: 'anehloga', infinitive: 'unelasdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'edehloha', habitual: 'edehlohoi', remote_past: 'edehlalvi', imperative: 'edehloga', infinitive: 'edelasdi']
        ]
    ]

    @Unroll
    def "conjugating Gehloha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gehloha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyeloha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyelohoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyelalvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyeloga"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyelasdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyeloha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyelohoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyelalvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyeloga"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyelasdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "gehloha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "gehlohoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uwehlalvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "gehloga"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uwelsdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "anehloha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "anehlohoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "unehlalvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "anehloga"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "unelasdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edehloha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edehlohoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "edehlalvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "edehloga"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "edelasdi"
    }
}
