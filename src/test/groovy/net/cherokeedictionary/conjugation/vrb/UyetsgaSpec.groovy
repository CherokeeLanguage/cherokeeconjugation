package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UyetsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Laughing",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agiyetsga', habitual: 'agiyetsgoi', remote_past: 'agiyetsvi', imperative: 'agiyetsa', infinitive: 'agiyetsdi'],
            [subject: 'SG2', object: '', present: 'jayetsga', habitual: 'jayetsgoi', remote_past: 'jayetsvi', imperative: 'jayetsa', infinitive: 'jayetsdi'],
            [subject: 'SG3', object: '', present: 'uyetsga', habitual: 'uyetsgoi', remote_past: 'uyetsvi', imperative: 'uyetsa', infinitive: 'uyetsdi'],
            [subject: 'PL3', object: '', present: 'uniyetsga', habitual: 'uniyetsgoi', remote_past: 'uniyetsvi', imperative: 'uniyetsa', infinitive: 'uniyetsdi'],
            [subject: 'PL1INCL', object: '', present: 'igiyetsga', habitual: 'igiyetsgoi', remote_past: 'igiyetsvi', imperative: 'igiyetsa', infinitive: 'igiyetsdi']
        ]
    ]

    @Unroll
    def "conjugating Uyetsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Uyetsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agiyetsga"
        "SG1" | "" | Tense.HABITUAL        | "agiyetsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiyetsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agiyetsa"
        "SG1" | "" | Tense.INFINITIVE      | "agiyetsdi"
        "SG2" | "" | Tense.PRESENT         | "jayetsga"
        "SG2" | "" | Tense.HABITUAL        | "jayetsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jayetsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jayetsa"
        "SG2" | "" | Tense.INFINITIVE      | "jayetsdi"
        "SG3" | "" | Tense.PRESENT         | "uyetsga"
        "SG3" | "" | Tense.HABITUAL        | "uyetsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyetsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uyetsa"
        "SG3" | "" | Tense.INFINITIVE      | "uyetsdi"
        "PL3" | "" | Tense.PRESENT         | "uniyetsga"
        "PL3" | "" | Tense.HABITUAL        | "uniyetsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyetsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uniyetsa"
        "PL3" | "" | Tense.INFINITIVE      | "uniyetsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igiyetsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "igiyetsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiyetsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igiyetsa"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiyetsdi"
    }
}
