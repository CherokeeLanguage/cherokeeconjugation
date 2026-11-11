package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import spock.lang.Specification
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Tell something to someone" — Present Tense (Stem I).
 *
 * Source: Cherokee Verb Conjugations (Durbin Feeling verb book), pp.132-134
 * (printed page numbers of the full 164-page document).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem I: -nohis-eh-
 *   Present Tense: -nohiseh-a
 *
 * Verb-book note: "This tense means the action is actually going on at the present time."
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToTellSomethingToSomeonePresentSpec extends Specification {

    static final String VERB = "to tell something to someone"
    static final String TENSE = "PRESENT"
    static final String SOURCE_PAGE = "pp.132-134"

    // Affix composition as printed:
    static final String STEM = "-nohis-eh-"        // Stem I
    static final String TENSE_FORM = "-nohiseh-a"  // Present Tense (Stem I)

    static final String VERB_BOOK_NOTE =
        "This tense means the action is actually going on at the present time."

    /** The 71 conjugated forms exactly as printed in the verb book (pronoun: the object-form group label, empty when the row is not grouped in print). */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular", romanized: "gvnohiseha", syllabary: "ᎬᏃᎯᏎᎭ", english: "I am telling you (singular)", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsinohiseha", syllabary: "ᏥᏃᎯᏎᎭ", english: "I am telling him/her", occurrence: 1],
            [pronoun: "First Singular", romanized: "tsinohiseha", syllabary: "ᏥᏃᎯᏎᎭ", english: "I am telling it", occurrence: 1],
            [pronoun: "First Singular", romanized: "sdvnohiseha", syllabary: "ᏍᏛᏃᎯᏎᎭ", english: "I am telling you (two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "itsvnohiseha", syllabary: "ᎢᏨᏃᎯᏎᎭ", english: "I am telling you (more than two)", occurrence: 1],
            [pronoun: "First Singular", romanized: "gatsinohiseha", syllabary: "ᎦᏥᏃᎯᏎᎭ", english: "I am telling them", occurrence: 1],
            [pronoun: "First Singular", romanized: "gatsinohiseha", syllabary: "ᎦᏥᏃᎯᏎᎭ", english: "I am telling those things", occurrence: 1],
            [pronoun: "Second Singular", romanized: "skinohiseha", syllabary: "ᏍᎩᏃᎯᏎᎭ", english: "You (singular) are telling me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hinohiseha", syllabary: "ᎯᏃᎯᏎᎭ", english: "You (singular) are telling him/her", occurrence: 1],
            [pronoun: "Second Singular", romanized: "hinohiseha", syllabary: "ᎯᏃᎯᏎᎭ", english: "You (singular) are telling it", occurrence: 1],
            [pronoun: "Second Singular", romanized: "sgininohiseha", syllabary: "ᏍᎩᏂᏃᎯᏎᎭ", english: "You (singular) are telling someone else and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "isginohiseha", syllabary: "ᎢᏍᎩᏃᎯᏎᎭ", english: "You (singular) are telling others and me", occurrence: 1],
            [pronoun: "Second Singular", romanized: "gahinohiseha", syllabary: "ᎦᎯᏃᎯᏎᎭ", english: "You (singular) are telling them", occurrence: 1],
            [pronoun: "Second Singular", romanized: "gahinohiseha", syllabary: "ᎦᎯᏃᎯᏎᎭ", english: "You (singular) are telling those (things)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "akinohiseha", syllabary: "ᎠᎩᏃᎯᏎᎭ", english: "S/he is telling me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "tsanohiseha", syllabary: "ᏣᏃᎯᏎᎭ", english: "S/he is telling you (singular)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "kanohiseha", syllabary: "ᎧᏃᎯᏎᎭ", english: "S/he is telling him/her", occurrence: 1],
            [pronoun: "Third Singular", romanized: "kanohiseha", syllabary: "ᎧᏃᎯᏎᎭ", english: "S/he is telling it", occurrence: 1],
            [pronoun: "Third Singular", romanized: "gininohiseha", syllabary: "ᎩᏂᏃᎯᏎᎭ", english: "S/he is telling you and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "ogininohiseha", syllabary: "ᎣᎩᏂᏃᎯᏎᎭ", english: "S/he is telling someone else and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginohiseha", syllabary: "ᎣᎩᏃᎯᏎᎭ", english: "S/he is telling another (or others), me and you", occurrence: 1],
            [pronoun: "Third Singular", romanized: "oginohiseha", syllabary: "ᎣᎩᏃᎯᏎᎭ", english: "S/he is telling others and me", occurrence: 1],
            [pronoun: "Third Singular", romanized: "sdinohiseha", syllabary: "ᏍᏗᏃᎯᏎᎭ", english: "S/he is telling you (two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "sdinohiseha", syllabary: "ᏍᏗᏃᎯᏎᎭ", english: "S/he is telling you (more than two)", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dekanohiseha", syllabary: "ᏕᎧᏃᎯᏎᎭ", english: "S/he is telling them", occurrence: 1],
            [pronoun: "Third Singular", romanized: "dekanohiseha", syllabary: "ᏕᎧᏃᎯᏎᎭ", english: "S/he is telling those things", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sgininohiseha", syllabary: "ᏍᎩᏂᏃᎯᏎᎭ", english: "You (two) are telling me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "esdinohiseha", syllabary: "ᎡᏍᏗᏃᎯᏎᎭ", english: "You (two) are telling him/her", occurrence: 1],
            [pronoun: "Second Dual", romanized: "sdinohiseha", syllabary: "ᏍᏗᏃᎯᏎᎭ", english: "You (two) are telling it", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desgininohiseha", syllabary: "ᏕᏍᎩᏂᏃᎯᏎᎭ", english: "You (two) are telling someone else and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desginohiseha", syllabary: "ᏕᏍᎩᏃᎯᏎᎭ", english: "You (two) are telling others and me", occurrence: 1],
            [pronoun: "Second Dual", romanized: "degesdinohiseha", syllabary: "ᏕᎨᏍᏗᏃᎯᏎᎭ", english: "You (two) are telling them", occurrence: 1],
            [pronoun: "Second Dual", romanized: "desdinohiseha", syllabary: "ᏕᏍᏗᏃᎯᏎᎭ", english: "You (two) are telling those (things)", occurrence: 1],
            [pronoun: "Second Plural", romanized: "isginohiseha", syllabary: "ᎢᏍᎩᏃᎯᏎᎭ", english: "You (more than two) are telling me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "etsinohiseha", syllabary: "ᎡᏥᏃᎯᏎᎭ", english: "You (more than two) are telling him/her", occurrence: 1],
            [pronoun: "Second Plural", romanized: "itsinohiseha", syllabary: "ᎢᏥᏃᎯᏎᎭ", english: "You (more than two) are telling it", occurrence: 1],
            [pronoun: "Second Plural", romanized: "desginohiseha", syllabary: "ᏕᏍᎩᏃᎯᏎᎭ", english: "You (more than two) are telling someone else and me", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsinohiseha", syllabary: "ᏕᏥᏃᎯᏎᎭ", english: "You (more than two) are telling them", occurrence: 1],
            [pronoun: "Second Plural", romanized: "detsinohiseha", syllabary: "ᏕᏥᏃᎯᏎᎭ", english: "You (more than two) are telling those things", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "eninohiseha", syllabary: "ᎡᏂᏃᎯᏎᎭ", english: "We (you and I) are telling him/her", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "ininohiseha", syllabary: "ᎢᏂᏃᎯᏎᎭ", english: "We (you and I) are telling it", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "geninohiseha", syllabary: "ᎨᏂᏃᎯᏎᎭ", english: "We (you and I) are telling them", occurrence: 1],
            [pronoun: "First Dual Inclusive", romanized: "deninohiseha", syllabary: "ᏕᏂᏃᎯᏎᎭ", english: "We (you and I) are telling those things", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvnohiseha", syllabary: "ᏍᏛᏃᎯᏎᎭ", english: "We (another and I) are telling you (singular)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdinohiseha", syllabary: "ᎣᏍᏗᏃᎯᏎᎭ", english: "We (another and I) are telling him/her", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "osdinohiseha", syllabary: "ᎣᏍᏗᏃᎯᏎᎭ", english: "We (another and I) are telling it", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "sdvnohiseha", syllabary: "ᏍᏛᏃᎯᏎᎭ", english: "We (another and I) are telling you (two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "itsvnohiseha", syllabary: "ᎢᏨᏃᎯᏎᎭ", english: "We (another and I) are telling you (more than two)", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "gotsinohiseha", syllabary: "ᎪᏥᏃᎯᏎᎭ", english: "We (another and I) are telling them", occurrence: 1],
            [pronoun: "First Dual Exclusive", romanized: "dotsinohiseha", syllabary: "ᏙᏥᏃᎯᏎᎭ", english: "We (another and I) are telling those (things)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "itsvnohiseha", syllabary: "ᎢᏨᏃᎯᏎᎭ", english: "We (others and I) are telling you (singular)", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsinohiseha", syllabary: "ᎣᏥᏃᎯᏎᎭ", english: "We (others and I) are telling him/her", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "otsinohiseha", syllabary: "ᎣᏥᏃᎯᏎᎭ", english: "We (others and I) are telling it", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "gotsinohiseha", syllabary: "ᎪᏥᏃᎯᏎᎭ", english: "We (others and I) are telling them", occurrence: 1],
            [pronoun: "First Plural Exclusive", romanized: "dotsinohiseha", syllabary: "ᏙᏥᏃᎯᏎᎭ", english: "We (others and I) are telling those (things)", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "edinohiseha", syllabary: "ᎡᏗᏃᎯᏎᎭ", english: "We (you and I and another or others) are telling him/her", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "idinohiseha", syllabary: "ᎢᏗᏃᎯᏎᎭ", english: "We (you and I and another or others) are telling it", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "gedinohiseha", syllabary: "ᎨᏗᏃᎯᏎᎭ", english: "We (you and I and another or others) are telling them", occurrence: 1],
            [pronoun: "First Plural Inclusive", romanized: "dedinohiseha", syllabary: "ᏕᏗᏃᎯᏎᎭ", english: "We (you and I and another or others) are telling those (things)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gvkinohiseha", syllabary: "ᎬᎩᏃᎯᏎᎭ", english: "They are telling me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsanohiseha", syllabary: "ᎨᏣᏃᎯᏎᎭ", english: "They are telling you (singular)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "aninohiseha", syllabary: "ᎠᏂᏃᎯᏎᎭ", english: "They are telling him/her", occurrence: 1],
            [pronoun: "Third Plural", romanized: "aninohiseha", syllabary: "ᎠᏂᏃᎯᏎᎭ", english: "They are telling it", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gegininohiseha", syllabary: "ᎨᎩᏂᏃᎯᏎᎭ", english: "They are telling you and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gogininohiseha", syllabary: "ᎪᎩᏂᏃᎯᏎᎭ", english: "They are telling someone else and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "geginohiseha", syllabary: "ᎨᎩᏃᎯᏎᎭ", english: "They are telling you and me and another or others", occurrence: 1],
            [pronoun: "Third Plural", romanized: "geginohiseha", syllabary: "ᎨᎩᏃᎯᏎᎭ", english: "They are telling others and me", occurrence: 1],
            [pronoun: "Third Plural", romanized: "gesdinohiseha", syllabary: "ᎨᏍᏗᏃᎯᏎᎭ", english: "They are telling you (two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "getsinohiseha", syllabary: "ᎨᏥᏃᎯᏎᎭ", english: "They are telling you (more than two)", occurrence: 1],
            [pronoun: "Third Plural", romanized: "daninohiseha", syllabary: "ᏓᏂᏃᎯᏎᎭ", english: "They are telling them", occurrence: 1],
            [pronoun: "Third Plural", romanized: "daninohiseha", syllabary: "ᏓᏂᏃᎯᏎᎭ", english: "They are telling those things", occurrence: 1],
    ]

    /**
     * Hook for the conjugation-engine comparison (to be wired in later).
     * Today it echoes the verb-book form; replace the body with a call into
     * the conjugation engine when the engine-vs-verb-book refinement begins.
     *
     * occurrence disambiguates rows the verb book prints more than once with the
     * same pronoun group and English gloss.
     */
    Map conjugate(String pronoun, String english, int occurrence) {
        def matches = VERB_BOOK.findAll { it.pronoun == pronoun && it.english == english }
        def row = matches[Math.min(occurrence, matches.size()) - 1]
        // TODO(engine-comparison): replace this echo with a conjugation-engine call,
        // e.g. conjStr(pronoun, "SG3IN", verbFixture, TENSE, "v.t.")
        return [romanized: row.romanized, syllabary: row.syllabary]
    }

    def "present tense form matches the verb book (#row.pronoun: #row.english)"() {
        when: "the form is conjugated"
        def form = conjugate(row.pronoun, row.english, row.occurrence)

        then: "both the romanized and syllabary forms match the verb book"
        form.romanized == row.romanized
        form.syllabary == row.syllabary

        and: "the English translation is preserved for later deconstruction"
        row.english

        where: "each of the 71 verb-book rows"
        row << VERB_BOOK
    }

    def "the verb book table is complete (71 rows)"() {
        expect:
        VERB_BOOK.size() == 71
    }
}
