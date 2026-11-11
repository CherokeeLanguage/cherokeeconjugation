package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Honor Someone or Something" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.82-84
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -lvgwod-ih-
 *   Present Tense: -lvgwodih-a / -lvkwdih-a
 *
 * Verb-book note: "This verb means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHonorSomeoneOrSomethingPresentSpec extends Specification {

    static final String VERB = "to honor someone or something"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.82-84"

    // Affix composition as printed:
    static final String STEM = "-lvgwod-ih-"        // Stem I
    static final String TENSE_FORM = "-lvgwodih-a / -lvkwdih-a"  // Present Tense (Stem I)

    static final String VERB_BOOK_NOTE =
        "This verb means the action is actually going on at the present time."

    /** The 71 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gvlvgwodiha", syllabary: "ᎬᎸᏉᏗᎭ", english: "I am honoring you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsilvgwodiha", syllabary: "ᏥᎸᏉᏗᎭ", english: "I am honoring him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsilvkwdiha", syllabary: "ᏥᎸᏉᏗᎭ", english: "I am honoring it", occurrence: 1],
            [pronoun: "First Singular", romanized: "sdvlvgwodiha", syllabary: "ᏍᏛᎸᏉᏗᎭ", english: "I am honoring you two", occurrence: 1],
            [pronoun: "First Singular", romanized: "itsvlvgwodiha", syllabary: "ᎢᏨᎸᏉᏗᎭ", english: "I am honoring you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "gatsilvgwodiha", syllabary: "ᎦᏥᎸᏉᏗᎭ", english: "I am honoring them", occurrence: 1],
            [pronoun: "First Singular", romanized: "detsilvkwdiha", syllabary: "ᏕᏥᎸᏉᏗᎭ", english: "I am honoring those things", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgilvgwodiha", syllabary: "ᏍᎩᎸᏉᏗᎭ", english: "You (singular) are honoring me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hilvgwodiha", syllabary: "ᎯᎸᏉᏗᎭ", english: "You (singular) are honoring him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hilvkwdiha", syllabary: "ᎯᎸᏉᏗᎭ", english: "You (singular) are honoring it", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sginilvgwodiha", syllabary: "ᏍᎩᏂᎸᏉᏗᎭ", english: "You (singular) are honoring someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "isgilvgwodiha", syllabary: "ᎢᏍᎩᎸᏉᏗᎭ", english: "You (singular) are honoring others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "gahilvgwodiha", syllabary: "ᎦᎯᎸᏉᏗᎭ", english: "You (singular) are honoring them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "dehilvkwdiha", syllabary: "ᏕᎯᎸᏉᏗᎭ", english: "You (singular) are honoring those things", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agilvgwodiha", syllabary: "ᎠᎩᎸᏉᏗᎭ", english: "He/she is honoring me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsalvgwodiha", syllabary: "ᏣᎸᏉᏗᎭ", english: "He/she is honoring you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "galvgwodiha", syllabary: "ᎦᎸᏉᏗᎭ", english: "He/she is honoring him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "galvkwdiha", syllabary: "ᎦᎸᏉᏗᎭ", english: "He/she is honoring it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ginilvgwodiha", syllabary: "ᎩᏂᎸᏉᏗᎭ", english: "He/she is honoring you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginilvgwodiha", syllabary: "ᎣᎩᏂᎸᏉᏗᎭ", english: "He/she is honoring someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "igilvgwodiha", syllabary: "ᎢᎩᎸᏉᏗᎭ", english: "He/she is honoring another (or others), me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ogilvgwodiha", syllabary: "ᎣᎩᎸᏉᏗᎭ", english: "He/she is honoring others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "sdilvgwodiha", syllabary: "ᏍᏗᎸᏉᏗᎭ", english: "He/she is honoring you (two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "gesdilvgwodiha", syllabary: "ᎨᏍᏗᎸᏉᏗᎭ", english: "He/she is honoring you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "degalvgwodiha", syllabary: "ᏕᎦᎸᏉᏗᎭ", english: "He/she is honoring them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "degalvkwdiha", syllabary: "ᏕᎦᎸᏉᏗᎭ", english: "He/she is honoring those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginilvgwodiha", syllabary: "ᏍᎩᏂᎸᏉᏗᎭ", english: "You (two) are honoring me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdilvgwodiha", syllabary: "ᎡᏍᏗᎸᏉᏗᎭ", english: "You (two) are honoring him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sdilvkwdiha", syllabary: "ᏍᏗᎸᏉᏗᎭ", english: "You (two) are honoring it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginilvgwodiha", syllabary: "ᏍᎩᏂᎸᏉᏗᎭ", english: "You (two) are honoring someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "isgilvgwodiha", syllabary: "ᎢᏍᎩᎸᏉᏗᎭ", english: "You (two) are honoring others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "gesdilvgwodiha", syllabary: "ᎨᏍᏗᎸᏉᏗᎭ", english: "You (two) are honoring them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdilvkwdiha", syllabary: "ᏕᏍᏗᎸᏉᏗᎭ", english: "You (two) are honoring those things", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgilvgwodiha", syllabary: "ᎢᏍᎩᎸᏉᏗᎭ", english: "You (more than two) are honoring me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "etsilvgwodiha", syllabary: "ᎡᏥᎸᏉᏗᎭ", english: "You (more than two) are honoring him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "itsilvkwdiha", syllabary: "ᎢᏥᎸᏉᏗᎭ", english: "You (more than two) are honoring it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "desgilvgwodiha", syllabary: "ᏕᏍᎩᎸᏉᏗᎭ", english: "You (more than two) are honoring someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "getsilvgwodiha", syllabary: "ᎨᏥᎸᏉᏗᎭ", english: "You (more than two) are honoring them", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsilvkwdiha", syllabary: "ᏕᏥᎸᏉᏗᎭ", english: "You (more than two) are honoring those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "enilvgwodiha", syllabary: "ᎡᏂᎸᏉᏗᎭ", english: "We (you and I) are honoring him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "inilvkwdiha", syllabary: "ᎢᏂᎸᏉᏗᎭ", english: "We (you and I) are honoring it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "genilvgwodiha", syllabary: "ᎨᏂᎸᏉᏗᎭ", english: "We (you and I) are honoring them", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "denilvkwdiha", syllabary: "ᏕᏂᎸᏉᏗᎭ", english: "We (you and I) are honoring those things", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvlvgwodiha", syllabary: "ᏍᏛᎸᏉᏗᎭ", english: "We (another and I) are honoring you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdilvgwodiha", syllabary: "ᎣᏍᏗᎸᏉᏗᎭ", english: "We (another and I) are honoring him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdilvkwdiha", syllabary: "ᎣᏍᏗᎸᏉᏗᎭ", english: "We (another and I) are honoring it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "desdvlvgwodiha", syllabary: "ᏕᏍᏛᎸᏉᏗᎭ", english: "We (another and I) are honoring you two", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "detsvlvgwodiha", syllabary: "ᏕᏨᎸᏉᏗᎭ", english: "We (another and I) are honoring you (more than two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "gosdilvgwodiha", syllabary: "ᎪᏍᏗᎸᏉᏗᎭ", english: "We (another and I) are honoring them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdilvkwdiha", syllabary: "ᏙᏍᏗᎸᏉᏗᎭ", english: "We (another and I) are honoring those things", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "itsvlvgwodiha", syllabary: "ᎢᏨᎸᏉᏗᎭ", english: "We (others and I) are honoring you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsilvgwodiha", syllabary: "ᎣᏥᎸᏉᏗᎭ", english: "We (others and I) are honoring him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsilvkwdiha", syllabary: "ᎣᏥᎸᏉᏗᎭ", english: "We (others and I) are honoring it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "gotsilvgwodiha", syllabary: "ᎪᏥᎸᏉᏗᎭ", english: "We (others and I) are honoring them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsilvkwdiha", syllabary: "ᏙᏥᎸᏉᏗᎭ", english: "We (others and I) are honoring those things", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "itsvlvgwodiha", syllabary: "ᎢᏨᎸᏉᏗᎭ", english: "We (you and I and another or others) are honoring him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "idilvkwdiha", syllabary: "ᎢᏗᎸᏉᏗᎭ", english: "We (you and I and another or others) are honoring it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "gedilvgwodiha", syllabary: "ᏕᏗᎸᏉᏗᎭ", english: "We (others and I) are honoring them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedilvkwdiha", syllabary: "ᏕᏗᎸᏉᏗᎭ", english: "We (others and I) are honoring those things", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gvgilvgwodiha", syllabary: "ᎬᎩᎸᏉᏗᎭ", english: "They are honoring me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsalvgwodiha", syllabary: "ᎨᏣᎸᏉᏗᎭ", english: "They are honoring you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anilvgwodiha", syllabary: "ᎠᏂᎸᏉᏗᎭ", english: "They are honoring him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anilvkwdiha", syllabary: "ᎠᏂᎸᏉᏗᎭ", english: "They are honoring it", occurrence: 1],
            [pronoun: "Third Plural", romanized: "geginilvgwodiha", syllabary: "ᎨᎩᏂᎸᏉᏗᎭ", english: "They are honoring you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anilvgwodiha", syllabary: "ᎠᏂᎸᏉᏗᎭ", english: "They are honoring someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gegilvgwodiha", syllabary: "ᎨᎩᎸᏉᏗᎭ", english: "They are honoring you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gogilvgwodiha", syllabary: "ᎪᎩᎸᏉᏗᎭ", english: "They are honoring others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gesdilvgwodiha", syllabary: "ᎨᏍᏗᎸᏉᏗᎭ", english: "They are honoring you two", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsilvgwodiha", syllabary: "ᎨᏥᎸᏉᏗᎭ", english: "They are honoring you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danilvgwodiha", syllabary: "ᏓᏂᎸᏉᏗᎭ", english: "They are honoring them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danilvkwdiha", syllabary: "ᏓᏂᎸᏉᏗᎭ", english: "They are honoring those things", occurrence: 1],
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
