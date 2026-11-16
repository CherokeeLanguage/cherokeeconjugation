// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72314 (entrya agia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AgiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Eat It (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jigia'],
            [subject: 'SG1', object: '', present: 'jigia', habitual: 'jigisgoi', remote_past: 'agigvi', imperative: 'jiga', infinitive: 'agigisdi'],
            [subject: 'SG2', object: '', present: 'higia', habitual: 'higisgoi', remote_past: 'jagvi', imperative: 'higa', infinitive: 'jagisdi'],
            [subject: 'SG3', object: '', habitual: 'agisgoi', imperative: 'higi', infinitive: 'ugisdi', present: 'agia', remote_past: 'ugisvi'],
            [subject: 'PL3', object: '', present: 'anigia', habitual: 'anigisgoi', remote_past: 'unigvi', imperative: 'aniga', infinitive: 'anigisdi']
        ]
    ]

    @Unroll
    def "conjugating Agia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Agia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsigia"
        "SG1" | "" | Tense.HABITUAL        | "tsigisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agigisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsigisvi"
        "SG1" | "" | Tense.INFINITIVE      | "agigisdi"
        "SG2" | "" | Tense.PRESENT         | "higia"
        "SG2" | "" | Tense.HABITUAL        | "higisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsagisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "higisvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsagisdi"
        "SG1" | "" | Tense.PRESENT         | "tsigia"
        "SG1" | "" | Tense.HABITUAL        | "tsigisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agigisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsigisvi"
        "SG1" | "" | Tense.INFINITIVE      | "agigisdi"
        "PL3" | "" | Tense.PRESENT         | "anigia"
        "PL3" | "" | Tense.HABITUAL        | "anigisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unigisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anigisvi"
        "PL3" | "" | Tense.INFINITIVE      | "unigisdi"
    }
}
