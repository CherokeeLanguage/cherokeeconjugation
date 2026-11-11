package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Like someone or something" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.92-94
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -lvgwod-Ø-
 *   Present Tense: -lvgwod-i / -lvkwd-i
 *
 * Verb-book note: "Note - this tense means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToLikeSomeoneOrSomethingPresentSpec extends VerbBaseSpec {

    static final String VERB = "to like someone or something"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.92-94"

    // Affix composition as printed:
    static final String STEM = "-lvgwod-Ø-"        // Stem I
    static final String TENSE_FORM = "-lvgwod-i / -lvkwd-i"  // Present Tense (Stem I)

    static final String VERB_BOOK_NOTE =
        "Note - this tense means the action is actually going on at the present time."

    /** The 71 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gvlvgwodi", syllabary: "ᎬᎸᏉᏗ", english: "I like you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsilvgwodi", syllabary: "ᏥᎸᏉᏗ", english: "I like him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "agilvkwdi", syllabary: "ᎠᎩᎸᏉᏗ", english: "I like it", occurrence: 1],
            [pronoun: "First Singular", romanized: "sdvlvgwodi", syllabary: "ᏍᏛᎸᏉᏗ", english: "I like you (two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "itsvlvgwodi", syllabary: "ᎢᏨᎸᏉᏗ", english: "I like you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "gatsilvgwodi", syllabary: "ᎦᏥᎸᏉᏗ", english: "I like them", occurrence: 1],
            [pronoun: "First Singular", romanized: "dagilvkwdi", syllabary: "ᏓᎩᎸᏉᏗ", english: "I like those things", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgilvgwodi", syllabary: "ᏍᎩᎸᏉᏗ", english: "You (singular) like me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hilvgwodi", syllabary: "ᎯᎸᏉᏗ", english: "You (singular) like him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "tsalvkwdi", syllabary: "ᏣᎸᏉᏗ", english: "You (singular) like it", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sginilvgwodi", syllabary: "ᏍᎩᏂᎸᏉᏗ", english: "You (singular) like someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "isgilvgwodi", syllabary: "ᎢᏍᎩᎸᏉᏗ", english: "You (singular) like others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "gahilvgwodi", syllabary: "ᎦᎯᎸᏉᏗ", english: "You (singular) like them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "detsalvkwdi", syllabary: "ᏕᏣᎸᏉᏗ", english: "You (singular) like those things", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agilvgwodi", syllabary: "ᎠᎩᎸᏉᏗ", english: "He/she likes me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsalvgwodi", syllabary: "ᏣᎸᏉᏗ", english: "He/she likes you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ulvgwodi", syllabary: "ᎤᎸᏉᏗ", english: "He/she likes him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ulvkwdi", syllabary: "ᎤᎸᏉᏗ", english: "He/she likes it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ginilvgwodi", syllabary: "ᎩᏂᎸᏉᏗ", english: "He/she likes you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginilvgwodi", syllabary: "ᎣᎩᏂᎸᏉᏗ", english: "He/she likes someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "igilvgwodi", syllabary: "ᎢᎩᎸᏉᏗ", english: "He/she likes another, or others, me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ogilvgwodi", syllabary: "ᎣᎩᎸᏉᏗ", english: "He/she likes others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "sdilvgwodi", syllabary: "ᏍᏗᎸᏉᏗ", english: "He/she likes you two", occurrence: 1],
            [pronoun: "Third Singular", romanized: "itsilvgwodi", syllabary: "ᎢᏥᎸᏉᏗ", english: "He/she likes you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dulvgwodi", syllabary: "ᏚᎸᏉᏗ", english: "He/she likes them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dulvkwdi", syllabary: "ᏚᎸᏉᏗ", english: "He/she likes those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginilvgwodi", syllabary: "ᏍᎩᏂᎸᏉᏗ", english: "You two like me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdilvgwodi", syllabary: "ᎡᏍᏗᎸᏉᏗ", english: "You two like him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sdilvkwdi", syllabary: "ᏍᏗᎸᏉᏗ", english: "You two like it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desginilvgwodi", syllabary: "ᏕᏍᎩᏂᎸᏉᏗ", english: "You two like someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desgilvgwodi", syllabary: "ᏕᏍᎩᎸᏉᏗ", english: "You two like others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdilvgwodi", syllabary: "ᏕᏍᏗᎸᏉᏗ", english: "You two like them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdilvkwdi", syllabary: "ᏕᏍᏗᎸᏉᏗ", english: "You two like those things", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgilvgwodi", syllabary: "ᎢᏍᎩᎸᏉᏗ", english: "You (more than two) like me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "etsilvgwodi", syllabary: "ᎡᏥᎸᏉᏗ", english: "You (more than two) like him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "itsilvkwdi", syllabary: "ᎢᏥᎸᏉᏗ", english: "You (more than two) like it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgilvgwodi", syllabary: "ᎢᏍᎩᎸᏉᏗ", english: "You (more than two) like someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsilvgwodi", syllabary: "ᏕᏥᎸᏉᏗ", english: "You (more than two) like them", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsilvkwdi", syllabary: "ᏕᏥᎸᏉᏗ", english: "You (more than two) like those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "enilvgwodi", syllabary: "ᎡᏂᎸᏉᏗ", english: "We (you and I) like him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "ginilvkwdi", syllabary: "ᎩᏂᎸᏉᏗ", english: "We (you and I) like it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "degenilvgwodi", syllabary: "ᏕᎨᏂᎸᏉᏗ", english: "We (you and I) like them", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "deginilvkwdi", syllabary: "ᏕᎩᏂᎸᏉᏗ", english: "We (you and I) like those things", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "itsvlvgwodi", syllabary: "ᎢᏨᎸᏉᏗ", english: "We (another and I) like you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdilvgwodi", syllabary: "ᎣᏍᏗᎸᏉᏗ", english: "We (another and I) like him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "oginilvkwdi", syllabary: "ᎣᎩᏂᎸᏉᏗ", english: "We (another and I) like it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "desdvlvgwodi", syllabary: "ᏕᏍᏛᎸᏉᏗ", english: "We (another and I) like you two", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "detsvlvgwodi", syllabary: "ᏕᏨᎸᏉᏗ", english: "We (another and I) like you (more than two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdilvgwodi", syllabary: "ᏙᏍᏗᎸᏉᏗ", english: "We (another and I) like them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "doginilvkwdi", syllabary: "ᏙᎩᏂᎸᏉᏗ", english: "We (another and I) like those things", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "itsvlvgwodi", syllabary: "ᎢᏨᎸᏉᏗ", english: "We (others and I) like you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsilvgwodi", syllabary: "ᎣᏥᎸᏉᏗ", english: "We (others and I) like him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "ogilvkwdi", syllabary: "ᎣᎩᎸᏉᏗ", english: "We (others and I) like it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsilvgwodi", syllabary: "ᏙᏥᎸᏉᏗ", english: "We (others and I) like them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dogilvkwdi", syllabary: "ᏙᎩᎸᏉᏗ", english: "We (others and I) like those things", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "otsilvgwodi", syllabary: "ᎣᏥᎸᏉᏗ", english: "We (you and I and another or others) like him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "ogilvkwdi", syllabary: "ᎣᎩᎸᏉᏗ", english: "We (you and I and another or others) like it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedilvgwodi", syllabary: "ᏕᏗᎸᏉᏗ", english: "We (you and I and another or others) like them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "degilvkwdi", syllabary: "ᏕᎩᎸᏉᏗ", english: "We (you and I and another or others) like those things", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gvgilvgwodi", syllabary: "ᎬᎩᎸᏉᏗ", english: "They like me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsalvgwodi", syllabary: "ᎨᏣᎸᏉᏗ", english: "They like you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "unilvgwodi", syllabary: "ᎤᏂᎸᏉᏗ", english: "They like him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "dunilvgwodi", syllabary: "ᏚᏂᎸᏉᏗ", english: "They like them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degeginilvgwodi", syllabary: "ᏕᎨᎩᏂᎸᏉᏗ", english: "They like you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degoginilvgwodi", syllabary: "ᏕᎪᎩᏂᎸᏉᏗ", english: "They like someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degegilvgwodi", syllabary: "ᏕᎨᎩᎸᏉᏗ", english: "They like you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degogilvgwodi", syllabary: "ᏕᎪᎩᎸᏉᏗ", english: "They like others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degesdilvgwodi", syllabary: "ᏕᎨᏍᏗᎸᏉᏗ", english: "They like you two", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degetsilvgwodi", syllabary: "ᏕᎨᏥᎸᏉᏗ", english: "They like you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degetsilvgwodi", syllabary: "ᏕᎨᏥᎸᏉᏗ", english: "They like them", occurrence: 2],
            [pronoun: "Third Plural", romanized: "dunilvkwdi", syllabary: "ᏚᏂᎸᏉᏗ", english: "They like those things", occurrence: 1],
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
