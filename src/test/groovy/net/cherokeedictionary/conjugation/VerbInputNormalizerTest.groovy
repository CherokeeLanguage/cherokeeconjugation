package net.cherokeedictionary.conjugation

import org.junit.Test

import static org.junit.Assert.assertEquals
import static org.junit.Assert.assertFalse
import static org.junit.Assert.assertNull
import static org.junit.Assert.assertTrue

/**
 * Tests for the conjugation-path input gate (VerbInputNormalizer, 2026-11-18).
 * The dictionary passes syllabary only -- glyphs must pass through
 * byte-identical; roman input converts to CED-canonical syllabary.
 * -- tio 18Nov26
 */
class VerbInputNormalizerTest {

    @Test
    void "glyph input passes through byte-identical"() {
        // The dictionary contract: syllabary in, untouched out (trimmed only).
        assertEquals("ᎦᏁᎭ", VerbInputNormalizer.normalizeRequestStem("ᎦᏁᎭ"))
        assertEquals("ᎦᏁᎭ", VerbInputNormalizer.normalizeRequestStem("  ᎦᏁᎭ "))
        assertEquals("ᏚᏅᏂᏢᎥᎢ", VerbInputNormalizer.normalizeRequestStem("ᏚᏅᏂᏢᎥᎢ"))
    }

    @Test
    void "roman input converts to CED-canonical syllabary"() {
        assertEquals("ᎦᏁᎭ", VerbInputNormalizer.normalizeRequestStem("ganeha"))
        assertEquals("ᎠᎪᏩᏘᎭ", VerbInputNormalizer.normalizeRequestStem("agowtiha"))
    }

    @Test
    void "glottal apostrophe between vowels is dropped (unwritten in syllabary)"() {
        // The Nani'a / A'i / D14 family: nani'a and nania are both ᎾᏂᎠ;
        // a'i == ai == ᎠᎢ.
        assertEquals("ᎾᏂᎠ", VerbInputNormalizer.normalizeRequestStem("nani'a"))
        assertEquals("ᎠᎢ", VerbInputNormalizer.normalizeRequestStem("a'i"))
        // Multiple dropped apostrophes: ji'i'luga -> jiiluga (ji-i-lu-ga)
        assertEquals("ᏥᎢᎷᎦ", VerbInputNormalizer.normalizeRequestStem("ji'i'luga"))
    }

    @Test
    void "apostrophe before a consonant is dropped too (laryngeal data lives in flags)"() {
        // hi'luga -> hiluga: the laryngeal has no glyph before a consonant;
        // the phonemic glottal-initial property is carried by the
        // glottalInitial lexeme flag (D14), not the orthography -- matching
        // the stem-wiring convention the specs have always applied.
        assertEquals(VerbInputNormalizer.toSyll("hiluga"),
                VerbInputNormalizer.normalizeRequestStem("hi'luga"))
    }

    @Test
    void "null and empty pass through"() {
        assertNull(VerbInputNormalizer.normalizeRequestStem(null))
        assertEquals("", VerbInputNormalizer.normalizeRequestStem("   "))
    }

    @Test
    void "hasGlyph detects the syllabary range"() {
        assertTrue(VerbInputNormalizer.hasGlyph("ᎦᏁᎭ"))
        assertFalse(VerbInputNormalizer.hasGlyph("ganeha"))
        assertFalse(VerbInputNormalizer.hasGlyph(null))
    }

    @Test
    void "toSyll keeps the shared conversion contract"() {
        // Same results the specs have always gotten (VerbBaseSpec/VerbLexemeFlagLoader
        // now delegate here): CED-convention roman and glyph inputs.
        assertEquals("ᎦᏁᎭ", VerbInputNormalizer.toSyll("ganeha"))
        assertEquals("ᎦᏁᎭ", VerbInputNormalizer.toSyll("ᎦᏁᎭ"))
        assertNull(VerbInputNormalizer.toSyll(null))
    }
}
