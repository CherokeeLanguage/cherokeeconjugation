package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Go" — Remote Past Tense (Stem III).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.36-37
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III: -env-s-
 *   Remote Past Tense: -envs-v'i
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToGoRemotePastSpec extends Specification {

    static final String VERB = "to go"
    static final String TENSE = "REMOTE_PAST"
    static final String SOURCE_PAGE = "pp.36-37"

    // Affix composition as printed:
    static final String STEM = "-env-s-"        // Stem III
    static final String TENSE_FORM = "-envs-v'i"  // Remote Past Tense (Stem III)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "agwenvsv'i", syllabary: "ᎠᏇᏅᏒᎢ", english: "I went"],
            [pronoun: "Second Singular", romanized: "tsenvsv'i", syllabary: "ᏤᏅᏒᎢ", english: "You went"],
            [pronoun: "Third Singular", romanized: "uwenvsv'i", syllabary: "ᎤᏪᏅᏒᎢ", english: "He/she/it went"],
            [pronoun: "Second Dual", romanized: "sdenvsv'i", syllabary: "ᏍᏕᏅᏒᎢ", english: "You (two) went"],
            [pronoun: "Second Plural", romanized: "itsenvsv'i", syllabary: "ᎢᏤᏅᏒᎢ", english: "You (more than two) went"],
            [pronoun: "First Dual Inclusive", romanized: "ginenvsv'i", syllabary: "ᎩᏁᏅᏒᎢ", english: "We (you and I) went"],
            [pronoun: "First Dual Exclusive", romanized: "oginenvsv'i", syllabary: "ᎣᎩᏁᏅᏒᎢ", english: "We (another and I) went"],
            [pronoun: "First Plural Exclusive", romanized: "ogenvsv'i", syllabary: "ᎣᎨᏅᏒᎢ", english: "We (others and I) went"],
            [pronoun: "First Plural Inclusive", romanized: "igenvsv'i", syllabary: "ᎢᎨᏅᏒᎢ", english: "We (you and I and another or others) went"],
            [pronoun: "Third Plural Form", romanized: "unenvsv'i", syllabary: "ᎤᏁᏅᏒᎢ", english: "They went"],
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

    def "remote past tense form matches the verb book (#row.pronoun)"() {
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
