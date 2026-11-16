// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 74035 (entrya wakti) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class WaktiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Going (Specific Direction)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'wijigati'],
            [subject: 'SG1', object: '', present: 'wijigati', habitual: 'wijitatoi', remote_past: 'wijigatvi', imperative: 'wijigatesdi', infinitive: 'X'],
            [subject: 'SG2', object: '', present: 'hwakti', habitual: '/', remote_past: 'hwigati', imperative: 'hwaktoi', infinitive: '/'],
            [subject: 'SG3', object: '', habitual: 'waktoi', imperative: 'hwiktesdi', infinitive: '', present: 'wakti', remote_past: 'waktvi'],
            [subject: 'PL3', object: '', present: 'wanakti', habitual: 'wanaktoi', remote_past: 'wanaktvi', imperative: 'wanaktesdi', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'widakti', habitual: 'widaktoi', remote_past: 'widaktvi', imperative: 'widaktesdi', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Wakti (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Wakti", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsigiti"
        "SG1" | "" | Tense.HABITUAL        | "tsigidoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agigidvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsigidvi"
        // "SG1" | "" | Tense.INFINITIVE      | "X"
        "SG2" | "" | Tense.PRESENT         | "higiti"
        // "SG2" | "" | Tense.HABITUAL        | "/"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsagidvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "higidvi"
        // "SG2" | "" | Tense.INFINITIVE      | "/"
        "SG3" | "" | Tense.PRESENT         | "wagiti"
        "SG3" | "" | Tense.HABITUAL        | "wagidoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugidvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gagidvi"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "anigiti"
        "PL3" | "" | Tense.HABITUAL        | "anigidoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unigidvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anigidvi"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "idigiti"
        "PL1INCL" | "" | Tense.HABITUAL        | "idigidoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igigidvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idigidvi"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
