package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Long and Rigid, like a stick, a shovel, etc." — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.48-49
 * (printed page numbers of the full 164-page document).
 *
 * Six example sentences, each printed as:
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
class ToHaveSomethingLongAndRigidSentenceExamplesSpec extends VerbBaseSpec {

    static final String VERB = "to have something long and rigid, like a stick, a shovel, etc."
    static final String SOURCE_PAGE = "pp.48-49"

    /** All six example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "Joe, do you have a shovel?",
             a: "tsowi, akodesdis tsvya?",
             b: "ᏦᏫ, ᎠᎪᏕᏍᏗᏍ ᏨᏯ?",
             forms: []],
            [number: 2,
             english: "I don't have a shovel, but I have a spade.",
             a: "hla akodesdi yagwvya asesgini usdi akodesdi agwvya",
             b: "Ꮭ ᎠᎪᏕᏍᏗ ᏯᏋᏯ ᎠᏎᏍᎩᏂ ᎤᏍᏗ ᎠᎪᏕᏍᏗ ᎠᏋᏯ",
             forms: []],
            [number: 3,
             english: "My car has a new tailpipe.",
             a: "agwatseli dagwalelu itse tsug(a)svsdodi nigvn(v)di",
             b: "ᎠᏆᏤᎵ ᏓᏆᎴᎷ ᎢᏤ ᏧᎦᏒᏍᏙᏗ ᏂᎬᏅᏗ",
             forms: []],
            [number: 4,
             english: "The plumber has several long pipes.",
             a: "na ama tsuwedasdi osda yidigvnehi duwaya ilvsgi tsusvdoni",
             b: "Ꮎ ᎠᎹ ᏧᏪᏓᏍᏗ ᎣᏍᏓ ᏱᏗᎬᏁᎯ ᏚᏩᏯ ᎢᎸᏍᎩ ᏧᏒᏙᏂ",
             forms: ["duwaya (Present Tense, Third Singular)"]],
            [number: 5,
             english: "John and Joe have three shovels.",
             a: "tsani ale tsowa tso'iha dikodesdohdi dunvya",
             b: "ᏣᏂ ᎠᎴ ᏦᏩ ᏦᎢᎭ ᏗᎪᏕᏍᏙᏗ ᏚᏅᏯ",
             forms: ["dunvya (Present Tense, Third Plural Form)"]],
            [number: 6,
             english: "When it snows again, I will have a snow shovel.",
             a: "sigwuhno igutanv un(v)tsi akodesdohdi agwvyesdi",
             b: "ᏏᏊᏃ ᎢᎫᏔᏅ ᎤᏅᏥ ᎠᎪᏕᏍᏙᏗ ᎠᏋᏴᏍᏗ",
             forms: ["agwvyesdi (Future Tense, First Singular)", "agwvyesdi (Future Imperative/Volative, First Singular)", "agwvyesdi (Immediate Imperative/Volative, First Singular)"]],
    ]

    def "example #row.number is recorded with all three lines intact"() {
        expect: "english sentence, romanized line and syllabary line are all preserved"
        row.english && row.a && row.b

        and: "the verb forms it exercises are documented for later deconstruction"
        row.forms != null

        where: "all six verb-book examples"
        row << EXAMPLES
    }

    def "example #row.number: syllabary and romanized lines are non-trivial"() {
        expect:
        row.a.length() > 10
        row.b.length() > 5

        where: "all six verb-book examples"
        row << EXAMPLES
    }

    def "the example collection is complete (six examples)"() {
        expect:
        EXAMPLES*.number == [1, 2, 3, 4, 5, 6]
    }
}
