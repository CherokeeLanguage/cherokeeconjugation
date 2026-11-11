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
            [subject: 'SG1', object: 'SG3AN', present: 'jiyagasesdi', habitual: 'jiyagasesdoi', remote_past: 'jiyagasesdvi', imperative: 'jiyagasesdesdi', infinitive: 'jiyagasesdohdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'agwaksesdi', habitual: 'agwaksesdoi', remote_past: 'agwaksesdvi', imperative: 'agwaksesdesdi', infinitive: 'agwaksesdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyagasesdi', habitual: 'hiyagasesdoi', remote_past: 'hiyagasesdvi', imperative: 'hiyagasesdesdi', infinitive: 'hiyagasesdohdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'jaksesdi', habitual: 'jaksesdoi', remote_past: 'jaksesdvi', imperative: 'jaksesdesdi', infinitive: 'jaksesdohdi'],
            [subject: 'SG3', object: 'SG3IN', present: 'uksesdi', habitual: 'uksesdoi', remote_past: 'uksesdvi', imperative: 'uksesdesdi', infinitive: 'uksesdohdi'],
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
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyagasesdi"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyagasesdoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyagasesdvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyagasesdesdi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyagasesdohdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "agwaksesdi"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "agwaksesdoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwaksesdvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "agwaksesdesdi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwaksesdohdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyagasesdi"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyagasesdoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyagasesdvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyagasesdesdi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyagasesdohdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "jaksesdi"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "jaksesdoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jaksesdvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "jaksesdesdi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jaksesdohdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "uksesdi"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "uksesdoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "uksesdvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "uksesdesdi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "uksesdohdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "unaksesdi"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "unaksesdoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unaksesdvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "unaksesdesdi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unaksesdohdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "igaksesdi"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "igaksesdoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igaksesdvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "igaksesdesdi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igaksesdohdi"
    }
}
