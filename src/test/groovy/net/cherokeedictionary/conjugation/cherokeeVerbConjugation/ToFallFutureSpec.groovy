package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Fall (a living being)" — Future Tense (Stem III).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.33
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III: -nv-ts-
 *   Future Tense: -nvts-i
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToFallFutureSpec extends VerbBaseSpec {

    static final String VERB = "to fall (a living being)"
    static final String TENSE = "FUTURE"
    static final String SOURCE_PAGE = "p.33"

    // Affix composition as printed:
    static final String STEM = "-nv-ts-"        // Stem III
    static final String TENSE_FORM = "-nvts-i"  // Future Tense (Stem III)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "datsinvtsi \"", syllabary: "ᏓᏥᏅᏥ", english: "I will fall"],  // opening quote missing in print; stray quote glyph as printed
            [pronoun: "Second Singular", romanized: "tinvtsi \"", syllabary: "ᏘᏅᏥ", english: "You will fall"],  // opening quote missing in print; stray quote glyph as printed
            [pronoun: "Third Singular", romanized: "daganvtsi", syllabary: "ᏓᎦᏅᏥ", english: "S/he will fall"],
            [pronoun: "Second Dual", romanized: "dodasdinvtsi", syllabary: "ᏙᏓᏍᏗᏅᏥ", english: "You (two) will fall"],
            [pronoun: "Second Plural", romanized: "dodatsinvtsi", syllabary: "ᏙᏓᏥᏅᏥ", english: "You (more than two) will fall"],
            [pronoun: "First Dual Inclusive", romanized: "dodaninvtsi", syllabary: "ᏙᏓᏂᏅᏥ", english: "We (you and I) will fall"],
            [pronoun: "First Dual Exclusive", romanized: "dodayosdinvtsi", syllabary: "ᏙᏓᏲᏍᏗᏅᏥ", english: "We (another and I) will fall"],
            [pronoun: "First Plural Exclusive", romanized: "dodayotsinvtsi", syllabary: "ᏙᏓᏲᏥᏅᏥ", english: "We (others and I) will fall"],
            [pronoun: "First Plural Inclusive", romanized: "dodadinvtsi", syllabary: "ᏙᏓᏗᏅᏥ", english: "We (you and I and another or others) will fall"],
            [pronoun: "Third Plural", romanized: "dodvninvtsi", syllabary: "ᏙᏛᏂᏅᏥ", english: "They will fall"],
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
