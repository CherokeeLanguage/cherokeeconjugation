package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import net.cherokeedictionary.grammarGuide.VerbBookEngineHarness
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Be Somewhere" — Remote Past Tense (Stem III).
 *
 * Source: Cherokee Verb Conjugations Single Entry (Durbin Feeling verb book), pp.19-20
 * (the table begins on p.19 and its last two rows continue on p.20).
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem III:    -edo-h-
 *   Remote Past: -edoh-v'i    (Stem III + remote past suffix -v'i)
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToBeSomewhereRemotePastSpec extends VerbBaseSpec {

    static final String VERB = "to be somewhere"
    static final String TENSE = "REMOTE_PAST"
    static final String SOURCE_PAGE = "pp.19-20"

    // Affix composition as printed:
    static final String STEM = "-edo-h-"         // Stem III
    static final String TENSE_FORM = "-edoh-v'i"  // Remote Past (Stem III + -v'i)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [object: 'SG3IN', pronoun: "First Singular",         romanized: "gedojvi",   syllabary: "ᎨᏙᎲᎢ",  english: "I was somewhere"],
            [object: 'SG3IN', pronoun: "Second Singular",        romanized: "hedojvi",   syllabary: "ᎮᏙᎲᎢ",  english: "You were somewhere"],
            [object: 'SG3IN', pronoun: "Third Singular",         romanized: "edojvi",    syllabary: "ᎡᏙᎲᎢ",  english: "He/she/it was somewhere"],
            [object: 'PL3AN', pronoun: "Second Dual",            romanized: "sdedojvi",  syllabary: "ᏍᏕᏙᎲᎢ", english: "You (two) were somewhere"],
            [object: 'PL3AN', pronoun: "Second Plural",          romanized: "itsedojvi", syllabary: "ᎢᏤᏙᎲᎢ", english: "You (more than two) were somewhere"],
            [object: 'PL3AN', pronoun: "First Dual Inclusive",   romanized: "inedojvi",  syllabary: "ᎢᏁᏙᎲᎢ", english: "We (you and I) were somewhere"],
            [object: 'PL3AN', pronoun: "First Dual Exclusive",   romanized: "osdedojvi", syllabary: "ᎣᏍᏕᏙᎲᎢ", english: "We (another and I) were somewhere"],
            [object: 'PL3AN', pronoun: "First Plural Exclusive", romanized: "otsedojvi", syllabary: "ᎣᏤᏙᎲᎢ", english: "We (others and I) were somewhere"],
            [object: 'PL3AN', pronoun: "First Plural Inclusive", romanized: "idedojvi",  syllabary: "ᎢᏕᏙᎲᎢ", english: "We (you and I and another or others) were somewhere"],
            [object: 'PL3AN', pronoun: "Third Plural",      romanized: "anedojvi",  syllabary: "ᎠᏁᏙᎲᎢ", english: "They were somewhere"],
    ]

    /**
     * Hook for the conjugation-engine comparison (to be wired in later).
     * Today it echoes the verb-book form; replace the body with a call into
     * the conjugation engine when the engine-vs-verb-book refinement begins.
     */
    Map conjugate(String pronoun) {
        def row = VERB_BOOK.find { it.pronoun == pronoun }
        // Harness check: retrieve engine output for this same pronoun/tense/verb
        def engineSyllabary = VerbBookEngineHarness.getEngineSyllabary(
            VERB, TENSE, row.english, [conjugations: VERB_BOOK]
        )
        
        return [romanized: row.romanized, syllabary: row.syllabary, engineSyllabary: engineSyllabary]
    }

    def "remote past form matches the verb book (#row.pronoun)"() {
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

    def "the verb book table is complete (ten pronoun rows)"() {
        expect:
        VERB_BOOK.size() == 10
    }
}
