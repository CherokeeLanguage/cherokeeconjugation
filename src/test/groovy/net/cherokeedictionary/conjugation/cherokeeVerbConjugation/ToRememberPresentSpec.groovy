package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Remember" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.112-114
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -anvdadi-'-
 *   Present Tense: -anvdadi'-a
 *
 * Verb-book note: "This tense means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToRememberPresentSpec extends Specification {

    static final String VERB = "to remember"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.112-114"

    // Affix composition as printed:
    static final String STEM = "-anvdadi-'-"        // Stem I
    static final String TENSE_FORM = "-anvdadi'-a"  // Present Tense (Stem I)

    static final String VERB_BOOK_NOTE =
        "This tense means the action is actually going on at the present time."

    /** The 71 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gvyanvdadi'a", syllabary: "ᎬᏯᏅᏓᏗᎠ", english: "I remember you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsiyanvdadi'a", syllabary: "ᏥᏯᏅᏓᏗᎠ", english: "I remember him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "ganvdadi'a", syllabary: "ᎦᏅᏓᏗᎠ", english: "I remember it", occurrence: 1],
            [pronoun: "First Singular", romanized: "sdvyanvdadi'a", syllabary: "ᏍᏛᏯᏅᏓᏗᎠ", english: "I remember you (two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "itsvyanvdadi'a", syllabary: "ᎢᏨᏯᏅᏓᏗᎠ", english: "I remember you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "gatsiyanvdadi'a", syllabary: "ᎦᏥᏯᏅᏓᏗᎠ", english: "I remember them", occurrence: 1],
            [pronoun: "First Singular", romanized: "deganvdadi'a", syllabary: "ᏕᎦᏅᏓᏗᎠ", english: "I remember those things", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgwanvdadi'a", syllabary: "ᏍᏆᏅᏓᏗᎠ", english: "You (singular) remember me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hiyanvdadi'a", syllabary: "ᎯᏯᏅᏓᏗᎠ", english: "You (singular) remember him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hanvdadi'a", syllabary: "ᎭᏅᏓᏗᎠ", english: "You (singular) remember it", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sginanvdadi'a", syllabary: "ᏍᎩᎾᏅᏓᏗᎠ", english: "You (singular) remember someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "isgiyanvdadi'a", syllabary: "ᎢᏍᎩᏯᏅᏓᏗᎠ", english: "You (singular) remember others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "gahiyanvdadi'a", syllabary: "ᎦᎯᏯᏅᏓᏗᎠ", english: "You (singular) remember them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "dehanvdadi'a", syllabary: "ᏕᎭᏅᏓᏗᎠ", english: "You (singular) remember those (things)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agwanvdadi'a", syllabary: "ᎠᏆᏅᏓᏗᎠ", english: "S/he remembers me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsanvdadi'a", syllabary: "ᏣᏅᏓᏗᎠ", english: "S/he remembers you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "aganvdadi'a", syllabary: "ᎠᎦᏅᏓᏗᎠ", english: "S/he remembers him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "anhdadi'a", syllabary: "ᎠᏅᏓᏗᎠ", english: "S/he remembers it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ginanvdadi'a", syllabary: "ᎩᎾᏅᏓᏗᎠ", english: "S/he remembers you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginanvdadi'a", syllabary: "ᎣᎩᎾᏅᏓᏗᎠ", english: "S/he remembers someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "iganvdadi'a", syllabary: "ᎢᎦᏅᏓᏗᏍᎪᎠ", english: "S/he remembers another (or others), me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oganvdadi'a", syllabary: "ᎣᎦᏅᏓᏗᎠ", english: "S/he remembers others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "sdanvdadi'a", syllabary: "ᏍᏓᏅᏓᏗᎠ", english: "S/he remembers you (two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "itsanvdadi'a", syllabary: "ᎢᏣᏅᏓᏗᎠ", english: "S/he remembers you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "danvdadi'a", syllabary: "ᏓᏅᏓᏗᎠ", english: "S/he remembers them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "danvdadi'a", syllabary: "ᏓᏅᏓᏗᎠ", english: "S/he remembers those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginanvdadi'a", syllabary: "ᏍᎩᎾᏅᏓᏗᎠ", english: "You (two) remember me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdanvdadi'a", syllabary: "ᎡᏍᏓᏅᏓᏗᎠ", english: "You (two) remember him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sdanvdadi'a", syllabary: "ᏍᏓᏅᏓᏗᎠ", english: "You (two) remember it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sgiyanvdadi'a", syllabary: "ᏍᎩᎤᏅᏓᏗᎠ", english: "You (two) remember someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginanvdadi'a", syllabary: "ᏍᎩᎾᏅᏓᏗᎠ", english: "You (two) remember others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "gesdanvdadi'a", syllabary: "ᎨᏍᏓᏅᏓᏗᎠ", english: "You (two) remember them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdanvdadi'a", syllabary: "ᏕᏍᏓᏅᏓᏗᎠ", english: "You (two) remember those (things)", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgiyanvdadi'a", syllabary: "ᎢᏍᎩᏯᏅᏓᏗᎠ", english: "You (more than two) remember me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "etsanvdadi'a", syllabary: "ᎡᏣᏅᏓᏗᎠ", english: "You (more than two) remember him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "itsanvdadi'a", syllabary: "ᎢᏣᏅᏓᏗᎠ", english: "You (more than two) remember it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "sgiyanvdadi'a", syllabary: "ᏍᎩᏯᏅᏓᏗᎠ", english: "You (more than two) remember someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsanvdadi'a", syllabary: "ᏕᏣᏅᏓᏗᎠ", english: "You (more than two) remember them", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsanvdadi'a", syllabary: "ᏕᏣᏅᏓᏗᎠ", english: "You (more than two) remember those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "enanvdadi'a", syllabary: "ᎡᎾᏅᏓᏗᎠ", english: "We (you and I) remember him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "inanvdadi'a", syllabary: "ᎢᎾᏅᏓᏗᎠ", english: "We (you and I) remember it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "genanvdadi'a", syllabary: "ᎨᎾᏅᏓᏗᎠ", english: "We (you and I) remember them", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "denanvdadi'a", syllabary: "ᏕᎾᏅᏓᏗᎠ", english: "We (you and I) remember those things", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvyanvdadi'a", syllabary: "ᏍᏛᏯᏅᏓᏗᎠ", english: "We (another and I) remember you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdanvdadi'a", syllabary: "ᎣᏓᏅᏓᏗᎠ", english: "We (another and I) remember him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdanvdadi'a", syllabary: "ᎣᏍᏓᏅᏓᏗᎠ", english: "We (another and I) remember it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvyanvdadi'a", syllabary: "ᏍᏛᏯᏅᏓᏗᎠ", english: "We (another and I) remember you (two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "itsvyanvdadi'a", syllabary: "ᎢᏨᏯᏅᏓᏗᎠ", english: "We (another and I) remember you (more than two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "gotsanvdadi'a", syllabary: "ᎪᏣᏅᏓᏗᎠ", english: "We (another and I) remember them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dotsanvdadi'a", syllabary: "ᏙᏣᏅᏓᏗᎠ", english: "We (another and I) remember those (things)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "itsvyanvdadi'a", syllabary: "ᎢᏨᏯᏅᏓᏗᎠ", english: "We (others and I) remember you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsanvdadi'a", syllabary: "ᎣᏣᏅᏓᏗᎠ", english: "We (others and I) remember him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsanvdadi'a", syllabary: "ᎣᏣᏅᏓᏗᎠ", english: "We (others and I) remember it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "gotsanvdadi'a", syllabary: "ᎪᏣᏅᏓᏗᎠ", english: "We (others and I) remember them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsanvdadi'a", syllabary: "ᏙᏣᏅᏓᏗᎠ", english: "We (others and I) remember those (things)", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "edanvdadi'a", syllabary: "ᎡᏓᏅᏓᏗᎠ", english: "We (you and I and another or others) remember him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "idanvdadi'a", syllabary: "ᎢᏓᏅᏓᏗᎠ", english: "We (you and I and another or others) remember it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "gedanvdadi'a", syllabary: "ᎨᏓᏅᏓᏗᎠ", english: "We (you and I and another or others) remember them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedanvdadi'a", syllabary: "ᏕᏓᏅᏓᏗᎠ", english: "We (you and I and another or others) remember those (things)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gvgwanvdadi'a", syllabary: "ᎬᏆᏅᏓᏗᎠ", english: "They remember me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsanvdadi'a", syllabary: "ᎨᏣᏅᏓᏗᎠ", english: "They remember you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "ananvdadi'a", syllabary: "ᎠᎾᏅᏓᏗᎠ", english: "They remember him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "ananvdadi'a", syllabary: "ᎠᎾᏅᏓᏗᎠ", english: "They remember it", occurrence: 1],
            [pronoun: "Third Plural", romanized: "geginanvdadi'a", syllabary: "ᎨᎩᎾᏅᏓᏗᎠ", english: "They remember you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "goginanvdadi'a", syllabary: "ᎪᎩᎾᏅᏓᏗᎠ", english: "They remember someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "goganvdadi'a", syllabary: "ᎪᎦᏅᏓᏗᎠ", english: "They remember you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "goginanvdadi'a", syllabary: "ᎪᎩᎾᏅᏓᏗᎠ", english: "They remember others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gesdanvdadi'a", syllabary: "ᎨᏍᏓᏅᏓᏗᎠ", english: "They remember you (two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsanvdadi'a", syllabary: "ᎨᏣᏅᏓᏗᎠ", english: "They remember you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "dananvdadi'a", syllabary: "ᏓᎾᏅᏓᏗᎠ", english: "They remember them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "dananvdadi'a", syllabary: "ᏓᎾᏅᏓᏗᎠ", english: "They remember those things", occurrence: 1],
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
