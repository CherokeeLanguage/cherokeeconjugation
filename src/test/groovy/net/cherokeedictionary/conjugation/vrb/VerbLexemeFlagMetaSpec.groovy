// tio 18Nov26: meta-test for the data-driven lexeme flags (lexeme-flag
// generalization). Keeps src/main/resources/data/verbLexemes.json and the
// spec details maps in sync (GAP.md convention: documentation and the
// meta-test must agree). Three assertions:
//
// 1. EVERY spec that declares a lexeme flag (glottalInitial / quvCoalescing /
//    impersonal / surfaceOverrides) has a same-name data entry with matching
//    citation, matching boolean flags, and an identical surfaceOverrides set.
// 2. EVERY data entry is consumed by a same-name spec -- no orphan entries
//    (the data file must never drift ahead of the specs silently).
// 3. The library-consumer path works and is ISOLATED: request.lexeme applies
//    the lexeme's flags through the facade's per-conjugation scope, and the
//    citation-sharing twins (Gahneha/Ganeha, both ᎦᏁᎭ) conjugate their own
//    SG1 surfaces regardless of order.
package net.cherokeedictionary.conjugation.vrb

import net.cherokeedictionary.conjugation.VerbBaseSpec
import net.cherokeedictionary.conjugation.ConjugationRequest
import net.cherokeedictionary.conjugation.VerbConjugationFacade
import net.cherokeedictionary.verb.metadata.VerbLexemeFlagLoader
import net.cherokeedictionary.verb.metadata.VerbRegistry
import spock.lang.Unroll

@Unroll
class VerbLexemeFlagMetaSpec extends VerbBaseSpec {

    /** Flag keys a spec may declare and the data file may carry. -- tio 18Nov26 */
    static final List<String> FLAG_KEYS = ["glottalInitial", "quvCoalescing", "impersonal"]

    /** Specs declaring any lexeme flag, discovered like VrbStemCoverageMetaSpec. -- tio 18Nov26 */
    static List<Map> discoverFlaggedSpecs() {
        return VrbStemCoverageMetaSpec.discoverVrbSpecs().findAll { spec ->
            spec.details.glottalInitial || spec.details.quvCoalescing ||
                    spec.details.impersonal || spec.details.surfaceOverrides
        }
    }

    /** surfaceOverrides of a details map as a comparable tuple set. -- tio 18Nov26 */
    static Set<String> overrideTuples(Map details) {
        return (details.surfaceOverrides ?: []).collect { o ->
            "${o.tense}|${o.subject}|${o.obj ?: 'NONE'}|${o.form}".toString()
        } as Set
    }

    def "spec #verb declaring lexeme flags has a matching data entry"() {
        given: "the spec's SG3 citation and the data entry"
        Map details = spec.details
        String citation = details.conjugations.find { it.subject == "SG3" }?.present
        Map entry = VerbLexemeFlagLoader.getEntry(verb)
        List<Boolean> flagsAgree = FLAG_KEYS.collect { key ->
            (entry[key] ?: false) == (details[key] ?: false)
        }

        expect:
        entry != null
        // citation agrees (raw book-romanization; both sides convert through the
        // same toSyll at registration time)
        entry.citation == citation
        // boolean flags agree
        flagsAgree == [true, true, true]
        // surfaceOverrides agree exactly
        overrideTuples(entry) == overrideTuples(details)

        where:
        verb << discoverFlaggedSpecs()*.name
        spec << discoverFlaggedSpecs()
    }

    def "data entry #verb is consumed by a same-name spec (no orphans)"() {
        given: "the spec set discovered by name"
        def names = VrbStemCoverageMetaSpec.discoverVrbSpecs()*.name as Set

        expect:
        names.contains(verb)

        where:
        verb << VerbLexemeFlagLoader.lexemeNames.sort()
    }

