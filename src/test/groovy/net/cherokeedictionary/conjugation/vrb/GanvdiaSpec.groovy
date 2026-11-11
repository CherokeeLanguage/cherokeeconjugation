package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanvdiaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Missing (Him/It)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'ganvdia', habitual: 'ganvdisgoi', remote_past: 'unvdvi', imperative: 'ganvda', infinitive: 'unvdisdi'],
            [subject: 'PL3', object: '', present: 'aninvdia', habitual: 'aninvdisgoi', remote_past: 'uninvdvi', imperative: 'aninvda', infinitive: 'uninvdisdi'],
            [subject: 'PL1INCL', object: '', present: 'idinvdia', habitual: 'idinvdisgoi', remote_past: 'iginvdvi', imperative: 'idinvda', infinitive: 'iginvdisdi']
        ]
    ]

    @Unroll
    def "conjugating Ganvdia (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganvdia", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "ganvdia"
        "SG1" | "" | Tense.HABITUAL        | "ganvdisgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "unvdvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganvda"
        "SG1" | "" | Tense.INFINITIVE      | "unvdisdi"
        "PL3" | "" | Tense.PRESENT         | "aninvdia"
        "PL3" | "" | Tense.HABITUAL        | "aninvdisgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninvdvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninvda"
        "PL3" | "" | Tense.INFINITIVE      | "uninvdisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinvdia"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinvdisgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginvdvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinvda"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginvdisdi"
    }
}
