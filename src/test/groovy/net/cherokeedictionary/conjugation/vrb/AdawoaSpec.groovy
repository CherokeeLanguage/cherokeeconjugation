// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72240 (entrya adawoa) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdawoaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Swimming, Bathing",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadawoa'],
            [subject: 'SG1', object: '', present: 'gadawoa', habitual: 'gadawosgoi', remote_past: 'agwadawovi', imperative: 'gadawoja', infinitive: 'agwadawosdi'],
            [subject: 'SG2', object: '', present: 'hadawoa', habitual: 'hadawosgoi', remote_past: 'jadawovi', imperative: 'hadawoja', infinitive: 'jadawosdi'],
            [subject: 'SG3', object: '', habitual: 'adawosgoi', imperative: 'hadawoja', infinitive: 'udawosdi', present: 'adawoa', remote_past: 'udawovi'],
            [subject: 'PL3', object: '', present: 'anadawoa', habitual: 'anadawosgoi', remote_past: 'unadawovi', imperative: 'anadawoja', infinitive: 'unadawosdi'],
            [subject: 'PL1INCL', object: '', present: 'idadawoa', habitual: 'idadawosgoi', remote_past: 'igadawovi', imperative: 'idadawoja', infinitive: 'igadawosdi']
        ]
    ]

    @Unroll
    def "conjugating Adawoa (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adawoa", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadawoa"
        "SG1" | "" | Tense.HABITUAL        | "gadawosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadawovi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadawovi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadawosdi"
        "SG2" | "" | Tense.PRESENT         | "hadawoa"
        "SG2" | "" | Tense.HABITUAL        | "hadawosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadawovi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadawovi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadawosdi"
        "SG3" | "" | Tense.PRESENT         | "adawoa"
        "SG3" | "" | Tense.HABITUAL        | "adawosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udawovi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adawovi"
        "SG3" | "" | Tense.INFINITIVE      | "udawosdi"
        "PL3" | "" | Tense.PRESENT         | "anadawoa"
        "PL3" | "" | Tense.HABITUAL        | "anadawosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadawovi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadawovi"
        "PL3" | "" | Tense.INFINITIVE      | "unadawosdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadawoa"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadawosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadawovi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadawovi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadawosdi"
    }
}
