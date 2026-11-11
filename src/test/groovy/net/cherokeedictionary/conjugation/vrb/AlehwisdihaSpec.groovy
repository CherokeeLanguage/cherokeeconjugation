package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlehwisdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Stopping (He/It Is)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'galewisdiha', habitual: 'galewisdisgoi', remote_past: 'agwalehwistanvi', imperative: 'galewisda', infinitive: 'agwalehwisdohdi'],
            [subject: 'SG2', object: '', present: 'halehwisdiha', habitual: 'halehwisdisgoi', remote_past: 'jalehwistanvi', imperative: 'halehwisda', infinitive: 'jalehwisdohdi'],
            [subject: 'SG3', object: '', present: 'alehwisdiha', habitual: 'alehwisdisgoi', remote_past: 'ulehwistanvi', imperative: 'alehwisda', infinitive: 'ulehwisdohdi'],
            [subject: 'PL3', object: '', present: 'analehwisdiha', habitual: 'analehwisdisgoi', remote_past: 'unalehwistanvi', imperative: 'analehwisda', infinitive: 'unalehwisdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idalehwisdiha', habitual: 'idalehwisdisgoi', remote_past: 'igalehwistanvi', imperative: 'idalehwisda', infinitive: 'igalehwisdohdi']
        ]
    ]

    @Unroll
    def "conjugating Alehwisdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alehwisdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galewisdiha"
        "SG1" | "" | Tense.HABITUAL        | "galewisdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwalehwistanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galewisda"
        "SG1" | "" | Tense.INFINITIVE      | "agwalehwisdohdi"
        "SG2" | "" | Tense.PRESENT         | "halehwisdiha"
        "SG2" | "" | Tense.HABITUAL        | "halehwisdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalehwistanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halehwisda"
        "SG2" | "" | Tense.INFINITIVE      | "jalehwisdohdi"
        "SG3" | "" | Tense.PRESENT         | "alehwisdiha"
        "SG3" | "" | Tense.HABITUAL        | "alehwisdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulehwistanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alehwisda"
        "SG3" | "" | Tense.INFINITIVE      | "ulehwisdohdi"
        "PL3" | "" | Tense.PRESENT         | "analehwisdiha"
        "PL3" | "" | Tense.HABITUAL        | "analehwisdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalehwistanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analehwisda"
        "PL3" | "" | Tense.INFINITIVE      | "unalehwisdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idalehwisdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalehwisdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalehwistanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalehwisda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalehwisdohdi"
    }
}
