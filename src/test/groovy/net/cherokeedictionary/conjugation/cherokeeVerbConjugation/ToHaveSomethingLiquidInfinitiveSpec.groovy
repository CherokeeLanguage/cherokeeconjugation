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

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "agwaditasdi/digwaditasdi", syllabary: "ᎠᏆᏗᏔᏍᏗ/ᏗᏆᏗᏔᏍᏗ", english: "For me to drink something liquid (singular)\"/\"For me to drink multiple liquid things\""],
            [pronoun: "Second Singular", romanized: "tsaditasdi/ditsaditasdi", syllabary: "ᏣᏗᏔᏍᏗ/ᏗᏣᏗᏔᏍᏗ", english: "For you to drink something liquid (singular)\"/\"For you to drink multiple liquid things\""],
            [pronoun: "Third Singular", romanized: "uditasdi/tsuditasdi", syllabary: "ᎤᏗᏔᏍᏗ/ᏧᏗᏔᏍᏗ", english: "For him/her/it to drink something liquid (singular)\"/\"For him/her/it to drink multiple liquid things\""],
            [pronoun: "Second Dual", romanized: "sdaditasdi/distaditasdi", syllabary: "ᏍᏓᏗᏔᏍᏗ/ᏗᏍᏔᏗᏔᏍᏗ", english: "For you (two) to drink something liquid (singular)\"/\"For you (two) to drink multiple liquid things\""],
            [pronoun: "Second Plural", romanized: "itsiditasdi/ditsaditasdi", syllabary: "ᎢᏥᏗᏔᏍᏗ/ᏗᏣᏗᏔᏍᏗ", english: "For you (more than two) to drink something liquid (singular)\"/\"For you (more than two) to drink multiple liquid things\""],
            [pronoun: "First Dual Inclusive", romanized: "ginaditasdi/diginaditasdi", syllabary: "ᎩᎾᏗᏔᏍᏗ/ᏗᎩᎾᏗᏔᏍᏗ", english: "For us (you and I) to drink something liquid (singular)\"/\"For us (you and I) to drink multiple liquid things\""],
            [pronoun: "First Dual Exclusive", romanized: "oginaditasdi/tsoginaditasdi", syllabary: "ᎣᎩᎾᏗᏔᏍᏗ/ᏦᎩᎾᏗᏔᏍᏗ", english: "For us (another and I) to drink something liquid (singular)\"/\"For us (another and I) to drink multiple liquid things\""],
            [pronoun: "First Plural Exclusive", romanized: "ogaditasdi/digaditasdi", syllabary: "ᎣᎦᏗᏔᏍᏗ/ᏗᎦᏗᏔᏍᏗ", english: "For us (others and I) to drink something liquid (singular)\"/\"For us (others and I) to drink multiple liquid things\""],
            [pronoun: "First Plural Inclusive", romanized: "igaditasdi/digaditasdi", syllabary: "ᎢᎦᏗᏔᏍᏗ/ᏗᎦᏗᏔᏍᏗ", english: "For us (you and I and another or others) to drink something liquid (singular)\"/\"For us (you and I and another or others) to drink multiple liquid things\""],
            [pronoun: "Third Plural", romanized: "unaditasdi/tsunaditasdi", syllabary: "ᎤᎾᏗᏔᏍᏗ/ᏧᎾᏗᏔᏍᏗ", english: "For them to drink something liquid (singular)\"/\"For them to drink multiple liquid things\""],
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

    def "infinitive form matches the verb book (#row.pronoun)"() {
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

    def "the verb book table is complete (ten rows)"() {
        expect:
        VERB_BOOK.size() == 10
    }
}
