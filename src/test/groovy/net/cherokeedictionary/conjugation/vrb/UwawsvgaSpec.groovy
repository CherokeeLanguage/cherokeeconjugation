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
            [subject: 'SG1', object: '', present: 'agiwsvga', habitual: 'agiwsvgoi', remote_past: 'agiwsvjvi', imperative: 'agiwsvgi', infinitive: 'agiwsvsdi'],
            [subject: 'SG2', object: '', present: 'jawsvga', habitual: 'jawsvgoi', remote_past: 'jawsvjvi', imperative: 'jawsvgi', infinitive: 'jawsvsdi'],
            [subject: 'SG3', object: '', present: 'uwawsvga', habitual: 'uwawsvgoi', remote_past: 'uwawsvjvi', imperative: 'uwawsvgi', infinitive: 'uwawsvsdi'],
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
        "SG1" | "" | Tense.PRESENT         | "agiwsvga"
        "SG1" | "" | Tense.HABITUAL        | "agiwsvgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwsvjvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agiwsvgi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwsvsdi"
        "SG2" | "" | Tense.PRESENT         | "jawsvga"
        "SG2" | "" | Tense.HABITUAL        | "jawsvgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jawsvjvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jawsvgi"
        "SG2" | "" | Tense.INFINITIVE      | "jawsvsdi"
        "SG3" | "" | Tense.PRESENT         | "uwawsvga"
        "SG3" | "" | Tense.HABITUAL        | "uwawsvgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwawsvjvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwawsvgi"
        "SG3" | "" | Tense.INFINITIVE      | "uwawsvsdi"
        "PL3" | "" | Tense.PRESENT         | "uniwsvga"
        "PL3" | "" | Tense.HABITUAL        | "uniwsvgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwsvjvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uniwsvgi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwsvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igiwsvga"
        "PL1INCL" | "" | Tense.HABITUAL        | "igiwsvgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiwsvjvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igiwsvgi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwsvsdi"
    }
}
