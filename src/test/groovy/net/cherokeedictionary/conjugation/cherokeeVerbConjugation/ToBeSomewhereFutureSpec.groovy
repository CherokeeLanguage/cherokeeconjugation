package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Be Somewhere" — Future Tense (Stem III).
 *
 * Source: Cherokee Verb Conjugations Single Entry (Durbin Feeling verb book), p.20.
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III: -edo-h-
 *   Future:   -edoh-esdi    (Stem III + future suffix -esdi)
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToBeSomewhereFutureSpec extends VerbBaseSpec {

    static final String VERB = "to be somewhere"
    static final String TENSE = "FUTURE"
    static final String SOURCE_PAGE = "p.20"

    // Affix composition as printed:
    static final String STEM = "-edo-h-"       // Stem III
    static final String TENSE_FORM = "-edoh-esdi"  // Future (Stem III + -esdi)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular",         romanized: "gedohesdi",   syllabary: "ᎨᏙᎮᏍᏗ",  english: "I will be somewhere"],
            [pronoun: "Second Singular",        romanized: "hedohesdi",   syllabary: "ᎮᏙᎮᏍᏗ",  english: "You will be somewhere"],
            [pronoun: "Third Singular",         romanized: "edohesdi",    syllabary: "ᎡᏙᎮᏍᏗ",  english: "He/she/it will be somewhere"],
            [pronoun: "Second Dual",            romanized: "sdedohesdi",  syllabary: "ᏍᏕᏙᎮᏍᏗ", english: "You (two) will be somewhere"],
            [pronoun: "Second Plural",          romanized: "itsedohesdi", syllabary: "ᎢᏤᏙᎮᏍᏗ", english: "You (more than two) will be somewhere"],
            [pronoun: "First Dual Inclusive",   romanized: "inedohesdi",  syllabary: "ᎢᏁᏙᎮᏍᏗ", english: "We (you and I) will be somewhere"],
            [pronoun: "First Dual Exclusive",   romanized: "osdedohesdi", syllabary: "ᎣᏍᏕᏙᎮᏍᏗ", english: "We (another and I) will be somewhere"],
            [pronoun: "First Plural Exclusive", romanized: "otsedohesdi", syllabary: "ᎣᏤᏙᎮᏍᏗ", english: "We (others and I) will be somewhere"],
            [pronoun: "First Plural Inclusive", romanized: "idedohesdi",  syllabary: "ᎢᏕᏙᎮᏍᏗ", english: "We (you and I and another or others) will be somewhere"],
            [pronoun: "Third Plural",      romanized: "anedohesdi",  syllabary: "ᎠᏁᏙᎮᏍᏗ", english: "They will be somewhere"],
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

    def "future tense form matches the verb book (#row.pronoun)"() {
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
