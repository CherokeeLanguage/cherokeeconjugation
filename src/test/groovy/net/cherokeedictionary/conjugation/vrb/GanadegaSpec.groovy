// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73093 (entrya ganadega) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanadegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Selling",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinadega'],
            [subject: 'SG1', object: '', present: 'jindega', habitual: 'jindegoi', remote_past: 'agindinvsvi', imperative: 'jinduga', infinitive: 'agindinvsdi'],
            [subject: 'SG2', object: '', present: 'hinadega', habitual: 'hinadegoi', remote_past: 'janadinvsvi', imperative: 'hinaduga', infinitive: 'janadinvsdi'],
            [subject: 'SG3', object: '', habitual: 'ganadegoi', imperative: 'hinaduga', infinitive: 'unadinvdi', present: 'ganadega', remote_past: 'unadinvsvi'],
            [subject: 'PL3', object: '', present: 'aninadega', habitual: 'aninadegoi', remote_past: 'uninadinvsvi', imperative: 'aninaduga', infinitive: 'uninadinvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idinadega', habitual: 'idinadegoi', remote_past: 'idinadinvsvi', imperative: 'idinaduga', infinitive: 'iginadinvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ganadega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganadega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinadega"
        "SG1" | "" | Tense.HABITUAL        | "tsinadegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginadinvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinadinvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginadinvdi"
        "SG2" | "" | Tense.PRESENT         | "hinadega"
        "SG2" | "" | Tense.HABITUAL        | "hinadegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janadinvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinadinvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "janadinvsdi"
        "SG3" | "" | Tense.PRESENT         | "ganadega"
        "SG3" | "" | Tense.HABITUAL        | "ganadegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unadinvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganadinvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "unadinvdi"
        "PL3" | "" | Tense.PRESENT         | "aninadega"
        "PL3" | "" | Tense.HABITUAL        | "aninadegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninadinvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninadinvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninadinvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinadega"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinadegoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "idinadinvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinadinvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginadinvsdi"
    }
}
