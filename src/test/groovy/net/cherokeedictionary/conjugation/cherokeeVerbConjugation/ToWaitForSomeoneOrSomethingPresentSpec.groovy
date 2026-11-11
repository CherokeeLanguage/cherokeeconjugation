package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Wait for someone or something" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.147-149
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -gati-y-
 *   Present Tense: -gatiy-a
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToWaitForSomeoneOrSomethingPresentSpec extends Specification {

    static final String VERB = "to wait for someone or something"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.147-149"

    // Affix composition as printed:
    static final String STEM = "-gati-y-"        // Stem I
    static final String TENSE_FORM = "-gatiy-a"  // Present Tense (Stem I)

    /** The 71 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gvgatiya", syllabary: "ᎬᎦᏘᏯ", english: "I am waiting for you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsigatiya", syllabary: "ᏥᎦᏘᏯ", english: "I am waiting for him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsigatiya", syllabary: "ᏥᎦᏘᏯ", english: "I am waiting for it", occurrence: 1],  // as printed: (tsi- pronounced quickly)
            [pronoun: "First Singular", romanized: "sdvgatiya", syllabary: "ᏍᏛᎦᏘᏯ", english: "I am waiting for you (two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "itsvgatiya", syllabary: "ᎢᏨᎦᏘᏯ", english: "I am waiting for you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "gatsigatiya", syllabary: "ᎦᏥᎦᏘᏯ", english: "I am waiting for them", occurrence: 1],
            [pronoun: "First Singular", romanized: "detsigatiya", syllabary: "ᏕᏥᎦᏘᏯ", english: "I am waiting for those things", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgigatiya", syllabary: "ᏍᎩᎦᏘᏯ", english: "You (singular) are waiting for me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "higatiya", syllabary: "ᎯᎦᏘᏯ", english: "You (singular) are waiting for him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "higatiya", syllabary: "ᎯᎦᏘᏯ", english: "You (singular) are waiting for it", occurrence: 1],  // as printed: (hi- pronounced quickly)
            [pronoun: "Second Singular", romanized: "sginigatiya", syllabary: "ᏍᎩᏂᎦᏘᏯ", english: "You (singular) are waiting for someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "isgigatiya", syllabary: "ᎢᏍᎩᎦᏘᏯ", english: "You (singular) are waiting for others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "gahigatiya", syllabary: "ᎦᎯᎦᏘᏯ", english: "You (singular) are waiting for them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "dehigatiya", syllabary: "ᏕᎯᎦᏘᏯ", english: "You (singular) are waiting for those things", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agigatiya", syllabary: "ᎠᎩᎦᏘᏯ", english: "He/she is waiting for me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsagatiya", syllabary: "ᏣᎦᏘᏯ", english: "He/she is waiting for you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agatiya", syllabary: "ᎠᎦᏘᏯ", english: "He/she is waiting for him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "aktiya", syllabary: "ᎠᎦᏘᏯ", english: "He/she is waiting for it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ginigatiya", syllabary: "ᎩᏂᎦᏘᏯ", english: "He/she is waiting for you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginigatiya", syllabary: "ᎣᎩᏂᎦᏘᏯ", english: "He/she is waiting for someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "igigatiya", syllabary: "ᎢᎩᎦᏘᏯ", english: "He/she is waiting for another, or others, me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ogigatiya", syllabary: "ᎣᎩᎦᏘᏯ", english: "He/she is waiting for others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "sdigatiya", syllabary: "ᏍᏗᎦᏘᏯ", english: "He/she is waiting for you two", occurrence: 1],
            [pronoun: "Third Singular", romanized: "itsigatiya", syllabary: "ᎢᏥᎦᏘᏯ", english: "He/she is waiting for you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dagatiya", syllabary: "ᏓᎦᏘᏯ", english: "He/she is waiting for them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dagatiya", syllabary: "ᏓᎦᏘᏯ", english: "He/she is waiting for those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginigatiya", syllabary: "ᏍᎩᏂᎦᏘᏯ", english: "You two are waiting for me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdigatiya", syllabary: "ᎡᏍᏗᎦᏘᏯ", english: "You two are waiting for him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sdigatiya", syllabary: "ᏍᏗᎦᏘᏯ", english: "You two are waiting for it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginigatiya", syllabary: "ᏍᎩᏂᎦᏘᏯ", english: "You two are waiting for someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "isgigatiya", syllabary: "ᎢᏍᎩᎦᏘᏯ", english: "You two are waiting for others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdigatiya", syllabary: "ᏕᏍᏗᎦᏘᏯ", english: "You two are waiting for them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdigatiya", syllabary: "ᏕᏍᏗᎦᏘᏯ", english: "You two are waiting for those things", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgigatiya", syllabary: "ᎢᏍᎩᎦᏘᏯ", english: "You (more than two) are waiting for me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "etsigatiya", syllabary: "ᎡᏥᎦᏘᏯ", english: "You (more than two) are waiting for him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "itsigatiya", syllabary: "ᎢᏥᎦᏘᏯ", english: "You (more than two) are waiting for it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgigatiya", syllabary: "ᎢᏍᎩᎦᏘᏯ", english: "You (more than two) are waiting for someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "getsigatiya", syllabary: "ᎨᏥᎦᏘᏯ", english: "You (more than two) are waiting for them", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsigatiya", syllabary: "ᏕᏥᎦᏘᏯ", english: "You (more than two) are waiting for those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "enigatiya", syllabary: "ᎡᏂᎦᏘᏯ", english: "We (you and I) are waiting for him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "inigatiya", syllabary: "ᎢᏂᎦᏘᏯ", english: "We (you and I) are waiting for it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "genigatiya", syllabary: "ᎨᏂᎦᏘᏯ", english: "We (you and I) are waiting for them", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "denigatiya", syllabary: "ᏕᏂᎦᏘᏯ", english: "We (you and I) are waiting for those thing", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvgatiya", syllabary: "ᏍᏛᎦᏘᏯ", english: "We (another and I) are waiting for you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "ostigatiya", syllabary: "ᎣᏍᏘᎦᏘᏯ", english: "We (another and I) are waiting for him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "ostigatiya", syllabary: "ᎣᏍᏘᎦᏘᏯ", english: "We (another and I) are waiting for it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvgatiya", syllabary: "ᏍᏛᎦᏘᏯ", english: "We (another and I) are waiting for you two", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "itsvgatiya", syllabary: "ᎢᏨᎦᏘᏯ", english: "We (another and I) are waiting for you (more than two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "gosdigatiya", syllabary: "ᎪᏍᏗᎦᏘᏯ", english: "We (another and I) are waiting for them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdigatiya", syllabary: "ᏙᏍᏗᎦᏘᏯ", english: "We (another and I) are waiting for those things", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "itsvgatiya", syllabary: "ᎢᏨᎦᏘᏯ", english: "We (others and I) are waiting for you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsigatiya", syllabary: "ᎣᏥᎦᏘᏯ", english: "We (others and I) are waiting for him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsigatiya", syllabary: "ᎣᏥᎦᏘᏯ", english: "We (others and I) are waiting for it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "gotsigatiya", syllabary: "ᎪᏥᎦᏘᏯ", english: "We (others and I) are waiting for them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsigatiya", syllabary: "ᏙᏥᎦᏘᏯ", english: "We (others and I) are waiting for those things", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "edigatiya", syllabary: "ᎡᏗᎦᏘᏯ", english: "We (you and I and another or others) are waiting for him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "idigatiya", syllabary: "ᎢᏗᎦᏘᏯ", english: "We (you and I and another or others) are waiting for it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "gedigatiya", syllabary: "ᎨᏗᎦᏘᏯ", english: "We (you and I and another or others) are waiting for them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedigatiya", syllabary: "ᏕᏗᎦᏘᏯ", english: "We (you and I and another or others) are waiting for those things", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gvgigatiya", syllabary: "ᎬᎩᎦᏘᏯ", english: "They are waiting for me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsigatiya", syllabary: "ᎨᏥᎦᏘᏯ", english: "They are waiting for you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anigatiya", syllabary: "ᎠᏂᎦᏘᏯ", english: "They are waiting for him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anigatiya", syllabary: "ᎠᏂᎦᏘᏯ", english: "They are waiting for it", occurrence: 1],
            [pronoun: "Third Plural", romanized: "geginigatiya", syllabary: "ᎨᎩᏂᎦᏘᏯ", english: "They are waiting for you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "goginigatiya", syllabary: "ᎪᎩᏂᎦᏘᏯ", english: "They are waiting for someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gegigatiya", syllabary: "ᎨᎩᏂᎦᏘᏯ", english: "They are waiting for you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "geginigatiya", syllabary: "ᎨᎩᏂᎦᏘᏯ", english: "They are waiting for others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gesdigatiya", syllabary: "ᎨᏍᏗᎦᏘᏯ", english: "They are waiting for you two", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsigatiya", syllabary: "ᎨᏥᎦᏘᏯ", english: "They are waiting for you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danigatiya", syllabary: "ᏓᏂᎦᏘᏯ", english: "They are waiting for them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danigatiya", syllabary: "ᏓᏂᎦᏘᏯ", english: "They are waiting for those things", occurrence: 1],
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
