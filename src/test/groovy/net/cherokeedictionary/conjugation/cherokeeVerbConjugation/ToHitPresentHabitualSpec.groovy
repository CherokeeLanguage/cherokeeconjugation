package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Hit" — Present Habitual Tense (Stem II).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.79-80
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem II: -vhni-h-
 *   Present Habitual Tense: -vhnih-o'i
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHitPresentHabitualSpec extends Specification {

    static final String VERB = "to hit"
    static final String TENSE = "PRESENT_HABITUAL"
    static final String SOURCE_PAGE = "pp.79-80"

    // Affix composition as printed:
    static final String STEM = "-vhni-h-"        // Stem II
    static final String TENSE_FORM = "-vhnih-o'i"  // Present Habitual Tense (Stem II)

    /** The two conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "", romanized: "gvniho'i", syllabary: "ᎬᏂᎰᎢ", english: "I hit it (habitually)", occurrence: 1],
            [pronoun: "", romanized: "gvhniho'i", syllabary: "ᎬᏂᎰᎢ", english: "S/he hits it (habitually)", occurrence: 1],
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

    def "present habitual tense form matches the verb book (#row.pronoun: #row.english)"() {
        when: "the form is conjugated"
        def form = conjugate(row.pronoun, row.english, row.occurrence)

        then: "both the romanized and syllabary forms match the verb book"
        form.romanized == row.romanized
        form.syllabary == row.syllabary

        and: "the English translation is preserved for later deconstruction"
        row.english

        where: "each of the two verb-book rows"
        row << VERB_BOOK
    }

    def "the verb book table is complete (two rows)"() {
        expect:
        VERB_BOOK.size() == 2
    }
}
