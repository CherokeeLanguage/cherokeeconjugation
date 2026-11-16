// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73251 (entrya gohwelia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'gowelia'],
            [subject: 'SG1', object: '', present: 'degowelia', habitual: 'degowelisgoi', remote_past: 'agwohwelanvi', imperative: 'gowelvga', infinitive: 'agwohwelohdi'],
            [subject: 'SG2', object: '', present: 'dehowelia', habitual: 'dehohwelisgoi', remote_past: 'johwelanvi', imperative: 'hohwelvga', infinitive: 'johwelohdi'],
            [subject: 'SG3', object: '', habitual: 'gohwelisgoi', imperative: 'hohwelvga', infinitive: 'uwohwelodi', present: 'gohwelia', remote_past: 'uwohwelanvi'],
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
        "SG1" | "" | Tense.PRESENT         | "gowelia"
        "SG1" | "" | Tense.HABITUAL        | "gowelisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquowelanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gowelanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwowelodi"
        "SG2" | "" | Tense.PRESENT         | "howelia"
        "SG2" | "" | Tense.HABITUAL        | "howelisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsowelanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "howelanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawowelodi"
        "SG3" | "" | Tense.PRESENT         | "gowelia"
        "SG3" | "" | Tense.HABITUAL        | "gowelisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwowelanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "owelanvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwowelodi"
        "PL3" | "" | Tense.PRESENT         | "anowelia"
        "PL3" | "" | Tense.HABITUAL        | "anowelisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unowelanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anowelanvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwowelodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idowelia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idowelisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igowelanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idowelanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwowelodi"
    }
}
