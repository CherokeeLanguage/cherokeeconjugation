package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlsosdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Aiming (43)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'galisosdiha', habitual: 'galisosdisgoi', remote_past: 'agwalsostanvi', imperative: 'galisosda', infinitive: 'agwalsosdohdi'],
            [subject: 'SG2', object: '', present: 'halsosdiha', habitual: 'halsosdisgoi', remote_past: 'jalsostanvi', imperative: 'halsosda', infinitive: 'jalsosdohdi'],
            [subject: 'SG3', object: '', present: 'alsosdiha', habitual: 'alsosdisgoi', remote_past: 'ulsostanvi', imperative: 'alsosda', infinitive: 'ulsosdohdi'],
            [subject: 'PL3', object: '', present: 'analsosdiha', habitual: 'analsosdisgoi', remote_past: 'unalsostanvi', imperative: 'analsosda', infinitive: 'unalsosdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idalsosdiha', habitual: 'idalsosdisgoi', remote_past: 'igalsostanvi', imperative: 'idalsosda', infinitive: 'igalsosdohdi']
        ]
    ]

    @Unroll
    def "conjugating Alsosdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alsosdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galisosdiha"
        "SG1" | "" | Tense.HABITUAL        | "galisosdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwalsostanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galisosda"
        "SG1" | "" | Tense.INFINITIVE      | "agwalsosdohdi"
        "SG2" | "" | Tense.PRESENT         | "halsosdiha"
        "SG2" | "" | Tense.HABITUAL        | "halsosdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalsostanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halsosda"
        "SG2" | "" | Tense.INFINITIVE      | "jalsosdohdi"
        "SG3" | "" | Tense.PRESENT         | "alsosdiha"
        "SG3" | "" | Tense.HABITUAL        | "alsosdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulsostanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alsosda"
        "SG3" | "" | Tense.INFINITIVE      | "ulsosdohdi"
        "PL3" | "" | Tense.PRESENT         | "analsosdiha"
        "PL3" | "" | Tense.HABITUAL        | "analsosdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalsostanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analsosda"
        "PL3" | "" | Tense.INFINITIVE      | "unalsosdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idalsosdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalsosdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalsostanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalsosda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalsosdohdi"
    }
}
