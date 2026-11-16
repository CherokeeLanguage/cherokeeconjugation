// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72402 (entrya ahyahtvhvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhyahtvhvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Frosting (It is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', habitual: 'ahyahtvhvsgoi', imperative: '', infinitive: 'uhyahtvtdi', present: 'ahyahtvhvsga', remote_past: 'uhyahtvhnvi']
        ]
    ]

    @Unroll
    def "conjugating Ahyahtvhvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahyahtvhvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "ayadvhvsga"
        "SG3" | "" | Tense.HABITUAL        | "ayadvhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyadvnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ayadvnvi"
        "SG3" | "" | Tense.INFINITIVE      | "uyadvtidi"
    }
}
