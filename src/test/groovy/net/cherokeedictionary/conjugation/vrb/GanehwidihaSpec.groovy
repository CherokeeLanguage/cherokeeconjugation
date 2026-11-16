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
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinewidiha"
        "SG1" | "" | Tense.HABITUAL        | "tsinewidisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginewidvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinewidvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginewitidi"
        "SG2" | "" | Tense.PRESENT         | "hinewidiha"
        "SG2" | "" | Tense.HABITUAL        | "hinewidisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanewidvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinewidvhvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanewitidi"
        "SG1" | "" | Tense.PRESENT         | "tsinewidiha"
        "SG1" | "" | Tense.HABITUAL        | "tsinewidisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginewidvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinewidvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginewitidi"
        "PL3" | "" | Tense.PRESENT         | "aninewidiha"
        "PL3" | "" | Tense.HABITUAL        | "aninewidisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninewidvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninewidvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninewitidi"
    }
}
