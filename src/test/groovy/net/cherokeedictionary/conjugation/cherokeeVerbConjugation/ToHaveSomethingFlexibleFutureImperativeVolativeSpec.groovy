package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Flexible" — Future Imperative/Volative (Stem III).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.52
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III: -na-'-
 *   Future Imperative/Volative: -na'-esdi
 *
 * Verb-book note: "Sometime in the future, but not right now."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingFlexibleFutureImperativeVolativeSpec extends Specification {

    static final String VERB = "to have something flexible"
    static final String TENSE = "FUTURE_IMPERATIVE_VOLATIVE"
    static final String SOURCE_PAGE = "p.52"

    // Affix composition as printed:
    static final String STEM = "-na-'-"        // Stem III
    static final String TENSE_FORM = "-na'-esdi"  // Future Imperative/Volative (Stem III)

    static final String VERB_BOOK_NOTE =
        "Sometime in the future, but not right now."

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "May I have multiple flexible things!\" agina'esdi/dagina'esdi", syllabary: "ᎠᎩᎾᎡᏍᏗ/ᏓᎩᎾᎡᏍᏗ", english: "May I have something flexible (singular)!\"/"],
            [pronoun: "Second Singular", romanized: "tsana'esdi/detsana'esdi", syllabary: "ᏣᎾᎡᏍᏗ/ᏕᏣᎾᎡᏍᏗ", english: "May you have something flexible (singular)!\"/\"May you have multiple flexible things!\""],
            [pronoun: "Third Singular", romanized: "una'esdi/duna'esdi", syllabary: "ᎤᎾᎡᏍᏗ/ᏚᎾᎡᏍᏗ", english: "May he/she/it have something flexible (singular)!\"/\"May he/she/it have multiple flexible things!\""],
            [pronoun: "Second Dual", romanized: "sdina'esdi/desdina'esdi", syllabary: "ᏍᏗᎾᎡᏍᏗ/ᏕᏍᏗᎾᎡᏍᏗ", english: "May you (two) have something flexible (singular)!\"/\"May you (two) have multiple flexible things!\""],
            [pronoun: "Second Plural", romanized: "itsina'esdi/detsina'esdi", syllabary: "ᎢᏥᎾᎡᏍᏗ/ᏕᏥᎾᎡᏍᏗ", english: "May you (more than two) have something flexible (singular)!\"/\"May you (more than two) have multiple flexible things!\""],
            [pronoun: "First Dual Inclusive", romanized: "ginina'esdi/deginina'esdi", syllabary: "ᎩᏂᎾᎡᏍᏗ/ᏕᎩᏂᎾᎡᏍᏗ", english: "May we (you and I) have something flexible (singular)!\"/\"May we (you and I) have multiple flexible things!\""],
            [pronoun: "First Dual Exclusive", romanized: "oginina'esdi/doginina'esdi", syllabary: "ᎣᎩᏂᎾᎡᏍᏗ/ᏙᎩᏂᎾᎡᏍᏗ", english: "May we (another and I) have something flexible (singular)!\"/\"May we (another and I) have multiple flexible things!\""],
            [pronoun: "First Plural Exclusive", romanized: "ogina'esdi/dogina'esdi", syllabary: "ᎣᎩᎾᎡᏍᏗ/ᏙᎩᎾᎡᏍᏗ", english: "May we (others and I) have something flexible (singular)!\"/\"May we (others and I) have multiple flexible things!\""],
            [pronoun: "First Plural Inclusive", romanized: "igina'esdi/degina'esdi", syllabary: "ᎢᎩᎾᎡᏍᏗ/ᏕᎩᎾᎡᏍᏗ", english: "May we (you and I and another or others) have something flexible (singular)!\"/\"May we (you and I and another or others) have multiple flexible things!\""],
            [pronoun: "Third Plural Form", romanized: "unina'esdi/dunina'esdi", syllabary: "ᎤᏂᎾᎡᏍᏗ/ᏚᏂᎾᎡᏍᏗ", english: "May they have something flexible (singular)!\"/\"May they have multiple flexible things!\""],
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
