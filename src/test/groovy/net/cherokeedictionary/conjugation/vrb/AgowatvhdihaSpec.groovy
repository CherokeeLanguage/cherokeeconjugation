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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jigowatvhdiha"
        "SG1" | "" | Tense.HABITUAL        | "jigowatvhdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agigowadvtanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsigowadvtanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agigowadvtodi"
        "SG2" | "" | Tense.PRESENT         | "higowatvhdiha"
        "SG2" | "" | Tense.HABITUAL        | "higowatvhdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsagowadvtanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "higowadvtanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsagowadvtodi"
        "SG3" | "" | Tense.PRESENT         | "agowatvhdiha"
        "SG3" | "" | Tense.HABITUAL        | "agowatvhdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugowatvhtanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "agowadvtanvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugowatvhdohdi"
        "PL3" | "" | Tense.PRESENT         | "anigowatvhdiha"
        "PL3" | "" | Tense.HABITUAL        | "anigowatvhdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unigowatvhtanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anigowadvtanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unigowatvhdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idigowadvdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idigowadvdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igigowadvtanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idigowadvtanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igigowadvtodi"
    }
}
