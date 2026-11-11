package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class WadiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Send (long)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'wijidia', habitual: 'wijidisgoi', remote_past: 'wagidvi', imperative: 'wijida', infinitive: 'wagidisdi'],
            [subject: 'SG2', object: '', present: 'hwidia', habitual: 'hwidisgoi', remote_past: 'wijadvi', imperative: 'hwida', infinitive: 'wijadisdi'],
            [subject: 'SG3', object: '', present: 'wadia', habitual: 'wadisgoi', remote_past: 'wudvi', imperative: 'wada', infinitive: 'wudisdi'],
            [subject: 'SG3', object: '', present: 'wanidia', habitual: 'wanidisgoi', remote_past: 'wunidvi', imperative: 'wanida', infinitive: 'wunidisdi']
        ]
    ]

    @Unroll
    def "conjugating Wadia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Wadia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "wijidia"
        "SG3" | "" | Tense.HABITUAL        | "wijidisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wagidvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wijida"
        "SG3" | "" | Tense.INFINITIVE      | "wagidisdi"
        "SG2" | "" | Tense.PRESENT         | "hwidia"
        "SG2" | "" | Tense.HABITUAL        | "hwidisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "wijadvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hwida"
        "SG2" | "" | Tense.INFINITIVE      | "wijadisdi"
        "SG3" | "" | Tense.PRESENT         | "wadia"
        "SG3" | "" | Tense.HABITUAL        | "wadisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wudvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wada"
        "SG3" | "" | Tense.INFINITIVE      | "wudisdi"
        "SG3" | "" | Tense.PRESENT         | "wanidia"
        "SG3" | "" | Tense.HABITUAL        | "wanidisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wunidvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wanida"
        "SG3" | "" | Tense.INFINITIVE      | "wunidisdi"
    }
}
