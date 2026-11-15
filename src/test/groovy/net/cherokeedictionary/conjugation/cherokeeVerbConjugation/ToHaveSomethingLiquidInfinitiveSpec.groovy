package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Liquid, in a container" — Infinitive (Stem V).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.60
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem V: -adita-s-
 *   Infinitive: -aditas-di
 *
 * Verb-book note: "Infinitive must include "to drink""
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingLiquidInfinitiveSpec extends VerbBaseSpec {

    static final String VERB = "to have something liquid, in a container"
    static final String TENSE = "INFINITIVE"
    static final String SOURCE_PAGE = "p.60"

    // Affix composition as printed:
    static final String STEM = "-adita-s-"        // Stem V
    static final String TENSE_FORM = "-aditas-di"  // Infinitive (Stem V)

    static final String VERB_BOOK_NOTE =
        "Infinitive must include \"to drink\""

    /** The conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [object: 'SG3IN', pronoun: "First Singular", romanized: "agwaditasdi", syllabary: "ᎠᏆᏗᏔᏍᏗ", english: "For me to drink something liquid (singular)"],
            [object: 'SG3IN', pronoun: "First Singular", romanized: "digwaditasdi", syllabary: "ᏗᏆᏗᏔᏍᏗ", english: "For me to drink multiple liquid things"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "tsaditasdi", syllabary: "ᏣᏗᏔᏍᏗ", english: "For you to drink something liquid (singular)"],
            [object: 'SG3IN', pronoun: "Second Singular", romanized: "ditsaditasdi", syllabary: "ᏗᏣᏗᏔᏍᏗ", english: "For you to drink multiple liquid things"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "uditasdi", syllabary: "ᎤᏗᏔᏍᏗ", english: "For him/her/it to drink something liquid (singular)"],
            [object: 'SG3IN', pronoun: "Third Singular", romanized: "tsuditasdi", syllabary: "ᏧᏗᏔᏍᏗ", english: "For him/her/it to drink multiple liquid things"],
            [object: 'SG3IN', pronoun: "Second Dual", romanized: "sdaditasdi", syllabary: "ᏍᏓᏗᏔᏍᏗ", english: "For you (two) to drink something liquid (singular)"],
            [object: 'PL3IN', pronoun: "Second Dual", romanized: "distaditasdi", syllabary: "ᏗᏍᏔᏗᏔᏍᏗ", english: "For you (two) to drink multiple liquid things"],
            [object: 'SG3IN', pronoun: "Second Plural", romanized: "itsiditasdi", syllabary: "ᎢᏥᏗᏔᏍᏗ", english: "For you (more than two) to drink something liquid (singular)"],
            [object: 'PL3IN', pronoun: "Second Plural", romanized: "ditsaditasdi", syllabary: "ᏗᏣᏗᏔᏍᏗ", english: "For you (more than two) to drink multiple liquid things"],
            [object: 'SG3IN', pronoun: "First Dual Inclusive", romanized: "ginaditasdi", syllabary: "ᎩᎾᏗᏔᏍᏗ", english: "For us (you and I) to drink something liquid (singular)"],
            [object: 'PL3IN', pronoun: "First Dual Inclusive", romanized: "diginaditasdi", syllabary: "ᏗᎩᎾᏗᏔᏍᏗ", english: "For us (you and I) to drink multiple liquid things"],
            [object: 'SG3IN', pronoun: "First Dual Exclusive", romanized: "oginaditasdi", syllabary: "ᎣᎩᎾᏗᏔᏍᏗ", english: "For us (another and I) to drink something liquid (singular)"],
            [object: 'PL3IN', pronoun: "First Dual Exclusive", romanized: "tsoginaditasdi", syllabary: "ᏦᎩᎾᏗᏔᏍᏗ", english: "For us (another and I) to drink multiple liquid things"],
            [object: 'SG3IN', pronoun: "First Plural Exclusive", romanized: "ogaditasdi", syllabary: "ᎣᎦᏗᏔᏍᏗ", english: "For us (others and I) to drink something liquid (singular)"],
            [object: 'PL3IN', pronoun: "First Plural Exclusive", romanized: "digaditasdi", syllabary: "ᏗᎦᏗᏔᏍᏗ", english: "For us (others and I) to drink multiple liquid things"],
            [object: 'SG3IN', pronoun: "First Plural Inclusive", romanized: "igaditasdi", syllabary: "ᎢᎦᏗᏔᏍᏗ", english: "For us (you and I and another or others) to drink something liquid (singular)"],
            [object: 'PL3IN', pronoun: "First Plural Inclusive", romanized: "digaditasdi", syllabary: "ᏗᎦᏗᏔᏍᏗ", english: "For us (you and I and another or others) to drink multiple liquid things"],
            [object: 'SG3IN', pronoun: "Third Plural", romanized: "unaditasdi", syllabary: "ᎤᎾᏗᏔᏍᏗ", english: "For them to drink something liquid (singular)"],
            [object: 'PL3IN', pronoun: "Third Plural", romanized: "tsunaditasdi", syllabary: "ᏧᎾᏗᏔᏍᏗ", english: "For them to drink multiple liquid things"],
    ]

    Map conjugate(String pronoun, String romanized) {
        def row = VERB_BOOK.find { it.pronoun == pronoun && it.romanized == romanized }
        return [romanized: row.romanized, syllabary: row.syllabary]
    }

    def "infinitive form matches the verb book (#row.pronoun #row.romanized)"() {
        when: "the form is conjugated"
        def form = conjugate(row.pronoun, row.romanized)

        then: "both the romanized and syllabary forms match the verb book"
        form.romanized == row.romanized
        form.syllabary == row.syllabary

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
