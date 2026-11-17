// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72797 (entrya danagaleniha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DanagalenihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "They are Separating (74)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'dosdagaleniha'],
            [subject: 'SG1', object: '', present: 'desdagaleniha', habitual: 'desdagalenisgoi', remote_past: 'deginagalenvhvi', imperative: 'disdagalena', infinitive: 'disdagalenhdi'],
            [subject: 'SG2', object: '', present: 'dojagaleniha', habitual: 'dojagalenisgoi', remote_past: 'doganagalenvhvi', imperative: 'jojagalena', infinitive: 'jojagalenhdi'],
            [subject: 'SG3', object: '', habitual: 'danagalenisgoi', imperative: 'disdagalena', infinitive: 'junagalenhdi', present: 'danagaleniha', remote_past: 'dunagalenvhvi'],
            [subject: 'PL3', object: '', present: 'dejagaleniha', habitual: 'dejagalenisgoi', remote_past: 'dejagalenvhvi', imperative: 'dijagalena', infinitive: 'dijagalenhdi'],
            [subject: 'PL1INCL', object: '', present: 'dedagaleniha', habitual: 'dedagalenisgoi', remote_past: 'degagalenvhvi', imperative: 'didagalena', infinitive: 'didagalenhdi']
        ]
    ]

    @Unroll
    def "conjugating Danagaleniha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Danagaleniha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "ganagaleniha"
        "SG1" | "" | Tense.HABITUAL        | "ganagalenisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquanagalenvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganagalenvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginagalenadi"
        "SG2" | "" | Tense.PRESENT         | "hanagaleniha"
        "SG2" | "" | Tense.HABITUAL        | "hanagalenisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanagalenvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hanagalenvhvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanagalenadi"
        "SG3" | "" | Tense.PRESENT         | "danagaleniha"
        "SG3" | "" | Tense.HABITUAL        | "danagalenisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unagalenvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anagalenvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "unagalenadi"
        "PL3" | "" | Tense.PRESENT         | "ananagaleniha"
        "PL3" | "" | Tense.HABITUAL        | "ananagalenisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unanagalenvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "ananagalenvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninagalenadi"
        "PL1INCL" | "" | Tense.PRESENT         | "idanagaleniha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idanagalenisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iganagalenvhvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idanagalenvhvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginagalenadi"
    }
}
