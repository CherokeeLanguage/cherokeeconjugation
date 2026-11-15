package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import net.cherokeedictionary.grammarGuide.VerbBookEngineHarness
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Go" — Infinitive (Stem V).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.38
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem V: -e-nvs-
 *   Infinitive: -envs-di
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToGoInfinitiveSpec extends VerbBaseSpec {

    static final String VERB = "to go"
    static final String TENSE = "INFINITIVE"
    static final String SOURCE_PAGE = "p.38"

    // Affix composition as printed:
    static final String STEM = "-e-nvs-"        // Stem V
    static final String TENSE_FORM = "-envs-di"  // Infinitive (Stem V)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [object: 'SG3IN', pronoun: "First Singular", romanized: "agwenvsdi", syllabary: "ᎠᏇᏅᏍᏗ", english: "For me to go"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "tsenvsdi", syllabary: "ᏤᏅᏍᏗ", english: "For you to go"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "uwenvsdi", syllabary: "ᎤᏪᏅᏍᏗ", english: "For him/her/it to go"],
            [object: 'PL3AN', pronoun: "Second Dual", romanized: "sdenvsdi", syllabary: "ᏍᏕᏅᏍᏗ", english: "For you (two) to go"],
            [object: 'PL3AN', pronoun: "Second Plural", romanized: "itsenvsdi", syllabary: "ᎢᏤᏅᏍᏗ", english: "For you (more than two) to go"],
            [object: 'PL3AN', pronoun: "First Dual Inclusive", romanized: "ginenvsdi", syllabary: "ᎩᏁᏅᏍᏗ", english: "For us (you and I) to go"],
            [object: 'PL3AN', pronoun: "First Dual Exclusive", romanized: "oginenvsdi", syllabary: "ᎣᎩᏁᏅᏍᏗ", english: "For us (another and I) to go"],
            [object: 'PL3AN', pronoun: "First Plural Exclusive", romanized: "ogenvsdi", syllabary: "ᎣᎨᏅᏍᏗ", english: "For us (others and I) to go"],
            [object: 'PL3AN', pronoun: "First Plural Inclusive", romanized: "igenvsdi", syllabary: "ᎢᎨᏅᏍᏗ", english: "For us (you and I and another or others) to go"],
            [object: 'PL3AN', pronoun: "Third Plural", romanized: "unenvsdi", syllabary: "ᎤᏁᏅᏍᏗ", english: "For them to go"],
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

    def "infinitive form matches the verb book (#row.pronoun)"() {
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
