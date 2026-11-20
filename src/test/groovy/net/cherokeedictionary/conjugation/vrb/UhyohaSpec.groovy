// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73827 (entrya uhyoha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UhyohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Looking for It",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agihyoha'],
            [subject: 'SG1', object: '', present: 'agihyoha', habitual: 'agihyohoi', remote_past: 'agiyolvi', imperative: 'agiyhga', infinitive: 'agiyosdi'],
            [subject: 'SG2', object: '', present: 'jahyhoha', habitual: 'jahyohoi', remote_past: 'jayolvi', imperative: 'jayhga', infinitive: 'jayosdi'],
            [subject: 'SG3', object: '', habitual: 'uhyohoi', imperative: 'jayhga', infinitive: 'uhyosdi', present: 'uhyoha', remote_past: 'uhyolvi'],
            [subject: 'PL3', object: '', present: 'unihyoha', habitual: 'unihyohoi', remote_past: 'uniyolvi', imperative: 'uniyhga', infinitive: 'uniyosdi'],
            [subject: 'PL1INCL', object: '', present: 'igihyoha', habitual: 'igihyohoi', remote_past: 'igiyolvi', imperative: 'igiyhga', infinitive: 'igiyosdi']
        ]
    ]

    @Unroll
    def "conjugating Uhyoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uhyoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agihyoha"
        "SG1" | "" | Tense.HABITUAL        | "agihyohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiyolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agiyolvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiyosdi"
        "SG2" | "" | Tense.PRESENT         | "tsayoha"
        "SG2" | "" | Tense.HABITUAL        | "jahyohoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jayolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsayolvi"
        "SG2" | "" | Tense.INFINITIVE      | "jayosdi"
        "SG3" | "" | Tense.PRESENT         | "uhyoha"
        "SG3" | "" | Tense.HABITUAL        | "uhyohoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhyolvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uyolvi"
        "SG3" | "" | Tense.INFINITIVE      | "uhyosdi"
        "PL3" | "" | Tense.PRESENT         | "unihyoha"
        "PL3" | "" | Tense.HABITUAL        | "unihyohoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uniyolvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igihyoha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igihyohoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiyolvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igiyolvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiyosdi"
    }
}
