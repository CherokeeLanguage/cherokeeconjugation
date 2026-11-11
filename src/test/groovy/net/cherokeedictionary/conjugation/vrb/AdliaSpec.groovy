package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdliaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Put in Container (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jidlia', habitual: 'jidlisgoi', remote_past: 'agidlvi', imperative: 'jidliga', infinitive: 'agidlisdi'],
            [subject: 'SG2', object: '', present: 'hidlia', habitual: 'hidlisgoi', remote_past: 'jadlvi', imperative: 'hidliga', infinitive: 'jadlisdi'],
            [subject: 'SG3', object: '', present: 'adlia', habitual: 'adlisgoi', remote_past: 'udlvi', imperative: 'wadliga', infinitive: 'udlisdi'],
            [subject: 'PL3', object: '', present: 'anidlia', habitual: 'anidlisgoi', remote_past: 'unidlvi', imperative: 'wanidliga', infinitive: 'unidlisdi']
        ]
    ]

    @Unroll
    def "conjugating Adlia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adlia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jidlia"
        "SG1" | "" | Tense.HABITUAL        | "jidlisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agidlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jidliga"
        "SG1" | "" | Tense.INFINITIVE      | "agidlisdi"
        "SG2" | "" | Tense.PRESENT         | "hidlia"
        "SG2" | "" | Tense.HABITUAL        | "hidlisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hidliga"
        "SG2" | "" | Tense.INFINITIVE      | "jadlisdi"
        "SG3" | "" | Tense.PRESENT         | "adlia"
        "SG3" | "" | Tense.HABITUAL        | "adlisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "wadliga"
        "SG3" | "" | Tense.INFINITIVE      | "udlisdi"
        "PL3" | "" | Tense.PRESENT         | "anidlia"
        "PL3" | "" | Tense.HABITUAL        | "anidlisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unidlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "wanidliga"
        "PL3" | "" | Tense.INFINITIVE      | "unidlisdi"
    }
}
