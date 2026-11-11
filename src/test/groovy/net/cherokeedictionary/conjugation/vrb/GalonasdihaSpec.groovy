package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GalonasdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Bluffing, Deceiving, Tricking (Him/Her)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jilonasdiha', habitual: 'jilonasdisgoi', remote_past: 'jilonastanvi', imperative: 'jilonasda', infinitive: 'jilonasdohdi'],
            [subject: 'SG2', object: '', present: 'hilonasdiha', habitual: 'hilonasdisgoi', remote_past: 'hilonastanvi', imperative: 'hilonasda', infinitive: 'hilonasdohdi'],
            [subject: 'SG3', object: '', present: 'galonasdiha', habitual: 'galonasdisgoi', remote_past: 'ulonastanvi', imperative: 'galonasda', infinitive: 'ulonasdohdi'],
            [subject: 'PL3', object: '', present: 'anilonasdiha', habitual: 'anilonasdisgoi', remote_past: 'unilonastanvi', imperative: 'anilonasda', infinitive: 'unilonasdohdi'],
            [subject: 'PL1INCL', object: '', present: 'edilonasdiha', habitual: 'edilonasdisgoi', remote_past: 'edilonastanvi', imperative: 'edilonasda', infinitive: 'edilonasdohdi']
        ]
    ]

    @Unroll
    def "conjugating Galonasdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Galonasdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jilonasdiha"
        "SG1" | "" | Tense.HABITUAL        | "jilonasdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jilonastanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jilonasda"
        "SG1" | "" | Tense.INFINITIVE      | "jilonasdohdi"
        "SG2" | "" | Tense.PRESENT         | "hilonasdiha"
        "SG2" | "" | Tense.HABITUAL        | "hilonasdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hilonastanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hilonasda"
        "SG2" | "" | Tense.INFINITIVE      | "hilonasdohdi"
        "SG3" | "" | Tense.PRESENT         | "galonasdiha"
        "SG3" | "" | Tense.HABITUAL        | "galonasdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulonastanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "galonasda"
        "SG3" | "" | Tense.INFINITIVE      | "ulonasdohdi"
        "PL3" | "" | Tense.PRESENT         | "anilonasdiha"
        "PL3" | "" | Tense.HABITUAL        | "anilonasdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unilonastanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anilonasda"
        "PL3" | "" | Tense.INFINITIVE      | "unilonasdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "edilonasdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "edilonasdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "edilonastanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "edilonasda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "edilonasdohdi"
    }
}
