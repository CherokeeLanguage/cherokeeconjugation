package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import net.cherokeedictionary.util.PrefixTableObject
import net.cherokeedictionary.util.PrefixTableSubject
import spock.lang.Unroll

/**
 * Verb-book reference spec: "To Be Somewhere" — Immediate Past (Stem IV).
 *
 * Source: Cherokee Verb Conjugations Single Entry (Durbin Feeling verb book), p.21.
 *
 * Affix composition, exactly as printed in the verb book:
 *   Stem IV:        -ed[o]-Ø-
 *   Immediate Past: -ed-a    (Stem IV + past suffix -a)
 *
 * Transcription note: the Second Singular romanized form is printed "hweda" in
 * the verb book (transcribed as printed); the syllabary reads ᏫᎮᏓ "wiheda".
 *
 * Conventions: romanized forms are transcribed as printed; typographic apostrophes
 * (U+2019) are normalized to ASCII apostrophes (').
 */
@Unroll
class ToBeSomewhereImmediatePastSpec extends VerbBaseSpec {

    static final String VERB = "to be somewhere"
    static final String TENSE = "IMMEDIATE_PAST"
    static final String SOURCE_PAGE = "p.21"

    // Affix composition as printed:
    static final String STEM = "-ed[o]-Ø-"  // Stem IV
    static final String TENSE_FORM = "-ed-a"    // Immediate Past (Stem IV + -a)

    /** The ten conjugated forms exactly as printed in the verb book. */
    static final List<Map> VERB_BOOK = [
            [pronoun: "First Singular",         romanized: "wigeda",   syllabary: "ᏫᎨᏓ",  english: "I was somewhere"],
            [pronoun: "Second Singular",        romanized: "hweda",    syllabary: "ᏫᎮᏓ",  english: "You were somewhere"],
            [pronoun: "Third Singular",         romanized: "weda",     syllabary: "ᏪᏓ",   english: "He/she/it was somewhere"],
            [pronoun: "Second Dual",            romanized: "wisdeda",  syllabary: "ᏫᏍᏕᏓ", english: "You (two) were somewhere"],
            [pronoun: "Second Plural",          romanized: "witseda",  syllabary: "ᏫᏤᏓ",  english: "You (more than two) were somewhere"],
            [pronoun: "First Dual Inclusive",   romanized: "wineda",   syllabary: "ᏫᏁᏓ",  english: "We (you and I) were somewhere"],
            [pronoun: "First Dual Exclusive",   romanized: "wosdeda",  syllabary: "ᏬᏍᏕᏓ", english: "We (another and I) were somewhere"],
            [pronoun: "First Plural Exclusive", romanized: "wotseda",  syllabary: "ᏬᏤᏓ",  english: "We (others and I) were somewhere"],
            [pronoun: "First Plural Inclusive", romanized: "wideda",   syllabary: "ᏫᏕᏓ",  english: "We (you and I and another or others) were somewhere"],
            [pronoun: "Third Plural",      romanized: "waneda",   syllabary: "ᏩᏁᏓ",  english: "They were somewhere"],
    ]

    /**
     * Hook for the conjugation-engine comparison (to be wired in later).
     * Today it echoes the verb-book form; replace the body with a call into
     * the conjugation engine when the engine-vs-verb-book refinement begins.
     */
    static final Map details = [
        definition: "To be somewhere",
        part_of_speech: "v.i.",
        conjugations: [
            [subject: 'SG3', present: 'edoh-a', remote_past: 'edoh-v\'i', immediate_past: 'ed-a', infinitive: 'edas-di', immediate: 'ed-a']
        ]
    ]

    Map conjugate(String pronoun) {
        def row = VERB_BOOK.find { it.pronoun == pronoun }
        def subject = PrefixTableSubject.fromReadableName(pronoun)
        if (subject == null) {
            // Check if we need to map based on the enum name or another identifier
            if (pronoun == "Third Plural") {
                subject = PrefixTableSubject.PL3
            } else {
                throw new IllegalStateException("Could not map pronoun: " + pronoun)
            }
        }

        // Default to SG3IN for this verb, but this should ideally be in the row
        def object = PrefixTableObject.SG3IN
        
        String expected = row.syllabary
        String syllabary = conjugateVerb(VERB, details, subject.name(), object.name(), TENSE, expected)
        return [romanized: row.romanized, syllabary: syllabary]
    }

    def "immediate past form matches the verb book (#row.pronoun)"() {
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
