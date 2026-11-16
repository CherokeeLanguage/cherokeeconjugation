package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DulvwisdanehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Working",
        part_of_speech: "v.i.",
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
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agilvwisdaneha"
        "SG1" | "" | Tense.HABITUAL        | "agilvwisdanehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agilvwisdanelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agilvwisdanelvi"
        "SG1" | "" | Tense.INFINITIVE      | "agilvwisdanedi"
        "SG2" | "" | Tense.PRESENT         | "tsalvwisdaneha"
        "SG2" | "" | Tense.HABITUAL        | "tsalvwisdanehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalvwisdanelvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsalvwisdanelvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsalvwisdanedi"
        "SG3" | "" | Tense.PRESENT         | "dulvwisdaneha"
        "SG3" | "" | Tense.HABITUAL        | "dulvwisdanehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dulvwisdanelvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dulvwisdanelvi"
        "SG3" | "" | Tense.INFINITIVE      | "dulvwisdanedi"
        "PL3" | "" | Tense.PRESENT         | "unilvwisdaneha"
        "PL3" | "" | Tense.HABITUAL        | "unilvwisdanehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unilvwisdanelvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unilvwisdanelvi"
        "PL3" | "" | Tense.INFINITIVE      | "unilvwisdanedi"
        "PL1INCL" | "" | Tense.PRESENT         | "igilvwisdaneha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igilvwisdanehoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igilvwisdanelvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igilvwisdanelvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igilvwisdanedi"
    }
}
