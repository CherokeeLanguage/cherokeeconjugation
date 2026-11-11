package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Love" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.102-104
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -geyu-h-
 *   Present Tense: -geyuh-a
 *
 * Verb-book notes (as printed):
 *   - "This verb means the action is actually going on at the present time."
 *   - "S/he loves him/her" differs from "S/he loves it" only by a change in tone. The same is true for "S/he " loves them" and "S/he loves those things.""
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToLovePresentSpec extends Specification {

    static final String VERB = "to love"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.102-104"

    // Affix composition as printed:
    static final String STEM = "-geyu-h-"        // Stem I
    static final String TENSE_FORM = "-geyuh-a"  // Present Tense (Stem I)

    static final List<String> VERB_BOOK_NOTES = [
        "This verb means the action is actually going on at the present time.",
        "S/he loves him/her\" differs from \"S/he loves it\" only by a change in tone. The same is true for \"S/he \" loves them\" and \"S/he loves those things.\"",
    ]

    /** The 70 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gvgeyu'a", syllabary: "ᎬᎨᏳᎠ", english: "I love you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsigeyu'a", syllabary: "ᏥᎨᏳᎠ", english: "I love him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "agigeyuha", syllabary: "ᎠᎩᎨᏳᎭ", english: "I love it", occurrence: 1],
            [pronoun: "First Singular", romanized: "sdvgeyu'a", syllabary: "ᏍᏛᎨᏳᎠ", english: "I love you (two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "itsvgeyu'a", syllabary: "ᎢᏨᎨᏳᎠ", english: "I love you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "gatsigeyu'a", syllabary: "ᎦᏥᎨᏳᎠ", english: "I love them", occurrence: 1],
            [pronoun: "First Singular", romanized: "dagigeyuha", syllabary: "ᏓᎩᎨᏳᎭ", english: "I love those things", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgigeyuha", syllabary: "ᏍᎩᎨᏳᎭ", english: "You love me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "higeyu'a", syllabary: "ᎯᎨᏳᎠ", english: "You love him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "tsageyuha", syllabary: "ᏣᎨᏳᎭ", english: "You love it", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sginigeyu'a", syllabary: "ᏍᎩᏂᎨᏳᎠ", english: "You love someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "isgigeyu'a", syllabary: "ᎢᏍᎩᎨᏳᎠ", english: "You love others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "gahigeyu'a", syllabary: "ᎦᎯᎨᏳᎠ", english: "You love them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "detsageyuha", syllabary: "ᏕᏣᎨᏳᎭ", english: "You love those things", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agigeyuha", syllabary: "ᎠᎩᎨᏳᎭ", english: "He/she loves me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsageyuha", syllabary: "ᏣᎨᏳᎭ", english: "He/she loves you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ugeyuha", syllabary: "ᎤᎨᏳᎭ", english: "He/she loves him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ugeyuha", syllabary: "ᎤᎨᏳᎭ", english: "He/she loves it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ginigeyuha", syllabary: "ᎩᏂᎨᏳᎭ", english: "He/she loves you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginigeyuha", syllabary: "ᎣᎩᏂᎨᏳᎭ", english: "He/she loves someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ogigeyuha", syllabary: "ᎣᎩᎨᏳᎭ", english: "He/she loves another or others, me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "igigeyuha", syllabary: "ᎢᎩᎨᏳᎭ", english: "He/she loves others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "sdigeyuha", syllabary: "ᏍᏗᎨᏳᎭ", english: "He/she loves you two", occurrence: 1],
            [pronoun: "Third Singular", romanized: "itsigeyuha", syllabary: "ᎢᏥᎨᏳᎭ", english: "He/she loves you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dugeyuha", syllabary: "ᏚᎨᏳᎭ", english: "He/she loves them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dugeyuha", syllabary: "ᏚᎨᏳᎭ", english: "He/she loves those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginigeyuha", syllabary: "ᏍᎩᏂᎨᏳᎭ", english: "You two love me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdigeyu'a", syllabary: "ᎡᏍᏗᎨᏳᎠ", english: "You two love him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sdigeyuha", syllabary: "ᏍᏗᎨᏳᎭ", english: "You two love it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginigeyu'a", syllabary: "ᏍᎩᏂᎨᏳᎠ", english: "You two love someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sgigeyu'a", syllabary: "ᏍᎩᎨᏳᎠ", english: "You two love others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "gesdigeyu'a", syllabary: "ᎨᏍᏗᎨᏳᎠ", english: "You two love them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdigeyuha", syllabary: "ᏕᏍᏗᎨᏳᎭ", english: "You two love those things", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgigeyu'a", syllabary: "ᎢᏍᎩᎨᏳᎠ", english: "You (more than two) love me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "etsigeyu'a", syllabary: "ᎡᏥᎨᏳᎠ", english: "You (more than two) love him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "itsigeyuha", syllabary: "ᎢᏥᎨᏳᎭ", english: "You (more than two) love it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgigeyu'a", syllabary: "ᎢᏍᎩᎨᏳᎠ", english: "You (more than two) love someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "desdigeyuha", syllabary: "ᏕᏍᏗᎨᏳᎭ", english: "You (more than two) love them", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsigeyuha", syllabary: "ᏕᏥᎨᏳᎭ", english: "You (more than two) love those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "enigeyu'a", syllabary: "ᎡᏂᎨᏳᎠ", english: "We (you and I) love him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "ginigeyuha", syllabary: "ᎩᏂᎨᏳᎭ", english: "We (you and I) love it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "deginigeyuha", syllabary: "ᏕᎩᏂᎨᏳᎭ", english: "We (you and I) love those things", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvgeyu'a", syllabary: "ᏍᏛᎨᏳᎠ", english: "We (another and I) love you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdigeyu'a", syllabary: "ᎣᏍᏗᎨᏳᎠ", english: "We (another and I) love him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "oginigeyuha", syllabary: "ᎣᎩᏂᎨᏳᎭ", english: "We (another and I) love it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "isdvgeyu'a", syllabary: "ᎢᏍᏛᎨᏳᎠ", english: "We (another and I) love you two", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "itsvgeyu'a", syllabary: "ᎢᏨᎨᏳᎠ", english: "We (another and I) love you (more than two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdigeyuha", syllabary: "ᏙᏍᏗᎨᏳᎭ", english: "We (another and I) love them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "doginigeyuha", syllabary: "ᏙᎩᏂᎨᏳᎭ", english: "We (another and I) love those things", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "itsvgeyu'a", syllabary: "ᎢᏨᎨᏳᎠ", english: "We (others and I) love you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsigeyu'a", syllabary: "ᎣᏥᎨᏳᎠ", english: "We (others and I) love him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "ogigeyuha", syllabary: "ᎣᎩᎨᏳᎭ", english: "We (others and I) love it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dosdigeyuha", syllabary: "ᏙᏍᏗᎨᏳᎭ", english: "We (others and I) love them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dogigeyuha", syllabary: "ᏙᎩᎨᏳᎭ", english: "We (others and I) love those things", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "edigeyu'a", syllabary: "ᎡᏗᎨᏳᎠ", english: "We (you and I and another or others) love him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "igigeyuha", syllabary: "ᎢᎩᎨᏳᎭ", english: "We (you and I and another or others) love it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedigeyuha", syllabary: "ᏕᏗᎨᏳᎭ", english: "We (you and I and another or others) love them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dogigeyuha", syllabary: "ᏙᎩᎨᏳᎭ", english: "We (you and I and another or others love those things", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gvgigeyu'a", syllabary: "ᎬᎩᎨᏳᎠ", english: "They love me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsageyuha", syllabary: "ᎨᏣᎨᏳᎭ", english: "They love you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "unigeyuha", syllabary: "ᎤᏂᎨᏳᎭ", english: "They love him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "unigeyuha", syllabary: "ᎤᏂᎨᏳᎭ", english: "They love it", occurrence: 1],
            [pronoun: "Third Plural", romanized: "geginigeyuha", syllabary: "ᎨᎩᏂᎨᏳᎭ", english: "They love you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "goginigeyuha", syllabary: "ᎪᎩᏂᎨᏳᎭ", english: "They love someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gegigeyuha", syllabary: "ᎨᎩᎨᏳᎭ", english: "They love you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gogigeyuha", syllabary: "ᎪᎩᎨᏳᎭ", english: "They love others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gesdigeyuha", syllabary: "ᎨᏍᏗᎨᏳᎭ", english: "They love you two", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsigeyuha", syllabary: "ᎨᏥᎨᏳᎭ", english: "They love you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "dunigeyuha", syllabary: "ᏚᏂᎨᏳᎭ", english: "They love them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "dunigeyuha", syllabary: "ᏚᏂᎨᏳᎭ", english: "They love those things", occurrence: 1],
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
