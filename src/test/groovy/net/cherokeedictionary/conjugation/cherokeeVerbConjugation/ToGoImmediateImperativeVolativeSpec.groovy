package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import net.cherokeedictionary.grammarGuide.VerbBookEngineHarness
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Go" — Immediate Imperative/Volative (Stem IV).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.37-38
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem IV: -e-n-
 *   Immediate Imperative/Volative: -en-a
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToGoImmediateImperativeVolativeSpec extends VerbBaseSpec {

    static final String VERB = "to go"
    static final String TENSE = "IMMEDIATE_IMPERATIVE_VOLATIVE"
    static final String SOURCE_PAGE = "pp.37-38"

    // Affix composition as printed:
    static final String STEM = "-e-n-"        // Stem IV
    static final String TENSE_FORM = "-en-a"  // Immediate Imperative/Volative (Stem IV)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [object: 'SG3IN', pronoun: "First Singular", romanized: "gena", syllabary: "ᎨᎾ", english: "May I go right now!"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "hena", syllabary: "ᎮᎾ", english: "May you go right now!"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "wena", syllabary: "ᏪᎾ", english: "May he/she/it go right now!"],
            [object: 'PL3AN', pronoun: "Second Dual", romanized: "sdena", syllabary: "ᏍᏕᎾ", english: "May you (two) go right now!"],
            [object: 'PL3AN', pronoun: "Second Plural", romanized: "itsena", syllabary: "ᎢᏤᎾ", english: "May you (more than two) go right now!"],
            [object: 'PL3AN', pronoun: "First Dual Inclusive", romanized: "inena", syllabary: "ᎢᏁᎾ", english: "May we (you and I) go right now!"],
            [object: 'PL3AN', pronoun: "First Dual Exclusive", romanized: "wosdena", syllabary: "ᏬᏍᏕᎾ", english: "May we (another and I) go right now!"],
            [object: 'PL3AN', pronoun: "First Plural Exclusive", romanized: "wotsena", syllabary: "ᏬᏤᎾ", english: "May we (others and I) go right now!"],
            [object: 'PL3AN', pronoun: "First Plural Inclusive", romanized: "idena", syllabary: "ᎢᏕᎾ", english: "May we (you and I and another or others) go right now!"],
            [object: 'PL3AN', pronoun: "Third Plural", romanized: "wanena", syllabary: "ᏩᏁᎾ", english: "May they go right now!"],
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

    def "immediate imperative/volative form matches the verb book (#row.pronoun)"() {
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
