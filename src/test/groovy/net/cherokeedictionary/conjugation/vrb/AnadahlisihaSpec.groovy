package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AnadahlisihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "They are Gathering (in a group)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'anadahlisiha', habitual: 'anadahlisisgoi', remote_past: 'unadahlisahnvi', imperative: 'anadahlisa', infinitive: 'unadahlisohdi'],
            [subject: 'SG2', object: '', present: 'ijadahlisiha', habitual: 'ijadahlisisgoi', remote_past: 'ijadahlisahnvi', imperative: 'ijadahlisa', infinitive: 'ijadahlisohdi'],
            [subject: 'SG3', object: '', present: 'sdadahlisiha', habitual: 'sdadahlisisgoi', remote_past: 'sdadahlisahnvi', imperative: 'sdadahlisa', infinitive: 'sdadahlisohdi'],
            [subject: 'PL3', object: '', present: 'ojadahlisiha', habitual: 'ojadahlisisgoi', remote_past: 'ogadahlisahnvi', imperative: 'ojadahlisa', infinitive: 'ogadahlisohdi'],
            [subject: 'PL1INCL', object: '', present: 'idadahlisiha', habitual: 'idadahlisisgoi', remote_past: 'igadahlisahnvi', imperative: 'idadahlisa', infinitive: 'igadahlisohdi']
        ]
    ]

    @Unroll
    def "conjugating Anadahlisiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Anadahlisiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "anadahlisiha"
        "SG1" | "" | Tense.HABITUAL        | "anadahlisisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "unadahlisahnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "anadahlisa"
        "SG1" | "" | Tense.INFINITIVE      | "unadahlisohdi"
        "SG2" | "" | Tense.PRESENT         | "ijadahlisiha"
        "SG2" | "" | Tense.HABITUAL        | "ijadahlisisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "ijadahlisahnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "ijadahlisa"
        "SG2" | "" | Tense.INFINITIVE      | "ijadahlisohdi"
        "SG3" | "" | Tense.PRESENT         | "sdadahlisiha"
        "SG3" | "" | Tense.HABITUAL        | "sdadahlisisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "sdadahlisahnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "sdadahlisa"
        "SG3" | "" | Tense.INFINITIVE      | "sdadahlisohdi"
        "PL3" | "" | Tense.PRESENT         | "ojadahlisiha"
        "PL3" | "" | Tense.HABITUAL        | "ojadahlisisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "ogadahlisahnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "ojadahlisa"
        "PL3" | "" | Tense.INFINITIVE      | "ogadahlisohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadahlisiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadahlisisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadahlisahnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadahlisa"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadahlisohdi"
    }
}
