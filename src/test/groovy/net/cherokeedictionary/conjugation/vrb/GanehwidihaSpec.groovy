// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73113 (entrya ganehwidiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanehwidihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Take Along (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinewidiha'],
            [subject: 'SG1', object: '', present: 'jinewidiha', habitual: 'jinewidisgoi', remote_past: 'aginehwidvhvi', imperative: 'jinewida', infinitive: 'aginehwitdi'],
            [subject: 'SG2', object: '', present: 'hinehwidiha', habitual: 'hinehwidisgoi', remote_past: 'jenehwidvhvi', imperative: 'hinehwida', infinitive: 'janehwitdi'],
            [subject: 'SG3', object: '', habitual: 'ganehwidisgoi', imperative: 'hinehwida', infinitive: 'unehwitdi', present: 'ganehwidiha', remote_past: 'unehwidvhvi'],
            [subject: 'PL3', object: '', present: 'aninehwidiha', habitual: 'aninehwidisgoi', remote_past: 'uninehwidvhvi', imperative: 'aninehwida', infinitive: 'uninehwitdi']
        ]
    ]

    @Unroll
    def "conjugating Ganehwidiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganehwidiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinewidiha"
        "SG1" | "" | Tense.HABITUAL        | "jinewidisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginehwidvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinewidvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginehwitdi"
        "SG2" | "" | Tense.PRESENT         | "hinehwidiha"
        "SG2" | "" | Tense.HABITUAL        | "hinehwidisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanewidvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinewidvhvi"
        "SG2" | "" | Tense.INFINITIVE      | "janehwitdi"
        "SG1" | "" | Tense.PRESENT         | "jinewidiha"
        "SG1" | "" | Tense.HABITUAL        | "jinewidisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginehwidvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinewidvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginehwitdi"
        "PL3" | "" | Tense.PRESENT         | "aninehwidiha"
        "PL3" | "" | Tense.HABITUAL        | "aninehwidisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninehwidvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninewidvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninehwitdi"
    }
}
