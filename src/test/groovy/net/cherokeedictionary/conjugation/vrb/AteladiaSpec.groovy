package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AteladiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Joining (59)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadeladia', habitual: 'gadeladisgoi', remote_past: 'agwateladvi', imperative: 'gadelada', infinitive: 'agwateladisdi'],
            [subject: 'SG2', object: '', present: 'hateladia', habitual: 'hateladisgoi', remote_past: 'jateladvi', imperative: 'hatelada', infinitive: 'jateladisdi'],
            [subject: 'SG3', object: '', present: 'ateladia', habitual: 'ateladisgoi', remote_past: 'uteladvi', imperative: 'atelada', infinitive: 'uteladisdi'],
            [subject: 'PL3', object: '', present: 'anateladia', habitual: 'anatelidisgoi', remote_past: 'unateladvi', imperative: 'anatelada', infinitive: 'unateladisdi'],
            [subject: 'PL1INCL', object: '', present: 'idateladia', habitual: 'idatelidisgoi', remote_past: 'igateladvi', imperative: 'idatelada', infinitive: 'igateladisdi']
        ]
    ]

    @Unroll
    def "conjugating Ateladia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ateladia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadeladia"
        "SG1" | "" | Tense.HABITUAL        | "gadeladisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwateladvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadelada"
        "SG1" | "" | Tense.INFINITIVE      | "agwateladisdi"
        "SG2" | "" | Tense.PRESENT         | "hateladia"
        "SG2" | "" | Tense.HABITUAL        | "hateladisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jateladvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatelada"
        "SG2" | "" | Tense.INFINITIVE      | "jateladisdi"
        "SG3" | "" | Tense.PRESENT         | "ateladia"
        "SG3" | "" | Tense.HABITUAL        | "ateladisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uteladvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atelada"
        "SG3" | "" | Tense.INFINITIVE      | "uteladisdi"
        "PL3" | "" | Tense.PRESENT         | "anateladia"
        "PL3" | "" | Tense.HABITUAL        | "anatelidisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unateladvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatelada"
        "PL3" | "" | Tense.INFINITIVE      | "unateladisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idateladia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idatelidisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igateladvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatelada"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igateladisdi"
    }
}
