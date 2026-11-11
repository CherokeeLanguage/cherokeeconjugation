package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UnaligohaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Together (They are) (175)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'oginaligoha', habitual: 'oginaligosoi', remote_past: 'oginaligosvi', imperative: 'oginaligosesdi', infinitive: 'oginadalisohdi'],
            [subject: 'SG2', object: '', present: 'ogaligoha', habitual: 'ogaligosoi', remote_past: 'ogaligosvi', imperative: 'ogaligosesdi', infinitive: 'ogadalisohdi'],
            [subject: 'SG3', object: '', present: 'unaligoha', habitual: 'unaligosoi', remote_past: 'unaligosvi', imperative: 'unaligosesdi', infinitive: 'unadalisohdi'],
            [subject: 'PL3', object: '', present: 'ijaligoha', habitual: 'ijaligosoi', remote_past: 'ijaligosvi', imperative: 'ijaligosesdi', infinitive: 'ijadalisohdi'],
            [subject: 'PL1INCL', object: '', present: 'igaligoha', habitual: 'igaligosoi', remote_past: 'igaligosvi', imperative: 'igaligosesdi', infinitive: 'igadalisohdi']
        ]
    ]

    @Unroll
    def "conjugating Unaligoha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Unaligoha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "oginaligoha"
        "SG1" | "" | Tense.HABITUAL        | "oginaligosoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "oginaligosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "oginaligosesdi"
        "SG1" | "" | Tense.INFINITIVE      | "oginadalisohdi"
        "SG2" | "" | Tense.PRESENT         | "ogaligoha"
        "SG2" | "" | Tense.HABITUAL        | "ogaligosoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "ogaligosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "ogaligosesdi"
        "SG2" | "" | Tense.INFINITIVE      | "ogadalisohdi"
        "SG3" | "" | Tense.PRESENT         | "unaligoha"
        "SG3" | "" | Tense.HABITUAL        | "unaligosoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unaligosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "unaligosesdi"
        "SG3" | "" | Tense.INFINITIVE      | "unadalisohdi"
        "PL3" | "" | Tense.PRESENT         | "ijaligoha"
        "PL3" | "" | Tense.HABITUAL        | "ijaligosoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "ijaligosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "ijaligosesdi"
        "PL3" | "" | Tense.INFINITIVE      | "ijadalisohdi"
        "PL1INCL" | "" | Tense.PRESENT         | "igaligoha"
        "PL1INCL" | "" | Tense.HABITUAL        | "igaligosoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igaligosvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "igaligosesdi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igadalisohdi"
    }
}
