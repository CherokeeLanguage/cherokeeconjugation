// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72988) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72988 (entrya gadeysdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GadeysdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Turning It",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsideyasdiha'],
            [subject: 'SG1', object: '', present: 'tsideyasdiha', habitual: 'jideyasdisgoi', remote_past: 'akdeystanvi', imperative: 'jideyasda', infinitive: 'akdeysdohdi'],
            [subject: 'SG2', object: '', present: 'hideysdiha', habitual: 'hideysdisgoi', remote_past: 'tsdeystanvi', imperative: 'hideysda', infinitive: 'tsdeysdohdi'],
            [subject: 'SG3', object: '', habitual: 'gadeyasdisgoi', imperative: 'hideyasda', infinitive: 'uwadeyasdodi', present: 'gadeyasdiha', remote_past: 'uwadeyastanvi'],
            [subject: 'PL3', object: '', present: 'anideysdiha', habitual: 'anideysdisgoi', remote_past: 'unideystanvi', imperative: 'anideysda', infinitive: 'unideysdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idideysdiha', habitual: 'idideysdisgoi', remote_past: 'igadeystanvi', imperative: 'idideysda', infinitive: 'igideysdohdi']
        ]
    ]

    @Unroll
    def "conjugating Gadeysdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gadeysdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsideyasdiha"
        "SG1" | "" | Tense.HABITUAL        | "tsideyasdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwadeyastanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwadeyastanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwadeyasdodi"
        "SG2" | "" | Tense.PRESENT         | "hideyasdiha"
        "SG2" | "" | Tense.HABITUAL        | "hideyasdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawadeyastanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwadeyastanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawadeyasdodi"
        "SG3" | "" | Tense.PRESENT         | "gadeyasdiha"
        "SG3" | "" | Tense.HABITUAL        | "gadeyasdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwadeyastanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawadeyastanvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwadeyasdodi"
        "PL3" | "" | Tense.PRESENT         | "anideyasdiha"
        "PL3" | "" | Tense.HABITUAL        | "anideyasdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwadeyastanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwadeyastanvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwadeyasdodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idideyasdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idideyasdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiwadeyastanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiwadeyastanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwadeyasdodi"
    }
}
