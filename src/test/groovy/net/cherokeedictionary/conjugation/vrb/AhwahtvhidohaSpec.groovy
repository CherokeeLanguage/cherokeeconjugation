package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhwahtvhidohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Visiting (Him/Her)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiwahtvhidoha', habitual: 'jiwahtvhidohoi', remote_past: 'jiwahtvhidolvi', imperative: 'jiwahtvhida', infinitive: 'jiwahtvhidasdi'],
            [subject: 'SG2', object: '', present: 'hihwahtvhidoha', habitual: 'hihwahtvhidohoi', remote_past: 'hihwahtvhidolvi', imperative: 'hiwahtvhida', infinitive: 'hihwahtvhidasdi'],
            [subject: 'SG3', object: '', present: 'ahwahtvhidoha', habitual: 'ahwahtvhidohoi', remote_past: 'uhwahtvhidolvi', imperative: 'ahwahtvhida', infinitive: 'uhwahtvhidasdi'],
            [subject: 'PL3', object: '', present: 'anihwahtvhidoha', habitual: 'anihwahtvhidohoi', remote_past: 'unihwahtvhidolvi', imperative: 'aniwahtvhida', infinitive: 'unihwahtvhidasdi'],
            [subject: 'PL1INCL', object: '', present: 'edihwahtvhidoha', habitual: 'edihwahtvhidohoi', remote_past: 'edihwahtvhidolvi', imperative: 'ediwahtvhida', infinitive: 'edihwahtvhidasdi']
        ]
    ]

    @Unroll
    def "conjugating Ahwahtvhidoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahwahtvhidoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiwahtvhidoha"
        "SG1" | "" | Tense.HABITUAL        | "jiwahtvhidohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jiwahtvhidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jiwahtvhida"
        "SG1" | "" | Tense.INFINITIVE      | "jiwahtvhidasdi"
        "SG2" | "" | Tense.PRESENT         | "hihwahtvhidoha"
        "SG2" | "" | Tense.HABITUAL        | "hihwahtvhidohoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hihwahtvhidolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwahtvhida"
        "SG2" | "" | Tense.INFINITIVE      | "hihwahtvhidasdi"
        "SG3" | "" | Tense.PRESENT         | "ahwahtvhidoha"
        "SG3" | "" | Tense.HABITUAL        | "ahwahtvhidohoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhwahtvhidolvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahwahtvhida"
        "SG3" | "" | Tense.INFINITIVE      | "uhwahtvhidasdi"
        "PL3" | "" | Tense.PRESENT         | "anihwahtvhidoha"
        "PL3" | "" | Tense.HABITUAL        | "anihwahtvhidohoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihwahtvhidolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwahtvhida"
        "PL3" | "" | Tense.INFINITIVE      | "unihwahtvhidasdi"
        "PL1INCL" | "" | Tense.PRESENT         | "edihwahtvhidoha"
        "PL1INCL" | "" | Tense.HABITUAL        | "edihwahtvhidohoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "edihwahtvhidolvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "ediwahtvhida"
        "PL1INCL" | "" | Tense.INFINITIVE      | "edihwahtvhidasdi"
    }
}
