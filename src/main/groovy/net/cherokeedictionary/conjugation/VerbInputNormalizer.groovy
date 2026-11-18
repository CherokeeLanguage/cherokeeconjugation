package net.cherokeedictionary.conjugation

import net.cherokeedictionary.transliteration.SyllabaryUtil

/**
 * Input-boundary normalization gate (2026-11-18, user decision: the dictionary
 * passes SYLLABARY only; roman input is tolerated but is not the primary
 * contract).
 *
 * Two entries:
 *   - {@link #normalizeRequestStem} -- the GATE on the conjugation path.
 *     Glyphs pass through byte-identical (the engine's native dialect --
 *     Stemmer/DefinitionLine and every VerbRegistry key are glyph strings).
 *     Roman (phonetic) input is converted: vowel-vowel glottal apostrophes
 *     are dropped (unwritten in the syllabary -- the Nani'a/A'i/D14 family),
 *     the book-romanization artifacts are repaired (ow->owa / hl->lo before
 *     consonants; Feeling writes agowtiha for ᎠᎪᏩᏘᎭ), then the CED-convention
 *     transliterator runs. Deliberately NOT normalized: d/t and g/k
 *     spirantization alternation, tone/length diacritics, uw-/u- fusion
 *     variance (D15, parked) -- all need round-trip probes + user rulings;
 *     they only matter for roman input, which the dictionary never sends.
 *   - {@link #toSyll} -- the roman-to-syllabary converter the test harness
 *     and VerbLexemeFlagLoader share (single home for the book-repair
 *     logic; behavior identical to the previous private copies).
 *
 * NOT touched by either entry: the specs (user ruling: specs are CED-canonical
 * and stay untouched; normalization belongs at the API boundary).
 * -- tio 18Nov26
 */
class VerbInputNormalizer {

    /** True when the string carries Cherokee syllabary glyphs. -- tio 18Nov26 */
    static boolean hasGlyph(String s) {
        return s != null && s.chars().any { it >= 0x13A0 && it <= 0x13F5 }
    }

    /**
     * The conjugation-path gate. Glyphs return as-is (trimmed); roman input
     * converts to CED-canonical syllabary. See class doc for what is
     * deliberately not normalized. -- tio 18Nov26
     */
    static String normalizeRequestStem(String input) {
        if (input == null) { return null }
        String s = input.trim()
        if (s.isEmpty()) { return s }
        if (hasGlyph(s)) { return s }
        // Glottal apostrophes are unwritten in the syllabary: between dual
        // vowels (nani'a / nania are both ᎾᏂᎠ; a'i == ai == ᎠᎢ) AND before
        // consonants (hi'luga -> hiluga -- the laryngeal has no glyph before
        // a consonant; the phonemic glottal-initial property is LEXEME DATA,
        // carried by the glottalInitial flag, not by the orthography -- this
        // matches the convention the specs have always applied when wiring
        // stems, e.g. AhiliSpec's ahiluga). -- tio 18Nov26
        s = s.replaceAll("(?i)'", '')
        return toSyll(s)
    }

    /**
     * The book's romanization writes the Ꮹ (wa) glyph as a bare "w" in the
     * gow- cluster ("agowtiha" for ᎠᎪᏩᏘᎭ) and ᏗᎸ-family clusters as "hl"
     * where the transliterator needs "lo" (hl otherwise collapses to tl).
     * Repaired here before conversion; identical to the rules that lived in
     * VerbBaseSpec (test) until hoisted. -- tio 18Nov26
     */
    static String normalizeBookRomanization(String latin) {
        return latin?.replaceAll("ow(?=[bcdfghjklmnprstz])", "owa")
                     .replaceAll("hl(?=[bcdfghjklmnprstz'])", "lo")
    }

    /**
     * Roman (vrb/CED convention) -> syllabary; glyph input uses the plain
     * path (wired fixtures). Mirrors the conversion the specs have always
     * applied; roman goes through the CED-convention variant. See
     * DISCREPANCIES.md D9/D12. -- tio 18Nov26
     */
    static String toSyll(String s) {
        if (!s) { return null }
        boolean glyphs = hasGlyph(s)
        return glyphs ?
            SyllabaryUtil.tsalagiToSyllabary(normalizeBookRomanization(s)) :
            SyllabaryUtil.tsalagiToSyllabaryCed(normalizeBookRomanization(s))
    }
}
