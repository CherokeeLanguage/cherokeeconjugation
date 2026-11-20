// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72429) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72429 (entrya ajavsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AjavsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he is Getting in a Car, Box, Etc.",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gatsavsga'],
            [subject: 'SG1', object: '', present: 'gatsavsga', habitual: 'gajavsgoi', remote_past: 'agwajanvi', imperative: 'gajavga', infinitive: 'agwajodi'],
            [subject: 'SG2', object: '', present: 'hajavsga', habitual: 'hajavsgoi', remote_past: 'jajanvi', imperative: 'hajavga', infinitive: 'jajodi'],
            [subject: 'SG3', object: '', habitual: 'atsavsgoi', imperative: 'hatsavga', infinitive: 'ujodi', present: 'atsavsga', remote_past: 'utsanvi'],
            [subject: 'PL3', object: '', present: 'anajavsga', habitual: 'anajavsgoi', remote_past: 'unajanvi', imperative: 'anajavga', infinitive: 'unajodi'],
            [subject: 'PL1INCL', object: '', present: 'idajavsga', habitual: 'idajavsgoi', remote_past: 'igajanvi', imperative: 'idajavga', infinitive: 'igajodi']
        ]
    ]

    @Unroll
    def "conjugating Ajavsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ajavsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gatsavsga"
        "SG1" | "" | Tense.HABITUAL        | "gajavsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwajanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatsanvi"
        // tio 18Nov26: INFINITIVE WIRED -- the earlier "ABSENT from the 2012
        // book" reading was WRONG (user glottal-apostrophe ruling): Aja'vsga is
        // Verb p.57 ("S/he is Getting in a Car, Box, Etc.") with a full box
        // whose infinitive column IS attested (agwajodi / jajodi / ujodi /
        // unajodi / igajodi); the yaml had dropped the glottal apostrophe
        // (aja'vsga -> "ajavsga"). The spec keeps the CED-canonical ts-shapes
        // (id 72429 ᎠᏣᎥᏍᎦ = atsavsga; Feeling's book writes ja'-/jv where CED
        // writes tsa -- orthography variance, parse-back convention keeps CED).
        "SG1" | "" | Tense.INFINITIVE      | "agwajodi"
        "SG2" | "" | Tense.PRESENT         | "hajavsga"
        "SG2" | "" | Tense.HABITUAL        | "hajavsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jajanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatsanvi"
        "SG2" | "" | Tense.INFINITIVE      | "jajodi"
        "SG3" | "" | Tense.PRESENT         | "atsavsga"
        "SG3" | "" | Tense.HABITUAL        | "atsavsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utsanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atsanvi"
        "SG3" | "" | Tense.INFINITIVE      | "ujodi"
        "PL3" | "" | Tense.PRESENT         | "anajavsga"
        "PL3" | "" | Tense.HABITUAL        | "anajavsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unajanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anatsanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unajodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idajavsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idajavsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igajanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idatsanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igajodi"
    }
}
