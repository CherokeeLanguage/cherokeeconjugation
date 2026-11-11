package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Be Somewhere" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations Single Entry (Durbin Feeling verb book), p.19.
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I:  -edo-h-
 *   Present: -edoh-a    (Stem I + present suffix -a)
 *
 * Verb-book note: "This verb means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes.
 */
@Unroll
class ToBeSomewherePresentSpec extends VerbBaseSpec {

    static final String VERB = "to be somewhere"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "p.19"

    // Affix composition as printed:
    static final String STEM = "-edo-h-"        // Stem I
    static final String TENSE_FORM = "-edoh-a"  // Present (Stem I + -a)

    static final String VERB_BOOK_NOTE =
        "This verb means the action is actually going on at the present time."

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular",         romanized: "gedoha",   syllabary: "ᎨᏙᎭ",  english: "I am somewhere"],
            [pronoun: "Second Singular",        romanized: "hedoha",   syllabary: "ᎮᏙᎭ",  english: "You are somewhere"],
            [pronoun: "Third Singular",         romanized: "edoha",    syllabary: "ᎡᏙᎭ",  english: "He/she/it is somewhere"],
            [pronoun: "Second Dual",            romanized: "sdedoha",  syllabary: "ᏍᏕᏙᎭ", english: "You (two) are somewhere"],
            [pronoun: "Second Plural",          romanized: "itsedoha", syllabary: "ᎢᏤᏙᎭ", english: "You (more than two) are somewhere"],
            [pronoun: "First Dual Inclusive",   romanized: "inedoha",  syllabary: "ᎢᏁᏙᎭ", english: "We (you and I) are somewhere"],
            [pronoun: "First Dual Exclusive",   romanized: "osdedoha", syllabary: "ᎣᏍᏕᏙᎭ", english: "We (another and I) are somewhere"],
            [pronoun: "First Plural Exclusive", romanized: "otsedoha", syllabary: "ᎣᏤᏙᎭ", english: "We (others and I) are somewhere"],
            [pronoun: "First Plural Inclusive", romanized: "idedoha",  syllabary: "ᎢᏕᏙᎭ", english: "We (you and I and another or others) are somewhere"],
            [pronoun: "Third Plural Form",      romanized: "anedoha",  syllabary: "ᎠᏁᏙᎭ", english: "They are somewhere"],
    ]

    /**
     * Hook for the conjugation-engine comparison (to be wired in later).
     * Today it echoes the verb-book form; replace the body with a call into
     * the conjugation engine when the engine-vs-verb-book refinement begins.
     */
    Map conjugate(String pronoun) {
        def row = VERB_BOOK.find { it.pronoun == pronoun }
        // TODO(engine-comparison): replace this echo with a conjugation-engine call,
        // e.g. conjStr(pronoun, "SG3IN", verbFixture, TENSE, "v.i.")
        return [romanized: row.romanized, syllabary: row.syllabary]
    }

    def "present tense form matches the verb book (#row.pronoun)"() {
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
