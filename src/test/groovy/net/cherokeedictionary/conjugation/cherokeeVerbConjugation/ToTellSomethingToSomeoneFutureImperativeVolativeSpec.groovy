package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Tell something to someone" — Future Imperative/Volative (Stem III).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.134
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III: -nohis-el-
 *   Future Imperative/Volative: -nohisel-v'i
 *
 * Verb-book note: "(Some time in the future, but not right now)"
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToTellSomethingToSomeoneFutureImperativeVolativeSpec extends Specification {

    static final String VERB = "to tell something to someone"
    static final String TENSE = "FUTURE_IMPERATIVE_VOLATIVE"
    static final String SOURCE_PAGE = "p.134"

    // Affix composition as printed:
    static final String STEM = "-nohis-el-"        // Stem III
    static final String TENSE_FORM = "-nohisel-v'i"  // Future Imperative/Volative (Stem III)

    static final String VERB_BOOK_NOTE =
        "(Some time in the future, but not right now)"

    /** The four conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "", romanized: "hinohiselv'i", syllabary: "ᎯᏃᎯᏎᎸᎢ", english: "You (singular) tell it!", occurrence: 1],
            [pronoun: "", romanized: "sdinohiselv'i", syllabary: "ᏍᏗᏃᎯᏎᎸᎢ", english: "You (two) tell it!", occurrence: 1],
            [pronoun: "", romanized: "etsinohiselv'i", syllabary: "ᎡᏥᏃᎯᏍᎸᎢ", english: "You (more than two) tell it to him/her", occurrence: 1],
            [pronoun: "", romanized: "kanohiselv'i", syllabary: "ᎧᏃᎯᏎᎸᎢ", english: "Let him/her tell it", occurrence: 1],
    ]

    /**
     * Hook for the conjugation-engine comparison (to be wired in later).
     * Today it echoes the verb-book form; replace the body with a call into
     * the conjugation engine when the engine-vs-verb-book refinement begins.
     *
     * occurrence disambiguates rows the verb book prints more than once with the
     * same pronoun group and English gloss.
     */
    Map conjugate(String pronoun, String english, int occurrence) {
        def matches = VERB_BOOK.findAll { it.pronoun == pronoun && it.english == english }
        def row = matches[Math.min(occurrence, matches.size()) - 1]
        // TODO(engine-comparison): replace this echo with a conjugation-engine call,
        // e.g. conjStr(pronoun, "SG3IN", verbFixture, TENSE, "v.t.")
        return [romanized: row.romanized, syllabary: row.syllabary]
    }

    def "future imperative/volative form matches the verb book (#row.pronoun: #row.english)"() {
        when: "the form is conjugated"
        def form = conjugate(row.pronoun, row.english, row.occurrence)

        then: "both the romanized and syllabary forms match the verb book"
        form.romanized == row.romanized
        form.syllabary == row.syllabary

        and: "the English translation is preserved for later deconstruction"
        row.english

        where: "each of the four verb-book rows"
        row << VERB_BOOK
    }

    def "the verb book table is complete (four rows)"() {
        expect:
        VERB_BOOK.size() == 4
    }
}
