// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72473 (entrya aktiya) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AktiyaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Waiting",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jigatiya, jigatiya'],
            [subject: 'SG2', object: 'SG3AN', present: 'higatiya', habitual: '/', remote_past: 'hiktiya', imperative: 'higatiyoi', infinitive: '/'],
            [subject: 'SG1', object: '', present: 'aktiya', habitual: 'aktiyoi', remote_past: 'uktidvi', imperative: 'aktida', infinitive: 'uktidisdi'],
            [subject: 'SG3', object: '', habitual: 'aktiyoi', imperative: 'higatida, hiktida', infinitive: 'uktidisdi', present: 'aktiya', remote_past: 'uktidvi'],
            [subject: 'PL1INCL', object: '', present: 'idaktiya', habitual: 'idaktiyoi', remote_past: 'igaktidvi', imperative: 'idaktida', infinitive: 'igaktidisdi']
        ]
    ]

    @Unroll
    def "conjugating Aktiya (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aktiya", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG2" | "SG3AN" | Tense.PRESENT         | "higitiya"
        // "SG2" | "SG3AN" | Tense.HABITUAL        | "/"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "gitidvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "higitidvi"
        // "SG2" | "SG3AN" | Tense.INFINITIVE      | "/"
        "SG1" | "" | Tense.PRESENT         | "tsigitiya"
        "SG1" | "" | Tense.HABITUAL        | "tsigitiyoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agigitidvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsigitidvi"
        "SG1" | "" | Tense.INFINITIVE      | "agigitidisdi"
        "SG3" | "" | Tense.PRESENT         | "agitiya"
        "SG3" | "" | Tense.HABITUAL        | "agitiyoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugitidvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "agitidvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugitidisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idigitiya"
        "PL1INCL" | "" | Tense.HABITUAL        | "idigitiyoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igigitidvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idigitidvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igigitidisdi"
    }
}
