package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsduiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Opening",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jisduia', habitual: 'jisduisgoi', remote_past: 'aksduisvi', imperative: 'jisdui', infinitive: 'aksduisdi'],
            [subject: 'SG2', object: '', present: 'hisduia', habitual: 'hisduisgoi', remote_past: 'tsduisvi', imperative: 'hisdui', infinitive: 'tsduisdi'],
            [subject: 'SG3', object: '', present: 'asduia', habitual: 'asduisgoi', remote_past: 'usduisvi', imperative: 'asdui', infinitive: 'usduisdi'],
            [subject: 'PL3', object: '', present: 'anisduia', habitual: 'anisduisgoi', remote_past: 'unsduisvi', imperative: 'anisdui', infinitive: 'unsduisdi'],
            [subject: 'PL1INCL', object: '', present: 'idisduia', habitual: 'idisduisgoi', remote_past: 'iksduisvi', imperative: 'idisdui', infinitive: 'iksduisdi']
        ]
    ]

    @Unroll
    def "conjugating Asduia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asduia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jisduia"
        "SG1" | "" | Tense.HABITUAL        | "jisduisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aksduisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jisdui"
        "SG1" | "" | Tense.INFINITIVE      | "aksduisdi"
        "SG2" | "" | Tense.PRESENT         | "hisduia"
        "SG2" | "" | Tense.HABITUAL        | "hisduisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsduisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisdui"
        "SG2" | "" | Tense.INFINITIVE      | "tsduisdi"
        "SG3" | "" | Tense.PRESENT         | "asduia"
        "SG3" | "" | Tense.HABITUAL        | "asduisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usduisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asdui"
        "SG3" | "" | Tense.INFINITIVE      | "usduisdi"
        "PL3" | "" | Tense.PRESENT         | "anisduia"
        "PL3" | "" | Tense.HABITUAL        | "anisduisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unsduisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisdui"
        "PL3" | "" | Tense.INFINITIVE      | "unsduisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisduia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisduisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iksduisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisdui"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iksduisdi"
    }
}
