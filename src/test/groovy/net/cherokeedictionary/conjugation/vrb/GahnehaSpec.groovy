package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GahnehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Have With / Hold in Hand (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jineha', habitual: 'jinehoi', remote_past: 'jinehvi', imperative: 'jinehesdi', infinitive: 'jinehi'],
            [subject: 'SG2', object: '', present: 'hihneha', habitual: 'hihnehoi', remote_past: 'hihnehvi', imperative: 'hihnehesdi', infinitive: 'hihnehi'],
            [subject: 'SG1', object: '', present: 'gahneha', habitual: 'gahnehoi', remote_past: 'gahnehvi', imperative: 'gahnehesdi', infinitive: 'gahnehi'],
            [subject: 'PL3', object: '', present: 'anihneha', habitual: 'anihnehoi', remote_past: 'anihnehvi', imperative: 'anihnehesdi', infinitive: 'anihnehi']
        ]
    ]

    @Unroll
    def "conjugating Gahneha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gahneha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jineha"
        "SG1" | "" | Tense.HABITUAL        | "jinehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jinehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinehesdi"
        "SG1" | "" | Tense.INFINITIVE      | "jinehi"
        "SG2" | "" | Tense.PRESENT         | "hihneha"
        "SG2" | "" | Tense.HABITUAL        | "hihnehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hihnehvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihnehesdi"
        "SG2" | "" | Tense.INFINITIVE      | "hihnehi"
        "SG1" | "" | Tense.PRESENT         | "gahneha"
        "SG1" | "" | Tense.HABITUAL        | "gahnehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "gahnehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gahnehesdi"
        "SG1" | "" | Tense.INFINITIVE      | "gahnehi"
        "PL3" | "" | Tense.PRESENT         | "anihneha"
        "PL3" | "" | Tense.HABITUAL        | "anihnehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "anihnehvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihnehesdi"
        "PL3" | "" | Tense.INFINITIVE      | "anihnehi"
    }
}
