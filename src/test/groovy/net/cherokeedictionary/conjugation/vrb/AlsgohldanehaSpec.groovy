package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlsgohldanehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Permitting Him/Her",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyalisgohldaneha', habitual: 'jiyalisgohldanehoi', remote_past: 'jiyalisgohldanelvi', imperative: 'jiyalisgohldasi', infinitive: 'jiyalisgohldanehdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyalisgohldaneha', habitual: 'hiyalisgohldanehoi', remote_past: 'hiyalisgohldanelvi', imperative: 'hiyalisgohldasi', infinitive: 'hiyalisgohldanehdi'],
            [subject: 'SG3', object: 'SG3AN', present: 'alsgohldaneha', habitual: 'alsgohldanehoi', remote_past: 'ulsgohldanelvi', imperative: 'alsgohldasi', infinitive: 'ulsgohldanehdi'],
            [subject: 'PL3', object: 'SG3AN', present: 'analsgohldaneha', habitual: 'analsgohldanehoi', remote_past: 'unalsgohldanelvi', imperative: 'analsgohldasi', infinitive: 'unalsgohldanehdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'edalsgohldaneha', habitual: 'edalsgohldanehoi', remote_past: 'edgalsgohldanelvi', imperative: 'edalsgohldasi', infinitive: 'edalsgohldanehdi']
        ]
    ]

    @Unroll
    def "conjugating Alsgohldaneha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alsgohldaneha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyalisgohldaneha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyalisgohldanehoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyalisgohldanelvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyalisgohldasi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyalisgohldanehdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyalisgohldaneha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyalisgohldanehoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyalisgohldanelvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyalisgohldasi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyalisgohldanehdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "alsgohldaneha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "alsgohldanehoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "ulsgohldanelvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "alsgohldasi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "ulsgohldanehdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "analsgohldaneha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "analsgohldanehoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "unalsgohldanelvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "analsgohldasi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "unalsgohldanehdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "edalsgohldaneha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "edalsgohldanehoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "edgalsgohldanelvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "edalsgohldasi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "edalsgohldanehdi"
    }
}
