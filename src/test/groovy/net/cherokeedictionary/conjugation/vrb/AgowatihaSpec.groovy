package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AgowatihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "See",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'agowatiha', habitual: 'agowatisgoi', remote_past: 'ugohvi', imperative: 'agowati', infinitive: 'ugowatvhdi'],
            [subject: 'PL3', object: '', present: 'anigowatiha', habitual: 'anigowatisgoi', remote_past: 'unigohvi', imperative: 'anigowati', infinitive: 'unigowatvhdi'],
            [subject: 'PL1INCL', object: '', present: 'idigowatiha', habitual: 'idigowatisgoi', remote_past: 'igigohvi', imperative: 'idigowati', infinitive: 'igigowatvhdi']
        ]
    ]

    @Unroll
    def "conjugating Agowatiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Agowatiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "agowatiha"
        "SG3" | "" | Tense.HABITUAL        | "agowatisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugohvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "agowati"
        "SG3" | "" | Tense.INFINITIVE      | "ugowatvhdi"
        "PL3" | "" | Tense.PRESENT         | "anigowatiha"
        "PL3" | "" | Tense.HABITUAL        | "anigowatisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unigohvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anigowati"
        "PL3" | "" | Tense.INFINITIVE      | "unigowatvhdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idigowatiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idigowatisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igigohvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idigowati"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igigowatvhdi"
    }
}
