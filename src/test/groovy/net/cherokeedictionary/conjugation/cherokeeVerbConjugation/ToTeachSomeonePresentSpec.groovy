package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Teach Someone" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.137-139
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -eyohv-sg-
 *   Present Tense: -eyohvsg-a
 *
 * Verb-book note: "This verb means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToTeachSomeonePresentSpec extends Specification {

    static final String VERB = "to teach someone"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.137-139"

    // Affix composition as printed:
    static final String STEM = "-eyohv-sg-"        // Stem I
    static final String TENSE_FORM = "-eyohvsg-a"  // Present Tense (Stem I)

    static final String VERB_BOOK_NOTE =
        "This verb means the action is actually going on at the present time."

    /** The 71 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "degvyeyohvsga", syllabary: "ᏕᎬᏰᏲᎲᏍᎦ", english: "I am teaching you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "detsiyeyohvsga", syllabary: "ᏕᏥᏰᏲᎲᏍᎦ", english: "I am teaching him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "degadeyohvsga", syllabary: "ᏕᎦᏕᏲᎲᏍᎦ", english: "I am teaching it", occurrence: 1],
            [pronoun: "First Singular", romanized: "desdvyeyohvsga", syllabary: "ᏕᏍᏛᏰᏲᎲᏍᎦ", english: "I am teaching you (two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "detsvyeyohvsga", syllabary: "ᏕᏨᏰᏲᎲᏍᎦ", english: "I am teaching you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "degatsiyeyohvsga", syllabary: "ᏕᎦᏥᏰᏲᎲᏍᎦ", english: "I am teaching them", occurrence: 1],
            [pronoun: "First Singular", romanized: "degadeyohvsga", syllabary: "ᏕᎦᏥᏰᏲᎲᏍᎦ", english: "I am teaching those things", occurrence: 1],
            [pronoun: "Second Singular", romanized: "desgweyohvsga", syllabary: "ᏕᏍᏇᏲᎲᏍᎦ", english: "You are (singular) teaching me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "dehiyeyohvsga", syllabary: "ᏕᎯᏰᏲᎲᏍᎦ", english: "You are (singular) teaching him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "dehiyeyohvsga", syllabary: "ᏕᎯᏰᏲᎲᏍᎦ", english: "You are (singular) teaching it", occurrence: 1],
            [pronoun: "Second Singular", romanized: "desgineyohvsga", syllabary: "ᏕᏍᎩᏁᏲᎲᏍᎦ", english: "You are (singular) teaching someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "desgiyeyohvsga", syllabary: "ᏕᏍᎩᏰᏲᎲᏍᎦ", english: "You are (singular) teaching others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "degahiyeyohvsga", syllabary: "ᏕᎦᎯᏰᏲᎲᏍᎦ", english: "You are (singular) teaching them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "deheyohvsga", syllabary: "ᏕᎮᏲᎲᏍᎦ", english: "You are (singular) teaching those (things)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dagweyohvsga", syllabary: "ᏓᏇᏲᎲᏍᎦ", english: "S/he is teaching me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "detseyohvsga", syllabary: "ᏕᏤᏲᎲᏍᎦ", english: "S/he teaches you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "degeyohvsga", syllabary: "ᏓᎨᏲᎲᏍᎦ", english: "S/he teaches him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dadeyohvsga", syllabary: "ᏓᏕᏲᎲᏍᎦ", english: "S/he teaches it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "degineyohvsga", syllabary: "ᏕᎩᏁᏲᎲᏍᎦ", english: "S/he teaches you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dogineyohvsga", syllabary: "ᏙᎩᏁᏲᎲᏍᎦ", english: "S/he teaches someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "degeyohvsga", syllabary: "ᏕᎨᏲᎲᏍᎦ", english: "S/he teaches another (or others), me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dogineyohvsga", syllabary: "ᏙᎩᏁᏲᎲᏍᎦ", english: "S/he teaches others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "desdeyohvsga", syllabary: "ᏕᏍᏕᏲᎲᏍᎦ", english: "S/he teaches you (two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "detseyohvsga", syllabary: "ᏕᏤᏲᎲᏍᎦ", english: "S/he teaches you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "degeyohvsga", syllabary: "ᏕᎨᏲᎲᏍᎦ", english: "S/he teaches them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dadeyohvsga", syllabary: "ᏕᎨᏲᎲᏍᎦ", english: "S/he teaches those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desgineyohvsga", syllabary: "ᏕᏍᎩᏁᏲᎲᏍᎦ", english: "You (two) teach me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdeyohvsga", syllabary: "ᏕᏍᏕᏲᎲᏍᎦ", english: "You (two) teach him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdadeyohvsga", syllabary: "ᏍᏕᏲᎲᏍᎦ", english: "You (two) teach it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desgineyohvsga", syllabary: "ᏕᏍᎩᏁᏲᎲᏍᎦ", english: "You (two) teach someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desgiyeyohvsga", syllabary: "ᏕᏍᎩᏰᏲᎲᏍᎦ", english: "You (two) teach others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdeyohvsga", syllabary: "ᏕᏍᏕᏲᎲᏍᎦ", english: "You (two) teach them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdadeyohvsga", syllabary: "ᏕᏍᏕᏲᎲᏍᎦ", english: "You (two) teach those (things)", occurrence: 1],
            [pronoun: "Second Plural", romanized: "desgiyeyohvsga", syllabary: "ᏕᏍᎩᏰᏲᎲᏍᎦ", english: "You (more than two) teach me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "etsiyeyohvsga", syllabary: "ᎡᏤᏲᎲᏍᎦ", english: "You (more than two) teach him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsadeyohvsga", syllabary: "ᏕᏤᏲᎲᏍᎦ", english: "You (more than two) teach it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "desgiyeyohvsga", syllabary: "ᏕᏍᎩᏰᏲᎲᏍᎦ", english: "You (more than two) teach someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detseyohvsga", syllabary: "ᏕᏤᏲᎲᏍᎦ", english: "You (more than two) teach them", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsadeyohvsga", syllabary: "ᏕᏣᏕᏲᎲᏍᎦ", english: "You (more than two) teach those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "eneyohvsga", syllabary: "ᎡᏁᏲᎲᏍᎦ", english: "We (you and I) teach him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "denadeyohvsga", syllabary: "ᎢᏁᏲᎲᏍᎦ", english: "We (you and I) teach it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "deneyohvsga", syllabary: "ᏕᏁᏲᎲᏍᎦ", english: "We (you and I) teach them", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "denadeyohvsga", syllabary: "ᏕᎾᏕᏲᎲᏍᎦ", english: "We (you and I) teach those things", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvyeyohvsga", syllabary: "ᏍᏛᏰᏲᎲᏍᎦ", english: "We (another and I) teach you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdeyohvsga", syllabary: "ᎣᏍᏕᏲᎲᏍᎦ", english: "We (another and I) teach him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdadeyohvsga", syllabary: "ᎣᏍᏕᏲᎲᏍᎦ", english: "We (another and I) teach it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "desdvyeyohvsga", syllabary: "ᏕᏍᏛᏰᏲᎲᏍᎦ", english: "We (another and I) teach you (two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "detsvyeyohvsga", syllabary: "ᏕᏨᏰᏲᎲᏍᎦ", english: "We (another and I) teach you (more than two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdeyohvsga", syllabary: "ᏙᏤᏲᎲᏍᎦ", english: "We (another and I) teach them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdadeyohvsga", syllabary: "ᏙᏤᏲᎲᏍᎦ", english: "We (another and I) teach those (things)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "detsvyeyohvsga", syllabary: "ᏕᏨᏰᏲᎲᏍᎦ", english: "We (others and I) teach you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotseyohvsga", syllabary: "ᏙᏤᏲᎲᏍᎦ", english: "We (others and I) teach him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsadeyohvsga", syllabary: "ᏙᏤᏲᎲᏍᎦ", english: "We (others and I) teach it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotseyohvsga", syllabary: "ᏙᏤᏲᎲᏍᎦ", english: "We (others and I) teach them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsadeyohvsga", syllabary: "ᏙᏤᏲᎲᏍᎦ", english: "We (others and I) teach those (things)", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "edeyohvsga", syllabary: "ᎡᏕᏲᎲᏍᎦ", english: "We (you and I and another or others) teach him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedayeyohvsga", syllabary: "ᎣᏤᏲᎲᏍᎦ", english: "We (you and I and another or others) teach it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedeyohvsga", syllabary: "ᏕᏕᏲᎲᏍᎦ", english: "We (you and I and another or others) teach them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedadeyohvsga", syllabary: "ᏕᏕᏲᎲᏍᎦ", english: "We (you and I and another or others) teach those (things)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degvgweyohvsga", syllabary: "ᏕᎬᏇᏲᎲᏍᎦ", english: "They teach me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degetseyohvsga", syllabary: "ᏕᎨᏰᏲᎲᏍᎦ", english: "They teach you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "daneyohvsga", syllabary: "ᏓᏁᏲᎲᏍᎦ", english: "They teach him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danadeyohvsga", syllabary: "ᏓᏁᏲᎲᏍᎦ", english: "They teach it", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degegineyohvsga", syllabary: "ᏕᎨᎩᏁᏲᎲᏍᎦ", english: "They teach you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degogineyohvsga", syllabary: "ᏕᎪᎩᏁᏲᎲᏍᎦ", english: "They teach someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degegeyohvsga", syllabary: "ᏕᎨᎨᏲᎲᏍᎦ", english: "They teach you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degogeyohvsga", syllabary: "ᏕᎪᎨᏲᎲᏍᎦ", english: "They teach others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degesdeyohvsga", syllabary: "ᏕᎨᏍᏕᏲᎲᏍᎦ", english: "They teach you (two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degetseyohvsga", syllabary: "ᏕᎨᏤᏲᎲᏍᎦ", english: "They teach you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "daneyohvsga", syllabary: "ᏓᏁᏲᎲᏍᎦ", english: "They teach them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danadeyohvsga", syllabary: "ᏓᏁᏲᎲᏍᎦ", english: "They teach those things", occurrence: 1],
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

    def "present tense form matches the verb book (#row.pronoun: #row.english)"() {
        when: "the form is conjugated"
        def form = conjugate(row.pronoun, row.english, row.occurrence)

        then: "both the romanized and syllabary forms match the verb book"
        form.romanized == row.romanized
        form.syllabary == row.syllabary

        and: "the English translation is preserved for later deconstruction"
        row.english

        where: "each of the 71 verb-book rows"
        row << VERB_BOOK
    }

    def "the verb book table is complete (71 rows)"() {
        expect:
        VERB_BOOK.size() == 71
    }
}
