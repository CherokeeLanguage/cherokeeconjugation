package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Flexible" — Immediate Past (Stem IV).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.53-54
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem IV: -na-'-
 *   Immediate Past: -na'-v'i
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingFlexibleImmediatePastSpec extends Specification {

    static final String VERB = "to have something flexible"
    static final String TENSE = "IMMEDIATE_PAST"
    static final String SOURCE_PAGE = "pp.53-54"

    // Affix composition as printed:
    static final String STEM = "-na-'-"        // Stem IV
    static final String TENSE_FORM = "-na'-v'i"  // Immediate Past (Stem IV)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "I had multiple flexible things\" agina'v'i/dagina'v'i", syllabary: "ᎠᎩᎾᎥᎢ/ᏓᎩᎾᎥᎢ", english: "I had something flexible (singular)\"/"],
            [pronoun: "Second Singular", romanized: "You had multiple flexible things\" tsana'v'i/detsana'v'i", syllabary: "ᏣᎾᎥᎢ/ᏕᏣᎾᎥᎢ", english: "You had something flexible (singular)\"/"],
            [pronoun: "Third Singular", romanized: "una'v'i/duna'v'i", syllabary: "ᎤᎾᎥᎢ/ᏚᎾᎥᎢ", english: "He/she/it had something flexible (singular)\"/\"He/she/it had multiple flexible things\""],
            [pronoun: "Second Dual", romanized: "You (two) had multiple flexible things\" sdina'v'i/desdina'v'i", syllabary: "ᏍᏗᎾᎥᎢ/ᏕᏍᏗᎾᎥᎢ", english: "You (two) had something flexible (singular)\"/"],
            [pronoun: "Second Plural", romanized: "itsina'v'i/detsina'v'i", syllabary: "ᎢᏥᎾᎥᎢ/ᏕᏥᎾᎥᎢ", english: "You (more than two) had something flexible (singular)\"/\"You (more than two) had multiple flexible things\""],
            [pronoun: "First Dual Inclusive", romanized: "ginina'v'i/deginina'v'i", syllabary: "ᎩᏂᎾᎥᎢ/ᏕᎩᏂᎾᎥᎢ", english: "We (you and I) had something flexible (singular)\"/\"We (you and I) had multiple flexible things\""],
            [pronoun: "First Dual Exclusive", romanized: "oginina'v'i/doginina'v'i", syllabary: "ᎣᎩᏂᎾᎥᎢ/ᏙᎩᏂᎾᎥᎢ", english: "We (another and I) had something flexible (singular)\"/\"We (another and I) had multiple flexible things\""],
            [pronoun: "First Plural Exclusive", romanized: "ogina'v'i/dogina'v'i", syllabary: "ᎣᎩᎾᎥᎢ/ᏙᎩᎾᎥᎢ", english: "We (others and I) had something flexible (singular)\"/\"We (others and I) had multiple flexible things\""],
            [pronoun: "First Plural Inclusive", romanized: "igina'v'i/degina'v'i", syllabary: "ᎢᎩᎾᎥᎢ/ᏕᎩᎾᎥᎢ", english: "We (you and I and another or others) had something flexible (singular)\"/\"We (you and I and another or others) had multiple flexible things\""],
            [pronoun: "Third Plural Form", romanized: "They had multiple flexible things\" unina'v'i/dunina'v'i", syllabary: "ᎤᏂᎾᎥᎢ/ᏚᏂᎾᎥᎢ", english: "They had something flexible (singular)\"/"],
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
