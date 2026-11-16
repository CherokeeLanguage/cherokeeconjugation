// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72385 (entrya ahnigisdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhnigisdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Starting It",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'ganigisdiha'],
            [subject: 'SG1', object: '', present: 'ganigisdiha', habitual: 'ganigisdisgoi', remote_past: 'agwahnigistanvi', imperative: 'ganigisda', infinitive: 'agwahnigisdohdi'],
            [subject: 'SG2', object: '', present: 'hahnigisdiha', habitual: 'hahnigisdisgoi', remote_past: 'jahnigistanvi', imperative: 'hahnigisda', infinitive: 'jahnigisdohdi'],
            [subject: 'SG3', object: '', habitual: 'ahnigisdisgoi', imperative: 'hahnigisda', infinitive: 'uhnigisdohdi', present: 'ahnigisdiha', remote_past: 'uhnigistanvi'],
            [subject: 'PL3', object: '', present: 'anahnigisdiha', habitual: 'anahnigisdisgoi', remote_past: 'unahnigistanvi', imperative: 'anahnigisda', infinitive: 'unahnigisdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idahnigisdiha', habitual: 'idahnigisdisgoi', remote_past: 'igahnigistanvi', imperative: 'idahnigisda', infinitive: 'igahnigisdohdi']
        ]
    ]

    @Unroll
    def "conjugating Ahnigisdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahnigisdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "ganigisdiha"
        "SG1" | "" | Tense.HABITUAL        | "ganigisdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquanigistanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganigistanvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquanigisdodi"
        "SG2" | "" | Tense.PRESENT         | "hanigisdiha"
        "SG2" | "" | Tense.HABITUAL        | "hanigisdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanigistanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hanigistanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanigisdodi"
        "SG3" | "" | Tense.PRESENT         | "anigisdiha"
        "SG3" | "" | Tense.HABITUAL        | "anigisdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unigistanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anigistanvi"
        "SG3" | "" | Tense.INFINITIVE      | "unigisdodi"
        "PL3" | "" | Tense.PRESENT         | "ananigisdiha"
        "PL3" | "" | Tense.HABITUAL        | "ananigisdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unanigistanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "ananigistanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unanigisdodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idanigisdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idanigisdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iganigistanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idanigistanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iganigisdodi"
    }
}
