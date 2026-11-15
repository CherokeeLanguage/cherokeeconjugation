package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import net.cherokeedictionary.grammarGuide.VerbBookEngineHarness
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Go" — Immediate Past (Stem IV).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.38
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem IV: -e-n-
 *   Immediate Past: -en-a
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToGoImmediatePastSpec extends VerbBaseSpec {

    static final String VERB = "to go"
    static final String TENSE = "IMMEDIATE_PAST"
    static final String SOURCE_PAGE = "p.38"

    // Affix composition as printed:
    static final String STEM = "-e-n-"        // Stem IV
    static final String TENSE_FORM = "-en-a"  // Immediate Past (Stem IV)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [object: 'SG3IN', pronoun: "First Singular", romanized: "gena", syllabary: "ᎨᎾ", english: "I went"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "hena", syllabary: "ᎮᎾ", english: "You went"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "ena", syllabary: "ᎡᎾ", english: "He/she/it went"],
            [object: 'SG3IN', pronoun: "Second Dual", romanized: "sdena", syllabary: "ᏍᏕᎾ", english: "You (two) went"],
            [object: 'SG3IN', pronoun: "Second Plural", romanized: "itsena", syllabary: "ᎢᏤᎾ", english: "You (more than two) went"],
            [object: 'SG3IN', pronoun: "First Dual Inclusive", romanized: "inena", syllabary: "ᎢᏁᎾ", english: "We (you and I) went"],
            [object: 'SG3IN', pronoun: "First Dual Exclusive", romanized: "osdena", syllabary: "ᎣᏍᏕᎾ", english: "We (another and I) went"],
            [object: 'SG3IN', pronoun: "First Plural Exclusive", romanized: "otsena", syllabary: "ᎣᏤᎾ", english: "We (others and I) went"],
            [object: 'SG3IN', pronoun: "First Plural Inclusive", romanized: "idena", syllabary: "ᎢᏕᎾ", english: "We (you and I and another or others) went"],
            [object: 'SG3IN', pronoun: "Third Plural", romanized: "anena", syllabary: "ᎠᏁᎾ", english: "They went"],
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

    def "immediate past form matches the verb book (#row.pronoun)"() {
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
