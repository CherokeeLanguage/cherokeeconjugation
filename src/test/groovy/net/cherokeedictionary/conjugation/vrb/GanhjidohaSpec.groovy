package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanhjidohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Handle/Carry (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinvjidoha', habitual: 'jinvjidohoi', remote_past: 'aginhjidolvi', imperative: 'jinvjida', infinitive: 'aginhjidasdi'],
            [subject: 'SG2', object: '', present: 'hinhjidoha', habitual: 'hinhjidohoi', remote_past: 'janhjidolvi', imperative: 'hinhjida', infinitive: 'janhjidasdi'],
            [subject: 'SG1', object: '', present: 'ganhjidoha', habitual: 'ganhjidohoi', remote_past: 'unhjidolvi', imperative: 'ganhjida', infinitive: 'unhjidasdi'],
            [subject: 'PL3', object: '', present: 'aninhjidoha', habitual: 'aninhjidohoi', remote_past: 'uninhjidolvi', imperative: 'aninhjida', infinitive: 'uninhjidasdi']
        ]
    ]

    @Unroll
    def "conjugating Ganhjidoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganhjidoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinvjidoha"
        "SG1" | "" | Tense.HABITUAL        | "jinvjidohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginhjidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinvjida"
        "SG1" | "" | Tense.INFINITIVE      | "aginhjidasdi"
        "SG2" | "" | Tense.PRESENT         | "hinhjidoha"
        "SG2" | "" | Tense.HABITUAL        | "hinhjidohoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janhjidolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinhjida"
        "SG2" | "" | Tense.INFINITIVE      | "janhjidasdi"
        "SG1" | "" | Tense.PRESENT         | "ganhjidoha"
        "SG1" | "" | Tense.HABITUAL        | "ganhjidohoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "unhjidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganhjida"
        "SG1" | "" | Tense.INFINITIVE      | "unhjidasdi"
        "PL3" | "" | Tense.PRESENT         | "aninhjidoha"
        "PL3" | "" | Tense.HABITUAL        | "aninhjidohoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninhjidolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninhjida"
        "PL3" | "" | Tense.INFINITIVE      | "uninhjidasdi"
    }
}
