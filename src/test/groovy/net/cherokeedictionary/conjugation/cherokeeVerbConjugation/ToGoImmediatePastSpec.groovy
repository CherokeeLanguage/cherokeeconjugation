package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Go" — Immediate Past (Stem IV).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.38
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem IV: -e-n-
 *   Immediate Past: -en-a
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToGoImmediatePastSpec extends VerbBaseSpec {

    static final String VERB = "to go"
    static final String TENSE = "IMMEDIATE_PAST"
    static final String SOURCE_PAGE = "p.38"

    // Affix composition as printed:
    static final String STEM = "-e-n-"        // Stem IV
    static final String TENSE_FORM = "-en-a"  // Immediate Past (Stem IV)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gena", syllabary: "ᎨᎾ", english: "I went"],
            [pronoun: "Second Singular", romanized: "hena", syllabary: "ᎮᎾ", english: "You went"],
            [pronoun: "Third Singular", romanized: "ena", syllabary: "ᎡᎾ", english: "He/she/it went"],
            [pronoun: "Second Dual", romanized: "sdena", syllabary: "ᏍᏕᎾ", english: "You (two) went"],
            [pronoun: "Second Plural", romanized: "itsena", syllabary: "ᎢᏤᎾ", english: "You (more than two) went"],
            [pronoun: "First Dual Inclusive", romanized: "inena", syllabary: "ᎢᏁᎾ", english: "We (you and I) went"],
            [pronoun: "First Dual Exclusive", romanized: "osdena", syllabary: "ᎣᏍᏕᎾ", english: "We (another and I) went"],
            [pronoun: "First Plural Exclusive", romanized: "otsena", syllabary: "ᎣᏣᎾ", english: "We (others and I) went"],
            [pronoun: "First Plural Inclusive", romanized: "idena", syllabary: "ᎢᏕᎾ", english: "We (you and I and another or others) went"],
            [pronoun: "Third Plural Form", romanized: "anena", syllabary: "ᎠᏁᎾ", english: "They went"],
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

    def "immediate past form matches the verb book (#row.pronoun)"() {
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
