// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72530 (entrya alsgwadia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlsgwadiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "It Is Ending/Finishing",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', habitual: 'alsgwadisgoi', imperative: '', infinitive: 'ulsgwadisdi', present: 'alsgwadia', remote_past: 'ulsgwadvi']
        ]
    ]

    @Unroll
    def "conjugating Alsgwadia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alsgwadia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "alisquadia"
        "SG3" | "" | Tense.HABITUAL        | "alisquadisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulisquadvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alisquadvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulisquadisdi"
    }
}
