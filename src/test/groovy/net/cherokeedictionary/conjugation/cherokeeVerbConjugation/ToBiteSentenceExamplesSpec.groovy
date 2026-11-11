package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Bite (when a human bites)" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.30-31
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
class ToBiteSentenceExamplesSpec extends Specification {

    static final String VERB = "to bite (when a human bites)"
    static final String SOURCE_PAGE = "pp.30-31"

    /** All ten example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "I got so excited, I bit my lip.",
             a: "agilanisdisgv, agwvsa agwadasgaltsv akinega'lv'i",
             b: "ᎠᎩᎳᏂᏍᏗᏍᎬ, ᎠᏋᏍᏌ ᎠᏆᏓᏍᎦᎶᏨ ᎠᎩᏁᎦᎸᎢ",
             forms: []],
            [number: 2,
             english: "That mean dog bit a boy yesterday. (Note the Class B prefix!!)",
             a: "na unegutsida gihli usgahltse na achutsa svhi tsigesv'i",
             b: "ᎤᏁᎫᏥᏓ ᎩᎵ ᎤᏍᎦᎶᏤ Ꮎ ᎠᏧᏣ ᏒᎯ ᏥᎨᏒᎢ.",
             forms: []],
            [number: 3,
             english: "I hope that dog doesn't bite me. (Note the Class B prefix!)",
             a: "agwohiyusesdi na gihli aksgahldi nigesvna",
             b: "ᎠᏉᎯᏳᏎᏍᏗ Ꮎ ᎩᎵ ᎠᎩᏍᎦᎶᏗ ᏂᎨᏒᎾ",
             forms: []],
            [number: 4,
             english: "John hopes that big dog won't bite him. (Note the Class B prefix!)",
             a: "tsani utugi uweha, na utana gihli usgahldi nigesvna",
             b: "ᏣᏂ ᎤᏚᎩ ᎤᏪᎭ, Ꮎ ᎤᏔᎾ ᎩᎵ ᎤᏍᎦᎶᏗ ᏂᎨᏒᎾ",
             forms: []],
            [number: 5,
             english: "The dentist told me to bite the piece of plastic.",
             a: "didandesgi agwatsdesdi agvhalvda gvnawosgi gotlvtanvhi agwoselv",
             b: "ᏗᏓᏅᏕᏍᎩ ᎠᏆᏥᏕᏍᏗ ᎠᎬᎭᎸᏓ ᎬᎾᏬᏍᎩ ᎪᏢᏔᏅᎯ ᎠᏉᏎᎸ",
             forms: []],
            [number: 6,
             english: "People used to bite a piece of wood when they were in pain.",
             a: "yvwi anatsdesge agvhalvdi ada anigitliyogv'i",
             b: "ᏴᏫ ᎠᎾᏥᏕᏍᎨ ᎠᎬᎭᎸᏗ ᎠᏓ ᎠᏂᎩᏟᏲᎬᎢ",
             forms: []],
            [number: 7,
             english: "The baby always bites his teething ring.",
             a: "na usdi nigohilv ats(i)desgo gasogwalv tsudandosdodi'i",
             b: "Ꮎ ᎤᏍᏗ ᏂᎪᎯᎸ ᎠᏥᏕᏍᎪ ᎦᏐᏆᎸ ᏧᏓᏅᏙᏍᏙᏗᎢ",
             forms: []],
            [number: 8,
             english: "John, don't bite so hard on that piece of candy!",
             a: "tsani, tlesdi sdaya hyats(i)desgesdi na kalsetsi",
             b: "ᏣᏂ, ᏞᏍᏗ ᏍᏓᏯ ᏱᎭᏥᏕᏍᎨᏍᏗ Ꮎ ᎧᎵᏎᏥ",
             forms: []],
            [number: 9,
             english: "It isn't nice to bite people.",
             a: "tla osi yigi kilo hyisgalga",
             b: "Ꮭ ᎣᏏ ᏱᎩ ᎩᎶ ᏱᎯᏍᎦᎶᎦ",
             forms: ["ᎯᏍᎦᎶᎦ (Present Tense, Second Singular)"]],
            [number: 10,
             english: "If you bite too hard, you may hurt your teeth.",
             a: "sdayisgini hyisgalga, eligwu yidetsehisdasi dehindogv'i",
             b: "ᏍᏓᏱᏍᎩᏂ ᏱᎯᏍᎦᎶᎦ, ᎡᎵᏊ ᏱᏕᏤᎯᏍᏓᏏ ᏕᎯᏅᏙᎬᎢ",
             forms: ["ᎯᏍᎦᎶᎦ (Present Tense, Second Singular)"]],
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
