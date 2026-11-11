package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlkisohdiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Practicing",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'galikisohdi', habitual: 'galikisohdihoi', remote_past: 'agwalkisohtanvi', imperative: 'galikisohda', infinitive: 'agwalkisohdohdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'halkisohdi', habitual: 'halkisohdihoi', remote_past: 'jalkisohtanvi', imperative: 'halkisohda', infinitive: 'jalkisohdohdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'alkisohdi', habitual: 'alkisohdihoi', remote_past: 'ulkisohtanvi', imperative: 'alkisohda', infinitive: 'ulkisohdohdi'],
            [subject: 'SG3', object: 'SG3IN', present: 'analkisohdi', habitual: 'analkisohdihoi', remote_past: 'unalkisohtanvi', imperative: 'analkisohda', infinitive: 'unalkisohdohdi'],
            [subject: 'PL3', object: 'SG3IN', present: 'idalkisohdi', habitual: 'idalkisohdihoi', remote_past: 'igalkisohtanvi', imperative: 'idalkisohda', infinitive: 'igalkisohdohdi']
        ]
    ]

    @Unroll
    def "conjugating Alkisohdi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alkisohdi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "galikisohdi"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "galikisohdihoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "agwalkisohtanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "galikisohda"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "agwalkisohdohdi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "halkisohdi"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "halkisohdihoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "jalkisohtanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "halkisohda"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "jalkisohdohdi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "alkisohdi"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "alkisohdihoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "ulkisohtanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "alkisohda"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "ulkisohdohdi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "analkisohdi"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "analkisohdihoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "unalkisohtanvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "analkisohda"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "unalkisohdohdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "idalkisohdi"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "idalkisohdihoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "igalkisohtanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "idalkisohda"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "igalkisohdohdi"
    }
}
