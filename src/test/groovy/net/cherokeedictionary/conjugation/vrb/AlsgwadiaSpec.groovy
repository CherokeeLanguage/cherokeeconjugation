package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlsgwadiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "It Is Ending/Finishing",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'alsgwadia', habitual: 'alsgwadisgoi', remote_past: 'ulsgwadvi', imperative: 'dvlsgwadi', infinitive: 'ulsgwadisdi']
        ]
    ]

    @Unroll
    def "conjugating Alsgwadia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alsgwadia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "alsgwadia"
        "SG3" | "" | Tense.HABITUAL        | "alsgwadisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulsgwadvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dvlsgwadi"
        "SG3" | "" | Tense.INFINITIVE      | "ulsgwadisdi"
    }
}
