package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GawonihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Speaking",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jiwoniha', habitual: 'jiwonisgoi', remote_past: 'agiwonisvi', imperative: 'jiwonihi', infinitive: 'agiwonihisdi'],
            [subject: 'SG2', object: '', present: 'hiwoniha', habitual: 'hiwonisgoi', remote_past: 'jawonisvi', imperative: 'hiwonihi', infinitive: 'jawonihisdi'],
            [subject: 'SG3', object: '', present: 'gawoniha', habitual: 'gawonisgoi', remote_past: 'uwonisvi', imperative: 'gawonihi', infinitive: 'uwonihisdi'],
            [subject: 'PL3', object: '', present: 'aniwoniha', habitual: 'aniwonisgoi', remote_past: 'uniwonisvi', imperative: 'aniwonihi', infinitive: 'uniwonihisdi'],
            [subject: 'PL1INCL', object: '', present: 'idiwoniha', habitual: 'idiwonisgoi', remote_past: 'igiwonisvi', imperative: 'idiwonihi', infinitive: 'igiwonihisdi']
        ]
    ]

    @Unroll
    def "conjugating Gawoniha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gawoniha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiwoniha"
        "SG1" | "" | Tense.HABITUAL        | "jiwonisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwonisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jiwonihi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwonihisdi"
        "SG2" | "" | Tense.PRESENT         | "hiwoniha"
        "SG2" | "" | Tense.HABITUAL        | "hiwonisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jawonisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwonihi"
        "SG2" | "" | Tense.INFINITIVE      | "jawonihisdi"
        "SG3" | "" | Tense.PRESENT         | "gawoniha"
        "SG3" | "" | Tense.HABITUAL        | "gawonisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwonisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawonihi"
        "SG3" | "" | Tense.INFINITIVE      | "uwonihisdi"
        "PL3" | "" | Tense.PRESENT         | "aniwoniha"
        "PL3" | "" | Tense.HABITUAL        | "aniwonisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwonisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwonihi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwonihisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idiwoniha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idiwonisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiwonisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiwonihi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwonihisdi"
    }
}
