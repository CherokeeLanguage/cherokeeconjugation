package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DasvsdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Scheduling a Time / Planning It",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'dejisvsdiha', habitual: 'dejisvsdisgoi', remote_past: 'daksvstanvi', imperative: 'dijisvsda', infinitive: 'diksvsdohdi'],
            [subject: 'SG2', object: '', present: 'dehisvsdiha', habitual: 'dehisvsdisgoi', remote_past: 'detsvstanvi', imperative: 'tisvsda', infinitive: 'ditsvsdohdi'],
            [subject: 'SG3', object: '', present: 'dasvsdiha', habitual: 'dasvsdisgoi', remote_past: 'dusvstanvi', imperative: 'disvsda', infinitive: 'jusvsdohdi'],
            [subject: 'PL3', object: '', present: 'danisvsdiha', habitual: 'danisvsdisgoi', remote_past: 'dunisvstanvi', imperative: 'dinisvsda', infinitive: 'junisvsdohdi'],
            [subject: 'PL1INCL', object: '', present: 'dedisvsdiha', habitual: 'dedisvsdisgoi', remote_past: 'degisvstanvi', imperative: 'didisvsda', infinitive: 'digisvsdohdi']
        ]
    ]

    @Unroll
    def "conjugating Dasvsdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Dasvsdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "dejisvsdiha"
        "SG1" | "" | Tense.HABITUAL        | "dejisvsdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "daksvstanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "dijisvsda"
        "SG1" | "" | Tense.INFINITIVE      | "diksvsdohdi"
        "SG2" | "" | Tense.PRESENT         | "dehisvsdiha"
        "SG2" | "" | Tense.HABITUAL        | "dehisvsdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "detsvstanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tisvsda"
        "SG2" | "" | Tense.INFINITIVE      | "ditsvsdohdi"
        "SG3" | "" | Tense.PRESENT         | "dasvsdiha"
        "SG3" | "" | Tense.HABITUAL        | "dasvsdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dusvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "disvsda"
        "SG3" | "" | Tense.INFINITIVE      | "jusvsdohdi"
        "PL3" | "" | Tense.PRESENT         | "danisvsdiha"
        "PL3" | "" | Tense.HABITUAL        | "danisvsdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunisvstanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinisvsda"
        "PL3" | "" | Tense.INFINITIVE      | "junisvsdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedisvsdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedisvsdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "degisvstanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didisvsda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digisvsdohdi"
    }
}
