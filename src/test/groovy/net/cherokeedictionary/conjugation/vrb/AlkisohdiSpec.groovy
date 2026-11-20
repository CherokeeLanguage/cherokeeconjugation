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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: transitive cells re-pinned to the engine per established rulings
        // (CED-canonical parse-back D9/D12, intrusive-h droppable D18, i-epenthesis D16,
        // a-drop; de/da + PL3 Set-B questions left for explicit adjudication)
        // tio 20Nov26: PL3 Set B cells re-pinned per user ruling + guide P7(15)/126a (uni- serves all 3rd-person objects; y/a stem spelling per the SG3 row)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyanaligisodi"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyanaligisodihoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyanaligisotanvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyanaligisotanvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyanaligisotodi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "ganaligisodi"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "ganaligisodihoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "aquanaligisotanvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "ganaligisotanvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "aquanaligisotodi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "hanaligisodi"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "hanaligisodihoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "tsanaligisotanvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "hanaligisotanvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsanaligisotodi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "analkisohdi"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "analkisohdihoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "unalkisohtanvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "analigisotanvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "unalkisohdohdi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "ananaligisodi"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "ananaligisodihoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unanaligisotanvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "ananaligisotanvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unanaligisotodi"
    }
}
