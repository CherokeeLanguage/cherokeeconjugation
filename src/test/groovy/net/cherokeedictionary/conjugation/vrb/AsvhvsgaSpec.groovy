package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AsvhvsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Using/Drinking/Eating It Up (57)",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG1', object: '', present: 'jisvhvsga', habitual: 'jisvhvsgoi', remote_past: 'aksvhnvi', imperative: 'jisvhna', infinitive: 'aksvhvsdi'],
            [subject: 'SG2', object: '', present: 'hisvhvsga', habitual: 'hisvhvsgoi', remote_past: 'tsvhnvi', imperative: 'hisvhna', infinitive: 'tsvhvsdi'],
            [subject: 'SG3', object: '', present: 'asvhvsga', habitual: 'asvhvsgoi', remote_past: 'usvhnvi', imperative: 'asvhna', infinitive: 'usvhvsdi'],
            [subject: 'PL3', object: '', present: 'anisvhvsga', habitual: 'anisvhvsgoi', remote_past: 'unisvhnvi', imperative: 'anisvhna', infinitive: 'unisvhvsdi'],
            [subject: 'PL1INCL', object: '', present: 'idisvhvsga', habitual: 'idisvhvsgoi', remote_past: 'iksvhnvi', imperative: 'idisvhna', infinitive: 'iksvhvsdi']
        ]
    ]

    @Unroll
    def "conjugating Asvhvsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Asvhvsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jisvhvsga"
        "SG1" | "" | Tense.HABITUAL        | "jisvhvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aksvhnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jisvhna"
        "SG1" | "" | Tense.INFINITIVE      | "aksvhvsdi"
        "SG2" | "" | Tense.PRESENT         | "hisvhvsga"
        "SG2" | "" | Tense.HABITUAL        | "hisvhvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsvhnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisvhna"
        "SG2" | "" | Tense.INFINITIVE      | "tsvhvsdi"
        "SG3" | "" | Tense.PRESENT         | "asvhvsga"
        "SG3" | "" | Tense.HABITUAL        | "asvhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usvhnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asvhna"
        "SG3" | "" | Tense.INFINITIVE      | "usvhvsdi"
        "PL3" | "" | Tense.PRESENT         | "anisvhvsga"
        "PL3" | "" | Tense.HABITUAL        | "anisvhvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisvhnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisvhna"
        "PL3" | "" | Tense.INFINITIVE      | "unisvhvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisvhvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisvhvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "iksvhnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisvhna"
        "PL1INCL" | "" | Tense.INFINITIVE      | "iksvhvsdi"
    }
}
