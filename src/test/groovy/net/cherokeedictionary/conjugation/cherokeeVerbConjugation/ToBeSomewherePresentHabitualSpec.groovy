package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Be Somewhere" — Present Habitual (Stem II).
 *
 * Source: Cherokee Verb Conjugations Single Entry (Durbin Feeling verb book), p.20.
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem II:         -edo-h-
 *   Present Habitual: -edoh-o'i    (Stem II + habitual suffix -o'i)
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToBeSomewherePresentHabitualSpec extends VerbBaseSpec {

    static final String VERB = "to be somewhere"
    static final String TENSE = "PRESENT_HABITUAL"
    static final String SOURCE_PAGE = "p.20"

    // Affix composition as printed:
    static final String STEM = "-edo-h-"        // Stem II
    static final String TENSE_FORM = "-edoh-o'i"  // Present Habitual (Stem II + -o'i)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular",         romanized: "gedoho'i",   syllabary: "ᎨᏙᎰᎢ",  english: "I am somewhere"],
            [pronoun: "Second Singular",        romanized: "hedoho'i",   syllabary: "ᎮᏙᎰᎢ",  english: "You are somewhere"],
            [pronoun: "Third Singular",         romanized: "edoho'i",    syllabary: "ᎡᏙᎰᎢ",  english: "He/she/it is somewhere"],
            [pronoun: "Second Dual",            romanized: "sdedoho'i",  syllabary: "ᏍᏕᏙᎰᎢ", english: "You (two) are somewhere"],
            [pronoun: "Second Plural",          romanized: "itsedoho'i", syllabary: "ᎢᏤᏙᎰᎢ", english: "You (more than two) are somewhere"],
            [pronoun: "First Dual Inclusive",   romanized: "inedoho'i",  syllabary: "ᎢᏁᏙᎰᎢ", english: "We (you and I) are somewhere"],
            [pronoun: "First Dual Exclusive",   romanized: "osdedoho'i", syllabary: "ᎣᏍᏕᏙᎰᎢ", english: "We (another and I) are somewhere"],
            [pronoun: "First Plural Exclusive", romanized: "otsedoho'i", syllabary: "ᎣᏤᏙᎰᎢ", english: "We (others and I) are somewhere"],
            [pronoun: "First Plural Inclusive", romanized: "idedoho'i",  syllabary: "ᎢᏕᏙᎰᎢ", english: "We (you and I and another or others) are somewhere"],
            [pronoun: "Third Plural Form",      romanized: "anedoho'i",  syllabary: "ᎠᏁᏙᎰᎢ", english: "They are somewhere"],
    ]

    /**
     * Hook for the conjugation-engine comparison (to be wired in later).
     * Today it echoes the verb-book form; replace the body with a call into
     * the conjugation engine when the engine-vs-verb-book refinement begins.
     */
    Map conjugate(String pronoun) {
        def row = VERB_BOOK.find { it.pronoun == pronoun }
        // TODO(engine-comparison): replace this echo with a conjugation-engine call.
        return [romanized: row.romanized, syllabary: row.syllabary]
    }

    def "present habitual form matches the verb book (#row.pronoun)"() {
        when: "the form is conjugated"
        def form = conjugate(row.pronoun)

        then: "both the romanized and syllabary forms match the verb book"
        form.romanized == row.romanized
        form.syllabary == row.syllabary

        and: "the English translation is preserved for later deconstruction"
        row.english

        where: "each of the ten verb-book rows"
        row << VERB_BOOK
    }

    def "the verb book table is complete (ten pronoun rows)"() {
        expect:
        VERB_BOOK.size() == 10
    }
}
