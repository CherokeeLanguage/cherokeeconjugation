// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72716 (entrya ayohusga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyohusgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Dying (S/he)",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyousga'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyousga', habitual: 'jiyousgoi', remote_past: 'jiyousvi', imperative: 'jiyouhi', infinitive: 'agiyohuhisdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyohusga', habitual: 'hiyohusgoi', remote_past: 'hiyohusvi', imperative: 'hiyohuhi', infinitive: 'jayohuhisdi'],
            [subject: 'SG3', object: '', habitual: 'ayohusgoi', imperative: 'hiyohuhi', infinitive: 'uyohuhisdi', present: 'ayohusga', remote_past: 'uyohusvi'],
            [subject: 'PL3', object: 'SG3AN', present: 'aniyohusga', habitual: 'aniyohusgoi', remote_past: 'uniyohusvi', imperative: 'aniyohuhi', infinitive: 'uniyohusdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'idiyohusga', habitual: 'idiyohusgoi', remote_past: 'igiyohusvi', imperative: 'idiyohuhi', infinitive: 'igiyohusdi']
        ]
    ]

    @Unroll
    def "conjugating Ayohusga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayohusga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyohusga"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyohusgoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyohusvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyohusvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyohuhisdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyohusga"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyohusgoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "yohusvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyohusvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "yohuhisdi"
        "SG3" | "SG3AN" | Tense.PRESENT         | "gayohusga"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "ayohusgoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uyohusvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "ayohusvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uyohuhisdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "aniyohusga"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "aniyohusgoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "aniyohusvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aniyohusvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "aniyohuhisdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "ediyohusga"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "ediyohusgoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "yohusvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "ediyohusvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "yohuhisdi"
    }
}
