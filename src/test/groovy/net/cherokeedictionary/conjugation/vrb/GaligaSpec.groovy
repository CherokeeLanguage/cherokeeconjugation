// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73061 (entrya galiga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GaligaSpec extends VerbBaseSpec {
    static def details = [
        definition: "It Is Burning",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', habitual: 'galigoi', imperative: '', infinitive: '', present: 'galiga', remote_past: 'ulijvi']
        ]
    ]

    @Unroll
    def "conjugating Galiga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Galiga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsiliga"
        "SG1" | "" | Tense.HABITUAL        | "tsiligoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agilitsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsilitsvi"
        "SG1" | "" | Tense.INFINITIVE      | "It"
    }
}
