package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GosdvnihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Batting It",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gosdvniha', habitual: 'gosdvnihoi', remote_past: 'agwosdvnilvi', imperative: 'gosdvniga', infinitive: 'agwosdvnisdi'],
            [subject: 'SG2', object: '', present: 'hosdvniha', habitual: 'hosdvnihoi', remote_past: 'josdvnilvi', imperative: 'hosdvniga', infinitive: 'josdvnisdi'],
            [subject: 'SG3', object: '', present: 'gosdvniha', habitual: 'gosdvnihoi', remote_past: 'uwosdvnilvi', imperative: 'gosdvniga', infinitive: 'uwosdvnisdi'],
            [subject: 'PL3', object: '', present: 'anosdvniha', habitual: 'anosdvnihoi', remote_past: 'unosdvnilvi', imperative: 'anosdvniga', infinitive: 'unosdvnisdi'],
            [subject: 'PL1INCL', object: '', present: 'idosdvniha', habitual: 'idosdvnihoi', remote_past: 'igosdvnilvi', imperative: 'idosdvniga', infinitive: 'igosdvnisdi']
        ]
    ]

    @Unroll
    def "conjugating Gosdvniha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gosdvniha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gosdvniha"
        "SG1" | "" | Tense.HABITUAL        | "gosdvnihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwosdvnilvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gosdvniga"
        "SG1" | "" | Tense.INFINITIVE      | "agwosdvnisdi"
        "SG2" | "" | Tense.PRESENT         | "hosdvniha"
        "SG2" | "" | Tense.HABITUAL        | "hosdvnihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "josdvnilvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hosdvniga"
        "SG2" | "" | Tense.INFINITIVE      | "josdvnisdi"
        "SG3" | "" | Tense.PRESENT         | "gosdvniha"
        "SG3" | "" | Tense.HABITUAL        | "gosdvnihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwosdvnilvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gosdvniga"
        "SG3" | "" | Tense.INFINITIVE      | "uwosdvnisdi"
        "PL3" | "" | Tense.PRESENT         | "anosdvniha"
        "PL3" | "" | Tense.HABITUAL        | "anosdvnihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unosdvnilvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anosdvniga"
        "PL3" | "" | Tense.INFINITIVE      | "unosdvnisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idosdvniha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idosdvnihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igosdvnilvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idosdvniga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igosdvnisdi"
    }
}
