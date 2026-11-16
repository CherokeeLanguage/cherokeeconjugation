// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72359 (entrya ahligia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhligiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Having a Nightmare",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadligia'],
            [subject: 'SG1', object: '', present: 'gadligia', habitual: 'gadligisgoi', remote_past: 'agwahligisvi', imperative: 'gadligi', infinitive: 'agwahligisdi'],
            [subject: 'SG2', object: '', present: 'hahligia', habitual: 'hahligisgoi', remote_past: 'jahligisvi', imperative: 'hahligi', infinitive: 'jahligisdi'],
            [subject: 'SG3', object: '', habitual: 'ahligisgoi', imperative: 'hahligi', infinitive: 'uhligisdi', present: 'ahligia', remote_past: 'uhligisvi'],
            [subject: 'PL3', object: '', present: 'anahligia', habitual: 'anahligisgoi', remote_past: 'unahligisvi', imperative: 'anahligi', infinitive: 'unahligisdi'],
            [subject: 'PL1INCL', object: '', present: 'idahligia', habitual: 'idahligi', remote_past: 'sgoi', imperative: 'igahligisvi', infinitive: 'idahligi']
        ]
    ]

    @Unroll
    def "conjugating Ahligia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahligia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gatligia"
        "SG1" | "" | Tense.HABITUAL        | "gatligisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquatligisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatligisvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquatligisdi"
        "SG2" | "" | Tense.PRESENT         | "hatligia"
        "SG2" | "" | Tense.HABITUAL        | "hatligisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatligisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatligisvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatligisdi"
        "SG3" | "" | Tense.PRESENT         | "atligia"
        "SG3" | "" | Tense.HABITUAL        | "atligisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utligisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atligisvi"
        "SG3" | "" | Tense.INFINITIVE      | "utligisdi"
        "PL3" | "" | Tense.PRESENT         | "anatligia"
        "PL3" | "" | Tense.HABITUAL        | "anatligisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatligisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatligisvi"
        "PL3" | "" | Tense.INFINITIVE      | "unatligisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idatligia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idatligisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatligisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatligisvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igatligisdi"
    }
}
