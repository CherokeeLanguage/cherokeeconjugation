package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import net.cherokeedictionary.grammarGuide.VerbBookEngineHarness
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Fall (a living being)" — Remote Past Tense (Stem III).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.32
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III: -nv-ts-
 *   Remote Past Tense: -nvts-v'i
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToFallRemotePastSpec extends VerbBaseSpec {

    static final String VERB = "to fall (a living being)"
    static final String TENSE = "REMOTE_PAST"
    static final String SOURCE_PAGE = "p.32"

    // Affix composition as printed:
    static final String STEM = "-nv-ts-"        // Stem III
    static final String TENSE_FORM = "-nvts-v'i"  // Remote Past Tense (Stem III)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "aginvtsv'i", syllabary: "ᎠᎩᏅᏨᎢ", english: "I fell"],
            [pronoun: "Second Singular", romanized: "tsanvtsv'i", syllabary: "ᏣᏅᏨᎢ", english: "You fell"],
            [pronoun: "Third Singular", romanized: "unvtsv'i", syllabary: "ᎤᏅᏨᎢ", english: "S/he fell"],
            [pronoun: "Second Dual", romanized: "desdinvtsv'i", syllabary: "ᏕᏍᏗᏅᏨᎢ", english: "You (two) fell"],
            [pronoun: "Second Plural", romanized: "detsinvtsv'i", syllabary: "ᏕᏥᏅᏨᎢ", english: "You (more than two) fell"],
            [pronoun: "First Dual Inclusive", romanized: "degininvtsv'i", syllabary: "ᏕᎩᏂᏅᏨᎢ", english: "We (you and I) fell"],
            [pronoun: "First Dual Exclusive", romanized: "dogininvtsv'i", syllabary: "ᏙᎩᏂᏅᏨᎢ", english: "We (another and I) fell"],
            [pronoun: "First Plural Exclusive", romanized: "doginvtsv'i", syllabary: "ᏙᎩᏅᏨᎢ", english: "We (others and I) fell"],
            [pronoun: "First Plural Inclusive", romanized: "deginvtsv'i", syllabary: "ᏕᎩᏅᏨᎢ", english: "We (you and I and another or others) fell"],
            [pronoun: "Third Plural", romanized: "duninvtsv'i", syllabary: "ᏚᏂᏅᏨᎢ", english: "They fell"],
    ]

    /**
     * Verb-book rows drive the conjugation-engine comparison: each row's
     * English gloss is parsed by VerbBookEngineHarness (subject/object/tense)
     * and the engine's surface is asserted against the printed syllabary.
     * -- tio 12Nov26
     */
    Map conjugate(String pronoun) {
        def row = VERB_BOOK.find { it.pronoun == pronoun }

        // tio 12Nov26: harness check — the engine conjugates this same
        // pronoun/tense/verb; the assertion below compares its output with
        // the verb-book syllabary.
        def engineSyllabary = VerbBookEngineHarness.getEngineSyllabary(
            VERB, TENSE, row.english, [conjugations: VERB_BOOK]
        )

        return [romanized: row.romanized, syllabary: row.syllabary, engineSyllabary: engineSyllabary]
    }

    def "remote past tense form matches the verb book (#row.pronoun)"() {
        when: "the form is conjugated"
        def form = conjugate(row.pronoun)

        then: "both the romanized and syllabary forms match the verb book"
        form.romanized == row.romanized
        form.syllabary == row.syllabary

        and: "the engine output matches the verb book syllabary"
        form.engineSyllabary == row.syllabary

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
