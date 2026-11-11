package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Killing (Him/It)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', object: '', present: 'ahiha', habitual: 'ahihoi', remote_past: 'uhlvi', imperative: 'aluga', infinitive: 'uhisdi'],
            [subject: 'PL3', object: '', present: 'anihiha', habitual: 'anihihoi', remote_past: 'unihlvi', imperative: 'aniluga', infinitive: 'unihisdi'],
            [subject: 'PL1INCL', object: '', present: 'idihiha', habitual: 'idihihoi', remote_past: 'igihlvi', imperative: 'idiluga', infinitive: 'igihisdi']
        ]
    ]

    @Unroll
    def "conjugating Ahiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "ahiha"
        "SG3" | "" | Tense.HABITUAL        | "ahihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "aluga"
        "SG3" | "" | Tense.INFINITIVE      | "uhisdi"
        "PL3" | "" | Tense.PRESENT         | "anihiha"
        "PL3" | "" | Tense.HABITUAL        | "anihihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniluga"
        "PL3" | "" | Tense.INFINITIVE      | "unihisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idihiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idihihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igihlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiluga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igihisdi"
    }
}
