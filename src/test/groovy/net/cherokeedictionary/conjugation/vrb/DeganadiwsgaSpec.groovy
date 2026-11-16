// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72821 (entrya deganadiwsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DeganadiwsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Crossing It",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'dejinadiwsga'],
            [subject: 'SG1', object: '', present: 'dejinadiwsga', habitual: 'dejinadiwsgoi', remote_past: 'daginadiwsvi', imperative: 'dijinadihwi', infinitive: 'diginadihwisdi'],
            [subject: 'SG2', object: '', present: 'dehinadiwsga', habitual: 'dehinadiwsgoi', remote_past: 'dejanadiwsvi', imperative: 'tinadihwi', infinitive: 'dijanadihwisdi'],
            [subject: 'SG3', object: '', habitual: 'deganadiwsgoi', imperative: 'tinadihwi', infinitive: 'junadihwisdi', present: 'deganadiwsga', remote_past: 'dunadiwsvi'],
            [subject: 'PL3', object: '', present: 'daninadiwsga', habitual: 'daninadiwsgoi', remote_past: 'duninadiwsvi', imperative: 'dininadihwi', infinitive: 'juninadihwisdi'],
            [subject: 'PL1INCL', object: '', present: 'dedinadiwsga', habitual: 'dedinadiwsgoi', remote_past: 'deginadiwsvi', imperative: 'didinadihwi', infinitive: 'diginadihwisdi']
        ]
    ]

    @Unroll
    def "conjugating Deganadiwsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Deganadiwsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinadiwvsga"
        "SG1" | "" | Tense.HABITUAL        | "tsinadiwvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginadiwvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinadiwvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginadiwisdi"
        "SG2" | "" | Tense.PRESENT         | "hinadiwvsga"
        "SG2" | "" | Tense.HABITUAL        | "hinadiwvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanadiwvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinadiwvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanadiwisdi"
        "SG3" | "" | Tense.PRESENT         | "deganadiwvsga"
        "SG3" | "" | Tense.HABITUAL        | "deganadiwvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unadiwvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganadiwvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "unadiwisdi"
        "PL3" | "" | Tense.PRESENT         | "aninadiwvsga"
        "PL3" | "" | Tense.HABITUAL        | "aninadiwvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninadiwvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninadiwvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninadiwisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinadiwvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinadiwvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginadiwvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinadiwvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginadiwisdi"
    }
}
