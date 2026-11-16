// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72611 (entrya asgwadia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsgwadiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Finishing",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jisgwadia'],
            [subject: 'SG1', object: '', present: 'jisgwadia', habitual: 'jisgwadisgoi', remote_past: 'aksgwadvi', imperative: 'jisgwada', infinitive: 'aksgwadisdi'],
            [subject: 'SG2', object: '', present: 'hisgwadia', habitual: 'hisgwadisgoi', remote_past: 'tsgwadvi', imperative: 'hisgwada', infinitive: 'tsgwadisdi'],
            [subject: 'SG3', object: '', habitual: 'asgwadisgoi', imperative: 'hisgwada', infinitive: 'usgwadisdi', present: 'asgwadia', remote_past: 'usgwadvi'],
            [subject: 'PL3', object: '', present: 'anisgwadia', habitual: 'anisgwadisgoi', remote_past: 'unsgwadvi', imperative: 'anisgwada', infinitive: 'unsgwadisdi'],
            [subject: 'PL1INCL', object: '', present: 'idisgwadia', habitual: 'idisgwadisgoi', remote_past: 'iksgwadvi', imperative: 'idisgwada', infinitive: 'iksgwadisdi']
        ]
    ]

    @Unroll
    def "conjugating Asgwadia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asgwadia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsisquadia"
        "SG1" | "" | Tense.HABITUAL        | "tsisquadisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agisquadvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisquadvi"
        "SG1" | "" | Tense.INFINITIVE      | "agisquadisdi"
        "SG2" | "" | Tense.PRESENT         | "hisquadia"
        "SG2" | "" | Tense.HABITUAL        | "hisquadisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasquadvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisquadvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsasquadisdi"
        "SG3" | "" | Tense.PRESENT         | "asquadia"
        "SG3" | "" | Tense.HABITUAL        | "asquadisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usquadvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asquadvi"
        "SG3" | "" | Tense.INFINITIVE      | "usquadisdi"
        "PL3" | "" | Tense.PRESENT         | "anisquadia"
        "PL3" | "" | Tense.HABITUAL        | "anisquadisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisquadvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisquadvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisquadisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisquadia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisquadisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisquadvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisquadvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisquadisdi"
    }
}
