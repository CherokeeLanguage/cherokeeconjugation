package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyohisdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Taking a Break",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiyohisdiha', habitual: 'jiyohisdisgoi', remote_past: 'agiyohisdtanvi', imperative: 'jiyohisda', infinitive: 'agiyohisdohdi'],
            [subject: 'SG2', object: '', present: 'hiyohisdiha', habitual: 'hiyohisdisgoi', remote_past: 'jayohisdtanvi', imperative: 'hiyohisda', infinitive: 'jayohisdohdi'],
            [subject: 'SG3', object: '', present: 'ayohisdiha', habitual: 'ayohisdisgoi', remote_past: 'uyohisdtanvi', imperative: 'ayohisda', infinitive: 'uyohisdohdi'],
            [subject: 'PL3', object: '', present: 'aniyohisdiha', habitual: 'aniyohisdisgoi', remote_past: 'uniyohisdtanvi', imperative: 'aniyohisda', infinitive: 'uniyohisdohdi'],
            [subject: 'PL1INCL', object: '', present: 'idiyohisdiha', habitual: 'idiyohisdisgoi', remote_past: 'igiyohisdtanvi', imperative: 'idiyohisda', infinitive: 'igiyohisdohdi']
        ]
    ]

    @Unroll
    def "conjugating Ayohisdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayohisdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiyohisdiha"
        "SG1" | "" | Tense.HABITUAL        | "jiyohisdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiyohisdtanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jiyohisda"
        "SG1" | "" | Tense.INFINITIVE      | "agiyohisdohdi"
        "SG2" | "" | Tense.PRESENT         | "hiyohisdiha"
        "SG2" | "" | Tense.HABITUAL        | "hiyohisdisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jayohisdtanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiyohisda"
        "SG2" | "" | Tense.INFINITIVE      | "jayohisdohdi"
        "SG3" | "" | Tense.PRESENT         | "ayohisdiha"
        "SG3" | "" | Tense.HABITUAL        | "ayohisdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyohisdtanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ayohisda"
        "SG3" | "" | Tense.INFINITIVE      | "uyohisdohdi"
        "PL3" | "" | Tense.PRESENT         | "aniyohisdiha"
        "PL3" | "" | Tense.HABITUAL        | "aniyohisdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyohisdtanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniyohisda"
        "PL3" | "" | Tense.INFINITIVE      | "uniyohisdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idiyohisdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idiyohisdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiyohisdtanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiyohisda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiyohisdohdi"
    }
}
