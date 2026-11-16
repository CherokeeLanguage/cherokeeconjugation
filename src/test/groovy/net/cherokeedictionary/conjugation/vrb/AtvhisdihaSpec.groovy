// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72692 (entrya atvhisdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtvhisdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Raising/Growing Him/It",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyadvhisdiha, gadvhisdiha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyadvhisdiha', habitual: 'jiyadvhisdisgoi', remote_past: 'jiyatvhistanvi', imperative: 'jiyadvhisda', infinitive: 'jiyatvhisdohdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gadvhisdiha', habitual: 'gadvhisdisgoi', remote_past: 'aktvhistanvi', imperative: 'gadvhisda', infinitive: 'aktvhisdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyadvhisdiha', habitual: 'hiyadvhisdisgoi', remote_past: 'hiyatvhistanvi', imperative: 'hiyadvhisda', infinitive: 'hiyatvhisdohdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hatvhisdiha', habitual: 'hatvhisdisgoi', remote_past: 'tstvhistanvi', imperative: 'hatvhisda', infinitive: 'tstvhisdohdi'],
            [subject: 'SG3', object: '', habitual: 'atvhisdisgoi', imperative: 'hiyadvhisda, hatvhisda', infinitive: 'utvhisdohdi', present: 'atvhisdiha', remote_past: 'utvhistanvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anatvhisdiha', habitual: 'anatvhisdisgoi', remote_past: 'unatvhistanvi', imperative: 'anatvhisda', infinitive: 'unatvhisdohdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'edatvhisdiha', habitual: 'edatvhisdisgoi', remote_past: 'edatvhistanvi', imperative: 'edatvhisda', infinitive: '/']
        ]
    ]

    @Unroll
    def "conjugating Atvhisdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atvhisdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyadvhisdiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyadvhisdisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyadvhistanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyadvhistanvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyadvhisdodi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gadvhisdiha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gadvhisdisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aquadvhistanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gadvhistanvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "aquadvhisdodi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyadvhisdiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyadvhisdisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "advhistanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyadvhistanvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "advhisdodi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hadvhisdiha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hadvhisdisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tsadvhistanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hadvhistanvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsadvhisdodi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "advhisdiha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "advhisdisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "udvhistanvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "advhistanvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "udvhisdodi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anadvhisdiha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anadvhisdisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unadvhistanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anadvhistanvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unadvhisdodi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idadvhisdiha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idadvhisdisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igadvhistanvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idadvhistanvi"
        // "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "/"
    }
}
