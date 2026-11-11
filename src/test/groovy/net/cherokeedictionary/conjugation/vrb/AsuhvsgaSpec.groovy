package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsuhvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Fishing",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gasuhvsga', habitual: 'gasuhvsgoi', remote_past: 'aksuhnvi', imperative: 'gasuhvga', infinitive: 'aksuhdi'],
            [subject: 'SG2', object: '', present: 'hasuhvsga', habitual: 'hasuhvsgoi', remote_past: 'tsuhnvi', imperative: 'hasuhvga', infinitive: 'tsuhdi'],
            [subject: 'SG3', object: '', present: 'asuhvsga', habitual: 'asuhvsgoi', remote_past: 'usuhnvi', imperative: 'asuhvga', infinitive: 'usuhdi'],
            [subject: 'SG3', object: '', present: 'anasuhvsga', habitual: 'anasuhvsgoi', remote_past: 'unsuhnvi', imperative: 'anasuhvga', infinitive: 'unsuhdi'],
            [subject: 'PL1INCL', object: '', present: 'idasuhvsga', habitual: 'idasuhvsgoi', remote_past: 'iksuhnvi', imperative: 'idasuhvga', infinitive: 'iksuhdi'],
            [subject: 'SG3', object: '', present: 'osda-nigvneha', habitual: 'osda-nigvnehoi', remote_past: 'osda-nagwvnelvi', imperative: 'osda-nigvga', infinitive: 'osda-yagwvndi'],
            [subject: 'SG3', object: '', present: 'osda-hnvneha', habitual: 'osda-hnvnehoi', remote_past: 'osda-nijvnelvi', imperative: 'osda-hnvga', infinitive: 'osda-yijvndi'],
            [subject: 'SG3', object: '', present: 'osda-nigvneha', habitual: 'osda-nigvnehoi', remote_past: 'osda-nuwvnelvi', imperative: 'osda-nigvga', infinitive: 'osda-yuwandi'],
            [subject: 'SG3', object: '', present: 'osda-nanvneha', habitual: 'osda-nanvnehoi', remote_past: 'osda-nunvnelvi', imperative: 'osda-nanvga', infinitive: 'osda-yunvndi'],
            [subject: 'SG3', object: '', present: 'osda-nidvneha', habitual: 'osda-nidvnehoi', remote_past: 'osda-nigvnelvi', imperative: 'osda-nidvga', infinitive: 'osda-yigvndi']
        ]
    ]

    @Unroll
    def "conjugating Asuhvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asuhvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gasuhvsga"
        "SG1" | "" | Tense.HABITUAL        | "gasuhvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aksuhnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gasuhvga"
        "SG1" | "" | Tense.INFINITIVE      | "aksuhdi"
        "SG2" | "" | Tense.PRESENT         | "hasuhvsga"
        "SG2" | "" | Tense.HABITUAL        | "hasuhvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsuhnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hasuhvga"
        "SG2" | "" | Tense.INFINITIVE      | "tsuhdi"
        "SG3" | "" | Tense.PRESENT         | "asuhvsga"
        "SG3" | "" | Tense.HABITUAL        | "asuhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usuhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asuhvga"
        "SG3" | "" | Tense.INFINITIVE      | "usuhdi"
        "SG3" | "" | Tense.PRESENT         | "anasuhvsga"
        "SG3" | "" | Tense.HABITUAL        | "anasuhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unsuhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anasuhvga"
        "SG3" | "" | Tense.INFINITIVE      | "unsuhdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idasuhvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idasuhvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iksuhnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idasuhvga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iksuhdi"
        "SG3" | "" | Tense.PRESENT         | "osda-nigvneha"
        "SG3" | "" | Tense.HABITUAL        | "osda-nigvnehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "osda-nagwvnelvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "osda-nigvga"
        "SG3" | "" | Tense.INFINITIVE      | "osda-yagwvndi"
        "SG3" | "" | Tense.PRESENT         | "osda-hnvneha"
        "SG3" | "" | Tense.HABITUAL        | "osda-hnvnehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "osda-nijvnelvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "osda-hnvga"
        "SG3" | "" | Tense.INFINITIVE      | "osda-yijvndi"
        "SG3" | "" | Tense.PRESENT         | "osda-nigvneha"
        "SG3" | "" | Tense.HABITUAL        | "osda-nigvnehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "osda-nuwvnelvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "osda-nigvga"
        "SG3" | "" | Tense.INFINITIVE      | "osda-yuwandi"
        "SG3" | "" | Tense.PRESENT         | "osda-nanvneha"
        "SG3" | "" | Tense.HABITUAL        | "osda-nanvnehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "osda-nunvnelvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "osda-nanvga"
        "SG3" | "" | Tense.INFINITIVE      | "osda-yunvndi"
        "SG3" | "" | Tense.PRESENT         | "osda-nidvneha"
        "SG3" | "" | Tense.HABITUAL        | "osda-nidvnehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "osda-nigvnelvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "osda-nidvga"
        "SG3" | "" | Tense.INFINITIVE      | "osda-yigvndi"
    }
}
