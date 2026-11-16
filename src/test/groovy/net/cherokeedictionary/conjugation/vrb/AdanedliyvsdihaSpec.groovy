// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72218 (entrya adanedliyvsdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdanedliyvsdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Taking Turns, Change",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadanedliyvsdiha'],
            [subject: 'SG1', object: '', present: 'gadanedliyvsdiha', habitual: 'gadanedliyvsdisgoi', remote_past: 'agwadanedliyvstanvi', imperative: 'gadanedliyvsda', infinitive: 'agwadanedliyvsdohdi'],
            [subject: 'SG2', object: '', present: 'hadanedliyvsdiha', habitual: 'hadanedliyvsdisgoi', remote_past: 'jadanedliyvstanvi', imperative: 'hadanedliyvsda', infinitive: 'jadanedliyvsdohdi'],
            [subject: 'SG3', object: '', habitual: 'adanedliyvsdisgoi', imperative: 'hadanedliyvsda', infinitive: 'udanedliyvsdohdi', present: 'adanedliyvsdiha', remote_past: 'udanedliyvstanvi'],
            [subject: 'PL3', object: '', present: 'anadanedliyvsdiha', habitual: 'anadanedliyvsdisgoi', remote_past: 'unadanedliyvstanvi', imperative: 'anadanedliyvsda', infinitive: 'unadanedliyvsdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idadanedliyvsdiha', habitual: 'idadanedliyvsdisgoi', remote_past: 'igadanedliyvstanvi', imperative: 'idadanedliyvsda', infinitive: 'igadanedliyvsdohdi']
        ]
    ]

    @Unroll
    def "conjugating Adanedliyvsdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adanedliyvsdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadanetliyvsdiha"
        "SG1" | "" | Tense.HABITUAL        | "gadanetliyvsdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadanetliyvstanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadanetliyvstanvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadanetliyvsdodi"
        "SG2" | "" | Tense.PRESENT         | "hadanetliyvsdiha"
        "SG2" | "" | Tense.HABITUAL        | "hadanetliyvsdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadanetliyvstanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadanetliyvstanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadanetliyvsdodi"
        "SG3" | "" | Tense.PRESENT         | "adanetliyvsdiha"
        "SG3" | "" | Tense.HABITUAL        | "adanetliyvsdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanetliyvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adanetliyvstanvi"
        "SG3" | "" | Tense.INFINITIVE      | "udanetliyvsdodi"
        "PL3" | "" | Tense.PRESENT         | "anadanetliyvsdiha"
        "PL3" | "" | Tense.HABITUAL        | "anadanetliyvsdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanetliyvstanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadanetliyvstanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadanetliyvsdodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadanetliyvsdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadanetliyvsdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanetliyvstanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadanetliyvstanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadanetliyvsdodi"
    }
}
