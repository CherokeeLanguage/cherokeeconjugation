package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Go" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.38-41
 * (printed page numbers of the full 164-page document).
 *
 * Twenty-eight example sentences, each printed as:
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
class ToGoSentenceExamplesSpec extends VerbBaseSpec {

    static final String VERB = "to go"
    static final String SOURCE_PAGE = "pp.38-41"

    /** All twenty-eight example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "John, tomorrow I want for you and me to go to Tahlequah.",
             a: "tsani, sunale iyv agwaduli nihi ale ayv daligwa ginenvsdi",
             b: "ᏣᏂ, ᏑᎾᎴ ᎢᏴ ᎠᏆᏚᎵ ᏂᎯ ᎠᎴ ᎠᏴ ᏓᎵᏆ ᎩᏁᏅᏍᏗ",
             forms: ["ginenvsdi (Infinitive, First Dual Inclusive)"]],
            [number: 2,
             english: "I'm in Tulsa but I want to go to Coweta.",
             a: "tvlisa gedoha asesgini Coweta agwenvsdi agwaduli",
             b: "ᏛᎵᏌ ᎨᏙᎭ ᎠᏎᏍᎩᏂ ᎪᏫᏓ ᎠᏇᏅᏍᏗ ᎠᏆᏚᎵ",
             forms: ["agwenvsdi (Infinitive, First Singular)"]],
            [number: 3,
             english: "John, tomorrow you go to Tulsa!",
             a: "tsani, sunale tvlisa henvsv'i!",
             b: "ᏣᏂ, ᏑᎾᎴ ᏛᎵᏌ ᎮᏅᏒᎢ!",
             forms: []],
            [number: 4,
             english: "After Christmas the three sisters will go to Texas.",
             a: "danisdayohi ulosohnv tso'i iyanadalv Texas dvnesi",
             b: "ᏓᏂᏍᏓᏲᎯ ᎤᎶᏐᏅ ᏦᎢ ᎢᏯᎾᏓᎸ Texas ᏛᏁᏏ",
             forms: ["dvnesi (Future (Expected) Tense, Third Plural Form)"]],
            [number: 5,
             english: "When we go to church we are happy.",
             a: "tsunilawisdi yogena osda ogiyelvso'i",
             b: "ᏧᏂᎳᏫᏍᏗ ᏲᎨᎾ ᎣᏍᏓ ᎣᎩᏰᎸᏐᎢ",
             forms: []],
            [number: 6,
             english: "After Mary and her daughters go to Tulsa, they will look for John.",
             a: "meli ale tsuwetsi anigehyutsa tvlisa waniluhtsv'i dvniyoli tsani",
             b: "ᎺᎵ ᎠᎴ ᏧᏪᏥ ᎠᏂᎨᏳᏣ ᏛᎵᏌ ᏩᏂᎷᏨᎢ ᏛᏂᏲᎵ ᏣᏂ",
             forms: []],
            [number: 7,
             english: "My mom always wanted to visit Paris. May she go there!",
             a: "agitsi nigohilv udulisgv Paris wuwedasdi. wedolv'i!",
             b: "ᎠᎩᏥ ᏂᎪᎯᎸ ᎤᏚᎵᏍᎬ Paris ᏭᏪᏓᏍᏗ. ᏪᏙᎸᎢ!",
             forms: []],
            [number: 8,
             english: "I always wanted to be in Texas. May I go there next year!",
             a: "nigohilv agwadulisgv wagwadehdi Texas. wigadenv'i so'i wadetiyvhv'i.",
             b: "ᏂᎪᎯᎸ ᎠᏆᏚᎵᏍᎬ ᏩᏆᏕᏗ Texas. ᏫᎦᏕᏅᎢ ᏐᎢ ᏩᏕᏘᏴᎲᎢ.",
             forms: []],
            [number: 9,
             english: "Mary, may you drive slowly!",
             a: "meli, tohigwu wilohi!",
             b: "ᎺᎵ, ᏙᎯᏊ ᏫᎶᎯ",
             forms: []],
            [number: 10,
             english: "Last year my brothers and I went to the fair.",
             a: "sudetiyvda tsigesv otsalinvtli ayvhno dinadvnelisgv wogedolv'i",
             b: "ᏑᏕᏘᏴᏓ ᏥᎨᏒ ᎣᏣᎵᏅᏟ ᎠᏴᏃ ᏗᎾᏛᏁᎵᏍᎬ ᏬᎨᏙᎸᎢ",
             forms: []],
            [number: 11,
             english: "John & I are going to Tahlequah.",
             a: "tsani ale ayv osdega daligwa",
             b: "ᏣᏂ ᎠᎴ ᎠᏴ ᎣᏍᏕᎦ ᏓᎵᏆ",
             forms: ["osdega (Present Tense, First Dual Exclusive)"]],
            [number: 12,
             english: "Mary, are you and I going to Tahlequah?",
             a: "meli, danesisgo daligwa",
             b: "ᎺᎵ, ᏓᏁᏏᏍᎪ ᏓᎵᏆ",
             forms: ["danesi (Future (Expected) Tense, First Dual Inclusive)"]],
            [number: 13,
             english: "A year ago, you, me, and John went to the state fair in Tulsa.",
             a: "sudetiyvda tsigesv tsani ale nihi ayvhno igenvsv'i sgadugi tsunadatlisahv'i",
             b: "ᏑᏕᏘᏴᏓ ᏥᎨᏒ ᏣᏂ ᎠᎴ ᏂᎯ ᎠᏴᏃ ᎢᎨᏅᏒᎢ ᏍᎦᏚᎩ ᏧᎾᏓᏟᏌᎲᎢ",
             forms: ["igenvsv'i (Remote Past Tense, First Plural Inclusive)"]],
            [number: 14,
             english: "Last summer they went to Oklahoma City. They didn't go to Tulsa.",
             a: "gogi tsigesv ogalahoma utana digaduhv'i unenvsv. hla tvlisa yunenvse'i.",
             b: "ᎪᎩ ᏥᎨᏒ ᎣᎦᎳᎰᎹ ᎤᏔᎾ ᏗᎦᏚᎲᎢ ᎤᏁᏅᏒ. Ꮭ ᏛᎵᏌ ᏳᏁᏅᏎᎢ.",
             forms: []],
            [number: 15,
             english: "Tomorrow, when it's warm, I'll go to the lake.",
             a: "sinale iyv uganowesdi, tsvdalv dagesi",
             b: "ᏏᎾᎴ ᎢᏴ ᎤᎦᏃᏪᏍᏗ, ᏨᏓᎸ ᏓᎨᏏ",
             forms: ["dagesi (Future (Expected) Tense, First Singular)"]],
            [number: 16,
             english: "John and I will go to Tahlequah.",
             a: "tsani ayvhno daligwa dayosdesi",
             b: "ᏣᏂ ᎠᏴᏃ ᏓᎵᏆ ᏓᏲᏍᏕᏏ",
             forms: ["dayosdesi (Future (Expected) Tense, First Dual Exclusive)"]],
            [number: 17,
             english: "Mary, will you go to Tahlequah tomorrow?",
             a: "meli, daligwas witedoli sinale iyv?",
             b: "ᎺᎵ ᏓᎵᏆᏍ ᏫᏖᏙᎵ ᏏᎾᎴ ᎢᏴ?",
             forms: []],
            [number: 18,
             english: "Mary wants to go to Germany. When she's older, may she go there!",
             a: "anitsvmani uwenvsdi uduli meli. atvsv esv'i!",
             b: "ᎠᏂᏨᎹᏂ ᎤᏪᏅᏍᏗ ᎤᏚᎵ ᎺᎵ. ᎠᏛᏒ ᎡᏒᎢ!",
             forms: ["uwenvsdi (Infinitive, Third Singular)"]],
            [number: 19,
             english: "Next year, you two boys go to Wagoner.",
             a: "sudetiyvda iyv sdita'li sdichutsa dagwalelu sdesv'i",
             b: "ᏑᏕᏘᏴᏓ ᎢᏴ ᏍᏗᏔᎵ ᏍᏗᏧᏣ ᏓᏆᎴᎷ ᏍᏕᏒᎢ",
             forms: []],
            [number: 20,
             english: "When I'm hungry, I go to the store to get something to eat.",
             a: "yagoyosi, didananv wigedoho witsigisgo gohusdi agisdi",
             b: "ᏯᎩᏲᏏ, ᏗᏓᎾᏅ ᏫᎨᏙᎰ ᏫᏥᎩᏍᎪ ᎪᎱᏍᏗ ᎠᎩᏍᏗ",
             forms: []],
            [number: 21,
             english: "On Wednesdays those kids and I always go to the movies.",
             a: "tso'ine'iga na diniyohli ale ayv nigohilv tsunadayvlatvdodi otsego'i",
             b: "ᏦᎢᏁᎢᎦ Ꮎ ᏗᏂᏲᎵ ᎠᎴ ᎠᏴ ᏂᎪᎯᎸ ᏧᎾᏓᏴᎳᏛᏙᏗ ᎣᏤᏒᎢ",
             forms: ["otsego'i (Present Habitual, First Plural Exclusive)"]],
            [number: 22,
             english: "John, since you are hungry, go to the store (right now).",
             a: "tsani, nogwu tsigi tsitsayosi didananv weda (usv didla)",
             b: "ᏣᏂ, ᏃᏊ ᏥᎩ ᏥᏣᏲᏏ ᏗᏓᎾᏅ ᏪᏓ (ᎤᏒ ᏗᏜ)",
             forms: []],
            [number: 23,
             english: "Since the girls are very hungry, may they go home and eat.",
             a: "tsiniga'a tsiduniyosi na anigehyutsa tsunenvsv wanena ale wanalisdayvhvga",
             b: "ᏥᏂᎦᎠ ᏥᏚᏂᏲᏏ Ꮎ ᎠᏂᎨᏳᏣ ᏧᏁᏅᏒ ᏩᏁᎾ ᎠᎵ ᏩᎾᎵᏍᏓᏴᎲᎦ",
             forms: ["wanena (Immediate Imperative/Volative, Third Plural Form)"]],
            [number: 24,
             english: "Just now I went to the park.",
             a: "kilagwu iyusdi wigeda tsunanelodi",
             b: "ᎩᎳᏊ ᎢᏳᏍᏗ ᏫᎨᏓ ᏧᎾᏁᎶᏗ",
             forms: []],
            [number: 25,
             english: "John, did you go to the park just now?",
             a: "tsani, kilagwus iyusdi weda tsunanelodi?",
             b: "ᏣᏂ, ᎩᎳᏊᏍ ᎢᏳᏍᏗ ᏪᏓ ᏧᎾᏁᎶᏗ?",
             forms: []],
            [number: 26,
             english: "I didn't go to the park. I went to the movies.",
             a: "hla yiwigeda tsunanelodi. tsunadayvlatvdi ugvwiyu wigeda.",
             b: "Ꮭ ᏱᏫᎨᏓ ᏧᎾᏁᎶᏗ. ᏧᎾᏓᏴᎳᏛᏗ ᎤᎬᏫᏳ ᏫᎨᏓ.",
             forms: []],
            [number: 27,
             english: "My parents want for you and I to go to the store.",
             a: "digigayvlige unaduli nihi ale ayv didananv wigedasdi",
             b: "ᏗᎩᎦᏴᎵᎨ ᎤᎾᏚᎵ ᏂᎯ ᎠᎴ ᎠᏴ ᏗᏓᎾᏅ ᏫᎨᏓᏍᏗ",
             forms: []],
            [number: 28,
             english: "I want all those boys to go home.",
             a: "agwaduli nigada na anichutsa dotsunenvsv widunenvsdi",
             b: "ᎠᏆᏚᎵ ᏂᎦᏓ Ꮎ ᎠᏂᏧᏣ ᏙᏧᏁᏅᏒ ᏫᏚᏁᏅᏍᏗ",
             forms: ["unenvsdi (Infinitive, Third Plural Form)"]],
    ]

    def "example #row.number is recorded with all three lines intact"() {
        expect: "english sentence, romanized line and syllabary line are all preserved"
        row.english && row.a && row.b

        and: "the verb forms it exercises are documented for later deconstruction"
        row.forms != null

        where: "all twenty-eight verb-book examples"
        row << EXAMPLES
    }

    def "example #row.number: syllabary and romanized lines are non-trivial"() {
        expect:
        row.a.length() > 10
        row.b.length() > 5

        where: "all twenty-eight verb-book examples"
        row << EXAMPLES
    }

    def "the example collection is complete (twenty-eight examples)"() {
        expect:
        EXAMPLES*.number == [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28]
    }
}
