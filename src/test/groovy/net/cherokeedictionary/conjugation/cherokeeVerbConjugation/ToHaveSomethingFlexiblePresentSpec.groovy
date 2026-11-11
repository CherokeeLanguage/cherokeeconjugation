package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Flexible" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.50
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -na-'-
 *   Present Tense: -na'-a
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingFlexiblePresentSpec extends VerbBaseSpec {

    static final String VERB = "to have something flexible"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "p.50"

    // Affix composition as printed:
    static final String STEM = "-na-'-"        // Stem I
    static final String TENSE_FORM = "-na'-a"  // Present Tense (Stem I)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "I have multiple flexible things\" agina'a/dagina'a", syllabary: "ᎠᎩᎾᎠ/ᏓᎩᎾᎠ", english: "I have something flexible (singular)\"/"],
            [pronoun: "Second Singular", romanized: "You have multiple flexible things\" tsana'a/detsana'a", syllabary: "ᏣᎾᎠ/ᏕᏣᎾᎠ", english: "You have something flexible (singular)\"/"],
            [pronoun: "Third Singular", romanized: "una'a/duna'a", syllabary: "ᎤᎾᎠ/ᏚᎾᎠ", english: "He/she/it has something flexible (singular)\"/\"He/she/it has multiple flexible things\""],
            [pronoun: "Second Dual", romanized: "sdina'a/desdina'a", syllabary: "ᏍᏗᎾᎠ/ᏕᏍᏗᎾᎠ", english: "You (two) have something flexible (singular)\"/\"You (two) have multiple flexible things\""],
            [pronoun: "Second Plural", romanized: "itsina'a/detsina'a", syllabary: "ᎢᏥᎾᎠ/ᏕᏥᎾᎠ", english: "You (more than two) have something flexible (singular)\"/\"You (more than two) have multiple flexible things\""],
            [pronoun: "First Dual Inclusive", romanized: "ginina'a/deginina'a", syllabary: "ᎩᏂᎾᎠ/ᏕᎩᏂᎾᎠ", english: "We (you and I) have something flexible (singular)\"/\"We (you and I) have multiple flexible things\""],
            [pronoun: "First Dual Exclusive", romanized: "oginina'a/doginina'a", syllabary: "ᎣᎩᏂᎾᎠ/ᏙᎩᏂᎾᎠ", english: "We (another and I) have something flexible (singular)\"/\"We (another and I) have multiple flexible things\""],
            [pronoun: "First Plural Exclusive", romanized: "ogina'a/dogina'a", syllabary: "ᎣᎩᎾᎠ/ᏙᎩᎾᎠ", english: "We (others and I) have something flexible (singular)\"/\"We (others and I) have multiple flexible things\""],
            [pronoun: "First Plural Inclusive", romanized: "igina'a/degina'a", syllabary: "ᎢᎩᎾᎠ/ᏕᎩᎾᎠ", english: "We (you and I and another or others) have something flexible (singular)\"/\"We (you and I and another or others) have multiple flexible things\""],
            [pronoun: "Third Plural Form", romanized: "They have multiple flexible things\" unina'a/dunina'a", syllabary: "ᎤᏂᎾᎠ/ᏚᏂᎾᎠ", english: "They have something flexible (singular)\"/"],
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

    def "present tense form matches the verb book (#row.pronoun)"() {
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
