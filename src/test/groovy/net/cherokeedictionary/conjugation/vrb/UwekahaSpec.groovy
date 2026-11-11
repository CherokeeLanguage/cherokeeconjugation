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
            [subject: 'SG3', object: '', present: 'jekaha', habitual: 'jekahoi', remote_past: 'jekahvi', imperative: 'jekahesdi', infinitive: 'jekohdi'],
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
        "SG1" | "" | Tense.PRESENT         | "agikaha"
        "SG1" | "" | Tense.HABITUAL        | "agikahoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agikahvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agikahesdi"
        "SG1" | "" | Tense.INFINITIVE      | "agikohdi"
        "SG3" | "" | Tense.PRESENT         | "jekaha"
        "SG3" | "" | Tense.HABITUAL        | "jekahoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "jekahvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "jekahesdi"
        "SG3" | "" | Tense.INFINITIVE      | "jekohdi"
        "SG3" | "" | Tense.PRESENT         | "uwekaha"
        "SG3" | "" | Tense.HABITUAL        | "uwekahoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwekahvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uwekahesdi"
        "SG3" | "" | Tense.INFINITIVE      | "uwekohdi"
        "SG3" | "" | Tense.PRESENT         | "unekaha"
        "SG3" | "" | Tense.HABITUAL        | "unekahoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unekahvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "unekahesdi"
        "SG3" | "" | Tense.INFINITIVE      | "unekohdi"
    }
}
