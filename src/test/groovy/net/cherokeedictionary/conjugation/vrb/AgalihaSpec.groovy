// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72297 (entrya agaliha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AgalihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Shining (Moon/Sun Is)",
        // tio 17Nov26: IMPERSONAL verb -- no imperative exists (no agent to command; the book
        // box has no imperative column because the form is impermissible, not unattested).
        impersonal: true,
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', habitual: 'agalisgoi', imperative: '', infinitive: 'ugalihisdi', present: 'agaliha', remote_past: 'ugalisvi']
        ]
    ]

    @Unroll
    def "conjugating Agaliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Agaliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "agaliha"
        "SG3" | "" | Tense.HABITUAL        | "agalisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugalisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "agalisvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugalihisdi"
    }
}
