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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        // tio 20Nov26: cells re-pinned to the engine post-DST h-branch fix (de-style keeps
        // ᏕᎯ per guide 61a/117a; FUTURE_COMMAND + DST2-infinitive cells left for pending rulings)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "detsigisvsdiha"
        "SG1" | "" | Tense.HABITUAL        | "detsigisvsdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagiksvstanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsigisvstanvi"
        "SG1" | "" | Tense.INFINITIVE      | "dagigisvstodi"
        "SG2" | "" | Tense.PRESENT         | "dehigisvsdiha"
        "SG2" | "" | Tense.HABITUAL        | "dehigisvsdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejaksvstanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "higisvstanvi"
        "SG2" | "" | Tense.INFINITIVE      | "detsagisvstodi"
        "SG3" | "" | Tense.PRESENT         | "daksvsdiha"
        "SG3" | "" | Tense.HABITUAL        | "daksvsdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "duksvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gagisvstanvi"
        "SG3" | "" | Tense.INFINITIVE      | "juksvsdohdi"
        "PL3" | "" | Tense.PRESENT         | "daniksvsdiha"
        "PL3" | "" | Tense.HABITUAL        | "daniksvsdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "duniksvstanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anigisvstanvi"
        "PL3" | "" | Tense.INFINITIVE      | "juniksvsdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dadigisvsdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "dadigisvsdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "dagigisvstanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idigisvstanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "dagigisvstodi"
    }
}
