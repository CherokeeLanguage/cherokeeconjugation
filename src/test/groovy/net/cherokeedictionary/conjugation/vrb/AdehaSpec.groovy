// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72243 (entrya adeha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Give/Pass (long)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jideha'],
            [subject: 'SG1', object: '', present: 'jideha', habitual: 'jidehoi', remote_past: 'jidelvi', imperative: 'jidisi', infinitive: 'jidehdi'],
            [subject: 'SG2', object: '', present: 'hideha', habitual: 'hidehoi', remote_past: 'hidelvi', imperative: 'hidisi', infinitive: 'hidehdi'],
            [subject: 'SG3', object: '', habitual: 'adehoi', imperative: 'hidisi', infinitive: 'udehdi', present: 'adeha', remote_past: 'udelvi'],
            [subject: 'PL3', object: '', present: 'anideha', habitual: 'anidehoi', remote_past: 'unidelvi', imperative: 'anidisi', infinitive: 'unidehdi']
        ]
    ]

    @Unroll
    def "conjugating Adeha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adeha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsideha"
        "SG1" | "" | Tense.HABITUAL        | "tsidehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agidelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsidelvi"
        "SG1" | "" | Tense.INFINITIVE      | "agidedi"
        "SG2" | "" | Tense.PRESENT         | "hideha"
        "SG2" | "" | Tense.HABITUAL        | "hidehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadelvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hidelvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadedi"
        "SG3" | "" | Tense.PRESENT         | "adeha"
        "SG3" | "" | Tense.HABITUAL        | "adehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udelvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adelvi"
        "SG3" | "" | Tense.INFINITIVE      | "udedi"
        "PL3" | "" | Tense.PRESENT         | "anideha"
        "PL3" | "" | Tense.HABITUAL        | "anidehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unidelvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anidelvi"
        "PL3" | "" | Tense.INFINITIVE      | "unidedi"
    }
}
