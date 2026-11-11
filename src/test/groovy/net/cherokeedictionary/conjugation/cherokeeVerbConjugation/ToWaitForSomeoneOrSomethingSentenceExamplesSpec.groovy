package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Wait for someone or something" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.150-152
 * (printed page numbers of the full 164-page document).
 *
 * Twenty-one example sentences, each printed as:
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
class ToWaitForSomeoneOrSomethingSentenceExamplesSpec extends VerbBaseSpec {

    static final String VERB = "to wait for someone or something"
    static final String SOURCE_PAGE = "pp.150-152"

    /** All twenty-one example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "John, tell Mary that we will wait for her after the movie.",
             a: "tsani, meli hinoneselv tsosdigatiyesdi didayvladvsgi ulisgwadonvhi",
             b: "ᏣᏂ, ᎺᎵ ᎯᏃᏁᏎᎸ ᏦᏍᏗᎦᏘᏰᏍᏗ ᏗᏓᏴᎳᏛᏍᎩ ᎤᎵᏍᏆᏙᏅᎯ",
             forms: []],
            [number: 2,
             english: "Mary, if you will wait for me after the movie, I will talk to you.",
             a: "meli, yisgigatida didayvladvsgi ulisgwadonv yinalinohvli",
             b: "ᎺᎵ, ᏱᏍᎩᎦᏘᏓ ᏗᏓᏴᎳᏛᏍᎩ ᎤᎵᏍᏆᏙᏅ ᏱᎾᎵᏃᎲᎵ",
             forms: []],
            [number: 3,
             english: "John, I want for you and your brothers to wait for me after church.",
             a: "tsani, agwaduli nihi ale itsalinvdlv isgigatidisdi tsunilawisdi ulisgwadvhi",
             b: "ᏣᏂ, ᎠᏆᏚᎵ ᏂᎯ ᎠᎴ ᎢᏣᎵᏅᏢ ᎢᏍᎩᎦᏘᏗᏍᏗ ᏧᏂᎳᏫᏍᏗ ᎤᎵᏍᏆᏛᎯ",
             forms: []],
            [number: 4,
             english: "John, when you have finished eating, wait for me outside.",
             a: "tsani, halisdayvnonv sgigatidv doyi dihlv.",
             b: "ᏣᏂ, ᎭᎵᏍᏓᏴᏃᏅ ᏍᎩᎦᏘᏛ ᏙᏱ ᏗᏢ",
             forms: []],
            [number: 5,
             english: "Mary, hurry up with your shopping—I am waiting for you.",
             a: "meli, tagaya hadananesvhvsgv'i. gvgatiya.",
             b: "ᎺᎵ, ᏔᎦᏯ ᎭᏓᎾᏁᏒᎲᏍᎬᏍᎢ. ᎬᎦᏘᏯ.",
             forms: ["gvgatiya (Present Tense, First Singular)"]],
            [number: 6,
             english: "After he waited for Mary for 5 hours, he got tired and left.",
             a: "hisgi iyuliloda atsigatida meli, duyawetsv ale unigisv",
             b: "ᎯᏍᎩ ᎢᏳᎵᎶᏓ ᎠᏥᎦᏘᏓ ᎺᎵ, ᏚᏯᏪᏨ ᎠᎴ ᎤᏂᎩᏒ",
             forms: ["tsigatida (Immediate Past Tense)"]],
            [number: 7,
             english: "After he has finished his test tomorrow, I will wait for him.",
             a: "asgwadohnv atsigoliyesgv sinale, datsigatidi",
             b: "ᎠᏍᏆᏛ ᎠᏥᎪᎵᏰᏍᎬ ᏏᎾᎴ, ᏓᏥᎦᏘᏗ",
             forms: ["ᏓᏥᎦᏘᏗ (Future Tense)"]],
            [number: 8,
             english: "Anna, you and I will be here a long time. May John wait for us!",
             a: "ani, nihi ale ayv gohida inedohesdi. tsani wiginigatida.",
             b: "ᎠᏂ, ᏂᎯ ᎠᎴ ᎠᏴ ᎪᎯᏓ ᎢᏁᏙᎮᏍᏗ. ᏣᏂ ᏫᎩᏂᎦᏘᏓ.",
             forms: []],
            [number: 9,
             english: "Anna and Jane, after this test is over, I want you to wait for me.",
             a: "ana ale tseni, anisgwadv getsigoliyesgv, agwaduli sgigatidisdi",
             b: "ᎠᎾ ᎠᎴ ᏤᏂ, ᎠᏂᏍᏆᏛ ᎨᏥᎪᎵᏰᏍᎬ, ᎠᏆᏚᎵ ᏍᎩᎦᏘᏗᏍᏗ",
             forms: []],
            [number: 10,
             english: "After Mary broke up with me, I waited for her three years.",
             a: "meli tsidoginagalenvhv, tso'i tsudetiyvda tsigatidv'i",
             b: "ᎺᎵ ᏥᏙᎩᎾᎦᎴᏅᎲ, ᏦᎢ ᏧᏕᏘᏴᏓ ᏥᎦᏘᏛᎢ",
             forms: []],
            [number: 11,
             english: "I waited five hours for Jane to call me.",
             a: "agigatidv hisgi iyuliloda igohida dilinohedi nidayudodi",
             b: "ᎠᎩᎦᏘᏛ ᎯᏍᎩ ᎢᏳᎵᎶᏓ ᎢᎪᎯᏓ ᏗᎵᏃᎮᏗ ᏂᏓᏳᏙᏗ",
             forms: []],
            [number: 12,
             english: "Mary, if you want to see John, you must wait for him.",
             a: "meli, iyu yitsaduli gohiwadvdi tsani, ase higatidisdi",
             b: "ᎺᎵ, ᎢᏳ ᏱᏣᏚᎵ ᎪᎯᏩᏛᏗ ᏣᏂ, ᎠᏎ ᎯᎦᏘᏗᏍᏗ",
             forms: []],
            [number: 13,
             english: "John, tell Jerry to wait for me.",
             a: "tsani, hinohiselv Jerry agigatidisdi'i",
             b: "ᏣᏂ, ᎯᏃᎯᏎᎸ Jerry ᎠᏗᎦᏘᏗᏍᏗᎢ",
             forms: ["agigatidisdi (Infinitive)"]],
            [number: 14,
             english: "You two boys must wait for your dad so you can thank him.",
             a: "nihi sditali sditsutsa ase esdigatidisdi sdidoda esdalielitsediyi",
             b: "ᏂᎯ ᏍᏗᏔᎵ ᏍᏗᏧᏣ ᎠᏎ ᎡᏍᏗᎦᏘᏗᏍᏗ ᏍᏗᏙᏓ ᎡᏍᏓᎵᎡᎵᏤᏗᏱ",
             forms: []],
            [number: 15,
             english: "Joe, you and your two brothers wait for the girls so you can talk to them.",
             a: "tsowi, nihi ale anitali itsalinvhlv detsigatiyesdi na anigeyutsa eligwu yidotsalinohvli",
             b: "ᏦᏫ, ᏂᎯ ᎠᎴ ᎠᏂᏔᎵ ᎢᏣᎵᏅᏢ ᏕᏥᎦᏘᏰᏍᏗ Ꮎ ᎠᏂᎨᏳᏣ ᎡᎵᏊ ᏱᏙᏣᎵᏃᎲᎵ",
             forms: []],
            [number: 16,
             english: "John, Mary, and I waited all day for John in Tulsa.",
             a: "tsani, meli ayvno otsigatidv tsani udodagwada Tulsi",
             b: "ᏣᏂ, ᎺᎵ ᎠᏴᏃ ᎣᏥᎦᏘᏛ ᏣᏂ ᎤᏙᏓᏆᏛ Tulsi",
             forms: []],
            [number: 17,
             english: "When those three boys were in Tahlequah, they waited all day to see Mary.",
             a: "na tso'i iyani'i anitsutsa daligwa tsanedohv, unigatidv udodagwada unigowadvdi meli",
             b: "Ꮎ ᏦᎢ ᎢᏯᏂᎢ ᎠᏂᏧᏣ ᏓᎵᏆ ᏣᏁᏙᎲ, ᎤᏂᎦᏘᏛ ᎤᏙᏓᏆᏓ ᎤᏂᎪᏩᏛᏗ ᎺᎵ",
             forms: []],
            [number: 18,
             english: "I waited three hours for John. Now let him wait for me!",
             a: "tso'i iyuliloda tsigatidv tsani. ka nogwu uwasa wagigatida!",
             b: "ᏦᎢ ᎢᏳᎵᎶᏓ ᏥᎦᏘᏛ ᏣᏂ. Ꭷ ᏃᏊ ᎤᏩᏌ ᏩᎩᎦᏘᏓ!",
             forms: []],
            [number: 19,
             english: "John, wait for me so we can show the new car to your sister.",
             a: "tsani, sgigatidv'i nasgino yenigowatvda etsado na itse dagwalelu",
             b: "ᏣᏂ, ᏍᎩᎦᏘᏛᎢ ᎾᏍᎩᏃ ᏰᏂᎪᏩᏛᏓ ᎡᏣᏙ Ꮎ ᎢᏤ ᏓᏆᎴᎷ",
             forms: []],
            [number: 20,
             english: "John, wait till the movie is over!",
             a: "tsani, higatida adayvladvsgi alisgwadv igohida!",
             b: "ᏣᏂ, ᎯᎦᏘᏓ ᎠᏓᏴᎳᏛᏍᎩ ᎠᎵᏍᏆᏛ ᎢᎪᎯᏓ!",
             forms: ["higatida (Immediate Imperative/Volative)"]],
            [number: 21,
             english: "I hope John and Mary will wait for those two girls.",
             a: "udugi agwvha tsani ale meli dodvnigatidi na anitali anigeyutsa",
             b: "ᎤᏚᎩ ᎠᏋᎭ ᏣᏂ ᎠᎴ ᎺᎵ ᏙᏛᏂᎦᏘᏗ Ꮎ ᎠᏂᏔᎵ ᎠᏂᎨᏳᏣ",
             forms: []],
    ]

    def "example #row.number is recorded with all three lines intact"() {
        expect: "english sentence, romanized line and syllabary line are all preserved"
        row.english && row.a && row.b

        and: "the verb forms it exercises are documented for later deconstruction"
        row.forms != null

        where: "all twenty-one verb-book examples"
        row << EXAMPLES
    }

    def "example #row.number: syllabary and romanized lines are non-trivial"() {
        expect:
        row.a.length() > 10
        row.b.length() > 5

        where: "all twenty-one verb-book examples"
        row << EXAMPLES
    }

    def "the example collection is complete (twenty-one examples)"() {
        expect:
        EXAMPLES*.number == [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21]
    }
}
