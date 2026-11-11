package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GohweliaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Writing",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'degowelia', habitual: 'degowelisgoi', remote_past: 'agwohwelanvi', imperative: 'gowelvga', infinitive: 'agwohwelohdi'],
            [subject: 'SG2', object: '', present: 'dehowelia', habitual: 'dehohwelisgoi', remote_past: 'johwelanvi', imperative: 'hohwelvga', infinitive: 'johwelohdi'],
            [subject: 'SG3', object: '', present: 'degohwelia', habitual: 'degohwelisgoi', remote_past: 'uwowelanvi', imperative: 'gohwelvga', infinitive: 'uwohwelohdi'],
            [subject: 'PL3', object: '', present: 'danohwelia', habitual: 'danohwelisgoi', remote_past: 'dunohwelanvi', imperative: 'dinohwelvga', infinitive: 'junohwelohdi'],
            [subject: 'PL1INCL', object: '', present: 'dedohwelia', habitual: 'dedohwelisgoi', remote_past: 'degohwelanvi', imperative: 'didohwelvga', infinitive: 'digohwelohdi']
        ]
    ]

    @Unroll
    def "conjugating Gohwelia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gohwelia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degowelia"
        "SG1" | "" | Tense.HABITUAL        | "degowelisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwohwelanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gowelvga"
        "SG1" | "" | Tense.INFINITIVE      | "agwohwelohdi"
        "SG2" | "" | Tense.PRESENT         | "dehowelia"
        "SG2" | "" | Tense.HABITUAL        | "dehohwelisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "johwelanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hohwelvga"
        "SG2" | "" | Tense.INFINITIVE      | "johwelohdi"
        "SG3" | "" | Tense.PRESENT         | "degohwelia"
        "SG3" | "" | Tense.HABITUAL        | "degohwelisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwowelanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gohwelvga"
        "SG3" | "" | Tense.INFINITIVE      | "uwohwelohdi"
        "PL3" | "" | Tense.PRESENT         | "danohwelia"
        "PL3" | "" | Tense.HABITUAL        | "danohwelisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunohwelanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinohwelvga"
        "PL3" | "" | Tense.INFINITIVE      | "junohwelohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedohwelia"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedohwelisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degohwelanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didohwelvga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digohwelohdi"
    }
}
