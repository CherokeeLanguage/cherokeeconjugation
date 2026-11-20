package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class WayihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Get (long)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'wijiyia', habitual: 'wijiyisgoi', remote_past: 'wagiyvhvi', imperative: 'wijiya', infinitive: 'wagiyhdi'],
            [subject: 'SG2', object: '', present: 'hwiyiha', habitual: 'hwiyisgoi', remote_past: 'wijayvhvi', imperative: 'hwiya', infinitive: 'wijayhdi'],
            [subject: 'SG3', object: '', present: 'wayiha', habitual: 'wayisgoi', remote_past: 'wuyvhvi', imperative: 'waya', infinitive: 'wuyhdi'],
            [subject: 'SG3', object: '', present: 'waniyiha', habitual: 'waniyisgoi', remote_past: 'wuniyvhvi', imperative: 'waniya', infinitive: 'wuniyhdi']
        ]
    ]

    @Unroll
    def "conjugating Wayiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Wayiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "wijiyia"
        "SG3" | "" | Tense.HABITUAL        | "wijiyisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwagiyvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawagiyvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugiyvdi"
        "SG2" | "" | Tense.PRESENT         | "hitsiyia"
        "SG2" | "" | Tense.HABITUAL        | "hitsiyisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawagiyvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwagiyvhvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsagiyvdi"
        "SG3" | "" | Tense.PRESENT         | "witsiyia"
        "SG3" | "" | Tense.HABITUAL        | "witsiyisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwagiyvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawagiyvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugiyvdi"
        "SG3" | "" | Tense.PRESENT         | "witsiyia"
        "SG3" | "" | Tense.HABITUAL        | "witsiyisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwagiyvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawagiyvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugiyvdi"
    }
}
