package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlidlihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Its Boiling (39)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'alidliha', habitual: 'alidlisgoi', remote_past: 'ulidlvhvi', imperative: 'dvlidlvhi', infinitive: 'ulihldi']
        ]
    ]

    @Unroll
    def "conjugating Alidliha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        def tenz = tense.toString()
        def syllabary = SyllabaryUtil.tsalagiToSyllabary(expected)

        conjugateVerb("Alidliha", details, subj, obj, tenz, expected) == syllabary
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "alidliha"
        "SG3" | "" | Tense.HABITUAL        | "alidlisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulidlvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dvlidlvhi"
        "SG3" | "" | Tense.INFINITIVE      | "ulihldi"
    }
}
