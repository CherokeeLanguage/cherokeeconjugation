package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GalvvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Put in Container (flexible)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jilvvsga', habitual: 'jilvvsgoi', remote_past: 'agilvnvi', imperative: 'jilvvga', infinitive: 'agilvdi'],
            [subject: 'SG2', object: '', present: 'hilvvsga', habitual: 'hilvvsgoi', remote_past: 'jalvnvi', imperative: 'hilvvga', infinitive: 'jalvdi'],
            [subject: 'SG3', object: '', present: 'galvvsga', habitual: 'galvvsgoi', remote_past: 'ulvnvi', imperative: 'wigalvvga', infinitive: 'ulvdi'],
            [subject: 'PL3', object: '', present: 'anilvvsga', habitual: 'anilvvsgoi', remote_past: 'unilvnvi', imperative: 'wanilvvga', infinitive: 'unilvdi']
        ]
    ]

    @Unroll
    def "conjugating Galvvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Galvvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsilvvsga"
        "SG1" | "" | Tense.HABITUAL        | "tsilvvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agilvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsilvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "agilvdi"
        "SG2" | "" | Tense.PRESENT         | "hilvvsga"
        "SG2" | "" | Tense.HABITUAL        | "hilvvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalvnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hilvnvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsalvdi"
        "SG1" | "" | Tense.PRESENT         | "tsilvvsga"
        "SG1" | "" | Tense.HABITUAL        | "tsilvvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agilvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsilvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "agilvdi"
        "PL3" | "" | Tense.PRESENT         | "anilvvsga"
        "PL3" | "" | Tense.HABITUAL        | "anilvvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unilvnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anilvnvi"
        "PL3" | "" | Tense.INFINITIVE      | "unilvdi"
    }
}
