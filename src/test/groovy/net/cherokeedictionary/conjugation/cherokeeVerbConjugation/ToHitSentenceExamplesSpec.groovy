package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Hit" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.80-81
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
class ToHitSentenceExamplesSpec extends VerbBaseSpec {

    static final String VERB = "to hit"
    static final String SOURCE_PAGE = "pp.80-81"

    /** All nine example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "Are you hitting a baseball?",
             a: "hvhnihas sday(a) sgwahlesdi?",
             b: "ᎲᏂᎭᏍ ᏍᏓᏯ ᏍᏆᏞᏍᏗ",
             forms: ["hvhniha (Present Tense, Second Singular)"]],
            [number: 2,
             english: "No, I am hitting a softball.",
             a: "hla, wanige sgwahlesdi gvniha",
             b: "Ꮭ, ᏩᏂᎨ ᏍᏆᎴᏍᏗ ᎬᏂᎭ",
             forms: ["gvniha (Present Tense, First Singular)"]],
            [number: 3,
             english: "You two are hitting the softball.",
             a: "sdita'li sdvniha wanige sgwahlesdi",
             b: "ᏍᏗᏔᎵ ᏍᏛᏂᎭ ᎾᏩᏂᎨ ᏍᏆᏞᏍᏗ",
             forms: ["ᏍᏛᏂᎭ (Present Tense, Second Dual)"]],
            [number: 4,
             english: "Jane, Joe and you are hitting him.",
             a: "tseni, ale tsowi, ale nihi etsvniha",
             b: "ᏟᏂ ᎠᎴ ᏦᏫ ᎠᎴ ᏂᎯ ᎡᏨᏂᎭ",
             forms: ["ᎡᏨᏂᎭ (Present Tense, Second Plural)"]],
            [number: 5,
             english: "When the boys were driving, they hit the wall.",
             a: "Nahiyu anichutsa anihilisv dagwalela, unvhnile aneksdv'i",
             b: "ᎾᎯᏳ ᎠᏂᏧᏣ ᎠᏂᎯᎵᏒ ᏓᏆᎴᎳ, ᎤᏅᏂᎴ ᎠᏁᎦᏍᏛᎢ",
             forms: []],
            [number: 6,
             english: "Jane, last year you hit the boy.",
             a: "tseni, sudetiyvd(a) tsigesv hiyvnile na achutsa",
             b: "ᏤᏂ, ᏑᏕᏘᏴᏓ ᏥᎨᏒ ᎯᏴᏂᎴ Ꮎ ᎠᏧᏣ",
             forms: []],
            [number: 7,
             english: "Jane and Joe will hit the baseballs tomorrow.",
             a: "tseni ale tsow(a) dodvnvnili disgwahlesdi sanale'iyv",
             b: "ᏤᏂ ᎠᎴ ᏦᏩ ᏙᏛᏅᏂᎵ ᏗᏍᏆᏞᏍᏗ ᏍᏌᎾᎴ ᎢᏴᎢ",
             forms: []],
            [number: 8,
             english: "John, if those boys get mad, they will hit you.",
             a: "tsani, yunihnalvtsv'i, na anichutsa dodagetsvnili",
             b: "ᏣᏂ, ᏳᏂᎿᎸᏨᎢ, ᏙᏓᎨᏨᏂᎵ",
             forms: []],
            [number: 9,
             english: "The girls (just now) hit the ball.",
             a: "nasgi anigehyutsa anvhn(i)ga na sgwahlesdi",
             b: "ᎾᏍᎩ ᎠᏂᎨᏳᏣ ᎠᏅᏂᎦ Ꮎ ᏍᏆᎴᏍᏗ",
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
