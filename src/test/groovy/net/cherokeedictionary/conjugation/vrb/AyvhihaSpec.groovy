package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyvhihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Entering",
        part_of_speech: "v.t.",
        conjugations: [
            [subject: 'SG1', object: 'SG3AN', present: 'jiyvia', habitual: 'jiyvioi', remote_past: 'agiyvhlvi', imperative: 'jiyva', infinitive: 'agiyvsdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyvhiha', habitual: 'hiyvhihoi', remote_past: 'jayvhlvi', imperative: 'hiyvha', infinitive: 'jayvsdi'],
            [subject: 'SG3', object: 'SG3AN', present: 'ayvhiha', habitual: 'ayvhihoi', remote_past: 'uyvhlvi', imperative: 'ayvha', infinitive: 'uyvsdi'],
            [subject: 'PL3', object: 'SG3AN', present: 'aniyvhiha', habitual: 'aniyvhihoi', remote_past: 'uniyvhlvi', imperative: 'aniyvha', infinitive: 'uniyvsdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'idiyvhiha', habitual: 'idiyvhihoi', remote_past: 'igiyvhlvi', imperative: 'idiyvha', infinitive: 'igiyvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ayvhiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayvhiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "jiyvia"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jiyvioi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "agiyvhlvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "jiyva"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "agiyvsdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyvhiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyvhihoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "jayvhlvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyvha"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "jayvsdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "ayvhiha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "ayvhihoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uyvhlvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "ayvha"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uyvsdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "aniyvhiha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "aniyvhihoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "uniyvhlvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aniyvha"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "uniyvsdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "idiyvhiha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "idiyvhihoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "igiyvhlvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "idiyvha"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "igiyvsdi"
    }
}
