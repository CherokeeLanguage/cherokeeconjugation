package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class WahvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Send (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'wijivsga', habitual: 'wijivsgoi', remote_past: 'wagihnvi', imperative: 'wijivga', infinitive: 'wagihdi'],
            [subject: 'SG2', object: '', present: 'hwihvsga', habitual: 'hwihvsgoi', remote_past: 'wijahnvi', imperative: 'hwihvga', infinitive: 'wijahdi'],
            [subject: 'SG3', object: '', present: 'wahvsga', habitual: 'wahvsgoi', remote_past: 'wuhnvi', imperative: 'wahvga', infinitive: 'wuhdi'],
            [subject: 'SG3', object: '', present: 'wanihvsga', habitual: 'wanihvsgoi', remote_past: 'wunihnvi', imperative: 'wanihvga', infinitive: 'wunihdi']
        ]
    ]

    @Unroll
    def "conjugating Wahvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Wahvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "wijivsga"
        "SG3" | "" | Tense.HABITUAL        | "wijivsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wagihnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wijivga"
        "SG3" | "" | Tense.INFINITIVE      | "wagihdi"
        "SG2" | "" | Tense.PRESENT         | "hwihvsga"
        "SG2" | "" | Tense.HABITUAL        | "hwihvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "wijahnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hwihvga"
        "SG2" | "" | Tense.INFINITIVE      | "wijahdi"
        "SG3" | "" | Tense.PRESENT         | "wahvsga"
        "SG3" | "" | Tense.HABITUAL        | "wahvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wuhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wahvga"
        "SG3" | "" | Tense.INFINITIVE      | "wuhdi"
        "SG3" | "" | Tense.PRESENT         | "wanihvsga"
        "SG3" | "" | Tense.HABITUAL        | "wanihvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wunihnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wanihvga"
        "SG3" | "" | Tense.INFINITIVE      | "wunihdi"
    }
}
