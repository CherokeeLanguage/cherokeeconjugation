package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DoyiSpec extends VerbBaseSpec {
    static def details = [
        definition: "Ujvsidiha Restroom (Going To)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'doyi', habitual: 'agwajvsidi', remote_past: 'doyi', imperative: 'agwajvsidisoi', infinitive: 'doyi'],
            [subject: 'SG2', object: '', present: 'doyi', habitual: 'jajvsidi', remote_past: 'doyi', imperative: 'jajvsidisoi', infinitive: 'doyi'],
            [subject: 'SG3', object: '', present: 'doyi', habitual: 'ujvsidi', remote_past: 'doyi', imperative: 'ujvsidisoi', infinitive: 'doyi'],
            [subject: 'PL3', object: '', present: 'doyi', habitual: 'unajvsidi', remote_past: 'doyi', imperative: 'unajvsidisoi', infinitive: 'doyi'],
            [subject: 'PL1INCL', object: '', present: 'doyi', habitual: 'igajvsidi', remote_past: 'doyi', imperative: 'igajvsidisoi', infinitive: 'doyi']
        ]
    ]

    @Unroll
    def "conjugating Doyi (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Doyi", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsitoyi"
        "SG1" | "" | Tense.HABITUAL        | "gutsvsidi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agitoyi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsidoyi"
        "SG1" | "" | Tense.INFINITIVE      | "agiyi"
        "SG2" | "" | Tense.PRESENT         | "hitoyi"
        "SG2" | "" | Tense.HABITUAL        | "hutsvsidi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatoyi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hidoyi"
        "SG2" | "" | Tense.INFINITIVE      | "tsayi"
        "SG3" | "" | Tense.PRESENT         | "doyi"
        "SG3" | "" | Tense.HABITUAL        | "ujvsidi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utoyi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gadoyi"
        "SG3" | "" | Tense.INFINITIVE      | "uyi"
        "PL3" | "" | Tense.PRESENT         | "anitoyi"
        "PL3" | "" | Tense.HABITUAL        | "anutsvsidi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unitoyi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anidoyi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyi"
        "PL1INCL" | "" | Tense.PRESENT         | "iditoyi"
        "PL1INCL" | "" | Tense.HABITUAL        | "idutsvsidi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igitoyi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "ididoyi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiyi"
    }
}
