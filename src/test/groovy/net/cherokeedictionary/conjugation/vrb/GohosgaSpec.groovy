// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73248 (entrya gohosga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GohosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Fall from Elevated Position, IT (neutral; long)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'goosga'],
            [subject: 'SG3', object: '', habitual: 'gohosgoi', imperative: 'hohohi', infinitive: 'uwohohisdi', present: 'gohosga', remote_past: 'uwohosvi']
        ]
    ]

    @Unroll
    def "conjugating Gohosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gohosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "goosga"
        "SG1" | "" | Tense.HABITUAL        | "gohosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquohosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gohosvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwohohisdi"
    }
}
