// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72702 (entrya ayega) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Waking Up",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyega'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyega', habitual: 'jiyegoi', remote_past: 'agiyejvi', imperative: 'jiyegi', infinitive: 'agiyeisdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyega', habitual: 'hiyegoi', remote_past: 'jayejvi', imperative: 'hiyegi', infinitive: 'jayeisdi'],
            [subject: 'SG3', object: '', habitual: 'ayegoi', imperative: 'hiyegi', infinitive: 'uyeisdi', present: 'ayega', remote_past: 'uyejvi'],
            [subject: 'PL3', object: 'SG3AN', present: 'aniyega', habitual: 'aniyegoi', remote_past: 'uniyejvi', imperative: 'aniyegi', infinitive: 'uniyeisdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'idiyega', habitual: 'idiyegoi', remote_past: 'igiyejvi', imperative: 'idiyegi', infinitive: 'igiyeisdi']
        ]
    ]

    @Unroll
    def "conjugating Ayega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyega"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyegoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyetsvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyetsvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyeisdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyega"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyegoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "yetsvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyetsvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "yeisdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "gayega"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "ayegoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uyetsvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "ayetsvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uyeisdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "aniyega"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "aniyegoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "aniyetsvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aniyetsvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "aniyeisdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "ediyega"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "ediyegoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "yetsvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "ediyetsvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "yeisdi"
    }
}
