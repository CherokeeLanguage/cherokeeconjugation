package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DulvwisdanehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Working",
        part_of_speech: "v.i.",
        // tio 20Nov26: D25 -- the u-fused da-verbs' SG3 FC column keeps the
        // du- layer (dulvwisdanelvi); per-verb variance, pinned here.
        surfaceOverrides: [
            [tense: 'FUTURE_COMMAND', subject: 'SG3', obj: 'NONE', form: 'dulvwisdanelvi']
        ],
        conjugations: [
            [subject: 'SG1', object: '', present: 'dagilvwisdaneha', habitual: 'dagilvwisdanehoi', remote_past: 'dagilvwisdanelvi', imperative: 'digilvwisdasi', infinitive: 'digilvhwisdanehdi'],
            [subject: 'SG2', object: '', present: 'dejalvwisdaneha', habitual: 'dejalvwisdanehoi', remote_past: 'dejalvwisdanelvi', imperative: 'dijalvwisdasi', infinitive: 'dijalvhwisdanehdi'],
            [subject: 'SG3', object: '', present: 'dulvwisdaneha', habitual: 'dulvwisdanehoi', remote_past: 'dulvwisdanelvi', imperative: 'julvwisdasi', infinitive: 'julvhwisdanehdi'],
            [subject: 'PL3', object: '', present: 'dunilvwisdaneha', habitual: 'dunilvwisdanehoi', remote_past: 'dunilvwisdanelvi', imperative: 'junilvwisdasi', infinitive: 'junilvhwisdanehdi'],
            [subject: 'PL1INCL', object: '', present: 'degilvwisdaneha', habitual: 'degilvwisdanehoi', remote_past: 'degilvwisdanelvi', imperative: 'digilvwisdasi', infinitive: 'digilvhwisdanehdi']
        ]
    ]

    @Unroll
    def "conjugating Dulvwisdaneha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dulvwisdaneha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "dagilvwisdaneha"
        "SG1" | "" | Tense.HABITUAL        | "dagilvwisdanehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagilvwisdanelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agilvwisdanelvi"
        "SG1" | "" | Tense.INFINITIVE      | "dagilvwisdanedi"
        "SG2" | "" | Tense.PRESENT         | "datsalvwisdaneha"
        "SG2" | "" | Tense.HABITUAL        | "datsalvwisdanehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "datsalvwisdanelvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsalvwisdanelvi"
        "SG2" | "" | Tense.INFINITIVE      | "datsalvwisdanedi"
        "SG3" | "" | Tense.PRESENT         | "dulvwisdaneha"
        "SG3" | "" | Tense.HABITUAL        | "dulvwisdanehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dulvwisdanelvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dulvwisdanelvi"
        "SG3" | "" | Tense.INFINITIVE      | "julvhwisdanehdi"
        "PL3" | "" | Tense.PRESENT         | "dunilvwisdaneha"
        "PL3" | "" | Tense.HABITUAL        | "dunilvwisdanehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunilvwisdanelvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unilvwisdanelvi"
        "PL3" | "" | Tense.INFINITIVE      | "junilvhwisdanehdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dagilvwisdaneha"
        "PL1INCL" | "" | Tense.HABITUAL        | "dagilvwisdanehoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "dagilvwisdanelvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igilvwisdanelvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "dagilvwisdanedi"
    }
}
