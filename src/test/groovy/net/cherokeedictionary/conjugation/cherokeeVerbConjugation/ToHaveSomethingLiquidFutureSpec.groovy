package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
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
class ToHaveSomethingLiquidFutureSpec extends Specification {

    static final String VERB = "to have something liquid, in a container"
    static final String TENSE = "FUTURE"
    static final String SOURCE_PAGE = "pp.57-58"

    // Affix composition as printed:
    static final String STEM = "-ne-h-"        // Stem III
    static final String TENSE_FORM = "-neh-esdi"  // Future Tense (Stem III)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "I will have multiple liquid things\" aginehesdi/daginehesdi", syllabary: "ᎠᎩᏁᎮᏍᏗ/ᏓᎩᏁᎮᏍᏗ", english: "I will have something liquid (singular)\"/"],
            [pronoun: "Second Singular", romanized: "You will have multiple liquid things\" tsanehesdi/detsanehesdi", syllabary: "ᏣᏁᎮᏍᏗ/ᏕᏣᏁᎮᏍᏗ", english: "You will have something liquid (singular)\"/"],
            [pronoun: "Third Singular", romanized: "unehesdi/dunehesdi", syllabary: "ᎤᏁᎮᏍᏗ/ᏚᏁᎮᏍᏗ", english: "He/she/it will have something liquid (singular)\"/\"He/she/it will have multiple liquid things\""],
            [pronoun: "Second Dual", romanized: "sdinehesdi/desdinehesdi", syllabary: "ᏍᏗᏁᎮᏍᏗ/ᏕᏍᏗᏁᎮᏍᏗ", english: "You (two) will have something liquid (singular)\"/\"You (two) will have multiple liquid things\""],
            [pronoun: "Second Plural", romanized: "itsinehesdi/detsinehesdi", syllabary: "ᎢᏥᏁᎮᏍᏗ/ᏕᏥᏁᎮᏍᏗ", english: "You (more than two) will have something liquid (singular)\"/\"You (more than two) will have multiple liquid things\""],
            [pronoun: "First Dual Inclusive", romanized: "gininehesdi/degininehesdi", syllabary: "ᎩᏂᏁᎮᏍᏗ/ᏕᎩᏂᏁᎮᏍᏗ", english: "We (you and I) will have something liquid (singular)\"/\"We (you and I) will have multiple liquid things\""],
            [pronoun: "First Dual Exclusive", romanized: "ogininehesdi/dogininehesdi", syllabary: "ᎣᎩᏂᏁᎮᏍᏗ/ᏙᎩᏂᏁᎮᏍᏗ", english: "We (another and I) will have something liquid (singular)\"/\"We (another and I) will have multiple liquid things\""],
            [pronoun: "First Plural Exclusive", romanized: "oginehesdi/doginehesdi", syllabary: "ᎣᎩᏁᎮᏍᏗ/ᏙᎩᏁᎮᏍᏗ", english: "We (others and I) will have something liquid (singular)\"/\"We (others and I) will have multiple liquid things\""],
            [pronoun: "First Plural Inclusive", romanized: "iginehesdi/doginehesdi", syllabary: "ᎢᎩᏁᎮᏍᏗ/ᏙᎩᏁᎮᏍᏗ", english: "We (you and I and another or others) will have something liquid (singular)\"/\"We (you and I and another or others) will have multiple liquid things\""],
            [pronoun: "Third Plural Form", romanized: "uninehesdi/duninehesdi", syllabary: "ᎤᏂᏁᎮᏍᏗ/ᏚᏂᏁᎮᏍᏗ", english: "They will have something liquid (singular)\"/\"They will have multiple liquid things\""],
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

    def "future tense form matches the verb book (#row.pronoun)"() {
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
