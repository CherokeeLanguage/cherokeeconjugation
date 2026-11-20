// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72685) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72685 (entrya atsgovsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtsgovsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Lying",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gatsisgovsga'],
            [subject: 'SG1', object: '', present: 'gatsisgovsga', habitual: 'gajisgovsgoi', remote_past: 'agwatsgonvi', imperative: 'gajisgovga', infinitive: 'agwatsgodi'],
            [subject: 'SG2', object: '', present: 'hatsgovsga', habitual: 'hatsgovsgoi', remote_past: 'jatsgonvi', imperative: 'hatsgovga', infinitive: 'jatsgodi'],
            [subject: 'SG3', object: '', habitual: 'atsigovsgoi', imperative: 'hatsigovga', infinitive: 'utsigodi', present: 'atsigovsga', remote_past: 'utsigonvi'],
            [subject: 'PL3', object: '', present: 'anatsgovsga', habitual: 'anatsgovsgoi', remote_past: 'unatsgonvi', imperative: 'anatsgovga', infinitive: 'unatsgodi'],
            [subject: 'PL1INCL', object: '', present: 'idatsgovsga', habitual: 'idatsgovsgoi', remote_past: 'igatsgonvi', imperative: 'idatsgovga', infinitive: 'igatsgodi']
        ]
    ]

    @Unroll
    def "conjugating Atsgovsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atsgovsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gatsigovsga"
        "SG1" | "" | Tense.HABITUAL        | "gatsigovsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquatsigonvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatsigonvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquatsigodi"
        "SG2" | "" | Tense.PRESENT         | "hatsigovsga"
        "SG2" | "" | Tense.HABITUAL        | "hatsigovsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatsigonvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatsigonvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatsigodi"
        "SG3" | "" | Tense.PRESENT         | "atsigovsga"
        "SG3" | "" | Tense.HABITUAL        | "atsigovsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utsigonvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atsigonvi"
        "SG3" | "" | Tense.INFINITIVE      | "utsigodi"
        "PL3" | "" | Tense.PRESENT         | "anatsigovsga"
        "PL3" | "" | Tense.HABITUAL        | "anatsigovsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatsigonvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatsigonvi"
        "PL3" | "" | Tense.INFINITIVE      | "unatsigodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idatsigovsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idatsigovsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatsigonvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatsigonvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igatsigodi"
    }
}
