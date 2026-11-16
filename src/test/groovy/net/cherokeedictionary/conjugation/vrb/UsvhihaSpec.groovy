// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73947 (entrya usvhiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UsvhihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Going to Bed",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'aksvhiha'],
            [subject: 'SG1', object: '', present: 'aksvhiha', habitual: 'aksvhihoi', remote_past: 'aksvhlvi', imperative: 'aksvha', infinitive: 'aksvsdi'],
            [subject: 'SG3', object: '', habitual: 'usvhihoi', imperative: 'tsvha', infinitive: 'usvsdi', present: 'usvhiha', remote_past: 'usvhlvi'],
            [subject: 'SG3', object: '', present: 'usvhiha', habitual: 'usvhihoi', remote_past: 'usvhlvi', imperative: 'usvha', infinitive: 'usvsdi'],
            [subject: 'SG3', object: '', present: 'iksvhiha', habitual: 'iksvhihoi', remote_past: 'iksvhlvi', imperative: 'iksvha', infinitive: 'iksvsdi']
        ]
    ]

    @Unroll
    def "conjugating Usvhiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Usvhiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agisvhiha"
        "SG1" | "" | Tense.HABITUAL        | "agisvhihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agisvtlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agisvtlvi"
        "SG1" | "" | Tense.INFINITIVE      | "agisvsdi"
        "SG3" | "" | Tense.PRESENT         | "usvhiha"
        "SG3" | "" | Tense.HABITUAL        | "usvhihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usvtlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "usvtlvi"
        "SG3" | "" | Tense.INFINITIVE      | "usvsdi"
        "SG3" | "" | Tense.PRESENT         | "usvhiha"
        "SG3" | "" | Tense.HABITUAL        | "usvhihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usvtlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "usvtlvi"
        "SG3" | "" | Tense.INFINITIVE      | "usvsdi"
        "SG3" | "" | Tense.PRESENT         | "usvhiha"
        "SG3" | "" | Tense.HABITUAL        | "usvhihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usvtlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "usvtlvi"
        "SG3" | "" | Tense.INFINITIVE      | "usvsdi"
    }
}
