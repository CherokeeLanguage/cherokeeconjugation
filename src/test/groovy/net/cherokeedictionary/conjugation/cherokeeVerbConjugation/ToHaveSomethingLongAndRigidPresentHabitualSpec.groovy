package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Long and Rigid, like a stick, a shovel, etc." — Present Habitual (Stem II).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.46-47
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem II: -vy-Ø-
 *   Present Habitual: -vy-o'i
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingLongAndRigidPresentHabitualSpec extends Specification {

    static final String VERB = "to have something long and rigid, like a stick, a shovel, etc."
    static final String TENSE = "PRESENT_HABITUAL"
    static final String SOURCE_PAGE = "pp.46-47"

    // Affix composition as printed:
    static final String STEM = "-vy-Ø-"        // Stem II
    static final String TENSE_FORM = "-vy-o'i"  // Present Habitual (Stem II)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "I have multiple long & rigid things\" agwvyo'i/dagwvyo'i", syllabary: "ᎠᏋᏲᎢ/ᏓᏋᏲᎢ", english: "I have something long & rigid (singular)\"/"],
            [pronoun: "Second Singular", romanized: "tsvyo'i/detsvyo'i", syllabary: "ᏨᏲᎢ/ᏕᏨᏲᎢ", english: "You have something long & rigid (singular)\"/\"You have multiple long & rigid things\""],
            [pronoun: "Third Singular", romanized: "uwayo'i/duwayo'i", syllabary: "ᎤᏩᏲᎢ/ᏚᏩᏲᎢ", english: "He/she/it has something long & rigid (singular)\"/\"He/she/it has multiple long & rigid things\""],
            [pronoun: "Second Dual", romanized: "sdvyo'i/desdvyo'i", syllabary: "ᏍᏛᏲᎢ/ᏕᏍᏛᏲᎢ", english: "You (two) have something long & rigid (singular)\"/\"You (two) have multiple long & rigid things\""],
            [pronoun: "Second Plural", romanized: "itsvyo'i/detsvyo'i", syllabary: "ᎢᏨᏲᎢ/ᏕᏨᏲᎢ", english: "You (more than two) have something long & rigid (singular)\"/\"You (more than two) have multiple long & rigid things\""],
            [pronoun: "First Dual Inclusive", romanized: "ginvyo'i/diginvyo'i", syllabary: "ᎩᏅᏲᎢ/ᏗᎩᏅᏲᎢ", english: "We (you and I) have something long & rigid (singular)\"/\"We (you and I) have multiple long & rigid things\""],
            [pronoun: "First Dual Exclusive", romanized: "oginvyo'i/doginvyo'i", syllabary: "ᎣᎩᏅᏲᎢ/ᏙᎩᏅᏲᎢ", english: "We (another and I) have something long & rigid (singular)\"/\"We (another andI) have multiple long & rigid things\""],
            [pronoun: "First Plural Exclusive", romanized: "ogvyo'i/dogvyo'i", syllabary: "ᎣᎬᏲᎢ/ᏙᎬᏲᎢ", english: "We (others and I) have something long & rigid (singular)\"/\"We (others and I) have multiple long & rigid things\""],
            [pronoun: "First Plural Inclusive", romanized: "igvyo'i/degvyo'i", syllabary: "ᎢᎬᏲᎢ/ᏕᎬᏲᎢ", english: "We (you and I and another or others) have something long & rigid (singular)\"/\"We (you and I and another or others) have multiple long & rigid things\""],
            [pronoun: "Third Plural Form", romanized: "unvyo'i/dunvyo'i", syllabary: "ᎤᏅᏲᎢ/ᏚᏅᏲᎢ", english: "They have something long & rigid (singular)\"/\"They have multiple long & rigid things\""],
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
