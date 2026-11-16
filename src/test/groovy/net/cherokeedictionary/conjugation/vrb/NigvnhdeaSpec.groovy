// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73561 (entrya nigvnhdea) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class NigvnhdeaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Taking It Off (147)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'nigvnhdea'],
            [subject: 'SG1', object: '', present: 'nigvnhdea', habitual: 'nigvnhdesgoi', remote_past: 'nagwvnhdesvi', imperative: 'nigvnhdagi', infinitive: 'iyagwvnhdesdi'],
            [subject: 'SG2', object: '', present: 'hnvnhdea', habitual: 'hnvnhdesgoi', remote_past: 'nijvnhdesvi', imperative: 'hnvnhdagi', infinitive: 'iyijvnhdesdi'],
            [subject: 'SG3', object: '', habitual: 'nigvnhdesgoi', imperative: 'hnvnhdagi', infinitive: 'iyuwanhdesdi', present: 'nigvnhdea', remote_past: 'nuwanhdesvi'],
            [subject: 'PL3', object: '', present: 'nanvnhdea', habitual: 'nanvnhdesgoi', remote_past: 'nunvnhdesvi', imperative: 'nanvnhdagi', infinitive: 'iyunvnhdesdi'],
            [subject: 'PL1INCL', object: '', present: 'nidvnhdea', habitual: 'nidvnhdesgoi', remote_past: 'nigvnhdesvi', imperative: 'nidvnhdagi', infinitive: 'iyigvnhdesdi']
        ]
    ]

    @Unroll
    def "conjugating Nigvnhdea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Nigvnhdea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gvnidea"
        "SG1" | "" | Tense.HABITUAL        | "gvnidesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquvnidesvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gvnidesvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiyuwanidesdi"
        "SG2" | "" | Tense.PRESENT         | "hvnidea"
        "SG2" | "" | Tense.HABITUAL        | "hvnidesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsvnidesvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hvnidesvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsayuwanidesdi"
        "SG3" | "" | Tense.PRESENT         | "nigvnidea"
        "SG3" | "" | Tense.HABITUAL        | "nigvnidesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwanidesvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "vnidesvi"
        "SG3" | "" | Tense.INFINITIVE      | "uyuwanidesdi"
        "PL3" | "" | Tense.PRESENT         | "anvnidea"
        "PL3" | "" | Tense.HABITUAL        | "anvnidesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unanidesvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anvnidesvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyuwanidesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idvnidea"
        "PL1INCL" | "" | Tense.HABITUAL        | "idvnidesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igvnidesvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idvnidesvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiyuwanidesdi"
    }
}
