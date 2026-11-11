package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class GansaneaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Pulling",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jinasanea', habitual: 'jinasanesgoi', remote_past: 'aginsanesvi', imperative: 'jinasanagi', infinitive: 'aginsanesdi'],
            [subject: 'SG1', object: '', present: 'gansanea', habitual: 'gansanesgoi', remote_past: 'unsanesvi', imperative: 'gansanagi', infinitive: 'unsanesdi'],
            [subject: 'PL3', object: '', present: 'aninsanea', habitual: 'aninsanesgoi', remote_past: 'uninsanesvi', imperative: 'aninsanagi', infinitive: 'uninsanesdi'],
            [subject: 'PL1INCL', object: '', present: 'idinsanea', habitual: 'idinsanesgoi', remote_past: 'iginsanesvi', imperative: 'idinsanagi', infinitive: 'iginsanesdi']
        ]
    ]

    @Unroll
    def "conjugating Gansanea (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Gansanea", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jinasanea"
        "SG1" | "" | Tense.HABITUAL        | "jinasanesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginsanesvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jinasanagi"
        "SG1" | "" | Tense.INFINITIVE      | "aginsanesdi"
        "SG1" | "" | Tense.PRESENT         | "gansanea"
        "SG1" | "" | Tense.HABITUAL        | "gansanesgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "unsanesvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gansanagi"
        "SG1" | "" | Tense.INFINITIVE      | "unsanesdi"
        "PL3" | "" | Tense.PRESENT         | "aninsanea"
        "PL3" | "" | Tense.HABITUAL        | "aninsanesgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninsanesvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aninsanagi"
        "PL3" | "" | Tense.INFINITIVE      | "uninsanesdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idinsanea"
        "PL1INCL" | "" | Tense.HABITUAL        | "idinsanesgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginsanesvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idinsanagi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginsanesdi"
    }
}
