package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AtiyohihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Arguing (59)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadiyohiha', habitual: 'gadiyohihoi', remote_past: 'agwatiyohlvi', imperative: 'gadiyoga', infinitive: 'agwatiyosdi'],
            [subject: 'SG2', object: '', present: 'hatiyohiha', habitual: 'hatiyohihoi', remote_past: 'jatiyohlvi', imperative: 'hatiyoga', infinitive: 'jatiyosdi'],
            [subject: 'SG3', object: '', present: 'atiyohiha', habitual: 'atiyohihoi', remote_past: 'utiyohlvi', imperative: 'atiyoga', infinitive: 'utiyosdi'],
            [subject: 'PL3', object: '', present: 'anatiyohiha', habitual: 'anatiyohihoi', remote_past: 'unatiyohlvi', imperative: 'anatiyoga', infinitive: 'unatiyosdi'],
            [subject: 'PL1INCL', object: '', present: 'idatiyohiha', habitual: 'idatiyohihoi', remote_past: 'igatiyohlvi', imperative: 'idatiyoga', infinitive: 'igatiyosdi']
        ]
    ]

    @Unroll
    def "conjugating Atiyohiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Atiyohiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadiyohiha"
        "SG1" | "" | Tense.HABITUAL        | "gadiyohihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwatiyohlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadiyoga"
        "SG1" | "" | Tense.INFINITIVE      | "agwatiyosdi"
        "SG2" | "" | Tense.PRESENT         | "hatiyohiha"
        "SG2" | "" | Tense.HABITUAL        | "hatiyohihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jatiyohlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatiyoga"
        "SG2" | "" | Tense.INFINITIVE      | "jatiyosdi"
        "SG3" | "" | Tense.PRESENT         | "atiyohiha"
        "SG3" | "" | Tense.HABITUAL        | "atiyohihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utiyohlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atiyoga"
        "SG3" | "" | Tense.INFINITIVE      | "utiyosdi"
        "PL3" | "" | Tense.PRESENT         | "anatiyohiha"
        "PL3" | "" | Tense.HABITUAL        | "anatiyohihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unatiyohlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatiyoga"
        "PL3" | "" | Tense.INFINITIVE      | "unatiyosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idatiyohiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idatiyohihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igatiyohlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatiyoga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igatiyosdi"
    }
}
