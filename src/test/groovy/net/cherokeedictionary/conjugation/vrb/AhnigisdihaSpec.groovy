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
            [subject: 'SG1', object: '', present: 'ganigisdiha', habitual: 'ganigisdisgoi', remote_past: 'agwahnigistanvi', imperative: 'ganigisda', infinitive: 'agwahnigisdohdi'],
            [subject: 'SG2', object: '', present: 'hahnigisdiha', habitual: 'hahnigisdisgoi', remote_past: 'jahnigistanvi', imperative: 'hahnigisda', infinitive: 'jahnigisdohdi'],
            [subject: 'SG3', object: '', present: 'ahnigisdiha', habitual: 'ahnigisdisgoi', remote_past: 'uhnigistanvi', imperative: 'ahnigisda', infinitive: 'uhnigisdohdi'],
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
        "SG1" | "" | Tense.REMOTE_PAST     | "agwahnigistanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganigisda"
        "SG1" | "" | Tense.INFINITIVE      | "agwahnigisdohdi"
        "SG2" | "" | Tense.PRESENT         | "hahnigisdiha"
        "SG2" | "" | Tense.HABITUAL        | "hahnigisdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahnigistanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hahnigisda"
        "SG2" | "" | Tense.INFINITIVE      | "jahnigisdohdi"
        "SG3" | "" | Tense.PRESENT         | "ahnigisdiha"
        "SG3" | "" | Tense.HABITUAL        | "ahnigisdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhnigistanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahnigisda"
        "SG3" | "" | Tense.INFINITIVE      | "uhnigisdohdi"
        "PL3" | "" | Tense.PRESENT         | "anahnigisdiha"
        "PL3" | "" | Tense.HABITUAL        | "anahnigisdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unahnigistanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anahnigisda"
        "PL3" | "" | Tense.INFINITIVE      | "unahnigisdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idahnigisdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idahnigisdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igahnigistanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idahnigisda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igahnigisdohdi"
    }
}
