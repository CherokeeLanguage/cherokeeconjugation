// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 74006 (entrya uyetsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'agiyetsga'],
            [subject: 'SG1', object: '', present: 'agiyetsga', habitual: 'agiyetsgoi', remote_past: 'agiyetsvi', imperative: 'agiyetsa', infinitive: 'agiyetsdi'],
            [subject: 'SG2', object: '', present: 'jayetsga', habitual: 'jayetsgoi', remote_past: 'jayetsvi', imperative: 'jayetsa', infinitive: 'jayetsdi'],
            [subject: 'SG3', object: '', habitual: 'uyetsgoi', imperative: 'jayetsa', infinitive: 'uyetsdi', present: 'uyetsga', remote_past: 'uyetsvi'],
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
        "SG1" | "" | Tense.PRESENT         | "agiyetisga"
        "SG1" | "" | Tense.HABITUAL        | "agiyetisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiyetsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agiyetsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiyetsidi"
        "SG2" | "" | Tense.PRESENT         | "tsayetisga"
        "SG2" | "" | Tense.HABITUAL        | "tsayetisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsayetsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsayetsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsayetsidi"
        "SG3" | "" | Tense.PRESENT         | "uyetisga"
        "SG3" | "" | Tense.HABITUAL        | "uyetisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyetsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "uyetsvi"
        "SG3" | "" | Tense.INFINITIVE      | "uyetsidi"
        "PL3" | "" | Tense.PRESENT         | "uniyetisga"
        "PL3" | "" | Tense.HABITUAL        | "uniyetisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyetsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uniyetsvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyetsidi"
        "PL1INCL" | "" | Tense.PRESENT         | "igiyetisga"
        "PL1INCL" | "" | Tense.HABITUAL        | "igiyetisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiyetsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igiyetsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiyetsidi"
    }
}
