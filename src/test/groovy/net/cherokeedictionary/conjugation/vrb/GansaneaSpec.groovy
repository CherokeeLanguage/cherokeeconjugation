// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73152 (entrya gansanea) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GansaneaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Pulling",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinasanea, jinasanea'],
            [subject: 'SG1', object: '', present: 'jinasanea', habitual: 'jinasanesgoi', remote_past: 'aginsanesvi', imperative: 'jinasanagi', infinitive: 'aginsanesdi'],
            [subject: 'SG3', object: '', habitual: 'gansanesgoi', imperative: 'hinasanagi, hinsanagi', infinitive: 'unsanesdi', present: 'gansanea', remote_past: 'unsanesvi'],
            [subject: 'PL3', object: '', present: 'aninsanea', habitual: 'aninsanesgoi', remote_past: 'uninsanesvi', imperative: 'aninsanagi', infinitive: 'uninsanesdi'],
            [subject: 'PL1INCL', object: '', present: 'idinsanea', habitual: 'idinsanesgoi', remote_past: 'iginsanesvi', imperative: 'idinsanagi', infinitive: 'iginsanesdi']
        ]
    ]

    @Unroll
    def "conjugating Gansanea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gansanea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinisanea"
        "SG1" | "" | Tense.HABITUAL        | "tsinisanesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginisanesvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinisanesvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginisanesdi"
        "SG1" | "" | Tense.PRESENT         | "tsinisanea"
        "SG1" | "" | Tense.HABITUAL        | "tsinisanesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginisanesvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinisanesvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginisanesdi"
        "PL3" | "" | Tense.PRESENT         | "aninisanea"
        "PL3" | "" | Tense.HABITUAL        | "aninisanesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninisanesvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninisanesvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninisanesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinisanea"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinisanesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginisanesvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinisanesvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginisanesdi"
    }
}
