package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UlenahihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Losing His Way",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agwalenahiha', habitual: 'agwalenahihoi', remote_past: 'agwalenahlvi', imperative: 'agwalenaga', infinitive: 'agwalenasdi'],
            [subject: 'SG2', object: '', present: 'jalenahiha', habitual: 'jalenahihoi', remote_past: 'jalenahlvi', imperative: 'jalenaga', infinitive: 'jalenasdi'],
            [subject: 'SG3', object: '', present: 'ulenahiha', habitual: 'ulenahihoi', remote_past: 'ulenahlvi', imperative: 'ulenaga', infinitive: 'ulenasdi'],
            [subject: 'PL3', object: '', present: 'unalenahiha', habitual: 'unalenahihoi', remote_past: 'unalenahlvi', imperative: 'unalenaga', infinitive: 'unalenasdi'],
            [subject: 'PL1INCL', object: '', present: 'igalenahiha', habitual: 'igalenahihoi', remote_past: 'igalenahlvi', imperative: 'igalenaga', infinitive: 'igalenasdi']
        ]
    ]

    @Unroll
    def "conjugating Ulenahiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ulenahiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwalenahiha"
        "SG1" | "" | Tense.HABITUAL        | "agwalenahihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwalenahlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwalenaga"
        "SG1" | "" | Tense.INFINITIVE      | "agwalenasdi"
        "SG2" | "" | Tense.PRESENT         | "jalenahiha"
        "SG2" | "" | Tense.HABITUAL        | "jalenahihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalenahlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jalenaga"
        "SG2" | "" | Tense.INFINITIVE      | "jalenasdi"
        "SG3" | "" | Tense.PRESENT         | "ulenahiha"
        "SG3" | "" | Tense.HABITUAL        | "ulenahihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulenahlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ulenaga"
        "SG3" | "" | Tense.INFINITIVE      | "ulenasdi"
        "PL3" | "" | Tense.PRESENT         | "unalenahiha"
        "PL3" | "" | Tense.HABITUAL        | "unalenahihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalenahlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unalenaga"
        "PL3" | "" | Tense.INFINITIVE      | "unalenasdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igalenahiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igalenahihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalenahlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igalenaga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalenasdi"
    }
}
