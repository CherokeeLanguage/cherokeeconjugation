package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlsvsdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Smelling It",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'galisvsdiha', habitual: 'galisvsdisgoi', remote_past: 'agwalsvstanvi', imperative: 'galisvsda', infinitive: 'agwalsvsdohdi'],
            [subject: 'SG2', object: '', present: 'halsvsdiha', habitual: 'halsvsdisgoi', remote_past: 'jalsvstanvi', imperative: 'halsvsda', infinitive: 'jalsvsdohdi'],
            [subject: 'SG3', object: '', present: 'alsvsdiha', habitual: 'alsvsdisgoi', remote_past: 'ulsvstanvi', imperative: 'alsvsda', infinitive: 'ulsvsdohdi'],
            [subject: 'PL3', object: '', present: 'analsvsdiha', habitual: 'analsvsdisgoi', remote_past: 'unalsvstanvi', imperative: 'analsvsda', infinitive: 'unalsvsdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idalsvsdiha', habitual: 'idalsvsdisgoi', remote_past: 'igalsvstanvi', imperative: 'idalsvsda', infinitive: 'igalsvsdohdi']
        ]
    ]

    @Unroll
    def "conjugating Alsvsdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alsvsdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galisvsdiha"
        "SG1" | "" | Tense.HABITUAL        | "galisvsdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwalsvstanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galisvsda"
        "SG1" | "" | Tense.INFINITIVE      | "agwalsvsdohdi"
        "SG2" | "" | Tense.PRESENT         | "halsvsdiha"
        "SG2" | "" | Tense.HABITUAL        | "halsvsdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalsvstanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halsvsda"
        "SG2" | "" | Tense.INFINITIVE      | "jalsvsdohdi"
        "SG3" | "" | Tense.PRESENT         | "alsvsdiha"
        "SG3" | "" | Tense.HABITUAL        | "alsvsdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulsvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alsvsda"
        "SG3" | "" | Tense.INFINITIVE      | "ulsvsdohdi"
        "PL3" | "" | Tense.PRESENT         | "analsvsdiha"
        "PL3" | "" | Tense.HABITUAL        | "analsvsdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalsvstanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analsvsda"
        "PL3" | "" | Tense.INFINITIVE      | "unalsvsdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idalsvsdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalsvsdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalsvstanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalsvsda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalsvsdohdi"
    }
}
