package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Have Something Flexible" — Immediate Imperative/Volative (Stem IV).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.53
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem IV: -na-'-
 *   Immediate Imperative/Volative: -na'-esdi
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToHaveSomethingFlexibleImmediateImperativeVolativeSpec extends VerbBaseSpec {

    static final String VERB = "to have something flexible"
    static final String TENSE = "IMMEDIATE_IMPERATIVE_VOLATIVE"
    static final String SOURCE_PAGE = "p.53"

    // Affix composition as printed:
    static final String STEM = "-na-'-"        // Stem IV
    static final String TENSE_FORM = "-na'-esdi"  // Immediate Imperative/Volative (Stem IV)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "agina'esdi/dagina'esdi", syllabary: "ᎠᎩᎾᎡᏍᏗ/ᏓᎩᎾᎡᏍᏗ", english: "May I have something flexible (singular) right now!\"/\"May I have multiple flexible things right now!\""],
            [pronoun: "Second Singular", romanized: "tsana'esdi/detsana'esdi", syllabary: "ᏣᎾᎡᏍᏗ/ᏕᏣᎾᎡᏍᏗ", english: "May you have something flexible (singular) right now!\"/\"May you have multiple flexible things right now!\""],
            [pronoun: "Third Singular", romanized: "una'esdi/duna'esdi", syllabary: "ᎤᎾᎡᏍᏗ/ᏚᎾᎡᏍᏗ", english: "May he/she/it have something flexible (singular) right now!\"/\"May he/she/it have multiple flexible things right now!\""],
            [pronoun: "Second Dual", romanized: "sdina'esdi/desdina'esdi", syllabary: "ᏍᏗᎾᎡᏍᏗ/ᏕᏍᏗᎾᎡᏍᏗ", english: "May you (two) have something flexible (singular) right now!\"/\"May you (two) have multiple flexible things right now!\""],
            [pronoun: "Second Plural", romanized: "itsina'esdi/detsina'esdi", syllabary: "ᎢᏥᎾᎡᏍᏗ/ᏕᏥᎾᎡᏍᏗ", english: "May you (more than two) have something flexible (singular) right now!\"/\"May you (more than two) have multiple flexible things right now!\""],
            [pronoun: "First Dual Inclusive", romanized: "ginina'esdi/deginina'esdi", syllabary: "ᎩᏂᎾᎡᏍᏗ/ᏕᎩᏂᎾᎡᏍᏗ", english: "May we (you and I) have something flexible (singular) right now!\"/\"May we (you and I) have multiple flexible things right now!\""],
            [pronoun: "First Dual Exclusive", romanized: "ogina'esdi/dogina'esdi", syllabary: "ᎣᎩᎾᎡᏍᏗ/ᏙᎩᎾᎡᏍᏗ", english: "May we (another and I) have something flexible (singular) right now!\"/\"May we (another and I) have multiple flexible things right now!\""],
            [pronoun: "First Plural Exclusive", romanized: "ogina'esdi/dogina'esdi", syllabary: "ᎣᎩᎾᎡᏍᏗ/ᏙᎩᎾᎡᏍᏗ", english: "May we (others and I) have something flexible (singular) right now!\"/\"May we (others and I) have multiple flexible things right now!\""],
            [pronoun: "First Plural Inclusive", romanized: "igina'esdi/degina'esdi", syllabary: "ᎢᎩᎾᎡᏍᏗ/ᏕᎩᎾᎡᏍᏗ", english: "May we (you and I and another or others) have something flexible (singular) right now!\"/\"May we (you and I and another or others) have multiple flexible things right now!\""],
            [pronoun: "Third Plural", romanized: "unina'esdi/dunina'esdi", syllabary: "ᎤᏂᎾᎡᏍᏗ/ᏚᏂᎾᎡᏍᏗ", english: "May they have something flexible (singular) right now!\"/\"May they have multiple flexible things right now!\""],
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

    def "immediate imperative/volative form matches the verb book (#row.pronoun)"() {
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
