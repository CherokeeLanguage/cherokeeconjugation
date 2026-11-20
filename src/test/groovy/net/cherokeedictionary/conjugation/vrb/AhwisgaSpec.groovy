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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiwisga"
        "SG1" | "" | Tense.HABITUAL        | "jiwisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akihwisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwisvi"
        "SG1" | "" | Tense.INFINITIVE      | "akihwisdi"
        "SG2" | "" | Tense.PRESENT         | "hihwisga"
        "SG2" | "" | Tense.HABITUAL        | "hihwisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahwisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwisvi"
        "SG2" | "" | Tense.INFINITIVE      | "jahwisdi"
        "SG3" | "" | Tense.PRESENT         | "ahwisga"
        "SG3" | "" | Tense.HABITUAL        | "ahwisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhwisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "awisvi"
        "SG3" | "" | Tense.INFINITIVE      | "uhwisdi"
        "PL3" | "" | Tense.PRESENT         | "anihwisga"
        "PL3" | "" | Tense.HABITUAL        | "anihwisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihwisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwisvi"
        "PL3" | "" | Tense.INFINITIVE      | "unihwisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idihwisga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idihwisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igihwisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiwisvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igihwisdi"
    }
}
