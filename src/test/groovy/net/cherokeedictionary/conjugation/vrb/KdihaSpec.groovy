package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Using",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gvdiha', habitual: 'gvdisgoi', remote_past: 'aktanvi', imperative: 'gvda', infinitive: 'akhdohdi'],
            [subject: 'SG2', object: '', present: 'hvdiha', habitual: 'hvdisgoi', remote_past: 'jvtanvi', imperative: '/', infinitive: 'tstanvi'],
            [subject: 'SG3', object: '', present: 'kdiha', habitual: 'kdisgoi', remote_past: 'uwatanvi', imperative: 'khda', infinitive: 'uwadohdi'],
            [subject: 'PL3', object: '', present: 'anvdiha', habitual: 'anvdisgoi', remote_past: 'unvtanvi', imperative: 'anvhda', infinitive: 'unvhdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idvdiha', habitual: 'idvdisgoi', remote_past: 'iktanvi', imperative: 'idvhda', infinitive: 'ikhdohdi']
        ]
    ]

    @Unroll
    def "conjugating Kdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gvdiha"
        "SG1" | "" | Tense.HABITUAL        | "gvdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aktanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gvda"
        "SG1" | "" | Tense.INFINITIVE      | "akhdohdi"
        "SG2" | "" | Tense.PRESENT         | "hvdiha"
        "SG2" | "" | Tense.HABITUAL        | "hvdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jvtanvi"
        // "SG2" | "" | Tense.FUTURE_COMMAND      | "/"
        "SG2" | "" | Tense.INFINITIVE      | "tstanvi"
        "SG3" | "" | Tense.PRESENT         | "kdiha"
        "SG3" | "" | Tense.HABITUAL        | "kdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwatanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "khda"
        "SG3" | "" | Tense.INFINITIVE      | "uwadohdi"
        "PL3" | "" | Tense.PRESENT         | "anvdiha"
        "PL3" | "" | Tense.HABITUAL        | "anvdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unvtanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anvhda"
        "PL3" | "" | Tense.INFINITIVE      | "unvhdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idvdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idvdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iktanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idvhda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "ikhdohdi"
    }
}
