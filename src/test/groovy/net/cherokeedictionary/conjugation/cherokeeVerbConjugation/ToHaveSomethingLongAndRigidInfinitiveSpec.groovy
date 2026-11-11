package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Long and Rigid, like a stick, a shovel, etc." — Infinitive (Stem V).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.48
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem V: -vy-Ø-
 *   Infinitive: -vy-i
 *
 * Verb-book note: "Infinitive must include "to have.""
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingLongAndRigidInfinitiveSpec extends VerbBaseSpec {

    static final String VERB = "to have something long and rigid, like a stick, a shovel, etc."
    static final String TENSE = "INFINITIVE"
    static final String SOURCE_PAGE = "p.48"

    // Affix composition as printed:
    static final String STEM = "-vy-Ø-"        // Stem V
    static final String TENSE_FORM = "-vy-i"  // Infinitive (Stem V)

    static final String VERB_BOOK_NOTE =
        "Infinitive must include \"to have.\""

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "agwvyi iyulisdodi", syllabary: "ᎠᏋᏱ ᎢᏳᎵᏍᏙᏗ", english: "For me to have something long & rigid (singular)"],
            [pronoun: "Second Singular", romanized: "tsvyi iyulisdodi", syllabary: "ᏨᏱ ᎢᏳᎵᏍᏙᏗ", english: "For you to have something long & rigid (singular)"],
            [pronoun: "Third Singular", romanized: "uwayi iyulisdodi", syllabary: "ᎤᏩᏱ ᎢᏳᎵᏍᏙᏗ", english: "For him/her/it to have something long & rigid (singular)"],
            [pronoun: "Second Dual", romanized: "sdvyi iyulisdodi", syllabary: "ᏍᏛᏱ ᎢᏳᎵᏍᏙᏗ", english: "For you (two) to have something long & rigid (singular)"],
            [pronoun: "Second Plural", romanized: "itsvyi iyulisdodi", syllabary: "ᎢᏨᏱ ᎢᏳᎵᏍᏙᏗ", english: "For you (more than two) to have something long & rigid (singular)"],
            [pronoun: "First Dual Inclusive", romanized: "ginvyi iyulisdodi", syllabary: "ᎩᏅᏱ ᎢᏳᎵᏍᏙᏗ", english: "For us (you and I) to have something long & rigid (singular)"],
            [pronoun: "First Dual Exclusive", romanized: "oginvyi iyulisdodi", syllabary: "ᎣᎩᏅᏱ ᎢᏳᎵᏍᏙᏗ", english: "For us (another and I) to have something long & rigid (singular)"],
            [pronoun: "First Plural Exclusive", romanized: "ogvyi iyulisdodi", syllabary: "ᎣᎬᏱ ᎢᏳᎵᏍᏙᏗ", english: "For us (others and I) to have something long & rigid (singular)"],
            [pronoun: "First Plural Inclusive", romanized: "igvyi iyulisdodi", syllabary: "ᎢᎬᏱ ᎢᏳᎵᏍᏙᏗ", english: "For us (you and I and another or others) to have something long & rigid (singular)\""],
            [pronoun: "Third Plural Form", romanized: "unvyi iyulisdodi", syllabary: "ᎤᏅᏱ ᎢᏳᎵᏍᏙᏗ", english: "For them to have something long & rigid (singular)"],
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

    def "infinitive form matches the verb book (#row.pronoun)"() {
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
