package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Flexible" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.54-55
 * (printed page numbers of the full 164-page document).
 *
 * Seven example sentences, each printed as:
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
class ToHaveSomethingFlexibleSentenceExamplesSpec extends Specification {

    static final String VERB = "to have something flexible"
    static final String SOURCE_PAGE = "pp.54-55"

    /** All seven example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "My car has a new water hose.",
             a: "agwatseli dagwalelu itse nigvn(v)di ama ulohisdi'i",
             b: "ᎠᏆᏤᎵ ᏓᏆᎴᎷ ᎢᏤ ᏂᎬᏅᏗ ᎠᎹ ᎤᎶᎯ ᏍᏗᎢ",
             forms: []],
            [number: 2,
             english: "Mary, do you have a five dollar bill?",
             a: "meli, hisg(i) adelvs tsa'la(a)?",
             b: "ᎺᎵ, ᎯᏍᎩ ᎠᏕᎸᏍ ᏣᎳᎠ?",
             forms: []],
            [number: 3,
             english: "I don't have any bills but I have a lot in change.",
             a: "hla adelv yidagi'la asesgini ts(u)quisdi anisdayi adelv dagihla",
             b: "Ꮭ ᎠᏕᎸ ᏱᏓᎩᎳ ᎠᏎᏍᎩᏂ ᏧᏈᏍᏗ ᎠᏂᏍᏓᏱ ᎠᏕᎸ ᏓᎩᏝ",
             forms: []],
            [number: 4,
             english: "That boy has many arrows and he also has two bows.",
             a: "na achutsa ts(u)quisdi digatlida duwvya ale tali digal(i)tsa'di duwvya",
             b: "Ꮎ ᎠᏧᏣ ᏧᏈᏍᏗ ᏗᎦᏟᏓ ᎠᎴ ᏔᎵᎭ ᏗᎦᎵᏣᏗ ᏚᏮᏯ",
             forms: []],
            [number: 5,
             english: "John has a new garden hose.",
             a: "tsani una'a itse usvdoni ahwisvdi ama tsusdudlisdodi",
             b: "ᏣᏂ ᎤᎾᎠ ᎢᏤ ᎤᏒᏙᏂ ᎠᏫᏒᏗ ᎠᎹ ᏧᏍᏚᏟᏍᏙᏗ",
             forms: []],
            [number: 6,
             english: "When John gets paid he will have new tires.",
             a: "tsani agagwiyv'elv ditse ditlvdi dutla'esdi",
             b: "ᏣᏂ ᎠᎦᏈᏴᎡᎸ ᏗᏤ ᏗᏢᏗ ᏚᏝᎡᏍᏗ",
             forms: []],
            [number: 7,
             english: "I have one coat but my brother had two.",
             a: "sagwu gasaleni agina'a asehno tsosdadanvhli ta'li duna'a",
             b: "ᏌᏊ ᎦᏌᎴᏂ ᎠᎩᎾᎠ ᎠᏎᏃ ᏦᏍᏓᏓᏅᎵ ᏔᎵ ᏚᎾᎠ",
             forms: ["ᎠᎩᎾᎠ (Present Tense, First Singular)", "duna'a (Present Tense, Third Singular)"]],
    ]

    def "example #row.number is recorded with all three lines intact"() {
        expect: "english sentence, romanized line and syllabary line are all preserved"
        row.english && row.a && row.b

        and: "the verb forms it exercises are documented for later deconstruction"
        row.forms != null

        where: "all seven verb-book examples"
        row << EXAMPLES
    }

    def "example #row.number: syllabary and romanized lines are non-trivial"() {
        expect:
        row.a.length() > 10
        row.b.length() > 5

        where: "all seven verb-book examples"
        row << EXAMPLES
    }

    def "the example collection is complete (seven examples)"() {
        expect:
        EXAMPLES*.number == [1, 2, 3, 4, 5, 6, 7]
    }
}
