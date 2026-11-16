// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73897 (entrya unaligoha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'ogaligoha'],
            [subject: 'SG1', object: '', present: 'oginaligoha', habitual: 'oginaligosoi', remote_past: 'oginaligosvi', imperative: 'oginaligosesdi', infinitive: 'oginadalisohdi'],
            [subject: 'SG2', object: '', present: 'ogaligoha', habitual: 'ogaligosoi', remote_past: 'ogaligosvi', imperative: 'ogaligosesdi', infinitive: 'ogadalisohdi'],
            [subject: 'SG3', object: '', habitual: 'unaligosoi', imperative: 'ijaligosesdi', infinitive: '----', present: 'unaligoha', remote_past: 'unaligosvi'],
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
        "SG1" | "" | Tense.PRESENT         | "aginaligoha"
        "SG1" | "" | Tense.HABITUAL        | "aginaligosoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aginaligosvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "aginaligosvi"
        "SG1" | "" | Tense.INFINITIVE      | "aginadalisodi"
        "SG2" | "" | Tense.PRESENT         | "tsanaligoha"
        "SG2" | "" | Tense.HABITUAL        | "tsanaligosoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsanaligosvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "tsanaligosvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsanadalisodi"
        "SG3" | "" | Tense.PRESENT         | "unaligoha"
        "SG3" | "" | Tense.HABITUAL        | "unaligosoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "unaligosvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "unaligosvi"
        "SG3" | "" | Tense.INFINITIVE      | "unadalisodi"
        "PL3" | "" | Tense.PRESENT         | "uninaligoha"
        "PL3" | "" | Tense.HABITUAL        | "uninaligosoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uninaligosvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "uninaligosvi"
        "PL3" | "" | Tense.INFINITIVE      | "uninadalisodi"
        "PL1INCL" | "" | Tense.PRESENT         | "iginaligoha"
        "PL1INCL" | "" | Tense.HABITUAL        | "iginaligosoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iginaligosvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iginaligosvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iginadalisodi"
    }
}
