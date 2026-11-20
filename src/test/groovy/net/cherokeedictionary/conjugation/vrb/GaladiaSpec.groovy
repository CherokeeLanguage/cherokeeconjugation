// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73051 (entrya galadia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GaladiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Put in Container (long)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiladia'],
            [subject: 'SG1', object: '', present: 'jiladia', habitual: 'jiladisgoi', remote_past: 'agiladvi', imperative: 'jilada', infinitive: 'agiladisdi'],
            [subject: 'SG2', object: '', present: 'hiladia', habitual: 'haladisgoi', remote_past: 'jaladvi', imperative: 'hilada', infinitive: 'jaladisdi'],
            [subject: 'SG3', object: '', habitual: 'galadisgoi', imperative: 'hilada', infinitive: 'uladisdi', present: 'galadia', remote_past: 'uladvi'],
            [subject: 'PL3', object: '', present: 'aniladia', habitual: 'aniladisgoi', remote_past: 'uniladvi', imperative: 'wanilada', infinitive: 'uniladisdi']
        ]
    ]

    @Unroll
    def "conjugating Galadia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Galadia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiladia"
        "SG1" | "" | Tense.HABITUAL        | "jiladisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiladvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiladvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiladisdi"
        "SG2" | "" | Tense.PRESENT         | "hiladia"
        "SG2" | "" | Tense.HABITUAL        | "haladisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jaladvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiladvi"
        "SG2" | "" | Tense.INFINITIVE      | "jaladisdi"
        "SG1" | "" | Tense.PRESENT         | "jiladia"
        "SG1" | "" | Tense.HABITUAL        | "jiladisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiladvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiladvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiladisdi"
        "PL3" | "" | Tense.PRESENT         | "aniladia"
        "PL3" | "" | Tense.HABITUAL        | "aniladisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniladvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniladvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniladisdi"
    }
}
