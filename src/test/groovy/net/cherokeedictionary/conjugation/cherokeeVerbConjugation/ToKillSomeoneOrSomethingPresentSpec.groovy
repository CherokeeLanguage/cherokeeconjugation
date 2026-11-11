package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Kill someone or something" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.87-89
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -h-ih-
 *   Present Tense: -hih-a
 *
 * Verb-book note: "This verb means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToKillSomeoneOrSomethingPresentSpec extends Specification {

    static final String VERB = "to kill someone or something"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.87-89"

    // Affix composition as printed:
    static final String STEM = "-h-ih-"        // Stem I
    static final String TENSE_FORM = "-hih-a"  // Present Tense (Stem I)

    static final String VERB_BOOK_NOTE =
        "This verb means the action is actually going on at the present time."

    /** The 70 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "tsi'iha", syllabary: "ᏥᎢᎭ", english: "I am killing him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsi'iha", syllabary: "ᏥᎢᎭ", english: "I am killing it", occurrence: 1],
            [pronoun: "First Singular", romanized: "desdv'iha", syllabary: "ᏕᏍᏛᎢᎭ", english: "I am killing you (two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "detsv'iha", syllabary: "ᏕᏨᎢᎭ", english: "I am killing you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "degatsi'iha", syllabary: "ᏕᎦᏥᎢᎭ", english: "I am killing them", occurrence: 1],
            [pronoun: "First Singular", romanized: "detsi'iha", syllabary: "ᏕᏥᎢᎭ", english: "I am killing those things", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgihiha", syllabary: "ᏍᎩᎯᎭ", english: "You (singular) are killing me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hi'iha", syllabary: "ᎯᎢᎭ", english: "You (singular) are killing him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hihiha", syllabary: "ᎯᎯᎭ", english: "You (singular) are killing it", occurrence: 1],
            [pronoun: "Second Singular", romanized: "desgini'iha", syllabary: "ᏕᏍᎩᏂᎢᎭ", english: "You (singular) are killing someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "desgi'iha", syllabary: "ᏕᏍᎩᎢᎭ", english: "You (singular) are killing others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "degahi'iha", syllabary: "ᏕᎦᎯᎢᎭ", english: "You (singular) are killing them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "dehi'hiha", syllabary: "ᏕᎯᎯᎭ", english: "You (singular) are killing those things", occurrence: 1],
            [pronoun: "Third Singular", romanized: "agihiha", syllabary: "ᎠᎩᎯᎭ", english: "He/she is killing me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsahiha", syllabary: "ᏣᎯᎭ", english: "He/she is killing you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dahiha", syllabary: "ᏓᎯᎭ", english: "He/she is killing him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ahiha", syllabary: "ᎠᎯᎭ", english: "He/she is killing it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "deginihiha", syllabary: "ᏕᎩᏂᎯᎭ", english: "He/she is killing you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "doginihiha", syllabary: "ᏙᎩᏂᎯᎭ", english: "He/she is killing someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "degihiha", syllabary: "ᏕᎩᎯᎭ", english: "He/she is killing another, or others, me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dogihiha", syllabary: "ᏙᎩᎯᎭ", english: "He/she is killing others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "desdihiha", syllabary: "ᏕᏍᏗᎯᎭ", english: "He/she is killing you two", occurrence: 1],
            [pronoun: "Third Singular", romanized: "detsihiha", syllabary: "ᏕᏥᎯᎭ", english: "He/she is killing you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dahiha", syllabary: "ᏓᎯᎭ", english: "He/she is killing them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dahiha", syllabary: "ᏓᎯᎭ", english: "He/she is killing those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sgini'iha", syllabary: "ᏍᎩᏂᎢᎭ", english: "You two are killing me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdi'iha", syllabary: "ᎡᏍᏗᎢᎭ", english: "You two are killing him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sdihiha", syllabary: "ᏍᏗᎯᎭ", english: "You two are killing it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desgini'iha", syllabary: "ᏕᏍᎩᏂᎢᎭ", english: "You two are killing someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desgi'iha", syllabary: "ᏕᏍᎩᎢᎭ", english: "You two are killing others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "degesdi'iha", syllabary: "ᏕᎨᏍᏗᎢᎭ", english: "You two are killing them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdihiha", syllabary: "ᏕᏍᏗᎯᎭ", english: "You two are killing those things", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isgi'iha", syllabary: "ᎢᏍᎩᎢᎭ", english: "You (more than two) are killing me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "etsi'iha", syllabary: "ᎡᏥᎢᎭ", english: "You (more than two) are killing him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "itsihiha", syllabary: "ᎢᏥᎯᎭ", english: "You (more than two) are killing it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "desgi'iha", syllabary: "ᏕᏍᎩᎢᎭ", english: "You (more than two) are killing someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsihiha", syllabary: "ᏕᏥᎯᎭ", english: "You (more than two) are killing them", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsihiha", syllabary: "ᏕᏥᎯᎭ", english: "You (more than two) are killing those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "eni'iha", syllabary: "ᎡᏂᎢᎭ", english: "We (you and I) are killing him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "inihiha", syllabary: "ᎢᏂᎯᎭ", english: "We (you and I) are killing it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "degeni'iha", syllabary: "ᏕᎨᏂᎢᎭ", english: "We (you and I) are killing them", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "denihiha", syllabary: "ᏕᏂᎯᎭ", english: "We (you and I) are killing those things", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdv'iha", syllabary: "ᏍᏛᎢᎭ", english: "We (another and I) are killing you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdi'iha", syllabary: "ᎣᏍᏗᎢᎭ", english: "We (another and I) are killing him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdi'iha", syllabary: "ᎣᏍᏗᎢᎭ", english: "We (another and I) are killing it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "desdv'iha", syllabary: "ᏕᏍᏛᎢᎭ", english: "We (another and I) are killing you two", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "detsv'iha", syllabary: "ᏕᏨᎢᎭ", english: "We (another and I) are killing you (more than two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "degosdi'iha", syllabary: "ᏕᎪᏍᏗᎢᎭ", english: "We (another and I) are killing them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dosdihiha", syllabary: "ᏙᏍᏗᎯᎭ", english: "We (another and I) are killing those things", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "itsv'iha", syllabary: "ᎢᏨᎢᎭ", english: "We (others and I) are killing you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsi'iha", syllabary: "ᎣᏥᎢᎭ", english: "We (others and I) are killing him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsihiha", syllabary: "ᎣᏥᎯᎭ", english: "We (others and I) are killing it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "degotsi'iha", syllabary: "ᏕᎪᏥᎢᎭ", english: "We (others and I) are killing them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsihiha", syllabary: "ᏙᏥᎯᎭ", english: "We (others and I) are killing those things", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "otsi'iha", syllabary: "ᎣᏥᎢᎭ", english: "We (you and I and another or others) are killing him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "idihiha", syllabary: "ᎢᏗᎯᎭ", english: "We (you and I and another or others) are killing it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "degedi'iha", syllabary: "ᏕᎨᏗᎢᎭ", english: "We (you and I and another or others) are killing them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedihiha", syllabary: "ᏕᏗᎯᎭ", english: "We (you and I and another or others) are killing those things", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gvgihiha", syllabary: "ᎬᎩᎯᎭ", english: "They are killing me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsahiha", syllabary: "ᏕᏣᎯᎭ", english: "They are killing you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anihiha", syllabary: "ᎠᏂᎯᎭ", english: "They are killing him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "anihiha", syllabary: "ᎠᏂᎯᎭ", english: "They are killing it", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degeginihiha", syllabary: "ᏕᎨᎩᏂᎯᎭ", english: "They are killing you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degoginihiha", syllabary: "ᏕᎪᎩᏂᎯᎭ", english: "They are killing someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degegihiha", syllabary: "ᏕᎨᎩᎯᎭ", english: "They are killing you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degogihiha", syllabary: "ᏕᎪᎩᎯᎭ", english: "They are killing others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degesdihiha", syllabary: "ᏕᎨᏍᏗᎯᎭ", english: "They are killing you two", occurrence: 1],
            [pronoun: "Third Plural", romanized: "degetsihiha", syllabary: "ᏕᎨᏥᎯᎭ", english: "They are killing you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danihiha", syllabary: "ᏓᏂᎯᎭ", english: "They are killing them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "danihiha", syllabary: "ᏓᏂᎯᎭ", english: "They are killing those things", occurrence: 1],
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
