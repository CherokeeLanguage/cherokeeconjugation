package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AjvstvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Turning on a Light",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jijvstvsga', habitual: 'jijvstvsgoi', remote_past: 'agijvstvsgoi', imperative: 'jijvstvga', infinitive: 'agijvstvsdi'],
            [subject: 'SG2', object: '', present: 'hijvstvsga', habitual: 'hijvstvsgoi', remote_past: 'jajvstvsgoi', imperative: 'hijvstvga', infinitive: 'jajvstvsdi'],
            [subject: 'SG3', object: '', present: 'ajvstvsga', habitual: 'ajvstvsgoi', remote_past: 'ujvstanvi', imperative: 'ajvstvga', infinitive: 'ujvstvsdi'],
            [subject: 'PL3', object: '', present: 'anijvstvsga', habitual: 'anijvstvsgoi', remote_past: 'unijvstanvi', imperative: 'anijvstvga', infinitive: 'unijvstvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idijvstvsga', habitual: 'idijvstvsgoi', remote_past: 'igijvstanvi', imperative: 'idijvstvga', infinitive: 'igijvstvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ajvstvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ajvstvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jijvstvsga"
        "SG1" | "" | Tense.HABITUAL        | "jijvstvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agijvstvsgoi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jijvstvga"
        "SG1" | "" | Tense.INFINITIVE      | "agijvstvsdi"
        "SG2" | "" | Tense.PRESENT         | "hijvstvsga"
        "SG2" | "" | Tense.HABITUAL        | "hijvstvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jajvstvsgoi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hijvstvga"
        "SG2" | "" | Tense.INFINITIVE      | "jajvstvsdi"
        "SG3" | "" | Tense.PRESENT         | "ajvstvsga"
        "SG3" | "" | Tense.HABITUAL        | "ajvstvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "ujvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ajvstvga"
        "SG3" | "" | Tense.INFINITIVE      | "ujvstvsdi"
        "PL3" | "" | Tense.PRESENT         | "anijvstvsga"
        "PL3" | "" | Tense.HABITUAL        | "anijvstvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unijvstanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anijvstvga"
        "PL3" | "" | Tense.INFINITIVE      | "unijvstvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idijvstvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idijvstvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igijvstanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idijvstvga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igijvstvsdi"
    }
}
