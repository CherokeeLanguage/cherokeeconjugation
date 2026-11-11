package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Stop someone or something" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.122-124
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -alehwisdod-ih-
 *   Present Tense: -alehwisdodih-a
 *
 * Verb-book note: "This verb means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToStopSomeoneOrSomethingPresentSpec extends Specification {

    static final String VERB = "to stop someone or something"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.122-124"

    // Affix composition as printed:
    static final String STEM = "-alehwisdod-ih-"        // Stem I
    static final String TENSE_FORM = "-alehwisdodih-a"  // Present Tense (Stem I)

    static final String VERB_BOOK_NOTE =
        "This verb means the action is actually going on at the present time."

    /** The 71 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gvyalehwisdodiha", syllabary: "ᎬᏯᎴᏫᏍᏙᏗᎭ", english: "I am stopping you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsiyalehwisdodiha", syllabary: "ᏥᏯᎴᏫᏍᏙᏗᎭ", english: "I am stopping him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "galehwisdodiha", syllabary: "ᎦᎴᏫᏍᏙᏗᎭ", english: "I am stopping it", occurrence: 1],
            [pronoun: "First Singular", romanized: "sdvyalehwisdodiha", syllabary: "ᏍᏛᏯᎴᏫᏍᏙᏗᎭ", english: "I am stopping you (two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "itsvyalehwisdodiha", syllabary: "ᎢᏨᏯᎴᏫᏍᏙᏗᎭ", english: "I am stopping you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "gatsiyalehwisdodiha", syllabary: "ᎦᏥᏯᎴᏫᏍᏙᏗᎭ", english: "I am stopping them", occurrence: 1],
            [pronoun: "First Singular", romanized: "degalehwisdodiha", syllabary: "ᏕᎦᎴᏫᏍᏙᏗᎭ", english: "I am stopping those things", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgwalehwisdodiha", syllabary: "ᏍᏆᎴᏫᏍᏙᏗᎭ", english: "You (singular) are stopping me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hiyalehwisdodiha", syllabary: "ᎯᏯᎴᏫᏍᏙᏗᎭ", english: "You (singular) are stopping him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "halehwisdodiha", syllabary: "ᎭᎴᏫᏍᏙᏗᎭ", english: "You (singular) are stopping it", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sginalehwisdodiha", syllabary: "ᏍᎩᎾᎴᏫᏍᏙᏗᎭ", english: "You (singular) are stopping someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "isgiyalehwisdodiha", syllabary: "ᎢᏍᎩᏯᎴᏫᏍᏙᏗᎭ", english: "You (singular) are stopping others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "gahiyalehwisdodiha", syllabary: "ᎦᎯᏯᎴᏫᏍᏙᏗᎭ", english: "You (singular) are stopping them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "dehalehwisdodiha", syllabary: "ᏕᎭᎴᏫᏍᏙᏗᎭ", english: "You (singular) are stopping those things", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agwalehwisdodiha", syllabary: "ᎠᏆᎴᏫᏍᏙᏗᎭ", english: "S/he is stopping me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsalehwisdodiha", syllabary: "ᏣᎴᏫᏍᏙᏗᎭ", english: "S/he is stopping you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "alehwisdodiha", syllabary: "ᎠᎴᏫᏍᏙᏗᎭ", english: "S/he is stopping him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "alehwisdodiha", syllabary: "ᎠᎴᏫᏍᏙᏗᎭ", english: "S/he is stopping it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ginalehwisdodiha", syllabary: "ᏍᎩᎾᎴᏫᏍᏙᏗᎭ", english: "S/he is stopping you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginalehwisdodiha", syllabary: "ᎣᎩᎾᎴᏫᏍᏙᏗᎭ", english: "S/he is stopping someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "igalehwisdodiha", syllabary: "ᎢᎦᎴᏫᏍᏙᏗᎭ", english: "S/he is stopping another, or others, me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ogalehwisdodiha", syllabary: "ᎣᎦᎴᏫᏍᏙᏗᎭ", english: "S/he is stopping others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "sdalehwisdodiha", syllabary: "ᏍᏓᎴᏫᏍᏙᏗᎭ", english: "S/he is stopping you two", occurrence: 1],
            [pronoun: "Third Singular", romanized: "itsalehwisdodiha", syllabary: "ᎢᏣᎴᏫᏍᏙᏗᎭ", english: "S/he is stopping you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dalehwisdodiha", syllabary: "ᏓᎴᏫᏍᏙᏗᎭ", english: "S/he is stopping them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dalehwisdodiha", syllabary: "ᏓᎴᏫᏍᏙᏗᎭ", english: "S/he is stopping those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginalehwisdodiha", syllabary: "ᏍᎩᎾᎴᏫᏍᏙᏗᎭ", english: "You two are stopping me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdalehwisdodiha", syllabary: "ᎡᏍᏓᎴᏫᏍᏙᏗᎭ", english: "You two are stopping him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sdalehwisdodiha", syllabary: "ᏍᏓᎴᏫᏍᏙᏗᎭ", english: "You two are stopping it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "geginalehwisdodiha", syllabary: "ᎨᎩᎾᎴᏫᏍᏙᏗᎭ", english: "You two are stopping someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desgiyalehwisdodiha", syllabary: "ᏕᏍᎩᏯᎴᏫᏍᏙᏗᎭ", english: "You two are stopping others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdalehwisdodiha", syllabary: "ᏕᏍᏓᎴᏫᏍᏙᏗᎭ", english: "You two are stopping them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdalehwisdodiha", syllabary: "ᏕᏍᏓᎴᏫᏍᏙᏗᎭ", english: "You two are stopping those things", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgiyalehwisdodiha", syllabary: "ᎢᏍᎩᏯᎴᏫᏍᏙᏗᎭ", english: "You (more than two) are stopping me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "etsalehwisdodiha", syllabary: "ᎡᏣᎴᏫᏍᏙᏗᎭ", english: "You (more than two) are stopping him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "itsalehwisdodiha", syllabary: "ᎢᏣᎴᏫᏍᏙᏗᎭ", english: "You (more than two) are stopping it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "goginalehwisdodiha", syllabary: "ᎪᎩᎾᎴᏫᏍᏙᏗᎭ", english: "You (more than two) are stopping someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsalehwisdodiha", syllabary: "ᏕᏣᎴᏫᏍᏙᏗᎭ", english: "You (more than two) are stopping them", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsalehwisdodiha", syllabary: "ᏕᏣᎴᏫᏍᏙᏗᎭ", english: "You (more than two) are stopping those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "enalehwisdodiha", syllabary: "ᎡᎾᎴᏫᏍᏙᏗᎭ", english: "We (you and I) are stopping him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "inalehwisdodiha", syllabary: "ᎢᎾᎴᏫᏍᏙᏗᎭ", english: "We (you and I) are stopping it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "genalehwisdodiha", syllabary: "ᎨᎾᎴᏫᏍᏙᏗᎭ", english: "We (you and I) are stopping them", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "denalehwisdodiha", syllabary: "ᏕᎾᎴᏫᏍᏙᏗᎭ", english: "We (you and I) are stopping those things", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "itsvyalehwisdodiha", syllabary: "ᎢᏨᏯᎴᏫᏍᏙᏗᎭ", english: "We (another and I) are stopping you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "otsalehwisdodiha", syllabary: "ᎣᏣᎴᏫᏍᏙᏗᎭ", english: "We (another and I) are stopping him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "otsalehwisdodiha", syllabary: "ᎣᏣᎴᏫᏍᏙᏗᎭ", english: "We (another and I) are stopping it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "desdvyalehwisdodiha", syllabary: "", english: "We (another and I) are stopping you two", occurrence: 1],  // syllabary not printed in the verb book
            [pronoun: "First Dual Exclusive", romanized: "itsvyalehwisdodiha", syllabary: "ᎢᏨᏯᎴᏫᏍᏙᏗᎭ", english: "We (another and I) are stopping you (more than two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdalehwisdodiha", syllabary: "ᏙᏍᏓᎴᏫᏍᏙᏗᎭ", english: "We (another and I) are stopping them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdalehwisdodiha", syllabary: "ᏙᏍᏓᎴᏫᏍᏙᏗᎭ", english: "We (another and I) are stopping those things", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "itsvyalehwisdodiha", syllabary: "ᎢᏨᏯᎴᏫᏍᏙᏗᎭ", english: "We (others and I) are stopping you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsalehwisdodiha", syllabary: "ᎣᏣᎴᏫᏍᏙᏗᎭ", english: "We (others and I) are stopping him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsalehwisdodiha", syllabary: "ᎣᏣᎴᏫᏍᏙᏗᎭ", english: "We (others and I) are stopping it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsalehwisdodiha", syllabary: "ᏙᏣᎴᏫᏍᏙᏗᎭ", english: "We (others and I) are stopping them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsalehwisdodiha", syllabary: "ᏙᏣᎴᏫᏍᏙᏗᎭ", english: "We (others and I) are stopping those things", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "edalehwisdodiha", syllabary: "ᎡᏓᎴᏫᏍᏙᏗᎭ", english: "We (you and I and another or others) are stopping him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "idalehwisdodiha", syllabary: "ᎢᏓᎴᏫᏍᏙᏗᎭ", english: "We (you and I and another or others) are stopping it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "gedalehwisdodiha", syllabary: "ᎨᏓᎴᏫᏍᏙᏗᎭ", english: "We (you and I and another or others) are stopping them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedalehwisdodiha", syllabary: "ᏕᏓᎴᏫᏍᏙᏗᎭ", english: "We (you and I and another or others) are stopping those things", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gvgwalehwisdodiha", syllabary: "ᎬᏆᎴᏫᏍᏙᏗᎭ", english: "They are stopping me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsalehwisdodiha", syllabary: "ᎨᏣᎴᏫᏍᏙᏗᎭ", english: "They are stopping you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "analehwisdodiha", syllabary: "ᎠᎾᎴᏫᏍᏙᏗᎭ", english: "They are stopping him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "analehwisdodiha", syllabary: "ᎠᎾᎴᏫᏍᏙᏗᎭ", english: "They are stopping it", occurrence: 1],
            [pronoun: "Third Plural", romanized: "geginalehwisdodiha", syllabary: "ᎨᎩᎾᎴᏫᏍᏙᏗᎭ", english: "They are stopping you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "goginalehwisdodiha", syllabary: "ᎪᎩᎾᎴᏫᏍᏙᏗᎭ", english: "They are stopping someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gegalehwisdodiha", syllabary: "ᎨᎦᎴᏫᏍᏙᏗᎭ", english: "They are stopping you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gogalehwisdodiha", syllabary: "ᎪᎦᎴᏫᏍᏙᏗᎭ", english: "They are stopping others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gesdalehwisdodiha", syllabary: "ᎨᏍᏓᎴᏫᏍᏙᏗᎭ", english: "They are stopping you two", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsalehwisdodiha", syllabary: "ᎨᏣᎴᏫᏍᏙᏗᎭ", english: "They are stopping you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danalehwisdodiha", syllabary: "ᏓᎾᎴᏫᏍᏙᏗᎭ", english: "They are stopping them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danalehwisdodiha", syllabary: "ᏓᎾᎴᏫᏍᏙᏗᎭ", english: "They are stopping those things", occurrence: 1],
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
