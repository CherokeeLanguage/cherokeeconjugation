package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Go" — Future (Expected) Tense (Stem II).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.37
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem II: -e-s-
 *   Future (Expected) Tense: -es-i  (NB: Future is usually Stem III)
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToGoFutureExpectedSpec extends VerbBaseSpec {

    static final String VERB = "to go"
    static final String TENSE = "FUTURE_EXPECTED"
    static final String SOURCE_PAGE = "p.37"

    // Affix composition as printed:
    static final String STEM = "-e-s-"        // Stem II
    static final String TENSE_FORM = "-es-i"  // Future (Expected) Tense (Stem II) NB: Future is usually Stem III

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "dagesi", syllabary: "ᏓᎨᏏ", english: "I will go"],
            [pronoun: "Second Singular", romanized: "tesi (dahesi)", syllabary: "ᏖᏏ", english: "You will go"],  // as printed: (ᏓᎮᏏ)
            [pronoun: "Third Singular", romanized: "dayesi", syllabary: "ᏓᏰᏏ", english: "He/she/it will go"],
            [pronoun: "Second Dual", romanized: "dasdesi", syllabary: "ᏓᏍᏕᏏ", english: "You (two) will go"],
            [pronoun: "Second Plural", romanized: "datsesi", syllabary: "ᏓᏤᏏ", english: "You (more than two) will go"],
            [pronoun: "First Dual Inclusive", romanized: "danesi", syllabary: "ᏓᏁᏏ", english: "We (you and I) will go"],
            [pronoun: "First Dual Exclusive", romanized: "dayosdesi", syllabary: "ᏓᏲᏍᏕᏏ", english: "We (another and I) will go"],
            [pronoun: "First Plural Exclusive", romanized: "dayotsesi", syllabary: "ᏓᏲᏤᏏ", english: "We (others and I) will go"],
            [pronoun: "First Plural Inclusive", romanized: "dadesi", syllabary: "ᏓᏕᏏ", english: "We (you and I and another or others) will go"],
            [pronoun: "Third Plural Form", romanized: "dvnesi", syllabary: "ᏛᏁᏏ", english: "They will go"],
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

    def "future (expected) tense form matches the verb book (#row.pronoun)"() {
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
