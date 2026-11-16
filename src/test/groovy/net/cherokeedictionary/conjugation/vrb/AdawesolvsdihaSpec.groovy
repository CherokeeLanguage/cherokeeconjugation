// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72238 (entrya adawesolvsdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdawesolvsdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Resting",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadawesolvsdiha'],
            [subject: 'SG1', object: '', present: 'gadawesolvsdiha', habitual: 'gadawesolvsdisgoi', remote_past: 'agwadawesolvstanvi', imperative: 'gadawesolvsda', infinitive: 'agwadawesolvsdohdi'],
            [subject: 'SG2', object: '', present: 'hadawesolvsdiha', habitual: 'hadawesolvsdisgoi', remote_past: 'jadawesolvstanvi', imperative: 'hadawesolvsda', infinitive: 'jadawesolvsdohdi'],
            [subject: 'SG3', object: '', habitual: 'adawesolvsdisgoi', imperative: 'hadawesolvsda', infinitive: 'udawesolvsdohdi', present: 'adawesolvsdiha', remote_past: 'udawesolvstanvi'],
            [subject: 'PL3', object: '', present: 'anadawesolvsdiha', habitual: 'anadawesolvsdisgoi', remote_past: 'unadawesolvstanvi', imperative: 'anadawesolvsda', infinitive: 'unadawesolvsdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idadawesolvsdiha', habitual: 'idadawesolvsdisgoi', remote_past: 'igadawesolvstanvi', imperative: 'idadawesolvsda', infinitive: 'igadawesolvsdohdi']
        ]
    ]

    @Unroll
    def "conjugating Adawesolvsdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adawesolvsdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadawesolvsdiha"
        "SG1" | "" | Tense.HABITUAL        | "gadawesolvsdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadawesolvstanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadawesolvstanvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquadawesolvsdodi"
        "SG2" | "" | Tense.PRESENT         | "hadawesolvsdiha"
        "SG2" | "" | Tense.HABITUAL        | "hadawesolvsdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadawesolvstanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadawesolvstanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsadawesolvsdodi"
        "SG3" | "" | Tense.PRESENT         | "adawesolvsdiha"
        "SG3" | "" | Tense.HABITUAL        | "adawesolvsdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udawesolvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adawesolvstanvi"
        "SG3" | "" | Tense.INFINITIVE      | "udawesolvsdodi"
        "PL3" | "" | Tense.PRESENT         | "anadawesolvsdiha"
        "PL3" | "" | Tense.HABITUAL        | "anadawesolvsdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadawesolvstanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadawesolvstanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unadawesolvsdodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadawesolvsdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadawesolvsdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadawesolvstanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadawesolvstanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadawesolvsdodi"
    }
}
