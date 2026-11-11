package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DanadlosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Meeting (They Are)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'dojadlosga', habitual: 'dojadlosgoi', remote_past: 'dogadlosvi', imperative: 'jojadlohi', infinitive: 'I'],
            [subject: 'SG2', object: '', present: 'desdadlosga', habitual: 'desdadlosgoi', remote_past: 'desdadlosvi', imperative: 'disdadlohi', infinitive: 'You'],
            [subject: 'SG3', object: '', present: 'dejadlosga', habitual: 'dejadlosgoi', remote_past: 'dejadlosvi', imperative: 'dijadlohi', infinitive: 'You'],
            [subject: 'PL3', object: '', present: 'dedadlosga', habitual: 'dedadlosgoi', remote_past: 'degadlosvi', imperative: 'didadlohi', infinitive: 'You,'],
            [subject: 'PL1INCL', object: '', present: 'danadlosga', habitual: 'danadlosgoi', remote_past: 'dunadlosvi', imperative: 'dinadlohi', infinitive: 'They']
        ]
    ]

    @Unroll
    def "conjugating Danadlosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Danadlosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "dojadlosga"
        "SG1" | "" | Tense.HABITUAL        | "dojadlosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dogadlosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jojadlohi"
        "SG1" | "" | Tense.INFINITIVE      | "I"
        "SG2" | "" | Tense.PRESENT         | "desdadlosga"
        "SG2" | "" | Tense.HABITUAL        | "desdadlosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "desdadlosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "disdadlohi"
        "SG2" | "" | Tense.INFINITIVE      | "You"
        "SG3" | "" | Tense.PRESENT         | "dejadlosga"
        "SG3" | "" | Tense.HABITUAL        | "dejadlosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dejadlosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dijadlohi"
        "SG3" | "" | Tense.INFINITIVE      | "You"
        "PL3" | "" | Tense.PRESENT         | "dedadlosga"
        "PL3" | "" | Tense.HABITUAL        | "dedadlosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "degadlosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "didadlohi"
        "PL3" | "" | Tense.INFINITIVE      | "You,"
        "PL1INCL" | "" | Tense.PRESENT         | "danadlosga"
        "PL1INCL" | "" | Tense.HABITUAL        | "danadlosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "dunadlosvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "dinadlohi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "They"
    }
}
