package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanatlaaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he Has an Animal",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinatlaa', habitual: 'jinatlaoi', remote_past: 'aginatlavi', imperative: 'jinatla', infinitive: 'x'],
            [subject: 'SG2', object: '', present: 'hinatlaa', habitual: 'hinatlaoi', remote_past: 'janatlavi', imperative: 'hinatla', infinitive: ''],
            [subject: 'SG3', object: '', present: 'ganatlaa', habitual: 'ganatlaoi', remote_past: 'unatlavi', imperative: 'ganatla', infinitive: ''],
            [subject: 'PL3', object: '', present: 'aninatlaa', habitual: 'aninatlaoi', remote_past: 'uninatlavi', imperative: 'aninatla', infinitive: ''],
            [subject: 'PL1INCL', object: '', present: 'idinatlaa', habitual: 'idinatlaoi', remote_past: 'iginatlavi', imperative: 'idinatla', infinitive: '']
        ]
    ]

    @Unroll
    def "conjugating Ganatlaa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganatlaa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinatlaa"
        "SG1" | "" | Tense.HABITUAL        | "jinatlaoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginatlavi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinatla"
        "SG1" | "" | Tense.INFINITIVE      | "x"
        "SG2" | "" | Tense.PRESENT         | "hinatlaa"
        "SG2" | "" | Tense.HABITUAL        | "hinatlaoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janatlavi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinatla"
        // "SG2" | "" | Tense.INFINITIVE      | "X"
        "SG3" | "" | Tense.PRESENT         | "ganatlaa"
        "SG3" | "" | Tense.HABITUAL        | "ganatlaoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unatlavi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganatla"
        // "SG3" | "" | Tense.INFINITIVE      | "X"
        "PL3" | "" | Tense.PRESENT         | "aninatlaa"
        "PL3" | "" | Tense.HABITUAL        | "aninatlaoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninatlavi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninatla"
        // "PL3" | "" | Tense.INFINITIVE      | "X"
        "PL1INCL" | "" | Tense.PRESENT         | "idinatlaa"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinatlaoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginatlavi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinatla"
        // "PL1INCL" | "" | Tense.INFINITIVE      | "X"
    }
}
