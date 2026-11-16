// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72216 (entrya adanawsdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdanawsdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Running, Take Off",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadanawsdiha'],
            [subject: 'SG1', object: '', present: 'gadanawsdiha', habitual: 'gadanawsdisgoi', remote_past: 'agwadanawstanvi', imperative: 'gadanawsda', infinitive: 'agwadanawsdohdi'],
            [subject: 'SG2', object: '', present: 'hadanawsdiha', habitual: 'hadanawsdisgoi', remote_past: 'jadanawstanvi', imperative: 'hadanawsda', infinitive: 'jadanawsdohdi'],
            [subject: 'SG3', object: '', habitual: 'adanawsdisgoi', imperative: 'hadanawsda', infinitive: 'udanawsdohdi', present: 'adanawsdiha', remote_past: 'udanawstanvi'],
            [subject: 'PL3', object: '', present: 'danadanawsdiha', habitual: 'danadanawsdisgoi', remote_past: 'unadanawstanvi', imperative: 'anadanawsda', infinitive: 'unadanawsdohdi'],
            [subject: 'PL1INCL', object: '', present: 'dedadanawsdiha', habitual: 'dedadanawsdisgoi', remote_past: 'igadanawstanvi', imperative: 'idadanawsda', infinitive: 'igadanawsdohdi']
        ]
    ]

    @Unroll
    def "conjugating Adanawsdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adanawsdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadanawvsdiha"
        "SG1" | "" | Tense.HABITUAL        | "gadanawvsdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadanawvstanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadanawvstanvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadanawvsdodi"
        "SG2" | "" | Tense.PRESENT         | "hadanawvsdiha"
        "SG2" | "" | Tense.HABITUAL        | "hadanawvsdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadanawvstanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadanawvstanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadanawvsdodi"
        "SG3" | "" | Tense.PRESENT         | "adanawvsdiha"
        "SG3" | "" | Tense.HABITUAL        | "adanawvsdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanawvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adanawvstanvi"
        "SG3" | "" | Tense.INFINITIVE      | "udanawvsdodi"
        "PL3" | "" | Tense.PRESENT         | "anadanawvsdiha"
        "PL3" | "" | Tense.HABITUAL        | "anadanawvsdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanawvstanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadanawvstanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadanawvsdodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadanawvsdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadanawvsdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanawvstanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadanawvstanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadanawvsdodi"
    }
}
