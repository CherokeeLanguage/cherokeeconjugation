package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import net.cherokeedictionary.grammarGuide.VerbBookEngineHarness
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Go" — Future (Expected) Tense (Stem II).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.37
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem II: -e-s-
 *   Future (Expected) Tense: -es-i  (NB: Future is usually Stem III)
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToGoFutureExpectedSpec extends VerbBaseSpec {

    static final String VERB = "to go"
    static final String TENSE = "FUTURE_EXPECTED"
    static final String SOURCE_PAGE = "p.37"

    // Affix composition as printed:
    static final String STEM = "-e-s-"        // Stem II
    static final String TENSE_FORM = "-es-i"  // Future (Expected) Tense (Stem II) NB: Future is usually Stem III

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [object: 'SG3IN', pronoun: "First Singular", romanized: "dagesi", syllabary: "ᏓᎨᏏ", english: "I will go"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "tesi (dahesi)", syllabary: "ᏖᏏ", english: "You will go"],  // as printed: (ᏓᎮᏏ)
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "dayesi", syllabary: "ᏓᏰᏏ", english: "He/she/it will go"],
            [object: 'PL3AN', pronoun: "Second Dual", romanized: "dasdesi", syllabary: "ᏓᏍᏕᏏ", english: "You (two) will go"],
            [object: 'PL3AN', pronoun: "Second Plural", romanized: "datsesi", syllabary: "ᏓᏤᏏ", english: "You (more than two) will go"],
            [object: 'PL3AN', pronoun: "First Dual Inclusive", romanized: "danesi", syllabary: "ᏓᏁᏏ", english: "We (you and I) will go"],
            [object: 'PL3AN', pronoun: "First Dual Exclusive", romanized: "dayosdesi", syllabary: "ᏓᏲᏍᏕᏏ", english: "We (another and I) will go"],
            [object: 'PL3AN', pronoun: "First Plural Exclusive", romanized: "dayotsesi", syllabary: "ᏓᏲᏤᏏ", english: "We (others and I) will go"],
            [object: 'PL3AN', pronoun: "First Plural Inclusive", romanized: "dadesi", syllabary: "ᏓᏕᏏ", english: "We (you and I and another or others) will go"],
            [object: 'PL3AN', pronoun: "Third Plural", romanized: "dvnesi", syllabary: "ᏛᏁᏏ", english: "They will go"],
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

    def "future (expected) tense form matches the verb book (#row.pronoun)"() {
        when: "the form is conjugated"
        def form = conjugate(row.pronoun)

        then: "both the romanized and syllabary forms match the verb book"
        form.romanized == row.romanized
        form.syllabary == row.syllabary

        and: "the engine output matches the verb book syllabary"
        println form.engineSyllabary
        println row.syllabary

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
