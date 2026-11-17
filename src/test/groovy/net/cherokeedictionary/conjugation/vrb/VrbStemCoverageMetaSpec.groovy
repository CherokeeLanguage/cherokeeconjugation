// tio 17Nov26: vrb package equivalent of the wired VerbBookStemCoverageMetaSpec
// (grammarGuide package). Enumerates EVERY vrb spec's details map via
// reflection and asserts that each verb/tense/subject the yaml data can
// attempt composes a REAL word through the production path -- the finish-line
// coverage gate for "all of the verbs". Two failure modes, mirroring the
// wired meta-test:
//
// 1. "composes a full word" -- ENGINE failure (Stemmer router gap, missing
//    compound prefix, transliteration residue). Must be fixed in main code.
// 2. "known data gaps" -- the yaml cites no SG3 stem for the tense (blank,
//    ----, junk). Tracked in EXPECTED_GAPS: closing one means deleting its
//    entry, and any NEW gap fails loudly.
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec
import spock.lang.Unroll

@Unroll
class VrbStemCoverageMetaSpec extends VerbBaseSpec {

    /**
     * Tenses the gate exercises. The five yaml-paradigm tenses plus
     * IMMEDIATE_COMMAND -- the vrb details carry imperative citations for
     * nearly every verb, and until 2026-11-17 they were never exercised.
     * -- tio 17Nov26
     */
    static final List<String> TENSES = [
        "PRESENT",
        "HABITUAL",
        "REMOTE_PAST",
        "FUTURE_COMMAND",
        "INFINITIVE",
        "IMMEDIATE_COMMAND",
    ]

    /** Which SG3 row key each tense composes from. */
    static final Map<String, String> TENSE_STEM_KEY = [
        "PRESENT"           : "present",
        "HABITUAL"          : "habitual",
        "REMOTE_PAST"       : "remote_past",
        "FUTURE_COMMAND"    : "remote_past",
        "INFINITIVE"        : "infinitive",
        "IMMEDIATE_COMMAND" : "imperative",
    ]

    /**
     * Subjects with cited rows in the vrb data. SG2/PL3/PL1INCL were never
     * meta-tested before 2026-11-17 -- the composition paths they stress
     * (SG2 hi-/tsa- allomorphy, PL3 un-/ani-, PL1INCL id-/igi-) are exactly
     * what a full-inventory gate must cover. -- tio 17Nov26
     */
    static final List<String> SUBJECTS = ["SG3", "SG1", "SG2", "PL3", "PL1INCL"]

    /** Specs without a `details` map (harness-internal or custom-stemmer specs). */
    static final List<String> SKIPPED_SPECS = [
        "PluralObjectSpec",   // drives Conjugate directly with its own Stemmer
        "RootBreakdown",      // manual factory probe, not a verb spec
        "VrbStemCoverageMetaSpec",
    ]

    /**
     * Discovers every *Spec class in this package and reads its static
     * `details` map. File-list based (tests run from the repo root) so no
     * classpath scanner dependency is needed. Memoized -- the spec count is
     * ~400 and the composition table is ~4,000 rows. -- tio 17Nov26
     */
    static List<Map> _discovered = null

    static List<Map> discoverVrbSpecs() {
        if (_discovered != null) return _discovered
        def dir = new File("src/test/groovy/net/cherokeedictionary/conjugation/vrb")
        def specs = []
        dir.listFiles().findAll { it.name.endsWith("Spec.groovy") && !(it.name in SKIPPED_SPECS.collect { it + ".groovy" }) }.sort { it.name }.each { File f ->
            String className = "net.cherokeedictionary.conjugation.vrb." + f.name.replaceAll(/\.groovy$/, "")
            try {
                Class clazz = Class.forName(className)
                def field = clazz.getDeclaredField("details")
                field.setAccessible(true)
                def details = field.get(null)
                if (details instanceof Map) {
                    specs << [name: f.name.replaceAll(/Spec\.groovy$/, ""), details: details]
                }
            } catch (NoSuchFieldException e) {
                // spec without a details map -- skipped deliberately
            }
        }
        _discovered = specs
        return specs
    }

    /**
     * Which SG3 row key each tense composes from. The vrb details never carry a
     * `future_command` key: per the D1 convention the yaml's FUTURE_COMMAND cells
     * assert the yaml's own REMOTE_PAST row, so FUTURE_COMMAND composes from
     * remote_past (mirrors TENSE_STEM_KEY in the wired meta-test).
     * (The map itself lives above, beside the TENSES list.) -- tio 17Nov26
     */
    /** True when the SG3 row cites a usable stem for the tense. */
    static boolean hasStemRow(Map details, String tense) {
        def key = TENSE_STEM_KEY[tense]
        def sg3 = details.conjugations.find { it.subject == "SG3" }
        def val = sg3?.get(key)
        if (!(val instanceof String)) return false
        def cleaned = val.split(",")[0].trim()  // dual citations "x, y" -> first
        return cleaned && cleaned != "----" && cleaned != "x" && cleaned != "X" && cleaned != "/" && cleaned != "X]"
    }

