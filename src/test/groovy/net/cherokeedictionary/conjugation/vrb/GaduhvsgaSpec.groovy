// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73005 (entrya gaduhvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GaduhvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Baking (93)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiduhvsga'],
            [subject: 'SG1', object: '', present: 'jiduhvsga', habitual: 'jiduhvsgoi', remote_past: 'agiwaduhnvi', imperative: 'jiduhvga', infinitive: 'agiwatdi'],
            [subject: 'SG2', object: '', present: 'hiduhvsga', habitual: 'hiduhvsgoi', remote_past: 'jawaduhnvi', imperative: 'hiduhvga', infinitive: 'jawatdi'],
            [subject: 'SG3', object: '', habitual: 'gaduhvsgoi', imperative: 'hiduhvga', infinitive: 'uwatdi', present: 'gaduhvsga', remote_past: 'uwaduhnvi'],
            [subject: 'PL3', object: '', present: 'aniduhvsga', habitual: 'aniduhvsgoi', remote_past: 'uniwaduhnvi', imperative: 'aniduhvga', infinitive: 'uniwatdi'],
            [subject: 'PL1INCL', object: '', present: 'ididuhvsga', habitual: 'ididuhvsgoi', remote_past: 'igiwaduhnvi', imperative: 'ididuhvga', infinitive: 'igiwatdi']
        ]
    ]

    @Unroll
    def "conjugating Gaduhvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gaduhvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsiduhvsga"
        "SG1" | "" | Tense.HABITUAL        | "tsiduhvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwadunvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwadunvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwatidi"
        "SG2" | "" | Tense.PRESENT         | "hiduhvsga"
        "SG2" | "" | Tense.HABITUAL        | "hiduhvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawadunvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwadunvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawatidi"
        "SG3" | "" | Tense.PRESENT         | "gaduhvsga"
        "SG3" | "" | Tense.HABITUAL        | "gaduhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwadunvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawadunvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwatidi"
        "PL3" | "" | Tense.PRESENT         | "aniduhvsga"
        "PL3" | "" | Tense.HABITUAL        | "aniduhvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwadunvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwadunvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwatidi"
        "PL1INCL" | "" | Tense.PRESENT         | "ididuhvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "ididuhvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiwadunvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiwadunvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwatidi"
    }
}
