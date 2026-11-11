package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DahyvgiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Tickling Him/Her ; Spurring a Horse",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'dejiyvgia', habitual: 'dejiyvgisgoi', remote_past: 'dejiyvgvi', imperative: '/', infinitive: 'dakihyvgvi'],
            [subject: 'SG2', object: '', present: 'dehihyvgia', habitual: 'dehihyvgisgoi', remote_past: 'dehihyvgvi', imperative: '/', infinitive: 'dejahyvgvi'],
            [subject: 'SG3', object: '', present: 'dahyvgia', habitual: 'dahyvgisgoi', remote_past: 'duhyvgvi', imperative: 'dihyvga', infinitive: 'juhyvgisdi'],
            [subject: 'PL3', object: '', present: 'danihyvgia', habitual: 'danihyvgisgoi', remote_past: 'dunihyvgvi', imperative: 'dinihyvga', infinitive: 'junihyvgisdi'],
            [subject: 'PL1INCL', object: '', present: 'dedihyvgia', habitual: 'dedihyvgisgoi', remote_past: 'dedihyvgvi', imperative: '/', infinitive: 'degihyvgvi']
        ]
    ]

    @Unroll
    def "conjugating Dahyvgia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dahyvgia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "dejiyvgia"
        "SG1" | "" | Tense.HABITUAL        | "dejiyvgisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dejiyvgvi"
        // "SG1" | "" | Tense.FUTURE_COMMAND      | "/"
        "SG1" | "" | Tense.INFINITIVE      | "dakihyvgvi"
        "SG2" | "" | Tense.PRESENT         | "dehihyvgia"
        "SG2" | "" | Tense.HABITUAL        | "dehihyvgisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dehihyvgvi"
        // "SG2" | "" | Tense.FUTURE_COMMAND      | "/"
        "SG2" | "" | Tense.INFINITIVE      | "dejahyvgvi"
        "SG3" | "" | Tense.PRESENT         | "dahyvgia"
        "SG3" | "" | Tense.HABITUAL        | "dahyvgisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "duhyvgvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dihyvga"
        "SG3" | "" | Tense.INFINITIVE      | "juhyvgisdi"
        "PL3" | "" | Tense.PRESENT         | "danihyvgia"
        "PL3" | "" | Tense.HABITUAL        | "danihyvgisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunihyvgvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinihyvga"
        "PL3" | "" | Tense.INFINITIVE      | "junihyvgisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedihyvgia"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedihyvgisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "dedihyvgvi"
        // "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "/"
        "PL1INCL" | "" | Tense.INFINITIVE      | "degihyvgvi"
    }
}
