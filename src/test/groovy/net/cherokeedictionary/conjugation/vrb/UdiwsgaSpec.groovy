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
            [subject: 'SG1', object: '', present: 'agwadiwsga', habitual: 'agwadiwsgoi', remote_past: 'agwadiwsvi', imperative: 'agwadihwi', infinitive: 'agwadihwisdi'],
            [subject: 'SG2', object: '', present: 'jadiwsga', habitual: 'jadiwsgoi', remote_past: 'jadiwsvi', imperative: 'jadihwi', infinitive: 'jadihwisdi'],
            [subject: 'SG3', object: '', present: 'udiwsga', habitual: 'udiwsgoi', remote_past: 'udiwsvi', imperative: 'udihwi', infinitive: 'udihwisdi'],
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
        "SG1" | "" | Tense.PRESENT         | "agwadiwsga"
        "SG1" | "" | Tense.HABITUAL        | "agwadiwsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadiwsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwadihwi"
        "SG1" | "" | Tense.INFINITIVE      | "agwadihwisdi"
        "SG2" | "" | Tense.PRESENT         | "jadiwsga"
        "SG2" | "" | Tense.HABITUAL        | "jadiwsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadiwsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jadihwi"
        "SG2" | "" | Tense.INFINITIVE      | "jadihwisdi"
        "SG3" | "" | Tense.PRESENT         | "udiwsga"
        "SG3" | "" | Tense.HABITUAL        | "udiwsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udiwsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "udihwi"
        "SG3" | "" | Tense.INFINITIVE      | "udihwisdi"
        "PL3" | "" | Tense.PRESENT         | "unadiwsga"
        "PL3" | "" | Tense.HABITUAL        | "unadiwsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadiwsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unadihwi"
        "PL3" | "" | Tense.INFINITIVE      | "unadihwisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igadiwsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "igadiwsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadiwsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igadihwi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadihwisdi"
    }
}
