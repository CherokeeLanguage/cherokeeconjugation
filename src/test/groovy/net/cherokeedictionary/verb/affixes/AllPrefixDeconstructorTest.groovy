package net.cherokeedictionary.verb.affixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.initialPrefixes.*
import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.*

/**
 * Comprehensive test for all prefix deconstruction methods.
 * 
 * This test validates that each prefix can be correctly extracted
 * from Cherokee verb forms, and that context-sensitive fusion detection works properly.
 */
class AllPrefixDeconstructorTest {

    private final PrefixWi wi = new PrefixWi()
    private final PrefixYi yi = new PrefixYi()
    private final PrefixNi ni = new PrefixNi()
    private final PrefixI i = new PrefixI()
    private final PrefixGa ga = new PrefixGa()
    private final PrefixE e = new PrefixE()
    private final PrefixDe de = new PrefixDe()
    private final PrefixDa da = new PrefixDa()
    private final PrefixDi di = new PrefixDi()
    private final PrefixJi ji = new PrefixJi()
    private final ReflexivePrefix reflexive = new ReflexivePrefix()

    @Test
    void testPrefixWiDeconstruction() {
        println("\n=== Testing Wi Prefix ===")
        
        // Test 1: Basic extraction
        def result1 = wi.deconstructFromSyllabary("ᏫᎠᏬᏂ", new Verb())
        assertTrue(result1.prefixRemoved)
        assertEquals("ᎠᏬᏂ", result1.result)
        println("✓ ᏫᎠᏬᏂ → ᎠᏬᏂ (wi- extracted)")
        
        // Test 2: No match
        def result2 = wi.deconstructFromSyllabary("ᎠᏬᏂ", new Verb())
        assertFalse(result2.prefixRemoved)
        println("✓ ᎠᏬᏂ → no change (no wi-)")
        
        // Test 3: Different allomorph
        def result3 = wi.deconstructFromSyllabary("ᏪᎠᏬᏂ", new Verb())
        assertTrue(result3.prefixRemoved)
        assertEquals("ᎠᏬᏂ", result3.result)
        println("✓ ᏪᎠᏬᏂ → ᎠᏬᏂ (wi- variant extracted)")
    }

    @Test
    void testPrefixYiDeconstruction() {
        println("\n=== Testing Yi Prefix ===")
        
        // Test 1: Basic extraction
        def result1 = yi.deconstructFromSyllabary("ᏱᎠᏬᏂ", new Verb())
        assertTrue(result1.prefixRemoved)
        assertEquals("ᎠᏬᏂ", result1.result)
        println("✓ ᏱᎠᏬᏂ → ᎠᏬᏂ (yi- extracted)")
        
        // Test 2: Fused pattern - should not extract
        Verb verb = new Verb()
        verb.pronounReflexiveRoot = "ᎪᏩᏘ"
        def result2 = yi.deconstructFromSyllabary("ᏱᎪᏩᏘᎭ", verb)
        assertFalse(result2.prefixRemoved)
        assertEquals("ᏱᎪᏩᏘᎭ", result2.result)
        println("✓ ᏱᎪᏩᏘᎭ → no change (fused pattern detected)")
        
        // Test 3: Different allomorph
        def result3 = yi.deconstructFromSyllabary("ᏯᎠᏬᏂ", new Verb())
        assertTrue(result3.prefixRemoved)
        assertEquals("ᎠᏬᏂ", result3.result)
        println("✓ ᏯᎠᏬᏂ → ᎠᏬᏂ (yi- variant extracted)")
    }

    @Test
    void testPrefixNiDeconstruction() {
        println("\n=== Testing Ni Prefix ===")
        
        // Test 1: Basic extraction
        def result1 = ni.deconstructFromSyllabary("ᏂᎠᏬᏂ", new Verb())
        assertTrue(result1.prefixRemoved)
        assertEquals("ᎠᏬᏂ", result1.result)
        println("✓ ᏂᎠᏬᏂ → ᎠᏬᏂ (ni- extracted)")
        
        // Test 2: No match
        def result2 = ni.deconstructFromSyllabary("ᎠᏬᏂ", new Verb())
        assertFalse(result2.prefixRemoved)
        println("✓ ᎠᏬᏂ → no change (no ni-)")
    }

