// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 74031 (entrya wahvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'wijivsga'],
            [subject: 'SG3', object: '', habitual: 'wahvsgoi', imperative: 'hwihvga', infinitive: 'wuhdi', present: 'wahvsga', remote_past: 'wuhnvi'],
            [subject: 'SG2', object: '', present: 'hwihvsga', habitual: 'hwihvsgoi', remote_past: 'wijahnvi', imperative: 'hwihvga', infinitive: 'wijahdi'],
            [subject: 'SG3', object: '', present: 'wahvsga', habitual: 'wahvsgoi', remote_past: 'wuhnvi', imperative: 'wahvga', infinitive: 'wuhdi'],
            [subject: 'SG3', object: '', present: 'wanihvsga', habitual: 'wanihvsgoi', remote_past: 'wunihnvi', imperative: 'wanihvga', infinitive: 'wunihdi']
        ]
    ]

    @Unroll
    def "conjugating Wahvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Wahvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "wahvsga"
        "SG3" | "" | Tense.HABITUAL        | "wahvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wuhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganvi"
        "SG3" | "" | Tense.INFINITIVE      | "wuhdi"
        "SG2" | "" | Tense.PRESENT         | "hwihvsga"
        "SG2" | "" | Tense.HABITUAL        | "hwihvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "wijahnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinvi"
        "SG2" | "" | Tense.INFINITIVE      | "wijahdi"
        "SG3" | "" | Tense.PRESENT         | "wahvsga"
        "SG3" | "" | Tense.HABITUAL        | "wahvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wuhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganvi"
        "SG3" | "" | Tense.INFINITIVE      | "wuhdi"
        "SG3" | "" | Tense.PRESENT         | "wanihvsga"
        "SG3" | "" | Tense.HABITUAL        | "wanihvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "wunihnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganvi"
        "SG3" | "" | Tense.INFINITIVE      | "wunihdi"
    }
}
