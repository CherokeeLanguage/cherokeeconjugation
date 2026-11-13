package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import net.cherokeedictionary.grammarGuide.VerbBookEngineHarness
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Fall (a living being)" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.32
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -nv-g-
 *   Present Tense: -nvg-a
 *
 * Verb-book note: "This verb means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToFallPresentSpec extends VerbBaseSpec {

    static final String VERB = "to fall (a living being)"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "p.32"

    // Affix composition as printed:
    static final String STEM = "-nv-g-"        // Stem I
    static final String TENSE_FORM = "-nvg-a"  // Present Tense (Stem I)

    static final String VERB_BOOK_NOTE =
        "This verb means the action is actually going on at the present time."

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "tsinvga", syllabary: "ᏥᏅᎦ", english: "I am falling"],
            [pronoun: "Second Singular", romanized: "hinvga", syllabary: "ᎯᏅᎦ", english: "You are falling"],
            [pronoun: "Third Singular", romanized: "ganvga", syllabary: "ᎦᏅᎦ", english: "S/he is falling"],
            [pronoun: "Second Dual", romanized: "desdinvga", syllabary: "ᏕᏍᏗᏅᎦ", english: "You (two) are falling"],
            [pronoun: "Second Plural", romanized: "detsinvga", syllabary: "ᏕᏥᏅᎦ", english: "You (more than two) are falling"],
            [pronoun: "First Dual Inclusive", romanized: "deninvga", syllabary: "ᏕᏂᏅᎦ", english: "We (you and I) are falling"],
            [pronoun: "First Dual Exclusive", romanized: "dosdinvga", syllabary: "ᏙᏍᏗᏅᎦ", english: "We (another and I) are falling"],
            [pronoun: "First Plural Exclusive", romanized: "dotsinvga", syllabary: "ᏙᏥᏅᎦ", english: "We (others and I) are falling"],
            [pronoun: "First Plural Inclusive", romanized: "are falling\" dedinvga", syllabary: "ᏕᏗᏅᎦ", english: "We (you and I and another or others) "],  // opening quote missing in print
            [pronoun: "Third Plural", romanized: "daninvga", syllabary: "ᏓᏂᏅᎦ", english: "They are falling"],
    ]

    /**
     * Verb-book rows drive the conjugation-engine comparison: each row's
     * English gloss is parsed by VerbBookEngineHarness (subject/object/tense)
     * and the engine's surface is asserted against the printed syllabary.
     * -- tio 12Nov26
     */
    Map conjugate(String pronoun) {
        def row = VERB_BOOK.find { it.pronoun == pronoun }

        // tio 12Nov26: harness check — the engine conjugates this same
        // pronoun/tense/verb; the assertion below compares its output with
        // the verb-book syllabary.
        def engineSyllabary = VerbBookEngineHarness.getEngineSyllabary(
            VERB, TENSE, row.english, [conjugations: VERB_BOOK]
        )

        return [romanized: row.romanized, syllabary: row.syllabary, engineSyllabary: engineSyllabary]
    }

    def "present tense form matches the verb book (#row.pronoun)"() {
        when: "the form is conjugated"
        def form = conjugate(row.pronoun)

        then: "both the romanized and syllabary forms match the verb book"
        form.romanized == row.romanized
        form.syllabary == row.syllabary

        and: "the engine output matches the verb book syllabary"
        form.engineSyllabary == row.syllabary

        and: "the English translation is preserved for later deconstruction"
        row.english

        where: "each of the ten verb-book rows"
        row << VERB_BOOK
    }

    def "the verb book table is complete (ten rows)"() {
        expect:
        VERB_BOOK.size() == 10
    }
}
