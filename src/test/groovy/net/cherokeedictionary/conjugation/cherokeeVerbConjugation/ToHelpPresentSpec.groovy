package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Help" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.67-69
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -sdeli-h-
 *   Present Tense: -sdelih-a
 *
 * Verb-book note: "This verb means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHelpPresentSpec extends VerbBaseSpec {

    static final String VERB = "to help"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.67-69"

    // Affix composition as printed:
    static final String STEM = "-sdeli-h-"        // Stem I
    static final String TENSE_FORM = "-sdelih-a"  // Present Tense (Stem I)

    static final String VERB_BOOK_NOTE =
        "This verb means the action is actually going on at the present time."

    /** The 71 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gvsdeliha", syllabary: "ᎬᏍᏕᎵᎭ", english: "I am helping you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsisdeliha", syllabary: "ᏥᏍᏕᏗᎭ", english: "I am helping him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsisdeliha", syllabary: "ᏥᏍᏕᎵᎭ", english: "I am helping it", occurrence: 1],
            [pronoun: "First Singular", romanized: "sdvsdeliha", syllabary: "ᏍᏛᏍᏕᎵᎭ", english: "I am helping you (two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "itsvsdeliha", syllabary: "ᎢᏨᏍᏕᎵᎭ", english: "I am helping you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "gatsisdeliha", syllabary: "ᎦᏥᏍᏕᎵᎭ", english: "I am helping them", occurrence: 1],
            [pronoun: "First Singular", romanized: "detsisdeliha", syllabary: "ᏕᏥᏍᏕᎵᎭ", english: "I am helping those things", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgisdeliha", syllabary: "ᏍᎩᏍᏕᎵᎭ", english: "You (singular) are helping me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hisdeliha", syllabary: "ᎯᏍᏕᎵᎭ", english: "You (singular) are helping him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hisdeliha", syllabary: "ᎯᏍᏕᎵᎭ", english: "You (singular) are helping it", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sginisdeliha", syllabary: "ᏍᎩᏂᏍᏕᎵᎭ", english: "You (singular) are helping someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "isgisdeliha", syllabary: "ᎢᏍᎩᏍᏕᎵᎭ", english: "You (singular) are helping others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "gahisdeliha", syllabary: "ᎦᎯᏍᏕᎵᎭ", english: "You (singular) are helping them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "tisdeliha", syllabary: "ᏘᏍᏕᎵᎭ", english: "You (singular) are helping those (things)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agisdeliha", syllabary: "ᎠᎩᏍᏕᎵᎭ", english: "S/he is helping me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsasdeliha", syllabary: "ᏣᏍᏕᎵᎭ", english: "S/he is helping you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "asdeliha", syllabary: "ᎠᏍᏕᎵᎭ", english: "S/he is helping him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "asdeliha", syllabary: "ᎠᏍᏕᎵᎭ", english: "S/he is helping it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ginisdeliha", syllabary: "ᎩᏂᏍᏕᎵᎭ", english: "S/he is helping you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginisdeliha", syllabary: "ᎣᎩᏂᏍᏕᎵᎭ", english: "S/he is helping someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "igisdeliha", syllabary: "ᎢᎩᏍᏕᎵᎭ", english: "S/he is helping another (or others), me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ogisdeliha", syllabary: "ᎣᎩᏍᏕᎵᎭ", english: "S/he is helping others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "sdisdeliha", syllabary: "ᏍᏗᏍᏕᎵᎭ", english: "S/he is helping you (two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "itsisdeliha", syllabary: "ᎢᏥᏍᏕᎵᎭ", english: "S/he is helping you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dasdeliha", syllabary: "ᏓᏍᏕᎵᎭ", english: "S/he is helping them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dasdeliha", syllabary: "ᏓᏍᏕᎵᎭ", english: "S/he is helping those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginisdeliha", syllabary: "ᏍᎩᏂᏍᏕᎵᎭ", english: "You (two) are helping me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdisdeliha", syllabary: "ᎡᏍᏗᏍᏕᎵᎭ", english: "You (two) are helping him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sdisdeliha", syllabary: "ᏍᏗᏍᏕᎵᎭ", english: "You (two) are helping it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginisdeliha", syllabary: "ᏍᎩᏂᏍᏕᎵᎭ", english: "You (two) are helping someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "isgisdeliha", syllabary: "ᎢᏍᎩᏍᏕᎵᎭ", english: "You (two) are helping others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "gahisdeliha", syllabary: "ᎦᎯᏍᏕᎵᎭ", english: "You (two) are helping them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdisdeliha", syllabary: "ᏕᏍᏗᏍᏕᎵᎭ", english: "You (two) are helping those things", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgisdeliha", syllabary: "ᎢᏍᎩᏍᏕᎵᎭ", english: "You (more than two) are helping me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "etsisdeliha", syllabary: "ᎡᏥᏍᏕᎵᎭ", english: "You (more than two) are helping him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "itsisdeliha", syllabary: "ᎢᏥᏍᏕᎵᎭ", english: "You (more than two) are helping it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "sginisdeliha", syllabary: "ᏍᎩᏂᏍᏕᎵᎭ", english: "You (more than two) are helping someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "getsisdeliha", syllabary: "ᎨᏥᏍᏕᎵᎭ", english: "You (more than two) are helping them", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsisdeliha", syllabary: "ᏕᏥᏍᏕᎵᎭ", english: "You (more than two) are helping those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "enisdeliha", syllabary: "ᎡᏂᏍᏕᎵᎭ", english: "We (you and I) are helping him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "inisdeliha", syllabary: "ᎢᏂᏍᏕᎵᎭ", english: "We (you and I) are helping it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "genisdeliha", syllabary: "ᎨᏂᏍᏕᎵᎭ", english: "We (you and I) are helping them", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "denisdeliha", syllabary: "ᏕᏂᏍᏕᎵᎭ", english: "We (you and I) are helping those things", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvsdeliha", syllabary: "ᏍᏛᏍᏕᎵᎭ", english: "We (another and I) are helping you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdisdeliha", syllabary: "ᎣᏍᏗᏍᏕᎵᎭ", english: "We (another and I) are helping him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdisdeliha", syllabary: "ᎣᏍᏗᏍᏕᎵᎭ", english: "We (another and I) are helping it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "desdvsdeliha", syllabary: "ᏕᏍᏛᏍᏕᎵᎭ", english: "We (another and I) are helping you (two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "detsvsdeliha", syllabary: "ᏕᏨᏍᏕᎵᎭ", english: "We (another and I) are helping you (more than two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "gosdisdeliha", syllabary: "ᎪᏍᏗᏍᏕᎵᎭ", english: "We (another and I) are helping them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdisdeliha", syllabary: "ᏙᏍᏗᏍᏕᎵᎭ", english: "We (another and I) are helping those things", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "itsvsdeliha", syllabary: "ᎢᏨᏍᏕᎵᎭ", english: "We (others and I) are helping you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsisdeliha", syllabary: "ᎣᏥᏍᏕᎵᎭ", english: "We (others and I) are helping him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsisdeliha", syllabary: "ᎣᏥᏍᏕᎵᎭ", english: "We (others and I) are helping it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "gotsisdeliha", syllabary: "ᎪᏥᏍᏕᎵᎭ", english: "We (others and I) are helping them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsisdeliha", syllabary: "ᏙᏥᏍᏕᎵᎭ", english: "We (others and I) are helping those things", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "edisdeliha", syllabary: "ᎡᏗᏍᏕᎵᎭ", english: "We (you and I and another or others) are helping him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "idisdeliha", syllabary: "ᎢᏗᏍᏕᎵᎭ", english: "We (you and I and another or others) are helping it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "gedisdeliha", syllabary: "ᎨᏗᏍᏕᎵᎭ", english: "We (others and I) are helping them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedisdeliha", syllabary: "ᏕᏗᏍᏕᎵᎭ", english: "We (others and I) are helping those things", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gvgisdeliha", syllabary: "ᎬᎩᏍᏕᎵᎭ", english: "They are helping me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsasdeliha", syllabary: "ᎨᏣᏍᏕᎵᎭ", english: "They are helping you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anisdeliha", syllabary: "ᎠᏂᏍᏕᎵᎭ", english: "They are helping him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anisdeliha", syllabary: "ᎠᏂᏍᏕᎵᎭ", english: "They are helping it", occurrence: 1],
            [pronoun: "Third Plural", romanized: "geginisdeliha", syllabary: "ᎨᎩᏂᏍᏕᎵᎭ", english: "They are helping you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "goginisdeliha", syllabary: "ᎪᎩᏂᏍᏕᎵᎭ", english: "They are helping someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gegisdeliha", syllabary: "ᎨᎩᏍᏕᎵᎭ", english: "They are helping you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "goginisdeliha", syllabary: "ᎪᎩᏂᏍᏕᎵᎭ", english: "They are helping others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gesdisdeliha", syllabary: "ᎨᏍᏗᏍᏕᎵᎭ", english: "They are helping you (two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsisdeliha", syllabary: "ᎨᏥᏍᏕᎵᎭ", english: "They are helping you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danisdeliha", syllabary: "ᏓᏂᏍᏕᎵᎭ", english: "They are helping them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danisdeliha", syllabary: "ᏓᏂᏍᏕᎵᎭ", english: "They are helping those things", occurrence: 1],
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
