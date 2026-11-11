package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Kill someone or something" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.90-91
 * (printed page numbers of the full 164-page document).
 *
 * Eight example sentences, each printed as:
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
class ToKillSomeoneOrSomethingSentenceExamplesSpec extends VerbBaseSpec {

    static final String VERB = "to kill someone or something"
    static final String SOURCE_PAGE = "pp.90-91"

    /** All eight example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "John, if you see a snake, kill it!",
             a: "tsani, iyuhno inada ihigo'i, hilv'i",
             b: "ᏣᏂ, ᎢᏳᏃ ᎢᎾᏓ ᎢᎯᎪᎢ, ᎯᎸᎢ",
             forms: ["hilv'i (Future Imperative/Volative)"]],
            [number: 2,
             english: "Mary and Jane want you (two) to kill any spiders that you may see.",
             a: "meli ale tseni unaduli nihi itsula disdihisdi nigada gananesgi desdigowtisgv'i",
             b: "ᎺᎵ ᎠᎴ ᏤᏂ ᎤᎾᏚᎵ ᏂᎯ ᎢᏧᎳ ᏗᏍᏗᎯᏍᏗ ᏂᎦᏓ ᎦᎾᏁᏍᎩ ᏕᏍᏗᎪᏩᏘᏍᎬᎢ",
             forms: []],
            [number: 3,
             english: "When you (two) were boys, you killed a rattlesnake.",
             a: "sdita'li sdichutsagwu tsigesv, utsonati esdilv'i",
             b: "ᏍᏗᏔᎵ ᏍᏗᏧᏣᏊ ᏥᎨᏒ, ᎤᏦᎾᏘ ᎡᏍᏗᎸᎢ",
             forms: ["esdilv'i (Future Imperative/Volative)"]],
            [number: 4,
             english: "It is wrong for people to kill other people.",
             a: "hla osi yigi yvwi aniso'i yvwi yidanihiha",
             b: "Ꮭ ᎣᏏ ᏱᎩ ᏴᏫ ᎠᏂᏐᎢ ᏴᏫ ᏱᏓᏂᎯᎭ",
             forms: ["anihiha (Present Tense, Third Plural)", "danihiha (Present Tense, Third Plural)"]],
            [number: 5,
             english: "I (just now) killed a fly with a newspaper.",
             a: "tvga tsiluhga kanoheda digaleyvthanv gohweli gvhdi",
             b: "ᏛᎦ ᏥᎷᎦ ᎧᏃᎮᏓ ᏗᎦᎴᏴᏔᏅ ᎪᏪᎵ ᎬᏗ",
             forms: []],
            [number: 6,
             english: "Anna, when you were a little girl, you killed a mouse.",
             a: "ana, tsasti higehyutsa tsigesv, tsisdetsi hilv'i",
             b: "ᎠᎾ, ᏣᏍᏘ ᎯᎨᏳᏣ ᏥᎨᏒ, ᏥᏍᏕᏥ ᎯᎸᎢ",
             forms: ["hilv'i (Future Imperative/Volative)"]],
            [number: 7,
             english: "If you boys see a poisonous snake, kill it!",
             a: "itsichutsa, iyuhno inada adahihi etsigo'v'i, etsilv'i!",
             b: "ᎢᏥᏧᏣ, ᎢᏳᏃ ᎢᎾᏓ ᎠᏓᎯᎯ ᎡᏥᎪᎥᎢ, ᎡᏥᎸᎢ!",
             forms: ["tsilv'i (Remote Past Tense)", "etsilv'i (Future Imperative/Volative)"]],
            [number: 8,
             english: "I want for you two boys to kill that snake.",
             a: "agwaduli sditali sdichutsa esdi'sdi na inada",
             b: "ᎠᏆᏚᎵ ᏍᏗᏔᎵ ᏍᏗᏧᏣ ᎡᏍᏗᎢᏍᏗ Ꮎ ᎢᎾᏓ",
             forms: []],
    ]

    def "example #row.number is recorded with all three lines intact"() {
        expect: "english sentence, romanized line and syllabary line are all preserved"
        row.english && row.a && row.b

        and: "the verb forms it exercises are documented for later deconstruction"
        row.forms != null

        where: "all eight verb-book examples"
        row << EXAMPLES
    }

    def "example #row.number: syllabary and romanized lines are non-trivial"() {
        expect:
        row.a.length() > 10
        row.b.length() > 5

        where: "all eight verb-book examples"
        row << EXAMPLES
    }

    def "the example collection is complete (eight examples)"() {
        expect:
        EXAMPLES*.number == [1, 2, 3, 4, 5, 6, 7, 8]
    }
}
