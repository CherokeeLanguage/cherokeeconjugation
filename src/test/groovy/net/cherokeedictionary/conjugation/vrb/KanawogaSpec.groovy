// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73475 (entrya kanawoga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KanawogaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Cold (139)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinawoga'],
            [subject: 'SG1', object: '', present: 'jinawoga', habitual: 'jinawogoi', remote_past: 'agihnawojvi', imperative: 'jinawogi', infinitive: 'agihnawosdi'],
            [subject: 'SG2', object: '', present: 'hinawoga', habitual: 'hinawogoi', remote_past: 'jahnawojvi', imperative: 'hihnawogi', infinitive: 'jahnawosdi'],
            [subject: 'SG3', object: '', habitual: 'kanawogoi', imperative: 'hihnawogi', infinitive: 'uhnawosdi', present: 'kanawoga', remote_past: 'uhnawojvi'],
            [subject: 'PL3', object: '', present: 'aninawoga', habitual: 'aninawogoi', remote_past: 'unihnawojvi', imperative: 'anihnawogi', infinitive: 'unihnawosdi'],
            [subject: 'PL1INCL', object: '', present: 'idinawoga', habitual: 'idinawogoi', remote_past: 'igihnawojvi', imperative: 'idihnawogi', infinitive: 'igihnawosdi']
        ]
    ]

    @Unroll
    def "conjugating Kanawoga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kanawoga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinawoga"
        "SG1" | "" | Tense.HABITUAL        | "tsinawogoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginawotsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinawotsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginawosdi"
        "SG2" | "" | Tense.PRESENT         | "hinawoga"
        "SG2" | "" | Tense.HABITUAL        | "hinawogoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanawotsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinawotsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanawosdi"
        "SG3" | "" | Tense.PRESENT         | "kanawoga"
        "SG3" | "" | Tense.HABITUAL        | "kanawogoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unawotsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganawotsvi"
        "SG3" | "" | Tense.INFINITIVE      | "unawosdi"
        "PL3" | "" | Tense.PRESENT         | "aninawoga"
        "PL3" | "" | Tense.HABITUAL        | "aninawogoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninawotsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninawotsvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninawosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinawoga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinawogoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginawotsvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinawotsvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginawosdi"
    }
}
