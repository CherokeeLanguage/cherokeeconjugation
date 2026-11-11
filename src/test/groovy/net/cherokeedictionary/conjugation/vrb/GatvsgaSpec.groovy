package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GatvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Hang Up (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadvsga', habitual: 'gadvsgoi', remote_past: 'agwatanvi', imperative: 'gadvga', infinitive: 'agwatdi'],
            [subject: 'SG2', object: '', present: 'hatvsga', habitual: 'hatvsgoi', remote_past: 'jatanvi', imperative: 'hatvga', infinitive: 'jatdi'],
            [subject: 'SG1', object: '', present: 'gatvsga', habitual: 'gatvsgoi', remote_past: 'utanvi', imperative: 'wigatvga', infinitive: 'utdi'],
            [subject: 'SG3', object: '', present: 'anatvsga', habitual: 'anatvsgoi', remote_past: 'unatanvi', imperative: 'wanatvga', infinitive: 'unatdi']
        ]
    ]

    @Unroll
    def "conjugating Gatvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gatvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadvsga"
        "SG1" | "" | Tense.HABITUAL        | "gadvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwatanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadvga"
        "SG1" | "" | Tense.INFINITIVE      | "agwatdi"
        "SG2" | "" | Tense.PRESENT         | "hatvsga"
        "SG2" | "" | Tense.HABITUAL        | "hatvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jatanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatvga"
        "SG2" | "" | Tense.INFINITIVE      | "jatdi"
        "SG1" | "" | Tense.PRESENT         | "gatvsga"
        "SG1" | "" | Tense.HABITUAL        | "gatvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "utanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wigatvga"
        "SG1" | "" | Tense.INFINITIVE      | "utdi"
        "SG3" | "" | Tense.PRESENT         | "anatvsga"
        "SG3" | "" | Tense.HABITUAL        | "anatvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unatanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wanatvga"
        "SG3" | "" | Tense.INFINITIVE      | "unatdi"
    }
}
