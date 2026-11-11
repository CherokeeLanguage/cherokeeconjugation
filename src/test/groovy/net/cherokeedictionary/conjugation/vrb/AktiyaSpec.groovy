package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AktiyaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Waiting",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG2', object: 'SG3AN', present: 'higatiya', habitual: '/', remote_past: 'hiktiya', imperative: 'higatiyoi', infinitive: '/'],
            [subject: 'SG1', object: '', present: 'aktiya', habitual: 'aktiyoi', remote_past: 'uktidvi', imperative: 'aktida', infinitive: 'uktidisdi'],
            [subject: 'SG3', object: '', present: 'anaktiya', habitual: 'anaktiyoi', remote_past: 'unaktidvi', imperative: 'anaktida', infinitive: 'unaktidisdi'],
            [subject: 'PL1INCL', object: '', present: 'idaktiya', habitual: 'idaktiyoi', remote_past: 'igaktidvi', imperative: 'idaktida', infinitive: 'igaktidisdi']
        ]
    ]

    @Unroll
    def "conjugating Aktiya (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aktiya", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG2" | "SG3AN" | Tense.PRESENT         | "higatiya"
        // "SG2" | "SG3AN" | Tense.HABITUAL        | "/"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiktiya"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "higatiyoi"
        // "SG2" | "SG3AN" | Tense.INFINITIVE      | "/"
        "SG1" | "" | Tense.PRESENT         | "aktiya"
        "SG1" | "" | Tense.HABITUAL        | "aktiyoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "uktidvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aktida"
        "SG1" | "" | Tense.INFINITIVE      | "uktidisdi"
        "SG3" | "" | Tense.PRESENT         | "anaktiya"
        "SG3" | "" | Tense.HABITUAL        | "anaktiyoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unaktidvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anaktida"
        "SG3" | "" | Tense.INFINITIVE      | "unaktidisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idaktiya"
        "PL1INCL" | "" | Tense.HABITUAL        | "idaktiyoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igaktidvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idaktida"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igaktidisdi"
    }
}
