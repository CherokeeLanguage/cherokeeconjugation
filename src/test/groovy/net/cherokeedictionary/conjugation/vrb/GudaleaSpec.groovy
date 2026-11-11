package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GudaleaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Unhitching/Unplugging/Unhooking It",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyudalea', habitual: 'jiyudalesgoi', remote_past: 'jiyudalesvi', imperative: 'Jiyudalagi', infinitive: 'jiyudalesdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'gudalea', habitual: 'gudalesgoi', remote_past: 'agwudalesvi', imperative: 'gudalagi', infinitive: 'agwudalesdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyudalea', habitual: 'hiyudalesgoi', remote_past: 'hiyudalesvi', imperative: 'Hiyudalagi', infinitive: 'hiyudalesdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'hudalea', habitual: 'hudalesgoi', remote_past: 'judalesvi', imperative: 'hudalagi', infinitive: 'judalesdi'],
            [subject: 'SG3', object: 'SG3IN', present: 'gudalea', habitual: 'gudalesgoi', remote_past: 'uwudalesvi', imperative: 'gudalagi', infinitive: 'uwudalesdi'],
            [subject: 'PL3', object: 'SG3IN', present: 'anudalea', habitual: 'anudalesgoi', remote_past: 'unudalesvi', imperative: 'anudalagi', infinitive: 'unudalesdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'idudalea', habitual: 'idudalesgoi', remote_past: 'igudalesvi', imperative: 'idudalagi', infinitive: 'igudalesdi']
        ]
    ]

    @Unroll
    def "conjugating Gudalea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gudalea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyudalea"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyudalesgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jiyudalesvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "Jiyudalagi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "jiyudalesdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "gudalea"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "gudalesgoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agwudalesvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "gudalagi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agwudalesdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyudalea"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyudalesgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "hiyudalesvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "Hiyudalagi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "hiyudalesdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hudalea"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hudalesgoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "judalesvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hudalagi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "judalesdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "gudalea"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "gudalesgoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "uwudalesvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "gudalagi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "uwudalesdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "anudalea"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "anudalesgoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unudalesvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "anudalagi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unudalesdi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "idudalea"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "idudalesgoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igudalesvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "idudalagi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igudalesdi"
    }
}
