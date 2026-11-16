// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72711) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72711 (entrya ayohiha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AyohihaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Shooting",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsiyoiha, tsiyoiha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jiyoiha', habitual: 'jiyoihoi', remote_past: 'agiyohlvi', imperative: 'jiyoa', infinitive: 'agiyosdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'hiyohiha', habitual: 'hiyohihoi', remote_past: 'jayohlvi', imperative: 'hiyoa', infinitive: '/'],
            [subject: 'SG3', object: '', habitual: 'ayohihoi', imperative: 'hiyoa, hiyoha', infinitive: 'uyosdi', present: 'ayohiha', remote_past: 'uyotlvi'],
            [subject: 'PL3', object: 'SG3AN', present: 'aniyohiha', habitual: 'aniyohihoi', remote_past: 'uniyohlvi', imperative: 'aniyoha', infinitive: 'uniyosdi'],
            [subject: 'PL1INCL', object: 'SG3AN', present: 'idiyohiha', habitual: 'idiyohihoi', remote_past: 'igiyohlvi', imperative: 'idiyoha', infinitive: 'igiyosdi']
        ]
    ]

    @Unroll
    def "conjugating Ayohiha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ayohiha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsiyohiha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "tsiyohihoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "tsiyotlvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsiyotlvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsiyosdi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "hiyohiha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "hiyohihoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "yotlvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "hiyotlvi"
        // "SG2" | "SG3AN" | Tense.INFINITIVE      | "/"
        "SG3" | "SG3AN" | Tense.PRESENT         | "gayohiha"
        "SG3" | "SG3AN" | Tense.HABITUAL        | "ayohihoi"
        "SG3" | "SG3AN" | Tense.REMOTE_PAST     | "uyotlvi"
        "SG3" | "SG3AN" | Tense.FUTURE_COMMAND      | "ayotlvi"
        "SG3" | "SG3AN" | Tense.INFINITIVE      | "uyosdi"
        "PL3" | "SG3AN" | Tense.PRESENT         | "aniyohiha"
        "PL3" | "SG3AN" | Tense.HABITUAL        | "aniyohihoi"
        "PL3" | "SG3AN" | Tense.REMOTE_PAST     | "aniyotlvi"
        "PL3" | "SG3AN" | Tense.FUTURE_COMMAND      | "aniyotlvi"
        "PL3" | "SG3AN" | Tense.INFINITIVE      | "aniyosdi"
        "PL1INCL" | "SG3AN" | Tense.PRESENT         | "ediyohiha"
        "PL1INCL" | "SG3AN" | Tense.HABITUAL        | "ediyohihoi"
        "PL1INCL" | "SG3AN" | Tense.REMOTE_PAST     | "yotlvi"
        "PL1INCL" | "SG3AN" | Tense.FUTURE_COMMAND      | "ediyotlvi"
        "PL1INCL" | "SG3AN" | Tense.INFINITIVE      | "yosdi"
    }
}
