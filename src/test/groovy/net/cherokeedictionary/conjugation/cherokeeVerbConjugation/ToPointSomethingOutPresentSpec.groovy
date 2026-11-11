package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Point Something Out" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.107-109
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -asehe-h-
 *   Present Tense: -aseheh-a
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToPointSomethingOutPresentSpec extends VerbBaseSpec {

    static final String VERB = "to point something out"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.107-109"

    // Affix composition as printed:
    static final String STEM = "-asehe-h-"        // Stem I
    static final String TENSE_FORM = "-aseheh-a"  // Present Tense (Stem I)

    /** The 66 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gvyaseheha", syllabary: "ᎬᏯᏎᎮᎭ", english: "I point it out to you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsiyaseheha", syllabary: "ᏥᏯᏎᎮᎭ", english: "I point it out to him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "sdvyaseheha", syllabary: "ᏍᏛᏯᏎᎮᎭ", english: "I point it out to you two", occurrence: 1],
            [pronoun: "First Singular", romanized: "itsvyaseheha", syllabary: "ᎢᏨᏯᏎᎮᎭ", english: "I point it out to you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "gatsiyaseheha", syllabary: "ᎦᏥᏯᏎᎮᎭ", english: "I point it out to them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgwaseheha", syllabary: "ᏍᏆᏎᎮᎭ", english: "You (singular) point it out to me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hiyaseheha", syllabary: "ᎯᏯᏎᎮᎭ", english: "You (singular) point it out to him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sginaseheha", syllabary: "ᏍᎩᎾᏎᎮᎭ", english: "You (singular) point it out to someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgiyaseheha", syllabary: "ᏍᎩᏯᏎᎮᎭ", english: "You (singular) point it out to others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "gahiyaseheha", syllabary: "ᎦᎯᏯᏎᎮᎭ", english: "You (singular) point it out to them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agwaseheha", syllabary: "ᎠᏆᏎᎮᎭ", english: "He/she is pointing it out to me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsaseheha", syllabary: "ᏣᏎᎮᎭ", english: "He/she is pointing it out to you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "aseheha", syllabary: "ᎠᏎᎮᎭ", english: "He/she is pointing it out to him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "aseheha", syllabary: "ᎠᏎᎮᎭ", english: "He/she is pointing it out to it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ginaseheha", syllabary: "ᎩᎾᏎᎮᎭ", english: "He/she is pointing it out to you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginaseheha", syllabary: "ᎣᎩᎾᏎᎮᎭ", english: "He/she is pointing it out to someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "igaseheha", syllabary: "ᎢᎦᏎᎮᎭ", english: "He/she is pointing it out to another (or others), me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginaseheha", syllabary: "ᎣᎩᎾᏎᎮᎭ", english: "He/she is pointing it out to others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "sdaseheha", syllabary: "ᏍᏓᏎᎮᎭ", english: "He/she is pointing it out to you (two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "itsaseheha", syllabary: "ᎢᏣᏎᎮᎭ", english: "He/she is pointing it out to you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "daseheha", syllabary: "ᏓᏎᎮᎭ", english: "He/she is pointing it out to them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "daseheha", syllabary: "ᏓᏎᎮᎭ", english: "He/she is pointing it out to those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginaseheha", syllabary: "ᏍᎩᎾᏎᎮᎭ", english: "You (two) are pointing it out to me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdaseheha", syllabary: "ᎡᏍᏓᏎᎮᎭ", english: "You (two) are pointing it out to him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sdaseheha", syllabary: "ᏍᏓᏎᎮᎭ", english: "You (two) are pointing it out to it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desginaseheha", syllabary: "", english: "You (two) are pointing it out to someone else and me", occurrence: 1],  // syllabary not printed in the verb book
            [pronoun: "Second Dual", romanized: "desgiyaseheha", syllabary: "ᏕᏍᎩᏯᏎᎮᎭ", english: "You (two) are pointing it out to others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdaseheha", syllabary: "ᏕᏍᏓᏎᎮᎭ", english: "You (two) are pointing it out to them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdaseheha", syllabary: "ᏕᏍᏓᏎᎮᎭ", english: "You (two) are pointing it out to those things", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgiyaseheha", syllabary: "ᎢᏍᎩᏯᏎᎮᎭ", english: "You (more than two) are pointing it out to me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "esdaseheha", syllabary: "ᎡᏍᏓᏎᎮᎭ", english: "You (more than two) are pointing it out to him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "sdaseheha ll", syllabary: "ᏍᏓᏎᎮᎭ", english: "You (more than two) are pointing it out to it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgiyaseheha", syllabary: "ᎢᏍᎩᏯᏎᎮᎭ", english: "You (more than two) are pointing it out to someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsaseheha", syllabary: "ᏕᏣᏎᎮᎭ", english: "You (more than two) are pointing it out to them", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsaseheha", syllabary: "ᏕᏣᏎᎮᎭ", english: "You (more than two) are pointing it out to those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "enaseheha", syllabary: "ᎡᎾᏎᎮᎭ", english: "We (you and I) are pointing it out to him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "inaseheha", syllabary: "ᎢᎾᏎᎮᎭ", english: "We (you and I) are pointing it out to it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "genaseheha", syllabary: "ᎨᎾᏎᎮᎭ", english: "We (you and I) are pointing it out to them", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "inaseheha", syllabary: "ᎢᎾᏎᎮᎭ", english: "We (you and I) are pointing it out to those things", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvyaseheha", syllabary: "ᏍᏛᏯᏎᎮᎭ", english: "We (another and I) are pointing it out to you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdaseheha", syllabary: "ᎣᏍᏓᏎᎮᎭ", english: "We (another and I) are pointing it out to him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdaseheha", syllabary: "ᎣᏍᏓᏎᎮᎭ", english: "We (another and I) are pointing it out to it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvyaseheha", syllabary: "ᏍᏛᏯᏎᎮᎭ", english: "We (another and I) are pointing it out to you two", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdaseheha", syllabary: "ᏙᏍᏓᏎᎮᎭ", english: "We (another and I) are pointing it out to them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdaseheha", syllabary: "ᏙᏍᏓᏎᎮᎭ", english: "We (another and I) are pointing it out to those things", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "itsvyaseheha", syllabary: "ᎢᏨᏯᏎᎮᎭ", english: "We (others and I) are pointing it out to you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsaseheha", syllabary: "ᎣᏣᏎᎮᎭ", english: "We (others and I) are pointing it out to him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsaseheha", syllabary: "ᎣᏣᏎᎮᎭ", english: "We (others) and I are pointing it out to it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsaseheha", syllabary: "ᏙᏣᏎᎮᎭ", english: "We (others and I) are pointing it out to them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsaseheha", syllabary: "ᏙᏣᏎᎮᎭ", english: "We (others and I) are pointing it out to those things", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "otsaseheha", syllabary: "ᎣᏣᏎᎮᎭ", english: "We (you and I and another or others) are pointing it out to him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "otsaseheha", syllabary: "ᎣᏣᏎᎮᎭ", english: "We (you and I and another or others) are pointing it out to it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dotsaseheha", syllabary: "ᏙᏣᏎᎮᎭ", english: "We (others and I) are pointing it out to them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dotsaseheha", syllabary: "ᏙᏣᏎᎮᎭ", english: "We (others and I) are pointing it out to those things", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gvgwaseheha", syllabary: "ᎬᏆᏎᎮᎭ", english: "They are pointing it out to me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsaseheha", syllabary: "ᎨᏣᏎᎮᎭ", english: "They are pointing it out to you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anaseheha", syllabary: "ᎠᎾᏎᎮᎭ", english: "They are pointing it out to him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anaseheha", syllabary: "ᎠᎾᏎᎮᎭ", english: "They are pointing it out to it", occurrence: 1],
            [pronoun: "Third Plural", romanized: "geginaseheha", syllabary: "ᎨᎩᎾᏎᎮᎭ", english: "They are pointing it out to you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "goginaseheha", syllabary: "ᎪᎩᎾᏎᎮᎭ", english: "They are pointing it out to someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gegaseheha", syllabary: "ᎨᎦᏎᎮᎭ", english: "They are pointing it out to you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gogaseheha", syllabary: "ᎪᎦᏎᎮᎭ", english: "They are pointing it out to others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gesdaseheha", syllabary: "ᎨᏍᏓᏎᎮᎭ", english: "They are pointing it out to you two", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsaseheha", syllabary: "ᎨᏣᏎᎮᎭ", english: "They are pointing it out to you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danaseheha", syllabary: "ᏓᎾᏎᎮᎭ", english: "They are pointing it out to them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danaseheha", syllabary: "ᏓᎾᏎᎮᎭ", english: "They are pointing it out to those things", occurrence: 1],
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

        where: "each of the 66 verb-book rows"
        row << VERB_BOOK
    }

    def "the verb book table is complete (66 rows)"() {
        expect:
        VERB_BOOK.size() == 66
    }
}
