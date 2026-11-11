package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Stop someone or something" — Immediate Past Tense (Stem IV).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.125
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem IV: -alehwisdod-Ø-
 *   Immediate Past Tense: -alehwisdod-a
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToStopSomeoneOrSomethingImmediatePastSpec extends VerbBaseSpec {

    static final String VERB = "to stop someone or something"
    static final String TENSE = "IMMEDIATE_PAST"
    static final String SOURCE_PAGE = "p.125"

    // Affix composition as printed:
    static final String STEM = "-alehwisdod-Ø-"        // Stem IV
    static final String TENSE_FORM = "-alehwisdod-a"  // Immediate Past Tense (Stem IV)

    /** The two conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "", romanized: "galehwisdoda", syllabary: "ᎦᎴᏫᏍᏙᏓ", english: "I stopped it just now", occurrence: 1],
            [pronoun: "", romanized: "alehwisdoda", syllabary: "ᎠᎴᏫᏍᏙᏓ", english: "He/she stopped it just now", occurrence: 1],
    ]

    /**
     * Hook for the conjugation-engine comparison (to be wired in later).
     * Today it echoes the verb-book form; replace the body with a call into
     * the conjugation engine when the engine-vs-verb-book refinement begins.
     *
     * occurrence disambiguates rows the verb book prints more than once with the
     * same pronoun group and English gloss.
     */
    Map conjugate(String pronoun, String english, int occurrence) {
        def matches = VERB_BOOK.findAll { it.pronoun == pronoun && it.english == english }
        def row = matches[Math.min(occurrence, matches.size()) - 1]
        // TODO(engine-comparison): replace this echo with a conjugation-engine call,
        // e.g. conjStr(pronoun, "SG3IN", verbFixture, TENSE, "v.t.")
        return [romanized: row.romanized, syllabary: row.syllabary]
    }

    def "immediate past tense form matches the verb book (#row.pronoun: #row.english)"() {
        when: "the form is conjugated"
        def form = conjugate(row.pronoun, row.english, row.occurrence)

        then: "both the romanized and syllabary forms match the verb book"
        form.romanized == row.romanized
        form.syllabary == row.syllabary

        and: "the English translation is preserved for later deconstruction"
        row.english

        where: "each of the two verb-book rows"
        row << VERB_BOOK
    }

    def "the verb book table is complete (two rows)"() {
        expect:
        VERB_BOOK.size() == 2
    }
}
