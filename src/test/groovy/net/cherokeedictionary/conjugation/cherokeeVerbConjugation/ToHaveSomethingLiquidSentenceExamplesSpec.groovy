package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Liquid, in a container" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.60-61
 * (printed page numbers of the full 164-page document).
 *
 * Five example sentences, each printed as:
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
class ToHaveSomethingLiquidSentenceExamplesSpec extends Specification {

    static final String VERB = "to have something liquid, in a container"
    static final String SOURCE_PAGE = "pp.60-61"

    /** All five example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "Mary, do you have a drink?",
             a: "meli, koki's tsaneha?",
             b: "ᎺᎵ, ᎠᏗᏔᏍᏗᏍ ᏣᏁᎭ?",
             forms: []],
            [number: 2,
             english: "I have water in my hands. (if hands are cupped)",
             a: "ama agineha digwoyeniyi",
             b: "ᎠᎹ ᎠᎩᏁᎭ ᏗᏉᏰᏂᏱ",
             forms: ["ᎠᎩᏁᎭ (Present Tense, First Singular)"]],
            [number: 3,
             english: "The earth has many oceans.",
             a: "ugodi amegwo dudotlvha ahani elohi",
             b: "ᎤᎪᏗ ᎠᎺᏉ ᏚᏙᏢᎭ ᎠᎭᏂ ᎡᎶᎯ",
             forms: []],
            [number: 4,
             english: "Tomorrow I will have some water.",
             a: "sanale iyv am(a) aginehesdi",
             b: "ᏌᎾᎴ ᎢᏴ ᎠᎹ ᎠᎩᏁᎮᏍᏗ",
             forms: ["ᎠᎩᏁᎮᏍᏗ (Future Tense, First Singular)", "ᎠᎩᏁᎮᏍᏗ (Future Imperative/Volative, First Singular)", "aginehesdi (Immediate Imperative/Volative, First Singular)"]],
            [number: 5,
             english: "I have a container of oil.",
             a: "go'i adlisdv'i agineho'i",
             b: "ᎪᎢ ᎠᏟᏍᏛ ᎠᎩᏁᎭ",
             forms: ["ᎠᎩᏁᎭ (Present Tense, First Singular)"]],
    ]

    def "example #row.number is recorded with all three lines intact"() {
        expect: "english sentence, romanized line and syllabary line are all preserved"
        row.english && row.a && row.b

        and: "the verb forms it exercises are documented for later deconstruction"
        row.forms != null

        where: "all five verb-book examples"
        row << EXAMPLES
    }

    def "example #row.number: syllabary and romanized lines are non-trivial"() {
        expect:
        row.a.length() > 10
        row.b.length() > 5

        where: "all five verb-book examples"
        row << EXAMPLES
    }

    def "the example collection is complete (five examples)"() {
        expect:
        EXAMPLES*.number == [1, 2, 3, 4, 5]
    }
}
