package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Hide someone or something" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.72-74
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -vsgalv'v-sg- / -vsgahlv-sg-
 *   Present Tense: -vsgalv'vsg-a / -vsgahlvsg-a
 *
 * Verb-book note: "This tense means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHideSomeoneOrSomethingPresentSpec extends VerbBaseSpec {

    static final String VERB = "to hide someone or something"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.72-74"

    // Affix composition as printed:
    static final String STEM = "-vsgalv'v-sg- / -vsgahlv-sg-"        // Stem I
    static final String TENSE_FORM = "-vsgalv'vsg-a / -vsgahlvsg-a"  // Present Tense (Stem I)

    static final String VERB_BOOK_NOTE =
        "This tense means the action is actually going on at the present time."

    /** The 71 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gvyvsgalv'vsga", syllabary: "ᎬᏴᏍᎦᎸᎥᏍᎦ", english: "I am hiding you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsiyvsgalv'vsga", syllabary: "ᏥᏴᏍᎦᎸᎥᏍᎦ", english: "I am hiding him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "gvsgahlvsga", syllabary: "ᎬᏍᎦᏢᏍᎦ", english: "I am hiding it", occurrence: 1],
            [pronoun: "First Singular", romanized: "sdvyvsgalv'vsga", syllabary: "ᏍᏛᏴᏍᎦᎸᎥᏍᎦ", english: "I am hiding you (two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "itsvyvsgalv'vsga", syllabary: "ᎢᏨᏴᏍᎦᎸᎥᏍᎦ", english: "I am hiding you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "gatsiyvsgalv'vsga", syllabary: "ᎦᏥᏴᏍᎦᎸᎥᏍᎦ", english: "I am hiding them", occurrence: 1],
            [pronoun: "First Singular", romanized: "degvsgahlvsga", syllabary: "ᏕᎬᏍᎦᏢᏍᎦ", english: "I am hiding those things", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgwvsgalv'vsga", syllabary: "ᏍᏋᏍᎦᎸᎥᏍᎦ", english: "You (singular) are hiding me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hiyvsgalv'vsga", syllabary: "ᎯᏴᏍᎦᎸᎥᏍᎦ", english: "You (singular) are hiding him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hvsgahlvsga", syllabary: "ᎲᏍᎦᏢᏍᎦ", english: "You (singular) are hiding it", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sginvsgalv'vsga", syllabary: "ᏍᎩᏅᏍᎦᎸᎥᏍᎦ", english: "You (singular) are hiding someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgiyvsgalv'vsga", syllabary: "ᏍᎩᏴᏍᎦᎸᎥᏍᎦ", english: "You (singular) are hiding others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "gahiyvsgalv'vsga", syllabary: "ᎦᎯᏴᏍᎦᎸᎥᏍᎦ", english: "You (singular) are hiding them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "dehvsgahlvsga", syllabary: "ᏕᎲᏍᎦᏢᏍᎦ", english: "You (singular) are hiding those (things)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agwvsgalv'vsga", syllabary: "ᎠᏋᏍᎦᎸᎥᏍᎦ", english: "S/he is hiding me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsvsgalv'vsga", syllabary: "ᏨᏍᎦᎸᎥᏍᎦ", english: "S/he is hiding you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "gvsgalv'vsga", syllabary: "ᎬᏍᎦᎸᎥᏍᎦ", english: "S/he is hiding him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "gvsgahlvsga", syllabary: "ᎬᏍᎦᏢᏍᎦ", english: "S/he is hiding it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ginvsgalv'vsga", syllabary: "ᎩᏅᏍᎦᎸᎥᏍᎦ", english: "S/he is hiding you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginvsgalv'vsga", syllabary: "ᎣᎩᏅᏍᎦᎸᎥᏍᎦ", english: "S/he is hiding someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "igvsgalv'vsga", syllabary: "ᎢᎬᏍᎦᎸᎥᏍᎦ", english: "S/he is hiding another (or others), me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ogvsgalv'vsga", syllabary: "ᎣᎬᏍᎦᎸᎥᏍᎦ", english: "S/he is hiding others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "sdvsgalv'vsga", syllabary: "ᏍᏛᏍᎦᎸᎥᏍᎦ", english: "S/he is hiding you (two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "itsvsgalv'vsga", syllabary: "ᎢᏨᏍᎦᎸᎥᏍᎦ", english: "S/he is hiding you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "degvsgalv'vsga", syllabary: "ᏕᎬᏍᎦᎸᎥᏍᎦ", english: "S/he is hiding them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "degvsgahlvsga", syllabary: "ᏕᎬᏍᎦᏢᏍᎦ", english: "S/he is hiding those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginvsgalv'vsga", syllabary: "ᏍᎩᏅᏍᎦᎸᎥᏍᎦ", english: "You (two) are hiding me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdvsgalv'vsga", syllabary: "ᎡᏍᏛᏍᎦᎸᎥᏍᎦ", english: "You (two) are hiding him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sdvsgahlvsga", syllabary: "ᏍᏛᏍᎦᏢᏍᎦ", english: "You (two) are hiding it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginv'vsgalv'vsga", syllabary: "ᏍᎩᏅᎥᏍᎦᎸᎥᏍᎦ", english: "You (two) are hiding someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desginvsgalv'vsga", syllabary: "ᏕᏍᎩᏅᏍᎦᎸᎥᏍᎦ", english: "You (two) are hiding others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdvsgalv'vsga", syllabary: "ᏕᏍᏛᏍᎦᎸᎥᏍᎦ", english: "You (two) are hiding them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdvsgahlvsga", syllabary: "ᏕᏍᏛᏍᎦᏢᏍᎦ", english: "You (two) are hiding those (things)", occurrence: 1],
            [pronoun: "Second Plural", romanized: "sgiyvsgalv'vsga", syllabary: "ᏍᎩᏴᏍᎦᎸᎥᏍᎦ", english: "You (more than two) are hiding me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "etsvsgalv'vsga", syllabary: "ᎡᏨᏍᎦᎸᎥᏍᎦ", english: "You (more than two) are hiding him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "itsvsgahlvsga", syllabary: "ᎢᏨᏍᎦᏢᏍᎦ", english: "You (more than two) are hiding it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "desgiyvsgalv'vsga", syllabary: "ᏕᏍᎩᏴᏍᎦᎸᎥᏍᎦ", english: "You (more than two) are hiding someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsvsgalv'vsga", syllabary: "ᏕᏨᏍᎦᎸᎥᏍᎦ", english: "You (more than two) are hiding them", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsvsgahlvsga", syllabary: "ᏕᏨᏍᎦᏢᏍᎦ", english: "You (more than two) are hiding those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "envsgalv'vsga", syllabary: "ᎡᏅᏍᎦᎸᎥᏍᎦ", english: "We (you and I) are hiding him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "invsgahlvsga", syllabary: "ᎢᏅᏍᎦᏢᏍᎦ", english: "We (you and I) are hiding it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "genvsgalv'vsga", syllabary: "ᎨᏅᏍᎦᎸᎥᏍᎦ", english: "We (you and I) are hiding them", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "denvsgahlvsga", syllabary: "ᏕᏅᏍᎦᏢᏍᎦ", english: "We (you and I) are hiding those things", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvyvsgalv'vsga", syllabary: "ᏍᏛᏴᏍᎦᎸᎥᏍᎦ", english: "We (another and I) are hiding you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdvsgalv'vsga", syllabary: "ᎣᏍᏛᏍᎦᎸᎥᏍᎦ", english: "We (another and I) are hiding him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdvsgahlvsga", syllabary: "ᎣᏍᏛᏍᎦᏢᏍᎦ", english: "We (another and I) are hiding it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "desdvyvsgalv'vsga", syllabary: "ᏕᏍᏛᏴᏍᎦᎸᎥᏍᎦ", english: "We (another and I) are hiding you (two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "detsvyvsgalv'vsga", syllabary: "ᏕᏨᏴᏍᎦᎸᎥᏍᎦ", english: "We (another and I) are hiding you (more than two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dotsvsgalv'vsga", syllabary: "ᏙᏨᏍᎦᎸᎥᏍᎦ", english: "We (another and I) are hiding them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdvsgahlvsga", syllabary: "ᏙᏍᏛᏍᎦᏢᏍᎦ", english: "We (another and I) are hiding those (things)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "itsvyvsgalv'vsga", syllabary: "ᎢᏨᏴᏍᎦᎸᎥᏍᎦ", english: "We (others and I) are hiding you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsvsgalv'vsga", syllabary: "ᎣᏨᏍᎦᎸᎥᏍᎦ", english: "We (others and I) are hiding him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsvsgahlvsga", syllabary: "ᎣᏨᏍᎦᏢᏍᎦ", english: "We (others and I) are hiding it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsvsgalv'vsga", syllabary: "ᏙᏨᏍᎦᎸᎥᏍᎦ", english: "We (others and I) are hiding them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsvsgahlvsga", syllabary: "ᏙᏨᏍᎦᏢᏍᎦ", english: "We (others and I) are hiding those (things)", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "edvsgalv'vsga", syllabary: "ᎡᏛᏍᎦᎸᎥᏍᎦ", english: "We (you and I and another or others) are hiding him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "idvsgahlvsga", syllabary: "ᎢᏛᏍᎦᏢᏍᎦ", english: "We (you and I and another or others) are hiding it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedvsgalv'vsga", syllabary: "ᏕᏛᏍᎦᎸᎥᏍᎦ", english: "We (you and I and another or others) are hiding them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedvsgahlvsga", syllabary: "ᏕᏛᏍᎦᏢᏍᎦ", english: "We (you and I and another or others) are hiding those (things)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gvgwvsgalv'vsga", syllabary: "ᎬᏋᏍᎦᎸᎥᏍᎦ", english: "They are hiding me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsvsgalv'vsga", syllabary: "ᎨᏨᏍᎦᎸᎥᏍᎦ", english: "They are hiding you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anvsgalv'vsga", syllabary: "ᎠᏅᏍᎦᎸᎥᏍᎦ", english: "They are hiding him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anvsgahlvsga", syllabary: "ᎠᏅᏍᎦᏢᏍᎦ", english: "They are hiding it", occurrence: 1],
            [pronoun: "Third Plural", romanized: "geginvsgalv'vsga", syllabary: "ᎨᎩᏅᏍᎦᎸᎥᏍᎦ", english: "They are hiding you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "goginvsgalv'vsga", syllabary: "ᎪᎩᏅᏍᎦᎸᎥᏍᎦ", english: "They are hiding someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gegvsgalv'vsga", syllabary: "ᎨᎬᏍᎦᎸᎥᏍᎦ", english: "They are hiding you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gogvsgalv'vsga", syllabary: "ᎪᎬᏍᎦᎸᎥᏍᎦ", english: "They are hiding others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gesdvsgalv'vsga", syllabary: "ᎨᏍᏛᏍᎦᎸᎥᏍᎦ", english: "They are hiding you (two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsvsgalv'vsga", syllabary: "ᎨᏨᏍᎦᎸᎥᏍᎦ", english: "They are hiding you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danvsgalv'vsga", syllabary: "ᏓᏅᏍᎦᎸᎥᏍᎦ", english: "They are hiding them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danvsgahlvsga", syllabary: "ᏓᏅᏍᎦᏢᏍᎦ", english: "They are hiding those things", occurrence: 1],
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
