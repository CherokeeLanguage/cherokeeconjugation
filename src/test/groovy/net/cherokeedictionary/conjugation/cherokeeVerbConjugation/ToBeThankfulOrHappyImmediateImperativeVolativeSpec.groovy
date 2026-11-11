package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Be Thankful or Happy" — Immediate Imperative/Volative (Stem IV).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.25
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem IV: -aliheli-g-
 *   Immediate Imperative/Volative: -alihelig-i
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToBeThankfulOrHappyImmediateImperativeVolativeSpec extends VerbBaseSpec {

    static final String VERB = "to be thankful or happy"
    static final String TENSE = "IMMEDIATE_IMPERATIVE_VOLATIVE"
    static final String SOURCE_PAGE = "p.25"

    // Affix composition as printed:
    static final String STEM = "-aliheli-g-"        // Stem IV
    static final String TENSE_FORM = "-alihelig-i"  // Immediate Imperative/Volative (Stem IV)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gali'eligi", syllabary: "ᎦᎵᎡᎵᎩ", english: "May I be thankful/happy right now!"],
            [pronoun: "Second Singular", romanized: "haliheligi", syllabary: "ᎭᎵᎮᎵᎩ", english: "May you be thankful/happy right now!"],
            [pronoun: "Third Singular", romanized: "waliheligi", syllabary: "ᏩᎵᎮᎵᎩ", english: "May he/she/it be thankful/happy right now!"],
            [pronoun: "Second Dual", romanized: "sdaliheligi", syllabary: "ᏍᏓᎵᎮᎵᎩ", english: "May you (two) be thankful/happy right now!"],
            [pronoun: "Second Plural", romanized: "itsaliheligi", syllabary: "ᎢᏣᎵᎮᎵᎩ", english: "May you (more than two) be thankful/happy right now!"],
            [pronoun: "First Dual Inclusive", romanized: "inaliheligi", syllabary: "ᎢᎾᎵᎮᎵᎩ", english: "May we (you and I) be thankful/happy right now!"],
            [pronoun: "First Dual Exclusive", romanized: "wosdaliheligi", syllabary: "ᏬᏍᏓᎵᎮᎵᎩ", english: "May we (another and I) be thankful/happy right now!"],
            [pronoun: "First Plural Exclusive", romanized: "wotsaliheligi", syllabary: "ᏬᏣᎵᎮᎵᎩ", english: "May we (others and I) be thankful/happy right now!"],
            [pronoun: "First Plural Inclusive", romanized: "idaliheligi", syllabary: "ᎢᏓᎵᎮᎵᎩ", english: "May we (you and I and another or others) be thankful/happy right now!"],
            [pronoun: "Third Plural Form", romanized: "wanaliheligi", syllabary: "ᏩᎾᎵᎮᎵᎩ", english: "May they be thankful/happy right now!"],
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
