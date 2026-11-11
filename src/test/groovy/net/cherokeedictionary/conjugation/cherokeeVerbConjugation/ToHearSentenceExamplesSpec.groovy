package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Hear" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.65-66
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
class ToHearSentenceExamplesSpec extends Specification {

    static final String VERB = "to hear"
    static final String SOURCE_PAGE = "pp.65-66"

    /** All ten example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "John, do you hear me?",
             a: "tsani, sgwatvgi'as?",
             b: "ᏣᏂ, ᏍᏆᏛᎩᎠᏍ",
             forms: ["sgwatvgi'a (Present Tense, Second Singular)", "atvgi'a (Present Tense, Third Singular)"]],
            [number: 2,
             english: "I don't hear you but I hear Mary and Jane.",
             a: "hla yigvyatvgi'a asehno meli ale tseni gatsiyatvgi'a",
             b: "Ꮭ ᏱᎬᏯᏛᎩᎠ. ᎺᎵ ᎠᎴ ᏤᏂ ᎦᏥᏯᏛᎩᎠ",
             forms: ["gvyatvgi'a (Present Tense, First Singular)", "tsiyatvgi'a (Present Tense, First Singular)", "gatsiyatvgi'a (Present Tense, First Singular)", "atvgi'a (Present Tense, Third Singular)"]],
            [number: 3,
             english: "John, if I hear you, I will help you.",
             a: "tsani, iyuhno yigvyatvgi'a dagvsdelvhi",
             b: "ᏣᏂ ᎢᏳᏃ ᏱᎬᏯᏛᎦᏅ ᏓᎬᏍᏕᎸᎯ",
             forms: ["gvyatvgi'a (Present Tense, First Singular)", "atvgi'a (Present Tense, Third Singular)"]],
            [number: 4,
             english: "They hear wolves.",
             a: "wahya dan(a)tvgi'a",
             b: "ᏩᏯ ᏓᎾᏛᎩᎠ",
             forms: ["ᏓᎾᏛᎩᎠ (Present Tense, Third Plural)"]],
            [number: 5,
             english: "They hear bells.",
             a: "tsuhalvni dan(a)tvgi'a",
             b: "ᏧᎭᎸᏂ ᏓᎾᏛᎩᎠ",
             forms: ["ᏓᎾᏛᎩᎠ (Present Tense, Third Plural)"]],
            [number: 6,
             english: "Last year I heard from John.",
             a: "sudetiyvda tsigesv tsiyatvganv tsani",
             b: "ᏑᏕᏘᏴᏓ ᏥᎨᏒ ᏥᏯᏛᎦᏅ ᏣᏂ",
             forms: []],
            [number: 7,
             english: "John, I hear the song.",
             a: "tsani, gatvgi'a kanogisdi",
             b: "ᏣᏂ, ᏰᎵᏊᏍᎪ ᎣᏯᏛᎬᎦ?",
             forms: ["gatvgi'a (Present Tense, First Singular)", "atvgi'a (Present Tense, Third Singular)"]],
            [number: 8,
             english: "You and I keep on hearing the song.",
             a: "Gaya'isv inatvgisgo kanogida",
             b: "ᏂᎪᎯᎸᎢ ᎢᎾᏛᎩᏍᎪ ᏗᎧᏃᎩᏓ",
             forms: []],
            [number: 9,
             english: "Let us hear the singing (right now).",
             a: "idatvgvga daninogisgv'i",
             b: "ᎢᏓᏛᎬᎦ ᏓᏂᏃᎩᏍᎬᎢ",
             forms: ["atvgvga (Immediate Past Tense)"]],
            [number: 10,
             english: "John, I want for you to hear this song.",
             a: "tsani, agwaduliha ts(a)tvgodi'i hi'a kanogida",
             b: "ᏣᏂ, ᎠᏆᏚᎵᎭ ᎯᎠ ᏗᎧᏃᎩᏓ ᏣᏛᎪᏗ",
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
