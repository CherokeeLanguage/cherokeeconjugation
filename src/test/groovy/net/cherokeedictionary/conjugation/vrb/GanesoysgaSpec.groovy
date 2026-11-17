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
            [subject: 'SG3', object: '', present: 'ganesoysga', habitual: 'ganesoysgoi', remote_past: 'unesoysvi', imperative: 'daganesoysi', infinitive: 'unesoysdi']
        ]
    ]

    @Unroll
    def "conjugating Ganesoysga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganesoysga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "ganesoysga"
        "SG3" | "" | Tense.HABITUAL        | "ganesoysgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unesoysvi"
        // "SG3" | "" | Tense.FUTURE_COMMAND      | "unesoysvi"  // unattested -- the 2012 book (p.78) has no imperative column for weather verbs
        "SG3" | "" | Tense.INFINITIVE      | "unesoysdi"
    }
}
