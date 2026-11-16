// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73095 (entrya ganahlvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanahlvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Hiring Him",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinahlvsga'],
            [subject: 'SG1', object: '', present: 'jinahlvsga', habitual: 'jinahlvsgoi', remote_past: 'jinahlvnvi', imperative: 'jinahlvvga', infinitive: 'jinahlvdi'],
            [subject: 'SG2', object: '', present: 'hinahlvsga', habitual: 'hinahlvsgoi', remote_past: 'hinahlvnvi', imperative: 'hinahlvvga', infinitive: 'hinahlvdi'],
            [subject: 'SG3', object: '', habitual: 'ganahlvsgoi', imperative: 'hinahlvvga', infinitive: 'unahlvdi', present: 'ganahlvsga', remote_past: 'unahlvnvi'],
            [subject: 'PL3', object: '', present: 'aninahlvsga', habitual: 'aninahlvsgoi', remote_past: 'aninahlvnvi', imperative: 'aninahlvvga', infinitive: 'uninahlvdi'],
            [subject: 'PL1INCL', object: '', present: 'edinahlvsga', habitual: 'edinahlvsgoi', remote_past: 'edinahlvnvi', imperative: 'edinahlvvga', infinitive: 'edinahlvdi']
        ]
    ]

    @Unroll
    def "conjugating Ganahlvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganahlvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinatlvsga"
        "SG1" | "" | Tense.HABITUAL        | "tsinatlvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginatlvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinatlvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginatlvdi"
        "SG2" | "" | Tense.PRESENT         | "hinatlvsga"
        "SG2" | "" | Tense.HABITUAL        | "hinatlvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanatlvnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinatlvnvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanatlvdi"
        "SG3" | "" | Tense.PRESENT         | "ganatlvsga"
        "SG3" | "" | Tense.HABITUAL        | "ganatlvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unatlvnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganatlvnvi"
        "SG3" | "" | Tense.INFINITIVE      | "unatlvdi"
        "PL3" | "" | Tense.PRESENT         | "aninatlvsga"
        "PL3" | "" | Tense.HABITUAL        | "aninatlvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninatlvnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninatlvnvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninatlvdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinatlvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinatlvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginatlvnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinatlvnvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginatlvdi"
    }
}
