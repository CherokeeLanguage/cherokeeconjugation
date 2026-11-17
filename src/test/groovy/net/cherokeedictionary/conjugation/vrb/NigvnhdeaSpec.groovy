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
        "SG1" | "" | Tense.PRESENT         | "gvnadea"
        "SG1" | "" | Tense.HABITUAL        | "gvnadesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquvnadesvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gvnadesvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiyuwanadesdi"
        "SG2" | "" | Tense.PRESENT         | "hvnadea"
        "SG2" | "" | Tense.HABITUAL        | "hvnadesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsvnadesvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hvnadesvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsayuwanadesdi"
        "SG3" | "" | Tense.PRESENT         | "nigvnadea"
        "SG3" | "" | Tense.HABITUAL        | "nigvnadesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwanadesvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "vnadesvi"
        "SG3" | "" | Tense.INFINITIVE      | "uyuwanadesdi"
        "PL3" | "" | Tense.PRESENT         | "anvnadea"
        "PL3" | "" | Tense.HABITUAL        | "anvnadesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unanadesvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anvnadesvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyuwanadesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idvnadea"
        "PL1INCL" | "" | Tense.HABITUAL        | "idvnadesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igvnadesvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idvnadesvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiyuwanadesdi"
    }
}
