// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72744 (entrya dadeyohvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DadeyohvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Teaching",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'degadeyohvsga'],
            [subject: 'SG1', object: '', present: 'degadeyohvsga', habitual: 'degadeyohvsgoi', remote_past: 'dagwadeyohnvi', imperative: 'digadeyohvga', infinitive: 'digwadehyohdi'],
            [subject: 'SG2', object: '', present: 'dehadeyohvsga', habitual: 'dehadeyohvsgoi', remote_past: 'dejadeyohnvi', imperative: 'tadeyohvga', infinitive: 'dijadehyohdi'],
            [subject: 'SG3', object: '', habitual: 'dadehyohvsgoi', imperative: 'tadehyohvga', infinitive: 'judehyohdi', present: 'dadeyohvsga', remote_past: 'dudeyohnvi'],
            [subject: 'PL3', object: '', present: 'danadeyohvsga', habitual: 'danadeyohvsgoi', remote_past: 'dunadeyohnvi', imperative: 'dinadeyohvga', infinitive: 'junadehyohdi'],
            [subject: 'PL1INCL', object: '', present: 'dedadeyohvsga', habitual: 'dedadeyohvsgoi', remote_past: 'degadeyohnvi', imperative: 'didadeyohvga', infinitive: 'digadehyohdi']
        ]
    ]

    @Unroll
    def "conjugating Dadeyohvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dadeyohvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degadeyohvsga"
        "SG1" | "" | Tense.HABITUAL        | "degadeyohvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwadeyohnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadeyonvi"
        "SG1" | "" | Tense.INFINITIVE      | "digwadehyohdi"
        "SG2" | "" | Tense.PRESENT         | "dehadeyohvsga"
        "SG2" | "" | Tense.HABITUAL        | "dehadeyohvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejadeyohnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadeyonvi"
        "SG2" | "" | Tense.INFINITIVE      | "dijadehyohdi"
        "SG3" | "" | Tense.PRESENT         | "dadeyohvsga"
        "SG3" | "" | Tense.HABITUAL        | "dadehyohvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dudeyohnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adeyonvi"
        "SG3" | "" | Tense.INFINITIVE      | "judehyohdi"
        "PL3" | "" | Tense.PRESENT         | "danadeyohvsga"
        "PL3" | "" | Tense.HABITUAL        | "danadeyohvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunadeyohnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadeyonvi"
        "PL3" | "" | Tense.INFINITIVE      | "junadehyohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedadeyohvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedadeyohvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degadeyohnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadeyonvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digadehyohdi"
    }
}
