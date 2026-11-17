// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73286 (entrya gutiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GutihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Snowing (It is)",
        // tio 17Nov26: IMPERSONAL verb -- no imperative exists (no agent to command; the book
        // box has no imperative column because the form is impermissible, not unattested).
        impersonal: true,
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', habitual: 'gutisgoi', imperative: '', infinitive: 'uwutohdi', present: 'gutiha', remote_past: 'uwutahnvi']
        ]
    ]

    @Unroll
    def "conjugating Gutiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gutiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gutiha"
        "SG1" | "" | Tense.HABITUAL        | "gutisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquutanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gutanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwudodi"
    }
}
