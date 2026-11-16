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
        "SG1" | "" | Tense.PRESENT         | "tsigidladia"
        "SG1" | "" | Tense.HABITUAL        | "tsigidladisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquuwadladvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "guwadladvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquuwadladisdi"
        "SG2" | "" | Tense.PRESENT         | "higidladia"
        "SG2" | "" | Tense.HABITUAL        | "higidladisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsuwadladvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "huwadladvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsuwadladisdi"
        "SG3" | "" | Tense.PRESENT         | "gidladia"
        "SG3" | "" | Tense.HABITUAL        | "gidladisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwuwadladvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwadladvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwuwadladisdi"
        "PL3" | "" | Tense.PRESENT         | "anigidladia"
        "PL3" | "" | Tense.HABITUAL        | "anigidladisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unuwadladvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anuwadladvi"
        "PL3" | "" | Tense.INFINITIVE      | "unuwadladisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idigidladia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idigidladisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iguwadladvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iduwadladvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iguwadladisdi"
    }
}
