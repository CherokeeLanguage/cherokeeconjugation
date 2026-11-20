package net.cherokeedictionary.conjugation.attestation

/**
 * Attestation registry: word-form -> citation records from the two reference
 * corpora (Phase 1 of the reliability roadmap, user request 2026-11-20).
 *
 * The index is built ONCE by a one-off builder from:
 *   - docs/processed/bible.txt  (Cherokee New Testament, 132k verse lines)
 *   - docs/processed/corpus.txt (modern news/story corpus, 9.1k lines)
 * and shipped as data/attestationIndex.tsv (form \t source \t locations).
 * NT locations are "BOOK chapter:verse"; CORPUS locations are "corpus:id".
 * At most {@value #LOCATIONS_CAP} locations are kept per (form, source) --
 * common function words occur thousands of times; five citations answer
 * "is this attested and where".
 *
 * API is glyph-based (the engine's native dialect): composed or parsed
 * forms pass in byte-identical. Nothing here transforms input -- matching
 * is exact (v1); near-miss/spelling-variance mining is a later pass.
 * -- tio 20Nov26
 */
class AttestationRegistry {

    private static final int LOCATIONS_CAP = 5
    private static volatile Map<String, Map<String, List<String>>> index

    /** True when the exact glyph form occurs in either reference corpus. -- tio 20Nov26 */
    static boolean isAttested(String glyphForm) {
        return formCitations(glyphForm) != null
    }

    /**
     * Citations for one form: source ("NT" / "CORPUS") -> ordered location
     * list. Null when the form is unattested. Defensive copy. -- tio 20Nov26
     */
    static Map<String, List<String>> citations(String glyphForm) {
        Map<String, List<String>> bySource = formCitations(glyphForm)
        if (bySource == null) {
            return null
        }
        def copy = new LinkedHashMap<String, List<String>>()
        bySource.each { k, v -> copy[k] = new ArrayList<String>(v) }
        return copy
    }

    /** Distinct attested forms in the loaded index. -- tio 20Nov26 */
    static int formCount() {
        return load().size()
    }

    private static Map<String, List<String>> formCitations(String glyphForm) {
        if (glyphForm == null || glyphForm.trim().isEmpty()) {
            return null
        }
        return load()[glyphForm.trim()]
    }

    private static Map<String, Map<String, List<String>>> load() {
        Map<String, Map<String, List<String>>> loaded = index
        if (loaded == null) {
            synchronized (AttestationRegistry.class) {
                if (index == null) {
                    index = readIndex()
                }
                loaded = index
            }
        }
        return loaded
    }

    private static Map<String, Map<String, List<String>>> readIndex() {
        def result = [:]
        def url = AttestationRegistry.class.classLoader.getResource("data/attestationIndex.tsv")
        if (url == null) {
            return result
        }
        url.withReader("UTF-8") { r ->
            r.eachLine { line ->
                if (!line || line.startsWith("//")) { return }
                def f = line.split("\t", -1)
                if (f.size() < 3) { return }
                def locs = new ArrayList<String>()
                f[2].split(';').each { loc ->
                    if (loc) { locs << loc }
                }
                result.computeIfAbsent(f[0]) { new LinkedHashMap<String, List<String>>() }[f[1]] = locs
            }
        }
        return result
    }
}
