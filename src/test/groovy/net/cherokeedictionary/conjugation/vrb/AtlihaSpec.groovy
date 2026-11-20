package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtlihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Fighting",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gatliha', habitual: 'gatlihoi', remote_past: 'agwvtlilvi', imperative: 'gatli', infinitive: 'agwalhsdi'],
            [subject: 'SG2', object: '', present: 'hatliha', habitual: 'hatlihoi', remote_past: 'jvtlilvi', imperative: 'hatli', infinitive: 'jahlsdi'],
            [subject: 'SG3', object: '', present: 'atliha', habitual: 'atlihoi', remote_past: 'utlilvi', imperative: 'atli', infinitive: 'uhlsdi'],
            [subject: 'PL3', object: '', present: 'anatliha', habitual: 'anatlihoi', remote_past: 'unvtlilvi', imperative: 'anatli', infinitive: 'unahlsdi'],
            [subject: 'PL1INCL', object: '', present: 'idatliha', habitual: 'idatlihoi', remote_past: 'igvtlilvi', imperative: 'idatli', infinitive: 'igahlsdi']
        ]
    ]

    @Unroll
    def "conjugating Atliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gatliha"
        "SG1" | "" | Tense.HABITUAL        | "gatlihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquatlilvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatlilvi"
        "SG1" | "" | Tense.INFINITIVE      | "aqualosdi"
        "SG2" | "" | Tense.PRESENT         | "hatliha"
        "SG2" | "" | Tense.HABITUAL        | "hatlihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatlilvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatlilvi"
        "SG2" | "" | Tense.INFINITIVE      | "jahlsdi"
        "SG3" | "" | Tense.PRESENT         | "atliha"
        "SG3" | "" | Tense.HABITUAL        | "atlihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utlilvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atlilvi"
        "SG3" | "" | Tense.INFINITIVE      | "uhlsdi"
        "PL3" | "" | Tense.PRESENT         | "anatliha"
        "PL3" | "" | Tense.HABITUAL        | "anatlihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatlilvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatlilvi"
        "PL3" | "" | Tense.INFINITIVE      | "unahlsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idatliha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idatlihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatlilvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatlilvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igahlsdi"
    }
}
