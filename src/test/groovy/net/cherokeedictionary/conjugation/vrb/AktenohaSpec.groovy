// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72470 (entrya aktenoha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AktenohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Looking (Around)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jigatenoha'],
            [subject: 'SG1', object: '', present: 'jigatenoha', habitual: 'jigatenohoi', remote_past: 'agwaktenolvi', imperative: 'jigatenaga', infinitive: 'agwaktenasdi'],
            [subject: 'SG2', object: '', present: 'haktenoha', habitual: 'haktenohoi', remote_past: 'jaktenolvi', imperative: 'hiktenaga', infinitive: 'jaktenasdi'],
            [subject: 'SG3', object: '', habitual: 'aktenohoi', imperative: 'hiktenaga', infinitive: 'uktenasdi', present: 'aktenoha', remote_past: 'uktenolvi'],
            [subject: 'PL3', object: '', present: 'anaktenoha', habitual: 'anaktenohoi', remote_past: 'unaktenolvi', imperative: 'anaktenaga', infinitive: 'unaktenasdi'],
            [subject: 'PL1INCL', object: '', present: 'idaktenoha', habitual: 'idaktenohoi', remote_past: 'igaktenolvi', imperative: 'idaktenaga', infinitive: 'igaktenasdi']
        ]
    ]

    @Unroll
    def "conjugating Aktenoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aktenoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsigitenoha"
        "SG1" | "" | Tense.HABITUAL        | "tsigitenohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agigitenolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsigitenolvi"
        "SG1" | "" | Tense.INFINITIVE      | "agigitenasdi"
        "SG2" | "" | Tense.PRESENT         | "higitenoha"
        "SG2" | "" | Tense.HABITUAL        | "higitenohoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsagitenolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "higitenolvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsagitenasdi"
        "SG3" | "" | Tense.PRESENT         | "agitenoha"
        "SG3" | "" | Tense.HABITUAL        | "agitenohoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugitenolvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "agitenolvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugitenasdi"
        "PL3" | "" | Tense.PRESENT         | "anigitenoha"
        "PL3" | "" | Tense.HABITUAL        | "anigitenohoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unigitenolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anigitenolvi"
        "PL3" | "" | Tense.INFINITIVE      | "unigitenasdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idigitenoha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idigitenohoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igigitenolvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idigitenolvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igigitenasdi"
    }
}
