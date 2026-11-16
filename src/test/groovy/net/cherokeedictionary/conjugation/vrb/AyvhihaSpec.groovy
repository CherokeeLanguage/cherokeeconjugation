// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72724 (entrya ayvhiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'jiyviha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyvia', habitual: 'jiyvioi', remote_past: 'agiyvhlvi', imperative: 'jiyva', infinitive: 'agiyvsdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyvhiha', habitual: 'hiyvhihoi', remote_past: 'jayvhlvi', imperative: 'hiyvha', infinitive: 'jayvsdi'],
            [subject: 'SG3', object: '', habitual: 'ayvhihoi', imperative: 'hiyvha', infinitive: 'uyvsdi', present: 'ayvhiha', remote_past: 'uyvhlvi'],
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
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyvhiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyvhihoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyvtlvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyvtlvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyvsdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyvhiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyvhihoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "yvtlvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyvtlvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "yvsdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "gayvhiha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "ayvhihoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uyvtlvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "ayvtlvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uyvsdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "aniyvhiha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "aniyvhihoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "aniyvtlvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aniyvtlvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "aniyvsdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "ediyvhiha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "ediyvhihoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "yvtlvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "ediyvtlvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "yvsdi"
    }
}
