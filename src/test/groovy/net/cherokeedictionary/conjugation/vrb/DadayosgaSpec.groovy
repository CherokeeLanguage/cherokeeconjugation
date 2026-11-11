package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DadayosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Giving Up",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'degadayosga', habitual: 'degadayosgoi', remote_past: 'dagwadayosvi', imperative: 'digadayohi', infinitive: 'digwadayohisdi'],
            [subject: 'SG2', object: '', present: 'dahadayosga', habitual: 'dehadayosgoi', remote_past: 'dejadayosvi', imperative: 'tadayohi', infinitive: 'dijadayohisdi'],
            [subject: 'SG3', object: '', present: 'dadayosga', habitual: 'dadayosgoi', remote_past: 'dudayosvi', imperative: 'didayohi', infinitive: 'judayohisdi'],
            [subject: 'PL3', object: '', present: 'danadayosga', habitual: 'danadayosgoi', remote_past: 'dunadayosvi', imperative: 'dinadayohi', infinitive: 'junadayohisdi'],
            [subject: 'PL1INCL', object: '', present: 'dedadayosga', habitual: 'dedadayosgoi', remote_past: 'degadayosvi', imperative: 'didadayohi', infinitive: 'digadayohisdi']
        ]
    ]

    @Unroll
    def "conjugating Dadayosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dadayosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degadayosga"
        "SG1" | "" | Tense.HABITUAL        | "degadayosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwadayosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "digadayohi"
        "SG1" | "" | Tense.INFINITIVE      | "digwadayohisdi"
        "SG2" | "" | Tense.PRESENT         | "dahadayosga"
        "SG2" | "" | Tense.HABITUAL        | "dehadayosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejadayosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tadayohi"
        "SG2" | "" | Tense.INFINITIVE      | "dijadayohisdi"
        "SG3" | "" | Tense.PRESENT         | "dadayosga"
        "SG3" | "" | Tense.HABITUAL        | "dadayosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dudayosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "didayohi"
        "SG3" | "" | Tense.INFINITIVE      | "judayohisdi"
        "PL3" | "" | Tense.PRESENT         | "danadayosga"
        "PL3" | "" | Tense.HABITUAL        | "danadayosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunadayosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinadayohi"
        "PL3" | "" | Tense.INFINITIVE      | "junadayohisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedadayosga"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedadayosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degadayosvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didadayohi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digadayohisdi"
    }
}
