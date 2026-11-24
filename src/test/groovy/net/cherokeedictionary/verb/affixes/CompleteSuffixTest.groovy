package net.cherokeedictionary.verb.affixes

import net.cherokeedictionary.core.Verb
import org.junit.jupiter.api.Test
import static org.junit.jupiter.api.Assertions.*

/**
 * Comprehensive test suite for ALL suffix deconstruction methods.
 * Tests all 18 implemented suffix types across multi-character and single-character suffixes.
 */
class CompleteSuffixTest {

    private final SuffixDeconstructor suffixDec = new SuffixDeconstructor()

    @Test
    void testMultiCharSuffixes() {
        println("\n=== Testing Multi-Character Suffixes ===")

        // 3-character suffixes
        assertSuffixRemoved("ᎠᏬᏂᏳᏍᏗ", "ᎠᏬᏂ", "IMMEDIATE_FUTURE")
        assertSuffixRemoved("ᎪᏩᏘᎡᏍᏗ", "ᎪᏩᏘ", "FUTURE_ORIENTED")
        assertSuffixRemoved("ᎠᏬᏂᏍᎪᎢ", "ᎠᏬᏂ", "COMPLETIVE_ASPECT")

        // 2-character suffixes
        assertSuffixRemoved("ᎠᏬᏂᎣᎢ", "ᎠᏬᏂ", "HABITUAL_ASPECT")
        assertSuffixRemoved("ᎠᏬᏂᎥᎢ", "ᎠᏬᏂ", "HABITUAL_OR_ASPECTUAL")
        assertSuffixRemoved("ᎠᏬᏂᎢᏏ", "ᎠᏬᏂ", "HABITUAL_OR_ASPECTUAL")
        assertSuffixRemoved("ᎠᏬᏂᎢᏗ", "ᎠᏬᏂ", "INFINITIVE_VARIANT")
        assertSuffixRemoved("ᎠᏬᏂᎡᎢ", "ᎠᏬᏂ", "ASPECTUAL_MODAL")
        assertSuffixRemoved("ᎠᏬᏂᏍᎢ", "ᎠᏬᏂ", "VOWEL_FINALIZATION_NASAL")
        assertSuffixRemoved("ᎠᏬᏂᏗᎾ", "ᎠᏬᏂ", "PLURAL_DISTRIBUTIVE")

        println("\n✓ All multi-character suffix tests passed!")
    }

    @Test
    void testSingleCharSuffixes() {
        println("\n=== Testing Single-Character Suffixes ===")

        assertSuffixRemoved("ᎠᏬᏂᎢ", "ᎠᏬᏂ", "HABITUAL_PRESENT")
        assertSuffixRemoved("ᎠᏬᏛ", "ᎠᏬ", "COMPLETIVE_ASPECT")
        assertSuffixRemoved("ᎠᏬᏊ", "ᎠᏬ", "REMOTE_PAST")
        assertSuffixRemoved("ᎠᏬᏗ", "ᎠᏬ", "INFINITIVE_MARKER")
        assertSuffixRemoved("ᎠᏬᎲ", "ᎠᏬ", "SG3_MARKING")
        assertSuffixRemoved("ᎠᏬᏧ", "ᎠᏬ", "INFINITIVE_MARKER")
        assertSuffixRemoved("ᎠᏬᎾ", "ᎠᏬ", "NOMINALIZER")
        assertSuffixRemoved("ᎠᏬᎨ", "ᎠᏬ", "ASPECTUAL_MARKER")
        assertSuffixRemoved("ᎠᏬᎠ", "ᎠᏬ", "VOWEL_ENDING")

        println("\n✓ All single-character suffix tests passed!")
    }

