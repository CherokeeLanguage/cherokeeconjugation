// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73858 (entrya uksesdi) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UksesdiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Watching / Careful (171)",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyagasesdi, agwaksesdi'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyagasesdi', habitual: 'jiyagasesdoi', remote_past: 'jiyagasesdvi', imperative: 'jiyagasesdesdi', infinitive: 'jiyagasesdohdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'agwaksesdi', habitual: 'agwaksesdoi', remote_past: 'agwaksesdvi', imperative: 'agwaksesdesdi', infinitive: 'agwaksesdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyagasesdi', habitual: 'hiyagasesdoi', remote_past: 'hiyagasesdvi', imperative: 'hiyagasesdesdi', infinitive: 'hiyagasesdohdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'jaksesdi', habitual: 'jaksesdoi', remote_past: 'jaksesdvi', imperative: 'jaksesdesdi', infinitive: 'jaksesdohdi'],
            [subject: 'SG3', object: '', habitual: 'uksesdoi', imperative: 'hiyagasesdesdi, jaksesdesdi', infinitive: 'uksesdohdi', present: 'uksesdi', remote_past: 'uksesdvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'unaksesdi', habitual: 'unaksesdoi', remote_past: 'unaksesdvi', imperative: 'unaksesdesdi', infinitive: 'unaksesdohdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'igaksesdi', habitual: 'igaksesdoi', remote_past: 'igaksesdvi', imperative: 'igaksesdesdi', infinitive: 'igaksesdohdi']
        ]
    ]

    @Unroll
    def "conjugating Uksesdi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uksesdi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyagisesdi"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyagisesdoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyagisesdvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyagisesdvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyagisesdodi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "aquagisesdi"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "aquagisesdoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aquagisesdvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "aquagisesdvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "aquagisesdodi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "agisesdi"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "agisesdoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "agisesdvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "agisesdvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "agisesdodi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "tsagisesdi"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "tsagisesdoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tsagisesdvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "tsagisesdvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsagisesdodi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "ugisesdi"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "ugisesdoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "ugisesdvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "ugisesdvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "ugisesdodi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "unagisesdi"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "unagisesdoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unagisesdvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "unagisesdvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unagisesdodi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "igagisesdi"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "igagisesdoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igagisesdvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "igagisesdvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igagisesdodi"
    }
}
