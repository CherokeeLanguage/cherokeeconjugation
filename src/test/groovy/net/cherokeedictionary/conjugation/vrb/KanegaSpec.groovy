// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73476 (entrya kanega) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KanegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Answering / Speaking",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinega'],
            [subject: 'SG1', object: '', present: 'jinega', habitual: 'jinegoi', remote_past: 'akinejvi', imperative: 'jinegi', infinitive: 'akihnesdi'],
            [subject: 'SG2', object: '', present: 'hinega', habitual: 'hinegoi', remote_past: 'jahnejvi', imperative: 'hihnegi', infinitive: 'jahnesdi'],
            [subject: 'SG3', object: '', habitual: 'kanegoi', imperative: 'hihnegi', infinitive: 'uhnesdi', present: 'kanega', remote_past: 'uhnejvi'],
            [subject: 'PL3', object: '', present: 'aninega', habitual: 'aninegoi', remote_past: 'unihnejvi', imperative: 'aninegi', infinitive: 'unihnesdi'],
            [subject: 'PL1INCL', object: '', present: 'idinega', habitual: 'idinegoi', remote_past: 'igihnejvi', imperative: 'idinegi', infinitive: 'igihnesdi']
        ]
    ]

    @Unroll
    def "conjugating Kanega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kanega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinega"
        "SG1" | "" | Tense.HABITUAL        | "tsinegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginetsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinetsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginesdi"
        "SG2" | "" | Tense.PRESENT         | "hinega"
        "SG2" | "" | Tense.HABITUAL        | "hinegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanetsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinetsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanesdi"
        "SG3" | "" | Tense.PRESENT         | "kanega"
        "SG3" | "" | Tense.HABITUAL        | "kanegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unetsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganetsvi"
        "SG3" | "" | Tense.INFINITIVE      | "unesdi"
        "PL3" | "" | Tense.PRESENT         | "aninega"
        "PL3" | "" | Tense.HABITUAL        | "aninegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninetsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninetsvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinega"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginetsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinetsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginesdi"
    }
}
