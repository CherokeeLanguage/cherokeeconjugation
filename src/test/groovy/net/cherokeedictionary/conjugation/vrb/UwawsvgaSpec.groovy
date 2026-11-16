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
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agiwawvsvga"
        "SG1" | "" | Tense.HABITUAL        | "agiwawvsvgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwawvsvtsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agiwawvsvtsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwawvsvsdi"
        "SG2" | "" | Tense.PRESENT         | "tsawawvsvga"
        "SG2" | "" | Tense.HABITUAL        | "tsawawvsvgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawawvsvtsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsawawvsvtsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawawvsvsdi"
        "SG3" | "" | Tense.PRESENT         | "uwawvsvga"
        "SG3" | "" | Tense.HABITUAL        | "uwawvsvgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwawvsvtsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwawvsvtsvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwawvsvsdi"
        "PL3" | "" | Tense.PRESENT         | "uniwawvsvga"
        "PL3" | "" | Tense.HABITUAL        | "uniwawvsvgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwawvsvtsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uniwawvsvtsvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwawvsvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igiwawvsvga"
        "PL1INCL" | "" | Tense.HABITUAL        | "igiwawvsvgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiwawvsvtsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igiwawvsvtsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwawvsvsdi"
    }
}
