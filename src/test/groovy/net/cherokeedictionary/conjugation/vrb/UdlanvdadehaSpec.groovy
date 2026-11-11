package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UdlanvdadehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Has Time (161)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'agwadlanvdadeha', habitual: 'agwadlanvdadehoi', remote_past: 'agwadlanvdadelvi', imperative: 'agwadlanvdadisi', infinitive: 'agwadlanvdadehdi'],
            [subject: 'SG2', object: '', present: 'jadlanvdadeha', habitual: 'jadlanvdadehoi', remote_past: 'jadlanvdadelvi', imperative: 'jadlanvdadisi', infinitive: 'jadlanvdadehdi'],
            [subject: 'SG3', object: '', present: 'udlanvdadeha', habitual: 'udlanvdadehoi', remote_past: 'udlanvdadelvi', imperative: 'udlanvdadisi', infinitive: 'udlanvdadehdi'],
            [subject: 'PL3', object: '', present: 'unadlanvdadeha', habitual: 'unadlanvdadehoi', remote_past: 'unadlanvdadelvi', imperative: 'unadlanvdadisi', infinitive: 'unadlanvdadehdi'],
            [subject: 'PL1INCL', object: '', present: 'igadlanvdadeha', habitual: 'igadlanvdadehoi', remote_past: 'igadlanvdadelvi', imperative: 'igadlanvdadisi', infinitive: 'igadlanvdadehdi']
        ]
    ]

    @Unroll
    def "conjugating Udlanvdadeha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Udlanvdadeha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "agwadlanvdadeha"
        "SG1" | "" | Tense.HABITUAL        | "agwadlanvdadehoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agwadlanvdadelvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "agwadlanvdadisi"
        "SG1" | "" | Tense.INFINITIVE      | "agwadlanvdadehdi"
        "SG2" | "" | Tense.PRESENT         | "jadlanvdadeha"
        "SG2" | "" | Tense.HABITUAL        | "jadlanvdadehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "jadlanvdadelvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "jadlanvdadisi"
        "SG2" | "" | Tense.INFINITIVE      | "jadlanvdadehdi"
        "SG3" | "" | Tense.PRESENT         | "udlanvdadeha"
        "SG3" | "" | Tense.HABITUAL        | "udlanvdadehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udlanvdadelvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "udlanvdadisi"
        "SG3" | "" | Tense.INFINITIVE      | "udlanvdadehdi"
        "PL3" | "" | Tense.PRESENT         | "unadlanvdadeha"
        "PL3" | "" | Tense.HABITUAL        | "unadlanvdadehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unadlanvdadelvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "unadlanvdadisi"
        "PL3" | "" | Tense.INFINITIVE      | "unadlanvdadehdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igadlanvdadeha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igadlanvdadehoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igadlanvdadelvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igadlanvdadisi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadlanvdadehdi"
    }
}
