package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Help" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.70-71
 * (printed page numbers of the full 164-page document).
 *
 * Eleven example sentences, each printed as:
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
class ToHelpSentenceExamplesSpec extends Specification {

    static final String VERB = "to help"
    static final String SOURCE_PAGE = "pp.70-71"

    /** All eleven example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "When they work in the fields, I help them.",
             a: "dlogesi yidunilvhwisdanela, gatsisdelisgo'i",
             b: "ᏠᎨᏏ ᏱᏚᏂᎸᏫᏍᏓᏁᎳ, ᎦᏥᏍᏕᎵᏍᎪᎢ",
             forms: ["tsisdelisgo'i (Present Habitual Tense)"]],
            [number: 2,
             english: "When Mary cooks, Sarah helps her.",
             a: "meli yudasdayvhna, seli usdelisgo'i",
             b: "ᎺᎵ ᏳᏓᏍᏓᏴᎿ, ᏎᎵ ᎤᏍᏕᎵᏍᎪᎢ",
             forms: []],
            [number: 3,
             english: "John, Sam and I help you work.",
             a: "tsani, sami, ayvhno itsvsdeliha digalvhwisdanelv",
             b: "ᏣᏂ, ᏌᎻ, ᎠᏴᏃ ᎢᏨᏍᏕᎵᎭ ᏗᎦᎸᏫᏍᏓᏁᎸ",
             forms: ["itsvsdeliha (Present Tense, First Singular)", "itsvsdeliha (Present Tense, First Plural Exclusive)"]],
            [number: 4,
             english: "The boys and I help them do their homework.",
             a: "na anichutsa ale ayv dotsisdeliha dinadelogwasgi",
             b: "Ꮎ ᎠᏂᏧᏣ ᎠᎴ ᎠᏴ ᏙᏥᏍᏕᎵᎭ ᏗᎾᏕᎶᏆᏍᎩ",
             forms: ["tsisdeliha (Present Tense, First Singular)", "otsisdeliha (Present Tense, First Plural Exclusive)", "dotsisdeliha (Present Tense, First Plural Exclusive)"]],
            [number: 5,
             english: "Last year I helped him work on his car.",
             a: "sudetiyvda tsigesv tsisdelvhv dagwalelu osda yigvnelv",
             b: "ᏑᏕᏘᏴᏓ ᏥᎨᏒ ᏥᏍᏕᎸᎲ ᏓᏆᎴᎷ ᎣᏍᏓ ᏱᎬᏁᎸ",
             forms: []],
            [number: 6,
             english: "John, I will help you work on your car.",
             a: "tsani, dagvsdelvhi dagwalelu osda nvnehv'i",
             b: "ᏣᏂ, ᏓᎬᏍᏕᎸᎯ ᏓᏆᎴᎷ ᎣᏍᏓ ᏅᏁᎲᎢ",
             forms: []],
            [number: 7,
             english: "John and Mary, you two help Joe!",
             a: "tsani ale meli, esdisdeli tsowa",
             b: "ᏣᏂ ᎠᎴ ᎺᎵ, ᎡᏍᏗᏍᏕᎵ ᏦᏩ",
             forms: []],
            [number: 8,
             english: "When he works on his car, I always help him.",
             a: "dagwalelu osda yilvwanela, nigohilv tsisdelisgo'i",
             b: "ᏓᏆᎴᎷ ᎣᏍᏓ ᏱᎸᏩᏁᎳ, ᏂᎪᎯᎸ ᏥᏍᏕᎵᏍᎪᎢ",
             forms: ["tsisdelisgo'i (Present Habitual Tense)"]],
            [number: 9,
             english: "May the Lord help you!",
             a: "unehlanvhi witsasdela!",
             b: "ᎤᏁᎳᏅᎯ ᏫᏣᏍᏕᎳ",
             forms: ["asdela (Immediate Past Tense)"]],
            [number: 10,
             english: "Mary and Jane, do you two want for me to help you?",
             a: "meli ale tseni, sdadulihas sdvsdelvdi?",
             b: "ᎺᎵ ᎠᎴ ᏤᏂ, ᏍᏓᏚᎵᎭᏍ ᏍᏛᏍᏕᎸᏗ?",
             forms: []],
            [number: 11,
             english: "Joe is helping you, me, and John.",
             a: "tsowi igisdeli nihi, ayv, ale tsani",
             b: "ᏦᏫ ᎢᎩᏍᏕᎵ ᏂᎯ, ᎠᏴ, ᎠᎴ ᏣᏂ",
             forms: []],
    ]

    def "example #row.number is recorded with all three lines intact"() {
        expect: "english sentence, romanized line and syllabary line are all preserved"
        row.english && row.a && row.b

        and: "the verb forms it exercises are documented for later deconstruction"
        row.forms != null

        where: "all eleven verb-book examples"
        row << EXAMPLES
    }

    def "example #row.number: syllabary and romanized lines are non-trivial"() {
        expect:
        row.a.length() > 10
        row.b.length() > 5

        where: "all eleven verb-book examples"
        row << EXAMPLES
    }

    def "the example collection is complete (eleven examples)"() {
        expect:
        EXAMPLES*.number == [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11]
    }
}
