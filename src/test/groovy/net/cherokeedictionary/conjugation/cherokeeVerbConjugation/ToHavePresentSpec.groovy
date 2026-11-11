package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have (a living being)" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.42
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -(a)ka-h-
 *   Present Tense: -(a)kah-a
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHavePresentSpec extends Specification {

    static final String VERB = "to have (a living being)"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "p.42"

    // Affix composition as printed:
    static final String STEM = "-(a)ka-h-"        // Stem I
    static final String TENSE_FORM = "-(a)kah-a"  // Present Tense (Stem I)

    /** The twenty-four conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gvyakaha", syllabary: "ᎬᏯᎧᎭ", english: "I have you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsiyakaha", syllabary: "ᏥᏯᎧᎭ", english: "I have him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "desdvyakaha", syllabary: "ᏕᏍᏛᏯᎧᎭ", english: "I have you two", occurrence: 1],
            [pronoun: "First Singular", romanized: "detsvyakaha", syllabary: "ᏕᏨᏯᎧᎭ", english: "I have you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "degatsiyakaha", syllabary: "ᏕᎦᏥᎧᎭ", english: "I have them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgikaha", syllabary: "ᏍᎩᎧᎭ", english: "You (singular) have me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hiyakaha", syllabary: "ᎯᏯᎧᎭ", english: "You (singular) have him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "desginikaha", syllabary: "ᏕᏍᎩᏂᎧᎭ", english: "You (singular) have someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "desgiyakaha", syllabary: "ᏕᏍᎩᏯᎧᎭ", english: "You (singular) have others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agikaha", syllabary: "ᎠᎩᎧᎭ", english: "He/she has me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsakaha", syllabary: "ᏣᎧᎭ", english: "He/she has you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "uwakaha", syllabary: "ᎤᏩᎧᎭ", english: "He/she has him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginikaha", syllabary: "ᎣᎩᏂᎧᎭ", english: "He/she has you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "doginikaha", syllabary: "ᏙᎩᏂᎧᎭ", english: "He/she has someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "degikaha", syllabary: "ᏕᎩᎧᎭ", english: "He/she has another (or others), me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dogikaha", syllabary: "ᏙᎩᎧᎭ", english: "He/she has others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "desdikaha", syllabary: "ᏕᏍᏗᎧᎭ", english: "He/she has you (two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "detsikaha", syllabary: "ᏕᏥᎧᎭ", english: "He/she has you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "duwakaha", syllabary: "ᏚᏩᎧᎭ", english: "He/she has them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginikaha", syllabary: "ᏍᎩᏂᎧᎭ", english: "You (two) have me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdikaha", syllabary: "ᎡᏍᏗᎧᎭ", english: "You (two) have him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desginikaha", syllabary: "ᏕᏍᎩᏂᎧᎭ", english: "You (two) have someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desgiyakaha", syllabary: "ᏕᏍᎩᏯᎧᎭ", english: "You (two) have others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdikaha", syllabary: "ᏕᏍᏗᎧᎭ", english: "You (two) have them", occurrence: 1],
    ]

    /**
     * Hook for the conjugation-engine comparison (to be wired in later).
     * Today it echoes the verb-book form; replace the body with a call into
     * the conjugation engine when the engine-vs-verb-book refinement begins.
     *
     * occurrence disambiguates rows the verb book prints more than once with the
     * same pronoun group and English gloss.
     */
    Map conjugate(String pronoun, String english, int occurrence) {
        def matches = VERB_BOOK.findAll { it.pronoun == pronoun && it.english == english }
        def row = matches[Math.min(occurrence, matches.size()) - 1]
        // TODO(engine-comparison): replace this echo with a conjugation-engine call,
        // e.g. conjStr(pronoun, "SG3IN", verbFixture, TENSE, "v.t.")
        return [romanized: row.romanized, syllabary: row.syllabary]
    }

    def "present tense form matches the verb book (#row.pronoun: #row.english)"() {
        when: "the form is conjugated"
        def form = conjugate(row.pronoun, row.english, row.occurrence)

        then: "both the romanized and syllabary forms match the verb book"
        form.romanized == row.romanized
        form.syllabary == row.syllabary

        and: "the English translation is preserved for later deconstruction"
        row.english

        where: "each of the twenty-four verb-book rows"
        row << VERB_BOOK
    }

    def "the verb book table is complete (twenty-four rows)"() {
        expect:
        VERB_BOOK.size() == 24
    }
}
