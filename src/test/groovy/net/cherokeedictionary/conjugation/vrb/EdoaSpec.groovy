package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class EdoaSpec extends VerbBaseSpec {
    static def details = [
        definition: "At / Walking Around",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gedoa', habitual: 'gedosgoi', remote_past: 'agwedolvi', imperative: 'geda', infinitive: 'agwedasdi'],
            [subject: 'SG2', object: '', present: 'hedoa', habitual: 'hedosgoi', remote_past: 'jedolvi', imperative: 'head', infinitive: 'jedasdi'],
            [subject: 'SG3', object: '', present: 'edoa', habitual: 'edosgoi', remote_past: 'uwedolvi', imperative: 'eda', infinitive: 'uwedasdi'],
            [subject: 'PL3', object: '', present: 'anedoa', habitual: 'anedosgoi', remote_past: 'unedolvi', imperative: 'aneda', infinitive: 'unedasdi'],
            [subject: 'PL1INCL', object: '', present: 'idedoa', habitual: 'idedosgoi', remote_past: 'igedolvi', imperative: 'ideda', infinitive: 'igedasdi']
        ]
    ]

    @Unroll
    def "conjugating Edoa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Edoa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gedoa"
        "SG1" | "" | Tense.HABITUAL        | "gedosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwedolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gedolvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwedasdi"
        "SG2" | "" | Tense.PRESENT         | "hedoa"
        "SG2" | "" | Tense.HABITUAL        | "hedosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jedolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hedolvi"
        "SG2" | "" | Tense.INFINITIVE      | "jedasdi"
        "SG3" | "" | Tense.PRESENT         | "edoa"
        "SG3" | "" | Tense.HABITUAL        | "edosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwedolvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "edolvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwedasdi"
        "PL3" | "" | Tense.PRESENT         | "anedoa"
        "PL3" | "" | Tense.HABITUAL        | "anedosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unedolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anedolvi"
        "PL3" | "" | Tense.INFINITIVE      | "unedasdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idedoa"
        "PL1INCL" | "" | Tense.HABITUAL        | "idedosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igedolvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idedolvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igedasdi"
    }
}
