// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72403 (entrya ahyaniha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhyanihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Receive (living)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyaniha'],
            [subject: 'SG1', object: '', present: 'jiyaniha', habitual: 'jiyanisgoi', remote_past: 'jiyanvhvi', imperative: 'jiyana', infinitive: 'jiyanhdi'],
            [subject: 'SG2', object: '', present: 'hihyaniha', habitual: 'hihyanisgoi', remote_past: 'hihyanvhvi', imperative: 'hwahyana', infinitive: 'hihyanhdi'],
            [subject: 'SG3', object: '', habitual: 'ahyanisgoi', imperative: 'hiyana', infinitive: 'uhyanhdi', present: 'ahyaniha', remote_past: 'uhyanvhvi'],
            [subject: 'PL3', object: '', present: 'anihyaniha', habitual: 'anihyanisgoi', remote_past: 'unihyanvhvi', imperative: 'wanihyana', infinitive: 'unihyanhdi']
        ]
    ]

    @Unroll
    def "conjugating Ahyaniha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahyaniha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsiyaniha"
        "SG1" | "" | Tense.HABITUAL        | "tsiyanisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiyanvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiyanvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiyanidi"
        "SG2" | "" | Tense.PRESENT         | "hiyaniha"
        "SG2" | "" | Tense.HABITUAL        | "hiyanisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsayanvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiyanvhvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsayanidi"
        "SG3" | "" | Tense.PRESENT         | "ayaniha"
        "SG3" | "" | Tense.HABITUAL        | "ayanisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyanvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ayanvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "uyanidi"
        "PL3" | "" | Tense.PRESENT         | "aniyaniha"
        "PL3" | "" | Tense.HABITUAL        | "aniyanisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyanvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniyanvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyanidi"
    }
}
