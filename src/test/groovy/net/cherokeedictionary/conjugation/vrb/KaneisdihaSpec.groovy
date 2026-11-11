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
            [subject: 'SG1', object: '', present: 'jineisdiha', habitual: 'jineisdisgoi', remote_past: 'akineistanvi', imperative: 'jineisda', infinitive: 'akineisdohdi'],
            [subject: 'SG2', object: '', present: 'hihneisdiha', habitual: 'hihneisdisgoi', remote_past: 'jahneistanvi', imperative: 'hihneisda', infinitive: 'jahneisdohdi'],
            [subject: 'SG3', object: '', present: 'kaneisdiha', habitual: 'kaneisdisgoi', remote_past: 'uhneistanvi', imperative: 'ahneisda', infinitive: 'uhneisdohdi'],
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
        "SG1" | "" | Tense.PRESENT         | "jineisdiha"
        "SG1" | "" | Tense.HABITUAL        | "jineisdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akineistanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jineisda"
        "SG1" | "" | Tense.INFINITIVE      | "akineisdohdi"
        "SG2" | "" | Tense.PRESENT         | "hihneisdiha"
        "SG2" | "" | Tense.HABITUAL        | "hihneisdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahneistanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihneisda"
        "SG2" | "" | Tense.INFINITIVE      | "jahneisdohdi"
        "SG3" | "" | Tense.PRESENT         | "kaneisdiha"
        "SG3" | "" | Tense.HABITUAL        | "kaneisdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhneistanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahneisda"
        "SG3" | "" | Tense.INFINITIVE      | "uhneisdohdi"
        "PL3" | "" | Tense.PRESENT         | "anihneisdiha"
        "PL3" | "" | Tense.HABITUAL        | "anihneisdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihneistanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihneisda"
        "PL3" | "" | Tense.INFINITIVE      | "unihneisdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idihneisdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idihneisdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igihneistanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idihneisda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igihneisdohdi"
    }
}
