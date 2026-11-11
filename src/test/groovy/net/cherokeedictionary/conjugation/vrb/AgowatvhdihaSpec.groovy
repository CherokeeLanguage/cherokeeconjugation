package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AgowatvhdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Showing It To Him/Her",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jigowatvhdiha', habitual: 'jigowatvhdisgoi', remote_past: 'jigowatvhtanvi', imperative: 'jigowatvhda', infinitive: 'jigowatvhdohdi'],
            [subject: 'SG2', object: '', present: 'higowatvhdiha', habitual: 'higowatvhdisgoi', remote_past: 'higowatvhtanvi', imperative: 'higowatvhda', infinitive: 'higowatvhdohdi'],
            [subject: 'SG3', object: '', present: 'agowatvhdiha', habitual: 'agowatvhdisgoi', remote_past: 'ugowatvhtanvi', imperative: 'agowatvhda', infinitive: 'ugowatvhdohdi'],
            [subject: 'PL3', object: '', present: 'anigowatvhdiha', habitual: 'anigowatvhdisgoi', remote_past: 'unigowatvhtanvi', imperative: 'anigowatvhda', infinitive: 'unigowatvhdohdi'],
            [subject: 'PL1INCL', object: '', present: 'edigowatvhdiha', habitual: 'edigowatvhdisgoi', remote_past: 'edigowatvhtanvi', imperative: 'edigowatvhda', infinitive: 'edigowatvhdohdi']
        ]
    ]

    @Unroll
    def "conjugating Agowatvhdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Agowatvhdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jigowatvhdiha"
        "SG1" | "" | Tense.HABITUAL        | "jigowatvhdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jigowatvhtanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jigowatvhda"
        "SG1" | "" | Tense.INFINITIVE      | "jigowatvhdohdi"
        "SG2" | "" | Tense.PRESENT         | "higowatvhdiha"
        "SG2" | "" | Tense.HABITUAL        | "higowatvhdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "higowatvhtanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "higowatvhda"
        "SG2" | "" | Tense.INFINITIVE      | "higowatvhdohdi"
        "SG3" | "" | Tense.PRESENT         | "agowatvhdiha"
        "SG3" | "" | Tense.HABITUAL        | "agowatvhdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugowatvhtanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "agowatvhda"
        "SG3" | "" | Tense.INFINITIVE      | "ugowatvhdohdi"
        "PL3" | "" | Tense.PRESENT         | "anigowatvhdiha"
        "PL3" | "" | Tense.HABITUAL        | "anigowatvhdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unigowatvhtanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anigowatvhda"
        "PL3" | "" | Tense.INFINITIVE      | "unigowatvhdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "edigowatvhdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "edigowatvhdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "edigowatvhtanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "edigowatvhda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "edigowatvhdohdi"
    }
}
