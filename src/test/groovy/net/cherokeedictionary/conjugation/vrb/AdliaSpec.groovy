// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72277 (entrya adlia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdliaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Put in Container (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jidlia'],
            [subject: 'SG1', object: '', present: 'jidlia', habitual: 'jidlisgoi', remote_past: 'agidlvi', imperative: 'jidliga', infinitive: 'agidlisdi'],
            [subject: 'SG2', object: '', present: 'hidlia', habitual: 'hidlisgoi', remote_past: 'jadlvi', imperative: 'hidliga', infinitive: 'jadlisdi'],
            [subject: 'SG3', object: '', habitual: 'adlisgoi', imperative: 'hidliga', infinitive: 'udlisdi', present: 'adlia', remote_past: 'udlvi'],
            [subject: 'PL3', object: '', present: 'anidlia', habitual: 'anidlisgoi', remote_past: 'unidlvi', imperative: 'wanidliga', infinitive: 'unidlisdi']
        ]
    ]

    @Unroll
    def "conjugating Adlia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adlia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsitlia"
        "SG1" | "" | Tense.HABITUAL        | "tsitlisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agitlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsitlvi"
        "SG1" | "" | Tense.INFINITIVE      | "agitlisdi"
        "SG2" | "" | Tense.PRESENT         | "hitlia"
        "SG2" | "" | Tense.HABITUAL        | "hitlisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hitlvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatlisdi"
        "SG3" | "" | Tense.PRESENT         | "atlia"
        "SG3" | "" | Tense.HABITUAL        | "atlisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atlvi"
        "SG3" | "" | Tense.INFINITIVE      | "utlisdi"
        "PL3" | "" | Tense.PRESENT         | "anitlia"
        "PL3" | "" | Tense.HABITUAL        | "anitlisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unitlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anitlvi"
        "PL3" | "" | Tense.INFINITIVE      | "unitlisdi"
    }
}
