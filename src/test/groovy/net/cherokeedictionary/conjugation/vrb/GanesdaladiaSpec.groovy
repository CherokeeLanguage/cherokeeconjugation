package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanesdaladiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Freezing (It is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'ganesdaladia', habitual: 'ganesdaladisgoi', remote_past: 'unesdaladvi', imperative: 'daganesdaladi', infinitive: 'unesdaladisdi']
        ]
    ]

    @Unroll
    def "conjugating Ganesdaladia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganesdaladia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "ganesdaladia"
        "SG1" | "" | Tense.HABITUAL        | "ganesdaladisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "unesdaladvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "daganesdaladi"
        "SG1" | "" | Tense.INFINITIVE      | "unesdaladisdi"
    }
}
