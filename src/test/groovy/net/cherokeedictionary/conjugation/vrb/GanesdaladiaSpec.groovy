// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73117 (entrya ganesdaladia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanesdaladiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Freezing (It is)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinesdaladia'],
            [subject: 'SG3', object: '', habitual: 'ganesdaladisgoi', imperative: 'hinesdalada', infinitive: 'unesdaladisdi', present: 'ganesdaladia', remote_past: 'unesdaladvi']
        ]
    ]

    @Unroll
    def "conjugating Ganesdaladia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganesdaladia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinesdaladia"
        "SG1" | "" | Tense.HABITUAL        | "tsinesdaladisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginesdaladvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinesdaladvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginesdaladisdi"
    }
}
