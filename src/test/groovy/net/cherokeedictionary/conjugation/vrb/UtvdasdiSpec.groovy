// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73960 (entrya utvdasdi) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UtvdasdiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Listening",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyatvdasdi, agwatvdasdi'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyatvdasdi', habitual: 'jiyatvdasdoi', remote_past: 'jiyatvdastanvi', imperative: 'gatvdasda', infinitive: '/jiyatvdasda'],
            [subject: 'SG1', object: 'SG3IN', present: 'aktvdasdi', habitual: 'aktvdasdoi', remote_past: 'aktvdastanvi', imperative: 'agwatvdasdesdi', infinitive: 'aktvdasdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyatvdasdi', habitual: 'hiyatvdasdoi', remote_past: 'hiyatvdastanvi', imperative: 'hatvdasda', infinitive: '/'],
            [subject: 'SG2', object: 'SG3IN', present: 'tstvdasdi', habitual: 'tstvdasdoi', remote_past: 'tstvdastanvi', imperative: 'tstvdasdesdi', infinitive: 'tstvdasdohdi'],
            [subject: 'SG3', object: '', habitual: 'utvdasdoi', imperative: 'hiyatvdasdesdi, jatvdasdesdi', infinitive: 'utvdasdohdi', present: 'utvdasdi', remote_past: 'utvdasdvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'untvdasdi', habitual: 'untvdasdoi', remote_past: 'untvdastanvi', imperative: 'untvdasdesdi', infinitive: 'unvtvdasdohdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'iktvdasdi', habitual: 'iktvdasdoi', remote_past: 'iktvdastan', imperative: 'vi', infinitive: 'iktvdasdesdi']
        ]
    ]

    @Unroll
    def "conjugating Utvdasdi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Utvdasdi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyadvdasdi"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyadvdasdoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyadvdasdvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyadvdasdvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "/jiyatvdasda"
        "SG1" | "SG3IN" | Tense.PRESENT         | "aquadvdasdi"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "aquadvdasdoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aquadvdasdvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "aquadvdasdvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "aquadvdasdodi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "advdasdi"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "advdasdoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "advdasdvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "advdasdvi"
        // "SG2" | "SG3AN" | Tense.INFINITIVE      | "/"
        "SG2" | "SG3IN" | Tense.PRESENT         | "tsadvdasdi"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "tsadvdasdoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tsadvdasdvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "tsadvdasdvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsadvdasdodi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "udvdasdi"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "udvdasdoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "udvdasdvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "udvdasdvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "udvdasdodi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "unadvdasdi"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "unadvdasdoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unadvdasdvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "unadvdasdvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unadvdasdodi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "igadvdasdi"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "igadvdasdoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igadvdasdvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "igadvdasdvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igadvdasdodi"
    }
}
