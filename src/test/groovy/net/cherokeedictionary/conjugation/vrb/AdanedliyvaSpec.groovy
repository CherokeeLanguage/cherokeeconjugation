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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadanedliyva"
        "SG1" | "" | Tense.HABITUAL        | "gadanedliyvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadanedliyvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadanetliyvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwadanedliyvsdi"
        "SG2" | "" | Tense.PRESENT         | "hadanedliyva"
        "SG2" | "" | Tense.HABITUAL        | "hadanedliyvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadanedliyvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadanetliyvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "jadanedliyvsdi"
        "SG3" | "" | Tense.PRESENT         | "adanedliyva"
        "SG3" | "" | Tense.HABITUAL        | "adanedliyvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udanedliyvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adanetliyvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "udanedliyvsdi"
        "PL3" | "" | Tense.PRESENT         | "anadanedliyva"
        "PL3" | "" | Tense.HABITUAL        | "anadanedliyvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadanedliyvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadanetliyvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadanedliyvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadanedliyva"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadanedliyvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadanedliyvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadanetliyvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadanedliyvsdi"
    }
}
