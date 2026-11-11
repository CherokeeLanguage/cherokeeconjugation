package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanohalidohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Hunting",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinoalidoha', habitual: 'jinoalidosgoi', remote_past: 'aginohalidolvi', imperative: 'jinoalida', infinitive: 'aginohalidasdi'],
            [subject: 'SG2', object: '', present: 'hinohalidoha', habitual: 'hinohalidosgoi', remote_past: 'janohalidolvi', imperative: 'hinohalida', infinitive: 'janohalidasdi'],
            [subject: 'SG3', object: '', present: 'ganohalidoha', habitual: 'ganohalidosgoi', remote_past: 'unohalidolvi', imperative: 'ganohalida', infinitive: 'unohalidasdi'],
            [subject: 'PL3', object: '', present: 'aninohalidoha', habitual: 'aninohalidosgoi', remote_past: 'uninohalidolvi', imperative: 'aninohalida', infinitive: 'uninohalidasdi'],
            [subject: 'PL1INCL', object: '', present: 'idinohalidoha', habitual: 'idinohalidosgoi', remote_past: 'iginohalidolvi', imperative: 'idinohalida', infinitive: 'iginohalidasdi']
        ]
    ]

    @Unroll
    def "conjugating Ganohalidoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganohalidoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinoalidoha"
        "SG1" | "" | Tense.HABITUAL        | "jinoalidosgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginohalidolvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinoalida"
        "SG1" | "" | Tense.INFINITIVE      | "aginohalidasdi"
        "SG2" | "" | Tense.PRESENT         | "hinohalidoha"
        "SG2" | "" | Tense.HABITUAL        | "hinohalidosgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "janohalidolvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinohalida"
        "SG2" | "" | Tense.INFINITIVE      | "janohalidasdi"
        "SG3" | "" | Tense.PRESENT         | "ganohalidoha"
        "SG3" | "" | Tense.HABITUAL        | "ganohalidosgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unohalidolvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ganohalida"
        "SG3" | "" | Tense.INFINITIVE      | "unohalidasdi"
        "PL3" | "" | Tense.PRESENT         | "aninohalidoha"
        "PL3" | "" | Tense.HABITUAL        | "aninohalidosgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninohalidolvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninohalida"
        "PL3" | "" | Tense.INFINITIVE      | "uninohalidasdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinohalidoha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinohalidosgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginohalidolvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinohalida"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginohalidasdi"
    }
}
