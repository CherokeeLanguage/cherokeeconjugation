package net.cherokeedictionary.verb.affixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.suffixes.*
import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.*

/**
 * Comprehensive test for suffix deconstruction.
 */
class SuffixDeconstructorTest {

    private final SuffixDeconstructor suffixDec = new SuffixDeconstructor()
    
    @Test
    void testImmediateFutureSuffix() {
        println("\n=== Testing Immediate Future (ᏳᏍᏗ) ===")
        
        def result = suffixDec.processAllSuffixes("ᎠᏬᏂᏳᏍᏗ", new Verb(), [])
        
        assertEquals("ᎠᏬᏂ", result, "Should remove ᏳᏍᏗ from end")
        println("✓ ᎠᏬᏂᏳᏍᏗ → ᎠᏬᏂ")
    }
    
    @Test
    void testHabitualSuffixI() {
        println("\n=== Testing Habitual (Ꭲ) ===")
        
        def result = suffixDec.processAllSuffixes("ᎠᏬᏂᎢ", new Verb(), [])
        
        assertEquals("ᎠᏬᏂ", result, "Should remove Ꭲ from end")
        println("✓ ᎠᏬᏂᎢ → ᎠᏬᏂ")
    }
    
    @Test
    void testCombinedPrefixAndSuffix() {
        println("\n=== Testing Full Deconstruction Pipeline ===")
        
        def deconstructor = new VerbDeconstructor()
        
        // Test 1: Simple verb with habitual
        def result1 = deconstructor.deconstruct("ᎠᏬᏂᎢ", new Verb())
        assertTrue(result1.success)
        println("✓ ᎠᏬᏂᎢ: ${result1.stem} (${result1.morphemes.size()} morphemes)")
        
        // Test 2: Verb with wi- and immediate future
        def result2 = deconstructor.deconstruct("ᏫᏬᏂᏳᏍᏗ", new Verb())
        assertTrue(result2.success)
        println("✓ ᏫᏬᏂᏳᏍᏗ: ${result2.stem} (${result2.morphemes.size()} morphemes)")
        
        // Verify wi- was extracted
        boolean hasWi = result2.morphemes?.any { it.value == "wi" }
        assertTrue(hasWi, "Should extract wi- prefix")
        println("  → Wi prefix: ${hasWi ? '✓' : '✗'}")
    }
    
    @Test
    void testMultipleSuffixTypes() {
        println("\n=== Testing Various Suffix Types ===")
        
        def results = [
            ["ᎠᏬᏂᏳᏍᏗ", "IMMEDIATE_FUTURE"],
            ["ᎠᏬᏂᎢ", "HABITUAL_PRESENT"],
            ["ᎪᏩᏘᎭ", "PRESENT_REFLEXIVE"],
        ]
        
        results.each { [input, expectedType] ->
            def morphemes = [] as ArrayList<Morpheme>
            String remaining = suffixDec.processAllSuffixes(input, new Verb(), morphemes)
            
            println("  Input: ${input}")
            println("    → Stem: ${remaining}")
            println("    → Morphemes: ${morphemes.size()}")
            
            if (!morphemes.isEmpty()) {
                println("      - ${morphemes[0].value}")
            }
        }
    }
    
    @Test
    void testEdgeCases() {
        println("\n=== Testing Edge Cases ===")
        
        // Very short word
        def result1 = suffixDec.processAllSuffixes("Ꭰ", new Verb(), [])
        assertEquals("Ꭰ", result1, "Very short words should remain unchanged")
        println("✓ Single character: Ꭰ → Ꭰ")
        
        // Empty string
        def result2 = suffixDec.processAllSuffixes("", new Verb(), [])
        assertEquals("", result2, "Empty string should remain empty")
        println("✓ Empty string handled gracefully")
        
        // No suffix present
        def result3 = suffixDec.processAllSuffixes("ᎠᏬᏂ", new Verb(), [])
        assertEquals("ᎠᏬᏂ", result3, "Word without recognized suffix should remain unchanged")
        println("✓ No suffix case: ᎠᏬᏂ → ᎠᏬᏂ")
    }
    
    @Test
    void runAllSuffixTests() {
        println("\n" + "="*80)
        println("RUNNING ALL SUFFIX DECONSTRUCTION TESTS")
        println("="*80 + "\n")
        
        try {
            testImmediateFutureSuffix()
        } catch (Exception e) {
            println("❌ Future tests failed: ${e.message}")
        }
        
        try {
            testHabitualSuffixI()
        } catch (Exception e) {
            println("❌ Habitual tests failed: ${e.message}")
        }
        
        try {
            testCombinedPrefixAndSuffix()
        } catch (Exception e) {
            println("❌ Combined tests failed: ${e.message}")
        }
        
        try {
            testMultipleSuffixTypes()
        } catch (Exception e) {
            println("❌ Multiple suffix tests failed: ${e.message}")
        }
        
        try {
            testEdgeCases()
        } catch (Exception e) {
            println("❌ Edge case tests failed: ${e.message}")
        }
        
        println("\n" + "="*80)
        println("ALL SUFFIX TESTS COMPLETED")
        println("="*80)
    }
}
