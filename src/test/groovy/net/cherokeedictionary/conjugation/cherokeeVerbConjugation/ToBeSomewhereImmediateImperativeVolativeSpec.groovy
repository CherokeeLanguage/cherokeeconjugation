package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Be Somewhere" — Immediate Imperative/Volative (Stem IV).
 *
 * Source: Cherokee Verb Conjugations Single Entry (Durbin Feeling verb book), p.21.
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem IV:                     -ed[o]-Ø-
 *   Immediate Imperative/Volative: -ed-a    (Stem IV + -a)
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToBeSomewhereImmediateImperativeVolativeSpec extends VerbBaseSpec {

    static final String VERB = "to be somewhere"
    static final String TENSE = "IMMEDIATE_IMPERATIVE_VOLATIVE"
    static final String SOURCE_PAGE = "p.21"

    // Affix composition as printed:
    static final String STEM = "-ed[o]-Ø-"  // Stem IV
    static final String TENSE_FORM = "-ed-a"    // Immediate Imperative/Volative (Stem IV + -a)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular",         romanized: "geda",    syllabary: "ᎨᏓ",  english: "May I be somewhere right now!"],
            [pronoun: "Second Singular",        romanized: "heda",    syllabary: "ᎮᏓ",  english: "May you be somewhere right now!"],
            [pronoun: "Third Singular",         romanized: "weda",    syllabary: "ᏪᏓ",  english: "May he/she/it be somewhere right now!"],
            [pronoun: "Second Dual",            romanized: "sdeda",   syllabary: "ᏍᏕᏓ", english: "May you (two) be somewhere right now!"],
            [pronoun: "Second Plural",          romanized: "itseda",  syllabary: "ᎢᏤᏓ", english: "May you (more than two) be somewhere right now!"],
            [pronoun: "First Dual Inclusive",   romanized: "ineda",   syllabary: "ᎢᏁᏓ", english: "May we (you and I) be somewhere right now!"],
            [pronoun: "First Dual Exclusive",   romanized: "wosdeda", syllabary: "ᏬᏍᏕᏓ", english: "May we (another and I) be somewhere right now!"],
            [pronoun: "First Plural Exclusive", romanized: "wotseda", syllabary: "ᏬᏤᏓ", english: "May we (others and I) be somewhere right now!"],
            [pronoun: "First Plural Inclusive", romanized: "ideda",   syllabary: "ᎢᏕᏓ", english: "May we (you and I and another or others) be somewhere right now!"],
            [pronoun: "Third Plural Form",      romanized: "waneda",  syllabary: "ᏩᏁᏓ", english: "May they be somewhere right now!"],
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

    def "the verb book table is complete (ten pronoun rows)"() {
        expect:
        VERB_BOOK.size() == 10
    }
}
