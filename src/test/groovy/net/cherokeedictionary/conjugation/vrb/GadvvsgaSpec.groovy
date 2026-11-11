package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GadvvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Hang Up (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadvvsga', habitual: 'gadvvsgoi', remote_past: 'agwadvnvi', imperative: 'gadvvga', infinitive: 'agwadvdi'],
            [subject: 'SG2', object: '', present: 'hadvvsga', habitual: 'hadvvsgoi', remote_past: 'jadvnvi', imperative: 'hadvvga', infinitive: 'jadvdi'],
            [subject: 'SG1', object: '', present: 'gadvvsga', habitual: 'gadvvsgoi', remote_past: 'udvnvi', imperative: 'wigadvvga', infinitive: 'udvdi'],
            [subject: 'SG3', object: '', present: 'anadvvsga', habitual: 'anadvvsgoi', remote_past: 'unadvnvi', imperative: 'wanadvvga', infinitive: 'unadvdi']
        ]
    ]

    @Unroll
    def "conjugating Gadvvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gadvvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadvvsga"
        "SG1" | "" | Tense.HABITUAL        | "gadvvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadvvga"
        "SG1" | "" | Tense.INFINITIVE      | "agwadvdi"
        "SG2" | "" | Tense.PRESENT         | "hadvvsga"
        "SG2" | "" | Tense.HABITUAL        | "hadvvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadvnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadvvga"
        "SG2" | "" | Tense.INFINITIVE      | "jadvdi"
        "SG1" | "" | Tense.PRESENT         | "gadvvsga"
        "SG1" | "" | Tense.HABITUAL        | "gadvvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "udvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wigadvvga"
        "SG1" | "" | Tense.INFINITIVE      | "udvdi"
        "SG3" | "" | Tense.PRESENT         | "anadvvsga"
        "SG3" | "" | Tense.HABITUAL        | "anadvvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unadvnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wanadvvga"
        "SG3" | "" | Tense.INFINITIVE      | "unadvdi"
    }
}
