// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72691 (entrya atvgia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtvgiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Hearing",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyatvgia, gatvgia'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyatvgia', habitual: 'jiyatvgisgoi', remote_past: 'jiyatvganvi', imperative: 'jiyatvgvga', infinitive: 'jiyatvgodi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gatvgia', habitual: 'gatvgisgoi', remote_past: 'aktvganvi', imperative: 'gatvgvga', infinitive: 'aktvgodi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyatvgia', habitual: 'hiyatvgisgoi', remote_past: 'hiyatvganvi', imperative: 'hiyatvgvga', infinitive: 'hiyatvgodi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hatvgia', habitual: 'hatvgisgoi', remote_past: 'tstvganvi', imperative: 'hatvgvga', infinitive: 'tstvgodi'],
            [subject: 'SG3', object: '', habitual: 'atvgisgoi', imperative: 'hiyatvgvga, hatvgvga', infinitive: 'utvgodi', present: 'atvgia', remote_past: 'utvganvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anatvgia', habitual: 'anatvgisgoi', remote_past: 'unatvganvi', imperative: 'anatvgvga', infinitive: 'unatvgodi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idatvgia', habitual: 'idatvgisgoi', remote_past: 'iktvganvi', imperative: 'idatvgvga', infinitive: 'iktvgodi']
        ]
    ]

    @Unroll
    def "conjugating Atvgia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atvgia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyadvgia"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyadvgisgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyadvganvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyadvganvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyadvgodi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gadvgia"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gadvgisgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aquadvganvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gadvganvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "aquadvgodi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyadvgia"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyadvgisgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "advganvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyadvganvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "advgodi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hadvgia"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hadvgisgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tsadvganvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hadvganvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsadvgodi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "advgia"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "advgisgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "udvganvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "advganvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "udvgodi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anadvgia"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anadvgisgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unadvganvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anadvganvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unadvgodi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "otsadvgia"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idadvgisgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igadvganvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idadvganvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igadvgodi"
    }
}
