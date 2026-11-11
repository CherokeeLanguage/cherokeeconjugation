package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Flexible" — Infinitive (Stem V).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.54
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem V: -nv-Ø-
 *   Infinitive: -nv-di
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingFlexibleInfinitiveSpec extends VerbBaseSpec {

    static final String VERB = "to have something flexible"
    static final String TENSE = "INFINITIVE"
    static final String SOURCE_PAGE = "p.54"

    // Affix composition as printed:
    static final String STEM = "-nv-Ø-"        // Stem V
    static final String TENSE_FORM = "-nv-di"  // Infinitive (Stem V)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "aginvdi/diginvdi", syllabary: "ᎠᎩᏅᏗ/ᏗᎩᏅᏗ", english: "For me to have something flexible (singular)\"/\"For me to have multiple flexible things\""],
            [pronoun: "Second Singular", romanized: "tsanvdi/ditsanvdi", syllabary: "ᏣᏅᏗ/ᏗᏣᏅᏗ", english: "For you to have something flexible (singular)\"/\"For you to have multiple flexible things\""],
            [pronoun: "Third Singular", romanized: "unvdi/tsunvdi", syllabary: "ᎤᏅᏗ/ᏧᏅᏗ", english: "For him/her/it to have something flexible (singular)\"/\"For him/her/it to have multiple flexible things\""],
            [pronoun: "Second Dual", romanized: "sdinvdi/disdinvdi", syllabary: "ᏍᏗᏅᏗ/ᏗᏍᏗᏅᏗ", english: "For you (two) to have something flexible (singular)\"/\"For you (two) to have multiple flexible things\""],
            [pronoun: "Second Plural", romanized: "itsinvdi/ditsinvdi", syllabary: "ᎢᏥᏅᏗ/ᏗᏥᏅᏗ", english: "For you (more than two) to have something flexible (singular)\"/\"For you (more than two) to have multiple flexible things\""],
            [pronoun: "First Dual Inclusive", romanized: "gininvdi/digininvdi", syllabary: "ᎩᏂᏅᏗ/ᏗᎩᏂᏅᏗ", english: "For us (you and I) to have something flexible (singular)\"/\"For us (you and I) to have multiple flexible things\""],
            [pronoun: "First Dual Exclusive", romanized: "ogininvdi/tsogininvdi", syllabary: "ᎣᎩᏂᏅᏗ/ᏦᎩᏂᏅᏗ", english: "For us (another and I) to have something flexible (singular)\"/\"For us (another and I) to have multiple flexible things\""],
            [pronoun: "First Plural Exclusive", romanized: "oginvdi/tsoginvdi", syllabary: "ᎣᎩᏅᏗ/ᏦᎩᏅᏗ", english: "For us (others and I) to have something flexible (singular)\"/\"For us (others and I) to have multiple flexible things\""],
            [pronoun: "First Plural Inclusive", romanized: "iginvdi/diginvdi", syllabary: "ᎢᎩᏅᏗ/ᏗᎩᏅᏗ", english: "For us (you and I and another or others) to have something flexible (singular)\"/\"For us (you and I and another or others) to have multiple flexible things\""],
            [pronoun: "Third Plural", romanized: "uninvdi/tsuninvdi", syllabary: "ᎤᏂᏅᏗ/ᏧᏂᏅᏗ", english: "For them to have something flexible (singular)\"/\"For them to have multiple flexible things\""],
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

    def "infinitive form matches the verb book (#row.pronoun)"() {
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
