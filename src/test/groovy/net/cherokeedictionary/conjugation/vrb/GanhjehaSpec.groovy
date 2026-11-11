package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GanhjehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Have With / Hold in Hand (liquid)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinejeha', habitual: 'jinejehoi', remote_past: 'jinejehvi', imperative: 'jinejehesdi', infinitive: 'jinejehi'],
            [subject: 'SG2', object: '', present: 'hinhjeha', habitual: 'hinhjehoi', remote_past: 'hinhjehvi', imperative: 'hinhjehesdi', infinitive: 'hinhjehi'],
            [subject: 'SG1', object: '', present: 'ganhjeha', habitual: 'ganhjehoi', remote_past: 'ganhjehvi', imperative: 'ganhjehesdi', infinitive: 'ganhjehi'],
            [subject: 'PL3', object: '', present: 'aninhjeha', habitual: 'aninhjehoi', remote_past: 'aninhjehvi', imperative: 'aninhjehesdi', infinitive: 'aninhjehi']
        ]
    ]

    @Unroll
    def "conjugating Ganhjeha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ganhjeha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinejeha"
        "SG1" | "" | Tense.HABITUAL        | "jinejehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "jinejehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinejehesdi"
        "SG1" | "" | Tense.INFINITIVE      | "jinejehi"
        "SG2" | "" | Tense.PRESENT         | "hinhjeha"
        "SG2" | "" | Tense.HABITUAL        | "hinhjehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "hinhjehvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hinhjehesdi"
        "SG2" | "" | Tense.INFINITIVE      | "hinhjehi"
        "SG1" | "" | Tense.PRESENT         | "ganhjeha"
        "SG1" | "" | Tense.HABITUAL        | "ganhjehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "ganhjehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "ganhjehesdi"
        "SG1" | "" | Tense.INFINITIVE      | "ganhjehi"
        "PL3" | "" | Tense.PRESENT         | "aninhjeha"
        "PL3" | "" | Tense.HABITUAL        | "aninhjehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "aninhjehvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninhjehesdi"
        "PL3" | "" | Tense.INFINITIVE      | "aninhjehi"
    }
}
