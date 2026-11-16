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
        "SG1" | "" | Tense.PRESENT         | "gadolisga"
        "SG1" | "" | Tense.HABITUAL        | "gadolisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadolisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadolisvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadotlisdi"
        "SG2" | "" | Tense.PRESENT         | "hadolisga"
        "SG2" | "" | Tense.HABITUAL        | "hadolisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadolisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadolisvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadotlisdi"
        "SG3" | "" | Tense.PRESENT         | "adolisga"
        "SG3" | "" | Tense.HABITUAL        | "adolisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udolisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adolisvi"
        "SG3" | "" | Tense.INFINITIVE      | "udotlisdi"
        "PL3" | "" | Tense.PRESENT         | "anadolisga"
        "PL3" | "" | Tense.HABITUAL        | "anadolisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadolisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadolisvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadotlisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadolisga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadolisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadolisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadolisvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadotlisdi"
    }
}
