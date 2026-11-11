package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GawohiliyvaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Answering, Replying",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gawoiliyva', habitual: 'gawoiliyvsgoi', remote_past: 'agwawohiliyvsvi', imperative: 'gawohiliyvna', infinitive: 'agwohiliyvsdi'],
            [subject: 'SG2', object: '', present: 'hawohiliyva', habitual: 'hawohiliyvsgoi', remote_past: 'jawohiliyvsvi', imperative: 'hawohiliyvna', infinitive: 'johiliyvsdi'],
            [subject: 'SG3', object: '', present: 'gawohiliyva', habitual: 'gawohiliyvsgoi', remote_past: 'uwohiliyvsvi', imperative: 'awohiliyvna', infinitive: 'uwohiliyvsdi'],
            [subject: 'PL3', object: '', present: 'anawohiliyva', habitual: 'anawohiliyvsgoi', remote_past: 'unawohiliyvsvi', imperative: 'anawohiliyvna', infinitive: 'unohiliyvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idawohiliyva', habitual: 'idawohiliyvsgoi', remote_past: 'igawohiliyvsvi', imperative: 'idawohiliyvna', infinitive: 'igohiliyvsdi']
        ]
    ]

    @Unroll
    def "conjugating Gawohiliyva (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gawohiliyva", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gawoiliyva"
        "SG1" | "" | Tense.HABITUAL        | "gawoiliyvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwawohiliyvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gawohiliyvna"
        "SG1" | "" | Tense.INFINITIVE      | "agwohiliyvsdi"
        "SG2" | "" | Tense.PRESENT         | "hawohiliyva"
        "SG2" | "" | Tense.HABITUAL        | "hawohiliyvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jawohiliyvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hawohiliyvna"
        "SG2" | "" | Tense.INFINITIVE      | "johiliyvsdi"
        "SG3" | "" | Tense.PRESENT         | "gawohiliyva"
        "SG3" | "" | Tense.HABITUAL        | "gawohiliyvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwohiliyvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "awohiliyvna"
        "SG3" | "" | Tense.INFINITIVE      | "uwohiliyvsdi"
        "PL3" | "" | Tense.PRESENT         | "anawohiliyva"
        "PL3" | "" | Tense.HABITUAL        | "anawohiliyvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unawohiliyvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anawohiliyvna"
        "PL3" | "" | Tense.INFINITIVE      | "unohiliyvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idawohiliyva"
        "PL1INCL" | "" | Tense.HABITUAL        | "idawohiliyvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igawohiliyvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idawohiliyvna"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igohiliyvsdi"
    }
}
