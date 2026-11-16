// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72251 (entrya adelohosga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdelohosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Finding it Out",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadeloosga'],
            [subject: 'SG1', object: '', present: 'gadelohosga', habitual: 'gadelohosgoi', remote_past: 'agwadelohosvi', imperative: 'gadelohohi', infinitive: 'agwadelohohisdi'],
            [subject: 'SG2', object: '', present: 'hadelohosga', habitual: 'hadelohosgoi', remote_past: 'jadelohosvi', imperative: 'hadelohohi', infinitive: 'jadelohohisdi'],
            [subject: 'SG3', object: '', habitual: 'adelohosgoi', imperative: 'hadelohohi', infinitive: 'udelohohisdi', present: 'adelohosga', remote_past: 'udelohosvi'],
            [subject: 'PL3', object: '', present: 'anadelohosga', habitual: 'anadelohosgoi', remote_past: 'unadelohosvi', imperative: 'anadelohohi', infinitive: 'unadelohohisdi'],
            [subject: 'PL1INCL', object: '', present: 'idadelohosga', habitual: 'idadelohosgoi', remote_past: 'igadelohosvi', imperative: 'idadelohohi', infinitive: 'igadelohohisdi']
        ]
    ]

    @Unroll
    def "conjugating Adelohosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adelohosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadelohosga"
        "SG1" | "" | Tense.HABITUAL        | "gadelohosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadelohosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadelohosvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadelohohisdi"
        "SG2" | "" | Tense.PRESENT         | "hadelohosga"
        "SG2" | "" | Tense.HABITUAL        | "hadelohosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadelohosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadelohosvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadelohohisdi"
        "SG3" | "" | Tense.PRESENT         | "adelohosga"
        "SG3" | "" | Tense.HABITUAL        | "adelohosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udelohosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adelohosvi"
        "SG3" | "" | Tense.INFINITIVE      | "udelohohisdi"
        "PL3" | "" | Tense.PRESENT         | "anadelohosga"
        "PL3" | "" | Tense.HABITUAL        | "anadelohosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadelohosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadelohosvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadelohohisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadelohosga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadelohosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadelohosvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadelohosvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadelohohisdi"
    }
}
