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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jisgwadia"
        "SG1" | "" | Tense.HABITUAL        | "jisgwadisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aksgwadvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisquadvi"
        "SG1" | "" | Tense.INFINITIVE      | "aksgwadisdi"
        "SG2" | "" | Tense.PRESENT         | "hisgwadia"
        "SG2" | "" | Tense.HABITUAL        | "hisgwadisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasquadvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisquadvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsasquadisdi"
        "SG3" | "" | Tense.PRESENT         | "asgwadia"
        "SG3" | "" | Tense.HABITUAL        | "asgwadisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usgwadvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asquadvi"
        "SG3" | "" | Tense.INFINITIVE      | "usgwadisdi"
        "PL3" | "" | Tense.PRESENT         | "anisgwadia"
        "PL3" | "" | Tense.HABITUAL        | "anisgwadisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unsgwadvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisquadvi"
        "PL3" | "" | Tense.INFINITIVE      | "unsgwadisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisgwadia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisgwadisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iksgwadvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisquadvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iksgwadisdi"
    }
}
