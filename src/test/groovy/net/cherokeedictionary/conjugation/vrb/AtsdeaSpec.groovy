// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72681 (entrya atsdea) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtsdeaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Biting",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gajisdea'],
            [subject: 'SG1', object: '', present: 'gajisdea', habitual: 'gajisdesgoi', remote_past: 'agwatsdesvi', imperative: 'gajisdagi', infinitive: 'agwatsdesdi'],
            [subject: 'SG2', object: '', present: 'hatsdea', habitual: 'hatsdesgoi', remote_past: 'jatsdesvi', imperative: 'hatsdagi', infinitive: 'jatsdesdi'],
            [subject: 'SG3', object: '', habitual: 'atsdesgoi', imperative: 'hatsdagi', infinitive: 'utsdesdi', present: 'atsdea', remote_past: 'utsdesvi'],
            [subject: 'PL3', object: '', present: 'anatsdea', habitual: 'anatsdesgoi', remote_past: 'unatsdesvi', imperative: 'anatsdagi', infinitive: 'unatsdesdi'],
            [subject: 'PL1INCL', object: '', present: 'idatsdea', habitual: 'idatsdesgoi', remote_past: 'igatsdesvi', imperative: 'idatsdagi', infinitive: 'igatsdesdi']
        ]
    ]

    @Unroll
    def "conjugating Atsdea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atsdea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gatsidea"
        "SG1" | "" | Tense.HABITUAL        | "gatsidesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquatsidesvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatsidesvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquatsidesdi"
        "SG2" | "" | Tense.PRESENT         | "hatsidea"
        "SG2" | "" | Tense.HABITUAL        | "hatsidesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatsidesvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatsidesvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatsidesdi"
        "SG3" | "" | Tense.PRESENT         | "atsidea"
        "SG3" | "" | Tense.HABITUAL        | "atsidesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utsidesvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atsidesvi"
        "SG3" | "" | Tense.INFINITIVE      | "utsidesdi"
        "PL3" | "" | Tense.PRESENT         | "anatsidea"
        "PL3" | "" | Tense.HABITUAL        | "anatsidesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatsidesvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatsidesvi"
        "PL3" | "" | Tense.INFINITIVE      | "unatsidesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idatsidea"
        "PL1INCL" | "" | Tense.HABITUAL        | "idatsidesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatsidesvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatsidesvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igatsidesdi"
    }
}
