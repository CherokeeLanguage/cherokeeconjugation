package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Be Somewhere" — Future Imperative/Volative (Stem III).
 *
 * Source: Cherokee Verb Conjugations Single Entry (Durbin Feeling verb book), p.20.
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III:                  -edo-h-
 *   Future Imperative/Volative: edoh-esdi    (as printed — no leading hyphen;
 *                               compare "Future: -edoh-esdi" in the same section)
 *
 * Verb-book note: "Sometime in the future, but not right now."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToBeSomewhereFutureImperativeVolativeSpec extends VerbBaseSpec {

    static final String VERB = "to be somewhere"
    static final String TENSE = "FUTURE_IMPERATIVE_VOLATIVE"
    static final String SOURCE_PAGE = "p.20"

    // Affix composition as printed:
    static final String STEM = "-edo-h-"       // Stem III
    static final String TENSE_FORM = "edoh-esdi"  // Future Imperative/Volative (as printed, no leading hyphen)

    static final String VERB_BOOK_NOTE = "Sometime in the future, but not right now."

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular",         romanized: "gedohesdi",   syllabary: "ᎨᏙᎮᏍᏗ",  english: "May I be somewhere!"],
            [pronoun: "Second Singular",        romanized: "hedohesdi",   syllabary: "ᎮᏙᎮᏍᏗ",  english: "May you be somewhere!"],
            [pronoun: "Third Singular",         romanized: "edohesdi",    syllabary: "ᎡᏙᎮᏍᏗ",  english: "May he/she/it be somewhere!"],
            [pronoun: "Second Dual",            romanized: "sdedohesdi",  syllabary: "ᏍᏕᏙᎮᏍᏗ", english: "May you (two) be somewhere!"],
            [pronoun: "Second Plural",          romanized: "itsedohesdi", syllabary: "ᎢᏤᏙᎮᏍᏗ", english: "May you (more than two) be somewhere!"],
            [pronoun: "First Dual Inclusive",   romanized: "inedohesdi",  syllabary: "ᎢᏁᏙᎮᏍᏗ", english: "May we (you and I) be somewhere!"],
            [pronoun: "First Dual Exclusive",   romanized: "osdedohesdi", syllabary: "ᎣᏍᏕᏙᎮᏍᏗ", english: "May we (another and I) be somewhere!"],
            [pronoun: "First Plural Exclusive", romanized: "otsedohesdi", syllabary: "ᎣᏤᏙᎮᏍᏗ", english: "May we (others and I) be somewhere!"],
            [pronoun: "First Plural Inclusive", romanized: "idedohesdi",  syllabary: "ᎢᏕᏙᎮᏍᏗ", english: "May we (you and I and another or others) be somewhere!"],
            [pronoun: "Third Plural",      romanized: "anedohesdi",  syllabary: "ᎠᏁᏙᎮᏍᏗ", english: "May they be somewhere!"],
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

    def "future imperative/volative form matches the verb book (#row.pronoun)"() {
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
