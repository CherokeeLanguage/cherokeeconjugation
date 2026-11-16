// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72404 (entrya ahyega) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhyegaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Take Somewaere (neutral)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyega'],
            [subject: 'SG1', object: '', present: 'jiyega', habitual: 'jiyegoi', remote_past: 'akiyvsvi', imperative: 'wijiyvga', infinitive: 'akiyvsdi'],
            [subject: 'SG2', object: '', present: 'hihyega', habitual: 'hihyegoi', remote_past: 'chayvsvi', imperative: 'hwihyvga', infinitive: 'chayvsdi'],
            [subject: 'SG3', object: '', habitual: 'ahyegoi', imperative: 'hihyuga', infinitive: 'uhyvsdi', present: 'ahyega', remote_past: 'uhyvsvi'],
            [subject: 'PL3', object: '', present: 'anihyega', habitual: 'anihyegoi', remote_past: 'unihyvsvi', imperative: 'anihyvga', infinitive: 'unihyvsdi']
        ]
    ]

    @Unroll
    def "conjugating Ahyega (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahyega", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "tsiyega"
        "SG1" | "" | Tense.HABITUAL        | "tsiyegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "agiyvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiyvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "agiyvsdi"
        "SG2" | "" | Tense.PRESENT         | "hiyega"
        "SG2" | "" | Tense.HABITUAL        | "hiyegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsayvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiyvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsayvsdi"
        "SG3" | "" | Tense.PRESENT         | "ayega"
        "SG3" | "" | Tense.HABITUAL        | "ayegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ayvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "uyvsdi"
        "PL3" | "" | Tense.PRESENT         | "aniyega"
        "PL3" | "" | Tense.HABITUAL        | "aniyegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniyvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyvsdi"
    }
}
