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
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gugidiha"
        "SG1" | "" | Tense.HABITUAL        | "gugidisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquugitanvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gugitanvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiwugidodi"
        "SG2" | "" | Tense.PRESENT         | "hugidiha"
        "SG2" | "" | Tense.HABITUAL        | "hugidisgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsugitanvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hugitanvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsawugidodi"
        "SG3" | "" | Tense.PRESENT         | "degugidiha"
        "SG3" | "" | Tense.HABITUAL        | "degugidisgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uwugitanvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ugitanvi"
        "SG3" | "" | Tense.INFINITIVE      | "uwugidodi"
        "PL3" | "" | Tense.PRESENT         | "anugidiha"
        "PL3" | "" | Tense.HABITUAL        | "anugidisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unugitanvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anugitanvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniwugidodi"
        "PL1INCL" | "" | Tense.PRESENT         | "idugidiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idugidisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igugitanvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idugitanvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igiwugidodi"
    }
}
