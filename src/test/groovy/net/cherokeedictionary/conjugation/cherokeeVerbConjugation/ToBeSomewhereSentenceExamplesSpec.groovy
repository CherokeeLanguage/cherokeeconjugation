package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Be Somewhere" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations Single Entry (Durbin Feeling verb book), pp.21-22.
 *
 * Nine example sentences, each printed as:
 *   english - the English sentence
 *   a       - the romanized Cherokee sentence
 *   b       - the syllabary Cherokee sentence
 *
 * The sentences are preserved verbatim for later deconstruction work; the
 * "forms" field lists the conjugated forms of this verb (To Be Somewhere) that
 * each sentence exercises, with the tense spec that covers each form.
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToBeSomewhereSentenceExamplesSpec extends Specification {

    static final String VERB = "to be somewhere"
    static final String SOURCE_PAGE = "pp.21-22"

    /** All nine example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "Last year John and Mary were in Tulsa. Now they are in Muskogee.",
             a: "sudetiyvda tsigesv tsani ale meli tal(i)si anedohv. nogwuhno tsigi guso'i anedoha",
             b: "ᏑᏕᏘᏴᏓ ᏥᎨᏒ ᏣᏂ ᎠᎴ ᎺᎵ ᏔᎵᏏ ᎠᏁᏙᎲ. ᏃᏊᏃ ᏥᎩ ᎫᏐᎢ ᎠᏁᏙᎭ.",
             forms: ["anedohv (Remote Past, Third Plural)", "anedoha (Present, Third Plural)"]],

            [number: 2,
             english: "John, tomorrow you have an appointment with the dentist. Be there!",
             a: "tsani, sanale iyv tsigesesdi dasvsdi hwiyagohw(a)tvdi didan(a)desgi hwedohesdi.",
             b: "ᏣᏂ, ᏍᏌᎾᎴ ᎢᏴ ᏥᎨᏎᏍᏗ ᏓᏒᏍᏗ ᏫᎯᏯᎪᏩᏛᏗ ᏗᏓᏅᏕᏍᎩ ᏫᎮᏙᎮᏍᏗ.",
             forms: ["hwedohesdi (Future Imperative/Volative, Second Singular)"]],

            [number: 3,
             english: "Both of us were happy when we were in Arizona last year.",
             a: "itsula osdal iheligv nahiyu 'Arizona' tsiwoginedolv so'i tsudetiyvda tsigesv'i",
             b: "ᎢᏧᎳ ᎣᏍᏓᎵᎮᎵᎬ ᎾᎯᏳ 'Arizona' ᏥᏬᎩᏁᏙᎸ ᏐᎢ ᏧᏕᏘᏴᏓ ᏥᎨᏒᎢ",
             forms: ["tsigesv'i (remote past form of 'to be')"]],

            [number: 4,
             english: "John always wanted to live in North Carolina. May he be there by next Christmas!",
             a: "tsani nigohilv udulvhv tsalagi uweti uneladisdi. Eligw(u) yiwedohesdi so'i udetiyvsadisv danisdayohihv'i.",
             b: "ᏣᏂ ᏂᎪᎯᎸ ᎤᏚᎸᎲ ᏣᎳᎩ ᎤᏪᏘ ᎤᏁᎳᏗᏍᏗ. ᎡᎵᏊ ᏱᏪᏙᎮᏍᏗ ᏐᎢ ᎤᏕᏘᏴᏍᏌᏗᏒ ᏓᏂᏍᏓᏲᎯᎲᎢ.",
             forms: ["yiwedohesdi (Future Imperative/Volative, Third Singular)"]],

            [number: 5,
             english: "My son is always at his girlfriend's house.",
             a: "agwetsi atsutsa nigohilv unalikdi tsuwenvsv wedoho'i",
             b: "ᎠᏇᏥ ᎠᏧᏣ ᏂᎪᎯᎸ ᎤᎾᎵᎪᏗ ᏧᏪᏅᏒ ᏪᏙᎰᎢ",
             forms: ["wedoho'i (Present Habitual, Third Singular)"]],

            [number: 6,
             english: "Right now my mom is at the Presbyterian church.",
             a: "etsi tsunilawisdi wedoha nogwu tsigi",
             b: "ᎡᏥ ᏧᏂᎳᏫᏍᏗ ᏪᏙᎭ ᏃᏊ ᏥᎩ",
             forms: ["wedoha (Present, Third Singular)"]],

            [number: 7,
             english: "John, I want for you and Elsy to be at the church tomorrow.",
             a: "tsani, nihidv ale el(i)s(i) digalaw(i)sdi sdedasdi sanale'iyv agwaduli",
             b: "ᏣᏂ, ᏂᎯᏛ ᎠᎴ ᎡᎵᏏ ᏗᎦᎳᏫᏍᏗ ᏍᏕᏓᏍᏗ ᏍᏌᎾᎴ ᎢᏴ ᎠᏆᏚᎵ",
             forms: ["sdedasdi (Infinitive, Second Dual)"]],

            [number: 8,
             english: "I always wanted (for me) to be in Oklahoma City.",
             a: "ogalahoma gaduhv utana, nigolv wagwedasdi agwadulisgoi",
             b: "ᎣᎦᎳᎰᎹ ᎦᏚᎲ ᎤᏔᎾ, ᏂᎪᎸ ᏩᏇᏓᏍᏗ ᎠᏆᏚᎵᏍᎪᎢ",
             forms: ["wagwedasdi (Infinitive, First Singular)"]],

            [number: 9,
             english: "John, you and I and Mary are supposed to be in Tulsa tomorrow. May we be there!",
             a: "tsani, nihi ale ayv melihno wigiluhisdi tal(i)si sanale'i. Asedv widedohesdi!",
             b: "ᏣᏂ, ᏂᎯ ᎠᎴ ᎠᏴ ᎺᎵᏃ ᏫᎩᎷᎯᏍᏗ ᏔᎵᏏ ᏍᏌᎾᎴᎢ. ᎠᏎᏛ ᏫᏕᏙᎮᏍᏗ",
             forms: ["widedohesdi (Future Imperative/Volative, First Plural Inclusive)"]],
    ]

    def "example #row.number is recorded with all three lines intact"() {
        expect: "english sentence, romanized line and syllabary line are all preserved"
        row.english && row.a && row.b

        and: "the verb forms it exercises are documented for later deconstruction"
        row.forms

        where: "all nine verb-book examples"
        row << EXAMPLES
    }

    def "example #row.number: syllabary and romanized lines are non-trivial"() {
        expect:
        row.a.length() > 10
        row.b.length() > 10

        where: "all nine verb-book examples"
        row << EXAMPLES
    }

    def "the example collection is complete (nine examples)"() {
        expect:
        EXAMPLES*.number == [1, 2, 3, 4, 5, 6, 7, 8, 9]
    }
}