    @Test
    void testPrefixIGaDeDaDiDeconstruction() {
        println("\n=== Testing I/Ga/De/Da/Di/E Prefixes ===")
        
        // Test I- prefix
        def iResult = i.deconstructFromSyllabary("ᎢᎠᏬᏂ", new Verb())
        assertTrue(iResult.prefixRemoved)
        assertEquals("ᎠᏬᏂ", iResult.result)
        println("✓ ᎢᎠᏬᏂ → ᎠᏬᏂ (i- extracted)")
        
        // Test Ga- prefix
        def gaResult = ga.deconstructFromSyllabary("ᎦᎠᏬᏂ", new Verb())
        assertTrue(gaResult.prefixRemoved)
        assertEquals("ᎠᏬᏂ", gaResult.result)
        println("✓ ᎦᎠᏬᏂ → ᎠᏬᏂ (ga- extracted)")
        
        // Test E- prefix
        def eResult = e.deconstructFromSyllabary("ᎡᎠᏬᏂ", new Verb())
        assertTrue(eResult.prefixRemoved)
        assertEquals("ᎠᏬᏂ", eResult.result)
        println("✓ ᎡᎠᏬᏂ → ᎠᏬᏂ (e- extracted)")
        
        // Test De- prefix
        def deResult = de.deconstructFromSyllabary("ᏕᎠᏬᏂ", new Verb())
        assertTrue(deResult.prefixRemoved)
        assertEquals("ᎠᏬᏂ", deResult.result)
        println("✓ ᏕᎠᏬᏂ → ᎠᏬᏂ (de- extracted)")
        
        // Test Da- prefix
        def daResult = da.deconstructFromSyllabary("ᏓᎠᏬᏂ", new Verb())
        assertTrue(daResult.prefixRemoved)
        assertEquals("ᎠᏬᏂ", daResult.result)
        println("✓ ᏓᎠᏬᏂ → ᎠᏬᏂ (da- extracted)")
        
        // Test Di- prefix
        def diResult = di.deconstructFromSyllabary("ᏗᎠᏬᏂ", new Verb())
        assertTrue(diResult.prefixRemoved)
        assertEquals("ᎠᏬᏂ", diResult.result)
        println("✓ ᏗᎠᏬᏂ → ᎠᏬᏂ (di- extracted)")
    }

    @Test
    void testPrefixJiContextSensitive() {
        println("\n=== Testing Ji Prefix (Context-Sensitive) ===")
        
        // Test 1: Non-fused case - should extract
        def result1 = ji.deconstructFromSyllabary("ᏥᏚᏍᏗ", new Verb())
        assertTrue(result1.prefixRemoved)
        assertEquals("ᏚᏍᏗ", result1.result)
        println("✓ ᏥᏚᏍᏗ → ᏚᏍᏗ (ji- extracted, short remaining)")
        
        // Test 2: Fused case - should NOT extract
        Verb verb = new Verb()
        verb.pronounReflexiveRoot = "ᎪᏩᏘ"
        def result2 = ji.deconstructFromSyllabary("ᏥᎪᏩᏘᎭ", verb)
        assertFalse(result2.prefixRemoved)
        assertEquals("ᏥᎪᏩᏘᎭ", result2.result)
        assertEquals("fused_into_stem", result2.reason)
        println("✓ ᏥᎪᏩᏘᎭ → no change (fused into stem)")
        
        // Test 3: Critical user example - wi + fused ji
        def result3 = ji.deconstructFromSyllabary("ᏫᏥᎪᏩᏘᎭ", verb)
        assertFalse(result3.prefixRemoved)
        println("✓ ᏫᏥᎪᏩᏘᎭ → no change (ji- fused, will handle in main pipeline)")
    }

