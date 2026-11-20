// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72412 (entrya ahyvdagwaloa) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhyvdagwaloaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Thundering (It is)",
        // tio 17Nov26: IMPERSONAL verb -- no imperative exists (no agent to command; the book
        // box has no imperative column because the form is impermissible, not unattested).
        impersonal: true,
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', habitual: 'ahyvdagwalosgoi', imperative: '', infinitive: 'uhyvdagwalosdi', present: 'ahyvdagwaloa', remote_past: 'uhyvdagwalovi']
        ]
    ]

    @Unroll
    def "conjugating Ahyvdagwaloa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahyvdagwaloa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "ahyvdagwaloa"
        "SG3" | "" | Tense.HABITUAL        | "ahyvdagwalosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhyvdagwalovi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ayvdaqualovi"
        "SG3" | "" | Tense.INFINITIVE      | "uhyvdagwalosdi"
    }
}
