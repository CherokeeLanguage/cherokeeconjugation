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
        "SG1" | "" | Tense.PRESENT         | "dagilvwisdaneha"
        "SG1" | "" | Tense.HABITUAL        | "dagilvwisdanehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagilvwisdanelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "digilvwisdasi"
        "SG1" | "" | Tense.INFINITIVE      | "digilvhwisdanehdi"
        "SG2" | "" | Tense.PRESENT         | "dejalvwisdaneha"
        "SG2" | "" | Tense.HABITUAL        | "dejalvwisdanehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejalvwisdanelvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "dijalvwisdasi"
        "SG2" | "" | Tense.INFINITIVE      | "dijalvhwisdanehdi"
        "SG3" | "" | Tense.PRESENT         | "dulvwisdaneha"
        "SG3" | "" | Tense.HABITUAL        | "dulvwisdanehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dulvwisdanelvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "julvwisdasi"
        "SG3" | "" | Tense.INFINITIVE      | "julvhwisdanehdi"
        "PL3" | "" | Tense.PRESENT         | "dunilvwisdaneha"
        "PL3" | "" | Tense.HABITUAL        | "dunilvwisdanehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunilvwisdanelvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "junilvwisdasi"
        "PL3" | "" | Tense.INFINITIVE      | "junilvhwisdanehdi"
        "PL1INCL" | "" | Tense.PRESENT         | "degilvwisdaneha"
        "PL1INCL" | "" | Tense.HABITUAL        | "degilvwisdanehoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degilvwisdanelvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "digilvwisdasi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digilvhwisdanehdi"
    }
}
