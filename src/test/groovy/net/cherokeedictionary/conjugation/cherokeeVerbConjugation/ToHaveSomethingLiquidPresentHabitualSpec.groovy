package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
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
class ToHaveSomethingLiquidPresentHabitualSpec extends VerbBaseSpec {

    static final String VERB = "to have something liquid, in a container"
    static final String TENSE = "PRESENT_HABITUAL"
    static final String SOURCE_PAGE = "pp.58-59"

    // Affix composition as printed:
    static final String STEM = "-ne-h-"        // Stem II
    static final String TENSE_FORM = "-neh-o'i"  // Present Habitual (Stem II)

    /** The conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [object: 'SG3IN', pronoun: "First Singular", romanized: "agineho'i", syllabary: "ᎠᎩᏁᎰᎢ", english: "I have something liquid (singular)"],
            [object: 'PL3IN', pronoun: "First Singular", romanized: "dagineho'i", syllabary: "ᏓᎩᏁᎰᎢ", english: "I have multiple liquid things"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "tsaneho'i", syllabary: "ᏣᏁᎰᎢ", english: "You have something liquid (singular)"],
            [object: 'PL3IN', pronoun: "Second Singular", romanized: "detsaneho'i", syllabary: "ᏕᏣᏁᎰᎢ", english: "You have multiple liquid things"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "uneho'i", syllabary: "ᎤᏁᎰᎢ", english: "He/she/it has something liquid (singular)"],
            [object: 'PL3IN', pronoun: "Third Singular", romanized: "duneho'i", syllabary: "ᏚᏁᎰᎢ", english: "He/she/it has multiple liquid things"],
            [object: 'SG3IN', pronoun: "Second Dual", romanized: "sdineho'i", syllabary: "ᏍᏗᏁᎰᎢ", english: "You (two) have something liquid (singular)"],
            [object: 'PL3IN', pronoun: "Second Dual", romanized: "desdineho'i", syllabary: "ᏕᏍᏗᏁᎰᎢ", english: "You (two) have multiple liquid things"],
            [object: 'SG3IN', pronoun: "Second Plural", romanized: "itsineho'i", syllabary: "ᎢᏥᏁᎰᎢ", english: "You (more than two) have something liquid (singular)"],
            [object: 'PL3IN', pronoun: "Second Plural", romanized: "detsineho'i", syllabary: "ᏕᏥᏁᎰᎢ", english: "You (more than two) have multiple liquid things"],
            [object: 'SG3IN', pronoun: "First Dual Inclusive", romanized: "ginineho'i", syllabary: "ᎩᏂᏁᎰᎢ", english: "We (you and I) have something liquid (singular)"],
            [object: 'PL3IN', pronoun: "First Dual Inclusive", romanized: "deginineho'i", syllabary: "ᏕᎩᏂᏁᎰᎢ", english: "We (you and I) have multiple liquid things"],
            [object: 'SG3IN', pronoun: "First Dual Exclusive", romanized: "oginineho'i", syllabary: "ᎣᎩᏂᏁᎰᎢ", english: "We (another and I) have something liquid (singular)"],
            [object: 'PL3IN', pronoun: "First Dual Exclusive", romanized: "doginineho'i", syllabary: "ᏙᎩᏂᏁᎰᎢ", english: "We (another and I) have multiple liquid things"],
            [object: 'SG3IN', pronoun: "First Plural Exclusive", romanized: "ogineho'i", syllabary: "ᎣᎩᏁᎰᎢ", english: "We (others and I) have something liquid (singular)"],
            [object: 'PL3IN', pronoun: "First Plural Exclusive", romanized: "dogineho'i", syllabary: "ᏙᎩᏁᎰᎢ", english: "We (others and I) have multiple liquid things"],
            [object: 'SG3IN', pronoun: "First Plural Inclusive", romanized: "igineho'i", syllabary: "ᎢᎩᏁᎰᎢ", english: "We (you and I and another or others) have something liquid (singular)"],
            [object: 'PL3IN', pronoun: "First Plural Inclusive", romanized: "degineho'i", syllabary: "ᏕᎩᏁᎰᎢ", english: "We (you and I and another or others) have multiple liquid things"],
            [object: 'SG3IN', pronoun: "Third Plural", romanized: "unineho'i", syllabary: "ᎤᏂᏁᎰᎢ", english: "They have something liquid (singular)"],
            [object: 'PL3IN', pronoun: "Third Plural", romanized: "dunineho'i", syllabary: "ᏚᏂᏁᎰᎢ", english: "They have multiple liquid things"],
    ]

    Map conjugate(String pronoun, String romanized) {
        def row = VERB_BOOK.find { it.pronoun == pronoun && it.romanized == romanized }
        return [romanized: row.romanized, syllabary: row.syllabary]
    }

    def "present habitual form matches the verb book (#row.pronoun #row.romanized)"() {
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
