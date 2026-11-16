// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72433 (entrya ajewia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AjewiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he is Spilling It/Pouring It/Being Wasteful",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gajewia'],
            [subject: 'SG1', object: '', present: 'gajewia', habitual: 'gajewisgoi', remote_past: 'agwajewvi', imperative: 'gajewa', infinitive: 'agwajewasdi'],
            [subject: 'SG2', object: '', present: 'hajewia', habitual: 'hajewisgoi', remote_past: 'jajewvi', imperative: 'hajewa', infinitive: 'jajewasdi'],
            [subject: 'SG3', object: '', habitual: 'ajewisgoi', imperative: 'hajewa', infinitive: 'ujewasdi', present: 'ajewia', remote_past: 'ujewvi'],
            [subject: 'PL3', object: '', present: 'anajewia', habitual: 'anajewisgoi', remote_past: 'unajewvi', imperative: 'anajewa', infinitive: 'unajewasdi'],
            [subject: 'PL1INCL', object: '', present: 'idajewia', habitual: 'idajewisgoi', remote_past: 'igajewvi', imperative: 'idajewa', infinitive: 'igajewasdi']
        ]
    ]

    @Unroll
    def "conjugating Ajewia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ajewia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gatsewia"
        "SG1" | "" | Tense.HABITUAL        | "gatsewisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquatsewvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatsewvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquatsewasdi"
        "SG2" | "" | Tense.PRESENT         | "hatsewia"
        "SG2" | "" | Tense.HABITUAL        | "hatsewisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatsewvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatsewvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatsewasdi"
        "SG3" | "" | Tense.PRESENT         | "atsewia"
        "SG3" | "" | Tense.HABITUAL        | "atsewisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utsewvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atsewvi"
        "SG3" | "" | Tense.INFINITIVE      | "utsewasdi"
        "PL3" | "" | Tense.PRESENT         | "anatsewia"
        "PL3" | "" | Tense.HABITUAL        | "anatsewisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatsewvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatsewvi"
        "PL3" | "" | Tense.INFINITIVE      | "unatsewasdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idatsewia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idatsewisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatsewvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatsewvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igatsewasdi"
    }
}
