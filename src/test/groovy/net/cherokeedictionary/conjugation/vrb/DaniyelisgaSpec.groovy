package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DaniyelisgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Adjourning",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'dosdiyelisga', habitual: 'dosdiyelisgoi', remote_past: 'doginiyelisvi', imperative: 'josdiyelihi', infinitive: 'joginiyelihisdi'],
            [subject: 'SG2', object: '', present: 'dojiyelisga', habitual: 'dojiyelisgoi', remote_past: 'dogiyelisvi', imperative: 'jojiyelihi', infinitive: 'jogiyelihisdi'],
            [subject: 'SG3', object: '', present: 'daniyelisga', habitual: 'daniyelisgoi', remote_past: 'duniyelisvi', imperative: 'diniyelisdi', infinitive: 'juniyelihisdi'],
            [subject: 'PL3', object: '', present: 'desdiyelisga', habitual: 'desdiyelisgoi', remote_past: 'desdiyelisvi', imperative: 'disdiyelihi', infinitive: 'disdiyelihisdi'],
            [subject: 'PL1INCL', object: '', present: 'dejiyelisga', habitual: 'dejiyelisgoi', remote_past: 'dejiyelisvi', imperative: 'dijiyelihi', infinitive: 'dijiyelihisdi']
        ]
    ]

    @Unroll
    def "conjugating Daniyelisga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Daniyelisga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "dosdiyelisga"
        "SG1" | "" | Tense.HABITUAL        | "dosdiyelisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "doginiyelisvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "josdiyelihi"
        "SG1" | "" | Tense.INFINITIVE      | "joginiyelihisdi"
        "SG2" | "" | Tense.PRESENT         | "dojiyelisga"
        "SG2" | "" | Tense.HABITUAL        | "dojiyelisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dogiyelisvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jojiyelihi"
        "SG2" | "" | Tense.INFINITIVE      | "jogiyelihisdi"
        "SG3" | "" | Tense.PRESENT         | "daniyelisga"
        "SG3" | "" | Tense.HABITUAL        | "daniyelisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "duniyelisvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "diniyelisdi"
        "SG3" | "" | Tense.INFINITIVE      | "juniyelihisdi"
        "PL3" | "" | Tense.PRESENT         | "desdiyelisga"
        "PL3" | "" | Tense.HABITUAL        | "desdiyelisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "desdiyelisvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "disdiyelihi"
        "PL3" | "" | Tense.INFINITIVE      | "disdiyelihisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dejiyelisga"
        "PL1INCL" | "" | Tense.HABITUAL        | "dejiyelisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "dejiyelisvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "dijiyelihi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "dijiyelihisdi"
    }
}
