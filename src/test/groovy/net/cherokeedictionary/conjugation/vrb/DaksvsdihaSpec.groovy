// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72770 (entrya daksvsdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DaksvsdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Hes Making/Blowing Smoke (71)*",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'dejigasvsdiha'],
            [subject: 'SG1', object: '', present: 'dejigasvsdiha', habitual: 'dejigasvsdisgoi', remote_past: 'dagiksvstanvi', imperative: 'dijiksvsda', infinitive: 'digiksvsdohdi'],
            [subject: 'SG2', object: '', present: 'dehiksvsdiha', habitual: 'dehiksvsdisgoi', remote_past: 'dejaksvstanvi', imperative: 'tiksvsda', infinitive: 'dijaksvsdohdi'],
            [subject: 'SG3', object: '', habitual: 'daksvsdisgoi', imperative: 'tiksvsda', infinitive: 'juksvsdohdi', present: 'daksvsdiha', remote_past: 'duksvstanvi'],
            [subject: 'PL3', object: '', present: 'daniksvsdiha', habitual: 'daniksvsdisgoi', remote_past: 'duniksvstanvi', imperative: 'diniksvsda', infinitive: 'juniksvsdohdi'],
            [subject: 'PL1INCL', object: '', present: 'dediksvsdiha', habitual: 'dediksvsdisgoi', remote_past: 'degiksvstanvi', imperative: 'didiksvsda', infinitive: 'digiksvsdohdi']
        ]
    ]

    @Unroll
    def "conjugating Daksvsdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Daksvsdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsigisvsdiha"
        "SG1" | "" | Tense.HABITUAL        | "tsigisvsdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agigisvstanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsigisvstanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agigisvsdodi"
        "SG2" | "" | Tense.PRESENT         | "higisvsdiha"
        "SG2" | "" | Tense.HABITUAL        | "higisvsdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsagisvstanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "higisvstanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsagisvsdodi"
        "SG3" | "" | Tense.PRESENT         | "dagisvsdiha"
        "SG3" | "" | Tense.HABITUAL        | "dagisvsdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ugisvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gagisvstanvi"
        "SG3" | "" | Tense.INFINITIVE      | "ugisvsdodi"
        "PL3" | "" | Tense.PRESENT         | "anigisvsdiha"
        "PL3" | "" | Tense.HABITUAL        | "anigisvsdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unigisvstanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anigisvstanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unigisvsdodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idigisvsdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idigisvsdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igigisvstanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idigisvstanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igigisvsdodi"
    }
}
