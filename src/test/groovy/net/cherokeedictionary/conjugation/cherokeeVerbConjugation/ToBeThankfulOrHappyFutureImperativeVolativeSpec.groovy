package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Be Thankful or Happy" — Future Imperative/Volative (Stem III).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.24
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III: -aliheli-ts-
 *   Future Imperative/Volative: -alihelits-v'i
 *   (the stems table prints alihelits-v'i for this tense)
 *
 * Verb-book note: "Sometime in the future, but not right now."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToBeThankfulOrHappyFutureImperativeVolativeSpec extends VerbBaseSpec {

    static final String VERB = "to be thankful or happy"
    static final String TENSE = "FUTURE_IMPERATIVE_VOLATIVE"
    static final String SOURCE_PAGE = "p.24"

    // Affix composition as printed:
    static final String STEM = "-aliheli-ts-"        // Stem III
    static final String TENSE_FORM = "-alihelits-v'i"  // Future Imperative/Volative (Stem III)

    static final String VERB_BOOK_NOTE =
        "Sometime in the future, but not right now."

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gali'elitsv'i", syllabary: "ᎦᎵᎡᎵᏨᎢ", english: "May I be thankful/happy!"],
            [pronoun: "Second Singular", romanized: "halihelitsv'i", syllabary: "ᎭᎵᎮᎵᏨᎢ", english: "May you be thankful/happy!"],
            [pronoun: "Third Singular", romanized: "alihelitsv'i", syllabary: "ᎠᎵᎮᎵᏨᎢ", english: "May he/she/it be thankful/happy!"],
            [pronoun: "Second Dual", romanized: "sdalihelitsv'i", syllabary: "ᏍᏓᎵᎮᎵᏨᎢ", english: "May you (two) be thankful/happy!"],
            [pronoun: "Second Plural", romanized: "itsalihelitsv'i", syllabary: "ᎢᏣᎵᎮᎵᏨᎢ", english: "May you (more than two) be thankful/happy!"],
            [pronoun: "First Dual Inclusive", romanized: "inalihelitsv'i", syllabary: "ᎢᎾᎵᎮᎵᏨᎢ", english: "May we (you and I) be thankful/happy!"],
            [pronoun: "First Dual Exclusive", romanized: "osdalihelitsv'i", syllabary: "ᎣᏍᏓᎵᎮᎵᏨᎢ", english: "May we (another and I) be thankful/happy!"],
            [pronoun: "First Plural Exclusive", romanized: "otsalihelitsv'i", syllabary: "ᎣᏣᎵᎮᎵᏨᎢ", english: "May we (others and I) be thankful/happy!"],
            [pronoun: "First Plural Inclusive", romanized: "idalihelitsv'i", syllabary: "ᎢᏓᎵᎮᎵᏨᎢ", english: "May we (you and I and another or others) be thankful/happy!"],
            [pronoun: "Third Plural Form", romanized: "analihelitsv'i", syllabary: "ᎠᎾᎵᎮᎵᏨᎢ", english: "May they be thankful/happy!"],
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

    def "future imperative/volative form matches the verb book (#row.pronoun)"() {
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
