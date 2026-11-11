package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Stop someone or something" — EXAMPLES.
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.125-126
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
class ToStopSomeoneOrSomethingSentenceExamplesSpec extends VerbBaseSpec {

    static final String VERB = "to stop someone or something"
    static final String SOURCE_PAGE = "pp.125-126"

    /** All ten example sentences exactly as printed in the verb book. */
    static final List<Map> EXAMPLES = [
            [number: 1,
             english: "Mary, stop the car right now!",
             a: "meli, halewisdoda dagwalelu!",
             b: "ᎺᎵ, ᎭᎴᏫᏍᏙᏓ ᏓᏆᎴᎷ!",
             forms: ["ᎭᎴᏫᏍᏙᏓ (Immediate Imperative/Volative)"]],
            [number: 2,
             english: "Charley, if I am driving too fast, I want you to stop me.",
             a: "tsali, iyuhno ayanuli otsi'ili, agwaduli sgwalewisdodi",
             b: "ᏣᎵ, ᎢᏳᏃ ᎠᏯᏄᎵ ᎣᏥᎢᎵ, ᎠᏆᏚᎵ ᏍᏆᎴᏫᏍᏙᏗ",
             forms: []],
            [number: 3,
             english: "Mary, if you start to get tired in the race tomorrow, stop and rest!",
             a: "meli, iyuhno yaleniha detsayawegv hadogiyasgv sinale, halewitanv ale hatsawesolvstanv'i",
             b: "ᎺᎵ, ᎢᏳᏃ ᏯᎴᏂᎭ ᏕᏣᏯᏪᎬ ᎭᏙᎩᏲᏍᎬ ᏏᎾᎴ, ᎭᎴᏫᏔᏅ ᎠᎴ ᎭᏣᏪᏐᎸᏍᏔᏅᎢ",
             forms: []],
            [number: 4,
             english: "\"Stop\" on a stop sign.",
             a: "\"halewisda\" adisgi gohweli",
             b: "\"ᎭᎴᏫᏍᏓ\" ᎠᏗᏍᎩ ᎪᏪᎵ",
             forms: []],
            [number: 5,
             english: "Those three boys need to stop smoking.",
             a: "na tso'i iyani anitsutsa unisuligo'isdi danogisgv'i",
             b: "Ꮎ ᏦᎢ ᎢᏯᏂ ᎠᏂᏧᏣ ᎤᏂᏑᎵᏍᎪᎢᏍᏗ ᏓᏃᎩᏍᎬᎢ",
             forms: []],
            [number: 6,
             english: "John, stop right now and rest awhile!",
             a: "tsani, halewisda ale hatsawesolvsda!",
             b: "ᏣᏂ, ᎭᎴᏫᏍᏓ ᎠᎴ ᎭᏣᏪᏐᎸᏍᏓ!",
             forms: []],
            [number: 7,
             english: "That car is stopping at the stop sign.",
             a: "na dagwalelu alewisda \"halewisda\" adisgi digohwelv'i",
             b: "Ꮎ ᏓᏆᎴᎷ ᎠᎴᏫᏍᏓ \"ᎭᎴᏫᏍᏓ\" ᎠᏗᏍᎩ ᏗᎪᏪᎸᎵ",
             forms: []],
            [number: 8,
             english: "He's talking too much. May he stop!",
             a: "iyuhno tsugwisdi ogawoni, walewisda (gawonisgv'i)!",
             b: "ᎢᏳᏃ ᏧᏈᏍᏗ ᎣᎦᏬᏂ, ᏩᎴᏫᏍᏓ (ᎦᏬᏂᏍᎬᎢ)!",
             forms: []],
            [number: 9,
             english: "All those kids should stop and rest awhile.",
             a: "na nigada diniyoli unalewisdodi ale tlega unatsawesolvsdodi",
             b: "Ꮎ ᏂᎦᏓ ᏗᏂᏲᎵ ᎤᎾᎴᏫᏍᏙᏗ ᎠᎴ ᏞᎦ ᎤᎾᏣᏪᏐᎸᏍᏙᏗ",
             forms: []],
            [number: 10,
             english: "I want all you boys to stop.",
             a: "tla yagwaduli nigada itsitsutsa itsisuligo'isdi",
             b: "Ꮭ ᏯᏆᏚᎵ ᏂᎯᏓ ᎢᏥᏧᏣ ᎢᏥᏑᎵᎪᎢᏍᏗ",
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
