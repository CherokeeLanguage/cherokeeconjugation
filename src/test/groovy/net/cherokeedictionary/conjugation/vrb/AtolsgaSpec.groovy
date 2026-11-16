// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72679 (entrya atolsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtolsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Borrowing",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyatolsga, gatolsga'],
            [subject: 'SG1', object: '', present: 'gatolsga', habitual: 'gatolsgoi', remote_past: 'agwatolsvi', imperative: 'gatola', infinitive: 'agwatohlisdi'],
            [subject: 'SG2', object: '', present: 'hatolsga', habitual: 'hatolsgoi', remote_past: 'jatolsvi', imperative: 'hatola', infinitive: 'jatohlisdi'],
            [subject: 'SG3', object: '', habitual: 'atolsgoi', imperative: 'hiyatola, hatola', infinitive: 'utohlisdi', present: 'atolsga', remote_past: 'utolsvi'],
            [subject: 'PL3', object: '', present: 'anatolsga', habitual: 'anatolsgoi', remote_past: 'unatolsvi', imperative: 'anatola', infinitive: 'unatohlisdi'],
            [subject: 'PL1INCL', object: '', present: 'idatolsga', habitual: 'idatolsgoi', remote_past: 'igatolsvi', imperative: 'idatola', infinitive: 'igatohlisdi']
        ]
    ]

    @Unroll
    def "conjugating Atolsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atolsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gatolsga"
        "SG1" | "" | Tense.HABITUAL        | "gatolsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwatolsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwatolsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadotlisdi"
        "SG2" | "" | Tense.PRESENT         | "hatolsga"
        "SG2" | "" | Tense.HABITUAL        | "hatolsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jatolsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jatolsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadotlisdi"
        "SG3" | "" | Tense.PRESENT         | "atolsga"
        "SG3" | "" | Tense.HABITUAL        | "atolsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utolsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "utolsvi"
        "SG3" | "" | Tense.INFINITIVE      | "udotlisdi"
        "PL3" | "" | Tense.PRESENT         | "anatolsga"
        "PL3" | "" | Tense.HABITUAL        | "anatolsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatolsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unatolsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadotlisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idatolsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idatolsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatolsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igatolsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadotlisdi"
    }
}
