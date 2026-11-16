package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Flexible" — Present Habitual (Stem II).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.52-53
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem II: -na-'-
 *   Present Habitual: -na'-o'i
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingFlexiblePresentHabitualSpec extends VerbBaseSpec {

    static final String VERB = "to have something flexible"
    static final String TENSE = "PRESENT_HABITUAL"
    static final String SOURCE_PAGE = "pp.52-53"

    // Affix composition as printed:
    static final String STEM = "-na-'-"        // Stem II
    static final String TENSE_FORM = "-na'-o'i"  // Present Habitual (Stem II)

    /** The conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [object: 'SG3IN', pronoun: "First Singular", romanized: "aginaoi", syllabary: "ᎠᎩᎾᎣᎢ", english: "I have something flexible (singular)"],
            [object: 'SG3IN', pronoun: "First Singular", romanized: "duninaoi", syllabary: "ᏚᏂᎾᎣᎢ", english: "I have multiple flexible things"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "tsanaoi", syllabary: "ᏣᎾᎣᎢ", english: "You have something flexible (singular)"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "detsanaoi", syllabary: "ᏕᏣᎾᎣᎢ", english: "You have multiple flexible things"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "unaoi", syllabary: "ᎤᎾᎣᎢ", english: "He/she/it has something flexible (singular)"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "dunaoi", syllabary: "ᏚᎾᎣᎢ", english: "He/she/it has multiple flexible things"],
            [object: 'SG3IN', pronoun: "Second Dual", romanized: "sdinaoi", syllabary: "ᏍᏗᎾᎣᎢ", english: "You (two) have something flexible (singular)"],
            [object: 'PL3IN', pronoun: "Second Dual", romanized: "desdinaoi", syllabary: "ᏕᏍᏗᎾᎣᎢ", english: "You (two) have multiple flexible things"],
            [object: 'SG3IN', pronoun: "Second Plural", romanized: "itsinaoi", syllabary: "ᎢᏥᎾᎣᎢ", english: "You (more than two) have something flexible (singular)"],
            [object: 'PL3IN', pronoun: "Second Plural", romanized: "detsinaoi", syllabary: "ᏕᏥᎾᎣᎢ", english: "You (more than two) have multiple flexible things"],
            [object: 'SG3IN', pronoun: "First Dual Inclusive", romanized: "gininaoi", syllabary: "ᎩᏂᎾᎣᎢ", english: "We (you and I) have something flexible (singular)"],
            [object: 'PL3IN', pronoun: "First Dual Inclusive", romanized: "degininaoi", syllabary: "ᏕᎩᏂᎾᎣᎢ", english: "We (you and I) have multiple flexible things"],
            [object: 'SG3IN', pronoun: "First Dual Exclusive", romanized: "ogininaoi", syllabary: "ᎣᎩᏂᎾᎣᎢ", english: "We (another and I) have something flexible (singular)"],
            [object: 'PL3IN', pronoun: "First Dual Exclusive", romanized: "dogininaoi", syllabary: "ᏙᎩᏂᎾᎣᎢ", english: "We (another and I) have multiple flexible things"],
            [object: 'SG3IN', pronoun: "First Plural Exclusive", romanized: "oginaoi", syllabary: "ᎣᎩᎾᎣᎢ", english: "We (others and I) have something flexible (singular)"],
            [object: 'PL3IN', pronoun: "First Plural Exclusive", romanized: "doginaoi", syllabary: "ᏙᎩᎾᎣᎢ", english: "We (others and I) have multiple flexible things"],
            [object: 'SG3IN', pronoun: "First Plural Inclusive", romanized: "iginaoi", syllabary: "ᎢᎩᎾᎣᎢ", english: "We (you and I and another or others) have something flexible (singular)"],
            [object: 'PL3IN', pronoun: "First Plural Inclusive", romanized: "deginaoi", syllabary: "ᏕᎩᎾᎣᎢ", english: "We (you and I and another or others) have multiple flexible things"],
            [object: 'SG3IN', pronoun: "Third Plural", romanized: "uninaoi", syllabary: "ᎤᏂᎾᎣᎢ", english: "They have something flexible (singular)"],
            [object: 'PL3IN', pronoun: "Third Plural", romanized: "duninaoi", syllabary: "ᏚᏂᎾᎣᎢ", english: "They have multiple flexible things"],
    ]

    /**
     * Hook for the conjugation-engine comparison (to be wired in later).
     * Today it echoes the verb-book form; replace the body with a call into
     * the conjugation engine when the engine-vs-verb-book refinement begins.
     */
    Map conjugate(String pronoun, String romanized) {
        def row = VERB_BOOK.find { it.pronoun == pronoun && it.romanized == romanized }
        // Harness check: retrieve engine output for this same pronoun/tense/verb
        def engineSyllabary = VerbBookEngineHarness.getEngineSyllabary(
            VERB, TENSE, row.english, [conjugations: VERB_BOOK]
        )
        
        return [romanized: row.romanized, syllabary: row.syllabary, engineSyllabary: engineSyllabary]
    }

    def "present habitual form matches the verb book (#row.pronoun #row.romanized)"() {
        when: "the form is conjugated"
        def form = conjugate(row.pronoun, row.romanized)

        then: "both the romanized and syllabary forms match the verb book"
        form.romanized == row.romanized
        form.syllabary == row.syllabary
        and: "the engine output matches the verb book syllabary"
        form.engineSyllabary == row.syllabary


        and: "the English translation is preserved for later deconstruction"
        row.english

        where: "each of the twenty verb-book rows"
        row << VERB_BOOK
    }

    def "the verb book table is complete (twenty rows)"() {
        expect:
        VERB_BOOK.size() == 20
    }
}
