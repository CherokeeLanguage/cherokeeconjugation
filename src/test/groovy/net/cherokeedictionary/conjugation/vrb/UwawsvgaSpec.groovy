// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73975 (entrya uwawsvga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UwawsvgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Smells (182)*",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agiwsvga'],
            [subject: 'SG1', object: '', present: 'agiwsvga', habitual: 'agiwsvgoi', remote_past: 'agiwsvjvi', imperative: 'agiwsvgi', infinitive: 'agiwsvsdi'],
            [subject: 'SG2', object: '', present: 'jawsvga', habitual: 'jawsvgoi', remote_past: 'jawsvjvi', imperative: 'jawsvgi', infinitive: 'jawsvsdi'],
            [subject: 'SG3', object: '', habitual: 'uwawsvgoi', imperative: 'jawsvgi', infinitive: 'uwawsvsdi', present: 'uwawsvga', remote_past: 'uwawsvjvi'],
            [subject: 'PL3', object: '', present: 'uniwsvga', habitual: 'uniwsvgoi', remote_past: 'uniwsvjvi', imperative: 'uniwsvgi', infinitive: 'uniwsvsdi'],
            [subject: 'PL1INCL', object: '', present: 'igiwsvga', habitual: 'igiwsvgoi', remote_past: 'igiwsvjvi', imperative: 'igiwsvgi', infinitive: 'igiwsvsdi']
        ]
    ]

    @Unroll
    def "conjugating Uwawsvga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uwawsvga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agiwsvga"
        "SG1" | "" | Tense.HABITUAL        | "agiwsvgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwsvjvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agiwawvsvtsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwsvsdi"
        "SG2" | "" | Tense.PRESENT         | "jawsvga"
        "SG2" | "" | Tense.HABITUAL        | "jawsvgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jawsvjvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsawawvsvtsvi"
        "SG2" | "" | Tense.INFINITIVE      | "jawsvsdi"
        "SG3" | "" | Tense.PRESENT         | "uwawsvga"
        "SG3" | "" | Tense.HABITUAL        | "uwawsvgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwawsvjvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwawvsvtsvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwawsvsdi"
        "PL3" | "" | Tense.PRESENT         | "uniwsvga"
        "PL3" | "" | Tense.HABITUAL        | "uniwsvgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwsvjvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uniwawvsvtsvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwsvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igiwsvga"
        "PL1INCL" | "" | Tense.HABITUAL        | "igiwsvgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiwsvjvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igiwawvsvtsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwsvsdi"
    }
}
