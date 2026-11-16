// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72725 (entrya ayvhwahtiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyvhwahtihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Find (long)",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyvwahtiha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyvwahtiha', habitual: 'jiyvwahtisgoi', remote_past: 'agiyvhwahtvhvi', imperative: 'jiyvwahta', infinitive: 'agiyvhwahtvhdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyvhwahtiha', habitual: 'hiyvhwahtisgoi', remote_past: 'jayvhwahtvhvi', imperative: 'hiyvhwahta', infinitive: 'jayvhwahtvhdi'],
            [subject: 'SG3', object: '', habitual: 'ayvhwahtisgoi', imperative: 'hiyvhwahta', infinitive: 'uyvhwahtvhdi', present: 'ayvhwahtiha', remote_past: 'uyvhwahtvhvi'],
            [subject: 'PL3', object: '', present: 'aniyvhwahtiha', habitual: 'aniyvhwahtisgoi', remote_past: 'uniyvhwahtvhvi', imperative: 'aniyvhwahta', infinitive: 'uniyvhwahtvhdi']
        ]
    ]

    @Unroll
    def "conjugating Ayvhwahtiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayvhwahtiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyvwatiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyvwatisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyvwadvhvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyvwadvhvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyvwadvdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyvwatiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyvwatisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "yvwadvhvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyvwadvhvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "yvwadvdi"
        "SG3" | "" | Tense.PRESENT         | "ayvwatiha"
        "SG3" | "" | Tense.HABITUAL        | "ayvwatisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyvwadvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ayvwadvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "uyvwadvdi"
        "PL3" | "" | Tense.PRESENT         | "aniyvwatiha"
        "PL3" | "" | Tense.HABITUAL        | "aniyvwatisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyvwadvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniyvwadvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyvwadvdi"
    }
}
