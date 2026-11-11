package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Hide someone or something" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.75-76
 * (printed page numbers of the full 164-page document).
 *
 * Nine example sentences, each printed as:
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
class ToHideSomeoneOrSomethingSentenceExamplesSpec extends Specification {

    static final String VERB = "to hide someone or something"
    static final String SOURCE_PAGE = "pp.75-76"

    /** All nine example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "When I have coins, I hide them.",
             a: "adela anisdaya yidagiha degvsgatlvsgo'i",
             b: "ᎠᏕᎳ ᎠᏂᏍᏓᏯ ᏱᏓᎩᎭ ᏕᎬᏍᎦᏢᏍᎪᎢ",
             forms: ["ᎬᏍᎦᏢᏍᎪᎢ (Present Habitual Tense)"]],
            [number: 2,
             english: "I hide the bird from the cat.",
             a: "tsisgwa tsiyvsgalvneho na wesa",
             b: "ᏥᏍᏆ ᏥᏴᏍᎦᎸᏁᎰ Ꮎ ᏪᏌ",
             forms: []],
            [number: 3,
             english: "John and I hide the dog.",
             a: "tsani ale ayv osdvsgalv'vsga gitli",
             b: "ᏣᏂ ᎠᎴ ᎠᏴ ᎣᏍᏛᏍᎦᎸᎥᏍᎦ ᎩᏟ",
             forms: ["sdvsgalv'vsga (Present Tense, Third Singular)", "osdvsgalv'vsga (Present Tense, First Dual Exclusive)"]],
            [number: 4,
             english: "Last year, when I had a hundred dollar bill, I hid it.",
             a: "sudetiyvda tsigesv sgohitsugwi-adelv tsagina'v agwvsgalvnv'i",
             b: "ᏑᏕᏘᏴᏓ ᏥᎨᏒ ᏍᎪᎯᏧᏈ-ᎠᏕᎸ ᏣᎩᎾᎥ ᎠᏋᏍᎦᎸᏅᎢ",
             forms: []],
            [number: 5,
             english: "John, you and Jane will hide the car.",
             a: "tsani, nihi ale tseni dasdvsgatlani dagwalelv",
             b: "ᏣᏂ, ᏂᎯ ᎠᎴ ᏤᏂ ᏓᏍᏛᏍᎦᏝᏂ ᏓᏆᎴᎸ",
             forms: []],
            [number: 6,
             english: "If he finds the coins, let him hide them!",
             a: "iyuhno dawatvhv adela dodagvsgatlani anisdaya",
             b: "ᎢᏳᏃ ᏓᏩᏛᎲ ᎠᏕᎳ ᏙᏓᎬᏍᎦᏝᏂ ᎠᏂᏍᏓᏯ",
             forms: ["ᏓᎬᏍᎦᏝᏂ (Future Tense)"]],
            [number: 7,
             english: "I get more money every week, and I always hide it.",
             a: "ugoda adela detsgisgo'i svnadodagwasdi nidegalistanegv, ale nigohilv degvsgatlvsgo'i",
             b: "ᎤᎪᏓ ᎠᏕᎳ ᏕᏥᎩᏍᎪᎢ ᏒᎾᏙᏓᏆᏍᏗ ᏂᏕᎦᎵᏍᏔᏁᎬ, ᎠᎴ ᏂᎪᎯᎸ ᏕᎬᏍᎦᏢᏍᎪᎢ",
             forms: ["ᎬᏍᎦᏢᏍᎪᎢ (Present Habitual Tense)"]],
            [number: 8,
             english: "John, if you find the car, hide it!",
             a: "tsani, iyuhno higowadvhv dagwalelu, hvsgatlanv'i!",
             b: "ᏣᏂ, ᎢᏳᏃ ᎯᎪᏩᏛᎲ ᏓᏆᎴᎷ, ᎲᏍᎦᏝᏅᎢ!",
             forms: ["ᎲᏍᎦᏝᏅᎢ (Future Imperative/Volative)"]],
            [number: 9,
             english: "John, I want for you and Mary to hide the coins.",
             a: "tsani, agwaduli nihi ale meli adela anisdaya disdvsgalodi'i!",
             b: "ᏣᏂ, ᎠᏆᏚᎵ ᏂᎯ ᎠᎴ ᎺᎵ ᎠᏕᎳ ᎠᏂᏍᏓᏯ ᏗᏍᏛᏍᎦᎶᏗᎢ!",
             forms: []],
    ]

    def "example #row.number is recorded with all three lines intact"() {
        expect: "english sentence, romanized line and syllabary line are all preserved"
        row.english && row.a && row.b

        and: "the verb forms it exercises are documented for later deconstruction"
        row.forms != null

        where: "all nine verb-book examples"
        row << EXAMPLES
    }

    def "example #row.number: syllabary and romanized lines are non-trivial"() {
        expect:
        row.a.length() > 10
        row.b.length() > 5

        where: "all nine verb-book examples"
        row << EXAMPLES
    }

    def "the example collection is complete (nine examples)"() {
        expect:
        EXAMPLES*.number == [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
