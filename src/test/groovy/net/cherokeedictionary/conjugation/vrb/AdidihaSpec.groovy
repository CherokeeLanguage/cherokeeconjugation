package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdidihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Getting Up",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadidia', habitual: 'gadidisgoi', remote_past: 'agwadidvhvi', imperative: 'gadida', infinitive: 'agwaditdi'],
            [subject: 'SG2', object: '', present: 'hadidiha', habitual: 'hadidisgoi', remote_past: 'jadidvhvi', imperative: 'hadida', infinitive: 'jaditdi'],
            [subject: 'SG3', object: '', present: 'adidiha', habitual: 'adidisgoi', remote_past: 'udidvhvi', imperative: 'adida', infinitive: 'uditdi'],
            [subject: 'PL3', object: '', present: 'anadidiha', habitual: 'anadidisgoi', remote_past: 'unadidvhvi', imperative: 'anadida', infinitive: 'unaditdi'],
            [subject: 'PL1INCL', object: '', present: 'idadidiha', habitual: 'idadidisgoi', remote_past: 'igadidvhvi', imperative: 'idadida', infinitive: 'igaditdi']
        ]
    ]

    @Unroll
    def "conjugating Adidiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adidiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadidia"
        "SG1" | "" | Tense.HABITUAL        | "gadidisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadidvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadida"
        "SG1" | "" | Tense.INFINITIVE      | "agwaditdi"
        "SG2" | "" | Tense.PRESENT         | "hadidiha"
        "SG2" | "" | Tense.HABITUAL        | "hadidisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadidvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadida"
        "SG2" | "" | Tense.INFINITIVE      | "jaditdi"
        "SG3" | "" | Tense.PRESENT         | "adidiha"
        "SG3" | "" | Tense.HABITUAL        | "adidisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udidvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adida"
        "SG3" | "" | Tense.INFINITIVE      | "uditdi"
        "PL3" | "" | Tense.PRESENT         | "anadidiha"
        "PL3" | "" | Tense.HABITUAL        | "anadidisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadidvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadida"
        "PL3" | "" | Tense.INFINITIVE      | "unaditdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadidiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadidisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadidvhvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadida"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igaditdi"
    }
}
