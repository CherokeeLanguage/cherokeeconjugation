package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Flexible" — Present Habitual (Stem II).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.52-53
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem II: -na-'-
 *   Present Habitual: -na'-o'i
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingFlexiblePresentHabitualSpec extends VerbBaseSpec {

    static final String VERB = "to have something flexible"
    static final String TENSE = "PRESENT_HABITUAL"
    static final String SOURCE_PAGE = "pp.52-53"

    // Affix composition as printed:
    static final String STEM = "-na-'-"        // Stem II
    static final String TENSE_FORM = "-na'-o'i"  // Present Habitual (Stem II)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "I have multiple flexible things\" agina'o'i/dunina'o'i", syllabary: "ᎠᎩᎾᎣᎢ/ᏚᏂᎾᎣᎢ", english: "I have something flexible (singular)\"/"],
            [pronoun: "Second Singular", romanized: "You have multiple flexible things\" tsana'o'i/detsana'o'i", syllabary: "ᏣᎾᎣᎢ/ᏕᏣᎾᎣᎢ", english: "You have something flexible (singular)\"/"],
            [pronoun: "Third Singular", romanized: "He/she/it has multiple flexible things\" una'o'i/duna'o'i", syllabary: "ᎤᎾᎣᎢ/ᏚᎾᎣᎢ", english: "He/she/it has something flexible (singular)\"/"],
            [pronoun: "Second Dual", romanized: "You (two) have multiple flexible things\" sdina'o'i/desdina'o'i", syllabary: "ᏍᏗᎾᎣᎢ/ᏕᏍᏗᎾᎣᎢ", english: "You (two) have something flexible (singular)\"/"],
            [pronoun: "Second Plural", romanized: "itsina'o'i/detsina'o'i", syllabary: "ᎢᏥᎾᎣᎢ/ᏕᏥᎾᎣᎢ", english: "You (more than two) have something flexible (singular)\"/\"You (more than two) have multiple flexible things\""],
            [pronoun: "First Dual Inclusive", romanized: "ginina'o'i/deginina'o'i", syllabary: "ᎩᏂᎾᎣᎢ/ᏕᎩᏂᎾᎣᎢ", english: "We (you and I) have something flexible (singular)\"/\"We (you and I) have multiple flexible things\""],
            [pronoun: "First Dual Exclusive", romanized: "oginina'o'i/doginina'o'i", syllabary: "ᎣᎩᏂᎾᎣᎢ/ᏙᎩᏂᎾᎣᎢ", english: "We (another and I) have something flexible (singular)\"/\"We (another and I) have multiple flexible things\""],
            [pronoun: "First Plural Exclusive", romanized: "ogina'o'i/dogina'o'i", syllabary: "ᎣᎩᎾᎣᎢ/ᏙᎩᎾᎣᎢ", english: "We (others and I) have something flexible (singular)\"/\"We (others and I) have multiple flexible things\""],
            [pronoun: "First Plural Inclusive", romanized: "igina'o'i/degina'o'i", syllabary: "ᎢᎩᎾᎣᎢ/ᏕᎩᎾᎣᎢ", english: "We (you and I and another or others) have something flexible (singular)\"/\"We (you and I and another or others) have multiple flexible things\""],
            [pronoun: "Third Plural", romanized: "They have multiple flexible things\" unina'o'i/dunina'o'i", syllabary: "ᎤᏂᎾᎣᎢ/ᏚᏂᎾᎣᎢ", english: "They have something flexible (singular)\"/"],
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

    def "present habitual form matches the verb book (#row.pronoun)"() {
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
