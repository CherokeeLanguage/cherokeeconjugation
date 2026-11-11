package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KanohehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Telling",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinoheha', habitual: 'jinohesgoi', remote_past: 'akihnohehlvi', imperative: 'jinohvla', infinitive: 'akihnohehdi'],
            [subject: 'SG2', object: '', present: 'hinoheha', habitual: 'hinohesgoi', remote_past: 'jahnohehlvi', imperative: 'hihnohvla', infinitive: 'jahnohehdi'],
            [subject: 'SG3', object: '', present: 'kanoheha', habitual: 'kanohesgoi', remote_past: 'uhnohehlvi', imperative: 'kanohvla', infinitive: 'uhnohehdi'],
            [subject: 'PL3', object: '', present: 'aninoheha', habitual: 'aninohesgoi', remote_past: 'unihnohehlvi', imperative: 'anihnohvla', infinitive: 'unihnohehdi'],
            [subject: 'PL1INCL', object: '', present: 'idinoheha', habitual: 'idinohesgoi', remote_past: 'igihnohehlvi', imperative: 'idihnohvla', infinitive: 'igihnohehdi']
        ]
    ]

    @Unroll
    def "conjugating Kanoheha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kanoheha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinoheha"
        "SG1" | "" | Tense.HABITUAL        | "jinohesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akihnohehlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinohvla"
        "SG1" | "" | Tense.INFINITIVE      | "akihnohehdi"
        "SG2" | "" | Tense.PRESENT         | "hinoheha"
        "SG2" | "" | Tense.HABITUAL        | "hinohesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahnohehlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihnohvla"
        "SG2" | "" | Tense.INFINITIVE      | "jahnohehdi"
        "SG3" | "" | Tense.PRESENT         | "kanoheha"
        "SG3" | "" | Tense.HABITUAL        | "kanohesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhnohehlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "kanohvla"
        "SG3" | "" | Tense.INFINITIVE      | "uhnohehdi"
        "PL3" | "" | Tense.PRESENT         | "aninoheha"
        "PL3" | "" | Tense.HABITUAL        | "aninohesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihnohehlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihnohvla"
        "PL3" | "" | Tense.INFINITIVE      | "unihnohehdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinoheha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinohesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igihnohehlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idihnohvla"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igihnohehdi"
    }
}
