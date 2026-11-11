package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DakanehihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Tying",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'dejiganehiha', habitual: 'dejiganehihoi', remote_past: 'dagikanehlvi', imperative: 'dijiganega', infinitive: 'digijihlusdi'],
            [subject: 'SG2', object: '', present: 'dehikanehiha', habitual: 'deihikanehihoi', remote_past: 'dejakanehlvi', imperative: 'tikanega', infinitive: 'dijajihlusdi'],
            [subject: 'SG3', object: '', present: 'dakanehiha', habitual: 'dakanehihoi', remote_past: 'dukanehlvi', imperative: 'dikanega', infinitive: 'jujihlusdi'],
            [subject: 'PL3', object: '', present: 'danikanehiha', habitual: 'danikanehihoi', remote_past: 'dunikanehlvi', imperative: 'dinikanega', infinitive: 'junijihlusdi'],
            [subject: 'PL1INCL', object: '', present: 'dedikanehiha', habitual: 'dedikanehihoi', remote_past: 'degikanehlvi', imperative: 'didikanega', infinitive: 'digijihlusdi']
        ]
    ]

    @Unroll
    def "conjugating Dakanehiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dakanehiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "dejiganehiha"
        "SG1" | "" | Tense.HABITUAL        | "dejiganehihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagikanehlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "dijiganega"
        "SG1" | "" | Tense.INFINITIVE      | "digijihlusdi"
        "SG2" | "" | Tense.PRESENT         | "dehikanehiha"
        "SG2" | "" | Tense.HABITUAL        | "deihikanehihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejakanehlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tikanega"
        "SG2" | "" | Tense.INFINITIVE      | "dijajihlusdi"
        "SG3" | "" | Tense.PRESENT         | "dakanehiha"
        "SG3" | "" | Tense.HABITUAL        | "dakanehihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dukanehlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dikanega"
        "SG3" | "" | Tense.INFINITIVE      | "jujihlusdi"
        "PL3" | "" | Tense.PRESENT         | "danikanehiha"
        "PL3" | "" | Tense.HABITUAL        | "danikanehihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunikanehlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinikanega"
        "PL3" | "" | Tense.INFINITIVE      | "junijihlusdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedikanehiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedikanehihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degikanehlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didikanega"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digijihlusdi"
    }
}
