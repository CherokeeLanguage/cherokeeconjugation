package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Want" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.153-155
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -adul-ih-
 *   Present Tense: -adulih-a
 *
 * Verb-book note: "This tense means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToWantPresentSpec extends Specification {

    static final String VERB = "to want"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.153-155"

    // Affix composition as printed:
    static final String STEM = "-adul-ih-"        // Stem I
    static final String TENSE_FORM = "-adulih-a"  // Present Tense (Stem I)

    static final String VERB_BOOK_NOTE =
        "This tense means the action is actually going on at the present time."

    /** The 70 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gvyaduli'a", syllabary: "ᎬᏯᏚᎵᎠ", english: "I want you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsiyaduli'a", syllabary: "ᏥᏯᏚᎵᎠ", english: "I want him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "agwaduliha", syllabary: "ᎠᏆᏚᎵᎭ", english: "I want it", occurrence: 1],
            [pronoun: "First Singular", romanized: "sdvyaduli'a", syllabary: "ᏍᏛᏯᏚᎵᎠ", english: "I want you (two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "itsvyaduli'a", syllabary: "ᎢᏨᏯᏚᎵᎠ", english: "I want you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "gatsiyaduli'a", syllabary: "ᎦᏥᏯᏚᎵᎠ", english: "I want them", occurrence: 1],
            [pronoun: "First Singular", romanized: "dagwaduliha", syllabary: "ᏓᏆᏚᎵᎭ", english: "I want those things", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgwaduliha", syllabary: "ᏍᏆᏚᎵᎭ", english: "You (singular) want me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hiyaduli'a", syllabary: "ᎯᏯᏚᎵᎠ", english: "You (singular) want him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "tsaduliha", syllabary: "ᏣᏚᎵᎭ", english: "You (singular) want it", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sginaduli'a", syllabary: "ᏍᎩᎾᏚᎵᎠ", english: "You (singular) want someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgiyaduli'a", syllabary: "ᏍᎩᏯᏚᎵᎠ", english: "You (singular) want others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "gahiyaduli'a", syllabary: "ᎦᎯᏯᏚᎵᎠ", english: "You (singular) want them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "detsaduliha", syllabary: "ᏕᏣᏚᎵᎭ", english: "You (singular) want those (things)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agwaduliha", syllabary: "ᎠᏆᏚᎵᎭ", english: "S/he wants me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsaduliha", syllabary: "ᏣᏚᎵᎭ", english: "S/he wants you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agaduli'a", syllabary: "ᎠᎦᏚᎵᎠ", english: "S/he wants him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "uduliha", syllabary: "ᎤᏚᎵᎭ", english: "S/he wants it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ginaduliha", syllabary: "ᎩᎾᏚᎵᎭ", english: "S/he wants you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginaduliha", syllabary: "ᎣᎩᎾᏚᎵᎭ", english: "S/he wants someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "igaduliha", syllabary: "ᎢᎦᏚᎵᎭ", english: "S/he wants another (or others), me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ogaduliha", syllabary: "ᎣᎦᏚᎵᎭ", english: "S/he wants others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "sdaduliha", syllabary: "ᏍᏓᏚᎵᎭ", english: "S/he wants you (two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "itsaduliha", syllabary: "ᎢᏣᏚᎵᎭ", english: "S/he wants you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "daduliha", syllabary: "ᏓᏚᎵᎭ", english: "S/he wants them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "duduliha", syllabary: "ᏚᏚᎵᎭ", english: "S/he wants those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginaduli'a", syllabary: "ᏍᎩᎾᏚᎵᎠ", english: "You (two) want me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdaduli'a", syllabary: "ᎡᏍᏓᏚᎵᎠ", english: "You (two) want him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sdaduliha", syllabary: "ᏍᏓᏚᎵᎭ", english: "You (two) want it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desginaduli'a", syllabary: "ᏕᏍᎩᎾᏚᎵᎠ", english: "You (two) want someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "isgiyaduli'a", syllabary: "ᎢᏍᎩᏯᏚᎵᎠ", english: "You (two) want others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "gahiyaduli'a", syllabary: "ᎦᎯᏯᏚᎵᎠ", english: "You (two) want them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdaduliha", syllabary: "ᏕᏍᏓᏚᎵᎭ", english: "You (two) want those (things)", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgiyaduli'a", syllabary: "ᎢᏍᎩᏯᏚᎵᎠ", english: "You (more than two) want me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "etsaduli'a", syllabary: "ᎡᏣᏚᎵᎠ", english: "You (more than two) want him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "itsaduliha", syllabary: "ᎢᏣᏚᎵᎭ", english: "You (more than two) want it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "desgiyaduli'a", syllabary: "ᏕᏍᎩᏯᏚᎵᎠ", english: "You (more than two) want someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "gahiyaduli'a", syllabary: "ᎦᎯᏯᏚᎵᎠ", english: "You (more than two) want them (animate)", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsaduliha", syllabary: "ᏕᏣᏚᎵᎭ", english: "You (more than two) want those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "enaduli'a", syllabary: "ᎡᎾᏚᎵᎠ", english: "We (you and I) want him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "ginaduliha", syllabary: "ᎩᎾᏚᎵᎭ", english: "We (you and I) want it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "degenaduliha", syllabary: "ᏕᎨᎾᏚᎵᎭ", english: "We (you and I) want them", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "deginaduliha", syllabary: "ᏕᎩᎾᏚᎵᎭ", english: "We (you and I) want those things", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvyaduli'a", syllabary: "ᏍᏛᏯᏚᎵᎠ", english: "We (another and I) want you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdaduli'a", syllabary: "ᎣᏍᏓᏚᎵᎠ", english: "We (another and I) want him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "oginaduliha", syllabary: "ᎣᎩᎾᏚᎵᎭ", english: "We (another and I) want it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvyaduli'a", syllabary: "ᏍᏛᏯᏚᎵᎠ", english: "We (another and I) want you (two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdaduliha", syllabary: "ᏙᏍᏓᏚᎵᎭ", english: "We (another and I) want them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "doginaduliha", syllabary: "ᏙᎩᎾᏚᎵᎭ", english: "We (another and I) want those (things)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "itsvyaduli'a", syllabary: "ᎢᏨᏯᏚᎵᎠ", english: "We (others and I) want you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsaduli'a", syllabary: "ᎣᏣᏚᎵᎠ", english: "We (others and I) want him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "oginaduliha", syllabary: "ᎣᎩᎾᏚᎵᎭ", english: "We (others and I) want it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsaduli'a", syllabary: "ᏙᏣᏚᎵᎠ", english: "We (others and I) want them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dogaduliha", syllabary: "ᏙᎦᏚᎵᎭ", english: "We (others and I) want those (things)", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "otsaduli'a", syllabary: "ᎣᏣᏚᎵᎠ", english: "We (you and I and other or others) want him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "ogaduliha", syllabary: "ᎣᎦᏚᎵᎭ", english: "We (you and I and other or others) want it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "gedaduli'a", syllabary: "ᎨᏓᏚᎵᎠ", english: "We (you and I and other or others) want them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "degaduliha", syllabary: "ᏕᎦᏚᎵᎭ", english: "We (you and I and other or others) want those (things)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gvgwaduliha", syllabary: "ᎬᏆᏚᎵᎭ", english: "They want me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsaduliha", syllabary: "ᎨᏣᏚᎵᎭ", english: "They want you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anaduliha", syllabary: "ᎠᎾᏚᎵᎭ", english: "They want him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "unaduliha", syllabary: "ᎤᎾᏚᎵᎭ", english: "They want it", occurrence: 1],
            [pronoun: "Third Plural", romanized: "geginaduliha", syllabary: "ᎨᎩᎾᏚᎵᎭ", english: "They want you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "goginaduliha", syllabary: "ᎪᎩᎾᏚᎵᎭ", english: "They want someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gegaduliha", syllabary: "ᎨᎦᏚᎵᎭ", english: "They want you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gogaduliha", syllabary: "ᎪᎦᏚᎵᎭ", english: "They want others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gesdaduliha", syllabary: "ᎨᏍᏓᏚᎵᎭ", english: "They want you (two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsaduliha", syllabary: "ᎨᏣᏚᎵᎭ", english: "They want you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danaduliha", syllabary: "ᏓᎾᏚᎵᎭ", english: "They want them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "dunaduliha", syllabary: "ᏚᎾᏚᎵᎭ", english: "They want those things", occurrence: 1],
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
