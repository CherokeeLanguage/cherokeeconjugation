package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Liquid, in a container" — Present Habitual (Stem II).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.58-59
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem II: -ne-h-
 *   Present Habitual: -neh-o'i
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingLiquidPresentHabitualSpec extends Specification {

    static final String VERB = "to have something liquid, in a container"
    static final String TENSE = "PRESENT_HABITUAL"
    static final String SOURCE_PAGE = "pp.58-59"

    // Affix composition as printed:
    static final String STEM = "-ne-h-"        // Stem II
    static final String TENSE_FORM = "-neh-o'i"  // Present Habitual (Stem II)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "I have multiple liquid things\" agineho'i/dagineho'i", syllabary: "ᎠᎩᏁᎰᎢ/ᏓᎩᏁᎰᎢ", english: "I have something liquid (singular)\"/"],
            [pronoun: "Second Singular", romanized: "You have multiple liquid things\" tsaneho'i/detsaneho'i", syllabary: "ᏣᏁᎰᎢ/ᏕᏣᏁᎰᎢ", english: "You have something liquid (singular)\"/"],
            [pronoun: "Third Singular", romanized: "He/she/it has multiple liquid things\" uneho'i/duneho'i", syllabary: "ᎤᏁᎰᎢ/ᏚᏁᎰᎢ", english: "He/she/it has something liquid (singular)\"/"],
            [pronoun: "Second Dual", romanized: "You (two) have multiple liquid things\" sdineho'i/desdineho'i", syllabary: "ᏍᏗᏁᎰᎢ/ᏕᏍᏗᏁᎰᎢ", english: "You (two) have something liquid (singular)\"/"],
            [pronoun: "Second Plural", romanized: "itsineho'i/detsineho'i", syllabary: "ᎢᏥᏁᎰᎢ/ᏕᏥᏁᎰᎢ", english: "You (more than two) have something liquid (singular)\"/\"You (more than two) have multiple liquid things\""],
            [pronoun: "First Dual Inclusive", romanized: "ginineho'i/deginineho'i", syllabary: "ᎩᏂᏁᎰᎢ/ᏕᎩᏂᏁᎰᎢ", english: "We (you and I) have something liquid (singular)\"/\"We (you and I) have multiple liquid things\""],
            [pronoun: "First Dual Exclusive", romanized: "oginineho'i/doginineho'i", syllabary: "ᎣᎩᏂᏁᎰᎢ/ᏙᎩᏂᏁᎰᎢ", english: "We (another and I) have something liquid (singular)\"/\"We (another and I) have multiple liquid things\""],
            [pronoun: "First Plural Exclusive", romanized: "ogineho'i/dogineho'i", syllabary: "ᎣᎩᏁᎰᎢ/ᏙᎩᏁᎰᎢ", english: "We (others and I) have something liquid (singular)\"/\"We (others and I) have multiple liquid things\""],
            [pronoun: "First Plural Inclusive", romanized: "igineho'i/degineho'i", syllabary: "ᎢᎩᏁᎰᎢ/ᏕᎩᏁᎰᎢ", english: "We (you and I and another or others) have something liquid (singular)\"/\"We (you and I and another or others) have multiple liquid things\""],
            [pronoun: "Third Plural Form", romanized: "They have multiple liquid things\" unineho'i/dunineho'i", syllabary: "ᎤᏂᏁᎰᎢ/ᏚᏂᏁᎰᎢ", english: "They have something liquid (singular)\"/"],
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

    def "present habitual form matches the verb book (#row.pronoun)"() {
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
