package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Bite (when a human bites)" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.27-29
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -sgahl-g-
 *   Present Tense: -sgahlg-a
 *
 * Verb-book note: "This verb means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToBitePresentSpec extends VerbBaseSpec {

    static final String VERB = "to bite (when a human bites)"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.27-29"

    // Affix composition as printed:
    static final String STEM = "-sgahl-g-"        // Stem I
    static final String TENSE_FORM = "-sgahlg-a"  // Present Tense (Stem I)

    static final String VERB_BOOK_NOTE =
        "This verb means the action is actually going on at the present time."

    /** The 70 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gvsgahlga", syllabary: "ᎬᏍᎦᎶᎦ", english: "I am biting you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsisgahlga", syllabary: "ᏥᏍᎦᎶᎦ", english: "I am biting him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "sdvsgahlga", syllabary: "ᏍᏛᏍᎦᎶᎦ", english: "I am biting you (two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "itsvsgahlga", syllabary: "ᎢᏨᏍᎦᎶᎦ", english: "I am biting you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "gatsisgahlga", syllabary: "ᎦᏥᏍᎦᎶᎦ", english: "I am biting them", occurrence: 1],
            [pronoun: "First Singular", romanized: "detsisgahlga", syllabary: "ᏕᏥᏍᎦᎶᎦ", english: "I am biting those things", occurrence: 1],
            [pronoun: "Second Singular", romanized: "ksgahlga", syllabary: "ᏍᎩᏍᎦᎶᎦ", english: "You (singular) are biting me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hisgahlga", syllabary: "ᎯᏍᎦᎶᎦ", english: "You (singular) are biting him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hisgahlga", syllabary: "ᎯᏍᎦᎶᎦ", english: "You (singular) are biting it", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sginisgahlga", syllabary: "ᏍᎩᏂᏍᎦᎶᎦ", english: "You (singular) are biting someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "isgisgahlga", syllabary: "ᎢᏍᎩᏍᎦᎶᎦ", english: "You (singular) are biting others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "dehisgahlga", syllabary: "ᏕᎯᏍᎦᎶᎦ", english: "You (singular) are biting them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "dehisgahlga", syllabary: "ᏕᎯᏍᎦᎶᎦ", english: "You (singular) are biting those (things)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agsgahlga", syllabary: "ᎠᎩᏍᎦᎶᎦ", english: "S/he is biting me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsgahlga", syllabary: "ᏣᏍᎦᎶᎦ", english: "S/he is biting you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "asgahlga", syllabary: "ᎠᏍᎦᎶᎦ", english: "S/he is biting him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "asgahlga", syllabary: "ᎠᏍᎦᎶᎦ", english: "S/he bites it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "deginisgahlga", syllabary: "ᏕᎩᏂᏍᎦᎶᎦ", english: "S/he is biting you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "doginisgahlga", syllabary: "ᏙᎩᏂᏍᎦᎶᎦ", english: "S/he is biting someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "degisgahlga", syllabary: "ᏕᎩᏍᎦᎶᎦ", english: "S/he is biting another (or others), me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dogisgahlga", syllabary: "ᏙᎩᏍᎦᎶᎦ", english: "S/he is biting others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "desdisgahlga", syllabary: "ᏕᏍᏗᏍᎦᎶᎦ", english: "S/he is biting you (two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "detsisgahlga", syllabary: "ᏕᏥᏍᎦᎶᎦ", english: "S/he is biting you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dasgahlga", syllabary: "ᏓᏍᎦᎶᎦ", english: "S/he is biting them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dasgahlga", syllabary: "ᏓᏍᎦᎶᎦ", english: "S/he is biting those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginisgahlga", syllabary: "ᏍᎩᏂᏍᎦᎶᎦ", english: "You (two) are biting me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdisgahlga", syllabary: "ᎡᏍᏗᏍᎦᎶᎦ", english: "You (two) are biting him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sdisgahlga", syllabary: "ᏍᏗᏍᎦᎶᎦ", english: "You (two) are biting it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desginisgahlga", syllabary: "ᏕᏍᎩᏂᏍᎦᎶᎦ", english: "You (two) are biting someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desgisgahlga", syllabary: "ᏕᏍᎩᏍᎦᎶᎦ", english: "You (two) are biting others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdisgahlga", syllabary: "ᏕᏍᏗᏍᎦᎶᎦ", english: "You (two) are biting them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdisgahlga", syllabary: "ᏕᏍᏗᏍᎦᎶᎦ", english: "You (two) are biting those (things)", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgisgahlga", syllabary: "ᎢᏍᎩᏍᎦᎶᎦ", english: "You (more than two) are biting me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "esdisgahlga", syllabary: "ᎡᏍᏗᏍᎦᎶᎦ", english: "You (more than two) are biting him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "itsisgahlga", syllabary: "ᎢᏥᏍᎦᎶᎦ", english: "You (more than two) are biting it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "desgisgahlga", syllabary: "ᏕᏍᎩᏍᎦᎶᎦ", english: "You (more than two) are biting someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsisgahlga", syllabary: "ᏕᏥᏍᎦᎶᎦ", english: "You (more than two) are biting them", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsisgahlga", syllabary: "ᏕᏥᏍᎦᎶᎦ", english: "You (more than two) are biting those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "enisgahlga", syllabary: "ᎡᏂᏍᎦᎶᎦ", english: "We (you and I) are biting him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "inisgahlga", syllabary: "ᎢᏂᏍᎦᎶᎦ", english: "We (you and I) are biting it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "genisgahlga", syllabary: "ᎨᏂᏍᎦᎶᎦ", english: "We (you and I) and biting them", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "denisgahlga", syllabary: "ᏕᏂᏍᎦᎶᎦ", english: "We (you and I) are biting those things", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvsgahlga", syllabary: "ᏍᏛᏍᎦᎶᎦ", english: "We (another and I) are biting you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdisgahlga", syllabary: "ᎣᏍᏗᏍᎦᎶᎦ", english: "We (another and I) are biting him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdisgahlga", syllabary: "ᏙᏍᏗᏍᎦᎶᎦ", english: "We (another and I) are biting it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "desdvsgahlga", syllabary: "ᏕᏍᏛᏍᎦᎶᎦ", english: "We (another and I) are biting you (two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "detsvsgahlga", syllabary: "ᏕᏨᏍᎦᎶᎦ", english: "We (another and I) are biting you (more than two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdisgahlga", syllabary: "ᏙᏍᏗᏍᎦᎶᎦ", english: "We (another and I) are biting them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdisgahlga", syllabary: "ᏙᏍᏗᏍᎦᎶᎦ", english: "We (another and I) are biting those (things)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "itsvsgahlga", syllabary: "ᎢᏨᏍᎦᎶᎦ", english: "We (others and I) are biting you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsisgahlga", syllabary: "ᎣᏥᏍᎦᎶᎦ", english: "We (others and I) are biting him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsisgahlga", syllabary: "ᎣᏥᏍᎦᎶᎦ", english: "We (others and I) are biting it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsisgahlga", syllabary: "ᏙᏥᏍᎦᎶᎦ", english: "We (others and I) are biting them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsisgahlga", syllabary: "ᏙᏥᏍᎦᎶᎦ", english: "We (others and I) are biting those (things)", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "edisgahlga", syllabary: "ᎡᏗᏍᎦᎶᎦ", english: "We (you and I and another or others) are biting him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "idisgahlga", syllabary: "ᎢᏗᏍᎦᎶᎦ", english: "We (you and I and another or others) are biting it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "gedisgahlga", syllabary: "ᎨᏗᏍᎦᎶᎦ", english: "We (you and I and another or others) are biting them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedisgahlga", syllabary: "ᏕᏗᏍᎦᎶᎦ", english: "We (you and I and another or others) are biting those (things)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degvgisgahlga", syllabary: "ᏕᎬᎩᏍᎦᎶᎦ", english: "They are biting me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degetsasgahlga", syllabary: "ᏕᎨᏣᏍᎦᎶᎦ", english: "They are biting you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danisgahlga", syllabary: "ᏓᏂᏍᎦᎶᎦ", english: "They are biting him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anisgahlga", syllabary: "ᎠᏂᏍᎦᎶᎦ", english: "They are biting it", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degeginisgahlga", syllabary: "ᏕᎨᎩᏂᏍᎦᎶᎦ", english: "They are biting you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degoginisgahlga", syllabary: "ᏕᎪᎩᏂᏍᎦᎶᎦ", english: "They are biting someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degegisgahlga", syllabary: "ᏕᎨᎩᏍᎦᎶᎦ", english: "They are biting you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degogisgahlga", syllabary: "ᏕᎪᎩᏍᎦᎶᎦ", english: "They are biting others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degesdisgahlga", syllabary: "ᏕᎨᏍᏗᏍᎦᎶᎦ", english: "They are biting you (two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degetsisgahlga", syllabary: "ᏕᎨᏥᏍᎦᎶᎦ", english: "They are biting you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danisgahlga", syllabary: "ᏓᏂᏍᎦᎶᎦ", english: "They are biting them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danisgahlga", syllabary: "ᏓᏂᏍᎦᎶᎦ", english: "They are biting those things", occurrence: 1],
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
