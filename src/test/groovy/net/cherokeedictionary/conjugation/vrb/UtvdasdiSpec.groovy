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
            [subject: 'SG1', object: 'SG3AN', present: 'jiyatvdasdi', habitual: 'jiyatvdasdoi', remote_past: 'jiyatvdastanvi', imperative: 'gatvdasda', infinitive: '/jiyatvdasda'],
            [subject: 'SG1', object: 'SG3IN', present: 'aktvdasdi', habitual: 'aktvdasdoi', remote_past: 'aktvdastanvi', imperative: 'agwatvdasdesdi', infinitive: 'aktvdasdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyatvdasdi', habitual: 'hiyatvdasdoi', remote_past: 'hiyatvdastanvi', imperative: 'hatvdasda', infinitive: '/'],
            [subject: 'SG2', object: 'SG3IN', present: 'tstvdasdi', habitual: 'tstvdasdoi', remote_past: 'tstvdastanvi', imperative: 'tstvdasdesdi', infinitive: 'tstvdasdohdi'],
            [subject: 'SG3', object: 'SG3IN', present: 'utvdasdi', habitual: 'utvdasdoi', remote_past: 'utvdastanvi', imperative: 'utvdasdesdi', infinitive: 'utvdasdohdi'],
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
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyatvdasdi"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyatvdasdoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyatvdastanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "gatvdasda"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "/jiyatvdasda"
        "SG1" | "SG3IN" | Tense.PRESENT         | "aktvdasdi"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "aktvdasdoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aktvdastanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "agwatvdasdesdi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "aktvdasdohdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyatvdasdi"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyatvdasdoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyatvdastanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hatvdasda"
        // "SG2" | "SG3AN" | Tense.INFINITIVE      | "/"
        "SG2" | "SG3IN" | Tense.PRESENT         | "tstvdasdi"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "tstvdasdoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tstvdastanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "tstvdasdesdi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tstvdasdohdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "utvdasdi"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "utvdasdoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "utvdastanvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "utvdasdesdi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "utvdasdohdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "untvdasdi"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "untvdasdoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "untvdastanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "untvdasdesdi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unvtvdasdohdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "iktvdasdi"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "iktvdasdoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "iktvdastan"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "vi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "iktvdasdesdi"
    }
}
