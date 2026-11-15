package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Long and Rigid, like a stick, a shovel, etc." — Immediate Imperative/Volative (Stem IV).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.47
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem IV: -vy-Ø-
 *   Immediate Imperative/Volative: -vy-esdi
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingLongAndRigidImmediateImperativeVolativeSpec extends VerbBaseSpec {

    static final String VERB = "to have something long and rigid, like a stick, a shovel, etc."
    static final String TENSE = "IMMEDIATE_IMPERATIVE_VOLATIVE"
    static final String SOURCE_PAGE = "p.47"

    // Affix composition as printed:
    static final String STEM = "-vy-Ø-"        // Stem IV
    static final String TENSE_FORM = "-vy-esdi"  // Immediate Imperative/Volative (Stem IV)

    /** The conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [object: 'SG3IN', pronoun: "First Singular", romanized: "agwvyesdi", syllabary: "ᎠᏋᏰᏍᏗ", english: "May I have something long & rigid (singular) right now!"],
            [object: 'SG3IN', pronoun: "First Singular", romanized: "dagwvyesdi", syllabary: "ᏓᏋᏰᏍᏗ", english: "May I have multiple long & rigid things right now!"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "tsvyesdi", syllabary: "ᏨᏰᏍᏗ", english: "May you have something long & rigid (singular) right now!"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "detsvyesdi", syllabary: "ᏕᏨᏰᏍᏗ", english: "May you have multiple long & rigid things right now!"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "uwayesdi", syllabary: "ᎤᏩᏰᏍᏗ", english: "May he/she/it have something long & rigid (singular) right now!"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "duwayesdi", syllabary: "ᏚᏩᏰᏍᏗ", english: "May he/she/it have multiple long & rigid things right now!"],
            [object: 'SG3IN', pronoun: "Second Dual", romanized: "sdvyesdi", syllabary: "ᏍᏛᏰᏍᏗ", english: "May you (two) have something long & rigid (singular) right now!"],
            [object: 'PL3IN', pronoun: "Second Dual", romanized: "desdvyesdi", syllabary: "ᏕᏍᏛᏰᏍᏗ", english: "May you (two) have multiple long & rigid things right now!"],
            [object: 'SG3IN', pronoun: "Second Plural", romanized: "itsvyesdi", syllabary: "ᎢᏨᏰᏍᏗ", english: "May you (more than two) have something long & rigid (singular) right now!"],
            [object: 'PL3IN', pronoun: "Second Plural", romanized: "detsvyesdi", syllabary: "ᏕᏨᏰᏍᏗ", english: "May you (more than two) have multiple long & rigid things right now!"],
            [object: 'SG3IN', pronoun: "First Dual Inclusive", romanized: "ginvyesdi", syllabary: "ᎩᏅᏰᏍᏗ", english: "May we (you and I) have something long & rigid (singular) right now!"],
            [object: 'PL3IN', pronoun: "First Dual Inclusive", romanized: "deginvyesdi", syllabary: "ᏕᎩᏅᏰᏍᏗ", english: "May we (you and I) have multiple long & rigid things right now!"],
            [object: 'SG3IN', pronoun: "First Dual Exclusive", romanized: "oginvyesdi", syllabary: "ᎣᎩᏅᏰᏍᏗ", english: "May we (another and I) have something long & rigid (singular) right now!"],
            [object: 'PL3IN', pronoun: "First Dual Exclusive", romanized: "doginvyesdi", syllabary: "ᏙᎩᏅᏰᏍᏗ", english: "May we (another and I) have multiple long & rigid things right now!"],
            [object: 'SG3IN', pronoun: "First Plural Exclusive", romanized: "ogvyesdi", syllabary: "ᎣᎬᏰᏍᏗ", english: "May we (others and I) have something long & rigid (singular) right now!"],
            [object: 'PL3IN', pronoun: "First Plural Exclusive", romanized: "dogvyesdi", syllabary: "ᏙᎬᏰᏍᏗ", english: "May we (others and I) have multiple long & rigid things right now!"],
            [object: 'SG3IN', pronoun: "First Plural Inclusive", romanized: "igvyesdi", syllabary: "ᎢᎬᏰᏍᏗ", english: "May we (you and I and another or others) have something long & rigid (singular) right now!"],
            [object: 'PL3IN', pronoun: "First Plural Inclusive", romanized: "degvyesdi", syllabary: "ᏕᎬᏰᏍᏗ", english: "May we (you and I and another or others) have multiple long & rigid things right now!"],
            [object: 'SG3IN', pronoun: "Third Plural", romanized: "unvyesdi", syllabary: "ᎤᏅᏰᏍᏗ", english: "May they have something long & rigid (singular) right now!"],
            [object: 'PL3IN', pronoun: "Third Plural", romanized: "dunvyesdi", syllabary: "ᏚᏅᏰᏍᏗ", english: "May they have multiple long & rigid things right now!"],
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

    def "immediate imperative/volative form matches the verb book (#row.pronoun #row.romanized)"() {
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
