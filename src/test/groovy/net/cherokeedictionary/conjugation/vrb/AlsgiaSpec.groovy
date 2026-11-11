package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AlsgiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Dancing",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'galisgia', habitual: 'galisgisgoi', remote_past: 'agwalsgisvi', imperative: 'galisgi', infinitive: 'agwalsgisdi'],
            [subject: 'SG2', object: '', present: 'halsgia', habitual: 'halsgisgoi', remote_past: 'jalsgisvi', imperative: 'halsgi', infinitive: 'jalsgisdi'],
            [subject: 'SG3', object: '', present: 'alsgia', habitual: 'alsgisgoi', remote_past: 'ulsgisvi', imperative: 'alsgi', infinitive: 'ulsgisdi'],
            [subject: 'PL3', object: '', present: 'analsgia', habitual: 'analsgisgoi', remote_past: 'unalsgisvi', imperative: 'analsgi', infinitive: 'unalsgisdi'],
            [subject: 'PL1INCL', object: '', present: 'idalsgia', habitual: 'idalsgisgoi', remote_past: 'igalsgisvi', imperative: 'idalsgi', infinitive: 'igalsgisdi']
        ]
    ]

    @Unroll
    def "conjugating Alsgia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Alsgia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "galisgia"
        "SG1" | "" | Tense.HABITUAL        | "galisgisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwalsgisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "galisgi"
        "SG1" | "" | Tense.INFINITIVE      | "agwalsgisdi"
        "SG2" | "" | Tense.PRESENT         | "halsgia"
        "SG2" | "" | Tense.HABITUAL        | "halsgisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jalsgisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "halsgi"
        "SG2" | "" | Tense.INFINITIVE      | "jalsgisdi"
        "SG3" | "" | Tense.PRESENT         | "alsgia"
        "SG3" | "" | Tense.HABITUAL        | "alsgisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ulsgisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "alsgi"
        "SG3" | "" | Tense.INFINITIVE      | "ulsgisdi"
        "PL3" | "" | Tense.PRESENT         | "analsgia"
        "PL3" | "" | Tense.HABITUAL        | "analsgisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unalsgisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "analsgi"
        "PL3" | "" | Tense.INFINITIVE      | "unalsgisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idalsgia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idalsgisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igalsgisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idalsgi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igalsgisdi"
    }
}
