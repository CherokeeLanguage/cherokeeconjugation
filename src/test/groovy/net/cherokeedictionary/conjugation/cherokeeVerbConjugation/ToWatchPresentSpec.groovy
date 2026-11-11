package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Watch" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.159-161
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -agasesd-Ø-
 *   Present Tense: -agasesd-i
 *
 * Verb-book note: "This tense means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToWatchPresentSpec extends VerbBaseSpec {

    static final String VERB = "to watch"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.159-161"

    // Affix composition as printed:
    static final String STEM = "-agasesd-Ø-"        // Stem I
    static final String TENSE_FORM = "-agasesd-i"  // Present Tense (Stem I)

    static final String VERB_BOOK_NOTE =
        "This tense means the action is actually going on at the present time."

    /** The 71 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gvyagasesdi", syllabary: "ᎬᏯᎦᏎᏍᏗ", english: "I am watching you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsiyagasesdi", syllabary: "ᏥᏯᎦᏎᏍᏗ", english: "I am watching him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "agwagasesdi", syllabary: "ᎠᏆᎦᏎᏍᏗ", english: "I am watching it", occurrence: 1],
            [pronoun: "First Singular", romanized: "sdvyagasesdi", syllabary: "ᏍᏛᏯᎦᏎᏍᏗ", english: "I am watching you two", occurrence: 1],
            [pronoun: "First Singular", romanized: "itsvyagasesdi", syllabary: "ᎢᏨᏯᎦᏎᏍᏗ", english: "I am watching you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "gatsiyagasesdi", syllabary: "ᎦᏥᏯᎦᏎᏍᏗ", english: "I am watching them", occurrence: 1],
            [pronoun: "First Singular", romanized: "dagwagasesdi", syllabary: "ᏓᏆᎦᏎᏍᏗ", english: "I am watching those things", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgwagasesdi", syllabary: "ᏍᏆᎦᏎᏍᏗ", english: "You (singular) are watching me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hiyagasesdi", syllabary: "ᎯᏯᎦᏎᏍᏗ", english: "You (singular) are watching him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "tsagasesdi", syllabary: "ᏣᎦᏎᏍᏗ", english: "You (singular) are watching it", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sginagasesdi", syllabary: "ᏍᎩᎾᎦᏎᏍᏗ", english: "You (singular) are watching someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgiyagasesdi", syllabary: "ᏍᎩᏯᎦᏎᏍᏗ", english: "You (singular) are watching others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "gahiyagasesdi", syllabary: "ᎦᎯᏯᎦᏎᏍᏗ", english: "You (singular) are watching them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "dehagasesdi", syllabary: "ᏕᎭᎦᏎᏍᏗ", english: "You (singular) are watching those things", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agwagasesdi", syllabary: "ᎠᏆᎦᏎᏍᏗ", english: "He/she is watching me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsagasesdi", syllabary: "ᏣᎦᏎᏍᏗ", english: "He/she is watching you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agasesdi", syllabary: "ᎠᎦᏎᏍᏗ", english: "He/she is watching him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "uksesdi", syllabary: "ᎤᎦᏎᏍᏗ", english: "He/she is watching it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ginagasesdi", syllabary: "ᎩᎾᎦᏎᏍᏗ", english: "He/she is watching you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginagasesdi", syllabary: "ᎣᎩᎾᎦᏎᏍᏗ", english: "He/she is watching someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "igagasesdi", syllabary: "ᎢᎦᎦᏎᏍᏗ", english: "He/she is watching another (or others), me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginagasesdi", syllabary: "ᎣᎩᎾᎦᏎᏍᏗ", english: "He/she is watching others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "sdagasesdi", syllabary: "ᏍᏓᎦᏎᏍᏗ", english: "He/she is watching you (two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "itsagasesdi", syllabary: "ᎢᏣᎦᏎᏍᏗ", english: "He/she is watching you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dagasesdi", syllabary: "ᏓᎦᏎᏍᏗ", english: "He/she is watching them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dunagasesdi", syllabary: "ᏚᎾᎦᏎᏍᏗ", english: "He/she is watching those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginagasesdi", syllabary: "ᏍᎩᎾᎦᏎᏍᏗ", english: "You (two) are watching me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdagasesdi", syllabary: "ᎡᏍᏓᎦᏎᏍᏗ", english: "You (two) are watching him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sdagasesdi", syllabary: "ᏍᏓᎦᏎᏍᏗ", english: "You (two) are watching it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginagasesdi", syllabary: "ᏍᎩᎾᎦᏎᏍᏗ", english: "You (two) are watching someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "isgiyagasesdi", syllabary: "ᎢᏍᎩᏯᎦᏎᏍᏗ", english: "You (two) are watching others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "gesdagasesdi", syllabary: "ᎨᏍᏓᎦᏎᏍᏗ", english: "You (two) are watching them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdagasesdi", syllabary: "ᏕᏍᏓᎦᏎᏍᏗ", english: "You (two) are watching those things", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgiyagasesdi", syllabary: "ᎢᏍᎩᏯᎦᏎᏍᏗ", english: "You (more than two) are watching me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "etsagasesdi", syllabary: "ᎡᏣᎦᏎᏍᏗ", english: "You (more than two) are watching him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "itsagasesdi", syllabary: "ᎢᏣᎦᏎᏍᏗ", english: "You (more than two) are watching it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgiyagasesdi", syllabary: "ᎢᏍᎩᏯᎦᏎᏍᏗ", english: "You (more than two) are watching someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "getsagasesdi", syllabary: "ᎨᏣᎦᏎᏍᏗ", english: "You (more than two) are watching them", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsagasesdi", syllabary: "ᏕᏣᎦᏎᏍᏗ", english: "You (more than two) are watching those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "enagasesdi", syllabary: "ᎡᎾᎦᏎᏍᏗ", english: "We (you and I) are watching him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "ginagasesdi", syllabary: "ᎩᎾᎦᏎᏍᏗ", english: "We (you and I) are watching it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "genagasesdi", syllabary: "ᎨᎾᎦᏎᏍᏗ", english: "We (you and I) are watching them", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "denagasesdi", syllabary: "ᏕᎾᎦᏎᏍᏗ", english: "We (you and I) are watching those things", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvyagasesdi", syllabary: "ᏍᏛᏯᎦᏎᏍᏗ", english: "We (another and I) are watching you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdagasesdi", syllabary: "ᎣᏍᏓᎦᏎᏍᏗ", english: "We (another and I) are watching him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "oginagasesdi", syllabary: "ᎣᎩᎾᎦᏎᏍᏗ", english: "We (another and I) are watching it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvyagasesdi", syllabary: "ᏍᏛᏯᎦᏎᏍᏗ", english: "We (another and I) are watching you two", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "itsvgasesdi", syllabary: "ᎢᏨᎦᏎᏍᏗ", english: "We (another and I) are watching you (more than two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdagasesdi", syllabary: "ᏙᏍᏓᎦᏎᏍᏗ", english: "We (another and I) are watching them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dogagasesdi", syllabary: "ᏙᎦᎦᏎᏍᏗ", english: "We (another and I) are watching those things", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "itsvyagasesdi", syllabary: "ᎢᏨᏯᎦᏎᏍᏗ", english: "We (others and I) are watching you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsagasesdi", syllabary: "ᎣᏣᎦᏎᏍᏗ", english: "We (others and I) are watching him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsagasesdi", syllabary: "ᎣᏣᎦᏎᏍᏗ", english: "We (others) and I are watching it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "gotsagasesdi", syllabary: "ᎪᏣᎦᏎᏍᏗ", english: "We (others and I) are watching them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsagasesdi", syllabary: "ᏙᏣᎦᏎᏍᏗ", english: "We (others and I) are watching those things", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "edagasesdi", syllabary: "ᎡᏓᎦᏎᏍᏗ", english: "We (you and I and another or others) are watching him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "idagasesdi", syllabary: "ᎢᏓᎦᏎᏍᏗ", english: "We (you and I and another or others) are watching it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "gedagasesdi", syllabary: "ᎨᏓᎦᏎᏍᏗ", english: "We (others and I) are watching them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedagasesdi", syllabary: "ᏕᏓᎦᏎᏍᏗ", english: "We (others and I) are watching those things", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gvgwagasesdi", syllabary: "ᎬᏆᎦᏎᏍᏗ", english: "They are watching me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsagasesdi", syllabary: "ᎨᏣᎦᏎᏍᏗ", english: "They are watching you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anagasesdi", syllabary: "ᎠᎾᎦᏎᏍᏗ", english: "They are watching him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "unagasesdi", syllabary: "ᎤᎾᎦᏎᏍᏗ", english: "They are watching it", occurrence: 1],
            [pronoun: "Third Plural", romanized: "geginagasesdi", syllabary: "ᎨᎩᎾᎦᏎᏍᏗ", english: "They are watching you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gogagasesdi", syllabary: "ᎪᎦᎦᏎᏍᏗ", english: "They are watching someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gegagasesdi", syllabary: "ᎨᎦᎦᏎᏍᏗ", english: "They are watching you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gogagasesdi", syllabary: "ᎪᎦᎦᏎᏍᏗ", english: "They are watching others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gesdagasesdi", syllabary: "ᎨᏍᏓᎦᏎᏍᏗ", english: "They are watching you two", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsagasesdi", syllabary: "ᎨᏣᎦᏎᏍᏗ", english: "They are watching you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danagasesdi", syllabary: "ᏓᎾᎦᏎᏍᏗ", english: "They are watching them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "dunagasesdi", syllabary: "ᏚᎾᎦᏎᏍᏗ", english: "They are watching those things", occurrence: 1],
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
