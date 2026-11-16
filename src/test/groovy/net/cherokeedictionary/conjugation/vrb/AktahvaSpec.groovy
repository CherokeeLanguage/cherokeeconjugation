// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72466 (entrya aktahva) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AktahvaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Turning Back / S/hes Turning",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gagatahva'],
            [subject: 'SG1', object: '', present: 'gagatahva', habitual: 'gagatahvsgoi', remote_past: 'agwaktahvsvi', imperative: 'gagatahvna', infinitive: 'agwaktahvsdi'],
            [subject: 'SG2', object: '', present: 'haktahva', habitual: 'haktahvsgoi', remote_past: 'jaktahvsvi', imperative: 'haktahvna', infinitive: 'jaktahvsdi'],
            [subject: 'SG3', object: '', habitual: 'aktahvsgoi', imperative: 'haktahvna', infinitive: 'uktahvsdi', present: 'aktahva', remote_past: 'uktahvsvi'],
            [subject: 'PL3', object: '', present: 'anaktahva', habitual: 'anaktahvsgoi', remote_past: 'unaktahvsvi', imperative: 'anaktahvna', infinitive: 'unaktahvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idaktahva', habitual: 'idaktahvsgoi', remote_past: 'igaktahvsvi', imperative: 'idaktahvna', infinitive: 'igaktahvsdi']
        ]
    ]

    @Unroll
    def "conjugating Aktahva (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Aktahva", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gagitahva"
        "SG1" | "" | Tense.HABITUAL        | "gagitahvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquagitahvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gagitahvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquagitahvsdi"
        "SG2" | "" | Tense.PRESENT         | "hagitahva"
        "SG2" | "" | Tense.HABITUAL        | "hagitahvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsagitahvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hagitahvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsagitahvsdi"
        "SG3" | "" | Tense.PRESENT         | "agitahva"
        "SG3" | "" | Tense.HABITUAL        | "agitahvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugitahvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "agitahvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugitahvsdi"
        "PL3" | "" | Tense.PRESENT         | "anagitahva"
        "PL3" | "" | Tense.HABITUAL        | "anagitahvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unagitahvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anagitahvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unagitahvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idagitahva"
        "PL1INCL" | "" | Tense.HABITUAL        | "idagitahvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igagitahvsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idagitahvsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igagitahvsdi"
    }
}
