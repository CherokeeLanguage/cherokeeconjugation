// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72217 (entrya adanedliyva) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdanedliyvaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Changing",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadanedliyva'],
            [subject: 'SG1', object: '', present: 'gadanedliyva', habitual: 'gadanedliyvsgoi', remote_past: 'agwadanedliyvsvi', imperative: 'gadanedliyvna', infinitive: 'agwadanedliyvsdi'],
            [subject: 'SG2', object: '', present: 'hadanedliyva', habitual: 'hadanedliyvsgoi', remote_past: 'jadanedliyvsvi', imperative: 'hadanedliyvna', infinitive: 'jadanedliyvsdi'],
            [subject: 'SG3', object: '', habitual: 'adanedliyvsgoi', imperative: 'hadanedliyvna', infinitive: 'udanedliyvsdi', present: 'adanedliyva', remote_past: 'udanedliyvsvi'],
            [subject: 'PL3', object: '', present: 'anadanedliyva', habitual: 'anadanedliyvsgoi', remote_past: 'unadanedliyvsvi', imperative: 'anadanedliyvna', infinitive: 'unadanedliyvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idadanedliyva', habitual: 'idadanedliyvsgoi', remote_past: 'igadanedliyvsvi', imperative: 'idadanedliyvna', infinitive: 'igadanedliyvsdi']
        ]
    ]

    @Unroll
    def "conjugating Adanedliyva (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adanedliyva", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadanetliyva"
        "SG1" | "" | Tense.HABITUAL        | "gadanetliyvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadanetliyvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadanetliyvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadanetliyvsdi"
        "SG2" | "" | Tense.PRESENT         | "hadanetliyva"
        "SG2" | "" | Tense.HABITUAL        | "hadanetliyvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadanetliyvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadanetliyvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadanetliyvsdi"
        "SG3" | "" | Tense.PRESENT         | "adanetliyva"
        "SG3" | "" | Tense.HABITUAL        | "adanetliyvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanetliyvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adanetliyvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "udanetliyvsdi"
        "PL3" | "" | Tense.PRESENT         | "anadanetliyva"
        "PL3" | "" | Tense.HABITUAL        | "anadanetliyvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanetliyvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadanetliyvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadanetliyvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadanetliyva"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadanetliyvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanetliyvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadanetliyvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadanetliyvsdi"
    }
}
