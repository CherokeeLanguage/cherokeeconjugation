// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73063 (entrya galihwoga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GalihwogaSpec extends VerbBaseSpec {
    static def details = [
        definition: "It Is Dying (Animal/Plant)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiliwoga'],
            [subject: 'SG3', object: '', habitual: 'galihwogoi', imperative: 'hilihwogi', infinitive: 'ulihwosdi', present: 'galihwoga', remote_past: 'ulihwojvi']
        ]
    ]

    @Unroll
    def "conjugating Galihwoga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Galihwoga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiliwoga"
        "SG1" | "" | Tense.HABITUAL        | "tsiliwogoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiliwotsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiliwotsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiliwosdi"
    }
}
