package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Talk to Someone" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.130-131
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
class ToTalkToSomeoneSentenceExamplesSpec extends Specification {

    static final String VERB = "to talk to someone"
    static final String SOURCE_PAGE = "pp.130-131"

    /** All sixteen example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "When he/she finishes telling the story, we will talk to him about it.",
             a: "Nogwu yasgwada kanohetlvsgv, dayedalinohetahni iyusdi unohetlvhnv'i",
             b: "ᏃᏊ ᏯᏍᏆᏓ ᎧᏃᎮᏢᏍᎬ, ᏓᏰᏓᎵᏃᎮᏔᏂ ᎢᏳᏍᏗ ᎤᏃᎮᏢᏅᎢ",
             forms: []],
            [number: 2,
             english: "You are talking to Mary about her new car.",
             a: "meli itse dagwalelu utselii hilinohedi nusdidanv'i",
             b: "ᎺᎵ ᎢᏤ ᏓᏆᎴᎷ ᎤᏤᎵᎢ ᎯᎵᏃᎮᏗ ᏄᏍᏗᏓᏅᎢ",
             forms: []],
            [number: 3,
             english: "John, next year you will talk to Mary about where to go on vacation.",
             a: "tsani, so'i wadetiyvhv Meli hilinohetanv'i uhna sdenvsdi to(hi) nisdadvhnv sdedolidohv'i.",
             b: "ᏣᏂ, ᏐᎢ ᏩᏕᏘᏴᎲ ᎺᎵ ᎯᎵᏃᎮᏔᏅᎢ ᎤᎿ ᏍᏕᏅᏍᏗ ᏙᎯ ᏂᏍᏓᏛᏅ ᏍᏕᏙᎵᏙᎲᎢ.",
             forms: ["hilinohetanv'i (Future Imperative/Volative)"]],
            [number: 4,
             english: "John, you talk to Mary (right now) about where we will eat tomorrow.",
             a: "tsani, meli hilinoheda nogwu uhna dadal(i)sdayvnisv sanale tsigesesdi",
             b: "ᏣᏂ, ᎺᎵ ᎯᎵᏃᎮᏓ ᏃᏊ ᎤᎿ ᏓᏓᎵᏍᏓᏴᏂᏒ ᏍᏌᎾᎴ ᏥᎨᏎᏍᏗ.",
             forms: ["ᎯᎵᏃᎮᏓ (Immediate Imperative/Volative)"]],
            [number: 5,
             english: "Tomorrow I will talk to Mary about the car.",
             a: "sanale tsilinohetanv meli dagwalelu ugvwatli",
             b: "ᏍᏌᎾᎴ ᏥᎵᏃᎮᏔᏅ ᎺᎵ ᏓᏆᎴᎷ ᎤᎬᏩᎵ",
             forms: []],
            [number: 6,
             english: "John, if you want for us three to go to California next year, you must talk to Mary about it.",
             a: "tsani, yitsaduli tso'i yidi'idv igenvsdi adela dalonige dihv so'i wadetiyvhv'i, ase sdahlinohedi gesesdi Meli.",
             b: "ᏣᏂ, ᏱᏣᏚᎵ ᏦᎢ ᏱᏗᎢᏛ ᎢᎨᏅᏍᏗ ᎠᏕᎳ ᏓᎶᏂᎨ ᏗᎲ ᏐᎢ ᏩᏕᏘᏴᎲᎢ ᎠᏎ ᏍᏓᏟᏃᎮᏗ ᎨᏎᏍᏗᎺᎵ.",
             forms: []],
            [number: 7,
             english: "John, Mary and I want for you to talk to Charley about the new car.",
             a: "tsani, meli ale ayv oginaduli hilinohedodi tsali itse dagwalelu ugvwali",
             b: "ᏣᏂ, ᎺᎵ ᎠᎴ ᎠᏴ ᎣᎩᎾᏚᎵ ᎯᎵᏃᎮᏙᏗ ᏣᎵ ᎢᏤ ᏓᏆᎴᎷ ᎤᎬᏩᎵ.",
             forms: []],
            [number: 8,
             english: "Just now I talked with my two brothers about the weather forecast for tomorrow.",
             a: "Nogwu tsigesv degatsilinoheda anita'li tsotsadahnvtli doyiditlv nidigal(i)stanisv sanale'i.",
             b: "ᏃᏊ ᏥᎨᏒ ᏕᎦᏥᎵᏃᎮᏓ ᎠᏂᏔᎵ ᏦᏣᏓᏅᏟ ᏙᏱᏗᏢ ᏂᏗᎦᎵᏍᏔᏂᏒ ᏍᏌᎾᎴᎢ.",
             forms: ["tsilinoheda (Immediate Past Tense)"]],
            [number: 9,
             english: "Tomorrow I will talk to John about buying a new car.",
             a: "sanale datsiyalinohetani tsani uhwahisdi atse dagwalelu ugvwahli",
             b: "ᏍᏌᎾᎴ ᏗᏥᏯᎵᏃᎮᏔᏂ ᏣᏂ ᎤᏩᎯᏍᏗ ᎠᏤ ᏓᏆᎴᎷ ᎤᎬᏩᎵ",
             forms: []],
            [number: 10,
             english: "My sisters talk all the time.",
             a: "tsvgido nigohilv anahlinohesgo'i.",
             b: "ᏨᎩᏙ ᏂᎪᎯᎸ ᎠᎾᎵᏃᎮᏍᎪᎢ.",
             forms: []],
            [number: 11,
             english: "Let's all three of us talk about what we will do tomorrow.",
             a: "nigada tso'i yidi'i idinohvli iyusdi nididadvnelisv sanale'i",
             b: "ᏂᎦᏓ ᏦᎢ ᏱᏗᎢ ᎢᏗᏃᎲᎵ ᎢᏳᏍᏗ ᏂᏗᏓᏛᏁᎵᏒ ᏍᏌᎾᎴᎢ.",
             forms: []],
            [number: 12,
             english: "Mary, talk to me tomorrow!",
             a: "meli, sgwahlinohetanv sanale'iyv'i",
             b: "ᎺᎵ, ᏍᏆᎵᏃᎮᏔᏅ ᏍᏌᎾᎴ ᎢᏴᎢ",
             forms: []],
            [number: 13,
             english: "The three boys want me to talk with them about their car.",
             a: "na tso'i iyani'i anichutsa unaduliha gatsiyalinohedodi dagwalelu unatseli ugvwahli",
             b: "Ꮎ ᏦᎢ ᎢᏯᏂᎢ ᎠᏂᏧᏣ ᎤᎾᏚᎵᎭ ᎦᏥᏯᎵᏃᎮᏙᏗ ᏓᏆᎴᎷ ᎤᎾᏤᎵ ᎤᎬᏩᎵ.",
             forms: ["ᏥᏯᎵᏃᎮᏙᏗ (Infinitive)"]],
            [number: 14,
             english: "John is very quiet. Let him talk!",
             a: "tsani udohiyu ehlawe'i. wigawonihi!",
             b: "ᏣᏂ ᎤᏙᎯᏳ ᎡᎳᏪᎢ. ᏫᎦᏬᏂᎯ!",
             forms: []],
            [number: 15,
             english: "Wait for me tomorrow and we will talk about your plans!",
             a: "sgiktiyesdi sanale ale yinahlinohvli iyusdi detsukdv yitsadvn(e)di'i",
             b: "ᏍᎩᎦᏘᏰᏍᏗ ᏍᏌᎾᎴ ᎠᎴ ᏱᎾᏟᏃᎲᎵ ᎢᏳᏍᏗ ᏕᏧᎪᏛ ᏱᏣᏛᏁᏗᎢ",
             forms: []],
            [number: 16,
             english: "I want my son to talk to me.",
             a: "agwetsi achutsa agwahlinohedodi'i agwaduli",
             b: "ᎠᏇᏥ ᎠᏧᏣ ᎠᏆᎵᏃᎮᏙᏗᎢ ᎠᏆᏚᎵ",
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
