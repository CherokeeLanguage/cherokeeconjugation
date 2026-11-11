package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdehloqwaaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Learning",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadeloqwaa', habitual: 'gadeloqwasgoi', remote_past: 'agwadehloqwavi', imperative: 'gadeloqwa', infinitive: 'agwadehlqwasdi'],
            [subject: 'SG2', object: '', present: 'hadehloqwaa', habitual: 'hadehloqwasgoi', remote_past: 'jadehloqwavi', imperative: 'hadehloqwa', infinitive: 'jadehlqwasdi'],
            [subject: 'SG3', object: '', present: 'adehloqwaa', habitual: 'adehloqwasgoi', remote_past: 'udehloqwavi', imperative: 'adehloqwa', infinitive: 'udehlqwasdi'],
            [subject: 'PL3', object: '', present: 'anadehloqwaa', habitual: 'anadehloqwasgoi', remote_past: 'unadehloqwavi', imperative: 'anadehloqwa', infinitive: 'unadehlqwasdi'],
            [subject: 'PL1INCL', object: '', present: 'idadehloqwaa', habitual: 'idadehloqwasgoi', remote_past: 'igadehloqwavi', imperative: 'idadehloqwa', infinitive: 'igadehlqwasdi']
        ]
    ]

    @Unroll
    def "conjugating Adehloqwaa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adehloqwaa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadeloqwaa"
        "SG1" | "" | Tense.HABITUAL        | "gadeloqwasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadehloqwavi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadeloqwa"
        "SG1" | "" | Tense.INFINITIVE      | "agwadehlqwasdi"
        "SG2" | "" | Tense.PRESENT         | "hadehloqwaa"
        "SG2" | "" | Tense.HABITUAL        | "hadehloqwasgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadehloqwavi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadehloqwa"
        "SG2" | "" | Tense.INFINITIVE      | "jadehlqwasdi"
        "SG3" | "" | Tense.PRESENT         | "adehloqwaa"
        "SG3" | "" | Tense.HABITUAL        | "adehloqwasgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udehloqwavi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adehloqwa"
        "SG3" | "" | Tense.INFINITIVE      | "udehlqwasdi"
        "PL3" | "" | Tense.PRESENT         | "anadehloqwaa"
        "PL3" | "" | Tense.HABITUAL        | "anadehloqwasgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadehloqwavi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadehloqwa"
        "PL3" | "" | Tense.INFINITIVE      | "unadehlqwasdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadehloqwaa"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadehloqwasgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadehloqwavi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadehloqwa"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadehlqwasdi"
    }
}
