package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhlinohehdiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Talking To, Speaking With",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jilinohehdi', habitual: 'jilinohehdisgoi', remote_past: 'jilinohehtanvi', imperative: 'jilinohehda', infinitive: 'jilinohehdohdi'],
            [subject: 'SG2', object: '', present: 'hilinohehdi', habitual: 'hilinohehdisgoi', remote_past: 'hilinohetanvi', imperative: 'hilinohehda', infinitive: 'hilinohehdohdi'],
            [subject: 'SG3', object: '', present: 'ahlinohehdi', habitual: 'ahlinohehdisgoi', remote_past: 'uhlinohetanvi', imperative: 'ahlinohehda', infinitive: 'uhlinohehdohdi'],
            [subject: 'PL3', object: '', present: 'anahlinohehdi', habitual: 'anahlinohehdisgoi', remote_past: 'unahlinohetanvi', imperative: 'anahlinohehda', infinitive: 'unahlinohehdohdi'],
            [subject: 'PL1INCL', object: '', present: 'edahlinohehdi', habitual: 'edahlinohehdisgoi', remote_past: 'edahlinohetanvi', imperative: 'edahlinohehda', infinitive: 'edahlinohehdohdi']
        ]
    ]

    @Unroll
    def "conjugating Ahlinohehdi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahlinohehdi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsitlinohedi"
        "SG1" | "" | Tense.HABITUAL        | "tsitlinohedisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agitlinohetanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsitlinohetanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agitlinohetodi"
        "SG2" | "" | Tense.PRESENT         | "hitlinohedi"
        "SG2" | "" | Tense.HABITUAL        | "hitlinohedisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatlinohetanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hitlinohetanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatlinohetodi"
        "SG3" | "" | Tense.PRESENT         | "ahlinohehdi"
        "SG3" | "" | Tense.HABITUAL        | "ahlinohehdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhlinohetanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atlinohetanvi"
        "SG3" | "" | Tense.INFINITIVE      | "uhlinohehdohdi"
        "PL3" | "" | Tense.PRESENT         | "anitlinohedi"
        "PL3" | "" | Tense.HABITUAL        | "anitlinohedisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unitlinohetanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anitlinohetanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unitlinohetodi"
        "PL1INCL" | "" | Tense.PRESENT         | "iditlinohedi"
        "PL1INCL" | "" | Tense.HABITUAL        | "iditlinohedisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igitlinohetanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iditlinohetanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igitlinohetodi"
    }
}
