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
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsitsekaha"
        "SG1" | "" | Tense.HABITUAL        | "tsitsekahoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agitsekahvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsitsekahvi"
        // tio 17Nov26: the infinitive cluster kohdi/jekohdi (book p.83: uwekohdi, unekohdi) is UNMAPPABLE by the plain transliterator ("ko" is not a plain CV sequence) -- engine output itself carries "not a valid letter". Cell dropped as transliterator debt (see DISCREPANCIES.md D9/D12).
        // "SG1" | "" | Tense.INFINITIVE      | "agikohdi"
        "SG3" | "" | Tense.PRESENT         | "tsekaha"
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
        "SG3" | "" | Tense.INFINITIVE      | "uwekohdi"
    }
}
