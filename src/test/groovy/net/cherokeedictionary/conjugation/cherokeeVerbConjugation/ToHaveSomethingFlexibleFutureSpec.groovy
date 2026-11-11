package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Flexible" — Future Tense (Stem III).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.51
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III: -na-'-
 *   Future Tense: -na'-esdi
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingFlexibleFutureSpec extends Specification {

    static final String VERB = "to have something flexible"
    static final String TENSE = "FUTURE"
    static final String SOURCE_PAGE = "p.51"

    // Affix composition as printed:
    static final String STEM = "-na-'-"        // Stem III
    static final String TENSE_FORM = "-na'-esdi"  // Future Tense (Stem III)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "I will have multiple flexible things\" agina'esdi/dagina'esdi", syllabary: "ᎠᎩᎾᎡᏍᏗ/ᏓᎩᎾᎡᏍᏗ", english: "I will have something flexible (singular)\"/"],
            [pronoun: "Second Singular", romanized: "tsana'esdi/detsana'esdi", syllabary: "ᏣᎾᎡᏍᏗ/ᏕᏣᎾᎡᏍᏗ", english: "You will have something flexible (singular)\"/\"You will have multiple flexible things\""],
            [pronoun: "Third Singular", romanized: "una'esdi/duna'esdi", syllabary: "ᎤᎾᎡᏍᏗ/ᏚᎾᎡᏍᏗ", english: "He/she/it will have something flexible (singular)\"/\"He/she/it will have multiple flexible things\""],
            [pronoun: "Second Dual", romanized: "sdina'esdi/desdina'esdi", syllabary: "ᏍᏗᎾᎡᏍᏗ/ᏕᏍᏗᎾᎡᏍᏗ", english: "You (two) will have something flexible (singular)\"/\"You (two) will have multiple flexible things\""],
            [pronoun: "Second Plural", romanized: "itsina'esdi/detsina'esdi", syllabary: "ᎢᏥᎾᎡᏍᏗ/ᏕᏥᎾᎡᏍᏗ", english: "You (more than two) will have something flexible (singular)\"/\"You (more than two) will have multiple flexible things\""],
            [pronoun: "First Dual Inclusive", romanized: "ginina'esdi/deginina'esdi", syllabary: "ᎩᏂᎾᎡᏍᏗ/ᏕᎩᏂᎾᎡᏍᏗ", english: "We (you and I) will have something flexible (singular)\"/\"We (you and I) will have multiple flexible things\""],
            [pronoun: "First Dual Exclusive", romanized: "oginina'esdi/doginina'esdi", syllabary: "ᎣᎩᏂᎾᎡᏍᏗ/ᏙᎩᏂᎾᎡᏍᏗ", english: "We (another and I) will have something flexible (singular)\"/\"We (another and I) will have multiple flexible things\""],
            [pronoun: "First Plural Exclusive", romanized: "ogina'esdi/dogina'esdi", syllabary: "ᎣᎩᎾᎡᏍᏗ/ᏙᎩᎾᎡᏍᏗ", english: "We (others and I) will have something flexible (singular)\"/\"We (others and I) will have multiple flexible things\""],
            [pronoun: "First Plural Inclusive", romanized: "igina'esdi/degina'esdi", syllabary: "ᎢᎩᎾᎡᏍᏗ/ᏕᎩᎾᎡᏍᏗ", english: "We (you and I and another or others) will have something flexible (singular)\"/\"We (you and I and another or others) will have multiple flexible things\""],
            [pronoun: "Third Plural Form", romanized: "unina'esdi/dunina'esdi", syllabary: "ᎤᏂᎾᎡᏍᏗ/ᏚᏂᎾᎡᏍᏗ", english: "They will have something flexible (singular)\"/\"They will have multiple flexible things\""],
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
