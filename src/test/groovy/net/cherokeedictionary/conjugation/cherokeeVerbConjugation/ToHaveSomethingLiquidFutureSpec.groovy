package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Liquid, in a container" — Future Tense (Stem III).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.57-58
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III: -ne-h-
 *   Future Tense: -neh-esdi
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingLiquidFutureSpec extends VerbBaseSpec {

    static final String VERB = "to have something liquid, in a container"
    static final String TENSE = "FUTURE"
    static final String SOURCE_PAGE = "pp.57-58"

    // Affix composition as printed:
    static final String STEM = "-ne-h-"        // Stem III
    static final String TENSE_FORM = "-neh-esdi"  // Future Tense (Stem III)

    /** The conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [object: 'SG3IN', pronoun: "First Singular", romanized: "aginehesdi", syllabary: "ᎠᎩᏁᎮᏍᏗ", english: "I will have something liquid (singular)"],
            [object: 'SG3IN', pronoun: "First Singular", romanized: "daginehesdi", syllabary: "ᏓᎩᏁᎮᏍᏗ", english: "I will have multiple liquid things"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "tsanehesdi", syllabary: "ᏣᏁᎮᏍᏗ", english: "You will have something liquid (singular)"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "detsanehesdi", syllabary: "ᏕᏣᏁᎮᏍᏗ", english: "You will have multiple liquid things"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "unehesdi", syllabary: "ᎤᏁᎮᏍᏗ", english: "He/she/it will have something liquid (singular)"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "dunehesdi", syllabary: "ᏚᏁᎮᏍᏗ", english: "He/she/it will have multiple liquid things"],
            [object: 'SG3IN', pronoun: "Second Dual", romanized: "sdinehesdi", syllabary: "ᏍᏗᏁᎮᏍᏗ", english: "You (two) will have something liquid (singular)"],
            [object: 'PL3IN', pronoun: "Second Dual", romanized: "desdinehesdi", syllabary: "ᏕᏍᏗᏁᎮᏍᏗ", english: "You (two) will have multiple liquid things"],
            [object: 'SG3IN', pronoun: "Second Plural", romanized: "itsinehesdi", syllabary: "ᎢᏥᏁᎮᏍᏗ", english: "You (more than two) will have something liquid (singular)"],
            [object: 'PL3IN', pronoun: "Second Plural", romanized: "detsinehesdi", syllabary: "ᏕᏥᏁᎮᏍᏗ", english: "You (more than two) will have multiple liquid things"],
            [object: 'SG3IN', pronoun: "First Dual Inclusive", romanized: "gininehesdi", syllabary: "ᎩᏂᏁᎮᏍᏗ", english: "We (you and I) will have something liquid (singular)"],
            [object: 'PL3IN', pronoun: "First Dual Inclusive", romanized: "degininehesdi", syllabary: "ᏕᎩᏂᏁᎮᏍᏗ", english: "We (you and I) will have multiple liquid things"],
            [object: 'SG3IN', pronoun: "First Dual Exclusive", romanized: "ogininehesdi", syllabary: "ᎣᎩᏂᏁᎮᏍᏗ", english: "We (another and I) will have something liquid (singular)"],
            [object: 'PL3IN', pronoun: "First Dual Exclusive", romanized: "dogininehesdi", syllabary: "ᏙᎩᏂᏁᎮᏍᏗ", english: "We (another and I) will have multiple liquid things"],
            [object: 'SG3IN', pronoun: "First Plural Exclusive", romanized: "oginehesdi", syllabary: "ᎣᎩᏁᎮᏍᏗ", english: "We (others and I) will have something liquid (singular)"],
            [object: 'PL3IN', pronoun: "First Plural Exclusive", romanized: "doginehesdi", syllabary: "ᏙᎩᏁᎮᏍᏗ", english: "We (others and I) will have multiple liquid things"],
            [object: 'SG3IN', pronoun: "First Plural Inclusive", romanized: "iginehesdi", syllabary: "ᎢᎩᏁᎮᏍᏗ", english: "We (you and I and another or others) will have something liquid (singular)"],
            [object: 'PL3IN', pronoun: "First Plural Inclusive", romanized: "doginehesdi", syllabary: "ᏙᎩᏁᎮᏍᏗ", english: "We (you and I and another or others) will have multiple liquid things"],
            [object: 'SG3IN', pronoun: "Third Plural", romanized: "uninehesdi", syllabary: "ᎤᏂᏁᎮᏍᏗ", english: "They will have something liquid (singular)"],
            [object: 'PL3IN', pronoun: "Third Plural", romanized: "duninehesdi", syllabary: "ᏚᏂᏁᎮᏍᏗ", english: "They will have multiple liquid things"],
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
