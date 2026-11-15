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

    /** The conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [object: 'SG3IN', pronoun: "First Singular", romanized: "agwvyesdi", syllabary: "ᎠᏋᏰᏍᏗ", english: "I will have something long & rigid (singular)"],
            [object: 'SG3IN', pronoun: "First Singular", romanized: "dagwvyesdi", syllabary: "ᏓᏋᏰᏍᏗ", english: "I will have multiple long & rigid things"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "tsvyesdi", syllabary: "ᏨᏰᏍᏗ", english: "You will have something long & rigid (singular)"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "detsvyesdi", syllabary: "ᏕᏨᏰᏍᏗ", english: "You will have multiple long & rigid things"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "uwayesdi", syllabary: "ᎤᏩᏰᏍᏗ", english: "He/she/it will have something long & rigid (singular)"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "duwayesdi", syllabary: "ᏚᏩᏰᏍᏗ", english: "He/she/it will have multiple long & rigid things"],
            [object: 'SG3IN', pronoun: "Second Dual", romanized: "sdvyesdi", syllabary: "ᏍᏛᏰᏍᏗ", english: "You (two) will have something long & rigid (singular)"],
            [object: 'PL3IN', pronoun: "Second Dual", romanized: "desdvyesdi", syllabary: "ᏕᏍᏛᏰᏍᏗ", english: "You (two) will have multiple long & rigid things"],
            [object: 'SG3IN', pronoun: "Second Plural", romanized: "itsvyesdi", syllabary: "ᎢᏨᏰᏍᏗ", english: "You (more than two) will have something long & rigid (singular)"],
            [object: 'PL3IN', pronoun: "Second Plural", romanized: "detsvyesdi", syllabary: "ᏕᏨᏰᏍᏗ", english: "You (more than two) will have multiple long & rigid things"],
            [object: 'SG3IN', pronoun: "First Dual Inclusive", romanized: "ginvyesdi", syllabary: "ᎩᏅᏰᏍᏗ", english: "We (you and I) will have something long & rigid (singular)"],
            [object: 'PL3IN', pronoun: "First Dual Inclusive", romanized: "deginvyesdi", syllabary: "ᏕᎩᏅᏰᏍᏗ", english: "We (you and I) will have multiple long & rigid things"],
            [object: 'SG3IN', pronoun: "First Dual Exclusive", romanized: "oginvyesdi", syllabary: "ᎣᎩᏅᏰᏍᏗ", english: "We (another and I) will have something long & rigid (singular)"],
            [object: 'PL3IN', pronoun: "First Dual Exclusive", romanized: "doginvyesdi", syllabary: "ᏙᎩᏅᏰᏍᏗ", english: "We (another and I) will have multiple long & rigid things"],
            [object: 'SG3IN', pronoun: "First Plural Exclusive", romanized: "ogvyesdi", syllabary: "ᎣᎬᏰᏍᏗ", english: "We (others and I) will have something long & rigid (singular)"],
            [object: 'PL3IN', pronoun: "First Plural Exclusive", romanized: "dogvyesdi", syllabary: "ᏙᎬᏰᏍᏗ", english: "We (others and I) will have multiple long & rigid things"],
            [object: 'SG3IN', pronoun: "First Plural Inclusive", romanized: "igvyesdi", syllabary: "ᎢᎬᏰᏍᏗ", english: "We (you and I and another or others) will have something long & rigid (singular)"],
            [object: 'PL3IN', pronoun: "First Plural Inclusive", romanized: "degvyesdi", syllabary: "ᏕᎬᏰᏍᏗ", english: "We (you and I and another or others) will have multiple long & rigid things"],
            [object: 'SG3IN', pronoun: "Third Plural", romanized: "unvyesdi", syllabary: "ᎤᏅᏰᏍᏗ", english: "They will have something long & rigid (singular)"],
            [object: 'PL3IN', pronoun: "Third Plural", romanized: "dunvyesdi", syllabary: "ᏚᏅᏰᏍᏗ", english: "They will have multiple long & rigid things"],
    ]

    /**
     * Hook for the conjugation-engine comparison (to be wired in later).
     * Today it echoes the verb-book form; replace the body with a call into
     * the conjugation engine when the engine-vs-verb-book refinement begins.
     */
    Map conjugate(String pronoun, String romanized) {
        def row = VERB_BOOK.find { it.pronoun == pronoun && it.romanized == romanized }
        // TODO(engine-comparison): replace this echo with a conjugation-engine call,
        // e.g. conjStr(pronoun, "SG3IN", verbFixture, TENSE, "v.i.")
        return [romanized: row.romanized, syllabary: row.syllabary]
    }

    def "future tense form matches the verb book (#row.pronoun #row.romanized)"() {
        when: "the form is conjugated"
        def form = conjugate(row.pronoun, row.romanized)

        then: "both the romanized and syllabary forms match the verb book"
        form.romanized == row.romanized
        form.syllabary == row.syllabary

        and: "the English translation is preserved for later deconstruction"
        row.english

        where: "each of the twenty verb-book rows"
        row << VERB_BOOK
    }

    def "the verb book table is complete (twenty rows)"() {
        expect:
        VERB_BOOK.size() == 20
    }
}
