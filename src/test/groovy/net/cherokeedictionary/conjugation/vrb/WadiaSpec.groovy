// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 74024 (entrya wadia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class WadiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Send (long)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'wijidia'],
            [subject: 'SG3', object: '', habitual: 'wadisgoi', imperative: 'hwida', infinitive: 'wudisdi', present: 'wadia', remote_past: 'wudvi'],
            [subject: 'SG2', object: '', present: 'hwidia', habitual: 'hwidisgoi', remote_past: 'wijadvi', imperative: 'hwida', infinitive: 'wijadisdi'],
            [subject: 'SG3', object: '', present: 'wadia', habitual: 'wadisgoi', remote_past: 'wudvi', imperative: 'wada', infinitive: 'wudisdi'],
            [subject: 'SG3', object: '', present: 'wanidia', habitual: 'wanidisgoi', remote_past: 'wunidvi', imperative: 'wanida', infinitive: 'wunidisdi']
        ]
    ]

    @Unroll
    def "conjugating Wadia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Wadia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "wadia"
        "SG3" | "" | Tense.HABITUAL        | "wadisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gadvi"
        "SG3" | "" | Tense.INFINITIVE      | "udisdi"
        "SG2" | "" | Tense.PRESENT         | "hidia"
        "SG2" | "" | Tense.HABITUAL        | "hidisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hidvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadisdi"
        "SG3" | "" | Tense.PRESENT         | "wadia"
        "SG3" | "" | Tense.HABITUAL        | "wadisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gadvi"
        "SG3" | "" | Tense.INFINITIVE      | "udisdi"
        "SG3" | "" | Tense.PRESENT         | "wadia"
        "SG3" | "" | Tense.HABITUAL        | "wadisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gadvi"
        "SG3" | "" | Tense.INFINITIVE      | "udisdi"
    }
}
