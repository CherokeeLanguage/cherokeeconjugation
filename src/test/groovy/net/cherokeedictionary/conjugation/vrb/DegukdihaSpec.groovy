// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72826 (entrya degukdiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class DegukdihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Deciding",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'degugodiha'],
            [subject: 'SG1', object: '', present: 'degugodiha', habitual: 'degugodisgoi', remote_past: 'dagwuktanvi', imperative: 'digugoda', infinitive: 'digwukdohdi'],
            [subject: 'SG2', object: '', present: 'dehugodiha', habitual: 'dehugodisgoi', remote_past: 'dejuktanvi', imperative: 'tukda', infinitive: 'dijukdohdi'],
            [subject: 'SG3', object: '', habitual: 'degukdisgoi', imperative: 'tukda', infinitive: 'juwukdohdi', present: 'degukdiha', remote_past: 'duwuktanvi'],
            [subject: 'PL3', object: '', present: 'danukdiha', habitual: 'danukdisgoi', remote_past: 'dunuktanvi', imperative: 'dinukda', infinitive: 'junukdohdi'],
            [subject: 'PL1INCL', object: '', present: 'dedukdiha', habitual: 'dedukdisgoi', remote_past: 'deguktanvi', imperative: 'didukda', infinitive: 'digukdohdi']
        ]
    ]

    @Unroll
    def "conjugating Degukdiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Degukdiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "degugodiha"
        "SG1" | "" | Tense.HABITUAL        | "degugodisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "dagwuktanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gugitanvi"
        "SG1" | "" | Tense.INFINITIVE      | "digwukdohdi"
        "SG2" | "" | Tense.PRESENT         | "dehugodiha"
        "SG2" | "" | Tense.HABITUAL        | "dehugodisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "dejuktanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hugitanvi"
        "SG2" | "" | Tense.INFINITIVE      | "dijukdohdi"
        "SG3" | "" | Tense.PRESENT         | "degukdiha"
        "SG3" | "" | Tense.HABITUAL        | "degukdisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "duwuktanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ugitanvi"
        "SG3" | "" | Tense.INFINITIVE      | "juwukdohdi"
        "PL3" | "" | Tense.PRESENT         | "danukdiha"
        "PL3" | "" | Tense.HABITUAL        | "danukdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "dunuktanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anugitanvi"
        "PL3" | "" | Tense.INFINITIVE      | "junukdohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "dedukdiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "dedukdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "deguktanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idugitanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "digukdohdi"
    }
}
