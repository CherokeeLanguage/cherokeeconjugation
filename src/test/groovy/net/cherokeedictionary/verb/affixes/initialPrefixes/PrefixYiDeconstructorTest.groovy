package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.*

/**
 * Unit tests for Yi prefix deconstruction
 */
class PrefixYiDeconstructorTest {

    @Test
    void testBasicYiPrefix() {
        PrefixYi yi = new PrefixYi()
        
        // Test basic yi- extraction
        def result = yi.deconstructFromSyllabary("ᏱᎠᏬᏂ", new Verb())
        
        assertTrue(result.prefixRemoved, "Should extract yi-")
        assertEquals("ᎠᏬᏂ", result.result, "Remaining should be ᎠᏬᏂ")
        assertEquals("Ᏹ", result.detectedPrefix, "Detected prefix should be Ᏹ")
    }
    
    @Test
    void testYiFusedPattern() {
        PrefixYi yi = new PrefixYi()
        Verb verb = new Verb()
        verb.pronounReflexiveRoot = "ᎪᏩᏘ"
        
        // Test fused pattern - yi followed by long root-like sequence
        def result = yi.deconstructFromSyllabary("ᏱᎪᏩᏘᎭ", verb)
        
        assertFalse(result.prefixRemoved, "Should not extract when fused")
        assertEquals("ᏱᎪᏩᏘᎭ", result.result, "Word should remain unchanged")
    }
    
    @Test
    void testNoYiPrefix() {
        PrefixYi yi = new PrefixYi()
        
        // Word without yi- prefix
        def result = yi.deconstructFromSyllabary("ᎠᏬᏂ", new Verb())
        
        assertFalse(result.prefixRemoved, "Should not remove anything")
        assertEquals("ᎠᏬᏂ", result.result, "Word should remain unchanged")
    }
    
    @Test
    void testEmptyInput() {
        PrefixYi yi = new PrefixYi()
        
        def result = yi.deconstructFromSyllabary("", new Verb())
        
        assertFalse(result.prefixRemoved)
        assertEquals("", result.result)
    }
}
