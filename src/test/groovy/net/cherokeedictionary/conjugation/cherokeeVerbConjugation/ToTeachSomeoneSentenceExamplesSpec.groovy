package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Teach Someone" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.140-141
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
class ToTeachSomeoneSentenceExamplesSpec extends VerbBaseSpec {

    static final String VERB = "to teach someone"
    static final String SOURCE_PAGE = "pp.140-141"

    /** All nine example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "Last year I taught Cherokee to those girls.",
             a: "sudetiyvda tsigesv tsalagi degatsiyeyohnv na anigehyutsa",
             b: "ᏑᏕᏘᏴᏓ ᏥᎨᏒ ᏣᎳᎩ ᏕᎦᏥᏰᏲᏅ Ꮎ ᎠᏂᎨᏳᏣ",
             forms: []],
            [number: 2,
             english: "Mary, next year, teach us Cherokee!",
             a: "meli, so'i wadetiyvhv tsalagi desgiyeyohnv'i!",
             b: "ᎺᎵ, ᏐᎢ ᏩᏕᏘᏴᎲ ᏣᎳᎩ ᏕᏍᎩᏰᏲᏅᎢ",
             forms: []],
            [number: 3,
             english: "Mary, teach me some Cherokee (right now)!",
             a: "meli, tsalagi disgwehyohvga!",
             b: "ᎺᎵ, ᏣᎳᎩ ᏗᏍᏇᏲᎲᎦ!",
             forms: []],
            [number: 4,
             english: "Joe, watch the man fix his car and then teach me how to do it.",
             a: "tsowi, hiyagatosda na asgaya utseli dagwalelu osda nigvhnehv'i ale sgweyohnv'i yagwvndi'i",
             b: "ᏦᏫ, ᎯᏯᎦᏎᏍᏓ Ꮎ ᎠᏂᏍᎦᏯ ᎤᏤᎵ ᏓᏆᎴᎷ ᎣᏍᏓ ᏂᎬᏁᎲ ᎠᎴ ᏍᏇᏲᏅᎢ ᏯᏋᏁᏗᎢ",
             forms: []],
            [number: 5,
             english: "All my friends want me to teach them Cherokee.",
             a: "nigada digwali unaduli tsalagi gatsiyeyodi'i",
             b: "ᏂᎦᏓ/ᎾᏂᎥ ᏗᏆᎵᏆ ᎤᎾᏚᎵ ᏣᎳᎩ ᎦᏥᏰᏲᏗ",
             forms: []],
            [number: 6,
             english: "Do you know how to teach French?",
             a: "Hiktahas yitsadvndi ditsadehyodi anigalvtsi uniwonihisdi?",
             b: "ᏣᏅᏔᏍᎪ ᏗᏣᏕᏲᏗ ᎠᏂᎦᎸᏣ ᎤᏂᏬᏂᎯᏍᏗ?",
             forms: []],
            [number: 7,
             english: "Kids often teach each other how to behave.",
             a: "diniyotli unvsa danadadehyohvsgo unohiyhdi'i",
             b: "ᏗᏂᏲᎵ ᏯᏃᎩ ᏓᎾᏓᏕᏲᎲᏍᎪ ᎢᏯᏛᏁᏗ ᎠᎴᏂᏓᏍᏗ",
             forms: []],
            [number: 8,
             english: "Mary, teach me how to do it.",
             a: "Meli, sgweyohvga yagwadvndi'i",
             b: "ᎺᎵ, ᏍᏇᏲᎲᎦ ᏯᏆᏛᏁᏗᎢ",
             forms: []],
            [number: 9,
             english: "John knows Cherokee very well. Let him teach others how to speak it!",
             a: "tsani, udohiyu osda un(v)ta tsalagi uwonihisdi'i. widigeyohvga aniso'i uniwonihisdi'i",
             b: "ᏣᏂ, ᎤᏙᎯᏳ ᎣᏍᏓ ᎤᏅᏔ ᏣᎳᎩ ᎤᏬᏂᎯᏍᏗᎢ. ᏫᏗᎨᏲᎲᎦ ᎠᏂᏐᎢ ᎤᏂᏬᏂᎯᏍᏗᎢ",
             forms: ["ᏫᏗᎨᏲᎲᎦ (Immediate Imperative/Volative)"]],
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
