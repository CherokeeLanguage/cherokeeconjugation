// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72547 (entrya anagaliha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AnagalihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Lightning (It is)",
        // tio 17Nov26: IMPERSONAL verb -- no imperative exists (no agent to command; the book
        // box has no imperative column because the form is impermissible, not unattested).
        impersonal: true,
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', habitual: 'anagalisgoi', imperative: '', infinitive: '', present: 'anagaliha', remote_past: 'unagalvhvi']
        ]
    ]

    @Unroll
    def "conjugating Anagaliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Anagaliha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "anagaliha"
        "SG3" | "" | Tense.HABITUAL        | "anagalisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unagalvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anagalvhvi"
        // tio 17Nov26: INFINITIVE UNATTESTED -- the 2012 book box for Anagaliha (Lightning) has no infinitive column; yaml junk dropped.
    }
}
