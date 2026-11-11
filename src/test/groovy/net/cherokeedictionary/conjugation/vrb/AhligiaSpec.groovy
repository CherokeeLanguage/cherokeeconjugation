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
            [subject: 'SG1', object: '', present: 'gadligia', habitual: 'gadligisgoi', remote_past: 'agwahligisvi', imperative: 'gadligi', infinitive: 'agwahligisdi'],
            [subject: 'SG2', object: '', present: 'hahligia', habitual: 'hahligisgoi', remote_past: 'jahligisvi', imperative: 'hahligi', infinitive: 'jahligisdi'],
            [subject: 'SG3', object: '', present: 'ahligia', habitual: 'ahligisgoi', remote_past: 'uhligisvi', imperative: 'ahligi', infinitive: 'uhligisdi'],
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
        "SG1" | "" | Tense.PRESENT         | "gadligia"
        "SG1" | "" | Tense.HABITUAL        | "gadligisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwahligisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadligi"
        "SG1" | "" | Tense.INFINITIVE      | "agwahligisdi"
        "SG2" | "" | Tense.PRESENT         | "hahligia"
        "SG2" | "" | Tense.HABITUAL        | "hahligisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahligisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hahligi"
        "SG2" | "" | Tense.INFINITIVE      | "jahligisdi"
        "SG3" | "" | Tense.PRESENT         | "ahligia"
        "SG3" | "" | Tense.HABITUAL        | "ahligisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhligisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahligi"
        "SG3" | "" | Tense.INFINITIVE      | "uhligisdi"
        "PL3" | "" | Tense.PRESENT         | "anahligia"
        "PL3" | "" | Tense.HABITUAL        | "anahligisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unahligisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anahligi"
        "PL3" | "" | Tense.INFINITIVE      | "unahligisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idahligia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idahligi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "sgoi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igahligisvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "idahligi"
    }
}
