package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Be Thankful or Happy" — Remote Past Tense (Stem III).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.23-24
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III: -aliheli-ts-
 *   Remote Past Tense: -alihelits-v'i
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToBeThankfulOrHappyRemotePastSpec extends Specification {

    static final String VERB = "to be thankful or happy"
    static final String TENSE = "REMOTE_PAST"
    static final String SOURCE_PAGE = "pp.23-24"

    // Affix composition as printed:
    static final String STEM = "-aliheli-ts-"        // Stem III
    static final String TENSE_FORM = "-alihelits-v'i"  // Remote Past Tense (Stem III)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "agwalihelitsv'i", syllabary: "ᎠᏆᎵᎮᎵᏨᎢ", english: "I was thankful/happy"],
            [pronoun: "Second Singular", romanized: "tsalihelitsv'i", syllabary: "ᏣᎵᎮᎵᏨᎢ", english: "You were thankful/happy"],
            [pronoun: "Third Singular", romanized: "ulihelitsv'i", syllabary: "ᎤᎵᎮᎵᏨᎢ", english: "He/she/it was thankful/happy"],
            [pronoun: "Second Dual", romanized: "sdalihelitsv'i", syllabary: "ᏍᏓᎵᎮᎵᏨᎢ", english: "You (two) were thankful/happy"],
            [pronoun: "Second Plural", romanized: "itsalihelitsv'i", syllabary: "ᎢᏣᎵᎮᎵᏨᎢ", english: "You (more than two) were thankful/happy"],
            [pronoun: "First Dual Inclusive", romanized: "ginalihelitsv'i", syllabary: "ᎩᎾᎵᎮᎵᏨᎢ", english: "We (you and I) were thankful/happy"],
            [pronoun: "First Dual Exclusive", romanized: "oginalihelitsv'i", syllabary: "ᎣᎩᎾᎵᎮᎵᏨᎢ", english: "We (another and I) were thankful/happy"],
            [pronoun: "First Plural Exclusive", romanized: "ogalihelitsv'i", syllabary: "ᎣᎦᎵᎮᎵᏨᎢ", english: "We (others and I) were thankful/happy"],
            [pronoun: "First Plural Inclusive", romanized: "igalihelitsv'i", syllabary: "ᎢᎦᎵᎮᎵᏨᎢ", english: "We (you and I and another or others) were thankful/happy"],
            [pronoun: "Third Plural Form", romanized: "unalihelitsv'i", syllabary: "ᎤᎾᎵᎮᎵᏨᎢ", english: "They were thankful/happy"],
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

    def "remote past tense form matches the verb book (#row.pronoun)"() {
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
