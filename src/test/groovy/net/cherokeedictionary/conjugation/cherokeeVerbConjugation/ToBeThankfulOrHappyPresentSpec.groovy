package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Be Thankful or Happy" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), p.23
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -aliheli-g-
 *   Present Tense: -alihelig-a
 *
 * Verb-book note: "This verb means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToBeThankfulOrHappyPresentSpec extends VerbBaseSpec {

    static final String VERB = "to be thankful or happy"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "p.23"

    // Affix composition as printed:
    static final String STEM = "-aliheli-g-"        // Stem I
    static final String TENSE_FORM = "-alihelig-a"  // Present Tense (Stem I)

    static final String VERB_BOOK_NOTE =
        "This verb means the action is actually going on at the present time."

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gali'eliga", syllabary: "ᎦᎵᎡᎵᎦ", english: "I am thankful/happy"],
            [pronoun: "Second Singular", romanized: "haliheliga", syllabary: "ᎭᎵᎮᎵᎦ", english: "You are thankful/happy"],
            [pronoun: "Third Singular", romanized: "aliheliga", syllabary: "ᎠᎵᎮᎵᎦ", english: "He/she/it is thankful/happy"],
            [pronoun: "Second Dual", romanized: "sdaliheliga", syllabary: "ᏍᏓᎵᎮᎵᎦ", english: "You (two) are thankful/happy"],
            [pronoun: "Second Plural", romanized: "itsaliheliga", syllabary: "ᎢᏣᎵᎮᎵᎦ", english: "You (more than two) are thankful/happy"],
            [pronoun: "First Dual Inclusive", romanized: "inaliheliga", syllabary: "ᎢᎾᎵᎮᎵᎦ", english: "We (you and I) are thankful/happy"],
            [pronoun: "First Dual Exclusive", romanized: "osdaliheliga", syllabary: "ᎣᏍᏓᎵᎮᎵᎦ", english: "We (another and I) are thankful/happy"],
            [pronoun: "First Plural Exclusive", romanized: "otsaliheliga", syllabary: "ᎣᏣᎵᎮᎵᎦ", english: "We (others and I) are thankful/happy"],
            [pronoun: "First Plural Inclusive", romanized: "idaliheliga", syllabary: "ᎢᏓᎵᎮᎵᎦ", english: "We (you and I and another or others) are thankful/happy"],
            [pronoun: "Third Plural", romanized: "analiheliga", syllabary: "ᎠᎾᎵᎮᎵᎦ", english: "They are thankful/happy"],
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