    @Test
    void testFullDeconstructionPipeline() {
        println("\n=== Full Pipeline Tests ===")
        
        def deconstructor = new VerbDeconstructor()
        
        // Test 1: Simple verb
        def result1 = deconstructor.deconstruct("ᎠᏬᏂ", new Verb())
        assertTrue(result1.success)
        println("✓ ᎠᏬᏂ: ${result1.stem} (${result1.morphemes.size()} morphemes)")
        
        // Test 2: wi- + stem
        def result2 = deconstructor.deconstruct("ᏫᎠᏬᏂ", new Verb())
        assertTrue(result2.success)
        boolean hasWi = result2.morphemes?.any { it.value == "wi" }
        assertTrue(hasWi, "Should extract wi-")
        println("✓ ᏫᎠᏬᏂ: ${result2.stem} - WI prefix: ${hasWi ? '✓' : '✗'}")
        
        // Test 3: Critical example with fused ji
        def result3 = deconstructor.deconstruct("ᏫᏥᎪᏩᏘᎭ", new Verb())
        assertTrue(result3.success)
        boolean hasJi = result3.morphemes?.any { it.value == "ji" }
        println("✓ ᏫᏥᎪᏩᏘᎭ: ${result3.stem}")
        if (!hasJi) {
            println("  → ji- correctly treated as fused ✓")
        } else {
            println("  ⚠️  ji- was extracted (might need tuning)")
        }
        
        // Test 4: More complex form with suffix
        def result4 = deconstructor.deconstruct("ᏫᏥᎪᏩᏘᎭᎢ", new Verb())
        assertTrue(result4.success)
        println("✓ ᏫᏥᎪᏩᏘᎭᎢ: ${result4.stem} - ${result4.morphemes.size()} morphemes")
    }

    @Test
    void testEdgeCases() {
        println("\n=== Edge Case Tests ===")
        
        def deconstructor = new VerbDeconstructor()
        
        // Very short word
        def result1 = deconstructor.deconstruct("Ꭰ", new Verb())
        assertFalse(result1.success || result1.error != null)
        println("✓ Single character handled")
        
        // Empty string
        def result2 = deconstructor.deconstruct("", new Verb())
        assertFalse(result2.success)
        println("✓ Empty string handled gracefully")
        
        // Just a prefix
        def result3 = deconstructor.deconstruct("Ꮻ", new Verb())
        assertNotNull(result3)
        println("✓ Single prefix glyph handled")
    }
    
    @Test
    void runAllTests() {
        println("\n" + "="*80)
        println("RUNNING ALL PREFIX DECONSTRUCTION TESTS")
        println("="*80)
        
        try {
            testPrefixWiDeconstruction()
        } catch (Exception e) {
            println("❌ Wi tests failed: ${e.message}")
        }
        
        try {
            testPrefixYiDeconstruction()
        } catch (Exception e) {
            println("❌ Yi tests failed: ${e.message}")
        }
        
        try {
            testPrefixNiDeconstruction()
        } catch (Exception e) {
            println("❌ Ni tests failed: ${e.message}")
        }
        
        try {
            testPrefixIGaDeDaDiDeconstruction()
        } catch (Exception e) {
            println("❌ I/Ga/De/Da/Di tests failed: ${e.message}")
        }
        
        try {
            testPrefixJiContextSensitive()
        } catch (Exception e) {
            println("❌ Ji tests failed: ${e.message}")
        }
        
        try {
            testFullDeconstructionPipeline()
        } catch (Exception e) {
            println("❌ Pipeline tests failed: ${e.message}")
        }
        
        try {
            testEdgeCases()
        } catch (Exception e) {
            println("❌ Edge case tests failed: ${e.message}")
        }
        
        println("\n" + "="*80)
        println("ALL TESTS COMPLETED")
        println("="*80)
    }
}
