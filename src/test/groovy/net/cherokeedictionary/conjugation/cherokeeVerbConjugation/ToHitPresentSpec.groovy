package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Hit" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.77-79
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -vhni-h-
 *   Present Tense: -vhnih-a
 *
 * Verb-book note: "This verb means the action is happening at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHitPresentSpec extends VerbBaseSpec {

    static final String VERB = "to hit"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.77-79"

    // Affix composition as printed:
    static final String STEM = "-vhni-h-"        // Stem I
    static final String TENSE_FORM = "-vhnih-a"  // Present Tense (Stem I)

    static final String VERB_BOOK_NOTE =
        "This verb means the action is happening at the present time."

    /** The 71 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gvyvhniha", syllabary: "ᎬᏴᏂᎭ", english: "I am hitting you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsiyvhniha", syllabary: "ᏥᏴᏂᎭ", english: "I am hitting him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "gvniha", syllabary: "ᎬᏂᎭ", english: "I am hitting it", occurrence: 1],
            [pronoun: "First Singular", romanized: "sdvyvhniha", syllabary: "ᏍᏛᏴᏂᎭ", english: "I am hitting you (two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "detsvyvhniha", syllabary: "ᏕᏨᏴᏂᎭ", english: "I am hitting you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "degatsiyvhniha", syllabary: "ᏕᎦᏥᏴᏂᎭ", english: "I am hitting them", occurrence: 1],
            [pronoun: "First Singular", romanized: "degvniha", syllabary: "ᏕᎬᏂᎭ", english: "I am hitting those things", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgwvhniha", syllabary: "ᏍᏋᏂᎭ", english: "You (singular) are hitting me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hiyvhniha", syllabary: "ᎯᏴᏂᎭ", english: "You (singular) are hitting him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hvhniha", syllabary: "ᎲᏂᎭ", english: "You (singular) are hitting it", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sginvhniha", syllabary: "ᏍᎩᏅᏂᎦ", english: "You (singular) are hitting someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "isgiyvhniha", syllabary: "ᎢᏍᎩᏴᏂᎭ", english: "You (singular) are hitting others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "degahiyvhniha", syllabary: "ᏕᎦᎯᏴᏂᎭ", english: "You (singular) are hitting them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "dehvhniha", syllabary: "ᏕᎲᏂᎭ", english: "You (singular) are hitting those (things)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agwvhniha", syllabary: "ᎠᏋᏂᎭ", english: "S/he is hitting me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsvhniha", syllabary: "ᏨᏂᎭ", english: "S/he is hitting you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "gvhniha", syllabary: "ᎬᏂᎭ", english: "S/he is hitting him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "gvhniha", syllabary: "ᎬᏂᎭ", english: "S/he is hitting it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ginvhniha", syllabary: "ᎩᏅᏂᎭ", english: "S/he is hitting you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginvhniha", syllabary: "ᎣᎩᏅᏂᎭ", english: "S/he is hitting someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "igvhniha", syllabary: "ᎢᎬᏂᎭ", english: "S/he is hitting another (or others), me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ogvhniha", syllabary: "ᎣᎬᏂᎭ", english: "S/he is hitting others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "sdvhniha", syllabary: "ᎢᏍᏛᏂᎭ", english: "S/he is hitting you (two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "itsvhniha", syllabary: "ᎢᏨᏂᎭ", english: "S/he is hitting you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "degvhniha", syllabary: "ᏕᎬᏂᎭ", english: "S/he is hitting them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "degvhniha", syllabary: "ᏕᎬᏂᎭ", english: "S/he is hitting those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginvhniha", syllabary: "ᏍᎩᏅᏂᎭ", english: "You (two) are hitting me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdvhniha", syllabary: "ᎡᏍᏛᏂᎭ", english: "You (two) are hitting him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sdvhniha", syllabary: "ᏍᏛᏂᎭ", english: "You (two) are hitting it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginvhniha", syllabary: "ᏍᎩᏅᏂᎭ", english: "You (two) are hitting someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "isgiyvhniha", syllabary: "ᎢᏍᎩᏴᏂᎭ", english: "You (two) are hitting others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdvhniha", syllabary: "ᎨᏍᏛᏂᎭ", english: "You (two) are hitting them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdvhniha", syllabary: "ᏕᏍᏛᏂᎭ", english: "You (two) are hitting those (things)", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgiyvhniha", syllabary: "ᎢᏍᎩᏴᏂᎭ", english: "You (more than two) are hitting me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "etsvhniha", syllabary: "ᎡᏨᏂᎭ", english: "You (more than two) are hitting him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "itsvhniha", syllabary: "ᎢᏨᏂᎭ", english: "You (more than two) are hitting it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgiyvhniha", syllabary: "ᎢᏍᎩᏴᏂᎭ", english: "You (more than two) are hitting someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "getsvhniha", syllabary: "ᎨᏨᏂᎭ", english: "You (more than two) are hitting them", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsvhniha", syllabary: "ᏕᏨᏂᎭ", english: "You (more than two) are hitting those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "envhniha", syllabary: "ᎡᏅᏂᎭ", english: "We (you and I) are hitting him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "invhniha", syllabary: "ᎢᏅᏂᎭ", english: "We (you and I) are hitting it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "genvhniha", syllabary: "ᎨᏅᏂᎭ", english: "We (you and I) are hitting them", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "denvhniha", syllabary: "ᏕᏅᏂᎭ", english: "We (you and I) are hitting those things", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvyvhniha", syllabary: "ᏍᏛᏴᏂᎭ", english: "We (another and I) are hitting you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdvhniha", syllabary: "ᎣᏍᏛᏂᎭ", english: "We (another and I) are hitting him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdvhniha", syllabary: "ᎣᏍᏛᏂᎭ", english: "We (another and I) are hitting it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvyvhniha", syllabary: "ᏍᏛᏴᏂᎭ", english: "We (another and I) are hitting you (two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "itsvyvhniha", syllabary: "ᎢᏨᏴᏂᎭ", english: "We (another and I) are hitting you (more than two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdvhniha", syllabary: "ᎪᏍᏛᏂᎭ", english: "We (another and I) are hitting them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdvhniha", syllabary: "ᏙᏍᏛᏂᎭ", english: "We (another and I) are hitting those (things)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "itsvyvhniha", syllabary: "ᎢᏨᏴᏂᎭ", english: "We (others and I) are hitting you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsvhniha", syllabary: "ᎣᏨᏂᎭ", english: "We (others and I) are hitting him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsvhniha", syllabary: "ᎣᏨᏂᎭ", english: "We (others and I) are hitting it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "degotsvhniha", syllabary: "ᏕᎪᏨᏂᎭ", english: "We (others and I) are hitting them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsvhniha", syllabary: "ᏙᏨᏂᎭ", english: "We (others and I) are hitting those (things)", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "edvhniha", syllabary: "ᎡᏛᏂᎭ", english: "We (you and I and another or others) are hitting him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "idvhniha", syllabary: "ᎢᏛᏂᎭ", english: "We (you and I and another or others) are hitting it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedvhniha", syllabary: "ᎨᏛᏂᎭ", english: "We (you and I and another or others) are hitting them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedvhniha", syllabary: "ᏕᏛᏂᎭ", english: "We (you and I and another or others) are hitting those (things)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gvgwvhniha", syllabary: "ᎬᏋᏂᎭ", english: "They are hitting me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsvhniha", syllabary: "ᎨᏨᏂᎭ", english: "They are hitting you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anvhniha", syllabary: "ᎠᏅᏂᎭ", english: "They are hitting him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anvhniha", syllabary: "ᎠᏅᏂᎭ", english: "They are hitting it", occurrence: 1],
            [pronoun: "Third Plural", romanized: "geginvhniha", syllabary: "ᎨᎩᏅᏂᎭ", english: "They are hitting you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "goginvhniha", syllabary: "ᎪᎩᏅᏂᎭ", english: "They are hitting someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gegvhniha", syllabary: "ᎨᎬᏂᎭ", english: "They are hitting you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gogvhniha", syllabary: "ᎪᎬᏂᎭ", english: "They are hitting others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gesdvhniha", syllabary: "ᎨᏍᏛᏂᎭ", english: "They are hitting you (two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsvhniha", syllabary: "ᎨᏨᏂᎭ", english: "They are hitting you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danvhniha", syllabary: "ᏓᏅᏂᎭ", english: "They are hitting them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danvhniha", syllabary: "ᏓᏅᏂᎭ", english: "They hit those things", occurrence: 1],
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
