// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73074 (entrya galonasdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'jilonasdiha'],
            [subject: 'SG1', object: '', present: 'jilonasdiha', habitual: 'jilonasdisgoi', remote_past: 'jilonastanvi', imperative: 'jilonasda', infinitive: 'jilonasdohdi'],
            [subject: 'SG2', object: '', present: 'hilonasdiha', habitual: 'hilonasdisgoi', remote_past: 'hilonastanvi', imperative: 'hilonasda', infinitive: 'hilonasdohdi'],
            [subject: 'SG3', object: '', habitual: 'galonasdisgoi', imperative: 'hilonasda', infinitive: 'ulonasdohdi', present: 'galonasdiha', remote_past: 'ulonastanvi'],
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
        "SG1" | "" | Tense.PRESENT         | "tsilonasdiha"
        "SG1" | "" | Tense.HABITUAL        | "tsilonasdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agilonastanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsilonastanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agilonasdodi"
        "SG2" | "" | Tense.PRESENT         | "hilonasdiha"
        "SG2" | "" | Tense.HABITUAL        | "hilonasdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalonastanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hilonastanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsalonasdodi"
        "SG3" | "" | Tense.PRESENT         | "galonasdiha"
        "SG3" | "" | Tense.HABITUAL        | "galonasdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulonastanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "galonastanvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulonasdodi"
        "PL3" | "" | Tense.PRESENT         | "anilonasdiha"
        "PL3" | "" | Tense.HABITUAL        | "anilonasdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unilonastanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anilonastanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unilonasdodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idilonasdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idilonasdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igilonastanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idilonastanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igilonasdodi"
    }
}
