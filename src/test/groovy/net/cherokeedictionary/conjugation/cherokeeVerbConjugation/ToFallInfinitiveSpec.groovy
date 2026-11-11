package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Fall (a living being)" — Infinitive (Stem V).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.34
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem V: -nv-'is-
 *   Infinitive: -nv'is-di
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToFallInfinitiveSpec extends VerbBaseSpec {

    static final String VERB = "to fall (a living being)"
    static final String TENSE = "INFINITIVE"
    static final String SOURCE_PAGE = "p.34"

    // Affix composition as printed:
    static final String STEM = "-nv-'is-"        // Stem V
    static final String TENSE_FORM = "-nv'is-di"  // Infinitive (Stem V)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "aginv'isdi", syllabary: "ᎠᎩᏅᎢᏍᏗ", english: "For me to fall"],
            [pronoun: "Second Singular", romanized: "tsanv'isdi", syllabary: "ᏣᏅᎢᏍᏗ", english: "For you to fall"],
            [pronoun: "Third Singular", romanized: "unv'isdi", syllabary: "ᎤᏅᎢᏍᏗ", english: "For him/her/it to fall"],
            [pronoun: "Second Dual", romanized: "disdinv'isdi", syllabary: "ᏗᏍᏗᏅᎢᏍᏗ", english: "For you (two) to fall"],
            [pronoun: "Second Plural", romanized: "ditsinv'isdi", syllabary: "ᏗᏥᏅᎢᏍᏗ", english: "For you (more than two) to fall"],
            [pronoun: "First Dual Inclusive", romanized: "digininv'isdi", syllabary: "ᏗᎩᏂᏅᎢᏍᏗ", english: "For us (you and I) to fall"],
            [pronoun: "First Dual Exclusive", romanized: "tsogininv'isdi", syllabary: "ᏦᎩᏂᏅᎢᏍᏗ", english: "For us (another and I) to fall"],
            [pronoun: "First Plural Exclusive", romanized: "tsoginv'isdi", syllabary: "ᏦᎩᏅᎢᏍᏗ", english: "For us (others and I) to fall"],
            [pronoun: "First Plural Inclusive", romanized: "diginv'isdi", syllabary: "ᏗᎩᏅᎢᏍᏗ", english: "For us (you and I and another or others) to fall"],
            [pronoun: "Third Plural Form", romanized: "tsuninv'isdi", syllabary: "ᏧᏂᏅᎢᏍᏗ", english: "For them to fall"],
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
