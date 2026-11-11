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
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jilinohehdi"
        "SG1" | "" | Tense.HABITUAL        | "jilinohehdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jilinohehtanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jilinohehda"
        "SG1" | "" | Tense.INFINITIVE      | "jilinohehdohdi"
        "SG2" | "" | Tense.PRESENT         | "hilinohehdi"
        "SG2" | "" | Tense.HABITUAL        | "hilinohehdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hilinohetanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hilinohehda"
        "SG2" | "" | Tense.INFINITIVE      | "hilinohehdohdi"
        "SG3" | "" | Tense.PRESENT         | "ahlinohehdi"
        "SG3" | "" | Tense.HABITUAL        | "ahlinohehdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhlinohetanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahlinohehda"
        "SG3" | "" | Tense.INFINITIVE      | "uhlinohehdohdi"
        "PL3" | "" | Tense.PRESENT         | "anahlinohehdi"
        "PL3" | "" | Tense.HABITUAL        | "anahlinohehdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unahlinohetanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anahlinohehda"
        "PL3" | "" | Tense.INFINITIVE      | "unahlinohehdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "edahlinohehdi"
        "PL1INCL" | "" | Tense.HABITUAL        | "edahlinohehdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "edahlinohetanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "edahlinohehda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "edahlinohehdohdi"
    }
}
