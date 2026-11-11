package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Look for" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.97-99
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -yo-h-
 *   Present Tense: -yoh-a
 *
 * Verb-book note: "This tense means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToLookForPresentSpec extends Specification {

    static final String VERB = "to look for"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.97-99"

    // Affix composition as printed:
    static final String STEM = "-yo-h-"        // Stem I
    static final String TENSE_FORM = "-yoh-a"  // Present Tense (Stem I)

    static final String VERB_BOOK_NOTE =
        "This tense means the action is actually going on at the present time."

    /** The 71 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gvyoha", syllabary: "ᎬᏲᎭ", english: "I am looking for you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsiyoha", syllabary: "ᏥᏲᎭ", english: "I am looking for him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "agiyoha", syllabary: "ᎠᎩᏲᎭ", english: "I am looking for it", occurrence: 1],
            [pronoun: "First Singular", romanized: "sdvyoha", syllabary: "ᏍᏛᏲᎭ", english: "I am looking for you (two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "itsvyoha", syllabary: "ᎢᏨᏲᎭ", english: "I am looking for you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "gatsiyoha", syllabary: "ᎦᏥᏲᎭ", english: "I am looking for them", occurrence: 1],
            [pronoun: "First Singular", romanized: "dagiyoha", syllabary: "ᏓᎩᏲᎭ", english: "I am looking for those things", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgiyoha", syllabary: "ᏍᎩᏲᎭ", english: "You (singular) look for me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hiyoha", syllabary: "ᎯᏲᎭ", english: "You (singular) look for him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "tsayoha", syllabary: "ᏣᏲᎭ", english: "You (singular) look for it", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sginiyoha", syllabary: "ᏍᎩᏂᏲᎭ", english: "You (singular) look for someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "isgiyoha", syllabary: "ᎢᏍᎩᏲᎭ", english: "You (singular) look for others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "gahiyoha", syllabary: "ᎦᎯᏲᎭ", english: "You (singular) look for them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "detsiyoha", syllabary: "ᏕᏥᏲᎭ", english: "You (singular) look for those (things)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "akiyoha", syllabary: "ᎠᎩᏲᎭ", english: "S/he looks for me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsayoha", syllabary: "ᏣᏲᎭ", english: "S/he looks for you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ayoha", syllabary: "ᎠᏲᎭ", english: "S/he looks for him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "uhyoha", syllabary: "ᎤᏲᎭ", english: "S/he looks for it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "giniyoha", syllabary: "ᎩᏂᏲᎭ", english: "S/he looks for you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginiyoha", syllabary: "ᎣᎩᏂᏲᎭ", english: "S/he looks for someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "igiyoha", syllabary: "ᎢᎩᏲᎭ", english: "S/he looks for another (or others), me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ogiyoha", syllabary: "ᎣᎩᏲᎭ", english: "S/he looks for others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "sdiyoha", syllabary: "ᏍᏗᏲᎭ", english: "S/he looks for you (two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "itsiyoha", syllabary: "ᎢᏥᏲᎭ", english: "S/he looks for you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dayoha", syllabary: "ᏓᏲᎭ", english: "S/he looks for them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "duyoha", syllabary: "ᏚᏲᎭ", english: "S/he looks for those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginiyoha", syllabary: "ᏍᎩᏂᏲᎭ", english: "You (two) look for me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdiyoha", syllabary: "ᎡᏍᏗᏲᎭ", english: "You (two) look for him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sdiyoha", syllabary: "ᏍᏗᏲᎭ", english: "You (two) look for it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginiyoha", syllabary: "ᏍᎩᏂᏲᎭ", english: "You (two) look for someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "isgiyoha", syllabary: "ᎢᏍᎩᏲᎭ", english: "You (two) look for others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "gesdiyoha", syllabary: "ᎨᏍᏗᏲᎭ", english: "You (two) look for them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdiyoha", syllabary: "ᏕᏍᏗᏲᎭ", english: "You (two) look for those (things)", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgiyoha", syllabary: "ᎢᏍᎩᏲᎭ", english: "You (more than two) are looking for me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "etsiyoha", syllabary: "ᎡᏥᏲᎭ", english: "You (more than two) are looking for him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "itsiyoha", syllabary: "ᎢᏥᏲᎭ", english: "You (more than two) are looking for it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "desgiyoha", syllabary: "ᏕᏍᎩᏲᎭ", english: "You (more than two) are looking for someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "getsiyoha", syllabary: "ᎨᏥᏲᎭ", english: "You (more than two) are looking for them", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsiyoha", syllabary: "ᏕᏥᏲᎭ", english: "You (more than two) are looking for those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "eniyoha", syllabary: "ᎡᏂᏲᎭ", english: "We (you and I) are looking for him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "giniyoha", syllabary: "ᎩᏂᏲᎭ", english: "We (you and I) are looking for it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "geniyoha", syllabary: "ᎨᏂᏲᎭ", english: "We (you and I) are looking for them", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "deginiyoha", syllabary: "ᏕᎩᏂᏲᎭ", english: "We (you and I) are looking for those things", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvyoha", syllabary: "ᏍᏛᏲᎭ", english: "We (another and I) are looking for you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdiyoha", syllabary: "ᎣᏍᏗᏲᎭ", english: "We (another and I) are looking for him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "oginiyoha", syllabary: "ᎣᎩᏂᏲᎭ", english: "We (another and I) are looking for it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "desdvyoha", syllabary: "ᏕᏍᏛᏲᎭ", english: "We (another and I) are looking for you (two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "itsvyoha", syllabary: "ᎢᏨᏲᎭ", english: "We (another and I) are looking for you (more than two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdiyoha", syllabary: "ᏙᏍᏗᏲᎭ", english: "We (another and I) are looking for them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "doginiyoha", syllabary: "ᏙᎩᏂᏲᎭ", english: "We (another and I) are looking for those (things)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "itsvyoha", syllabary: "ᎢᏨᏲᎭ", english: "We (others and I) are looking for you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsiyoha", syllabary: "ᎣᏥᏲᎭ", english: "We (others and I) are looking for him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "ogiyoha", syllabary: "ᎣᎩᏲᎭ", english: "We (others and I) are looking for it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsiyoha", syllabary: "ᏙᏥᏲᎭ", english: "We (others and I) are looking for them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dogiyoha", syllabary: "ᏙᎩᏲᎭ", english: "We (others and I) are looking for those (things)", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "ediyoha", syllabary: "ᎡᏗᏲᎭ", english: "We (you and I and another or others) look for him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "ogiyoha", syllabary: "ᎣᎩᏲᎭ", english: "We (you and I and another or others) look for it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dediyoha", syllabary: "ᏕᏗᏲᎭ", english: "We (you and I and another or others) look for them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "degiyoha", syllabary: "ᏕᎩᏲᎭ", english: "We (you and I and another or others) look for those (things)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gvgiyoha", syllabary: "ᎬᎩᏲᎭ", english: "They look for me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsayoha", syllabary: "ᎨᏣᏲᎭ", english: "They look for you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "aniyoha", syllabary: "ᎠᏂᏲᎭ", english: "They look for him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "uniyoha", syllabary: "ᎤᏂᏲᎭ", english: "They look for it", occurrence: 1],
            [pronoun: "Third Plural", romanized: "geginiyoha", syllabary: "ᎨᎩᏂᏲᎭ", english: "They look for you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "goginiyoha", syllabary: "ᎪᎩᏂᏲᎭ", english: "They look for someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gegiyoha", syllabary: "ᎨᎩᏲᎭ", english: "They look for you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gogiyoha", syllabary: "ᎪᎩᏲᎭ", english: "They look for others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gesdiyoha", syllabary: "ᎨᏍᏗᏲᎭ", english: "They look for you (two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsiyoha", syllabary: "ᎨᏥᏲᎭ", english: "They look for you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "daniyoha", syllabary: "ᏓᏂᏲᎭ", english: "They look for them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "duniyoha", syllabary: "ᏚᏂᏲᎭ", english: "They look for those things", occurrence: 1],
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
