package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class EliaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Think (So)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'gelia', habitual: 'gelisgoi', remote_past: 'agwelisvi', imperative: 'gela', infinitive: 'agwelisdi'],
            [subject: 'SG2', object: '', present: 'helia', habitual: 'helisgoi', remote_past: 'jelisvi', imperative: 'hela', infinitive: 'jelisdi'],
            [subject: 'SG3', object: '', present: 'elia', habitual: 'elisgoi', remote_past: 'uwelisvi', imperative: 'ela', infinitive: 'uwelisdi'],
            [subject: 'PL3', object: '', present: 'anelia', habitual: 'anelisgoi', remote_past: 'unelivi', imperative: 'anela', infinitive: 'unelisdi'],
            [subject: 'PL1INCL', object: '', present: 'idelia', habitual: 'idelisgoi', remote_past: 'igelisvi', imperative: 'idela', infinitive: 'igelisdi']
        ]
    ]

    @Unroll
    def "conjugating Elia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Elia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gelia"
        "SG1" | "" | Tense.HABITUAL        | "gelisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwelisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gela"
        "SG1" | "" | Tense.INFINITIVE      | "agwelisdi"
        "SG2" | "" | Tense.PRESENT         | "helia"
        "SG2" | "" | Tense.HABITUAL        | "helisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jelisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hela"
        "SG2" | "" | Tense.INFINITIVE      | "jelisdi"
        "SG3" | "" | Tense.PRESENT         | "elia"
        "SG3" | "" | Tense.HABITUAL        | "elisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwelisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ela"
        "SG3" | "" | Tense.INFINITIVE      | "uwelisdi"
        "PL3" | "" | Tense.PRESENT         | "anelia"
        "PL3" | "" | Tense.HABITUAL        | "anelisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unelivi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anela"
        "PL3" | "" | Tense.INFINITIVE      | "unelisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idelia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idelisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igelisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idela"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igelisdi"
    }
}
