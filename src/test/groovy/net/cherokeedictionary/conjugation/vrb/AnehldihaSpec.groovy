// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72552 (entrya anehldiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AnehldihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Trying",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'ganehldiha'],
            [subject: 'SG1', object: '', present: 'ganehldia', habitual: 'ganehldisgoi', remote_past: 'agwanehltanvi', imperative: 'ganehlda', infinitive: 'agwanehldohdi'],
            [subject: 'SG2', object: '', present: 'hanehldiha', habitual: 'hanehldisgoi', remote_past: 'janehltanvi', imperative: 'hanehlda', infinitive: 'janehldohdi'],
            [subject: 'SG3', object: '', habitual: 'anehldisgoi', imperative: 'hanehlda', infinitive: 'unehldohdi', present: 'anehldiha', remote_past: 'unehltanvi'],
            [subject: 'PL3', object: '', present: 'ananehldiha', habitual: 'ananehldisgoi', remote_past: 'unanehltanvi', imperative: 'ananehlda', infinitive: 'unanehldohdi'],
            [subject: 'PL1INCL', object: '', present: 'idanehldiha', habitual: 'idanehldisgoi', remote_past: 'iganehltanvi', imperative: 'idanehlda', infinitive: 'iganehldohdi']
        ]
    ]

    @Unroll
    def "conjugating Anehldiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Anehldiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "ganelodiha"
        "SG1" | "" | Tense.HABITUAL        | "ganelodisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquanelotanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganelotanvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquanelododi"
        "SG2" | "" | Tense.PRESENT         | "hanelodiha"
        "SG2" | "" | Tense.HABITUAL        | "hanelodisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanelotanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hanelotanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanelododi"
        "SG3" | "" | Tense.PRESENT         | "anelodiha"
        "SG3" | "" | Tense.HABITUAL        | "anelodisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unelotanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anelotanvi"
        "SG3" | "" | Tense.INFINITIVE      | "unelododi"
        "PL3" | "" | Tense.PRESENT         | "ananelodiha"
        "PL3" | "" | Tense.HABITUAL        | "ananelodisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unanelotanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "ananelotanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unanelododi"
        "PL1INCL" | "" | Tense.PRESENT         | "idanelodiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idanelodisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iganelotanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idanelotanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iganelododi"
    }
}
