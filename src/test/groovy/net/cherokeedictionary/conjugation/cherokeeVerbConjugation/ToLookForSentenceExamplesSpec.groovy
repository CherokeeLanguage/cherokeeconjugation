package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Look for" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.100-101
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
class ToLookForSentenceExamplesSpec extends Specification {

    static final String VERB = "to look for"
    static final String SOURCE_PAGE = "pp.100-101"

    /** All eight example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "I looked for a new car and I found it.",
             a: "agiyolv itse dagwalelu ale akiwatvhv'i",
             b: "ᎠᎩᏲᎸ ᎢᏤ ᏓᏆᎴᎷ ᎠᎴ ᎠᎩᏩᏛᎲᎢ",
             forms: []],
            [number: 2,
             english: "I am looking for those children.",
             a: "gatsiyoha nasgi diniyotli",
             b: "ᎦᏥᏲᎭ ᎾᏍᎩ ᏗᏂᏲᏟ",
             forms: ["tsiyoha (Present Tense, First Singular)", "gatsiyoha (Present Tense, First Singular)"]],
            [number: 3,
             english: "John, look for a new car!",
             a: "tsani, tsayoga itse dagwalelu",
             b: "ᏣᏂ, ᏣᏲᎦ ᎢᏤ ᏓᏆᎴᎷ",
             forms: ["tsayoga (Immediate Imperative/Volative)"]],
            [number: 4,
             english: "John needs a new car. May he look for it!",
             a: "tsani unigvga itse dagwalelu. wuyoga!",
             b: "ᏣᏂ ᎤᏂᎬᎦ ᎢᏤ ᏓᏆᎴᎷ. ᏭᏲᎦ!",
             forms: ["wuyoga (Immediate Imperative/Volative)"]],
            [number: 5,
             english: "Our children (three or more) want for you and me to look for their cat.",
             a: "digetsi diniyotli unaduli ediyosdi unatseli wesa",
             b: "ᏗᎨᏥ ᏗᏂᏲᏟ ᎤᎾᏚᎵ ᎡᏗᏲᏍᏗ ᎤᎾᏤᎵ ᏪᏌ",
             forms: []],
            [number: 6,
             english: "Tomorrow I will look for the lost keys.",
             a: "sunale iyv dodvgiyoli tsudelitsvhi disdu'isdi",
             b: "ᏑᎾᎵ ᎢᏴ ᏙᏛᎩᏲᎵ ᏧᏕᎵᏨᎯ ᏗᏍᏚᎢᏍᏗ",
             forms: ["ᏛᎩᏲᎵ (Future Tense)"]],
            [number: 7,
             english: "A year ago I looked for a car. Next year you (two) look for one!",
             a: "sudetiyvda tsigesv agiyolv'i dagwalelu. sudetiyvda tsigesesdi nihi sditali sdiyolv'i.",
             b: "ᏑᏕᏘᏴᏓ ᏥᎨᏒ ᎠᎩᏲᎸᎢ ᏓᏆᎴᎷ. ᏑᏕᏘᏴᏓ ᏥᎨᏎᏍᏗ ᏂᎯ ᏍᏔᎵ ᏍᏍᏲᎸᎢ.",
             forms: ["agiyolv'i (Remote Past Tense)", "sdiyolv'i (Future Imperative/Volative)"]],
            [number: 8,
             english: "I am always looking for something good to eat.",
             a: "nigohilv agiyoho gohusdi osda agisdi",
             b: "ᏂᎪᎯᎸ ᎠᎩᏲᎰ ᎪᎱᏍᏗ ᎣᏍᏓ ᎠᎩᏍᏗ",
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
