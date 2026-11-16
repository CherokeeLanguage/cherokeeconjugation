package net.cherokeedictionary.grammarGuide

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

/**
 * Meta-test: enumerates verb-book fixtures whose stems cannot be composed by
 * the engine, before they are wired as individual To*Spec tables.
 *
 * Two orthogonal failure modes, asserted by two separate methods:
 *
 * 1. "composes a full word" -- a genuine ENGINE failure. The fixture supplies
 *    the stem for the tense but the engine cannot route/compose it (Stemmer
 *    normalization gap, missing compound prefix entry, bad allomorphy). These
 *    must be fixed in main code and this method stays green.
 *
 * 2. "known gaps" -- a DATA failure. The fixture cites no SG3 stem row for
 *    the tense (e.g. "to have (a living being)" cites only present rows, so
 *    habitual/remote-past/infinitive/immediate-past cannot be attempted until
 *    the book's rows are transcribed). These are tracked in EXPECTED_GAPS:
 *    fixing a fixture means deleting its entry here, and any NEW gap shows up
 *    as a failure pointing at the exact verb+tense.
 *
 * The fixture-cited SG3 present form is printed in each test name so a failure
 * immediately shows the citation the engine choked on.
 */
@Unroll
class VerbBookStemCoverageMetaSpec extends VerbBaseSpec {

    /** Tense strings used by the wired cherokeeVerbConjugation To*Spec classes. */
    static final List<String> TENSES = [
        "PRESENT",
        "PRESENT_HABITUAL",
        "REMOTE_PAST",
        "FUTURE",
        "FUTURE_EXPECTED",
        "INFINITIVE",
        "IMMEDIATE_PAST",
        "IMMEDIATE_IMPERATIVE_VOLATIVE",
        "FUTURE_IMPERATIVE_VOLATIVE",
    ]

    /**
     * Which SG3 fixture row key each tense composes from. The engine derives
     * FUTURE / FUTURE_EXPECTED / both imperative-volative tenses from the
     * present stem (VerbTenseHolder completive/immediate fallbacks), so they
     * only require `present`; the other four need their dedicated row.
     */
    static final Map<String, String> TENSE_STEM_KEY = [
        "PRESENT"                      : "present",
        "PRESENT_HABITUAL"             : "habitual",
        "REMOTE_PAST"                  : "remote_past",
        "FUTURE"                       : "present",
        "FUTURE_EXPECTED"              : "present",
        "INFINITIVE"                   : "infinitive",
        "IMMEDIATE_PAST"               : "immediate_past",
        "IMMEDIATE_IMPERATIVE_VOLATIVE": "present",
        "FUTURE_IMPERATIVE_VOLATIVE"   : "present",
    ]

    /**
     * Fixtures citing no SG3 row (or a blank row) for a tense the wired specs
     * exercise. Data gaps, not engine bugs -- each entry is resolved by
     * transcribing the book's SG3 rows into VerbBookFixtures and then
     * DELETING the entry from this list.
     */
    /**
     * Fixtures citing no SG3 row (or a blank row) for a tense the wired specs
     * exercise. Data gaps, not engine bugs. tio 16Nov26: EMPTY -- every
     * fixture now cites all nine tense stems. The animate-have Stem IV was
     * closed by the book's own sibling pattern (Stem IV = Stem III surface on
     * all three have-something pages), since the "To Have (a living being)"
     * page (pp.42-43) prints only Stem I. When adding a NEW fixture, either
     * cite all nine tense rows or add a justified verb|tense entry here.
     */
    static final List<String> EXPECTED_GAPS = []

    static boolean hasStemRow(Map fixture, String tense) {
        def sg3 = fixture.conjugations.find { it.subject == "SG3" }
        def key = TENSE_STEM_KEY[tense]
        return sg3 && sg3[key] && sg3[key].trim()
    }

    static String gapKey(String verbName, String tense) {
        return "${verbName}|${tense}"
    }

    /** [verbName, tense, subject, object, citedForm] rows for the composition test. */
    static List<List> compositionRows() {
        def rows = []
        VerbBookFixtures.FIXTURES.each { String verbName, Map fixture ->
            def sg3 = fixture.conjugations.find { it.subject == "SG3" }
            def sg1 = fixture.conjugations.find { it.subject == "SG1" }
            def obj = fixture.objectClass ?: "SG3IN"

            TENSES.each { String tense ->
                if (hasStemRow(fixture, tense)) {
                    rows << [verbName, tense, "SG3", obj, sg3.present ?: "<no sg3 row>"]
                    if (sg1?.present) {
                        rows << [verbName, tense, "SG1", obj, sg1.present]
                    }
                }
            }
        }
        return rows
    }

    /** The verb|tense pairs where the fixture cites no SG3 stem for the tense. */
    static List<String> actualGaps() {
        def gaps = []
        VerbBookFixtures.FIXTURES.each { String verbName, Map fixture ->
            TENSES.each { String tense ->
                if (!hasStemRow(fixture, tense)) {
                    gaps << gapKey(verbName, tense)
                }
            }
        }
        return gaps.sort()
    }

    def "#verb #tense #subj/#obj composes a full word (cited: #cited)"() {
        given: "the fixture verbatim -- same details the wired To*Specs resolve through the harness"
        Map details = VerbBookFixtures.FIXTURES[verb]

        when: "we conjugate through the production path"
        String result = conjugateVerb(verb, details, subj, obj, tense, null)

        then: "the engine emitted a real word: non-blank, no MISSING_STEM placeholder"
        result != null
        def trimmed = result.trim()
        trimmed.length() > 0
        !trimmed.toUpperCase().contains("MISSING")
        // NB: internal spaces are legal -- the book prints compound/negative
        // two-word forms (e.g. ᎡᎵᏊᏍ ᏱᎨᏅᏒᎢ), so whitespace is NOT a failure.
        // The engine pads blank results with spaces (Conjugate.conjugate:
        // "       ") and leaves wholeWord null when the compound prefix is
        // missing; both are caught by the assertions above.

        where:
        [verb, tense, subj, obj, cited] << compositionRows()
    }

    def "fixture stem-coverage gaps match EXPECTED_GAPS exactly"() {
        expect: "every tense the fixture cannot attempt is a tracked data gap"
        actualGaps() == EXPECTED_GAPS.sort()
    }
}
