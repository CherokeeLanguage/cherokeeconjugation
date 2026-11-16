// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 74046 (entrya wigakahvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class WigakahvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Send (living)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'wijiyakahvsga'],
            [subject: 'SG3', object: '', habitual: 'wigakahvsgoi', imperative: 'hwiyakahvga', infinitive: 'wuwakohdi', present: 'wigakahvsga', remote_past: 'wuwakanvi'],
            [subject: 'SG2', object: '', present: 'hwiyakahvsga', habitual: 'hwiyakahvsgoi', remote_past: 'hwiyakanvi', imperative: 'hwiyakahvga', infinitive: 'hwiyakohdi'],
            [subject: 'SG3', object: '', present: 'wigakahvsga', habitual: 'wigakahvsgoi', remote_past: 'wuwakanvi', imperative: 'wigakahvga', infinitive: 'wuwakohdi'],
            [subject: 'SG3', object: '', present: 'wanakahvsga', habitual: 'wanakahvsgoi', remote_past: 'wunakanvi', imperative: 'wanakahvga', infinitive: 'wunakohdi']
        ]
    ]

    @Unroll
    def "conjugating Wigakahvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Wigakahvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "wigakahvsga"
        "SG3" | "" | Tense.HABITUAL        | "wigakahvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ukanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "akanvi"
        "SG3" | "" | Tense.INFINITIVE      | "wijiyakohdi"
        "SG2" | "" | Tense.PRESENT         | "hakahvsga"
        "SG2" | "" | Tense.HABITUAL        | "hakahvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsakanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hakanvi"
        "SG2" | "" | Tense.INFINITIVE      | "hwiyakohdi"
        "SG3" | "" | Tense.PRESENT         | "wigakahvsga"
        "SG3" | "" | Tense.HABITUAL        | "wigakahvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ukanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "akanvi"
        "SG3" | "" | Tense.INFINITIVE      | "wuwakohdi"
        "SG3" | "" | Tense.PRESENT         | "wigakahvsga"
        "SG3" | "" | Tense.HABITUAL        | "wigakahvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ukanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "akanvi"
        "SG3" | "" | Tense.INFINITIVE      | "wunakohdi"
    }
}
