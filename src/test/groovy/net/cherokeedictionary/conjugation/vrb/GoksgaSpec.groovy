// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73258 (entrya goksga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GoksgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Smoking (122)*",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gogisga'],
            [subject: 'SG1', object: '', present: 'gogisga', habitual: 'gogisgoi', remote_past: 'agwoksvi', imperative: 'gogi', infinitive: 'agwoksdi'],
            [subject: 'SG2', object: '', present: 'hoksga', habitual: 'hoksgoi', remote_past: 'joksvi', imperative: 'hogi', infinitive: 'joksdi'],
            [subject: 'SG3', object: '', habitual: 'goksgoi', imperative: 'hogi', infinitive: 'uwoksdi', present: 'goksga', remote_past: 'uwoksvi'],
            [subject: 'PL3', object: '', present: 'anoksga', habitual: 'anoksgoi', remote_past: 'unoksvi', imperative: 'anogi', infinitive: 'unoksdi'],
            [subject: 'PL1INCL', object: '', present: 'idoksga', habitual: 'idoksgoi', remote_past: 'igoksvi', imperative: 'idogi', infinitive: 'igoksdi']
        ]
    ]

    @Unroll
    def "conjugating Goksga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Goksga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gogisga"
        "SG1" | "" | Tense.HABITUAL        | "gogisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwoksvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwoksvi"
        "SG1" | "" | Tense.INFINITIVE      | "agwoksdi"
        "SG2" | "" | Tense.PRESENT         | "hoksga"
        "SG2" | "" | Tense.HABITUAL        | "hoksgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "joksvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "joksvi"
        "SG2" | "" | Tense.INFINITIVE      | "joksdi"
        "SG3" | "" | Tense.PRESENT         | "goksga"
        "SG3" | "" | Tense.HABITUAL        | "goksgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwoksvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwoksvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwoksdi"
        "PL3" | "" | Tense.PRESENT         | "anoksga"
        "PL3" | "" | Tense.HABITUAL        | "anoksgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unoksvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unoksvi"
        "PL3" | "" | Tense.INFINITIVE      | "unoksdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idoksga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idoksgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igoksvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igoksvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igoksdi"
    }
}
