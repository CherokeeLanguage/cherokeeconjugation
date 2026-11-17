// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 72405) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72405 (entrya ahyeha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AhyehaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Have With / Hold in Hand (neutral)",
        // tio 17Nov26: glottal-initial stem -- the 2012 book (p.84) prints SG1 ji-yeha on
        // every tense row (ji'yeha / ji'yeho'i / ji'yehv'i / ji'yehesdi / ji'yehi); the yaml
        // dropped the glottal apostrophes and carried tsiyeha/agiyeh-. D14: the engine's
        // SG1 ji- swap is registered lexically from this flag.
        glottalInitial: true,
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'jiyeha'],
            [subject: 'SG1', object: '', present: 'jiyeha', habitual: 'jiyehoi', remote_past: 'jiyehvi', imperative: 'jiyehesdi', infinitive: 'jiyehi'],
            [subject: 'SG2', object: '', present: 'hihyeha', habitual: 'hihyehoi', remote_past: 'hihyehvi', imperative: 'hihyehesdi', infinitive: 'hihyehi'],
            // tio 17Nov26: SG3 imperative supplied from the 2012 book (p.84: ahyehesdi) -- the yaml left it empty.
            [subject: 'SG3', object: '', habitual: "ayehoi", imperative: 'ahyehesdi', infinitive: "gahyehi", present: "ayeha", remote_past: 'ayehvi'],
            [subject: 'PL3', object: '', present: 'anihyeha', habitual: 'anihyehoi', remote_past: 'anihyehvi', imperative: 'anihyehesdi', infinitive: 'anihyehi']
        ]
    ]

    @Unroll
    def "conjugating Ahyeha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ahyeha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "jiyeha"
        "SG1" | "" | Tense.HABITUAL        | "jiyehoi"
        // tio 17Nov26: SG1 cells re-aligned to book p.84 (ji- glottal allomorph, D14).
        "SG1" | "" | Tense.REMOTE_PAST     | "jiyehvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "jiyehvi"
        "SG1" | "" | Tense.INFINITIVE      | "jiyehi"
        "SG2" | "" | Tense.PRESENT         | "hiyeha"
        "SG2" | "" | Tense.HABITUAL        | "hiyehoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsayehvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hiyehvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsayehi"
        "SG3" | "" | Tense.PRESENT         | "ayeha"
        "SG3" | "" | Tense.HABITUAL        | "ayehoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "uyehvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "ayehvi"
        "SG3" | "" | Tense.INFINITIVE      | "uyehi"
        "PL3" | "" | Tense.PRESENT         | "aniyeha"
        "PL3" | "" | Tense.HABITUAL        | "aniyehoi"
        "PL3" | "" | Tense.REMOTE_PAST     | "uniyehvi"
        "PL3" | "" | Tense.FUTURE_COMMAND      | "aniyehvi"
        "PL3" | "" | Tense.INFINITIVE      | "uniyehi"
    }
}
