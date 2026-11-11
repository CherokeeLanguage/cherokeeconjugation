package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KanegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Answering / Speaking",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinega', habitual: 'jinegoi', remote_past: 'akinejvi', imperative: 'jinegi', infinitive: 'akihnesdi'],
            [subject: 'SG2', object: '', present: 'hinega', habitual: 'hinegoi', remote_past: 'jahnejvi', imperative: 'hihnegi', infinitive: 'jahnesdi'],
            [subject: 'SG3', object: '', present: 'kanega', habitual: 'kanegoi', remote_past: 'uhnejvi', imperative: 'kanegi', infinitive: 'uhnesdi'],
            [subject: 'PL3', object: '', present: 'aninega', habitual: 'aninegoi', remote_past: 'unihnejvi', imperative: 'aninegi', infinitive: 'unihnesdi'],
            [subject: 'PL1INCL', object: '', present: 'idinega', habitual: 'idinegoi', remote_past: 'igihnejvi', imperative: 'idinegi', infinitive: 'igihnesdi']
        ]
    ]

    @Unroll
    def "conjugating Kanega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kanega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinega"
        "SG1" | "" | Tense.HABITUAL        | "jinegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akinejvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinegi"
        "SG1" | "" | Tense.INFINITIVE      | "akihnesdi"
        "SG2" | "" | Tense.PRESENT         | "hinega"
        "SG2" | "" | Tense.HABITUAL        | "hinegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahnejvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihnegi"
        "SG2" | "" | Tense.INFINITIVE      | "jahnesdi"
        "SG3" | "" | Tense.PRESENT         | "kanega"
        "SG3" | "" | Tense.HABITUAL        | "kanegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhnejvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "kanegi"
        "SG3" | "" | Tense.INFINITIVE      | "uhnesdi"
        "PL3" | "" | Tense.PRESENT         | "aninega"
        "PL3" | "" | Tense.HABITUAL        | "aninegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihnejvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninegi"
        "PL3" | "" | Tense.INFINITIVE      | "unihnesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinega"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igihnejvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinegi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igihnesdi"
    }
}
