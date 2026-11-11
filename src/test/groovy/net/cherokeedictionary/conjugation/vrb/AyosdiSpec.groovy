package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyosdiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Breaking It",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyosdiha', habitual: 'jiyosdisoi', remote_past: 'agiyosdanvi', imperative: 'jiyosda', infinitive: 'agiyosdohdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyosdiha', habitual: 'hiyosdisoi', remote_past: 'jayosdanvi', imperative: 'hiyosda', infinitive: 'jayosdohdi'],
            [subject: 'SG3', object: 'SG3AN', present: 'ayosdiha', habitual: 'ayosdihoi', remote_past: 'uyosdanvi', imperative: 'ayosda', infinitive: 'uyosdohdi'],
            [subject: 'PL3', object: 'SG3AN', present: 'aniyosdiha', habitual: 'aniyosdihoi', remote_past: 'uniyosdanvi', imperative: 'aniyosda', infinitive: 'uniyosdohdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'idiyosdiha', habitual: 'idiyosdihoi', remote_past: 'igiyosdanvi', imperative: 'idiyosda', infinitive: 'igiyosdohdi']
        ]
    ]

    @Unroll
    def "conjugating Ayosdi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayosdi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyosdiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyosdisoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "agiyosdanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyosda"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "agiyosdohdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyosdiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyosdisoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "jayosdanvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyosda"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "jayosdohdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "ayosdiha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "ayosdihoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uyosdanvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "ayosda"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uyosdohdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "aniyosdiha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "aniyosdihoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "uniyosdanvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aniyosda"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "uniyosdohdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "idiyosdiha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "idiyosdihoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "igiyosdanvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "idiyosda"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "igiyosdohdi"
    }
}
