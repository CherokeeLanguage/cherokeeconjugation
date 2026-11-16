// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72349 (entrya ahileha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhilehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/he Has a Vehicle",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiileha'],
            // tio 16Nov26: the yaml extraction cited only the SG1 row and
            // carried junk 'x' remote/imperative cells. SG1 'jiileha' restored
            // as the first-person row and the SG3 citation added from CED
            // cedEntries.csv id 72349 (3sg present 'ahileha' ᎠᎯᎴᎭ "he has
            // possession of a vehicle"; infinitive 'uhilvsdi'; remote/imperative
            // are '-----' in CED, i.e. unattested, so not cited here).
            [subject: 'SG3', object: '', habitual: 'ahilehoi', imperative: '', infinitive: 'uhilvsdi', present: 'ahileha', remote_past: ''],
            [subject: 'SG1', object: '', present: 'jiileha', habitual: 'jiilehoi', infinitive: 'agihilvsdi'],
        ]
    ]

    @Unroll
    def "conjugating Ahileha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahileha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsihileha"
        "SG1" | "" | Tense.HABITUAL        | "tsihilehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "x"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsihile"
        "SG1" | "" | Tense.INFINITIVE      | "agihilvsdi"
    }
}
