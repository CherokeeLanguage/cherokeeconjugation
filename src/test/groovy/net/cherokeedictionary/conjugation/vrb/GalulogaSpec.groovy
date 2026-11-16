// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73081 (entrya galuloga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GalulogaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Lacking / Missing (It is)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiluloga'],
            [subject: 'SG1', object: '', present: 'jiluloga', habitual: 'jilulogoi', remote_past: 'agilulojvi', imperative: 'jilulogi', infinitive: 'agilulosdi'],
            [subject: 'SG2', object: '', present: 'hiluloga', habitual: 'hilulogoi', remote_past: 'jalulojvi', imperative: 'hilulogi', infinitive: 'jalulosdi'],
            [subject: 'SG3', object: '', habitual: 'galulogoi', imperative: 'hilulogi', infinitive: 'ululosdi', present: 'galuloga', remote_past: 'ululojvi'],
            [subject: 'PL3', object: '', present: 'aniluloga', habitual: 'anilulogoi', remote_past: 'unilulojvi', imperative: 'anilulogi', infinitive: 'unilulosdi'],
            [subject: 'PL1INCL', object: '', present: 'idiluloga', habitual: 'idilugoi', remote_past: 'igilulojvi', imperative: 'idilulogi', infinitive: 'igilulosdi']
        ]
    ]

    @Unroll
    def "conjugating Galuloga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Galuloga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsiluloga"
        "SG1" | "" | Tense.HABITUAL        | "tsilulogoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agilulotsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsilulotsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agilulosdi"
        "SG2" | "" | Tense.PRESENT         | "hiluloga"
        "SG2" | "" | Tense.HABITUAL        | "hilulogoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalulotsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hilulotsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsalulosdi"
        "SG3" | "" | Tense.PRESENT         | "galuloga"
        "SG3" | "" | Tense.HABITUAL        | "galulogoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ululotsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "galulotsvi"
        "SG3" | "" | Tense.INFINITIVE      | "ululosdi"
        "PL3" | "" | Tense.PRESENT         | "aniluloga"
        "PL3" | "" | Tense.HABITUAL        | "anilulogoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unilulotsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anilulotsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unilulosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idiluloga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idilulogoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igilulotsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idilulotsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igilulosdi"
    }
}
