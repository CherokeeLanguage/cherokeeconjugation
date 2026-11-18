package net.cherokeedictionary.verb.metadata

import net.cherokeedictionary.transliteration.SyllabaryUtil

/**
 * Data-driven per-lexeme flags (lexeme-flag generalization, 2026-11-18).
 *
 * The per-verb lexeme flags (glottalInitial, quvCoalescing, impersonal,
 * surfaceOverrides) used to live ONLY in test-spec details maps, registered
 * per-conjugation by VerbBaseSpec inside a VerbRegistry scope. A library
 * consumer of VerbConjugationFacade could not get them: the engine jar's
 * global seeds (VerbRegistryInitializer) carried none of them. This loader
 * closes that gap: src/main/resources/data/verbLexemes.json is keyed by
 * LEXEME NAME (unique per verb) and applied per-conjugation through the same
 * withVerbScope mechanism the specs use.
 *
 * WHY NAME-KEYED, NOT CITATION-KEYED: citation keys are NOT lexeme-unique.
 * Gahneha 'hold (flexible)' and Ganeha 'hold (long)' both print SG3 present
 * ᎦᏁᎭ (ganeha); seeding Ganeha's SG1 surfaceOverrides under that citation
 * globally would leak them into Gahneha's SG1 cells through the registry's
 * global fallback (scope consulted first, then the global seeds). The lexeme
 * name is the ONLY discriminator between such twins, so the consumer supplies
 * request.lexeme = "Ganeha" and the facade opens a scope for exactly that
 * lexeme -- identical isolation to the test harness. -- tio 18Nov26
 */
class VerbLexemeFlagLoader {

    private static final String RESOURCE = "/data/verbLexemes.json"

    /** name -> entry map, memoized; null when the resource is missing. -- tio 18Nov26 */
    private static Map<String, Map> lexemes

    /** The book's romanization artifacts ("agowtiha" for ᎠᎪᏩᏘᎭ) must be
     * repaired before transliteration. tio 18Nov26: logic HOISTED to
     * VerbInputNormalizer (single home; the conjugation-path input gate and
     * the test harness now share it) -- this delegate keeps the loader's
     * conversion behavior byte-identical. -- tio 18Nov26 */
    private static String normalizeBookRomanization(String latin) {
        return net.cherokeedictionary.conjugation.VerbInputNormalizer.normalizeBookRomanization(latin)
    }

    /** Roman (vrb/CED convention) -> syllabary; wired fixtures carry glyphs and
     * use the plain path. Delegates to VerbInputNormalizer.toSyll -- identical
     * behavior, single home. See DISCREPANCIES.md D9/D12. -- tio 18Nov26 */
    static String toSyll(String s) {
        return net.cherokeedictionary.conjugation.VerbInputNormalizer.toSyll(s)
    }

    private static Map<String, Map> load() {
        if (lexemes != null) { return lexemes }
        def stream = VerbLexemeFlagLoader.getResourceAsStream(RESOURCE)
        if (stream == null) {
            // Missing data stays visible: an empty registry would silently
            // drop every lexeme flag for library consumers. -- tio 18Nov26
            throw new IllegalStateException("Lexeme flag data not found on classpath: ${RESOURCE}")
        }
        def parsed = new groovy.json.JsonSlurper().parse(stream, "UTF-8")
        lexemes = parsed.lexemes as Map<String, Map>
        return lexemes
    }

    /** All lexeme names in the data file (diagnostics/meta-test). -- tio 18Nov26 */
    static List<String> getLexemeNames() {
        return new ArrayList(load().keySet())
    }

    /** The raw entry for a lexeme name, or null. -- tio 18Nov26 */
    static Map getEntry(String lexemeName) {
        return load()[lexemeName]
    }

    /**
     * Registers one lexeme's flags into the CURRENT registration context:
     * an open VerbRegistry scope (per-conjugation) if one is open, otherwise
     * the global collections. Citation and surface forms convert through
     * {@link #toSyll}. Safe to call repeatedly (registry adds are idempotent
     * for sets/maps). -- tio 18Nov26
     */
    static void apply(String lexemeName) {
        Map entry = load()[lexemeName]
        if (entry == null) { return }
        String citation = toSyll(entry.citation as String)
        if (entry.glottalInitial) {
            VerbRegistry.registerGlottalInitial(citation)
        }
        if (entry.quvCoalescing) {
            VerbRegistry.registerQuvCoalescing(citation)
        }
        if (entry.impersonal) {
            VerbRegistry.registerImpersonal(citation)
        }
        (entry.surfaceOverrides ?: []).each { o ->
            VerbRegistry.registerSubjectSurface(citation, o.tense as String, o.subject as String,
                    (o.obj ?: "NONE") as String, toSyll(o.form as String))
        }
    }
}
