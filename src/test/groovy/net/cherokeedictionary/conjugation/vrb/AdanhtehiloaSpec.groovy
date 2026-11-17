// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72225 (entrya adanhtehiloa) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdanhtehiloaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Pondering, Considering",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadanvtehiloa'],
            [subject: 'SG1', object: '', present: 'gadanvtehiloa', habitual: 'gadanhtehilosgoi', remote_past: 'agwadanhtehilovi', imperative: 'gadanhtehiloja', infinitive: 'agwadanhtehilosdi'],
            [subject: 'SG2', object: '', present: 'hadanvtehiloa', habitual: 'hadanhtehilosgoi', remote_past: 'jadanhtehilovi', imperative: 'hadanhtehiloja', infinitive: 'jadanhtehilosdi'],
            [subject: 'SG3', object: '', habitual: 'adanhtehilosgoi', imperative: 'hadanhtehiloja', infinitive: 'udanhtehilosdi', present: 'adanhtehiloa', remote_past: 'udanhtehilovi'],
            [subject: 'PL3', object: '', present: 'anadanvtehiloa', habitual: 'anadanhtehilosgoi', remote_past: 'unadanhtehilovi', imperative: 'anadanhtehiloja', infinitive: 'unadanhtehilosdi'],
            [subject: 'PL1INCL', object: '', present: 'idadanvtehiloa', habitual: 'idadanhtehilosgoi', remote_past: 'igadanhtehilovi', imperative: 'idadanhtehiloja', infinitive: 'igadanhtehilosdi']
        ]
    ]

    @Unroll
    def "conjugating Adanhtehiloa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adanhtehiloa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadanatehiloa"
        "SG1" | "" | Tense.HABITUAL        | "gadanatehilosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadanatehilovi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadanatehilovi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadanatehilosdi"
        "SG2" | "" | Tense.PRESENT         | "hadanatehiloa"
        "SG2" | "" | Tense.HABITUAL        | "hadanatehilosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadanatehilovi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadanatehilovi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadanatehilosdi"
        "SG3" | "" | Tense.PRESENT         | "adanatehiloa"
        "SG3" | "" | Tense.HABITUAL        | "adanatehilosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanatehilovi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adanatehilovi"
        "SG3" | "" | Tense.INFINITIVE      | "udanatehilosdi"
        "PL3" | "" | Tense.PRESENT         | "anadanatehiloa"
        "PL3" | "" | Tense.HABITUAL        | "anadanatehilosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanatehilovi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadanatehilovi"
        "PL3" | "" | Tense.INFINITIVE      | "unadanatehilosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadanatehiloa"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadanatehilosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanatehilovi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadanatehilovi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadanatehilosdi"
    }
}
