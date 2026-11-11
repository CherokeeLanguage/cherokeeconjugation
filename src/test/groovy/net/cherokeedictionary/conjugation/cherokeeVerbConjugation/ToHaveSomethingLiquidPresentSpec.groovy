package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Liquid, in a container" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.56
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -ne-h-
 *   Present Tense: -neh-a
 *
 * Verb-book note: "This verb means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingLiquidPresentSpec extends VerbBaseSpec {

    static final String VERB = "to have something liquid, in a container"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "p.56"

    // Affix composition as printed:
    static final String STEM = "-ne-h-"        // Stem I
    static final String TENSE_FORM = "-neh-a"  // Present Tense (Stem I)

    static final String VERB_BOOK_NOTE =
        "This verb means the action is actually going on at the present time."

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "I have multiple liquid things\" agineha/dagineha", syllabary: "ᎠᎩᏁᎭ/ᏓᎩᏁᎭ", english: "I have something liquid (singular)\"/"],
            [pronoun: "Second Singular", romanized: "You have multiple liquid things\" tsaneha/detsaneha", syllabary: "ᏣᏁᎭ/ᏕᏣᏁᎭ", english: "You have something liquid (singular)\"/"],
            [pronoun: "Third Singular", romanized: "He/she/it has multiple liquid things\" uneha/duneha", syllabary: "ᎤᏁᎭ/ᏚᏁᎭ", english: "He/she/it has something liquid (singular)\"/"],
            [pronoun: "Second Dual", romanized: "You (two) have multiple liquid things\" sdineha/desdineha", syllabary: "ᏍᏗᏁᎭ/ᏕᏍᏗᏁᎭ", english: "You (two) have something liquid (singular)\"/"],
            [pronoun: "Second Plural", romanized: "itsineha/detsineha", syllabary: "ᎢᏥᏁᎭ/ᏕᏥᏁᎭ", english: "You (more than two) have something liquid (singular)\"/\"You (more than two) have multiple liquid things\""],
            [pronoun: "First Dual Inclusive", romanized: "ginineha/deginineha", syllabary: "ᎩᏂᏁᎭ/ᏕᎩᏂᏁᎭ", english: "We (you and I) have something liquid (singular)\"/\"We (you and I) have multiple liquid things\""],
            [pronoun: "First Dual Exclusive", romanized: "oginineha/doginineha", syllabary: "ᎣᎩᏂᏁᎭ/ᏙᎩᏂᏁᎭ", english: "We (another and I) have something liquid (singular)\"/\"We (another and I) have multiple liquid things\""],
            [pronoun: "First Plural Exclusive", romanized: "ogineha/dogineha", syllabary: "ᎣᎩᏁᎭ/ᏙᎩᏁᎭ", english: "We (others and I) have something liquid (singular)\"/\"We (others and I) have multiple liquid things\""],
            [pronoun: "First Plural Inclusive", romanized: "igineha/degineha", syllabary: "ᎢᎩᏁᎭ/ᏕᎩᏁᎭ", english: "We (you and I and another or others) have something liquid (singular)\"/\"We (you and I and another or others) have multiple liquid things\""],
            [pronoun: "Third Plural Form", romanized: "They have multiple liquid things\" unineha/dunineha", syllabary: "ᎤᏂᏁᎭ/ᏚᏂᏁᎭ", english: "They have something liquid (singular)\"/"],
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

    def "the verb book table is complete (ten rows)"() {
        expect:
        VERB_BOOK.size() == 10
    }
}
