package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DegvdiyeaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Washing Dishes",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'degvdiyea', habitual: 'degvdiyesgoi', remote_past: 'dagwvdiyevi', imperative: 'digvdiya', infinitive: 'digwvdiyedi'],
            [subject: 'SG2', object: '', present: 'dehvdiyea', habitual: 'dehvdiyesgoi', remote_past: 'dejvdiyevi', imperative: 'tvdiya', infinitive: 'dijvdiyedi'],
            [subject: 'SG3', object: '', present: 'degvdiyea', habitual: 'degvdiyesgoi', remote_past: 'duwadiyevi', imperative: 'digvdiya', infinitive: 'juwadiyedi'],
            [subject: 'PL3', object: '', present: 'danvdiyea', habitual: 'danvdiyesgoi', remote_past: 'dunvdiyevi', imperative: 'dinvdiya', infinitive: 'junvdiyedi'],
            [subject: 'PL1INCL', object: '', present: 'dedvdiyea', habitual: 'dedvdiyesgoi', remote_past: 'degvdiyevi', imperative: 'didvdiya', infinitive: 'digvdiyedi']
        ]
    ]

    @Unroll
    def "conjugating Degvdiyea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Degvdiyea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degvdiyea"
        "SG1" | "" | Tense.HABITUAL        | "degvdiyesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwvdiyevi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "digvdiya"
        "SG1" | "" | Tense.INFINITIVE      | "digwvdiyedi"
        "SG2" | "" | Tense.PRESENT         | "dehvdiyea"
        "SG2" | "" | Tense.HABITUAL        | "dehvdiyesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejvdiyevi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tvdiya"
        "SG2" | "" | Tense.INFINITIVE      | "dijvdiyedi"
        "SG3" | "" | Tense.PRESENT         | "degvdiyea"
        "SG3" | "" | Tense.HABITUAL        | "degvdiyesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "duwadiyevi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "digvdiya"
        "SG3" | "" | Tense.INFINITIVE      | "juwadiyedi"
        "PL3" | "" | Tense.PRESENT         | "danvdiyea"
        "PL3" | "" | Tense.HABITUAL        | "danvdiyesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunvdiyevi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinvdiya"
        "PL3" | "" | Tense.INFINITIVE      | "junvdiyedi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedvdiyea"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedvdiyesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degvdiyevi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didvdiya"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digvdiyedi"
    }
}
