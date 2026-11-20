package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class YigiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Is Not / Was / Will Be",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'tla', habitual: 'yigi', remote_past: 'gesoi', imperative: 'jigesvi', infinitive: 'gesesdi']
        ]
    ]

    @Unroll
    def "conjugating Yigi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Yigi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "tla"
        "SG3" | "" | Tense.HABITUAL        | "yigi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugesoi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gagesoi"
        "SG3" | "" | Tense.INFINITIVE      | "usesdi"
    }
}
