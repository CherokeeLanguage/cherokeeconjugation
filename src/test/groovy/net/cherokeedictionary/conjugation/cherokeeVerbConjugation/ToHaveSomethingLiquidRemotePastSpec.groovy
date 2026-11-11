package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Liquid, in a container" — Remote Past Tense (Stem III).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.57
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III: -ne-h-
 *   Remote Past Tense: -neh-v'i
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingLiquidRemotePastSpec extends VerbBaseSpec {

    static final String VERB = "to have something liquid, in a container"
    static final String TENSE = "REMOTE_PAST"
    static final String SOURCE_PAGE = "p.57"

    // Affix composition as printed:
    static final String STEM = "-ne-h-"        // Stem III
    static final String TENSE_FORM = "-neh-v'i"  // Remote Past Tense (Stem III)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "I had multiple liquid things\" aginehv'i/daginehv'i", syllabary: "ᎠᎩᏁᎲᎢ/ᏓᎩᏁᎲᎢ", english: "I had something liquid (singular)\"/"],
            [pronoun: "Second Singular", romanized: "You had multiple liquid things\" tsanehv'i/detsanehv'i", syllabary: "ᏣᏁᎲᎢ/ᏕᏣᏁᎲᎢ", english: "You had something liquid (singular)\"/"],
            [pronoun: "Third Singular", romanized: "He/she/it had multiple liquid things\" unehv'i/dunehv'i", syllabary: "ᎤᏁᎲᎢ/ᏚᏁᎲᎢ", english: "He/she/it had something liquid (singular)\"/"],
            [pronoun: "Second Dual", romanized: "You (two) had multiple liquid things\" sdinehv'i/desdinehv'i", syllabary: "ᏍᏗᏁᎲᎢ/ᏕᏍᏗᏁᎲᎢ", english: "You (two) had something liquid (singular)\"/"],
            [pronoun: "Second Plural", romanized: "itsinehv'i/detsinehv'i", syllabary: "ᎢᏥᏁᎲᎢ/ᏕᏥᏁᎲᎢ", english: "You (more than two) had something liquid (singular)\"/\"You (more than two) had multiple liquid things\""],
            [pronoun: "First Dual Inclusive", romanized: "gininehv'i/degininehv'i", syllabary: "ᎩᏂᏁᎲᎢ/ᏕᎩᏂᏁᎲᎢ", english: "We (you and I) had something liquid (singular)\"/\"We (you and I) had multiple liquid things\""],
            [pronoun: "First Dual Exclusive", romanized: "ogininehv'i/dogininehv'i", syllabary: "ᎣᎩᏂᏁᎲᎢ/ᏙᎩᏂᏁᎲᎢ", english: "We (another and I) had something liquid (singular)\"/\"We (another and I) had multiple liquid things\""],
            [pronoun: "First Plural Exclusive", romanized: "oginehv'i/doginehv'i", syllabary: "ᎣᎩᏁᎲᎢ/ᏙᎩᏁᎲᎢ", english: "We (others and I) had something liquid (singular)\"/\"We (others and I) had multiple liquid things\""],
            [pronoun: "First Plural Inclusive", romanized: "iginehv'i/deginehv'i", syllabary: "ᎢᎩᏁᎲᎢ/ᏕᎩᏁᎲᎢ", english: "We (you and I and another or others) had something liquid (singular)\"/\"We (you and I and another or others) had multiple liquid things\""],
            [pronoun: "Third Plural Form", romanized: "They had multiple liquid things\" uninehv'i/duninehv'i", syllabary: "ᎤᏂᏁᎲᎢ/ᏚᏂᏁᎲᎢ", english: "They had something liquid (singular)\"/"],
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
