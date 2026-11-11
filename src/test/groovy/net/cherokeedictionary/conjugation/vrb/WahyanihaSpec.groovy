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
        "SG3" | "" | Tense.PRESENT         | "wijiyaniha"
        "SG3" | "" | Tense.HABITUAL        | "wijiyanisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wijiyanvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wijiyana"
        "SG3" | "" | Tense.INFINITIVE      | "wijiyanhdi"
        "SG2" | "" | Tense.PRESENT         | "hwihyaniha"
        "SG2" | "" | Tense.HABITUAL        | "hwihyanisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hwihyanvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hwiyana"
        "SG2" | "" | Tense.INFINITIVE      | "hwihyanhdi"
        "SG3" | "" | Tense.PRESENT         | "wahyaniha"
        "SG3" | "" | Tense.HABITUAL        | "wigahyanisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wuhyanvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wayana"
        "SG3" | "" | Tense.INFINITIVE      | "wuhyanhdi"
        "SG3" | "" | Tense.PRESENT         | "wanihyaniha"
        "SG3" | "" | Tense.HABITUAL        | "wanihyanisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wunihyanvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "waniyana"
        "SG3" | "" | Tense.INFINITIVE      | "wunihyanhdi"
    }
}
