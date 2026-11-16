// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72535 (entrya alsosdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlsosdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Aiming (43)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'galisosdiha'],
            [subject: 'SG1', object: '', present: 'galisosdiha', habitual: 'galisosdisgoi', remote_past: 'agwalsostanvi', imperative: 'galisosda', infinitive: 'agwalsosdohdi'],
            [subject: 'SG2', object: '', present: 'halsosdiha', habitual: 'halsosdisgoi', remote_past: 'jalsostanvi', imperative: 'halsosda', infinitive: 'jalsosdohdi'],
            [subject: 'SG3', object: '', habitual: 'alsosdisgoi', imperative: 'halsosda', infinitive: 'ulsosdohdi', present: 'alsosdiha', remote_past: 'ulsostanvi'],
            [subject: 'PL3', object: '', present: 'analsosdiha', habitual: 'analsosdisgoi', remote_past: 'unalsostanvi', imperative: 'analsosda', infinitive: 'unalsosdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idalsosdiha', habitual: 'idalsosdisgoi', remote_past: 'igalsostanvi', imperative: 'idalsosda', infinitive: 'igalsosdohdi']
        ]
    ]

    @Unroll
    def "conjugating Alsosdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alsosdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galisosdiha"
        "SG1" | "" | Tense.HABITUAL        | "galisosdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aqualisostanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galisostanvi"
        "SG1" | "" | Tense.INFINITIVE      | "aqualisosdodi"
        "SG2" | "" | Tense.PRESENT         | "halisosdiha"
        "SG2" | "" | Tense.HABITUAL        | "halisosdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalisostanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halisostanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsalisosdodi"
        "SG3" | "" | Tense.PRESENT         | "alisosdiha"
        "SG3" | "" | Tense.HABITUAL        | "alisosdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulisostanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alisostanvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulisosdodi"
        "PL3" | "" | Tense.PRESENT         | "analisosdiha"
        "PL3" | "" | Tense.HABITUAL        | "analisosdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalisostanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analisostanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unalisosdodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idalisosdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalisosdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalisostanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalisostanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalisosdodi"
    }
}
