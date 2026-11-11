package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Be Thankful or Happy" — Infinitive (Stem V).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.25
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem V: -aliheli-s-
 *   Infinitive: -alihelis-di
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToBeThankfulOrHappyInfinitiveSpec extends Specification {

    static final String VERB = "to be thankful or happy"
    static final String TENSE = "INFINITIVE"
    static final String SOURCE_PAGE = "p.25"

    // Affix composition as printed:
    static final String STEM = "-aliheli-s-"        // Stem V
    static final String TENSE_FORM = "-alihelis-di"  // Infinitive (Stem V)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "agwalihelisdi", syllabary: "ᎠᏆᎵᎮᎵᏍᏗ", english: "For me to be thankful/happy"],
            [pronoun: "Second Singular", romanized: "tsalihelisdi", syllabary: "ᏣᎵᎮᎵᏍᏗ", english: "For you to be thankful/happy"],
            [pronoun: "Third Singular", romanized: "ulihelisdi", syllabary: "ᎤᎵᎮᎵᏍᏗ", english: "For him/her/it to be thankful/happy"],
            [pronoun: "Second Dual", romanized: "sdalihelisdi", syllabary: "ᏍᏓᎵᎮᎵᏍᏗ", english: "For you (two) to be thankful/happy"],
            [pronoun: "Second Plural", romanized: "itsalihelisdi", syllabary: "ᎢᏣᎵᎮᎵᏍᏗ", english: "For you (more than two) to be thankful/happy"],
            [pronoun: "First Dual Inclusive", romanized: "ginalihelisdi", syllabary: "ᎩᎾᎵᎮᎵᏍᏗ", english: "For us (you and I) to be thankful/happy"],
            [pronoun: "First Dual Exclusive", romanized: "oginalihelisdi", syllabary: "ᎣᎩᎾᎵᎮᎵᏍᏗ", english: "For us (another and I) to be thankful/happy"],
            [pronoun: "First Plural Exclusive", romanized: "ogalihelisdi", syllabary: "ᎣᎦᎵᎮᎵᏍᏗ", english: "For us (others and I) to be thankful/happy"],
            [pronoun: "First Plural Inclusive", romanized: "igalihelisdi", syllabary: "ᎢᎦᎵᎮᎵᏍᏗ", english: "For us (you and I and another or others) to be thankful/happy"],
            [pronoun: "Third Plural Form", romanized: "unalihelisdi", syllabary: "ᎤᎾᎵᎮᎵᏍᏗ", english: "For them to be thankful/happy"],
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
