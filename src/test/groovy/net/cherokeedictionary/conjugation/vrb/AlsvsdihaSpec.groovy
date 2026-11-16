// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72536 (entrya alsvsdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlsvsdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Smelling It",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'galisvsdiha'],
            [subject: 'SG1', object: '', present: 'galisvsdiha', habitual: 'galisvsdisgoi', remote_past: 'agwalsvstanvi', imperative: 'galisvsda', infinitive: 'agwalsvsdohdi'],
            [subject: 'SG2', object: '', present: 'halsvsdiha', habitual: 'halsvsdisgoi', remote_past: 'jalsvstanvi', imperative: 'halsvsda', infinitive: 'jalsvsdohdi'],
            [subject: 'SG3', object: '', habitual: 'alsvsdisgoi', imperative: 'halsvsda', infinitive: 'ulsvsdohdi', present: 'alsvsdiha', remote_past: 'ulsvstanvi'],
            [subject: 'PL3', object: '', present: 'analsvsdiha', habitual: 'analsvsdisgoi', remote_past: 'unalsvstanvi', imperative: 'analsvsda', infinitive: 'unalsvsdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idalsvsdiha', habitual: 'idalsvsdisgoi', remote_past: 'igalsvstanvi', imperative: 'idalsvsda', infinitive: 'igalsvsdohdi']
        ]
    ]

    @Unroll
    def "conjugating Alsvsdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alsvsdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galisvsdiha"
        "SG1" | "" | Tense.HABITUAL        | "galisvsdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aqualisvstanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galisvstanvi"
        "SG1" | "" | Tense.INFINITIVE      | "aqualisvsdodi"
        "SG2" | "" | Tense.PRESENT         | "halisvsdiha"
        "SG2" | "" | Tense.HABITUAL        | "halisvsdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsalisvstanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halisvstanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsalisvsdodi"
        "SG3" | "" | Tense.PRESENT         | "alisvsdiha"
        "SG3" | "" | Tense.HABITUAL        | "alisvsdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulisvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alisvstanvi"
        "SG3" | "" | Tense.INFINITIVE      | "ulisvsdodi"
        "PL3" | "" | Tense.PRESENT         | "analisvsdiha"
        "PL3" | "" | Tense.HABITUAL        | "analisvsdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalisvstanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analisvstanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unalisvsdodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idalisvsdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalisvsdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalisvstanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalisvstanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalisvsdodi"
    }
}
