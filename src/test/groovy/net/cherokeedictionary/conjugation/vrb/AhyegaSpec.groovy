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
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiyega"
        "SG1" | "" | Tense.HABITUAL        | "jiyegoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "akiyvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "tsiyvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "akiyvsdi"
        "SG2" | "" | Tense.PRESENT         | "hihyega"
        "SG2" | "" | Tense.HABITUAL        | "hihyegoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "chayvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiyvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "chayvsdi"
        "SG3" | "" | Tense.PRESENT         | "ahyega"
        "SG3" | "" | Tense.HABITUAL        | "ahyegoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uhyvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ayvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "uhyvsdi"
        "PL3" | "" | Tense.PRESENT         | "anihyega"
        "PL3" | "" | Tense.HABITUAL        | "anihyegoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unihyvsvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniyvsvi"
        "PL3" | "" | Tense.INFINITIVE      | "unihyvsdi"
    }
}
