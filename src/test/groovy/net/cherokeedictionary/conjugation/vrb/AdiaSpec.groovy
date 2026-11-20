// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72256 (entrya adia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Set Down (long)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jidia'],
            [subject: 'SG1', object: '', present: 'jidia', habitual: 'jidisgoi', remote_past: 'agidvi', imperative: 'jida', infinitive: 'agidisdi'],
            [subject: 'SG2', object: '', present: 'hidia', habitual: 'hidisgoi', remote_past: 'jadvi', imperative: 'hida', infinitive: 'jadisdi'],
            [subject: 'SG3', object: '', habitual: 'adisgoi', imperative: 'hida', infinitive: 'udisdi', present: 'adia', remote_past: 'udvi'],
            [subject: 'PL3', object: '', present: 'anidia', habitual: 'anidisgoi', remote_past: 'unidvi', imperative: 'wanida', infinitive: 'unidisdi']
        ]
    ]

    @Unroll
    def "conjugating Adia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jidia"
        "SG1" | "" | Tense.HABITUAL        | "jidisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agidvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsidvi"
        "SG1" | "" | Tense.INFINITIVE      | "agidisdi"
        "SG2" | "" | Tense.PRESENT         | "hidia"
        "SG2" | "" | Tense.HABITUAL        | "hidisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hidvi"
        "SG2" | "" | Tense.INFINITIVE      | "jadisdi"
        "SG3" | "" | Tense.PRESENT         | "adia"
        "SG3" | "" | Tense.HABITUAL        | "adisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "advi"
        "SG3" | "" | Tense.INFINITIVE      | "udisdi"
        "PL3" | "" | Tense.PRESENT         | "anidia"
        "PL3" | "" | Tense.HABITUAL        | "anidisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unidvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anidvi"
        "PL3" | "" | Tense.INFINITIVE      | "unidisdi"
    }
}
