// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72558 (entrya anina) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AninaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Sitting, They Are (Congregation)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'ojina'],
            [subject: 'SG3', object: '', habitual: 'aninoi', imperative: '', infinitive: '', present: 'anina', remote_past: 'aninvi']
        ]
    ]

    @Unroll
    def "conjugating Anina (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Anina", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "anina"
        "SG3" | "" | Tense.HABITUAL        | "aninoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uninvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "aninvi"
        "SG3" | "" | Tense.INFINITIVE      | "x"
    }
}
