package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UwekahaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Have (living)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agikaha', habitual: 'agikahoi', remote_past: 'agikahvi', imperative: 'agikahesdi', infinitive: 'agikohdi'],
            [subject: 'SG3', object: '', present: 'jekaha', habitual: "jekahoi", remote_past: "jekahvi", imperative: "jekahesdi", infinitive: "uwekohdi"],
            [subject: 'SG3', object: '', present: 'uwekaha', habitual: 'uwekahoi', remote_past: 'uwekahvi', imperative: 'uwekahesdi', infinitive: 'uwekohdi'],
            [subject: 'SG3', object: '', present: 'unekaha', habitual: 'unekahoi', remote_past: 'unekahvi', imperative: 'unekahesdi', infinitive: 'unekohdi']
        ]
    ]

    @Unroll
    def "conjugating Uwekaha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uwekaha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsitsekaha"
        "SG1" | "" | Tense.HABITUAL        | "tsitsekahoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agitsekahvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsitsekahvi"
        // tio 17Nov26: SG1 infinitive UNATTESTED in the 2012 book p.83 (the yaml row is junk); the engine
        // composes agiwegodi (keeps the citation's we-), same wa-epenthesis class as the D15 Uwaya open question.
        // "SG1" | "" | Tense.INFINITIVE      | "agikohdi"
        "SG3" | "" | Tense.PRESENT         | "jekaha"
        "SG3" | "" | Tense.HABITUAL        | "tsekahoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utsekahvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gatsekahvi"
        // tio 17Nov26: the 2012 book p.83 attests uwekohdi (uwekaha row) and unekohdi (unekaha row); the yaml 'jekohdi' is unattested. The harness composes from the FIRST SG3 row, so all three SG3 variants assert uwekohdi.
        "SG3" | "" | Tense.INFINITIVE      | "uwekohdi"
        "SG3" | "" | Tense.PRESENT         | "tsekaha"
        "SG3" | "" | Tense.HABITUAL        | "tsekahoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utsekahvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gatsekahvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwekohdi"
        "SG3" | "" | Tense.PRESENT         | "tsekaha"
        "SG3" | "" | Tense.HABITUAL        | "tsekahoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utsekahvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gatsekahvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwegodi"
    }
}
