package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Liquid, in a container" — Future Imperative/Volative (Stem III).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.58
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III: -ne-h-
 *   Future Imperative/Volative: -neh-esdi
 *
 * Verb-book note: "Some time in the future, but not right now."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingLiquidFutureImperativeVolativeSpec extends VerbBaseSpec {

    static final String VERB = "to have something liquid, in a container"
    static final String TENSE = "FUTURE_IMPERATIVE_VOLATIVE"
    static final String SOURCE_PAGE = "p.58"

    // Affix composition as printed:
    static final String STEM = "-ne-h-"        // Stem III
    static final String TENSE_FORM = "-neh-esdi"  // Future Imperative/Volative (Stem III)

    static final String VERB_BOOK_NOTE =
        "Some time in the future, but not right now."

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "May I have multiple liquid things!\" aginehesdi/daginehesdi", syllabary: "ᎠᎩᏁᎮᏍᏗ/ᏓᎩᏁᎮᏍᏗ", english: "May I have something liquid (singular)!\"/"],
            [pronoun: "Second Singular", romanized: "tsanehesdi/detsanehesdi", syllabary: "ᏣᏁᎮᏍᏗ/ᏕᏣᏁᎮᏍᏗ", english: "May you have something liquid (singular)!\"/\"May you have multiple liquid things!\""],
            [pronoun: "Third Singular", romanized: "unehesdi/dunehesdi", syllabary: "ᎤᏁᎮᏍᏗ/ᏚᏁᎮᏍᏗ", english: "May he/she/it have something liquid (singular)!\"/\"May he/she/it have multiple liquid things!\""],
            [pronoun: "Second Dual", romanized: "sdinehesdi/desdinehesdi", syllabary: "ᏍᏗᏁᎮᏍᏗ/ᏕᏍᏗᏁᎮᏍᏗ", english: "May you (two) have something liquid (singular)!\"/\"May you (two) have multiple liquid things!\""],
            [pronoun: "Second Plural", romanized: "itsinehesdi/detsinehesdi", syllabary: "ᎢᏥᏁᎮᏍᏗ/ᏕᏥᏁᎮᏍᏗ", english: "May you (more than two) have something liquid (singular)!\"/\"May you (more than two) have multiple liquid things!\""],
            [pronoun: "First Dual Inclusive", romanized: "gininehesdi/degininehesdi", syllabary: "ᎩᏂᏁᎮᏍᏗ/ᏕᎩᏂᏁᎮᏍᏗ", english: "May we (you and I) have something liquid (singular)!\"/\"May we (you and I) have multiple liquid things!\""],
            [pronoun: "First Dual Exclusive", romanized: "ogininehesdi/dogininehesdi", syllabary: "ᎣᎩᏂᏁᎮᏍᏗ/ᏙᎩᏂᏁᎮᏍᏗ", english: "May we (another and I) have something liquid (singular)!\"/\"May we (another and I) have multiple liquid things!\""],
            [pronoun: "First Plural Exclusive", romanized: "oginehesdi/doginehesdi", syllabary: "ᎣᎩᏁᎮᏍᏗ/ᏙᎩᏁᎮᏍᏗ", english: "May we (others and I) have something liquid (singular)!\"/\"May we (others and I) have multiple liquid things!\""],
            [pronoun: "First Plural Inclusive", romanized: "iginehesdi/deginehesdi", syllabary: "ᎢᎩᏁᎮᏍᏗ/ᏕᎩᏁᎮᏍᏗ", english: "May we (you and I and another or others) have something liquid (singular)!\"/\"May we (you and I and another or others) have multiple liquid things!\""],
            [pronoun: "Third Plural Form", romanized: "uninehesdi/duninehesdi", syllabary: "ᎤᏂᏁᎮᏍᏗ/ᏚᏂᏁᎮᏍᏗ", english: "May they have something liquid (singular)!\"/\"May they have multiple liquid things!\""],
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

    def "the verb book table is complete (ten rows)"() {
        expect:
        VERB_BOOK.size() == 10
    }
}
