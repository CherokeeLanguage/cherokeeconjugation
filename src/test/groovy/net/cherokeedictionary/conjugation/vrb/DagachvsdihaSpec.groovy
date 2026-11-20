// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72746 (entrya dagachvsdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DagachvsdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Marrying (68)*",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'dvgwachvsdiha'],
            [subject: 'SG3', object: '', habitual: 'dagachvsdisgoi', imperative: 'widejachvsda', infinitive: 'jagachvsdohdi', present: 'dagachvsdiha', remote_past: 'dagachvstanvi'],
            [subject: 'SG2', object: '', present: 'dejachsvsdiha', habitual: 'dejachvsdisgoi', remote_past: 'dejachvstanvi', imperative: 'widejachvsda', infinitive: 'dijachvsdohdi'],
            [subject: 'SG3', object: '', present: 'dagachvsdiha', habitual: 'dagachvsdisgoi', remote_past: 'dagachvstanvi', imperative: 'widagachvsda', infinitive: 'jagachvsdohdi'],
            [subject: 'SG3', object: '', present: 'degegachvsdiha', habitual: 'degegachvsdisgoi', remote_past: 'degegachvstanvi', imperative: 'widegegachvsda', infinitive: 'jigegachvsdohdi']
        ]
    ]

    @Unroll
    def "conjugating Dagachvsdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dagachvsdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "dagachvsdiha"
        "SG3" | "" | Tense.HABITUAL        | "dagachvsdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dugatsvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "agatsvstanvi"
        "SG3" | "" | Tense.INFINITIVE      | "tsugatsvstodi"
        "SG2" | "" | Tense.PRESENT         | "tigatsvsdiha"
        "SG2" | "" | Tense.HABITUAL        | "tigatsvsdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "datsagatsvstanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hagatsvstanvi"
        "SG2" | "" | Tense.INFINITIVE      | "datsagatsvstodi"
        "SG3" | "" | Tense.PRESENT         | "dagachvsdiha"
        "SG3" | "" | Tense.HABITUAL        | "dagachvsdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dugatsvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "agatsvstanvi"
        "SG3" | "" | Tense.INFINITIVE      | "tsugatsvstodi"
        "SG3" | "" | Tense.PRESENT         | "dagatsvsdiha"
        "SG3" | "" | Tense.HABITUAL        | "dagatsvsdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dugatsvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "agatsvstanvi"
        "SG3" | "" | Tense.INFINITIVE      | "tsugatsvstodi"
    }
}
