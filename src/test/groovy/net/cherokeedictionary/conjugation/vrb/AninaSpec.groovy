package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AninaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Sitting, They Are (Congregation)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'ojina', habitual: 'ojinoi', remote_past: 'x', imperative: 'ojinesdi', infinitive: 'x']
        ]
    ]

    @Unroll
    def "conjugating Anina (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Anina", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "ojina"
        "SG3" | "" | Tense.HABITUAL        | "ojinoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "x"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ojinesdi"
        "SG3" | "" | Tense.INFINITIVE      | "x"
    }
}
