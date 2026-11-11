package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Like someone or something" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.95-96
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
class ToLikeSomeoneOrSomethingSentenceExamplesSpec extends Specification {

    static final String VERB = "to like someone or something"
    static final String SOURCE_PAGE = "pp.95-96"

    /** All nine example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "Anna, I like you, and I love you.",
             a: "ana, gvlvkwdi ale gvgeyu'a",
             b: "ᎠᎾ ᎬᎸᏉᏗ ᎠᎴ ᎬᎨᏳᎠ",
             forms: ["ᎬᎸᏉᏗ (Present Tense, First Singular)"]],
            [number: 2,
             english: "Do you like fishing? No, I like hunting.",
             a: "tsalvkdis tsasunidasdi, hla aginohalidasdi agilvkdi",
             b: "ᏣᎸᏉᏗᏍ ᏣᏑᏂᏓᏍᏗ, Ꮭ ᎠᎩᏃᎭᎵᏓᏍᏗ ᎠᎩᎸᏉᏗ",
             forms: ["ᎠᎩᎸᏉᏗ (Present Tense, First Singular)", "ᏣᎸᏉᏗ (Present Tense, Second Singular)", "ᎠᎩᎸᏉᏗ (Present Tense, Third Singular)", "ᏣᎸᏉᏗ (Present Tense, Third Singular)", "ᎠᎩᎸᏉᏗ (Immediate Past Tense)"]],
            [number: 3,
             english: "John and I want for you to like your sister.",
             a: "tsani ale ayv oginaduli hilvkdohdi tsado/tsalv",
             b: "ᏣᏂ ᎠᎴ ᎠᏴ ᎣᎩᎾᏚᎵ ᎯᎸᏉᏙᏗ ᏣᏙ/ᏣᎸ",
             forms: []],
            [number: 4,
             english: "When you and I and John were boys, we liked to listen to country music.",
             a: "nihi ale ayv tsanihno didichutsagwo tsigesv, igilvkwdi gesv digadvdasdohdi country music",
             b: "ᏂᎯ ᎠᎴ ᎠᏴ ᏣᏂᏃ ᏗᏗᏧᏣᏉ ᏥᎨᏒ, ᎢᎩᎸᏉᏗ ᎨᏒ ᏗᎦᏛᏓᏍᏙᏗ country music",
             forms: ["ᎢᎩᎸᏉᏗ (Present Tense, Third Singular)"]],
            [number: 5,
             english: "When I eat ice cream, I like it.",
             a: "ice cream yagi'a tsilvgwodisgo",
             b: "ice cream ᏯᎩᎠ ᏥᎸᏉᏗᏍᎪ",
             forms: ["tsilvgwodi (Present Tense, First Singular)"]],
            [number: 6,
             english: "After I met Charley, I liked him.",
             a: "tsali tsidoginadlosv tsilvkwdo",
             b: "ᏣᎵ ᏥᏙᎩᎾᏜᏒ ᏥᎸᏉᏙ",
             forms: []],
            [number: 7,
             english: "Years ago, I liked to swim.",
             a: "tsudetiyvda tsigesv agilvkwdv agwadawosdi",
             b: "ᏧᏕᏘᏴᏓ ᏥᎨᏒ ᎠᎩᎸᏉᏛ ᎠᏆᏓᏬᏍᏗ",
             forms: []],
            [number: 8,
             english: "Mary, I will always like you.",
             a: "meli, nigohilv gvlvkwdesdi",
             b: "ᎺᎵ, ᏂᎪᎯᎸ ᎬᎸᏉᏕᏍᏗ",
             forms: []],
            [number: 9,
             english: "You two boys eat that food and you like it!",
             a: "sdichutsa--sdiga na alisdayvdi ale sdilvkwda!",
             b: "ᏍᏗᏧᏣ--ᏍᏗᎦ Ꮎ ᎠᎵᏍᏓᏴᏗ ᎠᎴ ᏍᏗᎸᏉᏓ",
             forms: ["sdilvkwda (Future Imperative/Volative)", "sdilvkwda (Immediate Imperative/Volative)"]],
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
