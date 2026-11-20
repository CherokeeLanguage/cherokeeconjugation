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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aginohyvhga"
        "SG1" | "" | Tense.HABITUAL        | "aginohyvhgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginohyvlsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aginoyvlisvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginohyvhlisdi"
        "SG2" | "" | Tense.PRESENT         | "janohyvhga"
        "SG2" | "" | Tense.HABITUAL        | "janohyvhgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janohyvlsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsanoyvlisvi"
        "SG2" | "" | Tense.INFINITIVE      | "janohyvhlisdi"
        "SG3" | "" | Tense.PRESENT         | "unohyvhga"
        "SG3" | "" | Tense.HABITUAL        | "unohyvhgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unohyvlsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "unoyvlisvi"
        "SG3" | "" | Tense.INFINITIVE      | "unohyvhlisdi"
        "PL3" | "" | Tense.PRESENT         | "uninohyvhga"
        "PL3" | "" | Tense.HABITUAL        | "uninohyvhgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninohyvlsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uninoyvlisvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninohyvhlisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "iginohyvhga"
        "PL1INCL" | "" | Tense.HABITUAL        | "iginohyvhgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginohyvlsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iginoyvlisvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginohyvhlisdi"
    }
}
