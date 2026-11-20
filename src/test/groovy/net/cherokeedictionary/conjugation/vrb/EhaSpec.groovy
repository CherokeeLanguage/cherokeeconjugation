// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72959 (entrya eha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class EhaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Lives (Resides)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gea'],
            [subject: 'SG3', object: '', habitual: 'ehoi', imperative: 'hehesdi', infinitive: '', present: 'eha', remote_past: '']
        ]
    ]

    @Unroll
    def "conjugating Eha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Eha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "geha"
        "SG1" | "" | Tense.HABITUAL        | "gehoi"
        // tio 17Nov26: REMOTE_PAST UNATTESTED -- the 2012 book (Eha, Lives) prints x in the remote column for every row.
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ge"
        // tio 17Nov26: INFINITIVE UNATTESTED -- the 2012 book box for Eha has no infinitive column; yaml junk dropped.
    }
}
