package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To See" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.120-121
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
class ToSeeSentenceExamplesSpec extends VerbBaseSpec {

    static final String VERB = "to see"
    static final String SOURCE_PAGE = "pp.120-121"

    /** All nine example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "Jane and Mary, do you see those cars?",
             a: "tseni ale meli, desdigowtihas na dagwalelu?",
             b: "ᏤᏂ ᎠᎴ ᎺᎵ, ᏕᏍᏗᎪᏩᏘᎭᏍ Ꮎ ᏓᏆᎴᎷ",
             forms: ["sdigowtiha (Present Tense, Third Singular)", "esdigowtiha (Present Tense, Second Dual)", "sdigowtiha (Present Tense, Second Dual)", "desdigowtiha (Present Tense, Second Dual)"]],
            [number: 2,
             english: "I don't see John, but I am looking for him.",
             a: "hla yitsigowti tsani, asesgini tsiyoha",
             b: "Ꮭ ᏱᏥᎪᏩᏘ ᏣᏂ, ᎠᏎᏍᎩᏂ ᏥᏲᎭ",
             forms: []],
            [number: 3,
             english: "Before I die, I want to see the Rocky Mountains.",
             a: "asi nagiyohusvnagwu, agwaduli digigowtvdi nvyohi dodalv'i",
             b: "ᎠᏏ ᎾᎩᏲᎱᏒᎾᏊ, ᎠᏆᏚᎵ ᏗᎩᎪᏩᏛᏗ ᏅᏲᎯ ᏙᏓᎸ",
             forms: []],
            [number: 4,
             english: "When Anna and Jane were small girls, they saw two ducks in the pond.",
             a: "ana ale tseni tsunasdi anigehyutsa tsigesv, anitali kawonu dunigohv vdalv'i",
             b: "ᎠᎾ ᎠᎴ ᏤᏂ ᏧᎾᏍᏗ ᎠᏂᎨᏳᏣ ᏥᎨᏒ, ᎠᏂᏔᎵ ᎧᏬᏄ ᏚᏂᎪᎲ ᎥᏓᎸᎢ",
             forms: []],
            [number: 5,
             english: "Anna, when you and Jane come to Tahlequah, I will see you.",
             a: "ana, nihi ale tseni sdiluhtsv daligwa, dasdvgo'i",
             b: "ᎠᎾ, ᏂᎯ ᎠᎴ ᏤᏂ ᏍᏗᎷᏨ ᏓᎵᏆ, ᏓᏍᏛᎪᎢ",
             forms: []],
            [number: 6,
             english: "When that car comes to Tahlequah, John and I will see it.",
             a: "daligwa galuhtsv na dagwalelu, tsani ale ayv dayosdigohi",
             b: "ᏓᎵᏆ ᎦᎷᏨ Ꮎ ᏓᏆᎴᎷ, ᏣᏂ ᎠᎴ ᎠᏴ ᏓᏲᏍᏗᎪᎯ",
             forms: []],
            [number: 7,
             english: "John, next year you and I will see your grandmother.",
             a: "tsani, sudetiyvda tsigvsesdi nihi ale ayv dayenigo'i tsalisi",
             b: "ᏣᏂ, ᏑᏕᏘᏴᏓ ᏥᎬᏎᏍᏗ ᏂᎯ ᎠᎴ ᎠᏴ ᏓᏰᏂᎪᎢ ᏣᎵᏏ",
             forms: []],
            [number: 8,
             english: "Mary, do you see that bird?",
             a: "meli, higow'tihas na tsisgwa?",
             b: "ᎺᎵ, ᎯᎪᏩᏗᎭᏍ Ꮎ ᏥᏍᏆ?",
             forms: []],
            [number: 9,
             english: "John, do you see that red car?",
             a: "tsani, higow'tihas na gigage dagwalelu?",
             b: "ᏣᏂ, ᎯᎪᏩᏘᎭᏍ Ꮎ ᎩᎦᎨ ᏓᏆᎴᎷ?",
             forms: ["ᎯᎪᏩᏘᎭ (Present Tense, Second Singular)"]],
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
