package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Point Something Out" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.110-111
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
class ToPointSomethingOutSentenceExamplesSpec extends VerbBaseSpec {

    static final String VERB = "to point something out"
    static final String SOURCE_PAGE = "pp.110-111"

    /** All ten example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "John, point out to me your new pistol.",
             a: "tsani, sgwasehisi tsatseli sgwala galogwe!",
             b: "ᏣᏂ, ᏍᏆᏎᎯᏏ ᏣᏤᎵ ᏍᏆᎳ ᎦᎶᏇ",
             forms: ["wasehisi (Immediate Imperative/Volative)", "asehisi (Immediate Past Tense)"]],
            [number: 2,
             english: "Yesterday I pointed out my new car to Jane and Mary.",
             a: "svhi tsigesv gatsiyasehelv agwatseli itse dagwalelu tseni ale meli",
             b: "ᏒᎯ ᏥᎨᏒ ᎦᏥᏯᏎᎮᎸ ᎠᏆᏤᎵ ᎢᏤ ᏓᏆᎴᎷ ᏤᏂ ᎠᎴ ᎺᎵ",
             forms: []],
            [number: 3,
             english: "Mary, after you show your dad your grades, he will be very happy.",
             a: "meli, dehiyasehelv detsanv tsunadelogwasdi, tvlihelitsi tsadoda",
             b: "ᎺᎵ, ᏕᎯᏯᏎᎮᎸ ᏕᏣᏅ ᏧᎾᏕᎶᏆᏍᏗ, ᏛᎵᎮᎵᏥ ᏣᏙᏓ",
             forms: []],
            [number: 4,
             english: "John, look at his grades carefully when he shows them to you.",
             a: "tsani, osda dehagasestanv dunvnv tsunadelogwasdi'i udanvdigwu detsasehelv'i",
             b: "ᏣᏂ, ᎣᏍᏓ ᏕᎭᎦᏎᏍᏔᏅ ᏚᏅᏅ ᏧᎾᏕᎶᏆᏍᏗᎢ ᎤᏓᏅᏗᏊ ᏕᏣᏎᎮᎸᎢ",
             forms: ["etsasehelv'i (Future Imperative/Volative)", "asehelv'i (Future Imperative/Volative)"]],
            [number: 5,
             english: "I want you two boys to show me your hands.",
             a: "agwaduli sdita'li disginigohwatvdohdi disdoyeni",
             b: "ᎠᏆᏚᎵ ᏍᏗᏔᎵ ᏗᏍᎩᏂᎪᏩᏛᏙᏗ ᏗᏍᏙᏰᏂ",
             forms: []],
            [number: 6,
             english: "John has a new, red car. May he point it out to all of us tomorrow.",
             a: "tsani uha itse, gigage dagwalelu. nigada igigohwatvthanv sinale iyv'i",
             b: "ᏣᏂ ᎤᎭ ᎢᏤ, ᎩᎦᎨ ᏓᏆᎴᎷ. ᏂᎦᏓ ᎢᎩᎪᏩᏛᏔᏅ ᏏᎾᎴ ᎢᏴᎢ",
             forms: []],
            [number: 7,
             english: "John, I want for you to show me how to drive your new car.",
             a: "tsani, agwaduli sgwasehedi yigvnedi ahilvsdi tsatseli itse dagwalelu",
             b: "ᏣᏂ, ᎠᏆᏚᎵ ᏍᏆᏎᎮᏗ ᏱᎬᏁᏗ ᎠᎯᎸᏍᏗ ᏣᏤᎵ ᎢᏤ ᏓᏆᎴᎷ",
             forms: []],
            [number: 8,
             english: "Yesterday those three boys showed me their new school jackets.",
             a: "svhi tsigesv na tso'i iyani'i anichutsa degvgigow'tvtanv ditse digasaleni tsunadelogwasdi tsunahnawosdi",
             b: "ᏒᎯ ᏥᎨᏒ Ꮎ ᏦᎢ ᎢᏯᏂᎢ ᎠᏂᏧᏣ ᏕᎬᎩᎪᏩᏛᏔᏅ ᏗᏤ ᏗᎦᏌᎴᏂ ᏧᎾᏕᎶᏆᏍᏗ ᏧᎾᎿᏬᏍᏗ",
             forms: []],
            [number: 9,
             english: "Joe, show this book to your sister Jane.",
             a: "tsowi, digow'tvta hi'a digohweli etsado tseni",
             b: "ᏦᏫ, ᏗᎪᏩᏛᏔ ᎯᎠ ᏗᎪᏪᎵ ᎡᏣᏙ ᏤᏂ",
             forms: []],
            [number: 10,
             english: "John, show me how to drive your new car.",
             a: "tsani, sgigow'tvda yigvnedi ahilidasdi tsatseli dagwalelu",
             b: "ᏣᏂ, ᏍᎩᎪᏩᏛᏓ ᏱᎬᏁᏗ ᎠᎯᎵᏓᏍᏗ ᏣᏤᎵ ᏓᏆᎴᎷ",
             forms: []],
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
