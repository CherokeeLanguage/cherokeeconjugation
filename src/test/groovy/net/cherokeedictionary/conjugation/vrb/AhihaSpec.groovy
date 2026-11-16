// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72348 (entrya ahiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Killing (Him/It)",
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiiha'],
            [subject: 'SG3', object: '', habitual: 'ahihoi', imperative: 'hiluga', infinitive: 'uhisdi', present: 'ahiha', remote_past: 'uhlvi'],
            [subject: 'PL3', object: '', present: 'anihiha', habitual: 'anihihoi', remote_past: 'unihlvi', imperative: 'aniluga', infinitive: 'unihisdi'],
            [subject: 'PL1INCL', object: '', present: 'idihiha', habitual: 'idihihoi', remote_past: 'igihlvi', imperative: 'idiluga', infinitive: 'igihisdi']
        ]
    ]

    @Unroll
    def "conjugating Ahiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG3" | "" | Tense.PRESENT         | "ahiha"
        "SG3" | "" | Tense.HABITUAL        | "ahihoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utlvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atlvi"
        "SG3" | "" | Tense.INFINITIVE      | "uhisdi"
        "PL3" | "" | Tense.PRESENT         | "anihiha"
        "PL3" | "" | Tense.HABITUAL        | "anihihoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "unitlvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "anitlvi"
        "PL3" | "" | Tense.INFINITIVE      | "unihisdi"
        "PL1INCL" | "" | Tense.PRESENT         | "idihiha"
        "PL1INCL" | "" | Tense.HABITUAL        | "idihihoi"
        "PL1INCL" | "" | Tense.REMOTE_PAST     | "igitlvi"
        "PL1INCL" | "" | Tense.FUTURE_COMMAND      | "iditlvi"
        "PL1INCL" | "" | Tense.INFINITIVE      | "igihisdi"
    }
}
