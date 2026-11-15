package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import net.cherokeedictionary.grammarGuide.VerbBookEngineHarness
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Go" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.36
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -e-g-
 *   Present Tense: -eg-a
 *
 * Verb-book notes (as printed):
 *   - "intransitive, e-vowel stem, class A, Ø"
 *   - "This tense means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToGoPresentSpec extends VerbBaseSpec {

    static final String VERB = "to go"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "p.36"

    // Affix composition as printed:
    static final String STEM = "-e-g-"        // Stem I
    static final String TENSE_FORM = "-eg-a"  // Present Tense (Stem I)

    static final List<String> VERB_BOOK_NOTES = [
        "intransitive, e-vowel stem, class A, Ø",
        "This tense means the action is actually going on at the present time.",
    ]

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [object: 'SG3IN', pronoun: "First Singular", romanized: "gega", syllabary: "ᎨᎦ", english: "I am going"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "hega", syllabary: "ᎮᎦ", english: "You are going"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "ega", syllabary: "ᎡᎦ", english: "He/she/it is going"],
            [object: 'PL3AN', pronoun: "Second Dual", romanized: "sdega", syllabary: "ᏍᏕᎦ", english: "You (two) are going"],
            [object: 'PL3AN', pronoun: "Second Plural", romanized: "itsega", syllabary: "ᎢᏤᎦ", english: "You (more than two) are going"],
            [object: 'PL3AN', pronoun: "First Dual Inclusive", romanized: "inega", syllabary: "ᎢᏁᎦ", english: "We (you and I) are going"],
            [object: 'PL3AN', pronoun: "First Dual Exclusive", romanized: "osdega", syllabary: "ᎣᏍᏕᎦ", english: "We (another and I) are going"],
            [object: 'PL3AN', pronoun: "First Plural Exclusive", romanized: "otsega", syllabary: "ᎣᏤᎦ", english: "We (others and I) are going"],
            [object: 'PL3AN', pronoun: "First Plural Inclusive", romanized: "idega", syllabary: "ᎢᏕᎦ", english: "We (you and I and another or others) are going"],
            [object: 'PL3AN', pronoun: "Third Plural", romanized: "anega", syllabary: "ᎠᏁᎦ", english: "They are going"],
    ]

    /**
     * tio 14Nov26: harness check — the engine conjugates this same
     * pronoun/tense/verb; the assertion below compares its output with
     * the verb-book syllabary.
     */
    Map conjugate(String pronoun) {
        def row = VERB_BOOK.find { it.pronoun == pronoun }

        def engineSyllabary = VerbBookEngineHarness.getEngineSyllabary(
            VERB, TENSE, row.english, [conjugations: VERB_BOOK]
        )

        return [romanized: row.romanized, syllabary: row.syllabary, engineSyllabary: engineSyllabary]
    }

    def "present tense form matches the verb book (#row.pronoun)"() {
        when: "the form is conjugated"
        def form = conjugate(row.pronoun)

        then: "both the romanized and syllabary forms match the verb book"
        form.romanized == row.romanized
        form.syllabary == row.syllabary

        and: "the engine output matches the verb book syllabary"
        form.engineSyllabary == row.syllabary

        and: "the English translation is preserved for later deconstruction"
        row.english

        where: "each of the ten verb-book rows"
        row << VERB_BOOK
    }

    def "the verb book table is complete (ten rows)"() {
        expect:
        VERB_BOOK.size() == 10
    }
}
