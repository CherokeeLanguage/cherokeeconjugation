// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72360 (entrya ahliilidoha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhliilidohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Its Taking Time (22)",
        // tio 17Nov26: no imperative ON PURPOSE (user verdict 2026-11-17) -- annotated with the
        // impersonal cohort; the imperative is impermissible, not unattested.
        impersonal: true,
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', habitual: 'ahliilidohoi', imperative: '', infinitive: 'uhliilidasdi', present: 'ahliilidoha', remote_past: 'uhliilidolvi']
        ]
    ]

    @Unroll
    def "conjugating Ahliilidoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahliilidoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "ahliilidoha"
        "SG3" | "" | Tense.HABITUAL        | "ahliilidohoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhliilidolvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atliilidolvi"
        "SG3" | "" | Tense.INFINITIVE      | "uhliilidasdi"
    }
}
