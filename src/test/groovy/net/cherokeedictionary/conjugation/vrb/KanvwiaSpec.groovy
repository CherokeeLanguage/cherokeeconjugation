package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KanvwiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Curing, Doctoring / Soldering, Welding",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinvwia', habitual: 'jinvwisgoi', remote_past: 'akinvwanvi', imperative: 'jinvwvga', infinitive: 'akinvwodi'],
            [subject: 'SG2', object: '', present: 'hinvwia', habitual: 'hinvwisgoi', remote_past: 'jahnvwanvi', imperative: 'hinvwvga', infinitive: '/'],
            [subject: 'SG3', object: '', present: 'kanvwia', habitual: 'kanvwisgoi', remote_past: 'uhnvwanvi', imperative: 'kahnvwvga', infinitive: 'uhnvwodi'],
            [subject: 'PL3', object: '', present: 'aninvwia', habitual: 'aninvwisgoi', remote_past: 'unihnvwanvi', imperative: 'anihnvwvga', infinitive: 'unihnvwodi'],
            [subject: 'PL1INCL', object: '', present: 'idinvwia', habitual: 'idinvwisgoi', remote_past: 'igihnvwanvi', imperative: 'idihnvwvga', infinitive: 'igihnvwodi']
        ]
    ]

    @Unroll
    def "conjugating Kanvwia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kanvwia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinvwia"
        "SG1" | "" | Tense.HABITUAL        | "jinvwisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akinvwanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinvwvga"
        "SG1" | "" | Tense.INFINITIVE      | "akinvwodi"
        "SG2" | "" | Tense.PRESENT         | "hinvwia"
        "SG2" | "" | Tense.HABITUAL        | "hinvwisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahnvwanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinvwvga"
        // "SG2" | "" | Tense.INFINITIVE      | "/"
        "SG3" | "" | Tense.PRESENT         | "kanvwia"
        "SG3" | "" | Tense.HABITUAL        | "kanvwisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhnvwanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "kahnvwvga"
        "SG3" | "" | Tense.INFINITIVE      | "uhnvwodi"
        "PL3" | "" | Tense.PRESENT         | "aninvwia"
        "PL3" | "" | Tense.HABITUAL        | "aninvwisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihnvwanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihnvwvga"
        "PL3" | "" | Tense.INFINITIVE      | "unihnvwodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinvwia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinvwisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igihnvwanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idihnvwvga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igihnvwodi"
    }
}
