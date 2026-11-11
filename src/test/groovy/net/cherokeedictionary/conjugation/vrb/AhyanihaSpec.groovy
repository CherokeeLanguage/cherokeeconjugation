package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhyanihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Receive (living)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiyaniha', habitual: 'jiyanisgoi', remote_past: 'jiyanvhvi', imperative: 'jiyana', infinitive: 'jiyanhdi'],
            [subject: 'SG2', object: '', present: 'hihyaniha', habitual: 'hihyanisgoi', remote_past: 'hihyanvhvi', imperative: 'hwahyana', infinitive: 'hihyanhdi'],
            [subject: 'SG3', object: '', present: 'ahyaniha', habitual: 'ahyanisgoi', remote_past: 'uhyanvhvi', imperative: 'wahyana', infinitive: 'uhyanhdi'],
            [subject: 'PL3', object: '', present: 'anihyaniha', habitual: 'anihyanisgoi', remote_past: 'unihyanvhvi', imperative: 'wanihyana', infinitive: 'unihyanhdi']
        ]
    ]

    @Unroll
    def "conjugating Ahyaniha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahyaniha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiyaniha"
        "SG1" | "" | Tense.HABITUAL        | "jiyanisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jiyanvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jiyana"
        "SG1" | "" | Tense.INFINITIVE      | "jiyanhdi"
        "SG2" | "" | Tense.PRESENT         | "hihyaniha"
        "SG2" | "" | Tense.HABITUAL        | "hihyanisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hihyanvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hwahyana"
        "SG2" | "" | Tense.INFINITIVE      | "hihyanhdi"
        "SG3" | "" | Tense.PRESENT         | "ahyaniha"
        "SG3" | "" | Tense.HABITUAL        | "ahyanisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhyanvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wahyana"
        "SG3" | "" | Tense.INFINITIVE      | "uhyanhdi"
        "PL3" | "" | Tense.PRESENT         | "anihyaniha"
        "PL3" | "" | Tense.HABITUAL        | "anihyanisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihyanvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "wanihyana"
        "PL3" | "" | Tense.INFINITIVE      | "unihyanhdi"
    }
}