    def "lexeme path conjugates the citation-sharing twins to their own SG1 surfaces"() {
        given: "full stem requests for Gahneha (flexible) and Ganeha (long) via request.lexeme"
        Map gahneha = VrbStemCoverageMetaSpec.discoverVrbSpecs().find { it.name == "Gahneha" }.details
        Map ganeha = VrbStemCoverageMetaSpec.discoverVrbSpecs().find { it.name == "Ganeha" }.details

        when: "each conjugates SG1 PRESENT through the production path with lexeme set"
        String gahnehaSurface = conjugateByLexeme("Gahneha", gahneha, "PRESENT")
        String ganehaSurface = conjugateByLexeme("Ganeha", ganeha, "PRESENT")
        // and in REVERSE order -- the pre-scope bug was order-dependent
        String ganehaSurface2 = conjugateByLexeme("Ganeha", ganeha, "HABITUAL")
        String gahnehaSurface2 = conjugateByLexeme("Gahneha", gahneha, "HABITUAL")

        then: "each lexeme surfaces its own SG1 row, in both orders"
        gahnehaSurface == VerbLexemeFlagLoader.toSyll("jineha")
        ganehaSurface == VerbLexemeFlagLoader.toSyll("jinea")
        gahnehaSurface2 == VerbLexemeFlagLoader.toSyll("jinehoi")
        ganehaSurface2 == VerbLexemeFlagLoader.toSyll("jineoi")
    }

    /** Conjugates one cell through the facade with request.lexeme set. -- tio 18Nov26 */
    private static String conjugateByLexeme(String lexemeName, Map details, String tense) {
        def sg3 = details.conjugations.find { it.subject == "SG3" }
        def sg1 = details.conjugations.find { it.subject == "SG1" }
        def request = new ConjugationRequest(
                subject: "SG1",
                object: "",
                verbTense: tense,
                partOfSpeech: details.part_of_speech ?: "v.i.",
                lexeme: lexemeName,
                present3rd: VerbLexemeFlagLoader.toSyll(sg3.present),
                habitual: VerbLexemeFlagLoader.toSyll(sg3.habitual),
                imperative: VerbLexemeFlagLoader.toSyll(sg3.imperative),
                infinitive: VerbLexemeFlagLoader.toSyll(sg3.infinitive),
                remotepast: VerbLexemeFlagLoader.toSyll(sg3.remote_past),
                present1st: VerbLexemeFlagLoader.toSyll(sg1.present)
        )
        return new VerbConjugationFacade().conjugate(request).wholeWord
    }

    def "lexeme #verb registers its flags into the caller's scope"() {
        when: "flags are applied inside a fresh scope (no global seeding)"
        Map entry = VerbLexemeFlagLoader.getEntry(verb)
        String citation = VerbLexemeFlagLoader.toSyll(entry.citation)
        Map<String, Object> result = VerbRegistry.withVerbScope {
            VerbLexemeFlagLoader.apply(verb)
            List<String> surfaced = (entry.surfaceOverrides ?: []).collect { o ->
                VerbRegistry.getSubjectSurface(citation, o.tense as String, o.subject as String,
                        (o.obj ?: "NONE") as String)
            }
            List<String> expected = (entry.surfaceOverrides ?: []).collect { o ->
                VerbLexemeFlagLoader.toSyll(o.form as String)
            }
            [
                glottalOk    : entry.glottalInitial ? VerbRegistry.isGlottalInitial(citation) : true,
                coalescingOk : entry.quvCoalescing ? VerbRegistry.isQuvCoalescing(citation) : true,
                impersonalOk : entry.impersonal ? VerbRegistry.isImpersonal(citation) : true,
                surfaced     : surfaced,
                expected     : expected,
            ]
        }

        then: "every declared flag answers true in-scope and every override surfaces"
        result.glottalOk
        result.coalescingOk
        result.impersonalOk
        result.surfaced == result.expected

        where:
        verb << VerbLexemeFlagLoader.lexemeNames.sort()
    }
}
