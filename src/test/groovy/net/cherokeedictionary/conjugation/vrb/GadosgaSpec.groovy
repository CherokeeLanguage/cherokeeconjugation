package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GadosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Fall from Elevated Position, IT (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gadosga', habitual: 'gadosgoi', remote_past: 'udosvi', imperative: 'wigadohi', infinitive: 'udohisdi']
        ]
    ]

    @Unroll
    def "conjugating Gadosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gadosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadosga"
        "SG1" | "" | Tense.HABITUAL        | "gadosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "udosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wigadohi"
        "SG1" | "" | Tense.INFINITIVE      | "udohisdi"
    }
}
