package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanehnehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Give/Pass (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jineneha', habitual: 'jinenehoi', remote_past: 'jinehnelvi', imperative: 'jinevsi', infinitive: 'jinehnehdi'],
            [subject: 'SG2', object: '', present: 'hinehneha', habitual: 'hinehnehoi', remote_past: 'hinehnelvi', imperative: 'hinehvsi', infinitive: 'hinehnehdi'],
            [subject: 'SG1', object: '', present: 'ganehneha', habitual: 'ganehnehoi', remote_past: 'unehnelvi', imperative: 'wiganehvsi', infinitive: 'unehnehdi'],
            [subject: 'PL3', object: '', present: 'aninehneha', habitual: 'aninehnehoi', remote_past: 'uninehnelvi', imperative: 'aninehvsi', infinitive: 'unehnehdi']
        ]
    ]

    @Unroll
    def "conjugating Ganehneha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganehneha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jineneha"
        "SG1" | "" | Tense.HABITUAL        | "jinenehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jinehnelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinevsi"
        "SG1" | "" | Tense.INFINITIVE      | "jinehnehdi"
        "SG2" | "" | Tense.PRESENT         | "hinehneha"
        "SG2" | "" | Tense.HABITUAL        | "hinehnehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hinehnelvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinehvsi"
        "SG2" | "" | Tense.INFINITIVE      | "hinehnehdi"
        "SG1" | "" | Tense.PRESENT         | "ganehneha"
        "SG1" | "" | Tense.HABITUAL        | "ganehnehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "unehnelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wiganehvsi"
        "SG1" | "" | Tense.INFINITIVE      | "unehnehdi"
        "PL3" | "" | Tense.PRESENT         | "aninehneha"
        "PL3" | "" | Tense.HABITUAL        | "aninehnehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninehnelvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninehvsi"
        "PL3" | "" | Tense.INFINITIVE      | "unehnehdi"
    }
}
