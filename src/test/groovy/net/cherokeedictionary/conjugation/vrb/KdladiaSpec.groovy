package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KdladiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Putting Out a Fire/Light",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gvdladia', habitual: 'gvdladisgoi', remote_past: 'akdladvi', imperative: 'gvdlada', infinitive: 'akdladisdi'],
            [subject: 'SG2', object: '', present: 'hvhdladia', habitual: 'hvhdladisgoi', remote_past: 'tsdladvi', imperative: 'hvhdlada', infinitive: 'tsdladisdi'],
            [subject: 'SG3', object: '', present: 'kdladia', habitual: 'kdladisgoi', remote_past: 'uwadladvi', imperative: 'kdlada', infinitive: 'uwadladisdi'],
            [subject: 'PL3', object: '', present: 'anvhdladia', habitual: 'anvhdladisgoi', remote_past: 'unhdladvi', imperative: 'anvhdlada', infinitive: 'unhdladisdi'],
            [subject: 'PL1INCL', object: '', present: 'idvhdladia', habitual: 'idvhdladisgoi', remote_past: 'igvhdladvi', imperative: 'idvhdlada', infinitive: 'igvhdladisdi']
        ]
    ]

    @Unroll
    def "conjugating Kdladia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kdladia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gvdladia"
        "SG1" | "" | Tense.HABITUAL        | "gvdladisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akdladvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gvdlada"
        "SG1" | "" | Tense.INFINITIVE      | "akdladisdi"
        "SG2" | "" | Tense.PRESENT         | "hvhdladia"
        "SG2" | "" | Tense.HABITUAL        | "hvhdladisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsdladvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hvhdlada"
        "SG2" | "" | Tense.INFINITIVE      | "tsdladisdi"
        "SG3" | "" | Tense.PRESENT         | "kdladia"
        "SG3" | "" | Tense.HABITUAL        | "kdladisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwadladvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "kdlada"
        "SG3" | "" | Tense.INFINITIVE      | "uwadladisdi"
        "PL3" | "" | Tense.PRESENT         | "anvhdladia"
        "PL3" | "" | Tense.HABITUAL        | "anvhdladisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unhdladvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anvhdlada"
        "PL3" | "" | Tense.INFINITIVE      | "unhdladisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idvhdladia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idvhdladisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igvhdladvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idvhdlada"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igvhdladisdi"
    }
}