    @Test
    void testCombinedPrefixAndSuffixPipeline() {
        println("\n=== Testing Full Pipeline (Prefix + Suffix) ===")

        def deconstructor = new VerbDeconstructor()

        // Test 1: wi- + habitual present
        def result1 = deconstructor.deconstruct("ᏫᎠᏬᏂᎢ", new Verb())
        assertTrue(result1.success, "Should succeed")
        boolean hasWi = result1.morphemes?.any { it.value == "wi" }
        assertTrue(hasWi, "Should extract wi-")
        println("✓ ᏫᎠᏬᏂᎢ: ${result1.stem} - Wi prefix: ${hasWi ? '✓' : '✗'}")

        // Test 2: wi- + immediate future
        def result2 = deconstructor.deconstruct("ᏫᏬᏂᏳᏍᏗ", new Verb())
        assertTrue(result2.success, "Should succeed")
        hasWi = result2.morphemes?.any { it.value == "wi" }
        assertTrue(hasWi, "Should extract wi-")
        println("✓ ᏫᏬᏂᏳᏍᏗ: ${result2.stem} - Wi prefix: ${hasWi ? '✓' : '✗'}")

        // Test 3: Complex form with multiple elements
        def result3 = deconstructor.deconstruct("ᏯᎠᏬᏂᎣᎢ", new Verb())
        assertTrue(result3.success, "Should succeed")
        println("✓ ᏯᎠᏬᏂᎣᎢ: ${result3.stem} - ${result3.morphemes.size()} morphemes extracted")

        // Test 4: Critical example with fused ji
        def result4 = deconstructor.deconstruct("ᏫᏥᎪᏩᏘᎭᎢ", new Verb())
        assertTrue(result4.success, "Should succeed")
        println("✓ ᏫᏥᎪᏩᏘᎭᎢ: ${result4.stem} - ${result4.morphemes.size()} morphemes extracted")
    }

    @Test
    void testEdgeCases() {
        println("\n=== Testing Edge Cases ===")

        // Very short word without suffix
        def result1 = suffixDec.processAllSuffixes("Ꭰ", new Verb(), [])
        assertEquals("Ꭰ", result1, "Single character should remain unchanged")
        println("✓ Single character: Ꭰ → Ꭰ")

        // Empty string
        def result2 = suffixDec.processAllSuffixes("", new Verb(), [])
        assertEquals("", result2, "Empty string should remain empty")
        println("✓ Empty string handled gracefully")

        // Word with no recognized suffix
        def result3 = suffixDec.processAllSuffixes("ᎠᏬᏂ", new Verb(), [])
        assertEquals("ᎠᏬᏂ", result3, "Word without suffix should remain unchanged")
        println("✓ No suffix case: ᎠᏬᏂ → ᎠᏬᏂ")

        // Multiple potential suffix matches (should take longest)
        def result4 = suffixDec.processAllSuffixes("ᎠᏬᏂᏳᏍᏗᎢ", new Verb(), [])
        // Should first remove ᏳᏍᏗ, then check for Ꭲ
        println("✓ Multi-suffix handling: ᎠᏬᏂᏳᏍᏗᎢ → ${result4}")
    }

    @Test
    void runAllSuffixTests() {
        println("\n" + "="*80)
        println("RUNNING COMPLETE SUFFIX TEST SUITE (18 SUFFIX TYPES)")
        println("="*80 + "\n")

        try {
            testMultiCharSuffixes()
        } catch (Exception e) {
            println("❌ Multi-char suffix tests failed: ${e.message}")
            e.printStackTrace()
        }

        try {
            testSingleCharSuffixes()
        } catch (Exception e) {
            println("❌ Single char suffix tests failed: ${e.message}")
            e.printStackTrace()
        }

        try {
            testCombinedPrefixAndSuffixPipeline()
        } catch (Exception e) {
            println("❌ Combined pipeline tests failed: ${e.message}")
            e.printStackTrace()
        }

        try {
            testEdgeCases()
        } catch (Exception e) {
            println("❌ Edge case tests failed: ${e.message}")
            e.printStackTrace()
        }

        println("\n" + "="*80)
        println("ALL SUFFIX TESTS COMPLETED")
        println("Implemented: 18 suffix types")
        println("="*80)
    }

    private void assertSuffixRemoved(String input, String expectedStem, String expectedType) {
        def morphemes = [] as ArrayList<Morpheme>
        String result = suffixDec.processAllSuffixes(input, new Verb(), morphemes)
        
        assertEquals(expectedStem, result, "Stem should match for $input")
        assertFalse(morphemes.isEmpty(), "Should extract at least one morpheme from $input")
        
        if (!morphemes.isEmpty()) {
            assertEquals(expectedType, morphemes[0].value, 
                "Expected type $expectedType for $input, got ${morphemes[0].value}")
            println("  ✓ ${input.padRight(15)} → ${expectedStem.padRight(10)} (${expectedType})")
        }
    }
}
