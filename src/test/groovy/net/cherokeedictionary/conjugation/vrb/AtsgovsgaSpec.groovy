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
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gatsisgovsga"
        "SG1" | "" | Tense.HABITUAL        | "gajisgovsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwatsgonvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatsigonvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwatsgodi"
        "SG2" | "" | Tense.PRESENT         | "hatsgovsga"
        "SG2" | "" | Tense.HABITUAL        | "hatsgovsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jatsgonvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatsigonvi"
        "SG2" | "" | Tense.INFINITIVE      | "jatsgodi"
        "SG3" | "" | Tense.PRESENT         | "atsigovsga"
        "SG3" | "" | Tense.HABITUAL        | "atsigovsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utsigonvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atsigonvi"
        "SG3" | "" | Tense.INFINITIVE      | "utsigodi"
        "PL3" | "" | Tense.PRESENT         | "anatsgovsga"
        "PL3" | "" | Tense.HABITUAL        | "anatsgovsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatsgonvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatsigonvi"
        "PL3" | "" | Tense.INFINITIVE      | "unatsgodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idatsgovsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idatsgovsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatsgonvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatsigonvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igatsgodi"
    }
}
