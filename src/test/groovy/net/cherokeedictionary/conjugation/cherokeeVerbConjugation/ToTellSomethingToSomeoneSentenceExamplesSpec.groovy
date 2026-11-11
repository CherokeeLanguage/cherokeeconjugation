package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Tell something to someone" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.135-136
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
class ToTellSomethingToSomeoneSentenceExamplesSpec extends Specification {

    static final String VERB = "to tell something to someone"
    static final String SOURCE_PAGE = "pp.135-136"

    /** All ten example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "John, tell me a story—right now!",
             a: "tsani, sginohisi kanoheda!",
             b: "ᏣᏂ, ᏍᎩᏃᎯᏏ ᎧᏃᎮᏓ!",
             forms: []],
            [number: 2,
             english: "Those three boys want John to tell them a story",
             a: "na tso'i iyani anitsutsa unaduli uninohisedi kanoheda",
             b: "Ꮎ ᏦᎢ ᎢᏯᏂ ᎠᏂᏧᏣ ᎤᎾᏚᎵ ᎤᏂᏃᎯᏎᏗ ᎧᏃᎮᏓ",
             forms: []],
            [number: 3,
             english: "John, listen to what Pete says, and then tell me!",
             a: "tsani, hadvdasdi nigawesgv gwida, nogwuhno sginohiselv'i",
             b: "ᏣᏂ, ᎭᏛᏓᏍᏗ ᏂᎦᏪᏍᎬ ᏈᏓ, ᏃᏊᏃ ᏍᎩᏃᎯᏎᎸᎢ",
             forms: []],
            [number: 4,
             english: "Mary always tells the same story.",
             a: "meli nigohilv vsgigwu kanoheda ikanohesgo'i",
             b: "ᎺᎵ ᏂᎪᎯᎸ ᎥᏍᎩᏊ ᎧᏃᎮᏓ ᎢᎧᏃᎮᏍᎪᎢ",
             forms: []],
            [number: 5,
             english: "Those three boys and I always tell people what we want them to do.",
             a: "na anitso anitsutsa ayvhno nigohilv dotsinohiseho yvwi iyusdi ogadulisgv iyunadvnedi'i",
             b: "Ꮎ ᎠᏂᏦ ᎠᏂᏧᏣ ᎠᏴᏃ ᏂᎪᎯᎸ ᏙᏥᏃᎯᏎᎰ ᏴᏫ ᎢᏳᏍᏗ ᎣᎦᏚᎵᏍᎬ ᎢᏳᎾᏛᏁᏗᎢ",
             forms: []],
            [number: 6,
             english: "All the girls are happy when I tell them a story.",
             a: "nani'v na anigeyutsa analiheligo ogatsinohisela gohusdi kanoheda",
             b: "ᎾᏂᎥ Ꮎ ᎠᏂᎨᏳᏣ ᎠᎾᎵᎮᎵᎪ ᎣᎦᏥᏃᎯᏎᎳ ᎪᎱᏍᏗ ᎧᏃᎮᏓ",
             forms: []],
            [number: 7,
             english: "After I tell my story, all you people will be happy.",
             a: "itsvnohise hi'a kanoheda, nitsi'v itsiyvwi itsalihelitsi",
             b: "ᎢᏨᏃᎯᏎ ᎯᎠ ᎧᏃᎮᏓ, ᏂᏥᎥ ᎢᏥᏴᏫ ᎢᏣᎵᎮᎵᏥ",
             forms: []],
             // note printed in the verb book between lines a. and b.: "At the end of this statement, you could add "no'wu tsig'" (ᏃᏊ ᏥᎩ), but it is not necessary."
            [number: 8,
             english: "John, listen to his story and then tell it to me.",
             a: "tsani, hadvdastanv hi'a tsikanoheha nogwuhno ayv isgihno hiselv'i",
             b: "ᏣᏂ, ᎭᏛᏓᏍᏔᏅ ᎯᎠ ᏥᎧᏃᎮᎭ ᏃᏊᏃ ᎠᏴ ᎢᏍᎩᏃ ᎯᏎᎸᎢ",
             forms: []],
            [number: 9,
             english: "All you girls be quiet! Let him tell us his story!",
             a: "nitsi'v itsigeyutsa ehlawe gesesdi! wikanohvli kanoheda!",
             b: "ᏂᏥᎥ ᎢᏥᎨᏳᏣ ᎡᏝᏪ ᎨᏎᏍᏗ! ᏫᎧᏃᎲᎵ ᎧᏃᎮᏓ!",
             forms: []],
            [number: 10,
             english: "The whole third grade class wanted for him to tell his story.",
             a: "nani'v tso'ine dininidohi unadulisgv unohedi kanoheda",
             b: "ᎾᏂᎥ ᏦᎢᏁ ᏗᏂᏂᏙᎯ ᎤᎾᏚᎵᏍᎬ ᎤᏃᎮᏗ ᎧᏃᎮᏓ",
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
