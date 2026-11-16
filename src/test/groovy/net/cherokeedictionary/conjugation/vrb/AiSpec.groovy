// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72423 (entrya ai) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Walking",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gai'],
            [subject: 'SG3', object: '', habitual: 'aisoi', imperative: '', infinitive: '', present: 'ai', remote_past: 'aisvi']
        ]
    ]

    @Unroll
    def "conjugating Ai (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ai", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gai"
        "SG1" | "" | Tense.HABITUAL        | "gaisoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquaisvi"
        // "SG1" | "" | Tense.FUTURE_COMMAND      | "gaisvi"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
    }
}
