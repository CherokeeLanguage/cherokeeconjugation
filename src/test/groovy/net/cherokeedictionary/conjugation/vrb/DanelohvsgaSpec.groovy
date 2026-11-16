// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72799 (entrya danelohvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DanelohvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Playing",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'deganelohvsga'],
            [subject: 'SG1', object: '', present: 'deganelohvsga', habitual: 'deganelohvsgoi', remote_past: 'dagwanelohnvi', imperative: 'deganelohvga', infinitive: 'digwanehldi'],
            [subject: 'SG2', object: '', present: 'dehanelohvsga', habitual: 'dehanelohvsgoi', remote_past: 'dejanelohnvi', imperative: 'tanelohvga', infinitive: 'dijanehldi'],
            [subject: 'SG3', object: '', habitual: 'danelohvsgoi', imperative: 'tanelohvga', infinitive: 'junehldi', present: 'danelohvsga', remote_past: 'dunelohnvi'],
            [subject: 'PL3', object: '', present: 'dananelohvsga', habitual: 'dananelohvsgoi', remote_past: 'dunanelohnvi', imperative: 'dinanelohvga', infinitive: 'junanehldi'],
            [subject: 'PL1INCL', object: '', present: 'dedanelohvsga', habitual: 'dedanelohvsgoi', remote_past: 'deganelohnvi', imperative: 'didanelohvga', infinitive: 'diganehldi']
        ]
    ]

    @Unroll
    def "conjugating Danelohvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Danelohvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "ganelohvsga"
        "SG1" | "" | Tense.HABITUAL        | "ganelohvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquanelonvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganelonvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginelodi"
        "SG2" | "" | Tense.PRESENT         | "hanelohvsga"
        "SG2" | "" | Tense.HABITUAL        | "hanelohvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanelonvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hanelonvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanelodi"
        "SG3" | "" | Tense.PRESENT         | "danelohvsga"
        "SG3" | "" | Tense.HABITUAL        | "danelohvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unelonvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anelonvi"
        "SG3" | "" | Tense.INFINITIVE      | "unelodi"
        "PL3" | "" | Tense.PRESENT         | "ananelohvsga"
        "PL3" | "" | Tense.HABITUAL        | "ananelohvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unanelonvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "ananelonvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninelodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idanelohvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idanelohvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iganelonvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idanelonvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginelodi"
    }
}
