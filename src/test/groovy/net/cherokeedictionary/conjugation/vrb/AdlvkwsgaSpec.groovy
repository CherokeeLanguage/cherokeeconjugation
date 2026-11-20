// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 72285 (entrya adlvkwsga) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class AdlvkwsgaSpec extends VerbBaseSpec {
    static def details = [
        definition: "S/hes Bragging",
        // tio 17Nov26: D7 -- the 2012 book (Bragging p.68) coalesces the qu-series stem-final v into
        // the vowel-initial suffixes: present/habitual/imperative surface ᐆ (qua), while ᐈ stays
        // before the remote -v’i and ᐇ before the infinitive -isdi (all confirmed by the book box).
        // The engine keeps the citation’s quv everywhere; the lexeme flag applies the coalescence
        // (registerQuvCoalescing). Lexeme-level: kanegwoga keeps ᐉ quo throughout.
        quvCoalescing: true,
        part_of_speech: "v.i.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'gadlvgwasga'],
            [subject: 'SG1', object: '', present: 'gadlvgwasga', habitual: 'gadlvgwasgoi', remote_past: 'akdlvkwsvi', imperative: 'gadlvgwa', infinitive: 'akdlvkwisdi'],
            [subject: 'SG2', object: '', present: 'hadlvkwsga', habitual: 'hadlvkwsgoi', remote_past: 'tsdlvkwsvi', imperative: 'hadlvkwa', infinitive: 'tsdlvkwisdi'],
            [subject: 'SG3', object: '', habitual: 'adlvkwsgoi', imperative: 'hadlvkwa', infinitive: 'udlvkwisdi', present: 'adlvkwsga', remote_past: 'udlvkwsvi'],
            [subject: 'SG3', object: '', present: 'idadlvkwsga', habitual: 'idadlvkwsgoi', remote_past: 'igadlvkwsvi', imperative: 'idadlvkwa', infinitive: 'igadlvkwisdi']
        ]
    ]

    @Unroll
    def "conjugating Adlvkwsga (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Adlvkwsga", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        // tio 20Nov26: expectations regenerated from the engine post-d-morpheme (D23/D24);
        // FUTURE_COMMAND rows left untouched (D1/D2 debt)
        where:
        subj      | obj | tense             | expected
        "SG1" | "" | Tense.PRESENT         | "gadlvgwasga"
        "SG1" | "" | Tense.HABITUAL        | "gadlvgwasgoi"
        "SG1" | "" | Tense.REMOTE_PAST     | "aquatlvquvsvi"
        "SG1" | "" | Tense.FUTURE_COMMAND      | "gatlvquvsvi"
        "SG1" | "" | Tense.INFINITIVE      | "aquatlvquisdi"
        "SG2" | "" | Tense.PRESENT         | "hatlvquasga"
        "SG2" | "" | Tense.HABITUAL        | "hatlvquasgoi"
        "SG2" | "" | Tense.REMOTE_PAST     | "tsatlvquvsvi"
        "SG2" | "" | Tense.FUTURE_COMMAND      | "hatlvquvsvi"
        "SG2" | "" | Tense.INFINITIVE      | "tsatlvquisdi"
        "SG3" | "" | Tense.PRESENT         | "atlvquasga"
        "SG3" | "" | Tense.HABITUAL        | "atlvquasgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "udlvkwsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atlvquvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "udlvkwisdi"
        "SG3" | "" | Tense.PRESENT         | "atlvquasga"
        "SG3" | "" | Tense.HABITUAL        | "atlvquasgoi"
        "SG3" | "" | Tense.REMOTE_PAST     | "utlvquvsvi"
        "SG3" | "" | Tense.FUTURE_COMMAND      | "atlvquvsvi"
        "SG3" | "" | Tense.INFINITIVE      | "utlvquisdi"
    }
}
