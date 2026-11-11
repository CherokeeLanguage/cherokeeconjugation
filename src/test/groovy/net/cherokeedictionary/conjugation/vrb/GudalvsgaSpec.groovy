package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GudalvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Hitching/Plugging/Hooking It Up",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyudalvsga', habitual: 'jiyudalvsgoi', remote_past: 'jiyudalvnvi', imperative: 'jiyudalvvga', infinitive: 'jiyudalvdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gudalvsga', habitual: 'gudalvsgoi', remote_past: 'agwudalvnvi', imperative: 'gudalvvga', infinitive: 'agwudalvdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyudalvsga', habitual: 'hiyudalvsgoi', remote_past: 'hiyudalvnvi', imperative: 'hiyudalvvga', infinitive: 'hiyudalvdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hudalvsga', habitual: 'hudalvsgoi', remote_past: 'judalvnvi', imperative: 'hudalvvga', infinitive: 'judalvdi'],
            [subject: 'SG3', object: 'SG3IN', present: 'gudalvsga', habitual: 'gudalvsgoi', remote_past: 'uwudalvnvi', imperative: 'gudalvvga', infinitive: 'uwudalvdi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anudalvsga', habitual: 'anudalvsgoi', remote_past: 'unudalvnvi', imperative: 'anudalvvga', infinitive: 'unudalvdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idudalvsga', habitual: 'idudalvsgoi', remote_past: 'igudalvnvi', imperative: 'idudalvvga', infinitive: 'igudalvdi']
        ]
    ]

    @Unroll
    def "conjugating Gudalvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gudalvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyudalvsga"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyudalvsgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyudalvnvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyudalvvga"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyudalvdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gudalvsga"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gudalvsgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwudalvnvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gudalvvga"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwudalvdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyudalvsga"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyudalvsgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyudalvnvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyudalvvga"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyudalvdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hudalvsga"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hudalvsgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "judalvnvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hudalvvga"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "judalvdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "gudalvsga"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "gudalvsgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "uwudalvnvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "gudalvvga"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "uwudalvdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anudalvsga"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anudalvsgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unudalvnvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anudalvvga"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unudalvdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idudalvsga"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idudalvsgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igudalvnvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idudalvvga"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igudalvdi"
    }
}
