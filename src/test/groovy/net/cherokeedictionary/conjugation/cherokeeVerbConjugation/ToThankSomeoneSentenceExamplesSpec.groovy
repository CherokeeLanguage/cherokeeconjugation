package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Thank someone" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.145-146
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
class ToThankSomeoneSentenceExamplesSpec extends Specification {

    static final String VERB = "to thank someone"
    static final String SOURCE_PAGE = "pp.145-146"

    /** All ten example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "John, after Mary tells her story, thank her for all of us!",
             a: "tsani, asgwadv meli kanohlvsgv, nigada gvwalihelitseha hiyoselv'i",
             b: "ᏣᏂ, ᎠᏍᏆᏛ ᎺᎵ ᎧᏃᏢᏍᎬ, ᏂᎦᏓ ᎬᏩᎵᎮᎵᏤᎭ ᎯᏲᏎᎸᎢ",
             forms: ["alihelitseha (Present Tense, Third Singular)"]],
            [number: 2,
             english: "We praise God and we thank Him.",
             a: "osdilvgwodiha unelanvhi ale osdalielitseha",
             b: "ᎣᏍᏗᎸᏉᏗᎭ ᎤᏁᎳᏅᎯ ᎠᎴ ᎣᏍᏓᎵᎡᎵᏤᎭ",
             forms: ["ᎣᏍᏓᎵᎡᎵᏤᎭ (Present Tense, First Dual Exclusive)"]],
            [number: 3,
             english: "All you people, be thankful and give thanks to God!",
             a: "nitsi'v itsiyvwi itsalihelitsadti gesesdi ale etsalielitsehesdi unelanvhi!",
             b: "ᏂᏥᎥ ᎢᏥᏴᏫ ᎢᏣᎵᎮᎵᏣᏗ ᎨᏎᏍᏗ ᎠᎴ ᎡᏣᎵᎡᎵᏣᎮᏍᏗ ᎤᏁᎳᏅᎯ",
             forms: []],
            [number: 4,
             english: "John, when he gives you the present, thank him!",
             a: "tsani, adanedi tsanelv, hiyalielitselv'i!",
             b: "ᏣᏂ, ᎠᏓᏁᏗ ᏣᏁᎸ, ᎯᏯᎵᎡᎵᏤᎸᎢ",
             forms: []],
            [number: 5,
             english: "I thank God every day.",
             a: "nidudodagwisv tsiyalielitseho unelanv",
             b: "ᏂᏚᏙᏓᏈᏒ ᏥᏯᎵᎡᎵᏤᎰ ᎤᏁᎳᏅᎯ",
             forms: []],
            [number: 6,
             english: "Mary, thank you for the gift!",
             a: "meli, gvyalielitseha nasgi adanedi",
             b: "ᎺᎵ, ᎬᏯᎵᎡᎵᏤᎭ ᎾᏍᎩ ᎠᏓᏁᏗ",
             forms: ["ᎬᏯᎵᎡᎵᏤᎭ (Present Tense, First Singular)"]],
            [number: 7,
             english: "Mary, while John is waiting, I want you to thank him.",
             a: "meli, tsani agatiyv igohida agwaduli hiyalielitsedi'i",
             b: "ᎺᎵ, ᏣᏂ ᎠᎦᏘᏴ ᎢᎪᎯᏓ ᎠᏆᏚᎵ ᎯᏯᎵᎡᎵᏤᏗᎢ",
             forms: []],
            [number: 8,
             english: "I gave John a lot of money. May he be thankful and thank me for it!",
             a: "tsugwisdi adela detsinelv tsani. ulihelitsati gesesdi ale agwalihelitselv'i!",
             b: "ᏧᏈᏍᏗ ᎠᏕᎳ ᏕᏥᏁᎸ ᏣᏂ. ᎤᎵᎮᎵᏣᏘ ᎨᏎᏍᏗ ᎠᎴ ᎠᏆᎵᎮᎵᏤᎸᎢ!",
             forms: ["alihelitselv'i (Future Imperative/Volative)"]],
            [number: 9,
             english: "John, did you thank your dad yesterday?",
             a: "tsani, hiyalielitselesgo tsadoda svhi tsigesv?",
             b: "ᏣᏂ, ᎯᏯᎵᎡᎵᏤᎴᏍᎪ ᏣᏙᏓ ᏒᎯ ᏥᎨᏒ?",
             forms: []],
            [number: 10,
             english: "I thanked him just now.",
             a: "tsiyalielitsisi",
             b: "ᏥᏯᎵᎡᎵᏥᏏ",
             forms: ["ᏥᏯᎵᎡᎵᏥᏏ (Immediate Past Tense)"]],
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
