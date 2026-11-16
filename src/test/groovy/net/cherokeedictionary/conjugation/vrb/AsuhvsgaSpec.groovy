// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72636 (entrya asuhvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'gasuhvsga'],
            [subject: 'SG1', object: '', present: 'gasuhvsga', habitual: 'gasuhvsgoi', remote_past: 'aksuhnvi', imperative: 'gasuhvga', infinitive: 'aksuhdi'],
            [subject: 'SG2', object: '', present: 'hasuhvsga', habitual: 'hasuhvsgoi', remote_past: 'tsuhnvi', imperative: 'hasuhvga', infinitive: 'tsuhdi'],
            [subject: 'SG3', object: '', habitual: 'asuhvsgoi', imperative: 'hasuhvga', infinitive: 'usuhdi', present: 'asuhvsga', remote_past: 'usuhnvi'],
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
        "SG1" | "" | Tense.REMOTE_PAST     | "aquasunvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gasunvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquasudi"
        "SG2" | "" | Tense.PRESENT         | "hasuhvsga"
        "SG2" | "" | Tense.HABITUAL        | "hasuhvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasunvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hasunvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsasudi"
        "SG3" | "" | Tense.PRESENT         | "asuhvsga"
        "SG3" | "" | Tense.HABITUAL        | "asuhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usunvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asunvi"
        "SG3" | "" | Tense.INFINITIVE      | "usudi"
        "SG3" | "" | Tense.PRESENT         | "asuhvsga"
        "SG3" | "" | Tense.HABITUAL        | "asuhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usunvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asunvi"
        "SG3" | "" | Tense.INFINITIVE      | "usudi"
        "PL1INCL" | "" | Tense.PRESENT         | "idasuhvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idasuhvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igasunvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idasunvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igasudi"
        "SG3" | "" | Tense.PRESENT         | "asuhvsga"
        "SG3" | "" | Tense.HABITUAL        | "asuhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usunvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asunvi"
        "SG3" | "" | Tense.INFINITIVE      | "usudi"
        "SG3" | "" | Tense.PRESENT         | "asuhvsga"
        "SG3" | "" | Tense.HABITUAL        | "asuhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usunvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asunvi"
        "SG3" | "" | Tense.INFINITIVE      | "usudi"
        "SG3" | "" | Tense.PRESENT         | "asuhvsga"
        "SG3" | "" | Tense.HABITUAL        | "asuhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usunvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asunvi"
        "SG3" | "" | Tense.INFINITIVE      | "usudi"
        "SG3" | "" | Tense.PRESENT         | "asuhvsga"
        "SG3" | "" | Tense.HABITUAL        | "asuhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usunvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asunvi"
        "SG3" | "" | Tense.INFINITIVE      | "usudi"
        "SG3" | "" | Tense.PRESENT         | "asuhvsga"
        "SG3" | "" | Tense.HABITUAL        | "asuhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usunvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asunvi"
        "SG3" | "" | Tense.INFINITIVE      | "usudi"
    }
}
