// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73559 (entrya nigawea) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class NigaweaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Saying/Meowing",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'nijiwea'],
            [subject: 'SG1', object: '', present: 'nijiwea', habitual: 'nijiwesgoi', remote_past: 'nagiwesvi', imperative: 'nijiwi', infinitive: 'iyagiwesdi'],
            [subject: 'SG2', object: '', present: 'hniwea', habitual: 'hniwesgoi', remote_past: 'nijawesvi', imperative: 'hniwi', infinitive: 'iyijawesdi'],
            [subject: 'SG3', object: '', habitual: 'nigawesgoi', imperative: 'hniwi', infinitive: 'iyuwesdi', present: 'nigawea', remote_past: 'nuwesvi'],
            [subject: 'PL3', object: '', present: 'naniwea', habitual: 'naniwesgoi', remote_past: 'nuniwesvi', imperative: 'naniwi', infinitive: 'iyuniwesdi'],
            [subject: 'PL1INCL', object: '', present: 'nidiwea', habitual: 'nidiwesgoi', remote_past: 'nigiwesvi', imperative: 'nidiwi', infinitive: 'iyigiwesdi']
        ]
    ]

    @Unroll
    def "conjugating Nigawea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Nigawea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsiwea"
        "SG1" | "" | Tense.HABITUAL        | "tsiwesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiwesvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiwesvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiyuwesdi"
        "SG2" | "" | Tense.PRESENT         | "hiwea"
        "SG2" | "" | Tense.HABITUAL        | "hiwesgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsawesvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiwesvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsayuwesdi"
        "SG3" | "" | Tense.PRESENT         | "nigawea"
        "SG3" | "" | Tense.HABITUAL        | "nigawesgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwesvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "gawesvi"
        "SG3" | "" | Tense.INFINITIVE      | "uyuwesdi"
        "PL3" | "" | Tense.PRESENT         | "aniwea"
        "PL3" | "" | Tense.HABITUAL        | "aniwesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniwesvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniwesvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyuwesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idiwea"
        "PL1INCL" | "" | Tense.HABITUAL        | "idiwesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igiwesvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idiwesvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiyuwesdi"
    }
}
