package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Be Thankful or Happy" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.26
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
class ToBeThankfulOrHappySentenceExamplesSpec extends Specification {

    static final String VERB = "to be thankful or happy"
    static final String SOURCE_PAGE = "p.26"

    /** All nine example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "At Thanksgiving, my friends and I are thankful.",
             a: "gvn(a) tsunihyesdi tsigeso, digwali ayvhno otsaliheligo'i",
             b: "ᎬᎾ ᏧᏂᏰᏍᏗ ᏥᎨᏐ, ᏗᏆᎵ ᎠᏴᏃ ᎣᏣᎵᎮᎵᎪᎢ",
             forms: ["aliheligo'i (Present Habitual, Third Singular)", "otsaliheligo'i (Present Habitual, First Plural Exclusive)"]],
            [number: 2,
             english: "John, I hope you will be happy in your marriage.",
             a: "tsani, agwohiyusesdi ulihelisdi tsadan(v)tv detsatsvstanv'i",
             b: "ᏣᏂ, ᎠᏉᎯᏳᎯᏳᏎᏍᏗ ᎤᎵᎮᎵᏍᏗ ᏣᏓᏅᏛ ᏕᏣᏨᏍᏔᏅᎢ",
             forms: ["ulihelisdi (Infinitive, Third Singular)"]],
            [number: 3,
             english: "When those boys get their new cars next year, I hope they will be happy.",
             a: "nahiyu danigis(v) ditse dagwalelu na anitsuts(a), agwohiyusesdi ulihelisdi dunadan(v)tesdi",
             b: "ᎾᎯᏳ ᏓᏂᎩᏒ ᏗᏤ ᏓᏆᎴᎷ Ꮎ ᎠᏂᏧᏣ ᎠᏉᎯᏳᏎᏍᏗ ᎤᎵᎮᎵᏍᏗᏚᎾᏓᏅᏖᏍᏗ",
             forms: ["ulihelisdi (Infinitive, Third Singular)"]],
            [number: 4,
             english: "John, be thankful/happy that you live in Oklahoma!",
             a: "tsani, haliheligesdi ogalahoma hinelv'i",
             b: "ᏣᏂ, ᎭᎵᎮᎵᎨᏍᏗ ᎣᎦᎳᎰᎹ ᎯᏁᎸᎢ",
             forms: []],
            [number: 5,
             english: "Mary, be thankful/happy (right now)!",
             a: "meli, haliheligesdi nogwu",
             b: "ᎺᎵ, ᎭᎵᎮᎵᎨᏍᏗ ᏃᏊ",
             forms: []],
            [number: 6,
             english: "Mary, be thankful/happy for all of next year!",
             a: "meli, haliheligesdi nigada so'i wadetiyisgv'i",
             b: "ᎺᎵ ᎭᎵᎮᎵᎨᏍᏗ ᏂᎦᏓ ᏐᎢ ᏩᏕᏘᏱᏍᎬᎢ",
             forms: []],
            [number: 7,
             english: "Five minutes ago, John and Mary were thankful/happy.",
             a: "hisgi iyatawostanv'i tsigesv, tsani ale meli analiheligv'i",
             b: "ᎯᏍᎩ ᎢᏯᏔᏬᏍᏔᏅᎢ ᏥᎨᏒ ᏣᏂ ᎠᎴ ᎺᎵ ᎠᎾᎵᎮᎵᎬᎢ",
             forms: []],
            [number: 8,
             english: "Many years ago, John and Mary were happy.",
             a: "gohigiyv tsigesv, tsani ale meli analiheligv'i",
             b: "ᎪᎯᎩᏴ ᏥᎨᏒ ᏣᏂ ᎠᎴ ᎺᎵ ᎠᎾᎵᎮᎵᎬᎢ",
             forms: []],
            [number: 9,
             english: "John, your dad always wanted for you to be thankful/happy.",
             a: "tsani, tsadoda tsigesv nigohilv udulisgv tsalihelisdi",
             b: "ᏣᏂ, ᏣᏙᏓ ᏥᎨᏒ ᏂᎪᎯᎸ ᎤᏚᎵᏍᎬ ᏣᎵᎮᎵᏍᏗ",
             forms: ["tsalihelisdi (Infinitive, Second Singular)"]],
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
