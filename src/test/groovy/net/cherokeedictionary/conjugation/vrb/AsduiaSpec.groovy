// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72581 (entrya asduia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsduiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Opening",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jisduia'],
            [subject: 'SG1', object: '', present: 'jisduia', habitual: 'jisduisgoi', remote_past: 'aksduisvi', imperative: 'jisdui', infinitive: 'aksduisdi'],
            [subject: 'SG2', object: '', present: 'hisduia', habitual: 'hisduisgoi', remote_past: 'tsduisvi', imperative: 'hisdui', infinitive: 'tsduisdi'],
            [subject: 'SG3', object: '', habitual: 'asduisgoi', imperative: 'hisdui', infinitive: 'usduisdi', present: 'asduia', remote_past: 'usduisvi'],
            [subject: 'PL3', object: '', present: 'anisduia', habitual: 'anisduisgoi', remote_past: 'unsduisvi', imperative: 'anisdui', infinitive: 'unsduisdi'],
            [subject: 'PL1INCL', object: '', present: 'idisduia', habitual: 'idisduisgoi', remote_past: 'iksduisvi', imperative: 'idisdui', infinitive: 'iksduisdi']
        ]
    ]

    @Unroll
    def "conjugating Asduia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asduia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsisduia"
        "SG1" | "" | Tense.HABITUAL        | "tsisduisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agisduisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisduisvi"
        "SG1" | "" | Tense.INFINITIVE      | "agisduisdi"
        "SG2" | "" | Tense.PRESENT         | "hisduia"
        "SG2" | "" | Tense.HABITUAL        | "hisduisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasduisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisduisvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsasduisdi"
        "SG3" | "" | Tense.PRESENT         | "asduia"
        "SG3" | "" | Tense.HABITUAL        | "asduisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usduisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asduisvi"
        "SG3" | "" | Tense.INFINITIVE      | "usduisdi"
        "PL3" | "" | Tense.PRESENT         | "anisduia"
        "PL3" | "" | Tense.HABITUAL        | "anisduisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisduisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisduisvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisduisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisduia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisduisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisduisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisduisvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisduisdi"
    }
}
