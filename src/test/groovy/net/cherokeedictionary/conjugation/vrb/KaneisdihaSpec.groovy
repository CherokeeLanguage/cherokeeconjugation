// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73480 (entrya kaneisdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class KaneisdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Mentioning It",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jineisdiha'],
            [subject: 'SG1', object: '', present: 'jineisdiha', habitual: 'jineisdisgoi', remote_past: 'akineistanvi', imperative: 'jineisda', infinitive: 'akineisdohdi'],
            [subject: 'SG2', object: '', present: 'hihneisdiha', habitual: 'hihneisdisgoi', remote_past: 'jahneistanvi', imperative: 'hihneisda', infinitive: 'jahneisdohdi'],
            [subject: 'SG3', object: '', habitual: 'kaneisdisgoi', imperative: 'hihneisda', infinitive: 'uhneisdohdi', present: 'kaneisdiha', remote_past: 'uhneisdanvi'],
            [subject: 'PL3', object: '', present: 'anihneisdiha', habitual: 'anihneisdisgoi', remote_past: 'unihneistanvi', imperative: 'anihneisda', infinitive: 'unihneisdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idihneisdiha', habitual: 'idihneisdisgoi', remote_past: 'igihneistanvi', imperative: 'idihneisda', infinitive: 'igihneisdohdi']
        ]
    ]

    @Unroll
    def "conjugating Kaneisdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Kaneisdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsineisdiha"
        "SG1" | "" | Tense.HABITUAL        | "tsineisdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agineisdanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsineisdanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agineisdodi"
        "SG2" | "" | Tense.PRESENT         | "hineisdiha"
        "SG2" | "" | Tense.HABITUAL        | "hineisdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsaneisdanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hineisdanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsaneisdodi"
        "SG3" | "" | Tense.PRESENT         | "kaneisdiha"
        "SG3" | "" | Tense.HABITUAL        | "kaneisdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uneisdanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganeisdanvi"
        "SG3" | "" | Tense.INFINITIVE      | "uneisdodi"
        "PL3" | "" | Tense.PRESENT         | "anineisdiha"
        "PL3" | "" | Tense.HABITUAL        | "anineisdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unineisdanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anineisdanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unineisdodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idineisdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idineisdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igineisdanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idineisdanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igineisdodi"
    }
}
