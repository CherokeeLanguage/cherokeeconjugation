// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72444 (entrya ajvstvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'jijvstvsga'],
            [subject: 'SG1', object: '', present: 'jijvstvsga', habitual: 'jijvstvsgoi', remote_past: 'agijvstvsgoi', imperative: 'jijvstvga', infinitive: 'agijvstvsdi'],
            [subject: 'SG2', object: '', present: 'hijvstvsga', habitual: 'hijvstvsgoi', remote_past: 'jajvstvsgoi', imperative: 'hijvstvga', infinitive: 'jajvstvsdi'],
            [subject: 'SG3', object: '', habitual: 'ajvstvsgoi', imperative: 'hijvstvga', infinitive: 'ujvstvsdi', present: 'ajvstvsga', remote_past: 'ujvstanvi'],
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
        "SG1" | "" | Tense.PRESENT         | "tsitsvsdvsga"
        "SG1" | "" | Tense.HABITUAL        | "tsitsvsdvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agitsvstanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsitsvstanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agitsvsdvsdi"
        "SG2" | "" | Tense.PRESENT         | "hitsvsdvsga"
        "SG2" | "" | Tense.HABITUAL        | "hitsvsdvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatsvstanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hitsvstanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatsvsdvsdi"
        "SG3" | "" | Tense.PRESENT         | "atsvsdvsga"
        "SG3" | "" | Tense.HABITUAL        | "atsvsdvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utsvstanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atsvstanvi"
        "SG3" | "" | Tense.INFINITIVE      | "utsvsdvsdi"
        "PL3" | "" | Tense.PRESENT         | "anitsvsdvsga"
        "PL3" | "" | Tense.HABITUAL        | "anitsvsdvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unitsvstanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anitsvstanvi"
        "PL3" | "" | Tense.INFINITIVE      | "unitsvsdvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "iditsvsdvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "iditsvsdvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igitsvstanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iditsvstanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igitsvsdvsdi"
    }
}
