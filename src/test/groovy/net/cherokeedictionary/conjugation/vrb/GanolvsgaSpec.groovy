package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanolvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Windy (It is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'ganolvsga', habitual: 'ganolvsgoi', remote_past: 'ganolvsgvi', imperative: 'ganolvsgesdi', infinitive: 'unolvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ganolvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganolvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "ganolvsga"
        "SG1" | "" | Tense.HABITUAL        | "ganolvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "ganolvsgvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganolvsgesdi"
        "SG1" | "" | Tense.INFINITIVE      | "unolvsdi"
    }
}
