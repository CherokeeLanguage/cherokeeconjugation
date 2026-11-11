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
            [subject: 'SG1', object: '', present: 'deganelohvsga', habitual: 'deganelohvsgoi', remote_past: 'dagwanelohnvi', imperative: 'deganelohvga', infinitive: 'digwanehldi'],
            [subject: 'SG2', object: '', present: 'dehanelohvsga', habitual: 'dehanelohvsgoi', remote_past: 'dejanelohnvi', imperative: 'tanelohvga', infinitive: 'dijanehldi'],
            [subject: 'SG3', object: '', present: 'danelohvsga', habitual: 'danelohvsgoi', remote_past: 'dunelohnvi', imperative: 'dinelohvga', infinitive: 'junehldi'],
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
        "SG1" | "" | Tense.PRESENT         | "deganelohvsga"
        "SG1" | "" | Tense.HABITUAL        | "deganelohvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwanelohnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "deganelohvga"
        "SG1" | "" | Tense.INFINITIVE      | "digwanehldi"
        "SG2" | "" | Tense.PRESENT         | "dehanelohvsga"
        "SG2" | "" | Tense.HABITUAL        | "dehanelohvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejanelohnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tanelohvga"
        "SG2" | "" | Tense.INFINITIVE      | "dijanehldi"
        "SG3" | "" | Tense.PRESENT         | "danelohvsga"
        "SG3" | "" | Tense.HABITUAL        | "danelohvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dunelohnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "dinelohvga"
        "SG3" | "" | Tense.INFINITIVE      | "junehldi"
        "PL3" | "" | Tense.PRESENT         | "dananelohvsga"
        "PL3" | "" | Tense.HABITUAL        | "dananelohvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunanelohnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "dinanelohvga"
        "PL3" | "" | Tense.INFINITIVE      | "junanehldi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedanelohvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedanelohvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "deganelohnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "didanelohvga"
        "PL1INCL" | "" | Tense.INFINITIVE      | "diganehldi"
    }
}
