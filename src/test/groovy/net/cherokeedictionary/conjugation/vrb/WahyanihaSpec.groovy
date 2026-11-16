package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class WahyanihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Get (living)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'wijiyaniha', habitual: 'wijiyanisgoi', remote_past: 'wijiyanvhvi', imperative: 'wijiyana', infinitive: 'wijiyanhdi'],
            [subject: 'SG2', object: '', present: 'hwihyaniha', habitual: 'hwihyanisgoi', remote_past: 'hwihyanvhvi', imperative: 'hwiyana', infinitive: 'hwihyanhdi'],
            [subject: 'SG3', object: '', present: 'wahyaniha', habitual: 'wigahyanisgoi', remote_past: 'wuhyanvhvi', imperative: 'wayana', infinitive: 'wuhyanhdi'],
            [subject: 'SG3', object: '', present: 'wanihyaniha', habitual: 'wanihyanisgoi', remote_past: 'wunihyanvhvi', imperative: 'waniyana', infinitive: 'wunihyanhdi']
        ]
    ]

    @Unroll
    def "conjugating Wahyaniha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Wahyaniha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "witsiyaniha"
        "SG3" | "" | Tense.HABITUAL        | "witsiyanisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwitsiyanvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawitsiyanvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "utsiyanidi"
        "SG2" | "" | Tense.PRESENT         | "hitsiyaniha"
        "SG2" | "" | Tense.HABITUAL        | "hitsiyanisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawitsiyanvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwitsiyanvhvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatsiyanidi"
        "SG3" | "" | Tense.PRESENT         | "witsiyaniha"
        "SG3" | "" | Tense.HABITUAL        | "witsiyanisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwitsiyanvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawitsiyanvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "utsiyanidi"
        "SG3" | "" | Tense.PRESENT         | "witsiyaniha"
        "SG3" | "" | Tense.HABITUAL        | "witsiyanisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwitsiyanvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawitsiyanvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "utsiyanidi"
    }
}