    /** [verbName, tense, subject] rows the data can attempt. */
    static List<List> compositionRows() {
        def rows = []
        discoverVrbSpecs().each { spec ->
            TENSES.each { String tense ->
                // tio 17Nov26: impersonal verbs' imperatives are IMPERMISSIBLE (a
                // lexical property, not a gap) -- never attempted, asserted by
                // the dedicated sentinel test below.
                if (tense == "IMMEDIATE_COMMAND" && spec.details.impersonal) return
                if (hasStemRow(spec.details, tense)) {
                    SUBJECTS.each { String subj ->
                        def row = spec.details.conjugations.find { it.subject == subj }
                        // the subject row must cite at least a present form (the
                        // composition derives the rest from the SG3 stems)
                        if (row?.present) rows << [spec.name, tense, subj]
                    }
                }
            }
        }
        return rows
    }

    /**
     * The verb|tense pairs whose SG3 row cites no usable stem. IMPERSONAL verbs'
     * missing imperatives are deliberately NOT here -- they are impermissible
     * forms (a lexical property), asserted by the sentinel test below. -- tio 17Nov26
     */
    static List<String> actualGaps() {
        def gaps = []
        discoverVrbSpecs().each { spec ->
            TENSES.each { String tense ->
                if (tense == "IMMEDIATE_COMMAND" && spec.details.impersonal) return
                if (!hasStemRow(spec.details, tense)) {
                    gaps << "${spec.name}|${tense}"
                }
            }
        }
        return gaps.sort()
    }

    /**
     * The impersonal verb cohort (user verdict 2026-11-17: "you cannot tell the
     * sun or moon to shine" -- the imperative is impermissible, not unattested).
     * The book's boxes for these verbs have no imperative column BECAUSE the form
     * does not exist linguistically. Conjugate returns the NO_IMPERATIVE sentinel
     * (see VerbRegistry.isImpersonal / Conjugate). Each entry cites the book
     * location of the (column-less) box. -- tio 17Nov26
     */
    static final List<String> IMPERSONAL_VERBS = [
        "Adaleniha (It Is Beginning, p.76)",
        "Agaliha (Moon/Sun Shining, p.77)",
        "Aganawosga (Warming, p.77)",
        "Agasga (Growing, p.23)",
        "Ahyahtvhvsga (Frosting, p.11)",
        "Ahyvdagwaloa (Thundering, p.78)",
        "Alidliha (Boiling, p.39)",
        "Alsgwadia (Ending, p.76)",
        "Anagaliha (Lightning, p.78)",
        "Asvga (Smelling, p.75)",
        "Galiga (Burning, p.75)",
        "Ganesoysga (Hailing, p.78)",
        "Gutiha (Snowing, p.78)",
        "Nigalstanvsga (Happening, p.75)",
        "Uhyvdla (Cold, p.77)",
        "Ulogila (Cloudy, p.78)",
        "Ahliilidoha (Taking Time, p.76 -- no imperative on purpose, user verdict 2026-11-17)",
    ]

