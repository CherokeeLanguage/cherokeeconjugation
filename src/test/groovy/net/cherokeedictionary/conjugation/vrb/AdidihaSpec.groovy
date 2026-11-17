// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72257 (entrya adidiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdidihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Getting Up",
        // tio 17Nov26: D6 verdict from the 2012 book (p.73): SG2/SG3 keep the present suffix
        // -ha (hadidiha/adidiha), but SG1 surfaces it as a glottal: gadidi'a. Whole-form
        // surface registered for the SG1 present (engine recomposes the glottal to -ha).
        // -- tio 17Nov26
        surfaceOverrides: [
            [tense: 'PRESENT', subject: 'SG1', obj: 'NONE', form: 'gadidia']
        ],
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadidia'],
            [subject: 'SG1', object: '', present: 'gadidia', habitual: 'gadidisgoi', remote_past: 'agwadidvhvi', imperative: 'gadida', infinitive: 'agwaditdi'],
            [subject: 'SG2', object: '', present: 'hadidiha', habitual: 'hadidisgoi', remote_past: 'jadidvhvi', imperative: 'hadida', infinitive: 'jaditdi'],
            [subject: 'SG3', object: '', habitual: 'adidisgoi', imperative: 'hadida', infinitive: 'uditdi', present: 'adidiha', remote_past: 'udidvhvi'],
            [subject: 'PL3', object: '', present: 'anadidiha', habitual: 'anadidisgoi', remote_past: 'unadidvhvi', imperative: 'anadida', infinitive: 'unaditdi'],
            [subject: 'PL1INCL', object: '', present: 'idadidiha', habitual: 'idadidisgoi', remote_past: 'igadidvhvi', imperative: 'idadida', infinitive: 'igaditdi']
        ]
    ]

    @Unroll
    def "conjugating Adidiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adidiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        // tio 17Nov26: SG1 present re-aligned to the book glottal form (D6).
        "SG1" | "" | Tense.PRESENT         | "gadidia"
        "SG1" | "" | Tense.HABITUAL        | "gadidisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquadidvhvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gadidvhvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquaditidi"
        "SG2" | "" | Tense.PRESENT         | "hadidiha"
        "SG2" | "" | Tense.HABITUAL        | "hadidisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsadidvhvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hadidvhvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsaditidi"
        "SG3" | "" | Tense.PRESENT         | "adidiha"
        "SG3" | "" | Tense.HABITUAL        | "adidisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udidvhvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "adidvhvi"
        "SG3" | "" | Tense.INFINITIVE      | "uditidi"
        "PL3" | "" | Tense.PRESENT         | "anadidiha"
        "PL3" | "" | Tense.HABITUAL        | "anadidisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadidvhvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anadidvhvi"
        "PL3" | "" | Tense.INFINITIVE      | "unaditidi"
        "PL1INCL" | "" | Tense.PRESENT         | "idadidiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idadidisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadidvhvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idadidvhvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igaditidi"
    }
}
