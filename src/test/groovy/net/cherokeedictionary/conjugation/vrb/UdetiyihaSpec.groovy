// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73739 (entrya udetiyiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UdetiyihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Having a Birthday",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agwadetiyiha'],
            [subject: 'SG1', object: '', present: 'agwadetiyiha', habitual: 'agwadetiyisgoi', remote_past: 'agwadetiyvhvi', imperative: 'agwadetiya', infinitive: 'agwadetiyhdi'],
            [subject: 'SG2', object: '', present: 'jadetiyiha', habitual: 'jadetiyisgoi', remote_past: 'jadetiyvhvi', imperative: 'jadetiya', infinitive: 'jadetiyhdi'],
            [subject: 'SG3', object: '', habitual: 'udetiyisgoi', imperative: 'jadetiya', infinitive: 'udetiyhdi', present: 'udetiyiha', remote_past: 'udetiyvhvi'],
            [subject: 'PL3', object: '', present: 'unadetiyiha', habitual: 'unadetiyisgoi', remote_past: 'unadetiyvhvi', imperative: 'unadetiya', infinitive: 'unadetiyhdi'],
            [subject: 'PL1INCL', object: '', present: 'igadetiyiha', habitual: 'igadetiyisgoi', remote_past: 'igadetiyvhvi', imperative: 'igadetiya', infinitive: 'igadetiyhdi']
        ]
    ]

    @Unroll
    def "conjugating Udetiyiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Udetiyiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwadetiyiha"
        "SG1" | "" | Tense.HABITUAL        | "agwadetiyisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadetiyvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquadetiyvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwadetiyhdi"
        "SG2" | "" | Tense.PRESENT         | "jadetiyiha"
        "SG2" | "" | Tense.HABITUAL        | "jadetiyisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadetiyvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsadetiyvhvi"
        "SG2" | "" | Tense.INFINITIVE      | "jadetiyhdi"
        "SG3" | "" | Tense.PRESENT         | "udetiyiha"
        "SG3" | "" | Tense.HABITUAL        | "udetiyisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udetiyvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "udetiyvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "udetiyhdi"
        "PL3" | "" | Tense.PRESENT         | "unadetiyiha"
        "PL3" | "" | Tense.HABITUAL        | "unadetiyisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadetiyvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unadetiyvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadetiyhdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igadetiyiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igadetiyisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadetiyvhvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igadetiyvhvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadetiyhdi"
    }
}
