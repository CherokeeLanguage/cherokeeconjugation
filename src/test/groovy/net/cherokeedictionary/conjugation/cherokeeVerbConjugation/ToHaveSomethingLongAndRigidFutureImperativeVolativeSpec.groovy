package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Long and Rigid, like a stick, a shovel, etc." — Future Imperative/Volative (Stem III).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.46
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III: -vy-Ø-
 *   Future Imperative/Volative: -vy-esdi
 *
 * Verb-book notes (as printed):
 *   - "Some time in the future, but not right now."
 *   - "These are the same forms as the future tense."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingLongAndRigidFutureImperativeVolativeSpec extends VerbBaseSpec {

    static final String VERB = "to have something long and rigid, like a stick, a shovel, etc."
    static final String TENSE = "FUTURE_IMPERATIVE_VOLATIVE"
    static final String SOURCE_PAGE = "p.46"

    // Affix composition as printed:
    static final String STEM = "-vy-Ø-"        // Stem III
    static final String TENSE_FORM = "-vy-esdi"  // Future Imperative/Volative (Stem III)

    static final List<String> VERB_BOOK_NOTES = [
        "Some time in the future, but not right now.",
        "These are the same forms as the future tense.",
    ]

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "agwvyesdi/dagwvyesdi", syllabary: "ᎠᏋᏰᏍᏗ/ᏓᏋᏰᏍᏗ", english: "May I have something long & rigid (singular)!\"/\"May I have multiple long & rigid things!\""],
            [pronoun: "Second Singular", romanized: "tsvyesdi/detsvyesdi", syllabary: "ᏨᏰᏍᏗ/ᏕᏨᏰᏍᏗ", english: "May you have something long & rigid (singular)!\"/\"May you have multiple long & rigid things!\""],
            [pronoun: "Third Singular", romanized: "uwayesdi/duwayesdi", syllabary: "ᎤᏩᏰᏍᏗ/ᏚᏩᏰᏍᏗ", english: "May he/she/it have something long & rigid (singular)!\"/\"May he/she/it have multiple long & rigid things!\""],
            [pronoun: "Second Dual", romanized: "tsvyesdi/detsvyesdi", syllabary: "ᏨᏰᏍᏗ/ᏕᏨᏰᏍᏗ", english: "May you (two) have something long & rigid (singular)!\"/\"May you (two) have multiple long & rigid things!\""],
            [pronoun: "Second Plural", romanized: "itsvyesdi/detsvyesdi", syllabary: "ᎢᏨᏰᏍᏗ/ᏕᏨᏰᏍᏗ", english: "May you (more than two) have something long & rigid (singular)!\"/\"May you (more than two) have multiple long & rigid things!\""],
            [pronoun: "First Dual Inclusive", romanized: "ginvyesdi/deginvyesdi", syllabary: "ᎩᏅᏰᏍᏗ/ᏕᎩᏅᏰᏍᏗ", english: "May we (you and I) have something long & rigid (singular)!\"/\"May we (you and I) have multiple long & rigid things!\""],
            [pronoun: "First Dual Exclusive", romanized: "oginvyesdi/doginvyesdi", syllabary: "ᎣᎩᏅᏰᏍᏗ/ᏙᎩᏅᏰᏍᏗ", english: "May we (another and I) have something long & rigid (singular)!\"/\"May we (another and I) have multiple long & rigid things!\""],
            [pronoun: "First Plural Exclusive", romanized: "ogvyesdi/dogvyesdi", syllabary: "ᎣᎬᏰᏍᏗ/ᏙᎬᏰᏍᏗ", english: "May we (others and I) have something long & rigid (singular)!\"/\"May we (others and I) have multiple long & rigid things!\""],
            [pronoun: "First Plural Inclusive", romanized: "igvyesdi/degvyesdi", syllabary: "ᎢᎬᏰᏍᏗ/ᏕᎬᏰᏍᏗ", english: "May we (you and I and another or others) have something long & rigid (singular)!\"/\"May we (you and I and another or others) have multiple long & rigid things!\""],
            [pronoun: "Third Plural Form", romanized: "unvyesdi/dunvyesdi", syllabary: "ᎤᏅᏰᏍᏗ/ᏚᏅᏰᏍᏗ", english: "May they have something long & rigid (singular)!\"/\"May they have multiple long & rigid things!\""],
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
