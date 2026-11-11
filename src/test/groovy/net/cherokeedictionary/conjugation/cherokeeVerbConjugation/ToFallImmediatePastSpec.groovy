package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Fall (a living being)" — Immediate Past (Stem IV).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.34
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem IV: -nv-g-
 *   Immediate Past: -nvg-i
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToFallImmediatePastSpec extends VerbBaseSpec {

    static final String VERB = "to fall (a living being)"
    static final String TENSE = "IMMEDIATE_PAST"
    static final String SOURCE_PAGE = "p.34"

    // Affix composition as printed:
    static final String STEM = "-nv-g-"        // Stem IV
    static final String TENSE_FORM = "-nvg-i"  // Immediate Past (Stem IV)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "tsinvgi", syllabary: "ᏥᏅᎩ", english: "I fell"],
            [pronoun: "Second Singular", romanized: "hinvgi", syllabary: "ᎯᏅᎩ", english: "You fell"],
            [pronoun: "Third Singular", romanized: "ganvgi", syllabary: "ᎦᏅᎩ", english: "S/he fell"],
            [pronoun: "Second Dual", romanized: "desdinvgi", syllabary: "ᏕᏍᏗᏅᎩ", english: "You (two) fell"],
            [pronoun: "Second Plural", romanized: "detsinvgi", syllabary: "ᏕᏥᏅᎩ", english: "You (more than two) fell"],
            [pronoun: "First Dual Inclusive", romanized: "deninvgi", syllabary: "ᏕᏂᏅᎩ", english: "We (you and I) fell"],
            [pronoun: "First Dual Exclusive", romanized: "dosdinvgi", syllabary: "ᏙᏍᏗᏅᎩ", english: "We (another and I) fell"],
            [pronoun: "First Plural Exclusive", romanized: "dotsinvgi", syllabary: "ᏙᏥᏅᎩ", english: "We (others and I) fell"],
            [pronoun: "First Plural Inclusive", romanized: "dedinvgi", syllabary: "ᏕᏗᏅᎩ", english: "We (you and I and another or others) fell"],
            [pronoun: "Third Plural Form", romanized: "daninvgi", syllabary: "ᏓᏂᏅᎩ", english: "They fell"],
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
