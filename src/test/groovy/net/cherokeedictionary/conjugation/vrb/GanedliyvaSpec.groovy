package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanedliyvaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Changing It",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinedliyva', habitual: 'jinedliyvsgoi', remote_past: 'aginedliyvsvi', imperative: 'jinedliyvna', infinitive: 'aginedliyvsdi'],
            [subject: 'SG2', object: '', present: 'hinedliyva', habitual: 'hinedliyvsgoi', remote_past: 'janedliyvsvi', imperative: 'hinedliyvna', infinitive: 'janedliyvsdi'],
            [subject: 'SG3', object: '', present: 'ganedliyva', habitual: 'ganedliyvsgoi', remote_past: 'unedliyvsvi', imperative: 'ganedliyvna', infinitive: 'unedliyvsdi'],
            [subject: 'PL3', object: '', present: 'aninedliyva', habitual: 'aninedliyvsgoi', remote_past: 'uninedliyvsvi', imperative: 'aninedliyvna', infinitive: 'uninedliyvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idinedliyva', habitual: 'idinedliyvsgoi', remote_past: 'iginedliyvsvi', imperative: 'idinedliyvna', infinitive: 'iginedliyvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ganedliyva (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganedliyva", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinedliyva"
        "SG1" | "" | Tense.HABITUAL        | "jinedliyvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginedliyvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinedliyvna"
        "SG1" | "" | Tense.INFINITIVE      | "aginedliyvsdi"
        "SG2" | "" | Tense.PRESENT         | "hinedliyva"
        "SG2" | "" | Tense.HABITUAL        | "hinedliyvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janedliyvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinedliyvna"
        "SG2" | "" | Tense.INFINITIVE      | "janedliyvsdi"
        "SG3" | "" | Tense.PRESENT         | "ganedliyva"
        "SG3" | "" | Tense.HABITUAL        | "ganedliyvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unedliyvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganedliyvna"
        "SG3" | "" | Tense.INFINITIVE      | "unedliyvsdi"
        "PL3" | "" | Tense.PRESENT         | "aninedliyva"
        "PL3" | "" | Tense.HABITUAL        | "aninedliyvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninedliyvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninedliyvna"
        "PL3" | "" | Tense.INFINITIVE      | "uninedliyvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinedliyva"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinedliyvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginedliyvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinedliyvna"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginedliyvsdi"
    }
}
