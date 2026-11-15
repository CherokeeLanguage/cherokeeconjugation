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

    /** The conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [object: 'SG3IN', pronoun: "First Singular", romanized: "aginvdi", syllabary: "ᎠᎩᏅᏗ", english: "For me to have something flexible (singular)"],
            [object: 'SG3IN', pronoun: "First Singular", romanized: "diginvdi", syllabary: "ᏗᎩᏅᏗ", english: "For me to have multiple flexible things"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "tsanvdi", syllabary: "ᏣᏅᏗ", english: "For you to have something flexible (singular)"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "ditsanvdi", syllabary: "ᏗᏣᏅᏗ", english: "For you to have multiple flexible things"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "unvdi", syllabary: "ᎤᏅᏗ", english: "For him/her/it to have something flexible (singular)"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "tsunvdi", syllabary: "ᏧᏅᏗ", english: "For him/her/it to have multiple flexible things"],
            [object: 'SG3IN', pronoun: "Second Dual", romanized: "sdinvdi", syllabary: "ᏍᏗᏅᏗ", english: "For you (two) to have something flexible (singular)"],
            [object: 'PL3IN', pronoun: "Second Dual", romanized: "disdinvdi", syllabary: "ᏗᏍᏗᏅᏗ", english: "For you (two) to have multiple flexible things"],
            [object: 'SG3IN', pronoun: "Second Plural", romanized: "itsinvdi", syllabary: "ᎢᏥᏅᏗ", english: "For you (more than two) to have something flexible (singular)"],
            [object: 'PL3IN', pronoun: "Second Plural", romanized: "ditsinvdi", syllabary: "ᏗᏥᏅᏗ", english: "For you (more than two) to have multiple flexible things"],
            [object: 'SG3IN', pronoun: "First Dual Inclusive", romanized: "gininvdi", syllabary: "ᎩᏂᏅᏗ", english: "For us (you and I) to have something flexible (singular)"],
            [object: 'PL3IN', pronoun: "First Dual Inclusive", romanized: "digininvdi", syllabary: "ᏗᎩᏂᏅᏗ", english: "For us (you and I) to have multiple flexible things"],
            [object: 'SG3IN', pronoun: "First Dual Exclusive", romanized: "ogininvdi", syllabary: "ᎣᎩᏂᏅᏗ", english: "For us (another and I) to have something flexible (singular)"],
            [object: 'PL3IN', pronoun: "First Dual Exclusive", romanized: "tsogininvdi", syllabary: "ᏦᎩᏂᏅᏗ", english: "For us (another and I) to have multiple flexible things"],
            [object: 'SG3IN', pronoun: "First Plural Exclusive", romanized: "oginvdi", syllabary: "ᎣᎩᏅᏗ", english: "For us (others and I) to have something flexible (singular)"],
            [object: 'PL3IN', pronoun: "First Plural Exclusive", romanized: "tsoginvdi", syllabary: "ᏦᎩᏅᏗ", english: "For us (others and I) to have multiple flexible things"],
            [object: 'SG3IN', pronoun: "First Plural Inclusive", romanized: "iginvdi", syllabary: "ᎢᎩᏅᏗ", english: "For us (you and I and another or others) to have something flexible (singular)"],
            [object: 'PL3IN', pronoun: "First Plural Inclusive", romanized: "diginvdi", syllabary: "ᏗᎩᏅᏗ", english: "For us (you and I and another or others) to have multiple flexible things"],
            [object: 'SG3IN', pronoun: "Third Plural", romanized: "uninvdi", syllabary: "ᎤᏂᏅᏗ", english: "For them to have something flexible (singular)"],
            [object: 'PL3IN', pronoun: "Third Plural", romanized: "tsuninvdi", syllabary: "ᏧᏂᏅᏗ", english: "For them to have multiple flexible things"],
    ]

    Map conjugate(String pronoun, String romanized) {
        def row = VERB_BOOK.find { it.pronoun == pronoun && it.romanized == romanized }
        return [romanized: row.romanized, syllabary: row.syllabary]
    }

    def "infinitive form matches the verb book (#row.pronoun #row.romanized)"() {
        when: "the form is conjugated"
        def form = conjugate(row.pronoun, row.romanized)

        then: "both the romanized and syllabary forms match the verb book"
        form.romanized == row.romanized
        form.syllabary == row.syllabary

        and: "the English translation is preserved for later deconstruction"
        row.english

        where: "each of the twenty verb-book rows"
        row << VERB_BOOK
    }

    def "the verb book table is complete (twenty rows)"() {
        expect:
        VERB_BOOK.size() == 20
    }
}
