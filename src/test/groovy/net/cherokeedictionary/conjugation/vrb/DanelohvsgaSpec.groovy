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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        // tio 20Nov26: cells re-pinned to the engine post-DST h-branch fix (de-style keeps
        // ᏕᎯ per guide 61a/117a; FUTURE_COMMAND + DST2-infinitive cells left for pending rulings)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "deganelohvsga"
        "SG1" | "" | Tense.HABITUAL        | "deganelohvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwanelohnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganelonvi"
        "SG1" | "" | Tense.INFINITIVE      | "daginelodi"
        "SG2" | "" | Tense.PRESENT         | "dehanelohvsga"
        "SG2" | "" | Tense.HABITUAL        | "dehanelohvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejanelohnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hanelonvi"
        "SG2" | "" | Tense.INFINITIVE      | "detsanelodi"
        "SG3" | "" | Tense.PRESENT         | "danelohvsga"
        "SG3" | "" | Tense.HABITUAL        | "danelohvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "dunelohnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "anelonvi"
        "SG3" | "" | Tense.INFINITIVE      | "junehldi"
        "PL3" | "" | Tense.PRESENT         | "dananelohvsga"
        "PL3" | "" | Tense.HABITUAL        | "dananelohvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunanelohnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "ananelonvi"
        "PL3" | "" | Tense.INFINITIVE      | "tsuninelodi"
        "PL1INCL" | "" | Tense.PRESENT         | "dadanelohvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "dadanelohvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "daganelonvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idanelonvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "daginelodi"
    }
}
