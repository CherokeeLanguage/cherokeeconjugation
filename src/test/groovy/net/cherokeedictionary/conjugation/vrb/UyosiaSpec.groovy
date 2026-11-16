package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UyosiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Hungry",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agiyosia', habitual: 'agiyosisgoi', remote_past: 'agiyosisgvi', imperative: 'agiyosihesdi', infinitive: 'agiyosisohdi'],
            [subject: 'SG2', object: '', present: 'jayosia', habitual: 'jayosisgoi', remote_past: 'jayosisgvi', imperative: 'jayosihesdi', infinitive: 'jayosisohdi'],
            [subject: 'SG3', object: '', present: 'uyosia', habitual: 'uyosisgoi', remote_past: 'uyosisgvi', imperative: 'uyosihesdi', infinitive: 'uyosisohdi'],
            [subject: 'PL3', object: '', present: 'duniyosia', habitual: 'duniyosisgoi', remote_past: 'duniyosisgvi', imperative: 'duniyosihesdi', infinitive: 'juniyosisohdi'],
            [subject: 'PL1INCL', object: '', present: 'degiyosia', habitual: 'degiyosisgoi', remote_past: 'degiyosisgvi', imperative: 'degiyosihesdi', infinitive: 'digiyosisohdi']
        ]
    ]

    @Unroll
    def "conjugating Uyosia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uyosia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agiyosia"
        "SG1" | "" | Tense.HABITUAL        | "agiyosisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiyosisgvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agiyosisgvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiyosisodi"
        "SG2" | "" | Tense.PRESENT         | "tsayosia"
        "SG2" | "" | Tense.HABITUAL        | "tsayosisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsayosisgvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsayosisgvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsayosisodi"
        "SG3" | "" | Tense.PRESENT         | "uyosia"
        "SG3" | "" | Tense.HABITUAL        | "uyosisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyosisgvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uyosisgvi"
        "SG3" | "" | Tense.INFINITIVE      | "uyosisodi"
        "PL3" | "" | Tense.PRESENT         | "uniyosia"
        "PL3" | "" | Tense.HABITUAL        | "uniyosisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyosisgvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uniyosisgvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyosisodi"
        "PL1INCL" | "" | Tense.PRESENT         | "igiyosia"
        "PL1INCL" | "" | Tense.HABITUAL        | "igiyosisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiyosisgvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igiyosisgvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiyosisodi"
    }
}
