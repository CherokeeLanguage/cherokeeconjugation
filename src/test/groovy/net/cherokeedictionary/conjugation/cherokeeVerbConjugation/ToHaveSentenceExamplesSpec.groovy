package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have (a living being)" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.43
 * (printed page numbers of the full 164-page document).
 *
 * Four example sentences, each printed as:
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
class ToHaveSentenceExamplesSpec extends VerbBaseSpec {

    static final String VERB = "to have (a living being)"
    static final String SOURCE_PAGE = "p.43"

    /** All four example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "How many children do you have?",
             a: "hilaiga tsuwets(i) detsakaha",
             b: "ᎯᎳᎢᎦ ᏧᏪᏥ ᏕᏣᎧᎭ",
             forms: ["tsakaha (Present Tense, Third Singular)"]],
            [number: 2,
             english: "I have three children.",
             a: "tsoʔi iyani digwets(i) dagikaha",
             b: "ᏦᎢ ᎢᏯᏂ ᏗᏇᏥ ᏓᎩᎧᎭ",
             forms: ["agikaha (Present Tense, Third Singular)"]],
            [number: 3,
             english: "I think he/she has two kids.",
             a: "taʔli iyani diniyohl(i) tsuwakaha",
             b: "ᏔᎵ ᎢᏯᏂ ᏗᏂᏲᎵ ᏧᏩᎧᎭ",
             forms: ["uwakaha (Present Tense, Third Singular)"]],
            [number: 4,
             english: "I heard he has another woman. (idiomatic for 'having another girlfriend')",
             a: "soʔihnv agehy(v) uwaka(ha) agw(a)tvganvʔi",
             b: "ᏍᏐᎢᏅ ᎠᎨᏴ ᎤᏩᎧᎭ ᎠᏆᏛᎦᏅᎢ",
             forms: ["ᎤᏩᎧᎭ (Present Tense, Third Singular)"]],
    ]

    def "example #row.number is recorded with all three lines intact"() {
        expect: "english sentence, romanized line and syllabary line are all preserved"
        row.english && row.a && row.b

        and: "the verb forms it exercises are documented for later deconstruction"
        row.forms != null

        where: "all four verb-book examples"
        row << EXAMPLES
    }

    def "example #row.number: syllabary and romanized lines are non-trivial"() {
        expect:
        row.a.length() > 10
        row.b.length() > 5

        where: "all four verb-book examples"
        row << EXAMPLES
    }

    def "the example collection is complete (four examples)"() {
        expect:
        EXAMPLES*.number == [1, 2, 3, 4]
    }
}
