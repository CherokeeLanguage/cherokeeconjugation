package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import net.cherokeedictionary.grammarGuide.VerbBookEngineHarness
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Go" — Present Habitual (Stem II).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.37
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem II: -e-s-
 *   Present Habitual: -eg-o'i  (NB: the Present Habitual is usually Stem II)
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToGoPresentHabitualSpec extends VerbBaseSpec {

    static final String VERB = "to go"
    static final String TENSE = "PRESENT_HABITUAL"
    static final String SOURCE_PAGE = "p.37"

    // Affix composition as printed:
    static final String STEM = "-e-s-"        // Stem II
    static final String TENSE_FORM = "-eg-o'i"  // Present Habitual (Stem II) NB: the Present Habitual is usually Stem II

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [object: 'SG3IN', pronoun: "First Singular", romanized: "gego'i", syllabary: "ᎨᎪᎢ", english: "I go"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "hego'i", syllabary: "ᎮᎪᎢ", english: "You go"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "anego'i", syllabary: "ᎠᏁᎪᎢ", english: "He/she/it goes"],
            [object: 'PL3AN', pronoun: "Second Dual", romanized: "sdego'i", syllabary: "ᏍᏕᏐᎢ", english: "You (two) go"],
            [object: 'PL3AN', pronoun: "Second Plural", romanized: "itsego'i", syllabary: "ᎢᏤᏐᎢ", english: "You (more than two) go"],
            [object: 'PL3AN', pronoun: "First Dual Inclusive", romanized: "inego'i", syllabary: "ᎢᏁᏐᎢ", english: "We (you and I) go"],
            [object: 'PL3AN', pronoun: "First Dual Exclusive", romanized: "osdego'i", syllabary: "ᎣᏍᏕᏐᎢ", english: "We (another and I) go"],
            [object: 'PL3AN', pronoun: "First Plural Exclusive", romanized: "otsego'i", syllabary: "ᎣᏤᏐᎢ", english: "We (others and I) go"],
            [object: 'PL3AN', pronoun: "First Plural Inclusive", romanized: "idego'i", syllabary: "ᎢᏕᏐᎢ", english: "We (you and I and another or others) go"],
            [object: 'PL3AN', pronoun: "Third Plural", romanized: "anego'i", syllabary: "ᎠᏁᏐᎢ", english: "They go"],
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

    def "present habitual form matches the verb book (#row.pronoun)"() {
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
