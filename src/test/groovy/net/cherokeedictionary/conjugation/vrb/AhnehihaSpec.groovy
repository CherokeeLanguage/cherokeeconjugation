package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhnehihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Wrestling",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gahnehiha', habitual: 'gahnehihoi', remote_past: 'agwahnehlvi', imperative: 'gahnega', infinitive: 'agwahnesdi'],
            [subject: 'SG2', object: '', present: 'hahnehiha', habitual: 'hahnehihoi', remote_past: 'jahnehlvi', imperative: 'hahnega', infinitive: 'jahnesdi'],
            [subject: 'SG3', object: '', present: 'ahnehiha', habitual: 'ahnehihoi', remote_past: 'uhnehlvi', imperative: 'ahnega', infinitive: 'uhnesdi'],
            [subject: 'PL3', object: '', present: 'anahnehiha', habitual: 'anahnehihoi', remote_past: 'unahnehlvi', imperative: 'anahnega', infinitive: 'unahnesdi'],
            [subject: 'PL1INCL', object: '', present: 'idahnehiha', habitual: 'idahnehihoi', remote_past: 'igahnehlvi', imperative: 'idahnega', infinitive: 'igahnesdi']
        ]
    ]

    @Unroll
    def "conjugating Ahnehiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahnehiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gahnehiha"
        "SG1" | "" | Tense.HABITUAL        | "gahnehihoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwahnehlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gahnega"
        "SG1" | "" | Tense.INFINITIVE      | "agwahnesdi"
        "SG2" | "" | Tense.PRESENT         | "hahnehiha"
        "SG2" | "" | Tense.HABITUAL        | "hahnehihoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahnehlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hahnega"
        "SG2" | "" | Tense.INFINITIVE      | "jahnesdi"
        "SG3" | "" | Tense.PRESENT         | "ahnehiha"
        "SG3" | "" | Tense.HABITUAL        | "ahnehihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhnehlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahnega"
        "SG3" | "" | Tense.INFINITIVE      | "uhnesdi"
        "PL3" | "" | Tense.PRESENT         | "anahnehiha"
        "PL3" | "" | Tense.HABITUAL        | "anahnehihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unahnehlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anahnega"
        "PL3" | "" | Tense.INFINITIVE      | "unahnesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idahnehiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idahnehihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igahnehlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idahnega"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igahnesdi"
    }
}
