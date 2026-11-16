// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72398 (entrya ahwisga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhwisgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he is Planting It",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiwisga'],
            [subject: 'SG1', object: '', present: 'jiwisga', habitual: 'jiwisgoi', remote_past: 'akihwisvi', imperative: 'jiwi', infinitive: 'akihwisdi'],
            [subject: 'SG2', object: '', present: 'hihwisga', habitual: 'hihwisgoi', remote_past: 'jahwisvi', imperative: 'hihwi', infinitive: 'jahwisdi'],
            [subject: 'SG3', object: '', habitual: 'ahwisgoi', imperative: 'hihwi', infinitive: 'uhwisdi', present: 'ahwisga', remote_past: 'uhwisvi'],
            [subject: 'PL3', object: '', present: 'anihwisga', habitual: 'anihwisgoi', remote_past: 'unihwisvi', imperative: 'anihwi', infinitive: 'unihwisdi'],
            [subject: 'PL1INCL', object: '', present: 'idihwisga', habitual: 'idihwisgoi', remote_past: 'igihwisvi', imperative: 'idihwi', infinitive: 'igihwisdi']
        ]
    ]

    @Unroll
    def "conjugating Ahwisga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahwisga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsiwisga"
        "SG1" | "" | Tense.HABITUAL        | "tsiwisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwisvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwisdi"
        "SG2" | "" | Tense.PRESENT         | "hiwisga"
        "SG2" | "" | Tense.HABITUAL        | "hiwisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwisvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawisdi"
        "SG3" | "" | Tense.PRESENT         | "awisga"
        "SG3" | "" | Tense.HABITUAL        | "awisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "awisvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwisdi"
        "PL3" | "" | Tense.PRESENT         | "aniwisga"
        "PL3" | "" | Tense.HABITUAL        | "aniwisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwisvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idiwisga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idiwisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiwisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiwisvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwisdi"
    }
}
