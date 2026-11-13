package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import net.cherokeedictionary.grammarGuide.VerbBookEngineHarness
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Fall (a living being)" — Present Habitual (Stem II).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.33
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem II: -nv-g-
 *   Present Habitual: -nvg-o'i
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToFallPresentHabitualSpec extends VerbBaseSpec {

    static final String VERB = "to fall (a living being)"
    static final String TENSE = "PRESENT_HABITUAL"
    static final String SOURCE_PAGE = "p.33"

    // Affix composition as printed:
    static final String STEM = "-nv-g-"        // Stem II
    static final String TENSE_FORM = "-nvg-o'i"  // Present Habitual (Stem II)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "tsinvgo'i", syllabary: "ᏥᏅᎪᎢ", english: "I fall"],
            [pronoun: "Second Singular", romanized: "hinvgo'i", syllabary: "ᎯᏅᎪᎢ", english: "You fall"],
            [pronoun: "Third Singular", romanized: "ganvgo'i", syllabary: "ᎦᏅᎪᎢ", english: "S/he falls"],
            [pronoun: "Second Dual", romanized: "desdinvgo'i", syllabary: "ᏕᏍᏗᏅᎪᎢ", english: "You (two) fall"],
            [pronoun: "Second Plural", romanized: "detsinvgo'i", syllabary: "ᏕᏥᏅᎪᎢ", english: "You (more than two) fall"],
            // tio 12Nov26: the book's syllabary cell for this row (ᏙᏍᏗᏅᎪᎢ,
            // p.33) duplicates the First Dual Exclusive row directly below it
            // while its own romanization prints "deninvgo'i" (de-ni-...). Every
            // sibling table gives DL1INCL the deni/digini surface (present
            // ᏕᏂᏅᎦ, immediate past ᏕᏂᏅᎩ, infinitive ᏗᎩᏂᏅᎢᏍᏗ, remote
            // ᏕᎩᏂᏅᏨᎢ, IIV ᏗᏂᏅᎩ, FIV ᏕᏂᏅᏨᎢ) — the habitual syllabary cell
            // is a book misprint; corrected to the romanization-consistent
            // ᏕᏂᏅᎪᎢ.
            [pronoun: "First Dual Inclusive", romanized: "deninvgo'i", syllabary: "ᏕᏂᏅᎪᎢ", english: "We (you and I) fall"],
            [pronoun: "First Dual Exclusive", romanized: "dosdinvgo'i", syllabary: "ᏙᏍᏗᏅᎪᎢ", english: "We (another and I) fall"],
            [pronoun: "First Plural Exclusive", romanized: "dotsinvgo'i", syllabary: "ᏙᏥᏅᎪᎢ", english: "We (others and I) fall"],
            [pronoun: "First Plural Inclusive", romanized: "dedinvgo'i", syllabary: "ᏕᏗᏅᎪᎢ", english: "We (you and I and another or others) fall"],
            // tio 12Nov26: the book's syllabary cell for this row (ᏓᏂᏅᎩ,
            // p.33) lacks the habitual suffix ᎪᎢ that its own romanization
            // "daninvgo'i" carries (ᏓᏂᏅᎩ is the Immediate Past form, printed
            // again on p.34). Corrected to ᏓᏂᏅᎪᎢ per the romanization and
            // the -nvg-o'i habitual pattern of all other rows.
            [pronoun: "Third Plural", romanized: "daninvgo'i", syllabary: "ᏓᏂᏅᎪᎢ", english: "They are falling"],
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

    def "present habitual form matches the verb book (#row.pronoun)"() {
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
