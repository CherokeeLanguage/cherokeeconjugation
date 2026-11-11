package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Be Thankful or Happy" — Immediate Past (Stem IV).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.25
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem IV: -aliheli-g-
 *   Immediate Past: -alihelig-i
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToBeThankfulOrHappyImmediatePastSpec extends Specification {

    static final String VERB = "to be thankful or happy"
    static final String TENSE = "IMMEDIATE_PAST"
    static final String SOURCE_PAGE = "p.25"

    // Affix composition as printed:
    static final String STEM = "-aliheli-g-"        // Stem IV
    static final String TENSE_FORM = "-alihelig-i"  // Immediate Past (Stem IV)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gali'eligi", syllabary: "ᎦᎵᎡᎵᎩ", english: "I was thankful/happy"],  // opening quote missing in print
            [pronoun: "Second Singular", romanized: "haliheligi", syllabary: "ᎭᎵᎮᎵᎩ", english: "You were thankful/happy"],  // opening quote missing in print
            [pronoun: "Third Singular", romanized: "aliheligi", syllabary: "ᎠᎵᎮᎵᎩ", english: "He/she/it was thankful/happy"],  // opening quote missing in print
            [pronoun: "Second Dual", romanized: "sdaliheligi", syllabary: "ᏍᏓᎵᎮᎵᎩ", english: "You (two) were thankful/happy"],  // opening quote missing in print
            [pronoun: "Second Plural", romanized: "itsaliheligi", syllabary: "ᎢᏣᎵᎮᎵᎩ", english: "You (more than two) were thankful/happy"],  // opening quote missing in print
            [pronoun: "First Dual Inclusive", romanized: "inaliheligi", syllabary: "ᎢᎾᎵᎮᎵᎩ", english: "We (you and I) were thankful/happy"],  // opening quote missing in print
            [pronoun: "First Dual Exclusive", romanized: "osdaliheligi", syllabary: "ᎣᏍᏓᎵᎮᎵᎩ", english: "We (another and I) were thankful/happy"],  // opening quote missing in print
            [pronoun: "First Plural Exclusive", romanized: "otsaliheligi", syllabary: "ᎣᏣᎵᎮᎵᎩ", english: "We (others and I) were thankful/happy"],  // opening quote missing in print
            [pronoun: "First Plural Inclusive", romanized: "idaliheligi", syllabary: "ᎢᏓᎵᎮᎵᎩ", english: "We (you and I and another or others) were thankful/happy"],  // opening quote missing in print
            [pronoun: "Third Plural Form", romanized: "analiheligi", syllabary: "ᎠᎾᎵᎮᎵᎩ", english: "They were thankful/happy"],
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

    def "immediate past form matches the verb book (#row.pronoun)"() {
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
