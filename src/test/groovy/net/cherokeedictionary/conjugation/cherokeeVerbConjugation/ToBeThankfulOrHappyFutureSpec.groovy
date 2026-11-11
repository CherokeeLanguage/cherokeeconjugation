package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Be Thankful or Happy" — Future Tense (Stem III).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.24
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III: -aliheli-ts-
 *   Future Tense: -alihelits-i
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToBeThankfulOrHappyFutureSpec extends VerbBaseSpec {

    static final String VERB = "to be thankful or happy"
    static final String TENSE = "FUTURE"
    static final String SOURCE_PAGE = "p.24"

    // Affix composition as printed:
    static final String STEM = "-aliheli-ts-"        // Stem III
    static final String TENSE_FORM = "-alihelits-i"  // Future Tense (Stem III)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "dagali'elitsi", syllabary: "ᏓᎦᎵᎡᎵᏥ", english: "I will be thankful/happy"],
            [pronoun: "Second Singular", romanized: "talihelitsi (exp. dahalihelitsi)", syllabary: "ᏔᎵᎮᎵᏥ", english: "You will be thankful/happy"],
            [pronoun: "Third Singular", romanized: "dvlihelitsi", syllabary: "ᏛᎵᎮᎵᏥ", english: "He/she/it will be thankful/happy"],
            [pronoun: "Second Dual", romanized: "dasdalihelitsi", syllabary: "ᏓᏍᏓᎵᎮᎵᏥ", english: "You (two) will be thankful/happy"],
            [pronoun: "Second Plural", romanized: "datsalihelitsi", syllabary: "ᏓᏣᎵᎮᎵᏥ", english: "You (more than two) will be thankful/happy"],
            [pronoun: "First Dual Inclusive", romanized: "danalihelitsi", syllabary: "ᏓᎾᎵᎮᎵᏥ", english: "We (you and I) will be thankful/happy"],
            [pronoun: "First Dual Exclusive", romanized: "dayosdalihelitsi", syllabary: "ᏓᏲᏍᏓᎵᎮᎵᏥ", english: "We (another and I) will be thankful/happy"],
            [pronoun: "First Plural Exclusive", romanized: "dayotsalihelitsi", syllabary: "ᏓᏲᏣᎵᎮᎵᏥ", english: "We (others and I) will be thankful/happy"],
            [pronoun: "First Plural Inclusive", romanized: "dadalihelitsi", syllabary: "ᏓᏓᎵᎮᎵᏥ", english: "We (you and I and another or others) will be thankful/happy"],
            [pronoun: "Third Plural", romanized: "dvnalihelitsi", syllabary: "ᏛᎾᎵᎮᎵᏥ", english: "They will be thankful/happy"],
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

    def "future tense form matches the verb book (#row.pronoun)"() {
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
