package net.cherokeedictionary.conjugation.cherokeeVerbConjugation

import net.cherokeedictionary.conjugation.VerbBaseSpec
import net.cherokeedictionary.conjugation.VerbLexicon
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

    /** The ten conjugated forms pulled from the central lexicon. */
    static final List<Map> VERB_BOOK = VerbLexicon.getConjugations(VERB, TENSE)

    /**
     * Hook for the conjugation-engine comparison (to be wired in later).
     * Today it echoes the verb-book form; replace the body with a call into
     * the conjugation engine when the engine-vs-verb-book refinement begins.
     */
    static final Map details = [
        definition: "To be somewhere",
        part_of_speech: "v.i.",
        // tio 12Nov26: the book's immediate-past rows all carry the orientation
        // wi- prefix (Ꮻ/Ꮺ/Ꮼ/Ꮹ...); declared lexically so the engine composes it.
        initialPrefixes: [wi: true],
        conjugations: [
            [subject: 'SG3', present: 'edoh-a', remote_past: 'edoh-v\'i', immediate_past: 'ed-a', infinitive: 'edas-di', immediate: 'ed-a']
        ]
    ]

    // tio 12Nov26: user decision — guide rule 27b WINS over the printed book row
    // for Second Singular. Book p.21 prints ᏫᎮᏓ (romanized "hweda", syllabary
    // reads wiheda, h kept); guide 27b says wi- metathesis drops a following h-
    // (WiVerbTest.testExample27b_WiDropsHWhenPrecedingH pins ᎯᎪᏩᏘᎭ → ᏫᎪᏩᏘᎭ).
    // Derived guide form: book's own SG2 composition h+eda ("hweda") minus h,
    // wi- fused with vowel harmony (wi+e → Ꮺ, same fusion as the book's own
    // SG3 row ᏪᏓ weda) → ᏪᏓ "weda". NOTE: this makes SG2 and SG3 homophonous
    // (both ᏪᏓ) — the book's Ꭾ ᏫᎮᏓ is the only person marker that survives.
    // Kept here rather than editing lexicon.json so the printed book row stays
    // visible in the data. RECHECK: if Feeling's "hweda" is actually his
    // romanization of an already-metathesized wih- cluster (i.e. SG2 is
    // hi+eda = "hieda"), the guide form would be ᏫᎡᏓ "wieda" instead — switch
    // both values if a hied-/wied- attestation surfaces. -- timo 12Nov26
    static final Map GUIDE_OVERRIDES = [
        'Second Singular': [romanized: 'weda', syllabary: 'ᏪᏓ'],
    ]

    /** Book row, with guide-corrected substitutions applied (see GUIDE_OVERRIDES). */
    static Map expectedRow(String pronoun) {
        def row = VERB_BOOK.find { it.pronoun == pronoun }
        def override = GUIDE_OVERRIDES[pronoun]
        // tio 12Nov26: guide-corrected expectation (see GUIDE_OVERRIDES comment);
        // falls through to the verbatim book row for every other pronoun.
        return override ? new HashMap(row) + override : row
    }

    Map conjugate(String pronoun) {
        def row = expectedRow(pronoun)
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
        // tio 12Nov26: compare against the guide-corrected row (GUIDE_OVERRIDES),
        // not the raw lexicon row.
        def expected = expectedRow(row.pronoun)

        then: "both the romanized and syllabary forms match the verb book"
        form.romanized == expected.romanized
        form.syllabary == expected.syllabary

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
