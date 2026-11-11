package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyavsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Put in Container (living)",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyavsga', habitual: 'jiyavsgoi', remote_past: 'jiyanvi', imperative: 'jiyavga', infinitive: 'jiyodi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyavsga', habitual: 'hiyavsgoi', remote_past: 'hiyanvi', imperative: 'hiyavga', infinitive: 'hiyodi'],
            [subject: 'SG3', object: '', present: 'ayavsga', habitual: 'ayavsgoi', remote_past: 'uyanvi', imperative: 'wayavga', infinitive: 'uyodi'],
            [subject: 'PL3', object: '', present: 'aniyavsga', habitual: 'aniyavsgoi', remote_past: 'uniyanvi', imperative: 'waniyavga', infinitive: 'uniyodi']
        ]
    ]

    @Unroll
    def "conjugating Ayavsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayavsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyavsga"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyavsgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyavga"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyodi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyavsga"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyavsgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyavga"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyodi"
        "SG3" | "" | Tense.PRESENT         | "ayavsga"
        "SG3" | "" | Tense.HABITUAL        | "ayavsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wayavga"
        "SG3" | "" | Tense.INFINITIVE      | "uyodi"
        "PL3" | "" | Tense.PRESENT         | "aniyavsga"
        "PL3" | "" | Tense.HABITUAL        | "aniyavsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "waniyavga"
        "PL3" | "" | Tense.INFINITIVE      | "uniyodi"
    }
}
