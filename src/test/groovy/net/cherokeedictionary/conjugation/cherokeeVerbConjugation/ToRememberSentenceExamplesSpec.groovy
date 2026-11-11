package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Remember" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.115-116
 * (printed page numbers of the full 164-page document).
 *
 * Sixteen example sentences, each printed as:
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
class ToRememberSentenceExamplesSpec extends Specification {

    static final String VERB = "to remember"
    static final String SOURCE_PAGE = "pp.115-116"

    /** All sixteen example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "John, I liked your dad. I will always remember him.",
             a: "tsani, tsilvgwotanv tsadoda. nigohilv tsiyanvdadisgesd.",
             b: "ᏣᏂ, ᏥᎸᏉᏔᏅ ᏣᏙᏓ. ᏂᎪᎯᎸ ᏥᏯᏅᏓᏗᏍᎨᏍᏗ.",
             forms: []],
            [number: 2,
             english: "Mary and Jane, you girls remember to brush your teeth every morning!",
             a: "meli ale tseni, sdigehyutsa sdanvdadisgesdi disdinvgalvdi desdinvdogv dugitsvnvsv'i",
             b: "ᎺᎵ ᎠᎴ ᏤᏂ, ᏍᏗᎨᏳᏣ ᏍᏓᏅᏓᏗᏍᎨᏍᏗ ᏗᏍᏗᏅᎦᎸᏗ ᏕᏍᏗᏅᏙᎬ ᏚᎩᏨᏅᏒᎢ",
             forms: []],
            [number: 3,
             english: "Mary, I want for you to always remember me.",
             a: "meli, agwaduli nigohilv sgwadadisdiyi",
             b: "ᎺᎵ, ᎠᏆᏚᎵ ᏂᎪᎯᎸ ᏍᏆᏓᏗᏍᏗᏱ",
             forms: []],
            [number: 4,
             english: "On Veterans' Day, everyone remembers the soldiers.",
             a: "uniyosidolv igohi nigadiyu aniyosgi dananvdadisgo'i",
             b: "ᎤᏂᏲᏏᏙᎸ ᎢᎪᎯ ᏂᎦᏗᏳ ᎠᏂᏲᏍᎩ ᏓᎾᏅᏓᏗᏍᎪᎢ",
             forms: ["anvdadisgo'i (Present Habitual Tense)"]],
            [number: 5,
             english: "John, look at that car and remember what it looks like.",
             a: "tsani, higowata na dagwalelu ale hanvdadisgesdi dikanodiyi",
             b: "ᏣᏂ, ᎯᎪᏩᏔ Ꮎ ᏓᏆᎴᎷ ᎠᎴ ᎭᏅᏓᏗᏍᎨᏍᏗ ᏗᎧᏃᏗᏱ",
             forms: []],
            [number: 6,
             english: "Mary, remember John for the rest of your life.",
             a: "meli hiyanvdadisgesdi tsani hehv igohida",
             b: "ᎺᎵ ᎯᏯᏅᏓᏗᏍᎨᏍᏗ ᏣᏂ ᎮᎲ ᎢᎪᎯᏓ",
             forms: []],
            [number: 7,
             english: "Charley, when you see John tomorrow, remember what he looks like!",
             a: "tsali, higo'v tsani sinale hanvdadv nusdv tsagaganodi'i",
             b: "ᏣᎵ, ᎯᎪᎥ ᏣᏂ ᏏᎾᎴ ᎭᏅᏓᏛ ᏄᏍᏛ ᏣᎦᎦᏃᏗᎢ",
             forms: []],
            [number: 8,
             english: "Everyone should always remember their old friends.",
             a: "nigadiyu tsunanvdadisdi anigayvli tsunali'i",
             b: "ᏂᎦᏗᏳ ᏧᎾᏅᏓᏗᏍᏗ ᎠᏂᎦᏴᎵ ᏧᎾᎵᎢ",
             forms: []],
            [number: 9,
             english: "John always forgets my birthday. May he remember it this year!",
             a: "tsani nigohilv uwakewisgo agwadetiyisgv'i. anvdadv hi'a tsudetiyvsadi!",
             b: "ᏣᏂ ᏂᎪᎯᎸ ᎤᏩᎨᏫᏍᎪ ᎠᏆᏕᏗᏱᏍᎬᎢ. ᎠᏅᏓᏛ ᎯᎠ ᏧᏕᏘᏴᏌᏗ!",
             forms: []],
            [number: 10,
             english: "Remember the Sabbath and keep it holy!",
             a: "itsanvdadisgesdi nasgi galigwogine-iga ale itsilvgwodesdi",
             b: "ᎢᏣᏅᏓᏗᏍᎨᏍᏗ ᎾᏍᎩ ᎦᎵᏉᎩᏁ-ᎢᎦ ᎠᎴ ᎢᏥᎸᏉᏕᏍᏗ",
             forms: []],
            [number: 11,
             english: "Mary, will you remember me ten years from now?",
             a: "meli, sgwanvdadisgesdis sgohi winadetiyvhv?",
             b: "ᎺᎵ, ᏍᏆᏅᏓᏗᏍᎨᏍᏗᏍ ᏍᎪᎯ ᏫᎾᏕᏘᏴᎲ?",
             forms: []],
            [number: 12,
             english: "John, I will always remember you.",
             a: "tsani, nigohilv gvyanvdadisgesdi",
             b: "ᏣᏂ, ᏂᎪᎯᎸ ᎬᏯᏅᏓᏗᏍᎨᏍᏗ",
             forms: []],
            [number: 13,
             english: "John, if you teach me how to ride a bike, I will always remember it.",
             a: "tsani, yisgweyohna agwagilvdodi ta'li digagwati, nigohilv yiganvdada",
             b: "ᏣᏂ, ᏱᏍᏇᏲᎿ ᎠᏆᎩᎸᏙᏘ ᏔᎵ ᏗᎦᏆᏘ, ᏂᎪᎯᎸ ᏱᎦᏅᏓᏓ",
             forms: ["ganvdada (Immediate Past Tense)", "anvdada (Immediate Past Tense)"]],
            [number: 14,
             english: "When I learn a new word, I always remember it.",
             a: "yagwadelogwa itse kane'isdi nigohilv ganvdadisgo'i",
             b: "ᏯᏆᏕᎶᏆ ᎢᏤ ᎧᏁᎢᏍᏗ ᏂᎪᎯᎸ ᎦᏅᏓᏗᏍᎪᎢ",
             forms: ["ganvdadisgo'i (Present Habitual Tense)", "anvdadisgo'i (Present Habitual Tense)"]],
            [number: 15,
             english: "I will teach you how to ride a bike if you promise to remember how to do it.",
             a: "yigvyeyohvga ta'li digagwati tsagilvdodi yisgidu'isdanela tsanvdadisdi iyadvnedi'i",
             b: "ᏱᎬᏰᏲᎲᎦ ᏔᎵ ᏗᎦᏆᏘ ᏣᎩᎸᏙᏗ ᏱᏍᎩᏚᎢᏍᏓᏁᎳ ᏣᏅᏓᏗᏍᏗ ᎢᏯᏛᏁᏗᎢ",
             forms: []],
            [number: 16,
             english: "Mary, if I tell you that story, will you remember it tomorrow?",
             a: "meli, iyuno yigvnohisela na kanohelvnv eligwus tanvdadi sinale iyv?",
             b: "ᎺᎵ, ᎢᏳᏃ ᏱᎬᏃᎯᏎᎳ Ꮎ ᎧᏃᎮᎸᏅ ᎡᎵᏊᏍ ᏔᏅᏓᏗ ᏏᎾᎴ ᎢᏴ?",
             forms: []],
    ]

    def "example #row.number is recorded with all three lines intact"() {
        expect: "english sentence, romanized line and syllabary line are all preserved"
        row.english && row.a && row.b

        and: "the verb forms it exercises are documented for later deconstruction"
        row.forms != null

        where: "all sixteen verb-book examples"
        row << EXAMPLES
    }

    def "example #row.number: syllabary and romanized lines are non-trivial"() {
        expect:
        row.a.length() > 10
        row.b.length() > 5

        where: "all sixteen verb-book examples"
        row << EXAMPLES
    }

    def "the example collection is complete (sixteen examples)"() {
        expect:
        EXAMPLES*.number == [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
    }
}
