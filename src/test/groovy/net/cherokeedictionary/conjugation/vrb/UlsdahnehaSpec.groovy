package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UlsdahnehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Happening",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agwalsdahneha', habitual: 'agwalsdahnehoi', remote_past: 'agwalsdahnelvi', imperative: 'agwalsdasi', infinitive: 'agwalsdahnehdi'],
            [subject: 'SG2', object: '', present: 'jalsdahneha', habitual: 'jalsdahnehoi', remote_past: 'jalsdahnelvi', imperative: 'jalsdasi', infinitive: 'jalsdahnehdi'],
            [subject: 'SG3', object: '', present: 'ulsdahneha', habitual: 'ulsdahnehoi', remote_past: 'ulsdahnelvi', imperative: 'ulsdasi', infinitive: 'ulsdahnehdi'],
            [subject: 'PL3', object: '', present: 'unalsdahneha', habitual: 'unalsdahnehoi', remote_past: 'unalsdahnelvi', imperative: 'unalsdasi', infinitive: 'unalsdahnehdi'],
            [subject: 'PL1INCL', object: '', present: 'igalsdahneha', habitual: 'igalsdahnehoi', remote_past: 'igalsdahnelvi', imperative: 'igalsdasi', infinitive: 'igalsdahnehdi']
        ]
    ]

    @Unroll
    def "conjugating Ulsdahneha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ulsdahneha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwalsdahneha"
        "SG1" | "" | Tense.HABITUAL        | "agwalsdahnehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwalsdahnelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwalsdasi"
        "SG1" | "" | Tense.INFINITIVE      | "agwalsdahnehdi"
        "SG2" | "" | Tense.PRESENT         | "jalsdahneha"
        "SG2" | "" | Tense.HABITUAL        | "jalsdahnehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalsdahnelvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jalsdasi"
        "SG2" | "" | Tense.INFINITIVE      | "jalsdahnehdi"
        "SG3" | "" | Tense.PRESENT         | "ulsdahneha"
        "SG3" | "" | Tense.HABITUAL        | "ulsdahnehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulsdahnelvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ulsdasi"
        "SG3" | "" | Tense.INFINITIVE      | "ulsdahnehdi"
        "PL3" | "" | Tense.PRESENT         | "unalsdahneha"
        "PL3" | "" | Tense.HABITUAL        | "unalsdahnehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalsdahnelvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unalsdasi"
        "PL3" | "" | Tense.INFINITIVE      | "unalsdahnehdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igalsdahneha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igalsdahnehoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalsdahnelvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igalsdasi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalsdahnehdi"
    }
}
