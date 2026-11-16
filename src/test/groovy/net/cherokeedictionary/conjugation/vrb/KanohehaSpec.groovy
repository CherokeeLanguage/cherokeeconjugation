// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73493 (entrya kanoheha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KanohehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Telling",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jinoheha'],
            [subject: 'SG1', object: '', present: 'jinoheha', habitual: 'jinohesgoi', remote_past: 'akihnohehlvi', imperative: 'jinohvla', infinitive: 'akihnohehdi'],
            [subject: 'SG2', object: '', present: 'hinoheha', habitual: 'hinohesgoi', remote_past: 'jahnohehlvi', imperative: 'hihnohvla', infinitive: 'jahnohehdi'],
            [subject: 'SG3', object: '', habitual: 'kanohesgoi', imperative: 'hihnohvla', infinitive: 'uhnohehdi', present: 'kanoheha', remote_past: 'uhnohehlvi'],
            [subject: 'PL3', object: '', present: 'aninoheha', habitual: 'aninohesgoi', remote_past: 'unihnohehlvi', imperative: 'anihnohvla', infinitive: 'unihnohehdi'],
            [subject: 'PL1INCL', object: '', present: 'idinoheha', habitual: 'idinohesgoi', remote_past: 'igihnohehlvi', imperative: 'idihnohvla', infinitive: 'igihnohehdi']
        ]
    ]

    @Unroll
    def "conjugating Kanoheha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kanoheha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsinoheha"
        "SG1" | "" | Tense.HABITUAL        | "tsinohesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginohetlvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsinohetlvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginohedi"
        "SG2" | "" | Tense.PRESENT         | "hinoheha"
        "SG2" | "" | Tense.HABITUAL        | "hinohesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanohetlvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinohetlvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanohedi"
        "SG3" | "" | Tense.PRESENT         | "kanoheha"
        "SG3" | "" | Tense.HABITUAL        | "kanohesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unohetlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganohetlvi"
        "SG3" | "" | Tense.INFINITIVE      | "unohedi"
        "PL3" | "" | Tense.PRESENT         | "aninoheha"
        "PL3" | "" | Tense.HABITUAL        | "aninohesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninohetlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninohetlvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninohedi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinoheha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinohesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginohetlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinohetlvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginohedi"
    }
}
