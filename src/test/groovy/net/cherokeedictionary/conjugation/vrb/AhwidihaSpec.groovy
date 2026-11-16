// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72397 (entrya ahwidiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhwidihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Take Along (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiwidiha'],
            [subject: 'SG1', object: '', present: 'jiwidiha', habitual: 'jiwidisgoi', remote_past: 'akiwidvhvi', imperative: 'jiwida', infinitive: 'akiwitdi'],
            [subject: 'SG2', object: '', present: 'hihwidiha', habitual: 'hihwidisgoi', remote_past: 'jahwidvhvi', imperative: 'hihwida', infinitive: 'jahwitdi'],
            [subject: 'SG3', object: '', habitual: 'ahwidisgoi', imperative: 'hihwida', infinitive: 'uhwitdi', present: 'ahwidiha', remote_past: 'uhwidvhvi'],
            [subject: 'PL3', object: '', present: 'anihwidiha', habitual: 'anihwidisgoi', remote_past: 'unihwidvhvi', imperative: 'anihwida', infinitive: 'unihwitdi']
        ]
    ]

    @Unroll
    def "conjugating Ahwidiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahwidiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsiwidiha"
        "SG1" | "" | Tense.HABITUAL        | "tsiwidisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwidvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwidvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwitidi"
        "SG2" | "" | Tense.PRESENT         | "hiwidiha"
        "SG2" | "" | Tense.HABITUAL        | "hiwidisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawidvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwidvhvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawitidi"
        "SG3" | "" | Tense.PRESENT         | "awidiha"
        "SG3" | "" | Tense.HABITUAL        | "awidisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwidvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "awidvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwitidi"
        "PL3" | "" | Tense.PRESENT         | "aniwidiha"
        "PL3" | "" | Tense.HABITUAL        | "aniwidisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwidvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwidvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwitidi"
    }
}
