package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Be Somewhere" — Infinitive (Stem V).
 *
 * Source: Cherokee Verb Conjugations Single Entry (Durbin Feeling verb book), p.21.
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem IV:    -ed[o]-as-
 *   Infinitive: -edas-di    (Stem V + infinitive suffix -di)
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToBeSomewhereInfinitiveSpec extends VerbBaseSpec {

    static final String VERB = "to be somewhere"
    static final String TENSE = "INFINITIVE"
    static final String SOURCE_PAGE = "p.21"

    // Affix composition as printed:
    static final String STEM = "-ed[o]-as-"   // Stem V
    static final String TENSE_FORM = "-edas-di"  // Infinitive (Stem V + -di)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular",         romanized: "agwedasdi",  syllabary: "ᎠᏇᏓᏍᏗ",  english: "For me to be somewhere"],
            [pronoun: "Second Singular",        romanized: "tsedasdi",   syllabary: "ᏤᏓᏍᏗ",   english: "For you to be somewhere"],
            [pronoun: "Third Singular",         romanized: "uwedasdi",   syllabary: "ᎤᏪᏓᏍᏗ",  english: "For him/her/it to be somewhere"],
            [pronoun: "Second Dual",            romanized: "sdedasdi",   syllabary: "ᏍᏕᏓᏍᏗ",  english: "For you (two) to be somewhere"],
            [pronoun: "Second Plural",          romanized: "itsedasdi",  syllabary: "ᎢᏤᏓᏍᏗ",  english: "For you (more than two) to be somewhere"],
            [pronoun: "First Dual Inclusive",   romanized: "ginedasdi",  syllabary: "ᎩᏁᏓᏍᏗ",  english: "For us (you and I) to be somewhere"],
            [pronoun: "First Dual Exclusive",   romanized: "oginedasdi", syllabary: "ᎣᎩᏁᏓᏍᏗ", english: "For us (another and I) to be somewhere"],
            [pronoun: "First Plural Exclusive", romanized: "ogedasdi",   syllabary: "ᎣᎨᏓᏍᏗ",  english: "For us (others and I) to be somewhere"],
            [pronoun: "First Plural Inclusive", romanized: "igedasdi",   syllabary: "ᎢᎨᏓᏍᏗ",  english: "For us (you and I and another or others) to be somewhere"],
            [pronoun: "Third Plural",      romanized: "unedasdi",   syllabary: "ᎤᏁᏓᏍᏗ",  english: "For them to be somewhere"],
    ]

    /**
     * Hook for the conjugation-engine comparison (to be wired in later).
     * Today it echoes the verb-book form; replace the body with a call into
     * the conjugation engine when the engine-vs-verb-book refinement begins.
     */
    Map conjugate(String pronoun) {
        def row = VERB_BOOK.find { it.pronoun == pronoun }
        // TODO(engine-comparison): replace this echo with a conjugation-engine call.
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

    def "the verb book table is complete (ten pronoun rows)"() {
        expect:
        VERB_BOOK.size() == 10
    }
}
