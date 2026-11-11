package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhiliSpec extends VerbBaseSpec {
    static def details = [
        definition: "Driving",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiili', habitual: 'jiilegoi', remote_past: '/', imperative: 'jiilisoi', infinitive: 'agihilvsvi'],
            [subject: 'SG2', object: '', present: 'hihili', habitual: 'hihilegoi', remote_past: '/', imperative: 'hihilisoi', infinitive: 'jahilvsvi'],
            [subject: 'SG3', object: '', present: 'ahili', habitual: 'ahilegoi', remote_past: '/', imperative: 'ahilisoi', infinitive: 'uhilvsvi'],
            [subject: 'PL3', object: '', present: 'anihili', habitual: 'anihilegoi', remote_past: '/', imperative: 'anihilisoi', infinitive: 'unihilvsvi'],
            [subject: 'PL1INCL', object: '', present: 'idihili', habitual: 'idihilegoi', remote_past: '/', imperative: 'idihilisoi', infinitive: 'igihilvsvi']
        ]
    ]

    @Unroll
    def "conjugating Ahili (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahili", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiili"
        "SG1" | "" | Tense.HABITUAL        | "jiilegoi"
        // "SG1" | "" | Tense.REMOTE_PAST     | "/"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jiilisoi"
        "SG1" | "" | Tense.INFINITIVE      | "agihilvsvi"
        "SG2" | "" | Tense.PRESENT         | "hihili"
        "SG2" | "" | Tense.HABITUAL        | "hihilegoi"
        // "SG2" | "" | Tense.REMOTE_PAST     | "/"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihilisoi"
        "SG2" | "" | Tense.INFINITIVE      | "jahilvsvi"
        "SG3" | "" | Tense.PRESENT         | "ahili"
        "SG3" | "" | Tense.HABITUAL        | "ahilegoi"
        // "SG3" | "" | Tense.REMOTE_PAST     | "/"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahilisoi"
        "SG3" | "" | Tense.INFINITIVE      | "uhilvsvi"
        "PL3" | "" | Tense.PRESENT         | "anihili"
        "PL3" | "" | Tense.HABITUAL        | "anihilegoi"
        // "PL3" | "" | Tense.REMOTE_PAST     | "/"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihilisoi"
        "PL3" | "" | Tense.INFINITIVE      | "unihilvsvi"
        "PL1INCL" | "" | Tense.PRESENT         | "idihili"
        "PL1INCL" | "" | Tense.HABITUAL        | "idihilegoi"
        // "PL1INCL" | "" | Tense.REMOTE_PAST     | "/"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idihilisoi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igihilvsvi"
    }
}
