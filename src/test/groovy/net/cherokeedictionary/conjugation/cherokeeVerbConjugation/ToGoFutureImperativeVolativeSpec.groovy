package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Go" — Future Imperative/Volative (Stem III).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.37
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III: -env-s-
 *   Future Imperative/Volative: -envs-v'i
 *
 * Verb-book note: "Some time in the future, but not right now."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToGoFutureImperativeVolativeSpec extends VerbBaseSpec {

    static final String VERB = "to go"
    static final String TENSE = "FUTURE_IMPERATIVE_VOLATIVE"
    static final String SOURCE_PAGE = "p.37"

    // Affix composition as printed:
    static final String STEM = "-env-s-"        // Stem III
    static final String TENSE_FORM = "-envs-v'i"  // Future Imperative/Volative (Stem III)

    static final String VERB_BOOK_NOTE =
        "Some time in the future, but not right now."

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "eligwus yigenvsv'i", syllabary: "ᎡᎵᏊᏍ ᏱᎨᏅᏒᎢ", english: "May I go later on?"],
            [pronoun: "Second Singular", romanized: "hwenvsv'i", syllabary: "ᏪᏅᏒᎢ", english: "May you go later on!"],
            [pronoun: "Third Singular", romanized: "wenvsv'i", syllabary: "ᏪᏅᏒᎢ", english: "May he/she/it go later on!"],
            [pronoun: "Second Dual", romanized: "wisdenvsv'i", syllabary: "ᏫᏍᏕᏅᏒᎢ", english: "May you (two) go later on!"],
            [pronoun: "Second Plural", romanized: "witsenvsv'i", syllabary: "ᏫᏤᏅᏒᎢ", english: "May you (more than two) go later on!"],
            [pronoun: "First Dual Inclusive", romanized: "winenvsv'i", syllabary: "ᏫᏁᏅᏒᎢ", english: "May we (you and I) go later on!"],
            [pronoun: "First Dual Exclusive", romanized: "wosdenvsv'i", syllabary: "ᏬᏍᏕᏅᏒᎢ", english: "May we (another and I) go later on!"],
            [pronoun: "First Plural Exclusive", romanized: "wotsenvsv'i", syllabary: "ᏬᏤᏅᏒᎢ", english: "May we (others and I) go later on!"],
            [pronoun: "First Plural Inclusive", romanized: "widenvsv'i", syllabary: "ᏫᏕᏅᏒᎢ", english: "May we (you and I and another or others) go later on!"],
            [pronoun: "Third Plural Form", romanized: "wanenvsv'i", syllabary: "ᏩᏁᏅᏒᎢ", english: "May they go later on!"],
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
