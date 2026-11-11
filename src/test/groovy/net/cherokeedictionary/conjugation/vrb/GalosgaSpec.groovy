package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GalosgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Fall from Elevated Position (living)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jilosga', habitual: 'jilosgoi', remote_past: 'agilosvi', imperative: 'jilohi', infinitive: 'agilohisdi'],
            [subject: 'SG2', object: '', present: 'hilosga', habitual: 'hilosgoi', remote_past: 'jalosvi', imperative: 'hilohi', infinitive: 'jalohisdi'],
            [subject: 'SG1', object: '', present: 'galosga', habitual: 'galosgoi', remote_past: 'ulosvi', imperative: 'wigalohi', infinitive: 'ulohisdi'],
            [subject: 'PL3', object: '', present: 'anilosga', habitual: 'anilosgoi', remote_past: 'unilosvi', imperative: 'wanilohi', infinitive: 'unilohisdi']
        ]
    ]

    @Unroll
    def "conjugating Galosga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Galosga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jilosga"
        "SG1" | "" | Tense.HABITUAL        | "jilosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agilosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jilohi"
        "SG1" | "" | Tense.INFINITIVE      | "agilohisdi"
        "SG2" | "" | Tense.PRESENT         | "hilosga"
        "SG2" | "" | Tense.HABITUAL        | "hilosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hilohi"
        "SG2" | "" | Tense.INFINITIVE      | "jalohisdi"
        "SG1" | "" | Tense.PRESENT         | "galosga"
        "SG1" | "" | Tense.HABITUAL        | "galosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "ulosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "wigalohi"
        "SG1" | "" | Tense.INFINITIVE      | "ulohisdi"
        "PL3" | "" | Tense.PRESENT         | "anilosga"
        "PL3" | "" | Tense.HABITUAL        | "anilosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unilosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "wanilohi"
        "PL3" | "" | Tense.INFINITIVE      | "unilohisdi"
    }
}
