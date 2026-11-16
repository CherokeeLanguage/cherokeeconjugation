// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72395 (entrya ahwahtiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhwahtihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Find (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiwahtiha'],
            [subject: 'SG1', object: '', present: 'jiwahtiha', habitual: 'jiwahtisgoi', remote_past: 'agihwahtvhvi', imperative: 'jiwahta', infinitive: 'agihwahtvhdi'],
            [subject: 'SG2', object: '', present: 'hihwahtiha', habitual: 'hihwahtisgoi', remote_past: 'jahwahtvhvi', imperative: 'hihwahta', infinitive: 'jahwahtvhdi'],
            [subject: 'SG3', object: '', habitual: 'ahwahtisgoi', imperative: 'hiwahta, hihwahta', infinitive: 'uhwahtvhdi', present: 'ahwahtiha', remote_past: 'uhwahtvhvi'],
            [subject: 'PL3', object: '', present: 'anihwahtiha', habitual: 'anihwahtisgoi', remote_past: 'unihwahtvhvi', imperative: 'anihwahta', infinitive: 'unihwahtvhdi']
        ]
    ]

    @Unroll
    def "conjugating Ahwahtiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahwahtiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsiwatiha"
        "SG1" | "" | Tense.HABITUAL        | "tsiwatisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwadvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwadvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwadvdi"
        "SG2" | "" | Tense.PRESENT         | "hiwatiha"
        "SG2" | "" | Tense.HABITUAL        | "hiwatisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawadvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwadvhvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawadvdi"
        "SG3" | "" | Tense.PRESENT         | "awatiha"
        "SG3" | "" | Tense.HABITUAL        | "awatisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwadvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "awadvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwadvdi"
        "PL3" | "" | Tense.PRESENT         | "aniwatiha"
        "PL3" | "" | Tense.HABITUAL        | "aniwatisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwadvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwadvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwadvdi"
    }
}
