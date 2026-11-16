// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72800 (entrya danilawiga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DanilawigaSpec extends VerbBaseSpec {
    static def details = [
        definition: "They're Having Church",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'dojilawiga'],
            [subject: 'SG1', object: '', present: 'dosdilawiga', habitual: 'dosdilawigoi', remote_past: 'doginilawijvi', imperative: 'josdilawigi', infinitive: 'joginilawisdi'],
            [subject: 'SG2', object: '', present: 'dojilawiga', habitual: 'dojilawigoi', remote_past: 'dogilawijvi', imperative: 'jojilawigi', infinitive: 'jogilawisdi'],
            [subject: 'SG3', object: '', habitual: 'danilawigoi', imperative: 'dijilawigi', infinitive: 'junilawisdi', present: 'danilawiga', remote_past: 'dunilawijvi'],
            [subject: 'PL3', object: '', present: 'dejilawiga', habitual: 'dejilawigoi', remote_past: 'dejilawijvi', imperative: 'dijilawigi', infinitive: 'dijilawisdi'],
            [subject: 'PL1INCL', object: '', present: 'dedilawiga', habitual: 'dedilawigoi', remote_past: 'degilawijvi', imperative: 'didilawigi', infinitive: 'digilawisdi']
        ]
    ]

    @Unroll
    def "conjugating Danilawiga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Danilawiga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "ganilawiga"
        "SG1" | "" | Tense.HABITUAL        | "ganilawigoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquanilawitsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganilawitsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginilawisdi"
        "SG2" | "" | Tense.PRESENT         | "hanilawiga"
        "SG2" | "" | Tense.HABITUAL        | "hanilawigoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanilawitsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hanilawitsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanilawisdi"
        "SG3" | "" | Tense.PRESENT         | "danilawiga"
        "SG3" | "" | Tense.HABITUAL        | "danilawigoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unilawitsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anilawitsvi"
        "SG3" | "" | Tense.INFINITIVE      | "unilawisdi"
        "PL3" | "" | Tense.PRESENT         | "ananilawiga"
        "PL3" | "" | Tense.HABITUAL        | "ananilawigoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unanilawitsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "ananilawitsvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninilawisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idanilawiga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idanilawigoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iganilawitsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idanilawitsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginilawisdi"
    }
}
