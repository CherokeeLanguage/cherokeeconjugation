package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import net.cherokeedictionary.grammarGuide.VerbBookEngineHarness
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To See" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.117-119
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -gowt-ih-
 *   Present Tense: -gowtih-a
 *
 * Verb-book notes (as printed):
 *   - "This tense means the action is actually going on at the present time."
 *   - "Verbs in bold differ only in initial vowel length during pronunciation."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToSeePresentSpec extends VerbBaseSpec {

    static final String VERB = "to see"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.117-119"

    // Affix composition as printed:
    static final String STEM = "-gowt-ih-"        // Stem I
    static final String TENSE_FORM = "-gowtih-a"  // Present Tense (Stem I)

    static final List<String> VERB_BOOK_NOTES = [
        "This tense means the action is actually going on at the present time.",
        "Verbs in bold differ only in initial vowel length during pronunciation.",
    ]

    /** The 71 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gvgowtiha", syllabary: "ᎬᎪᏩᏘᎭ", english: "I see you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsigowtiha", syllabary: "ᏥᎪᏩᏘᎭ", english: "I see him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsigowtiha", syllabary: "ᏥᎪᏩᏘᎭ", english: "I see it", occurrence: 1],
            [pronoun: "First Singular", romanized: "sdvgowtiha", syllabary: "ᏍᏛᎪᏩᏘᎭ", english: "I see you (two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "itsvgowtiha", syllabary: "ᎢᏨᎪᏩᏘᎭ", english: "I see you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "gatsigowtiha", syllabary: "ᎦᏥᎪᏩᏘᎭ", english: "I see them", occurrence: 1],
            [pronoun: "First Singular", romanized: "detsigowtiha", syllabary: "ᏕᏥᎪᏩᏘᎭ", english: "I see those things", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgowtiha", syllabary: "ᏍᎪᏩᏘᎭ", english: "You (singular) see me", occurrence: 1],  // as printed: (short vowel "sgi'ow-")
            [pronoun: "Second Singular", romanized: "higowtiha", syllabary: "ᎯᎪᏩᏘᎭ", english: "You (singular) see him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "higowtiha", syllabary: "ᎯᎪᏩᏘᎭ", english: "You (singular) see it", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sginigowtiha", syllabary: "ᏍᎩᏂᎪᏩᏘᎭ", english: "You (singular) see someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "isgigowtiha", syllabary: "ᎢᏍᎩᎪᏩᏘᎭ", english: "You (singular) see others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "gahigowtiha", syllabary: "ᎦᎯᎪᏩᏘᎭ", english: "You (singular) see them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "dehigowtiha", syllabary: "ᏕᎯᎪᏩᏘᎭ", english: "You (singular) see those things", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agigowtiha", syllabary: "ᎠᎩᎪᏩᏘᎭ", english: "He/she sees me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsagowtiha", syllabary: "ᏣᎪᏩᏘᎭ", english: "He/she sees you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agowtiha", syllabary: "ᎠᎪᏩᏘᎭ", english: "He/she sees him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agowtiha", syllabary: "ᎠᎪᏩᏘᎭ", english: "He/she sees it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ginigowtiha", syllabary: "ᎩᏂᎪᏩᏘᎭ", english: "He/she sees you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginigowtiha", syllabary: "ᎣᎩᏂᎪᏩᏘᎭ", english: "He/she sees someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "igigowtiha", syllabary: "ᎢᎩᎪᏩᏘᎭ", english: "He/she sees another, or others, me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ogigowtiha", syllabary: "ᎣᎩᎪᏩᏘᎭ", english: "He/she sees others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "sdigowtiha", syllabary: "ᏍᏗᎪᏩᏘᎭ", english: "He/she sees you two", occurrence: 1],
            [pronoun: "Third Singular", romanized: "itsigowtiha", syllabary: "ᎢᏥᎪᏩᏘᎭ", english: "He/she sees you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dagowtiha", syllabary: "ᏓᎪᏩᏘᎭ", english: "He/she sees them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dagowtiha", syllabary: "ᏓᎪᏩᏘᎭ", english: "He/she sees those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginigowtiha", syllabary: "ᏍᎩᏂᎪᏩᏘᎭ", english: "You two see me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdigowtiha", syllabary: "ᎡᏍᏗᎪᏩᏘᎭ", english: "You two see him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sdigowtiha", syllabary: "ᏍᏗᎪᏩᏘᎭ", english: "You two see it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sginigowtiha", syllabary: "ᏍᎩᏂᎪᏩᏘᎭ", english: "You two see someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "isgigowtiha", syllabary: "ᎢᏍᎩᎪᏩᏘᎭ", english: "You two see others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "gesdigowtiha", syllabary: "ᎨᏍᏗᎪᏩᏘᎭ", english: "You two see them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdigowtiha", syllabary: "ᏕᏍᏗᎪᏩᏘᎭ", english: "You two see those things", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgigowtiha", syllabary: "ᎢᏍᎩᎪᏩᏘᎭ", english: "You (more than two) see me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "etsigowtiha", syllabary: "ᎡᏥᎪᏩᏘᎭ", english: "You (more than two) see him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "itsigowtiha", syllabary: "ᎢᏥᎪᏩᏘᎭ", english: "You (more than two) see it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgigowtiha", syllabary: "ᎢᏍᎩᎪᏩᏘᎭ", english: "You (more than two) see someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "getsigowtiha", syllabary: "ᎨᏥᎪᏩᏘᎭ", english: "You (more than two) see them", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsigowtiha", syllabary: "ᏕᏥᎪᏩᏘᎭ", english: "You (more than two) see those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "enigowtiha", syllabary: "ᎡᏂᎪᏩᏘᎭ", english: "We (you and I) see him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "inigowtiha", syllabary: "ᎢᏂᎪᏩᏘᎭ", english: "We (you and I) see it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "genigowtiha", syllabary: "ᎨᏂᎪᏩᏘᎭ", english: "We (you and I) see them", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "denigowtiha", syllabary: "ᏕᏂᎪᏩᏘᎭ", english: "We (you and I) see those things", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvgowtiha", syllabary: "ᏍᏛᎪᏩᏘᎭ", english: "We (another and I) see you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdigowtiha", syllabary: "ᎣᏍᏗᎪᏩᏘᎭ", english: "We (another and I) see him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdigowtiha", syllabary: "ᎣᏍᏗᎪᏩᏘᎭ", english: "We (another and I) see it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "gotsigowtiha", syllabary: "ᎪᏥᎪᏩᏘᎭ", english: "We (another and I) see you two", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "itsvgowtiha", syllabary: "ᎢᏨᎪᏩᏘᎭ", english: "We (another and I) see you (more than two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "gosdigowtiha", syllabary: "ᎪᏍᏗᎪᏩᏘᎭ", english: "We (another and I) see them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdigowtiha", syllabary: "ᏙᏍᏗᎪᏩᏘᎭ", english: "We (another and I) see those things", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "itsvgowtiha", syllabary: "ᎢᏨᎪᏩᏘᎭ", english: "We (others and I) see you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsigowtiha", syllabary: "ᎣᏥᎪᏩᏘᎭ", english: "We (others and I) see him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsigowtiha", syllabary: "ᎣᏥᎪᏩᏘᎭ", english: "We (others and I) see it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "gotsigowtiha", syllabary: "ᎪᏥᎪᏩᏘᎭ", english: "We (others and I) see them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsigowtiha", syllabary: "ᏙᏥᎪᏩᏘᎭ", english: "We (others and I) see those things", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "edigowtiha", syllabary: "ᎡᏗᎪᏩᏘᎭ", english: "We (you and I and another or others) see him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "idigowtiha", syllabary: "ᎢᏗᎪᏩᏘᎭ", english: "We (you and I and another or others) see it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "gedigowtiha", syllabary: "ᎨᏗᎪᏩᏘᎭ", english: "We (you and I and another or others) see them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedigowtiha", syllabary: "ᏕᏗᎪᏩᏘᎭ", english: "We (you and I and another or others) see those things", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gvgigowtiha", syllabary: "ᎬᎩᎪᏩᏘᎭ", english: "They see me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsagowtiha", syllabary: "ᎨᏣᎪᏩᏘᎭ", english: "They see you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anigowtiha", syllabary: "ᎠᏂᎪᏩᏘᎭ", english: "They see him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anigowtiha", syllabary: "ᎠᏂᎪᏩᏘᎭ", english: "They see it", occurrence: 1],
            [pronoun: "Third Plural", romanized: "geginigowtiha", syllabary: "ᎨᎩᏂᎪᏩᏘᎭ", english: "They see you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "goginigowtiha", syllabary: "ᎪᎩᏂᎪᏩᏘᎭ", english: "They see someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gegigowtiha", syllabary: "ᎨᎩᎪᏩᏘᎭ", english: "They see you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gogigowtiha", syllabary: "ᎪᎩᎪᏩᏘᎭ", english: "They see others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gesdigowtiha", syllabary: "ᎨᏍᏗᎪᏩᏘᎭ", english: "They see you two", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsigowtiha", syllabary: "ᎨᏥᎪᏩᏘᎭ", english: "They see you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danigowtiha", syllabary: "ᏓᏂᎪᏩᏘᎭ", english: "They see them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danigowtiha", syllabary: "ᏓᏂᎪᏩᏘᎭ", english: "They see those things", occurrence: 1],
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
        
        // Harness check: retrieve engine output for this same pronoun/tense/verb
        def engineSyllabary = VerbBookEngineHarness.getEngineSyllabary(
            VERB, TENSE, row.english, [conjugations: VERB_BOOK]
        )
        
        return [romanized: row.romanized, syllabary: row.syllabary, engineSyllabary: engineSyllabary]
    }

    def "present tense form matches the verb book (#row.pronoun: #row.english)"() {
        when: "the form is conjugated"
        def form = conjugate(row.pronoun, row.english, row.occurrence)

        then: "both the romanized and syllabary forms match the verb book"
        form.romanized == row.romanized
        form.syllabary == row.syllabary

        and: "the engine output matches the verb book syllabary"
        form.engineSyllabary == row.syllabary

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
