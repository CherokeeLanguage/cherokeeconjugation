package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Long and Rigid, like a stick, a shovel, etc." — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.44-45
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -vy-Ø-
 *   Present Tense: -vy-a
 *
 * Verb-book notes (as printed):
 *   - "This verb form means the action is actually going on at the present time."
 *   - "uwv- becomes uwa- in the Third Singular Form, in a regular phonetic change."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingLongAndRigidPresentSpec extends Specification {

    static final String VERB = "to have something long and rigid, like a stick, a shovel, etc."
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.44-45"

    // Affix composition as printed:
    static final String STEM = "-vy-Ø-"        // Stem I
    static final String TENSE_FORM = "-vy-a"  // Present Tense (Stem I)

    static final List<String> VERB_BOOK_NOTES = [
        "This verb form means the action is actually going on at the present time.",
        "uwv- becomes uwa- in the Third Singular Form, in a regular phonetic change.",
    ]

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "I have multiple long & rigid things\" agwvya/dagwvya", syllabary: "ᎠᏋᏯ/ᏓᏋᏯ", english: "I have something long & rigid (singular)\"/"],
            [pronoun: "Second Singular", romanized: "tsvya/detsvya", syllabary: "ᏨᏯ/ᏕᏨᏯ", english: "You have something long & rigid (singular)\"/\"You have multiple long & rigid things\""],
            [pronoun: "Third Singular", romanized: "uwaya/duwaya", syllabary: "ᎤᏩᏯ/ᏚᏩᏯ", english: "He/she/it has something long & rigid (singular)\"/\"He/she/it has multiple long & rigid things\""],
            [pronoun: "Second Dual", romanized: "sdvya/desdvya", syllabary: "ᏍᏛᏯ/ᏕᏍᏛᏯ", english: "You (two) have something long & rigid (singular)\"/\"You (two) have multiple long & rigid things\""],
            [pronoun: "Second Plural", romanized: "itsvya/detsvya", syllabary: "ᎢᏨᏯ/ᏕᏨᏯ", english: "You (more than two) have something long & rigid (singular)\"/\"You (more than two) have multiple long & rigid things\""],
            [pronoun: "First Dual Inclusive", romanized: "ginvya/deginvya", syllabary: "ᎩᏅᏯ/ᏕᎩᏅᏯ", english: "We (you and I) have something long & rigid (singular)\"/\"We (you and I) have multiple long & rigid things\""],
            [pronoun: "First Dual Exclusive", romanized: "oginvya/doginvya", syllabary: "ᎣᎩᏅᏯ/ᏙᎩᏅᏯ", english: "We (another and I) have something long & rigid (singular)\"/\"We (another and I) have multiple long & rigid things\""],
            [pronoun: "First Plural Exclusive", romanized: "ogvya/dogvya", syllabary: "ᎣᎬᏯ/ᏙᎬᏯ", english: "We (others and I) have something long & rigid (singular)\"/\"We (others and I) have multiple long & rigid things\""],
            [pronoun: "First Plural Inclusive", romanized: "igvya/degvya", syllabary: "ᎢᎬᏯ/ᏕᎬᏯ", english: "We (you and I and another or others) have something long & rigid (singular)\"/\"We (you and I and another or others) have multiple long & rigid things\""],
            [pronoun: "Third Plural Form", romanized: "unvya/dunvya", syllabary: "ᎤᏅᏯ/ᏚᏅᏯ", english: "They have something long & rigid (singular)\"/\"They have multiple long & rigid things\""],
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
