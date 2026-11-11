package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Talk to Someone" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.127-129
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -ahlinohehd-ih-
 *   Present Tense: -ahlinohehdih-a
 *
 * Verb-book note: "This verb means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToTalkToSomeonePresentSpec extends VerbBaseSpec {

    static final String VERB = "to talk to someone"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.127-129"

    // Affix composition as printed:
    static final String STEM = "-ahlinohehd-ih-"        // Stem I
    static final String TENSE_FORM = "-ahlinohehdih-a"  // Present Tense (Stem I)

    static final String VERB_BOOK_NOTE =
        "This verb means the action is actually going on at the present time."

    /** The 70 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gvyalinohediha", syllabary: "ᎬᏯᎵᏃᎮᏗᎭ", english: "I am talking to, or with, you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsiyalinohediha", syllabary: "ᏥᏯᎵᏃᎮᏗᎭ", english: "I am talking to, or with, him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "galinohediha", syllabary: "ᎦᎵᏃᎮᏗᎭ", english: "I am talking to, or with, it", occurrence: 1],
            [pronoun: "First Singular", romanized: "sdvyalinohediha", syllabary: "ᏍᏛᏯᎵᏃᎮᏗᎭ", english: "I am talking to, or with, you (two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "itsvyalinohediha", syllabary: "ᎢᏨᏯᎵᏃᎮᏗᎭ", english: "I am talking to, or with, you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "gatsiyalinohediha", syllabary: "ᎦᏥᏯᎵᏃᎮᏗᎭ", english: "I am talking to, or with, them", occurrence: 1],
            [pronoun: "First Singular", romanized: "degalinohediha", syllabary: "ᏕᎦᎵᏃᎮᏗᎭ", english: "I am talking to, or with, those things", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgwalinohediha", syllabary: "ᏍᏆᎵᏃᎮᏗᎭ", english: "You (singular) are talking to, or with, me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hiyalinohediha", syllabary: "ᎯᏯᎵᏃᎮᏗᎭ", english: "You (singular) are talking to, or with, him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "halinohediha", syllabary: "ᎭᎵᏃᎮᏗᎭ", english: "You (singular) are talking to, or with, it", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sginalinohediha", syllabary: "ᏍᎩᎾᎵᏃᎮᏗᎭ", english: "You (singular) are talking to, or with, someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "isgiyalinohediha", syllabary: "ᎢᏍᎩᏯᎵᏃᎮᏗᎭ", english: "You (singular) are talking to, or with, others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "gahiyalinohediha", syllabary: "ᎦᎯᏯᎵᏃᎮᏗᎭ", english: "You (singular) are talking to, or with, them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "dehalinohediha", syllabary: "ᏕᎭᎵᏃᎮᏗᎭ", english: "You (singular) are talking to, or with, those (things)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agwahlinohediha", syllabary: "ᎠᏆᎵᏃᎮᏗᎭ", english: "S/he is talking to, or with, me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsahlinohediha", syllabary: "ᏣᎵᏃᎮᏗᎭ", english: "S/he is talking to, or with, you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ahlinohediha", syllabary: "ᎠᎵᏃᎮᏗᎭ", english: "S/he is talking to, or with, him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ahlinohediha", syllabary: "ᎠᎵᏃᎮᏗᎭ", english: "S/he is talking to, or with, it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ginahlinohediha", syllabary: "ᎩᎾᎵᏃᎮᏗᎭ", english: "S/he is talking to, or with, you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginahlinohediha", syllabary: "ᎣᎩᎵᏃᎮᏗᎭ", english: "S/he is talking to, or with, someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "igahlinohediha", syllabary: "ᎢᎦᎵᏃᎮᏗᎭ", english: "S/he is talking to, or with, another (or others), me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ogahlinohediha", syllabary: "ᎣᎦᎵᏃᎮᏗᎭ", english: "S/he is talking to, or with, others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "sdahlinohediha", syllabary: "ᏍᏓᎵᏃᎮᏗᎭ", english: "S/he is talking to, or with, you (two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "itsahlinohediha", syllabary: "ᎢᏣᎵᏃᎮᏗᎭ", english: "S/he is talking to, or with, you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dahlinohediha", syllabary: "ᏓᎵᏃᎮᏗᎭ", english: "S/he is talking to, or with, them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dahlinohediha", syllabary: "ᏓᎵᏃᎮᏗᎭ", english: "S/he is talking to, or with, those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginahlinohediha", syllabary: "ᏍᎩᎾᎵᏃᎮᏗᎭ", english: "You (two) are talking to, or with, me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdalinohediha", syllabary: "ᎡᏍᏓᎵᏃᎮᏗᎭ", english: "You (two) are talking to, or with, him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sdalinohediha", syllabary: "ᏍᏓᎵᏃᎮᏗᎭ", english: "You (two) are talking to, or with, it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginalinohediha", syllabary: "ᏍᎩᎾᎵᏃᎮᏗᎭ", english: "You (two) are talking to, or with, someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "isgiyalinohediha", syllabary: "ᎢᏍᎩᏯᎵᏃᎮᏗᎭ", english: "You (two) are talking to, or with, others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdalinohediha", syllabary: "ᏕᏍᏓᎵᏃᎮᏗᎭ", english: "You (two) are talking to, or with, those (things)", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isginahlinohediha", syllabary: "ᏍᎩᎾᎵᏃᎮᏗᎭ", english: "You (more than two) are talking to, or with, me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "etsahlinohediha", syllabary: "ᎡᏣᎵᏃᎮᏗᎭ", english: "You (more than two) are talking to, or with, him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "itsahlinohediha", syllabary: "ᎢᏣᎵᏃᎮᏗᎭ", english: "You (more than two) are talking to, or with, it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgiyahlinohediha", syllabary: "ᎢᏍᎩᏯᎵᏃᎮᏗᎭ", english: "You (more than two) are talking to, or with, someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsahlinohediha", syllabary: "ᏕᏣᎵᏃᎮᏗᎭ", english: "You (more than two) are talking to, or with, them", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsahlinohediha", syllabary: "ᏕᎭᎵᏃᎮᏗᎭ", english: "You (more than two) are talking to, or with, those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "enahlinohediha", syllabary: "ᎡᎾᎵᏃᎮᏗᎭ", english: "We (you and I) are talking to, or with, him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "inahlinohediha", syllabary: "ᎢᎾᎵᏃᎮᏗᎭ", english: "We (you and I) are talking to, or with, it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "denahlinohediha", syllabary: "ᏕᎾᎵᏃᎮᏗᎭ", english: "We (you and I) are talking to, or with, them", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "denahlinohediha", syllabary: "ᏕᎾᎵᏃᎮᏗᎭ", english: "We (you and I) are talking to, or with, those things", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvyahlinohediha", syllabary: "ᏍᏛᏯᎵᏃᎮᏗᎭ", english: "We (another and I) are talking to, or with, you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdahlinohediha", syllabary: "ᎣᏍᏓᎵᏃᎮᏗᎭ", english: "We (another and I) are talking to, or with, him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdahlinohediha", syllabary: "ᎣᏍᏓᎵᏃᎮᏗᎭ", english: "We (another and I) are talking to, or with, it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "desdvyahlinohediha", syllabary: "ᏕᏍᏛᏯᎵᏃᎮᏗᎭ", english: "We (another and I) are talking to, or with, you (two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "itsvyahlinohediha", syllabary: "ᎢᏨᏯᎵᏃᎮᏗᎭ", english: "We (another and I) are talking to, or with, you (more than two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdahlinohediha", syllabary: "ᏕᏍᏓᎵᏃᎮᏗᎭ", english: "We (another and I) are talking to, or with, them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdalinohediha", syllabary: "ᏙᏍᏓᎵᏃᎮᏗᎭ", english: "We (another and I) are talking to, or with, those (things)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "itsvyalinohediha", syllabary: "ᎢᏨᏯᎵᏃᎮᏗᎭ", english: "We (others and I) are talking to, or with, you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsahlinohediha", syllabary: "ᎣᏣᎵᏃᎮᏗᎭ", english: "We (others and I) are talking to, or with, him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsahlinohediha", syllabary: "ᎣᏣᎵᏃᎮᏗᎭ", english: "We (others and I) are talking to, or with, it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsahlinohediha", syllabary: "ᏙᏣᎵᏃᎮᏗᎭ", english: "We (others and I) are talking to, or with, them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsahlinohediha", syllabary: "ᏕᏍᏓᎵᏃᎮᏗᎭ", english: "We (others and I) are talking to, or with, those (things)", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "edahlinohediha", syllabary: "ᎡᏓᎵᏃᎮᏗᎭ", english: "We (you and I and another or others) are talking to, or with, him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "idahlinohediha", syllabary: "ᎣᏣᎵᏃᎮᏗᎭ", english: "We (you and I and another or others) are talking to, or with, it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedahlinohediha", syllabary: "ᎦᏓᎵᏃᎯᏗ", english: "We (you and I and another or others) are talking to, or with, them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedahlinohediha", syllabary: "ᏕᏓᎵᏃᎮᏗᎭ", english: "We (you and I and another or others) are talking to, or with, those (things)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gvgwahlinohediha", syllabary: "ᎬᏆᎵᏃᎮᏗᎭ", english: "They are talking to, or with, me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsahlinohediha", syllabary: "ᎨᏣᎵᏃᎮᏗᎭ", english: "They are talking to, or with, you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anahlinohediha", syllabary: "ᎠᎾᎵᏃᎮᏗᎭ", english: "They are talking to, or with, him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anahlinohediha", syllabary: "ᎠᎾᎵᏃᎮᏗᎭ", english: "They are talking to, or with, it", occurrence: 1],
            [pronoun: "Third Plural", romanized: "geginahlinohediha", syllabary: "ᎨᎩᎾᎵᏃᎮᏗᎭ", english: "They are talking to, or with, you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gogahlinohediha", syllabary: "ᎪᎦᎵᏃᎮᏗᎭ", english: "They are talking to, or with, someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gegahlinohediha", syllabary: "ᏕᎦᎵᏃᎮᏗᎭ", english: "They are talking to, or with, you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "goginahlinohediha", syllabary: "ᎪᎩᎾᎵᏃᎮᏗᎭ", english: "They are talking to, or with, others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gesdahlinohediha", syllabary: "ᎨᏍᏓᎵᏃᎮᏗᎭ", english: "They are talking to, or with, you (two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degetsahlinohediha", syllabary: "ᏕᎨᏣᎵᏃᎮᏗᎭ", english: "They are talking to, or with, you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danahlinohediha", syllabary: "ᏓᎾᎵᏃᎮᏗᎭ", english: "They are talking to, or with, them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danahlinohediha", syllabary: "ᏓᎾᎵᏃᎮᏗᎭ", english: "They are talking to, or with, those things", occurrence: 1],
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

        where: "each of the 70 verb-book rows"
        row << VERB_BOOK
    }

    def "the verb book table is complete (70 rows)"() {
        expect:
        VERB_BOOK.size() == 70
    }
}
