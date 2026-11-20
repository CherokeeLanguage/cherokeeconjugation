// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72609 (entrya asgosga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsgosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Digging It",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gasgosga'],
            [subject: 'SG1', object: '', present: 'gasgosga', habitual: 'gasgosgoi', remote_past: 'agwasgosvi', imperative: 'gasgola', infinitive: 'agwasgosdi'],
            [subject: 'SG2', object: '', present: 'hasgosga', habitual: 'hasgosgoi', remote_past: 'jasgosvi', imperative: 'hasgola', infinitive: 'jasgosdi'],
            [subject: 'SG3', object: '', habitual: 'asgosgoi', imperative: 'hasgola', infinitive: 'usgosdi', present: 'asgosga', remote_past: 'usgosvi'],
            [subject: 'PL3', object: '', present: 'anasgosga', habitual: 'anasgosgoi', remote_past: 'unasgosvi', imperative: 'anasgola', infinitive: 'unasgosdi'],
            [subject: 'PL1INCL', object: '', present: 'idasgosga', habitual: 'idasgosgoi', remote_past: 'igasgosvi', imperative: 'idasgola', infinitive: 'igasgosdi']
        ]
    ]

    @Unroll
    def "conjugating Asgosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asgosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gasgosga"
        "SG1" | "" | Tense.HABITUAL        | "gasgosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwasgosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gasgosvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwasgosdi"
        "SG2" | "" | Tense.PRESENT         | "hasgosga"
        "SG2" | "" | Tense.HABITUAL        | "hasgosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jasgosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hasgosvi"
        "SG2" | "" | Tense.INFINITIVE      | "jasgosdi"
        "SG3" | "" | Tense.PRESENT         | "asgosga"
        "SG3" | "" | Tense.HABITUAL        | "asgosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usgosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asgosvi"
        "SG3" | "" | Tense.INFINITIVE      | "usgosdi"
        "PL3" | "" | Tense.PRESENT         | "anasgosga"
        "PL3" | "" | Tense.HABITUAL        | "anasgosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unasgosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anasgosvi"
        "PL3" | "" | Tense.INFINITIVE      | "unasgosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idasgosga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idasgosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igasgosvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idasgosvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igasgosdi"
    }
}
