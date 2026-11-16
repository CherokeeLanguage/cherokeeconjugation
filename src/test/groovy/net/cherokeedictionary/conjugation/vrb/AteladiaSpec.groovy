// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72667 (entrya ateladia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AteladiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Joining (59)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadeladia'],
            [subject: 'SG1', object: '', present: 'gadeladia', habitual: 'gadeladisgoi', remote_past: 'agwateladvi', imperative: 'gadelada', infinitive: 'agwateladisdi'],
            [subject: 'SG2', object: '', present: 'hateladia', habitual: 'hateladisgoi', remote_past: 'jateladvi', imperative: 'hatelada', infinitive: 'jateladisdi'],
            [subject: 'SG3', object: '', habitual: 'ateladisgoi', imperative: 'hatelada', infinitive: 'uteladisdi', present: 'ateladia', remote_past: 'uteladvi'],
            [subject: 'PL3', object: '', present: 'anateladia', habitual: 'anatelidisgoi', remote_past: 'unateladvi', imperative: 'anatelada', infinitive: 'unateladisdi'],
            [subject: 'PL1INCL', object: '', present: 'idateladia', habitual: 'idatelidisgoi', remote_past: 'igateladvi', imperative: 'idatelada', infinitive: 'igateladisdi']
        ]
    ]

    @Unroll
    def "conjugating Ateladia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ateladia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gateladia"
        "SG1" | "" | Tense.HABITUAL        | "gateladisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquateladvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gateladvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquateladisdi"
        "SG2" | "" | Tense.PRESENT         | "hateladia"
        "SG2" | "" | Tense.HABITUAL        | "hateladisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsateladvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hateladvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsateladisdi"
        "SG3" | "" | Tense.PRESENT         | "ateladia"
        "SG3" | "" | Tense.HABITUAL        | "ateladisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uteladvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ateladvi"
        "SG3" | "" | Tense.INFINITIVE      | "uteladisdi"
        "PL3" | "" | Tense.PRESENT         | "anateladia"
        "PL3" | "" | Tense.HABITUAL        | "anateladisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unateladvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anateladvi"
        "PL3" | "" | Tense.INFINITIVE      | "unateladisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idateladia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idateladisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igateladvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idateladvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igateladisdi"
    }
}
