package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Want" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.156-157
 * (printed page numbers of the full 164-page document).
 *
 * Sixteen example sentences, each printed as:
 *   english - the English sentence
 *   a       - the romanized Cherokee sentence
 *   b       - the syllabary Cherokee sentence
 *
 * The sentences are preserved verbatim for later deconstruction work; the
 * "forms" field lists conjugated forms of this verb that each sentence
 * exercises, detected by substring match of the verb-book row forms in the
 * romanized (a) or syllabary (b) line — a heuristic aid, not a replacement
 * for manual analysis; an empty list means no match was found.
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToWantSentenceExamplesSpec extends Specification {

    static final String VERB = "to want"
    static final String SOURCE_PAGE = "pp.156-157"

    /** All sixteen example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "Anna, I want for you to remember me.",
             a: "ana, agwaduli sgwanvdadisdi",
             b: "ᎠᎾ, ᎠᏆᏚᎵ ᏍᏆᏅᏓᏗᏍᏗ",
             forms: []],
            [number: 2,
             english: "When I saw that new car a minute ago, I wanted it.",
             a: "tsitsigowata na itse dagwalelu agwadula",
             b: "ᏥᏥᎪᏩᏔ Ꮎ ᎢᏤ ᏓᏆᎴᎷ ᎠᏆᏚᎳ",
             forms: ["agwadula (Immediate Past Tense)"]],
            [number: 3,
             english: "I always want more money.",
             a: "nigohilv ugodo agwadulisgo adela",
             b: "ᏂᎪᎯᎸ ᎤᎪᏙ ᎠᏆᏚᎵᏍᎪ ᎠᏕᎳ",
             forms: []],
            [number: 4,
             english: "John, I want for you to want that car.",
             a: "tsani, agwaduli tsadulvdi na dagwalelu",
             b: "ᏣᏂ, ᎠᏆᏚᎵ ᏣᏚᎸᏗ Ꮎ ᏓᏆᎴᎷ",
             forms: []],
            [number: 5,
             english: "John and Joe want a new house.",
             a: "tsani ale tsowi unaduli itse galitsode",
             b: "ᏣᏂ ᎠᎴ ᏦᏫ ᎤᎾᏚᎵ ᎢᏤ ᎦᎵᏦᏕ",
             forms: []],
            [number: 6,
             english: "John, I want for you and I to go to the OU/OSU game tomorrow.",
             a: "tsani, agwaduli nihi ale ayv ginenvsdi sinale OU/OSU dinalasgalisgv",
             b: "ᏣᏂ, ᎠᏆᏚᎵ ᏂᎯ ᎠᎴ ᎠᏴ ᎩᏁᏅᏍᏗ ᏏᎾᎴ OU/OSU ᏗᎾᎳᏍᎦᎵᏍᎬ",
             forms: []],
            [number: 7,
             english: "Mary, I want for you to sing a song for me.",
             a: "meli, agwaduli nihi disginogi'edi",
             b: "ᎺᎵ, ᎠᏆᏚᎵ ᏂᎯ ᏗᏍᎩᏃᎩᎡᏗ",
             forms: []],
            [number: 8,
             english: "I like Mary, I love her, and I want her.",
             a: "tsilvgwodi meli ale tsigeyu'a ale tsiyaduli'a",
             b: "ᏥᎸᏉᏗ ᎺᎵ ᎠᎴ ᏥᎨᏳᎠ ᎠᎴ ᏥᏯᏚᎵᎠ",
             forms: ["tsiyaduli'a (Present Tense, First Singular)"]],
            [number: 9,
             english: "John, do you want to eat now?",
             a: "tsani, tsadulihas tsalisdayvdi nogwu?",
             b: "ᏣᏂ, ᏣᏚᎵᎭᏍ ᏣᎵᏍᏓᏴᏗ ᏃᏊ?",
             forms: ["tsaduliha (Present Tense, Second Singular)", "tsaduliha (Present Tense, Third Singular)"]],
            [number: 10,
             english: "Joe and I want for you two boys to go to Tahlequah with us.",
             a: "tsowi ale ayv oginaduli nihi sditali sditsutsa daligwa wigedasdi'i",
             b: "ᏦᏫ ᎠᎴ ᎠᏴ ᎣᎩᎾᏚᎵ ᏂᎯ ᏍᏗᏔᎵ ᏍᏗᏧᏣ ᏓᎵᏆ ᏫᎨᏓᏍᏗᎢ",
             forms: []],
            [number: 11,
             english: "Do you three girls want some of these cookies?",
             a: "itsitso'i itsigeyutsa itsadulihas igada unatseli uniganasda?",
             b: "ᎢᏥᏦᎢ ᎢᏥᎨᏳᏣ ᎢᏣᏚᎵᎭᏍ ᎢᎦᏓ ᎤᎾᏤᎵ ᎤᏂᎦᎾᏍᏓ",
             forms: ["tsaduliha (Present Tense, Second Singular)", "tsaduliha (Present Tense, Third Singular)", "itsaduliha (Present Tense, Third Singular)", "itsaduliha (Present Tense, Second Plural)"]],
            [number: 12,
             english: "I don't want any cookies. I want a Coke.",
             a: "hla uniganasda yidagwaduli. kogi agwaduliha.",
             b: "Ꮭ ᎤᏂᎦᎾᏍᏓ ᏱᏓᏆᏚᎵ. ᎪᎩ ᎠᏆᏚᎵᎭ",
             forms: ["agwaduliha (Present Tense, First Singular)", "agwaduliha (Present Tense, Third Singular)"]],
            [number: 13,
             english: "Before I die I want to go to Germany.",
             a: "asi nagiyohusvnagwu agwaduli anitsvmani wagwedasdi",
             b: "ᎠᏏ ᎾᎩᏲᎱᏒᎾᏊ ᎠᏆᏚᎵ ᎠᏂᏨᎹᏂ ᏩᏇᏓᏍᏗ",
             forms: []],
            [number: 14,
             english: "I always, always want to eat.",
             a: "nigohilv, nigohilv agwadulisgo agwalisdayvdi",
             b: "ᏂᎪᎯᎸ, ᏂᎪᎯᎸ ᎠᏆᏚᎵᏍᎪ ᎠᏆᎵᏍᏓᏴᏗ",
             forms: []],
            [number: 15,
             english: "Just now those four boys wanted to go for a swim.",
             a: "na nvgi iyani anitsutsa unadulisgv unadawo'vsdi'i",
             b: "Ꮎ ᏅᎩ ᎢᏯᏂ ᎠᏂᏧᏣ ᎤᎾᏚᎵᏍᎬ ᎤᎾᏓᏬᎥᏍᏗᎢ",
             forms: []],
            [number: 16,
             english: "Jane, do you want a cup of coffee?",
             a: "tseni, tsadulihasgo ulisgwidi iga kawi?",
             b: "ᏤᏂ, ᏣᏚᎵᎭᏍᎪ ᎤᎵᏍᏈᏗ ᎢᎦ ᎧᏫ?",
             forms: ["tsaduliha (Present Tense, Second Singular)", "tsaduliha (Present Tense, Third Singular)"]],
    ]

    def "example #row.number is recorded with all three lines intact"() {
        expect: "english sentence, romanized line and syllabary line are all preserved"
        row.english && row.a && row.b

        and: "the verb forms it exercises are documented for later deconstruction"
        row.forms != null

        where: "all sixteen verb-book examples"
        row << EXAMPLES
    }

    def "example #row.number: syllabary and romanized lines are non-trivial"() {
        expect:
        row.a.length() > 10
        row.b.length() > 5

        where: "all sixteen verb-book examples"
        row << EXAMPLES
    }

    def "the example collection is complete (sixteen examples)"() {
        expect:
        EXAMPLES*.number == [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
    }
}
