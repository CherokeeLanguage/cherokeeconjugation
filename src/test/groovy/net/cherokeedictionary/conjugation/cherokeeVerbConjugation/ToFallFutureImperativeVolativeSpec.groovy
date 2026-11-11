package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Fall (a living being)" — Future Imperative/Volative (Stem III).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.33
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III: -nv-ts-
 *   Future Imperative/Volative: -nvts-v'i
 *
 * Verb-book note: "Sometime in the future, but not right now."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToFallFutureImperativeVolativeSpec extends VerbBaseSpec {

    static final String VERB = "to fall (a living being)"
    static final String TENSE = "FUTURE_IMPERATIVE_VOLATIVE"
    static final String SOURCE_PAGE = "p.33"

    // Affix composition as printed:
    static final String STEM = "-nv-ts-"        // Stem III
    static final String TENSE_FORM = "-nvts-v'i"  // Future Imperative/Volative (Stem III)

    static final String VERB_BOOK_NOTE =
        "Sometime in the future, but not right now."

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "tsinvtsv'i", syllabary: "ᏥᏅᏨᎢ", english: "May I fall!"],
            [pronoun: "Second Singular", romanized: "hinvtsv'i", syllabary: "ᎯᏅᏨᎢ", english: "May you fall!"],
            [pronoun: "Third Singular", romanized: "ganvtsv'i", syllabary: "ᎦᏅᏨᎢ", english: "May s/he fall!"],
            [pronoun: "Second Dual", romanized: "desdinvtsv'i", syllabary: "ᏕᏍᏗᏅᏨᎢ", english: "May you (two) fall!"],
            [pronoun: "Second Plural", romanized: "detsinvtsv'i", syllabary: "ᏕᏥᏅᏨᎢ", english: "May you (more than two) fall!"],
            [pronoun: "First Dual Inclusive", romanized: "deninvtsv'i", syllabary: "ᏕᏂᏅᏨᎢ", english: "May we (you and I) fall!"],
            [pronoun: "First Dual Exclusive", romanized: "dosdinvtsv'i", syllabary: "ᏙᏍᏗᏅᏨᎢ", english: "May we (another and I) fall!"],
            [pronoun: "First Plural Exclusive", romanized: "dotsinvtsv'i", syllabary: "ᏙᏥᏅᏨᎢ", english: "May we (others and I) fall!"],
            [pronoun: "First Plural Inclusive", romanized: "dedinvtsv'i", syllabary: "ᏕᏗᏅᏨᎢ", english: "May we (you and I and another or others) fall!"],
            [pronoun: "Third Plural Form", romanized: "daninvtsv'i", syllabary: "ᏓᏂᏅᏨᎢ", english: "May they fall!"],
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