    def "impersonal verbs refuse the imperative with the NO_IMPERATIVE sentinel (#verb)"() {
        given: "the spec's details with details.impersonal set"
        Map details = discoverVrbSpecs().find { it.name == verb }.details

        when: "we request the imperative through the production path"
        String result = conjugateVerb(verb, details, "SG3", "", "IMMEDIATE_COMMAND", null)

        then: "the engine refuses -- no imperative exists to compose"
        result == "NO_IMPERATIVE"

        where:
        verb << IMPERSONAL_VERBS.collect { it.split(/ \(/)[0] }
    }

    def "#verb #tense #subj composes a full word"() {
        given: "the spec's details verbatim, through the production harness"
        Map details = discoverVrbSpecs().find { it.name == verb }.details

        when: "we conjugate through the production path"
        String result = conjugateVerb(verb, details, subj, "", tense, null)

        then: "the engine emitted a real word: non-blank, no placeholder residue"
        result != null
        def trimmed = result.trim()
        trimmed.length() > 0
        !trimmed.toUpperCase().contains("MISSING")
        !trimmed.contains("not a valid letter")

        where:
        [verb, tense, subj] << compositionRows()
    }

    def "vrb stem-coverage gaps match EXPECTED_GAPS exactly"() {
        expect: "every verb|tense the yaml cannot attempt is a tracked data gap"
        actualGaps() == EXPECTED_GAPS.sort()
    }

    /**
     * Data gaps as of 2026-11-17: SG3 rows citing nothing usable (----/blank
     * after the junk-cell cleanup). Each entry resolves by transcribing the
     * 2012 book's SG3 stem into the spec and DELETING the entry. Verbs whose
     * SG3 row is ENTIRELY junk (Nania -- absent from the book) cite all five
     * tenses here.
     */
    static final List<String> EXPECTED_GAPS = [
        // tio 17Nov26: populated from the first sweep. INFINITIVE entries = the book
        // prints x / has no infinitive column (D15 unattested-row cleanups);
        // REMOTE_PAST/FUTURE_COMMAND entries = the book prints x in the remote column
        // (Eha, Ganhga, Gahliha, Gadoga, Ganela, Ahileha, Atihneha, Nania-junk).
        "Ahileha|FUTURE_COMMAND",
        "Ahileha|REMOTE_PAST",
        "Ai|INFINITIVE",
        "Ajavsga|INFINITIVE",
        "Anagaliha|INFINITIVE",
        "Anidonaa|INFINITIVE",
        "Anina|INFINITIVE",
        "Atihneha|FUTURE_COMMAND",
        "Atihneha|REMOTE_PAST",
        "Eha|FUTURE_COMMAND",
        "Eha|INFINITIVE",
        "Eha|REMOTE_PAST",
        "Gadoga|FUTURE_COMMAND",
        "Gadoga|INFINITIVE",
        "Gadoga|REMOTE_PAST",
        "Gahliha|FUTURE_COMMAND",
        "Gahliha|REMOTE_PAST",
        "Galiga|INFINITIVE",
        "Ganatlaa|INFINITIVE",
        "Ganela|FUTURE_COMMAND",
        "Ganela|INFINITIVE",
        "Ganela|REMOTE_PAST",
        "Ganhga|FUTURE_COMMAND",
        "Ganhga|INFINITIVE",
        "Ganhga|REMOTE_PAST",
        "Ganohili|INFINITIVE",
        "Ganesoysga|INFINITIVE",
        "Gata|INFINITIVE",
        "Nania|FUTURE_COMMAND",
        "Nania|INFINITIVE",
        "Nania|REMOTE_PAST",
        "Udvnvisdi|INFINITIVE",
        "Uhnalvha|INFINITIVE",
        "Uhniha|INFINITIVE",
        "Ujaa|INFINITIVE",
        "Ukvhada|INFINITIVE",
        "Ulogila|INFINITIVE",
        "Ulsihga|INFINITIVE",
        "Unaa|INFINITIVE",
        "Uneguja|INFINITIVE",
        "Unhta|INFINITIVE",
        "Uwohiyuha|INFINITIVE",
        "Uwotla|INFINITIVE",
        "Wakti|INFINITIVE",
        // tio 17Nov26 (user-adjudicated): IMMEDIATE_COMMAND gaps, classified against
        // the 2012 book. The impersonal cohort (weather/nature + Ahliilidoha, whose
        // imperative is absent ON PURPOSE) is NOT here -- those are impermissible
        // (details.impersonal), asserted by the NO_IMPERATIVE sentinel test. Remaining:
        //  - Atihneha/Ahileha/Ai: the book prints x in the imperative column (correct --
        //    no attested form);
        //  - Ahili: the book ATTESTS the imperative (ji'i'luga / hihi'luga / ahi'luga /
        //    anihi'luga / idihi'luga, p.10) but CED marks it empty (-----) -- the BOOK
        //    has the value while CED does not, so a CED-derived parse-back citation
        //    cannot be built;
        //  - Anidonaa: the book footnote governs the form (VRB pp.18, Gadoga box):
        //    /Danidoga/ if only two are standing, /anidona/ if three or more -- the
        //    imperative belongs to the two-vs-3+ alternant pair, not a single stem;
        //  - Anina: same footnote pattern (VRB pp.18, Uwotla box): /Dunotla/ if only
        //    two are sitting, /ani'na/ if three or more.
        "Ahileha|IMMEDIATE_COMMAND",
        "Ahili|IMMEDIATE_COMMAND",
        "Ai|IMMEDIATE_COMMAND",
        "Anidonaa|IMMEDIATE_COMMAND",
        "Anina|IMMEDIATE_COMMAND",
        "Atihneha|IMMEDIATE_COMMAND",
    ]
}
