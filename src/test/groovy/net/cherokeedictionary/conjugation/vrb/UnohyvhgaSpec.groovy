// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73915 (entrya unohyvhga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UnohyvhgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Sound (It is making)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'aginohyvhga'],
            [subject: 'SG1', object: '', present: 'aginohyvhga', habitual: 'aginohyvhgoi', remote_past: 'aginohyvlsvi', imperative: 'aginohyvla', infinitive: 'aginohyvhlisdi'],
            [subject: 'SG2', object: '', present: 'janohyvhga', habitual: 'janohyvhgoi', remote_past: 'janohyvlsvi', imperative: 'janohyvla', infinitive: 'janohyvhlisdi'],
            [subject: 'SG3', object: '', habitual: 'unohyvhgoi', imperative: 'janohyvla', infinitive: 'unohyvhlisdi', present: 'unohyvhga', remote_past: 'unohyvlsvi'],
            [subject: 'PL3', object: '', present: 'uninohyvhga', habitual: 'uninohyvhgoi', remote_past: 'uninohyvlsvi', imperative: 'uninohyvla', infinitive: 'uninohyvhlisdi'],
            [subject: 'PL1INCL', object: '', present: 'iginohyvhga', habitual: 'iginohyvhgoi', remote_past: 'iginohyvlsvi', imperative: 'iginohyvla', infinitive: 'iginohyvhlisdi']
        ]
    ]

    @Unroll
    def "conjugating Unohyvhga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Unohyvhga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aginoyvga"
        "SG1" | "" | Tense.HABITUAL        | "aginoyvgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginoyvlisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aginoyvlisvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginoyvtlisdi"
        "SG2" | "" | Tense.PRESENT         | "tsanoyvga"
        "SG2" | "" | Tense.HABITUAL        | "tsanoyvgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanoyvlisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsanoyvlisvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanoyvtlisdi"
        "SG3" | "" | Tense.PRESENT         | "unoyvga"
        "SG3" | "" | Tense.HABITUAL        | "unoyvgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unoyvlisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "unoyvlisvi"
        "SG3" | "" | Tense.INFINITIVE      | "unoyvtlisdi"
        "PL3" | "" | Tense.PRESENT         | "uninoyvga"
        "PL3" | "" | Tense.HABITUAL        | "uninoyvgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninoyvlisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uninoyvlisvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninoyvtlisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "iginoyvga"
        "PL1INCL" | "" | Tense.HABITUAL        | "iginoyvgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginoyvlisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iginoyvlisvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginoyvtlisdi"
    }
}
