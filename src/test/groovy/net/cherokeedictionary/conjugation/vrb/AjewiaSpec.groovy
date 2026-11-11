package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AjewiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he is Spilling It/Pouring It/Being Wasteful",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gajewia', habitual: 'gajewisgoi', remote_past: 'agwajewvi', imperative: 'gajewa', infinitive: 'agwajewasdi'],
            [subject: 'SG2', object: '', present: 'hajewia', habitual: 'hajewisgoi', remote_past: 'jajewvi', imperative: 'hajewa', infinitive: 'jajewasdi'],
            [subject: 'SG3', object: '', present: 'ajewia', habitual: 'ajewisgoi', remote_past: 'ujewvi', imperative: 'ajewa', infinitive: 'ujewasdi'],
            [subject: 'PL3', object: '', present: 'anajewia', habitual: 'anajewisgoi', remote_past: 'unajewvi', imperative: 'anajewa', infinitive: 'unajewasdi'],
            [subject: 'PL1INCL', object: '', present: 'idajewia', habitual: 'idajewisgoi', remote_past: 'igajewvi', imperative: 'idajewa', infinitive: 'igajewasdi']
        ]
    ]

    @Unroll
    def "conjugating Ajewia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ajewia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gajewia"
        "SG1" | "" | Tense.HABITUAL        | "gajewisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwajewvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gajewa"
        "SG1" | "" | Tense.INFINITIVE      | "agwajewasdi"
        "SG2" | "" | Tense.PRESENT         | "hajewia"
        "SG2" | "" | Tense.HABITUAL        | "hajewisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jajewvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hajewa"
        "SG2" | "" | Tense.INFINITIVE      | "jajewasdi"
        "SG3" | "" | Tense.PRESENT         | "ajewia"
        "SG3" | "" | Tense.HABITUAL        | "ajewisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ujewvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ajewa"
        "SG3" | "" | Tense.INFINITIVE      | "ujewasdi"
        "PL3" | "" | Tense.PRESENT         | "anajewia"
        "PL3" | "" | Tense.HABITUAL        | "anajewisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unajewvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anajewa"
        "PL3" | "" | Tense.INFINITIVE      | "unajewasdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idajewia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idajewisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igajewvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idajewa"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igajewasdi"
    }
}
