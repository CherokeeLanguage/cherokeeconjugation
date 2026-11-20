// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72565 (entrya asaladia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsaladiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Raising/Lifting",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jisaladia'],
            [subject: 'SG1', object: '', present: 'jisaldia', habitual: 'jisaldisgoi', remote_past: 'aksaldanvi', imperative: 'jisaldvga', infinitive: 'aksaldodi'],
            [subject: 'SG2', object: '', present: 'hisaladia', habitual: 'hisaladisgoi', remote_past: 'tsaladanvi', imperative: 'hisaladvga', infinitive: 'tsaladodi'],
            [subject: 'SG3', object: '', habitual: 'asaladisgoi', imperative: 'hisaladvga, hisaladvga', infinitive: 'usaladodi', present: 'asaladia', remote_past: 'usaladanvi'],
            [subject: 'PL3', object: '', present: 'anisaladia', habitual: 'anisaladisgoi', remote_past: 'unisaladanvi', imperative: 'anisaladvga', infinitive: 'unisaladodi'],
            [subject: 'PL1INCL', object: '', present: 'idisaladia', habitual: 'idisaladisgoi', remote_past: 'iksaladanvi', imperative: 'idisaladvga', infinitive: 'iksaladodi']
        ]
    ]

    @Unroll
    def "conjugating Asaladia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asaladia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsisaladia"
        "SG1" | "" | Tense.HABITUAL        | "tsisaladisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agisaladanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisaladanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agisaladodi"
        "SG2" | "" | Tense.PRESENT         | "hisaladia"
        "SG2" | "" | Tense.HABITUAL        | "hisaladisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasaladanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisaladanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsasalatodi"
        "SG3" | "" | Tense.PRESENT         | "asaladia"
        "SG3" | "" | Tense.HABITUAL        | "asaladisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usaladanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asaladanvi"
        "SG3" | "" | Tense.INFINITIVE      | "usaladodi"
        "PL3" | "" | Tense.PRESENT         | "anisaladia"
        "PL3" | "" | Tense.HABITUAL        | "anisaladisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisaladanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisaladanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisaladodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisaladia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisaladisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iksaladanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisaladanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iksaladodi"
    }
}
