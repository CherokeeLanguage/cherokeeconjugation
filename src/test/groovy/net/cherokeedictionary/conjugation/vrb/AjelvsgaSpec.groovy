package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AjelvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Acting Like Him/Her",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gajelvsga', habitual: 'gajelvsgoi', remote_past: 'agwajelvhnvi', imperative: 'gajvelvna', infinitive: 'agwajehldi'],
            [subject: 'SG2', object: '', present: 'hajelvsga', habitual: 'hajelvsgoi', remote_past: 'jajelvhnvi', imperative: 'hajelvna', infinitive: 'jajehldi'],
            [subject: 'SG3', object: '', present: 'ajelvsga', habitual: 'ajelvsgoi', remote_past: 'ujelvhnvi', imperative: 'ajelvna', infinitive: 'ujehldi'],
            [subject: 'PL3', object: '', present: 'anajelvsga', habitual: 'anajelvsgoi', remote_past: 'unajelvhnvi', imperative: 'anajelvna', infinitive: 'unajehldi'],
            [subject: 'PL1INCL', object: '', present: 'idajelvsga', habitual: 'idajelvsgoi', remote_past: 'igajelvhnvi', imperative: 'idajelvna', infinitive: 'igajehldi']
        ]
    ]

    @Unroll
    def "conjugating Ajelvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ajelvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gajelvsga"
        "SG1" | "" | Tense.HABITUAL        | "gajelvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwajelvhnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gajvelvna"
        "SG1" | "" | Tense.INFINITIVE      | "agwajehldi"
        "SG2" | "" | Tense.PRESENT         | "hajelvsga"
        "SG2" | "" | Tense.HABITUAL        | "hajelvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jajelvhnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hajelvna"
        "SG2" | "" | Tense.INFINITIVE      | "jajehldi"
        "SG3" | "" | Tense.PRESENT         | "ajelvsga"
        "SG3" | "" | Tense.HABITUAL        | "ajelvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ujelvhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ajelvna"
        "SG3" | "" | Tense.INFINITIVE      | "ujehldi"
        "PL3" | "" | Tense.PRESENT         | "anajelvsga"
        "PL3" | "" | Tense.HABITUAL        | "anajelvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unajelvhnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anajelvna"
        "PL3" | "" | Tense.INFINITIVE      | "unajehldi"
        "PL1INCL" | "" | Tense.PRESENT         | "idajelvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idajelvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igajelvhnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idajelvna"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igajehldi"
    }
}
