// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72410 (entrya ahyoha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhyohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Looking for Him",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyoha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyoha', habitual: 'jiyohoi', remote_past: 'jiyalvi', imperative: 'jiyga', infinitive: 'jiysdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hihyoha', habitual: 'hihyohoi', remote_past: 'hiyalvi', imperative: 'hiyhga', infinitive: 'hiysdi'],
            [subject: 'SG3', object: '', habitual: 'ahyohoi', imperative: 'hiyhga', infinitive: 'uysdi', present: 'ahyoha', remote_past: 'uhyalvi'],
            [subject: 'PL3', object: 'SG3AN', present: 'anihyoha', habitual: 'anihyohoi', remote_past: 'unihyalvi', imperative: 'aniyhga', infinitive: 'uniysdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'edihyoha', habitual: 'edihyohoi', remote_past: 'edihyalvi', imperative: 'ediyhga', infinitive: 'ediysdi']
        ]
    ]

    @Unroll
    def "conjugating Ahyoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahyoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyoha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyohoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyalvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyalvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiysdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyoha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyohoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "yalvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyalvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiysdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "gayoha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "ayohoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uyalvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "ayalvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uysdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "aniyoha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "aniyohoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "aniyalvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aniyalvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "uniysdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "ediyoha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "ediyohoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "yalvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "ediyalvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "ediysdi"
    }
}
