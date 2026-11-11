package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Love" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.105-106
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
class ToLoveSentenceExamplesSpec extends VerbBaseSpec {

    static final String VERB = "to love"
    static final String SOURCE_PAGE = "pp.105-106"

    /** All nine example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "Sarah, do you love me?",
             a: "seli, sgigeyuhas?",
             b: "ᏎᎵ, ᏍᎩᎨᏳᎭᏍ?",
             forms: ["sgigeyuha (Present Tense, Second Singular)"]],
            [number: 2,
             english: "John, I love you now and I will always love you.",
             a: "tsani, nogwu tsigi gvgeyu'a ale nigohilv gvgeyusesdi",
             b: "ᎬᎨᏳ ᏣᏂ, ᎬᎨᏳᎠ ᏃᏊ ᏥᎩ ᎠᎴ ᏂᎪᎯᎸ ᎬᎨᏳᏎᏍᏗ",
             forms: ["gvgeyu'a (Present Tense, First Singular)"]],
            [number: 3,
             english: "John and I both love Sarah.",
             a: "tsani ale aya itsula osdigeyu'a seli",
             b: "ᏣᏂ ᎠᎴ ᎠᏯ ᎢᏧᎳ ᎣᏍᏗᎨᏳᎠ ᏎᎵ",
             forms: ["osdigeyu'a (Present Tense, First Dual Exclusive)"]],
            [number: 4,
             english: "When I see Sarah, I love her.",
             a: "nogwu yitsigoha seli, tsigeyuso'i",
             b: "ᏃᏊ ᏥᎪᏩᏔ ᏎᎵ, ᏥᎨᏳᏐᎢ",
             forms: []],
            [number: 5,
             english: "Last year, when I loved Mary, I was very happy.",
             a: "sudetiyvdv tsigesv, tsitsigeyusv meli, agwalihelitsonv gesv'i",
             b: "ᏑᏕᏘᏴᏛ ᏥᎨᏒ, ᏥᏥᎨᏳᏒ ᎺᎵ, ᎠᏆᎵᎮᎵᏦᏅ ᎨᏒᎢ",
             forms: []],
            [number: 6,
             english: "John, will those girls always love you?",
             a: "tsani, nigohilvs getsageyusesdi na anigehyutsa?",
             b: "ᏣᏂ, ᏂᎦᏓᏍᎪ Ꮎ ᎠᏂᎨᏳᏣ ᏂᎪᎯᎸ ᎨᏣᎪᏳᏎᏍᏗ",
             forms: []],
            [number: 7,
             english: "Sarah and Jane, when you were little girls, you loved your parents.",
             a: "seli ale tseni, sdigeyutsa tsigesv, desdigeyuse disdigayvlige'i",
             b: "ᏎᎵ ᎠᎴ ᏤᏂ, ᏗᏍᏓᏍᏗᏱᏊ ᏥᎨᏒ, ᏕᏍᏗᎨᏳᏒ ᏗᏍᏗᎦᏴᎵᎨ",
             forms: []],
            [number: 8,
             english: "John is a religious boy. May he always love God!",
             a: "tsani uwohiyuhi achutsa. nigohilv ugeyusesdi unehlanvhi!",
             b: "ᏣᏂ ᎤᏬᎯᏳᎯ ᎠᏧᏣ. ᏂᎪᎯᎸ ᎤᎨᏳᏎᏍᏗ ᎤᏁᎳᏅᎯ",
             forms: []],
            [number: 9,
             english: "I want for you boys to always love this song.",
             a: "agwaduli nihi itsichutsa nigohilv itsigeyuhi iyulisdohdi hi'a kanogisdi",
             b: "ᎠᏆᏚᎵ ᏂᎯ ᏍᏗᏧᏣ ᏂᎪᎯᎸ ᏍᏗᎨᏳᎯ ᎢᏳᎵᏍᏙᏗ ᎯᎠ ᏗᎧᏃᎩᏓ",
             forms: []],
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
