// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72303 (entrya aganawosga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AganawosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Getting Warm (It is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', habitual: 'aganawosgoi', imperative: '', infinitive: 'uganawohisdi', present: 'aganawosga', remote_past: 'uganawosvi']
        ]
    ]

    @Unroll
    def "conjugating Aganawosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aganawosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "aganawosga"
        "SG3" | "" | Tense.HABITUAL        | "aganawosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uganawosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "aganawosvi"
        "SG3" | "" | Tense.INFINITIVE      | "uganawohisdi"
    }
}
