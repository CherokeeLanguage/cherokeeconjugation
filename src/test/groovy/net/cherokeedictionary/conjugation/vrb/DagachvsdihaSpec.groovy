package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DagachvsdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Marrying (68)*",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'dvgwachvsdiha', habitual: 'dvgwachvsvsdisgoi', remote_past: 'dvgwachvstanvi', imperative: 'dvgwachvsda', infinitive: 'digwachvsdohdi'],
            [subject: 'SG2', object: '', present: 'dejachsvsdiha', habitual: 'dejachvsdisgoi', remote_past: 'dejachvstanvi', imperative: 'widejachvsda', infinitive: 'dijachvsdohdi'],
            [subject: 'SG3', object: '', present: 'dagachvsdiha', habitual: 'dagachvsdisgoi', remote_past: 'dagachvstanvi', imperative: 'widagachvsda', infinitive: 'jagachvsdohdi'],
            [subject: 'SG3', object: '', present: 'degegachvsdiha', habitual: 'degegachvsdisgoi', remote_past: 'degegachvstanvi', imperative: 'widegegachvsda', infinitive: 'jigegachvsdohdi']
        ]
    ]

    @Unroll
    def "conjugating Dagachvsdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dagachvsdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "dvgwachvsdiha"
        "SG3" | "" | Tense.HABITUAL        | "dvgwachvsvsdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dvgwachvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dvgwachvsda"
        "SG3" | "" | Tense.INFINITIVE      | "digwachvsdohdi"
        "SG2" | "" | Tense.PRESENT         | "dejachsvsdiha"
        "SG2" | "" | Tense.HABITUAL        | "dejachvsdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejachvstanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "widejachvsda"
        "SG2" | "" | Tense.INFINITIVE      | "dijachvsdohdi"
        "SG3" | "" | Tense.PRESENT         | "dagachvsdiha"
        "SG3" | "" | Tense.HABITUAL        | "dagachvsdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dagachvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "widagachvsda"
        "SG3" | "" | Tense.INFINITIVE      | "jagachvsdohdi"
        "SG3" | "" | Tense.PRESENT         | "degegachvsdiha"
        "SG3" | "" | Tense.HABITUAL        | "degegachvsdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "degegachvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "widegegachvsda"
        "SG3" | "" | Tense.INFINITIVE      | "jigegachvsdohdi"
    }
}
