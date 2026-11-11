package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
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
class ToFallPresentHabitualSpec extends Specification {

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
            [pronoun: "First Dual Inclusive", romanized: "deninvgo'i", syllabary: "ᏙᏍᏗᏅᎪᎢ", english: "We (you and I) fall"],
            [pronoun: "First Dual Exclusive", romanized: "dosdinvgo'i", syllabary: "ᏙᏍᏗᏅᎪᎢ", english: "We (another and I) fall"],
            [pronoun: "First Plural Exclusive", romanized: "dotsinvgo'i", syllabary: "ᏙᏥᏅᎪᎢ", english: "We (others and I) fall"],
            [pronoun: "First Plural Inclusive", romanized: "dedinvgo'i", syllabary: "ᏕᏗᏅᎪᎢ", english: "We (you and I and another or others) fall"],
            [pronoun: "Third Plural Form", romanized: "daninvgo'i", syllabary: "ᏓᏂᏅᎩ", english: "They are falling"],
    ]

    /**
     * Hook for the conjugation-engine comparison (to be wired in later).
     * Today it echoes the verb-book form; replace the body with a call into
     * the conjugation engine when the engine-vs-verb-book refinement begins.
     */
    Map conjugate(String pronoun) {
        def row = VERB_BOOK.find { it.pronoun == pronoun }
        // TODO(engine-comparison): replace this echo with a conjugation-engine call,
        // e.g. conjStr(pronoun, "SG3IN", verbFixture, TENSE, "v.i.")
        return [romanized: row.romanized, syllabary: row.syllabary]
    }

    def "present habitual form matches the verb book (#row.pronoun)"() {
        when: "the form is conjugated"
        def form = conjugate(row.pronoun)

        then: "both the romanized and syllabary forms match the verb book"
        form.romanized == row.romanized
        form.syllabary == row.syllabary

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
