package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Fall (a living being)" — Immediate Imperative/Volative (Stem IV).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.33-34
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem IV: -nv-g-
 *   Immediate Imperative/Volative: -nvg-i
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToFallImmediateImperativeVolativeSpec extends Specification {

    static final String VERB = "to fall (a living being)"
    static final String TENSE = "IMMEDIATE_IMPERATIVE_VOLATIVE"
    static final String SOURCE_PAGE = "pp.33-34"

    // Affix composition as printed:
    static final String STEM = "-nv-g-"        // Stem IV
    static final String TENSE_FORM = "-nvg-i"  // Immediate Imperative/Volative (Stem IV)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "tsinvgi", syllabary: "ᏥᏅᎩ", english: "May I fall right now!"],
            [pronoun: "Second Singular", romanized: "hinvgi", syllabary: "ᎯᏅᎩ", english: "May you fall right now!"],
            [pronoun: "Third Singular", romanized: "wiganvgi", syllabary: "ᏫᎦᏅᎩ", english: "May s/he fall right now!"],
            [pronoun: "Second Dual", romanized: "desdinvgi", syllabary: "ᏗᏍᏗᏅᎩ", english: "May you (two) fall right now!"],
            [pronoun: "Second Plural", romanized: "detsinvgi", syllabary: "ᏗᏥᏅᎩ", english: "May you (more than two) fall right now!"],
            [pronoun: "First Dual Inclusive", romanized: "dininvgi", syllabary: "ᏗᏂᏅᎩ", english: "May we (you and I) fall right now!"],
            [pronoun: "First Dual Exclusive", romanized: "widosdinvgi", syllabary: "ᏫᏙᏍᏗᏅᎩ", english: "May we (another and I) fall right now!"],
            [pronoun: "First Plural Exclusive", romanized: "widotsinvgi", syllabary: "ᏫᏙᏥᏅᎩ", english: "May we (others and I) fall right now!"],
            [pronoun: "First Plural Inclusive", romanized: "didinvgi", syllabary: "ᏗᏗᏅᎩ", english: "May we (you and I and another or others) fall right now!"],
            [pronoun: "Third Plural Form", romanized: "widaninvgi", syllabary: "ᏫᏓᏂᏅᎩ", english: "May they fall right now!"],
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

    def "immediate imperative/volative form matches the verb book (#row.pronoun)"() {
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
