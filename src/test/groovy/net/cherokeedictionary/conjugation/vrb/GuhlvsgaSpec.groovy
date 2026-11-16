// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73280 (entrya guhlvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GuhlvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Covering (125)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'guhlvsga'],
            [subject: 'SG1', object: '', present: 'guhlvsga', habitual: 'guhlvsgoi', remote_past: 'agwuhlvnvi', imperative: 'guhlvvga', infinitive: 'agwuhlvdi'],
            [subject: 'SG2', object: '', present: 'huhlvsga', habitual: 'huhlvsgoi', remote_past: 'juhlvnvi', imperative: 'huhlvvga', infinitive: 'juhlvdi'],
            [subject: 'SG3', object: '', habitual: 'guhlvsgoi', imperative: 'huhlvvga', infinitive: 'uwuhlvdi', present: 'guhlvsga', remote_past: 'uwuhlvnvi'],
            [subject: 'PL3', object: '', present: 'anuhlvsga', habitual: 'anuhlvsgoi', remote_past: 'unuhlvnvi', imperative: 'anuhlvvga', infinitive: 'unuhlvdi'],
            [subject: 'PL1INCL', object: '', present: 'iduhlvsga', habitual: 'iduhlvsgoi', remote_past: 'iguhlvnvi', imperative: 'iduhlvvga', infinitive: 'iguhlvdi']
        ]
    ]

    @Unroll
    def "conjugating Guhlvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Guhlvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gutlvsga"
        "SG1" | "" | Tense.HABITUAL        | "gutlvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquutlvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gutlvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwutlvdi"
        "SG2" | "" | Tense.PRESENT         | "hutlvsga"
        "SG2" | "" | Tense.HABITUAL        | "hutlvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsutlvnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hutlvnvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawutlvdi"
        "SG3" | "" | Tense.PRESENT         | "gutlvsga"
        "SG3" | "" | Tense.HABITUAL        | "gutlvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwutlvnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "utlvnvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwutlvdi"
        "PL3" | "" | Tense.PRESENT         | "anutlvsga"
        "PL3" | "" | Tense.HABITUAL        | "anutlvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unutlvnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anutlvnvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwutlvdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idutlvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idutlvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igutlvnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idutlvnvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwutlvdi"
    }
}
