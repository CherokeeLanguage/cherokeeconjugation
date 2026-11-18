// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72827 (entrya degvdiyea) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'degvdiyea'],
            [subject: 'SG1', object: '', present: 'degvdiyea', habitual: 'degvdiyesgoi', remote_past: 'dagwvdiyevi', imperative: 'digvdiya', infinitive: 'digwvdiyedi'],
            [subject: 'SG2', object: '', present: 'dehvdiyea', habitual: 'dehvdiyesgoi', remote_past: 'dejvdiyevi', imperative: 'tvdiya', infinitive: 'dijvdiyedi'],
            [subject: 'SG3', object: '', habitual: 'degvdiyesgoi', imperative: 'tvdiya', infinitive: 'juwadiyedi', present: 'degvdiyea', remote_past: 'duwadiyevi'],
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
        "SG1" | "" | Tense.PRESENT         | "gvdiyea"
        "SG1" | "" | Tense.HABITUAL        | "gvdiyesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquvdiyevi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gvdiyevi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwadiyedi"
        "SG2" | "" | Tense.PRESENT         | "hvdiyea"
        "SG2" | "" | Tense.HABITUAL        | "hvdiyesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsvdiyevi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hvdiyevi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawadiyedi"
        "SG3" | "" | Tense.PRESENT         | "degvdiyea"
        "SG3" | "" | Tense.HABITUAL        | "degvdiyesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwadiyevi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "vdiyevi"
        "SG3" | "" | Tense.INFINITIVE      | "uwadiyedi"
        "PL3" | "" | Tense.PRESENT         | "anvdiyea"
        "PL3" | "" | Tense.HABITUAL        | "anvdiyesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unvdiyevi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anvdiyevi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwadiyedi"
        "PL1INCL" | "" | Tense.PRESENT         | "idvdiyea"
        "PL1INCL" | "" | Tense.HABITUAL        | "idvdiyesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igvdiyevi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idvdiyevi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwadiyedi"
    }
}
