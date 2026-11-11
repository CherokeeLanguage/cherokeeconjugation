package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Fall (a living being)" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.34-35
 * (printed page numbers of the full 164-page document).
 *
 * Ten example sentences, each printed as:
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
class ToFallSentenceExamplesSpec extends Specification {

    static final String VERB = "to fall (a living being)"
    static final String SOURCE_PAGE = "pp.34-35"

    /** All ten example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "John, when you run, you fall.",
             a: "tsani, yitsadanaw(i)stana hinvgo'i",
             b: "ᏣᏂ, ᏱᏣᏓᎾᏫᏍᏔᎾ ᎯᏅᎪᎢ",
             forms: ["hinvgo'i (Present Habitual, Second Singular)"]],
            [number: 2,
             english: "Last year I fell and broke my leg.",
             a: "sudetiyvda tsigesv aginvtsv'i ale tsagwatvlesv'i",
             b: "ᏑᏕᏘᏴᏓ ᏥᎨᏒ ᎠᎩᏅᏨᎢ ᎠᎴ ᏣᏆᏛᎴᏒᎢ",
             forms: ["aginvtsv'i (Remote Past Tense, First Singular)"]],
            [number: 3,
             english: "You and I fell onto a wasps' nest.",
             a: "kanatsisdetsi unanesdahlahv widegininvtsv'i",
             b: "ᎧᎾᏥᏍᏕᏥ ᎤᎾᏁᏍᏓᎳᎲ ᏫᏕᎩᏂᏅᏨᎢ",
             forms: ["degininvtsv'i (Remote Past Tense, First Dual Inclusive)"]],
            [number: 4,
             english: "John, if you run fast, you will fall.",
             a: "tsani, enuli yihadanaw(i)stana tinvtsi",
             b: "ᏣᏂ, ᎡᏄᎵ ᏱᎭᏓᎾᏫᏍᏔᎾ ᏘᏅᏥ",
             forms: []],
            [number: 5,
             english: "Mary, if you slow down, you will not fall.",
             a: "meli, yits(a)sganolada, tla yitinvtsi",
             b: "ᎺᎵ, ᏱᏣᏍᎦᏃᎳᏓ, Ꮭ ᏱᏘᏅᏥ",
             forms: []],
            [number: 6,
             english: "All six of you fall down!",
             a: "nigada sudal(i) itsi'i itsinvgi",
             b: "ᏂᎦᏓ ᏑᏓᎵ ᎢᏥᎢ ᎢᏥᏅᎩ",
             forms: ["tsinvgi (Immediate Imperative/Volative, First Singular)", "tsinvgi (Immediate Past, First Singular)"]],
            [number: 7,
             english: "You two fall down later!",
             a: "desdinvtsv'i",
             b: "ᏕᏍᏗᏅᏨᎢ",
             forms: ["desdinvtsv'i (Remote Past Tense, Second Dual)", "desdinvtsv'i (Future Imperative/Volative, Second Dual)"]],
            [number: 8,
             english: "The runner is always falling.",
             a: "na adanaw(i)sdisgi nigohilv unvtsati",
             b: "Ꮎ ᎠᏓᎾᏫᏍᏗᏍᎩ ᏂᎪᎯᎸ ᎤᏅᏣᏘ",
             forms: []],
            [number: 9,
             english: "When I run in the morning, it isn't so hot.",
             a: "Yagwadanaw(i)stana sanale'i, tlado yudihlego'i",
             b: "ᏯᏆᏓᎾᏫᏍᏔᎾ ᏌᎾᎴᎢ, ᏝᏙ ᏳᏗᎴᎪᎢ",
             forms: []],
            [number: 10,
             english: "John, fall down right now!",
             a: "tsani, hinvgi nogwu tsigi!",
             b: "ᏣᏂ, ᎯᏅᎩ ᏃᏊ ᏥᎩ",
             forms: ["hinvgi (Immediate Imperative/Volative, Second Singular)", "hinvgi (Immediate Past, Second Singular)"]],
    ]

    def "example #row.number is recorded with all three lines intact"() {
        expect: "english sentence, romanized line and syllabary line are all preserved"
        row.english && row.a && row.b

        and: "the verb forms it exercises are documented for later deconstruction"
        row.forms != null

        where: "all ten verb-book examples"
        row << EXAMPLES
    }

    def "example #row.number: syllabary and romanized lines are non-trivial"() {
        expect:
        row.a.length() > 10
        row.b.length() > 5

        where: "all ten verb-book examples"
        row << EXAMPLES
    }

    def "the example collection is complete (ten examples)"() {
        expect:
        EXAMPLES*.number == [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    }
}
