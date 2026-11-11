package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Honor Someone or Something" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.85-86
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
class ToHonorSomeoneOrSomethingSentenceExamplesSpec extends Specification {

    static final String VERB = "to honor someone or something"
    static final String SOURCE_PAGE = "pp.85-86"

    /** All seven example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "When we hear about brave men, we honor them.",
             a: "dots(a)tvgisgv tsunal(i)chvyasdi anisgaya, gotsilvgw(o)disgo'i",
             b: "ᎣᏓᏣᏛᎦᎶ ᏧᎾᎵᏨᏯᏍᏗ ᎠᏂᏍᎦᏯ, ᎪᏥᎸᏉᏗᏍᎪᎢ",
             forms: ["ᏥᎸᏉᏗᏍᎪᎢ (Present Habitual Tense)"]],
            [number: 2,
             english: "Joe, you and your brothers honor the flag.",
             a: "tsowi, nihi ale itsatlinvdlv itsilvgwoda gadati",
             b: "ᏦᏫ, ᏂᎯ ᎠᎴ ᎢᏣᎵᏅᏟ ᎢᏥᎸᏉᏓ ᎦᏓᏘ",
             forms: ["ᎢᏥᎸᏉᏓ (Immediate Imperative/Volative)", "ᏥᎸᏉᏓ (Immediate Past Tense)"]],
            [number: 3,
             english: "The men honor the soldiers.",
             a: "nasgi anisgaya danilvgw(o)diha na aniyaw(i)sgi",
             b: "ᎾᏍᎩ ᎠᏂᏍᎦᏯ ᏓᏂᎸᏉᏗᎭ Ꮎ ᎠᏂᏯᏫᏍᎩ",
             forms: ["ᏓᏂᎸᏉᏗᎭ (Present Tense, Third Plural)"]],
            [number: 4,
             english: "John and I honor him.",
             a: "tsani ale ayv osdilvgw(o)diha",
             b: "ᏣᏂ ᎠᎴ ᎠᏴ ᎣᏍᏗᎸᏉᏗᎭ",
             forms: ["ᏍᏗᎸᏉᏗᎭ (Present Tense, Third Singular)", "ᏍᏗᎸᏉᏗᎭ (Present Tense, Second Dual)", "ᎣᏍᏗᎸᏉᏗᎭ (Present Tense, First Dual Exclusive)"]],
            [number: 5,
             english: "All Americans honor George Washington.",
             a: "nigada amayehli anehi anilvgw(o)do tsatsi wasadvna",
             b: "ᏂᎦᏓ ᎠᎹᏰᏟ ᎠᏁᎯ ᎠᏂᎸᏉᏙ ᏣᏂ ᏩᏌᏛᎾ",
             forms: []],
            [number: 6,
             english: "May John honor the flag.",
             a: "tsani wigalvgw(o)tanv'i nasgi gadati",
             b: "ᏣᏂ ᏫᎦᎸᏉᏔᏅᎢ ᎾᏍᎩ ᎦᏓᏘ",
             forms: ["ᎦᎸᏉᏔᏅᎢ (Future Imperative/Volative)"]],
            [number: 7,
             english: "\"Let us now honor famous men\" (hymn title).",
             a: "\"gedilvgwoda tsunadanotsahli anisgaya\"",
             b: "\"ᎨᏗᎸᏉᏓ ᏧᎾᏓᏃᏣᎵ ᎠᏂᏍᎦᏯ\" (ᏧᏂᎳᏫᎢᏍᏗ ᏗᎧᏃᎩᏍᏗ)",
             forms: []],
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
