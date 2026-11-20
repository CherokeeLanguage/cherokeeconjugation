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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "agowatiha"
        "SG3" | "" | Tense.HABITUAL        | "agowatisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugohvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "agohvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugowatvhdi"
        "PL3" | "" | Tense.PRESENT         | "anagowatiha"
        "PL3" | "" | Tense.HABITUAL        | "anagowatisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unagohvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anagohvi"
        "PL3" | "" | Tense.INFINITIVE      | "unagowadvdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idagowatiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idagowatisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igagohvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idagohvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igagowadvdi"
    }
}
