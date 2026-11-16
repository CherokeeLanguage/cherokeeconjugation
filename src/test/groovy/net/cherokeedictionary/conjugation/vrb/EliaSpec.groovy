// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72966 (entrya elia) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'gelia'],
            [subject: 'SG1', object: '', present: 'gelia', habitual: 'gelisgoi', remote_past: 'agwelisvi', imperative: 'gela', infinitive: 'agwelisdi'],
            [subject: 'SG2', object: '', present: 'helia', habitual: 'helisgoi', remote_past: 'jelisvi', imperative: 'hela', infinitive: 'jelisdi'],
            [subject: 'SG3', object: '', habitual: 'elisgoi', imperative: 'hela', infinitive: 'uwelisdi', present: 'elia', remote_past: 'uwelisvi'],
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
        "SG1" | "" | Tense.REMOTE_PAST     | "aquelisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gelisvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwelisdi"
        "SG2" | "" | Tense.PRESENT         | "helia"
        "SG2" | "" | Tense.HABITUAL        | "helisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tselisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "helisvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawelisdi"
        "SG3" | "" | Tense.PRESENT         | "elia"
        "SG3" | "" | Tense.HABITUAL        | "elisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwelisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "elisvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwelisdi"
        "PL3" | "" | Tense.PRESENT         | "anelia"
        "PL3" | "" | Tense.HABITUAL        | "anelisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unelisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anelisvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwelisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idelia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idelisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igelisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idelisvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwelisdi"
    }
}
