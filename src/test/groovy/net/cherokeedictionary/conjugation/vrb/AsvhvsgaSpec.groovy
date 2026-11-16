// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72651 (entrya asvhvsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
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
                [subject: 'SG1', object: '', present: 'jisvhvsga'],
            [subject: 'SG1', object: '', present: 'jisvhvsga', habitual: 'jisvhvsgoi', remote_past: 'aksvhnvi', imperative: 'jisvhna', infinitive: 'aksvhvsdi'],
            [subject: 'SG2', object: '', present: 'hisvhvsga', habitual: 'hisvhvsgoi', remote_past: 'tsvhnvi', imperative: 'hisvhna', infinitive: 'tsvhvsdi'],
            [subject: 'SG3', object: '', habitual: 'asvhvsgoi', imperative: 'hisvhna', infinitive: 'usvhvsdi', present: 'asvhvsga', remote_past: 'usvhnvi'],
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
        "SG1" | "" | Tense.PRESENT         | "tsisvhvsga"
        "SG1" | "" | Tense.HABITUAL        | "tsisvhvsgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agisvnvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsisvnvi"
        "SG1" | "" | Tense.INFINITIVE      | "agisvhvsdi"
        "SG2" | "" | Tense.PRESENT         | "hisvhvsga"
        "SG2" | "" | Tense.HABITUAL        | "hisvhvsgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsasvnvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hisvnvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsasvhvsdi"
        "SG3" | "" | Tense.PRESENT         | "asvhvsga"
        "SG3" | "" | Tense.HABITUAL        | "asvhvsgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "usvnvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "asvnvi"
        "SG3" | "" | Tense.INFINITIVE      | "usvhvsdi"
        "PL3" | "" | Tense.PRESENT         | "anisvhvsga"
        "PL3" | "" | Tense.HABITUAL        | "anisvhvsgoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unisvnvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anisvnvi"
        "PL3" | "" | Tense.INFINITIVE      | "unisvhvsdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idisvhvsga"
        "PL1INCL" | "" | Tense.HABITUAL        | "idisvhvsgoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igisvnvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "idisvnvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igisvhvsdi"
    }
}
