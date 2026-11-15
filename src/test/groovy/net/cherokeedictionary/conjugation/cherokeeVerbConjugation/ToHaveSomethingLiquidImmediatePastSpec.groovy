package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Liquid, in a container" — Immediate Past (Stem IV).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.59-60
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem IV: -ne-h-
 *   Immediate Past: -neh-v'i
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingLiquidImmediatePastSpec extends VerbBaseSpec {

    static final String VERB = "to have something liquid, in a container"
    static final String TENSE = "IMMEDIATE_PAST"
    static final String SOURCE_PAGE = "pp.59-60"

    // Affix composition as printed:
    static final String STEM = "-ne-h-"        // Stem IV
    static final String TENSE_FORM = "-neh-v'i"  // Immediate Past (Stem IV)

    /** The conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [object: 'SG3IN', pronoun: "First Singular", romanized: "aginehv'i", syllabary: "ᎠᎩᏁᎲᎢ", english: "I had something liquid (singular)"],
            [object: 'PL3IN', pronoun: "First Singular", romanized: "daginehv'i", syllabary: "ᏓᎩᏁᎲᎢ", english: "I had multiple liquid things"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "tsanehv'i", syllabary: "ᏣᏁᎲᎢ", english: "You had something liquid (singular)"],
            [object: 'PL3IN', pronoun: "Second Singular", romanized: "detsanehv'i", syllabary: "ᏕᏣᏁᎲᎢ", english: "You had multiple liquid things"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "unehv'i", syllabary: "ᎤᏁᎲᎢ", english: "He/she/it had something liquid (singular)"],
            [object: 'PL3IN', pronoun: "Third Singular", romanized: "dunehv'i", syllabary: "ᏚᏁᎲᎢ", english: "He/she/it had multiple liquid things"],
            [object: 'SG3IN', pronoun: "Second Dual", romanized: "sdinehv'i", syllabary: "ᏍᏗᏁᎲᎢ", english: "You (two) had something liquid (singular)"],
            [object: 'PL3IN', pronoun: "Second Dual", romanized: "desdinehv'i", syllabary: "ᏕᏍᏗᏁᎲᎢ", english: "You (two) had multiple liquid things"],
            [object: 'SG3IN', pronoun: "Second Plural", romanized: "itsinehv'i", syllabary: "ᎢᏥᏁᎲᎢ", english: "You (more than two) had something liquid (singular)"],
            [object: 'PL3IN', pronoun: "Second Plural", romanized: "detsinehv'i", syllabary: "ᏕᏥᏁᎲᎢ", english: "You (more than two) had multiple liquid things"],
            [object: 'SG3IN', pronoun: "First Dual Inclusive", romanized: "gininehv'i", syllabary: "ᎩᏂᏁᎲᎢ", english: "We (you and I) had something liquid (singular)"],
            [object: 'PL3IN', pronoun: "First Dual Inclusive", romanized: "degininehv'i", syllabary: "ᏕᎩᏂᏁᎲᎢ", english: "We (you and I) had multiple liquid things"],
            [object: 'SG3IN', pronoun: "First Dual Exclusive", romanized: "ogininehv'i", syllabary: "ᎣᎩᏂᏁᎲᎢ", english: "We (another and I) had something liquid (singular)"],
            [object: 'PL3IN', pronoun: "First Dual Exclusive", romanized: "dogininehv'i", syllabary: "ᏙᎩᏂᏁᎲᎢ", english: "We (another and I) had multiple liquid things"],
            [object: 'SG3IN', pronoun: "First Plural Exclusive", romanized: "oginehv'i", syllabary: "ᎣᎩᏁᎲᎢ", english: "We (others and I) had something liquid (singular)"],
            [object: 'PL3IN', pronoun: "First Plural Exclusive", romanized: "doginehv'i", syllabary: "ᏙᎩᏁᎲᎢ", english: "We (others and I) had multiple liquid things"],
            [object: 'SG3IN', pronoun: "First Plural Inclusive", romanized: "iginehv'i", syllabary: "ᎢᎩᏁᎲᎢ", english: "We (you and I and another or others) had something liquid (singular)"],
            [object: 'PL3IN', pronoun: "First Plural Inclusive", romanized: "deginehv'i", syllabary: "ᏕᎩᏁᎲᎢ", english: "We (you and I and another or others) had multiple liquid things"],
            [object: 'SG3IN', pronoun: "Third Plural", romanized: "uninehv'i", syllabary: "ᎤᏂᏁᎲᎢ", english: "They had something liquid (singular)"],
            [object: 'PL3IN', pronoun: "Third Plural", romanized: "duninehv'i", syllabary: "ᏚᏂᏁᎲᎢ", english: "They had multiple liquid things"],
    ]

    /**
     * Hook for the conjugation-engine comparison (to be wired in later).
     * Today it echoes the verb-book form; replace the body with a call into
     * the conjugation engine when the engine-vs-verb-book refinement begins.
     */
    Map conjugate(String pronoun, String romanized) {
        def row = VERB_BOOK.find { it.pronoun == pronoun && it.romanized == romanized }
        return [romanized: row.romanized, syllabary: row.syllabary]
    }

    def "immediate past form matches the verb book (#row.pronoun #row.romanized)"() {
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
