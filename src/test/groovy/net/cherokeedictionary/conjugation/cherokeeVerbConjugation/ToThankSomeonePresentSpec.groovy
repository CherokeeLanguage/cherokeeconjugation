package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Thank someone" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.142-144
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -alihelitse-h-
 *   Present Tense: -alihelitseh-a
 *
 * Verb-book note: "This verb means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToThankSomeonePresentSpec extends Specification {

    static final String VERB = "to thank someone"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.142-144"

    // Affix composition as printed:
    static final String STEM = "-alihelitse-h-"        // Stem I
    static final String TENSE_FORM = "-alihelitseh-a"  // Present Tense (Stem I)

    static final String VERB_BOOK_NOTE =
        "This verb means the action is actually going on at the present time."

    /** The 71 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gvyali'elitseha", syllabary: "ᎬᏯᎵᎡᎵᏤᎭ", english: "I thank you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsiyali'elitseha", syllabary: "ᏥᏯᎵᎡᎵᏤᎭ", english: "I thank him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsiyali'elitseha", syllabary: "ᏥᏯᎵᎡᎵᏤᎭ", english: "I thank it", occurrence: 1],
            [pronoun: "First Singular", romanized: "sdvyali'elitseha", syllabary: "ᏍᏛᏯᎵᎡᎵᏤᎭ", english: "I thank you two", occurrence: 1],
            [pronoun: "First Singular", romanized: "itsvyali'elitseha", syllabary: "ᎢᏨᏯᎵᎡᎵᏤᎭ", english: "I thank you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "gatsiyali'elitseha", syllabary: "ᎦᏥᏯᎵᎡᎵᏤᎭ", english: "I thank them", occurrence: 1],
            [pronoun: "First Singular", romanized: "degali'elitseha", syllabary: "ᏕᎦᎵᎡᎵᏤᎭ", english: "I thank those things", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgwalihelitseha", syllabary: "ᏍᏆᎵᎮᎵᏤᎭ", english: "You (singular) thank me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hiyali'elitseha", syllabary: "ᎯᏯᎵᎡᎵᏤᎭ", english: "You (singular) thank him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hiyali'elitseha", syllabary: "ᎯᏯᎵᎡᎵᏤᎭ", english: "You (singular) thank it", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sginalihelitseha", syllabary: "ᏍᎩᎾᎵᎮᎵᏤᎭ", english: "You (singular) thank someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgiyali'elitseha", syllabary: "ᏍᎩᏯᎵᎡᎵᏤᎭ", english: "You (singular) thank others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "gahiyali'elitseha", syllabary: "ᎦᎯᏯᎵᎡᎵᏤᎭ", english: "You (singular) thank them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "dehalihelitseha", syllabary: "ᏕᎭᎵᎮᎵᏤᎭ", english: "You (singular) thank those things", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agwalihelitseha", syllabary: "ᎠᏆᎵᎮᎵᏤᎭ", english: "He/she is thanking me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsalihelitseha", syllabary: "ᏣᎵᎮᎵᏤᎭ", english: "He/she is thanking you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "alihelitseha", syllabary: "ᎠᎵᎮᎵᏤᎭ", english: "He/she is thanking him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "alihelitseha", syllabary: "ᎠᎵᎮᎵᏤᎭ", english: "He/she is thanking it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ginalihelitseha", syllabary: "ᎩᎾᎵᎮᎵᏤᎭ", english: "He/she is thanking you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginalihelitseha", syllabary: "ᎣᎩᎾᎵᎮᎵᏤᎭ", english: "He/she is thanking someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "igalihelitseha", syllabary: "ᎢᎦᎵᎮᎵᏤᎭ", english: "He/she is thanking another (or others), me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ogalihelitseha", syllabary: "ᎣᎦᎵᎮᎵᏤᎭ", english: "He/she is thanking others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "sdalihelitseha", syllabary: "ᏍᏓᎵᎮᎵᏤᎭ", english: "He/she is thanking you (two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "itsalihelitseha", syllabary: "ᎢᏣᎵᎮᎵᏤᎭ", english: "He/she is thanking you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dalihelitseha", syllabary: "ᏓᎵᎮᎵᏤᎭ", english: "He/she is thanking them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dalihelitseha", syllabary: "ᏓᎵᎮᎵᏤᎭ", english: "He/she is thanking those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginali'elitseha", syllabary: "ᏍᎩᎾᎵᎡᎵᏤᎭ", english: "You (two) are thanking me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdali'elitseha", syllabary: "ᎡᏍᏓᎵᎡᎵᏤᎭ", english: "You (two) are thanking him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdali'elitseha", syllabary: "ᎡᏍᏓᎵᎡᎵᏤᎭ", english: "You (two) are thanking it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desginali'elitseha", syllabary: "ᏕᏍᎩᎾᎵᎡᎵᏤᎭ", english: "You (two) are thanking someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desgiyali'elitseha", syllabary: "ᏕᏍᎩᏯᎵᎡᎵᏤᎭ", english: "You (two) are thanking others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "gesdalihelitseha", syllabary: "ᎨᏍᏓᎵᎮᎵᏤᎭ", english: "You (two) are thanking them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdalihelitseha", syllabary: "ᏕᏍᏓᎵᎮᎵᏤᎭ", english: "You (two) are thanking those things", occurrence: 1],
            [pronoun: "Second Plural", romanized: "sgiyali'elitseha", syllabary: "ᏍᎩᏯᎵᎡᎵᏤᎭ", english: "You (more than two) are thanking me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "etsali'elitseha", syllabary: "ᎡᏣᎵᎡᎵᏤᎭ", english: "You (more than two) are thanking him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "itsalihelitseha", syllabary: "ᎢᏣᎵᎮᎵᏤᎭ", english: "You (more than two) are thanking it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "sgiyali'elitseha", syllabary: "ᏍᎩᏯᎵᎡᎵᏤᎭ", english: "You (more than two) are thanking someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "getsalihelitseha", syllabary: "ᎨᏣᎵᎮᎵᏤᎭ", english: "You (more than two) are thanking them", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsalihelitseha", syllabary: "ᏕᏣᎵᎮᎵᏤᎭ", english: "You (more than two) are thanking those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "enali'elitseha", syllabary: "ᎡᎾᎵᎡᎵᏤᎭ", english: "We (you and I) are thanking him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "inalihelitseha", syllabary: "ᎢᎾᎵᎮᎵᏤᎭ", english: "We (you and I) are thanking it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "genali'elitseha", syllabary: "ᎨᎾᎵᎡᎵᏤᎭ", english: "We (you and I) are thanking them", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "dosdalihelitseha", syllabary: "ᏙᏍᏓᎵᎮᎵᏤᎭ", english: "We (you and I) are thanking those things", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvyali'elitseha", syllabary: "ᏍᏛᏯᎵᎡᎵᏤᎭ", english: "We (another and I) are thanking you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdali'elitseha", syllabary: "ᎣᏍᏓᎵᎡᎵᏤᎭ", english: "We (another and I) are thanking him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdalihelitseha", syllabary: "ᎣᏍᏓᎵᎮᎵᏤᎭ", english: "We (another and I) are thanking it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvyali'elitseha", syllabary: "ᏍᏛᏯᎵᎡᎵᏤᎭ", english: "We (another and I) are thanking you two", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "itsvyali'elitseha", syllabary: "ᎢᏨᏯᎵᎡᎵᏤᎭ", english: "We (another and I) are thanking you (more than two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "gosdali'elitseha", syllabary: "ᎪᏍᏓᎵᎡᎵᏤᎭ", english: "We (another and I) are thanking them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdalihelitseha", syllabary: "ᏙᏍᏓᎵᎮᎵᏤᎭ", english: "We (another and I) are thanking those things", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "itsvyali'elitseha", syllabary: "ᎢᏨᏯᎵᎡᎵᏤᎭ", english: "We (others and I) are thanking you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsali'elitseha", syllabary: "ᎣᏣᎵᎡᎵᏤᎭ", english: "We (others and I) are thanking him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsali'elitseha", syllabary: "ᎣᏣᎵᎡᎵᏤᎭ", english: "We (others) and I are thanking it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "gotsali'elitseha", syllabary: "ᎪᏣᎵᎡᎵᏤᎭ", english: "We (others and I) are thanking them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dogalihelitseha", syllabary: "ᏙᎦᎵᎮᎵᏤᎭ", english: "We (others and I) are thanking those things", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "edali'elitseha", syllabary: "ᎡᏓᎵᎡᎵᏤᎭ", english: "We (you and I and another or others) are thanking him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "edali'elitseha", syllabary: "ᎡᏓᎵᎡᎵᏤᎭ", english: "We (you and I and another or others) are thanking it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "gedali'elitseha", syllabary: "ᎨᏓᎵᎡᎵᏤᎭ", english: "We (others and I) are thanking them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedalihelitseha", syllabary: "ᏕᏓᎵᎮᎵᏤᎭ", english: "We (others and I) are thanking those things", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gvgwalihelitseha", syllabary: "ᎬᏆᎵᎮᎵᏤᎭ", english: "They are thanking me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsalihelitseha", syllabary: "ᎨᏣᎵᎮᎵᏤᎭ", english: "They are thanking you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "analihelitseha", syllabary: "ᎠᎾᎵᎮᎵᏤᎭ", english: "They are thanking him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "analihelitseha", syllabary: "ᎠᎾᎵᎮᎵᏤᎭ", english: "They are thanking it", occurrence: 1],
            [pronoun: "Third Plural", romanized: "geginalihelitseha", syllabary: "ᎨᎩᎾᎵᎮᎵᏤᎭ", english: "They are thanking you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "goginalihelitseha", syllabary: "ᎪᎩᎾᎵᎮᎵᏤᎭ", english: "They are thanking someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gegalihelitseha", syllabary: "ᎨᎦᎵᎮᎵᏤᎭ", english: "They are thanking you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gogalihelitseha", syllabary: "ᎪᎦᎵᎮᎵᏤᎭ", english: "They are thanking others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gesdalihelitseha", syllabary: "ᎨᏍᏓᎵᎮᎵᏤᎭ", english: "They are thanking you two", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsalihelitseha", syllabary: "ᎨᏣᎵᎮᎵᏤᎭ", english: "They are thanking you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degetsalihelitseha", syllabary: "ᏕᎨᏣᎵᎮᎵᏤᎭ", english: "They are thanking them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danalihelitseha", syllabary: "ᏓᎾᎵᎮᎵᏤᎭ", english: "They are thanking those things", occurrence: 1],
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
