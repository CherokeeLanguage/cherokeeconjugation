// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72246 (entrya adehosga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdehosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he is Embarrassed",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadeosga'],
            [subject: 'SG1', object: '', present: 'gadeosga', habitual: 'gadeosgoi', remote_past: 'agwadehosvi', imperative: 'gadeohi', infinitive: 'agwadehohisdi'],
            [subject: 'SG2', object: '', present: 'hadehosga', habitual: 'hadehosgoi', remote_past: 'jadehosvi', imperative: 'hadehohi', infinitive: 'jadehohisdi'],
            [subject: 'SG3', object: '', habitual: 'adehosgoi', imperative: 'hadehohi', infinitive: 'udehohisdi', present: 'adehosga', remote_past: 'udehosvi'],
            [subject: 'PL3', object: '', present: 'anadehosga', habitual: 'anadehosgoi', remote_past: 'unadehosvi', imperative: 'anadehohi', infinitive: 'unadehohisdi'],
            [subject: 'PL1INCL', object: '', present: 'idadehosga', habitual: 'idadehosgoi', remote_past: 'igadehosvi', imperative: 'idadehohi', infinitive: 'igadehohisdi']
        ]
    ]

    @Unroll
    def "conjugating Adehosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adehosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadehosga"
        "SG1" | "" | Tense.HABITUAL        | "gadehosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadehosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadehosvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadehohisdi"
        "SG2" | "" | Tense.PRESENT         | "hadehosga"
        "SG2" | "" | Tense.HABITUAL        | "hadehosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadehosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadehosvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadehohisdi"
        "SG3" | "" | Tense.PRESENT         | "adehosga"
        "SG3" | "" | Tense.HABITUAL        | "adehosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udehosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adehosvi"
        "SG3" | "" | Tense.INFINITIVE      | "udehohisdi"
        "PL3" | "" | Tense.PRESENT         | "anadehosga"
        "PL3" | "" | Tense.HABITUAL        | "anadehosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadehosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadehosvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadehohisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadehosga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadehosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadehosvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadehosvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadehohisdi"
    }
}
