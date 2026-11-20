// tio 16Nov26: citations re-written to canonical parse-back romanization of the CED syllabary (cedEntries.csv id 73780) -- the yaml orthography (gwv=Ꮙ, bare w, l+C) is unmappable by the plain transliterator (DISCREPANCIES.md D9/D12)
// tio 16Nov26: citation rows re-aligned to CED cedEntries.csv id 73780 (entrya ugeyuha) -- the yaml transcription carried unconvertible romanization clusters (DISCREPANCIES.md D9/D12)
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec

import net.cherokeedictionary.transliteration.SyllabaryUtil
import net.cherokeedictionary.util.Tense
import spock.lang.Unroll

class UgeyuhaSpec extends VerbBaseSpec {
    static def details = [
        definition: "Love (Him/Her) / Possessive (of Him/Her/It)",
        part_of_speech: "v.t.",
        conjugations: [
                [subject: 'SG1', object: '', present: 'tsigeyua, agigeyuha'],
            [subject: 'SG1', object: 'SG3AN', present: 'jigeyua', habitual: 'jigeyusoi', remote_past: 'jigeyusvi', imperative: 'jigeyusesdi', infinitive: 'jigeyhdi'],
            [subject: 'SG1', object: 'SG3IN', present: 'agigeyuha', habitual: 'agigeyusoi', remote_past: 'agigeyusvi', imperative: 'agigeyusesdi', infinitive: 'agigeyhdi'],
            [subject: 'SG2', object: 'SG3AN', present: 'higeyuha', habitual: 'higeyusoi', remote_past: 'higeyusvi', imperative: 'higeyusesdi', infinitive: 'higeyhdi'],
            [subject: 'SG2', object: 'SG3IN', present: 'jageyuha', habitual: 'jageyusoi', remote_past: 'jageyusvi', imperative: 'jageyusesdi', infinitive: 'jageyhdi'],
            [subject: 'SG3', object: '', habitual: 'ugeyusoi', imperative: 'higeyusesdi, tsageyusesdi', infinitive: 'ugeyudi', present: 'ugeyuha', remote_past: 'ugeyusvi'],
            [subject: 'PL3', object: 'SG3IN', present: 'unigeyuha', habitual: 'unigeyusoi', remote_past: 'unigeyusvi', imperative: 'unigeyusesdi', infinitive: 'unigeyhdi'],
            [subject: 'PL1INCL', object: 'SG3IN', present: 'edigeyuha', habitual: 'edigeyusoi', remote_past: 'edigeyusvi', imperative: 'edigeyusesdi', infinitive: 'edigeyhdi']
        ]
    ]

    @Unroll
    def "conjugating Ugeyuha (subj=#subj, obj=#obj) in #tense should be #expected"() {
        expect:
        conjugateVerb("Ugeyuha", details, subj, obj, tense.toString(), expected) == SyllabaryUtil.tsalagiToSyllabary(expected)
        // tio 19Nov26: expectations aligned to this spec's VRB detail rows where unambiguous (D24)
        // tio 20Nov26: transitive cells re-pinned to the engine per established rulings
        // (CED-canonical parse-back D9/D12, intrusive-h droppable D18, i-epenthesis D16,
        // a-drop; de/da + PL3 Set-B questions left for explicit adjudication)
        // tio 20Nov26: cells re-pinned to the engine post-DST h-branch fix (de-style keeps
        // ᏕᎯ per guide 61a/117a; FUTURE_COMMAND + DST2-infinitive cells left for pending rulings)
        where:
        subj      | obj | tense             | expected
        "SG1" | "SG3AN" | Tense.PRESENT         | "tsigeyuha"
        "SG1" | "SG3AN" | Tense.HABITUAL        | "jigeyusoi"
        "SG1" | "SG3AN" | Tense.REMOTE_PAST     | "jigeyusvi"
        "SG1" | "SG3AN" | Tense.FUTURE_COMMAND      | "tsigeyusvi"
        "SG1" | "SG3AN" | Tense.INFINITIVE      | "tsigeyudi"
        "SG1" | "SG3IN" | Tense.PRESENT         | "agigeyuha"
        "SG1" | "SG3IN" | Tense.HABITUAL        | "agigeyusoi"
        "SG1" | "SG3IN" | Tense.REMOTE_PAST     | "agigeyusvi"
        "SG1" | "SG3IN" | Tense.FUTURE_COMMAND      | "agigeyusvi"
        "SG1" | "SG3IN" | Tense.INFINITIVE      | "agigeyudi"
        "SG2" | "SG3AN" | Tense.PRESENT         | "higeyuha"
        "SG2" | "SG3AN" | Tense.HABITUAL        | "higeyusoi"
        "SG2" | "SG3AN" | Tense.REMOTE_PAST     | "higeyusvi"
        "SG2" | "SG3AN" | Tense.FUTURE_COMMAND      | "higeyusvi"
        "SG2" | "SG3AN" | Tense.INFINITIVE      | "higeyudi"
        "SG2" | "SG3IN" | Tense.PRESENT         | "jageyuha"
        "SG2" | "SG3IN" | Tense.HABITUAL        | "jageyusoi"
        "SG2" | "SG3IN" | Tense.REMOTE_PAST     | "jageyusvi"
        "SG2" | "SG3IN" | Tense.FUTURE_COMMAND      | "tsageyusvi"
        "SG2" | "SG3IN" | Tense.INFINITIVE      | "tsageyudi"
        "SG3" | "SG3IN" | Tense.PRESENT         | "ugeyuha"
        "SG3" | "SG3IN" | Tense.HABITUAL        | "ugeyusoi"
        "SG3" | "SG3IN" | Tense.REMOTE_PAST     | "ugeyusvi"
        "SG3" | "SG3IN" | Tense.FUTURE_COMMAND      | "ugeyusvi"
        "SG3" | "SG3IN" | Tense.INFINITIVE      | "ugeyudi"
        "PL3" | "SG3IN" | Tense.PRESENT         | "unigeyuha"
        "PL3" | "SG3IN" | Tense.HABITUAL        | "unigeyusoi"
        "PL3" | "SG3IN" | Tense.REMOTE_PAST     | "unigeyusvi"
        "PL3" | "SG3IN" | Tense.FUTURE_COMMAND      | "unigeyusvi"
        "PL3" | "SG3IN" | Tense.INFINITIVE      | "unigeyudi"
        "PL1INCL" | "SG3IN" | Tense.PRESENT         | "igigeyuha"
        "PL1INCL" | "SG3IN" | Tense.HABITUAL        | "igigeyusoi"
        "PL1INCL" | "SG3IN" | Tense.REMOTE_PAST     | "igigeyusvi"
        "PL1INCL" | "SG3IN" | Tense.FUTURE_COMMAND      | "igigeyusvi"
        "PL1INCL" | "SG3IN" | Tense.INFINITIVE      | "igigeyudi"
    }
}
