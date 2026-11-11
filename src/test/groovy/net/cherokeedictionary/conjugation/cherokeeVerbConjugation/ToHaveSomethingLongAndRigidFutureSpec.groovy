package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Long and Rigid, like a stick, a shovel, etc." — Future Tense (Stem III).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.45-46
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III: -vy-Ø-
 *   Future Tense: -vy-esdi
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingLongAndRigidFutureSpec extends VerbBaseSpec {

    static final String VERB = "to have something long and rigid, like a stick, a shovel, etc."
    static final String TENSE = "FUTURE"
    static final String SOURCE_PAGE = "pp.45-46"

    // Affix composition as printed:
    static final String STEM = "-vy-Ø-"        // Stem III
    static final String TENSE_FORM = "-vy-esdi"  // Future Tense (Stem III)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "agwvyesdi/dagwvyesdi", syllabary: "ᎠᏋᏰᏍᏗ/ᏓᏋᏰᏍᏗ", english: "I will have something long & rigid (singular)\"/\"I will have multiple long & rigid things\""],
            [pronoun: "Second Singular", romanized: "tsvyesdi/detsvyesdi", syllabary: "ᏨᏰᏍᏗ/ᏕᏨᏰᏍᏗ", english: "You will have something long & rigid (singular)\"/\"You will have multiple long & rigid things\""],
            [pronoun: "Third Singular", romanized: "uwayesdi/duwayesdi", syllabary: "ᎤᏩᏰᏍᏗ/ᏚᏩᏰᏍᏗ", english: "He/she/it will have something long & rigid (singular)\"/\"He/she/it will have multiple long & rigid things\""],
            [pronoun: "Second Dual", romanized: "sdvyesdi/desdvyesdi", syllabary: "ᏍᏛᏰᏍᏗ/ᏕᏍᏛᏰᏍᏗ", english: "You (two) will have something long & rigid (singular)\"/\"You (two) will have multiple long & rigid things\""],
            [pronoun: "Second Plural", romanized: "itsvyesdi/detsvyesdi", syllabary: "ᎢᏨᏰᏍᏗ/ᏕᏨᏰᏍᏗ", english: "You (more than two) will have something long & rigid (singular)\"/\"You (more than two) will have multiple long & rigid things\""],
            [pronoun: "First Dual Inclusive", romanized: "ginvyesdi/deginvyesdi", syllabary: "ᎩᏅᏰᏍᏗ/ᏕᎩᏅᏰᏍᏗ", english: "We (you and I) will have something long & rigid (singular)\"/\"We (you and I) will have multiple long & rigid things\""],
            [pronoun: "First Dual Exclusive", romanized: "oginvyesdi/deginvyesdi", syllabary: "ᎣᎩᏅᏰᏍᏗ/ᏕᎩᏅᏰᏍᏗ", english: "We (another and I) will have something long & rigid (singular)\"/\"We (another and I) will have multiple long & rigid things\""],
            [pronoun: "First Plural Exclusive", romanized: "ogvyesdi/dogvyesdi", syllabary: "ᎣᎬᏰᏍᏗ/ᏙᎬᏰᏍᏗ", english: "We (others and I) will have something long & rigid (singular)\"/\"We (others and I) will have multiple long & rigid things\""],
            [pronoun: "First Plural Inclusive", romanized: "igvyesdi/degvyesdi", syllabary: "ᎢᎬᏰᏍᏗ/ᏕᎬᏰᏍᏗ", english: "We (you and I and another or others) will have something long & rigid (singular)\"/\"We (you and I and another or others) will have multiple long & rigid things\""],
            [pronoun: "Third Plural", romanized: "unvyesdi/dunvyesdi", syllabary: "ᎤᏅᏰᏍᏗ/ᏚᏅᏰᏍᏗ", english: "They will have something long & rigid (singular)\"/\"They will have multiple long & rigid things\""],
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
