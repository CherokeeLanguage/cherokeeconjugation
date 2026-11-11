package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Long and Rigid, like a stick, a shovel, etc." — Remote Past Tense (Stem III).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.45
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III: -vy-Ø-
 *   Remote Past Tense: -vy-v'i
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingLongAndRigidRemotePastSpec extends Specification {

    static final String VERB = "to have something long and rigid, like a stick, a shovel, etc."
    static final String TENSE = "REMOTE_PAST"
    static final String SOURCE_PAGE = "p.45"

    // Affix composition as printed:
    static final String STEM = "-vy-Ø-"        // Stem III
    static final String TENSE_FORM = "-vy-v'i"  // Remote Past Tense (Stem III)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "I had multiple long & rigid things\" agwvyv'i/dagwvyv'i", syllabary: "ᎠᏋᏴᎢ/ᏓᏋᏴᎢ", english: "I had something long & rigid (singular)\"/"],
            [pronoun: "Second Singular", romanized: "tsvyv'i/detsvyv'i", syllabary: "ᏨᏴᎢ/ᏕᏨᏴᎢ", english: "You had something long & rigid (singular)\"/\"You had multiple long & rigid things\""],
            [pronoun: "Third Singular", romanized: "uwayv'i/duwayv'i", syllabary: "ᎤᏩᏴᎢ/ᏚᏩᏴᎢ", english: "He/she/it had something long & rigid (singular)\"/\"He/she/it had multiple long & rigid things\""],
            [pronoun: "Second Dual", romanized: "sdvyv'i/desdvyv'i", syllabary: "ᏍᏛᏴᎢ/ᏕᏍᏛᏴᎢ", english: "You (two) had something long & rigid (singular)\"/\"You (two) had multiple long & rigid things\""],
            [pronoun: "Second Plural", romanized: "itsvyv'i/detsvyv'i", syllabary: "ᎢᏨᏴᎢ/ᏕᏨᏴᎢ", english: "You (more than two) had something long & rigid (singular)\"/\"You (more than two) had multiple long & rigid things\""],
            [pronoun: "First Dual Inclusive", romanized: "ginvyv'i/deginvyv'i", syllabary: "ᎩᏅᏴᎢ/ᏕᎩᏅᏴᎢ", english: "We (you and I) had something long & rigid (singular)\"/\"We (you and I) had multiple long & rigid things\""],
            [pronoun: "First Dual Exclusive", romanized: "oginvyv'i/doginvyv'i", syllabary: "ᎣᎩᏅᏴᎢ/ᏙᎩᏅᏴᎢ", english: "We (another and I) had something long & rigid (singular)\"/\"We (another and I) had multiple long & rigid things\""],
            [pronoun: "First Plural Exclusive", romanized: "ogvyv'i", syllabary: "ᎣᎬᏴᎢ", english: "We (others and I) had something long & rigid (singular)"],
            [pronoun: "First Plural Inclusive", romanized: "igvyv'i/degvyv'i", syllabary: "ᎢᎬᏴᎢ/ᏕᎬᏴᎢ", english: "We (you and I and another or others) had something long & rigid (singular)\"/\"We (you and I and another or others) had multiple long & rigid things\""],
            [pronoun: "Third Plural Form", romanized: "unvyv'i/dunvyv'i", syllabary: "ᎤᏅᏴᎢ/ᏚᏅᏴᎢ", english: "They had something long & rigid (singular)\"/\"They had multiple long & rigid things\""],
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

    def "remote past tense form matches the verb book (#row.pronoun)"() {
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
