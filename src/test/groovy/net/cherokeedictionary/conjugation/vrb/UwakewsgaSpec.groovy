package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UwakewsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Forget",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyvkewsga', habitual: 'jiyvkewsgoi', remote_past: 'jiyvkewsvi', imperative: 'jiyvkewa', infinitive: 'jiyvkehwisdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'agwvkewsga', habitual: 'agwvkewsgoi', remote_past: 'agwvkewsvi', imperative: 'agwvkewa', infinitive: 'agwvkehwisdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'jvkewsga', habitual: 'jvkewsgoi', remote_past: 'jvkewsvi', imperative: 'wijvkewa', infinitive: 'jvkehwisdi'],
            [subject: 'SG3', object: 'SG3IN', present: 'uwakewsga', habitual: 'uwakewsgoi', remote_past: 'uwakewsvi', imperative: 'wuwakewa', infinitive: 'uwakehwisdi'],
            [subject: 'PL3', object: 'SG3IN', present: 'unvkewsga', habitual: 'unvkewsgoi', remote_past: 'unvkewsvi', imperative: 'wunvkewa', infinitive: 'unvkehwisdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'igvkewsga', habitual: 'igvkewsgoi', remote_past: 'igvkewsvi', imperative: 'wigvkewa', infinitive: 'igvkehwisdi']
        ]
    ]

    @Unroll
    def "conjugating Uwakewsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uwakewsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyvkewsga"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyvkewsgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyvkewsvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyvkewa"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyvkehwisdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "agwvkewsga"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "agwvkewsgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwvkewsvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "agwvkewa"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwvkehwisdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "jvkewsga"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "jvkewsgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jvkewsvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "wijvkewa"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "jvkehwisdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "uwakewsga"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "uwakewsgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "uwakewsvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "wuwakewa"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "uwakehwisdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "unvkewsga"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "unvkewsgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unvkewsvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "wunvkewa"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unvkehwisdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "igvkewsga"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "igvkewsgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igvkewsvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "wigvkewa"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igvkehwisdi"
    }
}
