package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Liquid, in a container" — Future Imperative/Volative (Stem III).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.58
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III: -ne-h-
 *   Future Imperative/Volative: -neh-esdi
 *
 * Verb-book note: "Some time in the future, but not right now."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingLiquidFutureImperativeVolativeSpec extends VerbBaseSpec {

    static final String VERB = "to have something liquid, in a container"
    static final String TENSE = "FUTURE_IMPERATIVE_VOLATIVE"
    static final String SOURCE_PAGE = "p.58"

    // Affix composition as printed:
    static final String STEM = "-ne-h-"        // Stem III
    static final String TENSE_FORM = "-neh-esdi"  // Future Imperative/Volative (Stem III)

    static final String VERB_BOOK_NOTE =
        "Some time in the future, but not right now."

    /** The conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [object: 'SG3IN', pronoun: "First Singular", romanized: "aginehesdi", syllabary: "ᎠᎩᏁᎮᏍᏗ", english: "May I have something liquid (singular)!"],
            [object: 'SG3IN', pronoun: "First Singular", romanized: "daginehesdi", syllabary: "ᏓᎩᏁᎮᏍᏗ", english: "May I have multiple liquid things!"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "tsanehesdi", syllabary: "ᏣᏁᎮᏍᏗ", english: "May you have something liquid (singular)!"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "detsanehesdi", syllabary: "ᏕᏣᏁᎮᏍᏗ", english: "May you have multiple liquid things!"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "unehesdi", syllabary: "ᎤᏁᎮᏍᏗ", english: "May he/she/it have something liquid (singular)!"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "dunehesdi", syllabary: "ᏚᏁᎮᏍᏗ", english: "May he/she/it have multiple liquid things!"],
            [object: 'SG3IN', pronoun: "Second Dual", romanized: "sdinehesdi", syllabary: "ᏍᏗᏁᎮᏍᏗ", english: "May you (two) have something liquid (singular)!"],
            [object: 'PL3IN', pronoun: "Second Dual", romanized: "desdinehesdi", syllabary: "ᏕᏍᏗᏁᎮᏍᏗ", english: "May you (two) have multiple liquid things!"],
            [object: 'SG3IN', pronoun: "Second Plural", romanized: "itsinehesdi", syllabary: "ᎢᏥᏁᎮᏍᏗ", english: "May you (more than two) have something liquid (singular)!"],
            [object: 'PL3IN', pronoun: "Second Plural", romanized: "detsinehesdi", syllabary: "ᏕᏥᏁᎮᏍᏗ", english: "May you (more than two) have multiple liquid things!"],
            [object: 'SG3IN', pronoun: "First Dual Inclusive", romanized: "gininehesdi", syllabary: "ᎩᏂᏁᎮᏍᏗ", english: "May we (you and I) have something liquid (singular)!"],
            [object: 'PL3IN', pronoun: "First Dual Inclusive", romanized: "degininehesdi", syllabary: "ᏕᎩᏂᏁᎮᏍᏗ", english: "May we (you and I) have multiple liquid things!"],
            [object: 'SG3IN', pronoun: "First Dual Exclusive", romanized: "ogininehesdi", syllabary: "ᎣᎩᏂᏁᎮᏍᏗ", english: "May we (another and I) have something liquid (singular)!"],
            [object: 'PL3IN', pronoun: "First Dual Exclusive", romanized: "dogininehesdi", syllabary: "ᏙᎩᏂᏁᎮᏍᏗ", english: "May we (another and I) have multiple liquid things!"],
            [object: 'SG3IN', pronoun: "First Plural Exclusive", romanized: "oginehesdi", syllabary: "ᎣᎩᏁᎮᏍᏗ", english: "May we (others and I) have something liquid (singular)!"],
            [object: 'PL3IN', pronoun: "First Plural Exclusive", romanized: "doginehesdi", syllabary: "ᏙᎩᏁᎮᏍᏗ", english: "May we (others and I) have multiple liquid things!"],
            [object: 'SG3IN', pronoun: "First Plural Inclusive", romanized: "iginehesdi", syllabary: "ᎢᎩᏁᎮᏍᏗ", english: "May we (you and I and another or others) have something liquid (singular)!"],
            [object: 'PL3IN', pronoun: "First Plural Inclusive", romanized: "deginehesdi", syllabary: "ᏕᎩᏁᎮᏍᏗ", english: "May we (you and I and another or others) have multiple liquid things!"],
            [object: 'SG3IN', pronoun: "Third Plural", romanized: "uninehesdi", syllabary: "ᎤᏂᏁᎮᏍᏗ", english: "May they have something liquid (singular)!"],
            [object: 'PL3IN', pronoun: "Third Plural", romanized: "duninehesdi", syllabary: "ᏚᏂᏁᎮᏍᏗ", english: "May they have multiple liquid things!"],
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

    def "future imperative/volative form matches the verb book (#row.pronoun #row.romanized)"() {
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
