package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UyohuseaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Losing Something (Thing)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agiyohusea', habitual: 'agiyohusehoi', remote_past: 'agiyohuselvi', imperative: 'agiyohusi', infinitive: 'agiyohusehdi'],
            [subject: 'SG2', object: '', present: 'jayohusea', habitual: 'jayohusehoi', remote_past: 'jayohuselvi', imperative: 'jayohusi', infinitive: 'jayohusehdi'],
            [subject: 'SG3', object: '', present: 'uyohusea', habitual: 'uyohusehoi', remote_past: 'uyohuselvi', imperative: 'uyohusi', infinitive: 'uyohusehdi'],
            [subject: 'PL3', object: '', present: 'uniyohusea', habitual: 'uniyohusehoi', remote_past: 'uniyohuselvi', imperative: 'uniyohusi', infinitive: 'uniyohusehdi'],
            [subject: 'PL1INCL', object: '', present: 'igiyohusea', habitual: 'igiyohusehoi', remote_past: 'igiyohuselvi', imperative: 'igiyohusi', infinitive: 'igiyohusehdi']
        ]
    ]

    @Unroll
    def "conjugating Uyohusea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uyohusea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agiyohusea"
        "SG1" | "" | Tense.HABITUAL        | "agiyohusehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiyohuselvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agiyohusi"
        "SG1" | "" | Tense.INFINITIVE      | "agiyohusehdi"
        "SG2" | "" | Tense.PRESENT         | "jayohusea"
        "SG2" | "" | Tense.HABITUAL        | "jayohusehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jayohuselvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jayohusi"
        "SG2" | "" | Tense.INFINITIVE      | "jayohusehdi"
        "SG3" | "" | Tense.PRESENT         | "uyohusea"
        "SG3" | "" | Tense.HABITUAL        | "uyohusehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyohuselvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uyohusi"
        "SG3" | "" | Tense.INFINITIVE      | "uyohusehdi"
        "PL3" | "" | Tense.PRESENT         | "uniyohusea"
        "PL3" | "" | Tense.HABITUAL        | "uniyohusehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyohuselvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uniyohusi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyohusehdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igiyohusea"
        "PL1INCL" | "" | Tense.HABITUAL        | "igiyohusehoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiyohuselvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igiyohusi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiyohusehdi"
    }
}
