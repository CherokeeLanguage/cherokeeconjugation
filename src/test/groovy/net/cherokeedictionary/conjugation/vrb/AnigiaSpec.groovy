package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AnigiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Leaving / It is Starting",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'ganigia', habitual: 'ganigisgoi', remote_past: 'agwahnigisvi', imperative: 'ganigi', infinitive: 'agwahnigisdi'],
            [subject: 'SG2', object: '', present: 'hanigia', habitual: 'hanigisgoi', remote_past: 'jahnigisvi', imperative: 'hahnigi', infinitive: 'jahnigisdi'],
            [subject: 'SG3', object: '', present: 'anigia', habitual: 'anigisgoi', remote_past: 'uhnigisvi', imperative: 'ahnigi', infinitive: 'uhnigisdi'],
            [subject: 'PL3', object: '', present: 'ananigia', habitual: 'ananigisgoi', remote_past: 'unahnigisvi', imperative: 'anahnigi', infinitive: 'unahnigisdi'],
            [subject: 'PL1INCL', object: '', present: 'idanigia', habitual: 'idanigisgoi', remote_past: 'igahnigisvi', imperative: 'idahnigi', infinitive: 'igahnigisdi']
        ]
    ]

    @Unroll
    def "conjugating Anigia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Anigia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "ganigia"
        "SG1" | "" | Tense.HABITUAL        | "ganigisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquanigisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganigisvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquanigisdi"
        "SG2" | "" | Tense.PRESENT         | "hanigia"
        "SG2" | "" | Tense.HABITUAL        | "hanigisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanigisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hanigisvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanigisdi"
        "SG3" | "" | Tense.PRESENT         | "anigia"
        "SG3" | "" | Tense.HABITUAL        | "anigisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unigisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anigisvi"
        "SG3" | "" | Tense.INFINITIVE      | "unigisdi"
        "PL3" | "" | Tense.PRESENT         | "ananigia"
        "PL3" | "" | Tense.HABITUAL        | "ananigisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unanigisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "ananigisvi"
        "PL3" | "" | Tense.INFINITIVE      | "unanigisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idanigia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idanigisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iganigisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idanigisvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iganigisdi"
    }
}
