// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72353 (entrya ahiyaa) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhiyaaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Leave Behind (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiiyaa'],
            [subject: 'SG1', object: '', present: 'jiiyaa', habitual: 'jiiyasgoi', remote_past: 'agihiyvi', imperative: 'jiiya', infinitive: 'agihiyasdi'],
            [subject: 'SG2', object: '', present: 'hihiyaa', habitual: 'hihiyasgoi', remote_past: 'jahiyvi', imperative: 'hihiya', infinitive: 'jahiyasdi'],
            [subject: 'SG3', object: '', habitual: 'ahiyasgoi', imperative: 'hihiya', infinitive: 'uhiyasdi', present: 'ahiyaa', remote_past: 'uhiyvi'],
            [subject: 'PL3', object: '', present: 'anihiyaa', habitual: 'anihiyasgoi', remote_past: 'unihiyvi', imperative: 'anihiya', infinitive: 'unihiyasdi']
        ]
    ]

    @Unroll
    def "conjugating Ahiyaa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahiyaa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiiyaa"
        "SG1" | "" | Tense.HABITUAL        | "jiiyasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agihiyvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsihiyvi"
        "SG1" | "" | Tense.INFINITIVE      | "agihiyasdi"
        "SG2" | "" | Tense.PRESENT         | "hihiyaa"
        "SG2" | "" | Tense.HABITUAL        | "hihiyasgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahiyvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihiyvi"
        "SG2" | "" | Tense.INFINITIVE      | "jahiyasdi"
        "SG3" | "" | Tense.PRESENT         | "ahiyaa"
        "SG3" | "" | Tense.HABITUAL        | "ahiyasgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhiyvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahiyvi"
        "SG3" | "" | Tense.INFINITIVE      | "uhiyasdi"
        "PL3" | "" | Tense.PRESENT         | "anihiyaa"
        "PL3" | "" | Tense.HABITUAL        | "anihiyasgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihiyvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihiyvi"
        "PL3" | "" | Tense.INFINITIVE      | "unihiyasdi"
    }
}
