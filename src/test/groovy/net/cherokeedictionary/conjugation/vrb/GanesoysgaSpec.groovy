package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanesoysgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Hailing (It is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'ganesoysga', habitual: 'ganesoysgoi', remote_past: 'unesoysvi', imperative: 'daganesoysi', infinitive: 'unesoysdi']
        ]
    ]

    @Unroll
    def "conjugating Ganesoysga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganesoysga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "ganesoysga"
        "SG1" | "" | Tense.HABITUAL        | "ganesoysgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "unesoysvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "daganesoysi"
        "SG1" | "" | Tense.INFINITIVE      | "unesoysdi"
    }
}
