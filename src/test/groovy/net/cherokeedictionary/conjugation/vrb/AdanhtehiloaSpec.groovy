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
        "SG1" | "" | Tense.PRESENT         | "gadanitehiloa"
        "SG1" | "" | Tense.HABITUAL        | "gadanitehilosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadanitehilovi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadanitehilovi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadanitehilosdi"
        "SG2" | "" | Tense.PRESENT         | "hadanitehiloa"
        "SG2" | "" | Tense.HABITUAL        | "hadanitehilosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadanitehilovi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadanitehilovi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadanitehilosdi"
        "SG3" | "" | Tense.PRESENT         | "adanitehiloa"
        "SG3" | "" | Tense.HABITUAL        | "adanitehilosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanitehilovi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adanitehilovi"
        "SG3" | "" | Tense.INFINITIVE      | "udanitehilosdi"
        "PL3" | "" | Tense.PRESENT         | "anadanitehiloa"
        "PL3" | "" | Tense.HABITUAL        | "anadanitehilosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanitehilovi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadanitehilovi"
        "PL3" | "" | Tense.INFINITIVE      | "unadanitehilosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadanitehiloa"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadanitehilosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanitehilovi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadanitehilovi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadanitehilosdi"
    }
}
