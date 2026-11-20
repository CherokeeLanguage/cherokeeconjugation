// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72393 (entrya ahva) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhvaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Move (neutral) (26)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiva'],
            [subject: 'SG1', object: '', present: 'jiva', habitual: 'jivsgoi', remote_past: 'agihvsvi', imperative: 'jivna', infinitive: 'akvsdi'],
            [subject: 'SG2', object: '', present: 'hihva', habitual: 'hihvsgoi', remote_past: 'jahvsvi', imperative: 'hihvna', infinitive: 'jahvsdi'],
            [subject: 'SG3', object: '', habitual: 'ahvsgoi', imperative: 'hihvna', infinitive: 'uhvsdi', present: 'ahva', remote_past: 'uhvsvi'],
            [subject: 'PL3', object: '', present: 'anihva', habitual: 'anihvsgoi', remote_past: 'unihvsi', imperative: 'wanihvna', infinitive: 'unihvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ahva (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahva", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiva"
        "SG1" | "" | Tense.HABITUAL        | "jivsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agihvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsihvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "akvsdi"
        "SG2" | "" | Tense.PRESENT         | "hihva"
        "SG2" | "" | Tense.HABITUAL        | "hihvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jahvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hihvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "jahvsdi"
        "SG3" | "" | Tense.PRESENT         | "ahva"
        "SG3" | "" | Tense.HABITUAL        | "ahvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ahvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "uhvsdi"
        "PL3" | "" | Tense.PRESENT         | "anihva"
        "PL3" | "" | Tense.HABITUAL        | "anihvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihvsi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anihvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unihvsdi"
    }
}
