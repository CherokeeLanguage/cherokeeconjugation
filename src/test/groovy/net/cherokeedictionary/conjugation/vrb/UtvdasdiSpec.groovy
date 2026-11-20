// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73960) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'tsiyadvdasdi, aquadvdasdi'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyatvdasdi', habitual: 'jiyatvdasdoi', remote_past: 'jiyatvdastanvi', imperative: 'gatvdasda', infinitive: "jiyatvdasdohdi"],
            [subject: 'SG1', object: 'SG3IN', present: 'aktvdasdi', habitual: 'aktvdasdoi', remote_past: 'aktvdastanvi', imperative: 'agwatvdasdesdi', infinitive: 'aktvdasdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyatvdasdi', habitual: 'hiyatvdasdoi', remote_past: 'hiyatvdastanvi', imperative: 'hatvdasda', infinitive: '/'],
            [subject: 'SG2', object: 'SG3IN', present: 'tstvdasdi', habitual: 'tstvdasdoi', remote_past: 'tstvdastanvi', imperative: 'tstvdasdesdi', infinitive: 'tstvdasdohdi'],
            [subject: 'SG3', object: '', habitual: 'udvdasdoi', imperative: 'hiyadvdasdesdi, tsadvdasdesdi', infinitive: 'udvdasdodi', present: 'udvdasdi', remote_past: 'udvdasdvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'untvdasdi', habitual: 'untvdasdoi', remote_past: 'untvdastanvi', imperative: 'untvdasdesdi', infinitive: 'unvtvdasdohdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'iktvdasdi', habitual: 'iktvdasdoi', remote_past: 'iktvdastan', imperative: 'vi', infinitive: 'iktvdasdesdi']
        ]
    ]

    @Unroll
    def "conjugating Utvdasdi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Utvdasdi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyatvdasdi"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyatvdasdoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyatvdastanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyadvdasdvi"
        // tio 17Nov26: infinitive supplied from the 2012 book p.5 (jiyatvdasdohdi) -- the yaml carried a "/"-prefixed junk value.
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyatvdasdohdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "aktvdasdi"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "aktvdasdoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aktvdastanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "aquadvdasdvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "aktvdasdohdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyatvdasdi"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyatvdasdoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyatvdastanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "advdasdvi"
        // "SG2" | "SG3AN" | Tense.INFINITIVE      | "/"
        "SG2" | "SG3IN" | Tense.PRESENT         | "tstvdasdi"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "tstvdasdoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tstvdastanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "tsadvdasdvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tstvdasdohdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "udvdasdi"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "udvdasdoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "udvdasdvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "udvdasdvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "udvdasdodi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "untvdasdi"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "untvdasdoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "untvdastanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "unadvdasdvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unvtvdasdohdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "iktvdasdi"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "iktvdasdoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "iktvdastan"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "igadvdasdvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "iktvdasdesdi"
    }
}
