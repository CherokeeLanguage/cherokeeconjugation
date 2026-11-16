// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73206 (entrya gawoniha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GawonihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Speaking",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiwoniha'],
            [subject: 'SG1', object: '', present: 'jiwoniha', habitual: 'jiwonisgoi', remote_past: 'agiwonisvi', imperative: 'jiwonihi', infinitive: 'agiwonihisdi'],
            [subject: 'SG2', object: '', present: 'hiwoniha', habitual: 'hiwonisgoi', remote_past: 'jawonisvi', imperative: 'hiwonihi', infinitive: 'jawonihisdi'],
            [subject: 'SG3', object: '', habitual: 'gawonisgoi', imperative: 'hiwonihi', infinitive: 'uwonihisdi', present: 'gawoniha', remote_past: 'uwonisvi'],
            [subject: 'PL3', object: '', present: 'aniwoniha', habitual: 'aniwonisgoi', remote_past: 'uniwonisvi', imperative: 'aniwonihi', infinitive: 'uniwonihisdi'],
            [subject: 'PL1INCL', object: '', present: 'idiwoniha', habitual: 'idiwonisgoi', remote_past: 'igiwonisvi', imperative: 'idiwonihi', infinitive: 'igiwonihisdi']
        ]
    ]

    @Unroll
    def "conjugating Gawoniha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gawoniha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsiwoniha"
        "SG1" | "" | Tense.HABITUAL        | "tsiwonisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwonisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwonisvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwonihisdi"
        "SG2" | "" | Tense.PRESENT         | "hiwoniha"
        "SG2" | "" | Tense.HABITUAL        | "hiwonisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawonisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwonisvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawonihisdi"
        "SG3" | "" | Tense.PRESENT         | "gawoniha"
        "SG3" | "" | Tense.HABITUAL        | "gawonisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwonisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawonisvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwonihisdi"
        "PL3" | "" | Tense.PRESENT         | "aniwoniha"
        "PL3" | "" | Tense.HABITUAL        | "aniwonisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwonisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwonisvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwonihisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idiwoniha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idiwonisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiwonisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiwonisvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwonihisdi"
    }
}
