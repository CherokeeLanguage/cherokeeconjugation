// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73744 (entrya udiwsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UdiwsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Getting Well",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'agwadiwsga'],
            [subject: 'SG1', object: '', present: 'agwadiwsga', habitual: 'agwadiwsgoi', remote_past: 'agwadiwsvi', imperative: 'agwadihwi', infinitive: 'agwadihwisdi'],
            [subject: 'SG2', object: '', present: 'jadiwsga', habitual: 'jadiwsgoi', remote_past: 'jadiwsvi', imperative: 'jadihwi', infinitive: 'jadihwisdi'],
            [subject: 'SG3', object: '', habitual: 'udiwsgoi', imperative: 'jadihwi', infinitive: 'udihwisdi', present: 'udiwsga', remote_past: 'udiwsvi'],
            [subject: 'PL3', object: '', present: 'unadiwsga', habitual: 'unadiwsgoi', remote_past: 'unadiwsvi', imperative: 'unadihwi', infinitive: 'unadihwisdi'],
            [subject: 'PL1INCL', object: '', present: 'igadiwsga', habitual: 'igadiwsgoi', remote_past: 'igadiwsvi', imperative: 'igadihwi', infinitive: 'igadihwisdi']
        ]
    ]

    @Unroll
    def "conjugating Udiwsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Udiwsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "aquadiwvsga"
        "SG1" | "" | Tense.HABITUAL        | "aquadiwvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadiwvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aquadiwvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadiwisdi"
        "SG2" | "" | Tense.PRESENT         | "tsadiwvsga"
        "SG2" | "" | Tense.HABITUAL        | "tsadiwvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadiwvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsadiwvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadiwisdi"
        "SG3" | "" | Tense.PRESENT         | "udiwvsga"
        "SG3" | "" | Tense.HABITUAL        | "udiwvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udiwvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "udiwvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "udiwisdi"
        "PL3" | "" | Tense.PRESENT         | "unadiwvsga"
        "PL3" | "" | Tense.HABITUAL        | "unadiwvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadiwvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unadiwvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadiwisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igadiwvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "igadiwvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadiwvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igadiwvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadiwisdi"
    }
}
