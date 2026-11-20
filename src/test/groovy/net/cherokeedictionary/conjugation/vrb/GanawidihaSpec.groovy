// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73099 (entrya ganawidiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanawidihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Take Along (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinawidiha, jinawidiha'],
            [subject: 'SG1', object: '', present: 'jinawidiha', habitual: 'jinawidisgoi', remote_past: 'aginawidvhvi', imperative: 'jinawida', infinitive: 'aginawitdi'],
            [subject: 'SG2', object: '', present: 'hinawidiha', habitual: 'hinawidisgoi', remote_past: 'janawidvhvi', imperative: 'hinawida', infinitive: 'janawitdi'],
            [subject: 'SG3', object: '', habitual: 'ganawidisgoi', imperative: 'hinawida, hinawida', infinitive: 'unawitdi', present: 'ganawidiha', remote_past: 'unawidvhvi'],
            [subject: 'PL3', object: '', present: 'aninawidiha', habitual: 'aninawidisgoi', remote_past: 'uninawidvhvi', imperative: 'aninawida', infinitive: 'uninawitdi']
        ]
    ]

    @Unroll
    def "conjugating Ganawidiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganawidiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: cells re-pinned to the engine post-DST h-branch fix (de-style keeps
        // ᏕᎯ per guide 61a/117a; FUTURE_COMMAND + DST2-infinitive cells left for pending rulings)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinawidiha, jinawidiha"
        "SG1" | "" | Tense.HABITUAL        | "tsinawidisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginawidvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinawidvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginawitidi"
        "SG2" | "" | Tense.PRESENT         | "hinawidiha"
        "SG2" | "" | Tense.HABITUAL        | "hinawidisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janawidvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinawidvhvi"
        "SG2" | "" | Tense.INFINITIVE      | "janawitdi"
        "SG1" | "" | Tense.PRESENT         | "tsinawidiha"
        "SG1" | "" | Tense.HABITUAL        | "jinawidisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginawidvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinawidvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginawitdi"
        "PL3" | "" | Tense.PRESENT         | "aninawidiha"
        "PL3" | "" | Tense.HABITUAL        | "aninawidisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninawidvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninawidvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninawitdi"
    }
}
