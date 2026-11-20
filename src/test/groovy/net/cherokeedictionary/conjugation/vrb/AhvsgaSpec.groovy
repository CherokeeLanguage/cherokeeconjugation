// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72394 (entrya ahvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Set Down (neutral) (26)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jivsga'],
            [subject: 'SG1', object: '', present: 'jivsga', habitual: 'jivsgoi', remote_past: 'agihnvi', imperative: 'jivga', infinitive: 'agihdi'],
            [subject: 'SG2', object: '', present: 'hihvsga', habitual: 'hihvsgoi', remote_past: 'jahnvi', imperative: 'hihvga', infinitive: 'jahdi'],
            [subject: 'SG3', object: '', habitual: 'ahvsgoi', imperative: 'hihvga', infinitive: 'uhdi', present: 'ahvsga', remote_past: 'uhnvi'],
            [subject: 'PL3', object: '', present: 'anihvsga', habitual: 'anihvsgoi', remote_past: 'unihnvi', imperative: 'wanihvga', infinitive: 'unihdi']
        ]
    ]

    @Unroll
    def "conjugating Ahvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jivsga"
        "SG1" | "" | Tense.HABITUAL        | "jivsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agihnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinvi"
        "SG1" | "" | Tense.INFINITIVE      | "agihdi"
        "SG2" | "" | Tense.PRESENT         | "hihvsga"
        "SG2" | "" | Tense.HABITUAL        | "hihvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinvi"
        "SG2" | "" | Tense.INFINITIVE      | "jahdi"
        "SG3" | "" | Tense.PRESENT         | "ahvsga"
        "SG3" | "" | Tense.HABITUAL        | "ahvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anvi"
        "SG3" | "" | Tense.INFINITIVE      | "uhdi"
        "PL3" | "" | Tense.PRESENT         | "anihvsga"
        "PL3" | "" | Tense.HABITUAL        | "anihvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninvi"
        "PL3" | "" | Tense.INFINITIVE      | "unihdi"
    }
}
