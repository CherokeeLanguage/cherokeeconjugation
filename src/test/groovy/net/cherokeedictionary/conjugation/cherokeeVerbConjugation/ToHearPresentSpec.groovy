package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Hear" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.62-64
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -atvg-i'-
 *   Present Tense: -atvgi'-a
 *
 * Verb-book note: "This verb means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHearPresentSpec extends VerbBaseSpec {

    static final String VERB = "to hear"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.62-64"

    // Affix composition as printed:
    static final String STEM = "-atvg-i'-"        // Stem I
    static final String TENSE_FORM = "-atvgi'-a"  // Present Tense (Stem I)

    static final String VERB_BOOK_NOTE =
        "This verb means the action is actually going on at the present time."

    /** The 71 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gvyatvgi'a", syllabary: "ᎬᏯᏛᎩᎠ", english: "I hear you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsiyatvgi'a", syllabary: "ᏥᏯᏛᎩᎠ", english: "I hear him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "gatvgi'a", syllabary: "ᎦᏛᎩᎠ", english: "I hear it", occurrence: 1],
            [pronoun: "First Singular", romanized: "sdvyatvgi'a", syllabary: "ᏍᏛᏯᏛᎩᎠ", english: "I hear you (two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "itsvyatvgi'a", syllabary: "ᎢᏨᏯᏛᎩᎠ", english: "I hear you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "gatsiyatvgi'a", syllabary: "ᎦᏥᏯᏛᎩᎠ", english: "I hear them", occurrence: 1],
            [pronoun: "First Singular", romanized: "degatvgi'a", syllabary: "ᏕᎦᏛᎩᎠ", english: "I hear those things", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgwatvgi'a", syllabary: "ᏍᏆᏛᎩᎠ", english: "You (singular) hear me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hiyatvgi'a", syllabary: "ᎯᏯᏛᎩᎠ", english: "You (singular) hear him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hatvgi'a", syllabary: "ᎭᏛᎩᎠ", english: "You (singular) hear it", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sginatvgi'a", syllabary: "ᏍᎩᎾᏛᎩᎠ", english: "You (singular) hear someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "isgiyatvgi'a", syllabary: "ᎢᏍᎩᏯᏛᎩᎠ", english: "You (singular) hear others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "gahiyatvgi'a", syllabary: "ᎦᎯᏯᏛᎩᎠ", english: "You (singular) hear them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "dehatvgi'a", syllabary: "ᏕᎭᏛᎩᎠ", english: "You (singular) hear those (things)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agwatvgi'a", syllabary: "ᎠᏆᏛᎩᎠ", english: "S/he hears me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsatvgi'a", syllabary: "ᏣᏛᎩᎠ", english: "S/he hears you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agatvgi'a", syllabary: "ᎠᎦᏛᎩᎠ", english: "S/he hears him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "atvgi'a", syllabary: "ᎠᏛᎩᎠ", english: "S/he hears it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ginatvgi'a", syllabary: "ᎩᎾᏛᎩᎠ", english: "S/he hears you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginatvgi'a", syllabary: "ᎣᎩᎾᏛᎩᎠ", english: "S/he hears someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "igatvgi'a", syllabary: "ᎢᎦᏛᎩᎠ", english: "S/he hears another (or others), me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ogatvgi'a", syllabary: "ᎣᎦᏛᎩᎠ", english: "S/he hears others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "sdatvgi'a", syllabary: "ᏍᏓᏛᎩᎠ", english: "S/he hears you (two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "itsatvgi'a", syllabary: "ᎢᏣᏛᎩᎠ", english: "S/he hears you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "datvgi'a", syllabary: "ᏓᏛᎩᎠ", english: "S/he hears them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "datvgi'a", syllabary: "ᏓᏛᎩᎠ", english: "S/he hears those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginatvgi'a", syllabary: "ᏍᎩᎾᏛᎩᎠ", english: "You (two) hear me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdatvgi'a", syllabary: "ᎡᏍᏓᏛᎩᎠ", english: "You (two) hear him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sdatvgi'a", syllabary: "ᏍᏓᏛᎩᎠ", english: "You (two) hear it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desginatvgi'a", syllabary: "ᏕᏍᎩᎾᏛᎩᎠ", english: "You (two) hear someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desgiyatvgi'a", syllabary: "ᏕᏍᎩᏯᏛᎩᎠ", english: "You (two) hear others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "gesdatvgi'a", syllabary: "ᎨᏍᏓᏛᎩᎠ", english: "You (two) hear them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdatvgi'a", syllabary: "ᏕᏍᏓᏛᎩᎠ", english: "You (two) hear those (things)", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgiyatvgi'a", syllabary: "ᎢᏍᎩᏯᏛᎩᎠ", english: "You (more than two) hear me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "etsatvgi'a", syllabary: "ᎡᏣᏛᎩᎠ", english: "You (more than two) hear him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "itsatvgi'a", syllabary: "ᎢᏣᏛᎩᎠ", english: "You (more than two) hear it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "desginatvgi'a", syllabary: "ᏕᏍᎩᎾᏛᎩᎠ", english: "You (more than two) hear someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "getsatvgi'a", syllabary: "ᎨᏣᏛᎩᎠ", english: "You (more than two) hear them", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsatvgi'a", syllabary: "ᏕᏣᏛᎩᎠ", english: "You (more than two) hear those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "enatvgi'a", syllabary: "ᎡᎾᏛᎩᎠ", english: "We (you and I) hear him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "inatvgi'a", syllabary: "ᎢᎾᏛᎩᎠ", english: "We (you and I) hear it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "genatvgi'a", syllabary: "ᎨᎾᏛᎩᎠ", english: "We (you and I) hear them", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "denatvgi'a", syllabary: "ᏕᎾᏛᎩᎠ", english: "We (you and I) hear those things", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvyatvgi'a", syllabary: "ᏍᏛᏯᏛᎩᎠ", english: "We (another and I) hear you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdatvgi'a", syllabary: "ᎣᏍᏓᏛᎩᎠ", english: "We (another and I) hear him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdatvgi'a", syllabary: "ᎣᏍᏓᏛᎩᎠ", english: "We (another and I) hear it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvyatvgi'a", syllabary: "ᏍᏛᏯᏛᎩᎠ", english: "We (another and I) hear you (two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "itsvyatvgi'a", syllabary: "ᎢᏨᏯᏛᎩᎠ", english: "We (another and I) hear you (more than two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "gosdatvgi'a", syllabary: "ᎪᏍᏓᏛᎩᎠ", english: "We (another and I) hear them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dotsatvgi'a", syllabary: "ᏙᏣᏛᎩᎠ", english: "We (another and I) hear those (things)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "itsvyatvgi'a", syllabary: "ᎢᏨᏯᏛᎩᎠ", english: "We (others and I) hear you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsatvgi'a", syllabary: "ᎣᏣᏛᎩᎠ", english: "We (others and I) hear him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsatvgi'a", syllabary: "ᎣᏣᏛᎩᎠ", english: "We (others and I) hear it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "gotsatvgi'a", syllabary: "ᎪᏣᏛᎩᎠ", english: "We (others and I) hear them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsatvgi'a", syllabary: "ᏙᏣᏛᎩᎠ", english: "We (others and I) hear those (things)", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "otsatvgi'a", syllabary: "ᎣᏣᏛᎩᎠ", english: "We (you and I and another or others) hear him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "otsatvgi'a", syllabary: "ᎣᏣᏛᎩᎠ", english: "We (you and I and another or others) hear it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "gedatvgi'a", syllabary: "ᎨᏓᏛᎩᎠ", english: "We (you and I and another or others) hear them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedatvgi'a", syllabary: "ᏕᏓᏛᎩᎠ", english: "We (you and I and another or others) hear those (things)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gvgwatvgi'a", syllabary: "ᎬᏆᏛᎩᎠ", english: "They hear me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsatvgi'a", syllabary: "ᎨᏣᏛᎩᎠ", english: "They hear you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anatvgi'a", syllabary: "ᎠᎾᏛᎩᎠ", english: "They hear him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anatvgi'a", syllabary: "ᎠᎾᏛᎩᎠ", english: "They hear it", occurrence: 1],
            [pronoun: "Third Plural", romanized: "geginatvgi'a", syllabary: "ᎨᎩᎾᏛᎩᎠ", english: "They hear you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "goginatvgi'a", syllabary: "ᎪᎩᎾᏛᎩᎠ", english: "They hear someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gegatvgi'a", syllabary: "ᎨᎦᏛᎩᎠ", english: "They hear you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gogatvgi'a", syllabary: "ᎪᎦᏛᎩᎠ", english: "They hear others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gesdatvgi'a", syllabary: "ᎨᏍᏓᏛᎩᎠ", english: "They hear you (two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsatvgi'a", syllabary: "ᎨᏣᏛᎩᎠ", english: "They hear you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danatvgi'a", syllabary: "ᏓᎾᏛᎩᎠ", english: "They hear them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danatvgi'a", syllabary: "ᏓᎾᏛᎩᎠ", english: "They hear those things", occurrence: 1],
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
