package net.cherokeedictionary.verb.affixes.initialPrefixes

import net.cherokeedictionary.core.Verb
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.*

/**
 * Test suite for prefix deconstruction methods.
 * 
 * This tests the approach of reversing conjugation logic to deconstruct verbs.
 * We take existing Prefix classes and add deconstructFromSyllabary methods
 * that reverse what toSyllabary does.
 */
class PrefixWiDeconstructorTest extends GroovyTestCase {

    private PrefixWi prefixWi
    private PrefixJi prefixJi
    private Verb mockVerb

    @BeforeEach
    void setUp() {
        prefixWi = new PrefixWi()
        prefixJi = new PrefixJi()

        // Create a mock verb with minimal structure
        mockVerb = new Verb()
        mockVerb.pronounReflexiveRoot = "ᎪᏩᏘ"  // Example root
        mockVerb.tense = null
    }

    /**
     * Test basic wi- prefix detection and stripping
     */
//    @Test
//    void testWiPrefixBasicDetection() {
//        String input = "ᏫᎠᏬᏂ"  // wi- + a-woni
//        def result = prefixWi.deconstructFromSyllabary(input, mockVerb)
//
//        assertTrue(result.prefixRemoved, "Should have detected wi- prefix")
//        assertEquals("ᏬᏂ", result.result, "Stripped stem should be ᏬᏂ")
//        assertEquals("Ꮻ", result.detectedPrefix, "Detected prefix should be Ꮻ")
//    }

    /**
     * Test when no wi- prefix is present
     */
//    @Test
//    void testNoWiPrefixPresent() {
//        String input = "ᎠᏬᏂ"  // just a-woni, no wi-
//        def result = prefixWi.deconstructFromSyllabary(input, mockVerb)
//
//        assertFalse(result.prefixRemoved, "Should NOT detect wi- prefix")
//        assertEquals("ᎠᏬᏂ", result.result, "Input should remain unchanged")
//        assertNull(result.detectedPrefix, "No prefix should be detected")
//    }

    void testWi() {
        String input = "ᏫᏥᎪᏩᏘᎭ"  // just a-woni, no wi-
        def result = prefixWi.deconstructFromSyllabary(input, mockVerb)
        assertEquals("ᏥᎪᏩᏘᎭ", result.result)
    }

//    /**
//     * Test different wi- variants based on vowel following
//     */
//    @Test
//    void testWiVariantDetection() {
//        List<String[]> testCases = [
//            ["ᏩᎠᏬᏂ", "ᏬᏂ"],  // wa- variant
//            ["ᏪᎠᏬᏂ", "ᏬᏂ"],  // we- variant
//            ["ᏫᎠᏬᏂ", "ᏬᏂ"],  // wi- variant
//            ["ᏬᎠᏬᏂ", "ᏬᏂ"],  // wo- variant
//            ["ᏭᎠᏬᏂ", "ᏬᏂ"]   // vu- variant
//        ]
//
//        testCases.each { testCase ->
//            String input = testCase[0]
//            String expectedStem = testCase[1]
//
//            def result = prefixWi.deconstructFromSyllabary(input, mockVerb)
//            assertTrue(result.prefixRemoved, "Should detect wi- variant in $input")
//            assertEquals(expectedStem, result.result, "Should strip to correct stem for $input")
//        }
//    }
//
//    /**
//     * Test ji- prefix stripping
//     */
//    @Test
//    void testJiPrefixStripping() {
//        String input = "ᏥᎠᏬᏂ"  // ji- + a-woni (genuine ji- case)
//        def result = prefixJi.deconstructFromSyllabary(input, mockVerb)
//
//        assertTrue(result.prefixRemoved, "Should detect ji- prefix")
//        assertEquals("ᎠᏬᏂ", result.result, "Stripped stem should be ᎠᏬᏂ")
//        assertEquals("Ꮵ", result.detectedPrefix, "Detected prefix should be Ꮵ")
//    }
//
//    /**
//     * CRITICAL TEST: The user's example - context-sensitive disambiguation
//     *
//     * Input: ᏫᏥᎪᏩᏘᎭ
//     * Expected: Should recognize that ᎪᏩᏘ is a root, so Ꮵ is FUSED, not separate
//     */
//    @Test
//    void testUserExampleContextSensitiveDisambiguation() {
//        String input = "ᏫᏥᎪᏩᏘᎭ"  // User's example: wi-ji-gawati-ha
//
//        // First, apply wi- deconstruction
//        println("\n=== Testing: ${input} ===")
//        println("Step 1: Apply Wi deconstruction")
//
//        def wiResult = prefixWi.deconstructFromSyllabary(input, mockVerb)
//        println("After Wi deconstruction:")
//        println("  Removed: ${wiResult.prefixRemoved}")
//        println("  Detected: ${wiResult.detectedPrefix}")
//        println("  Result: ${wiResult.result}")
//
//        // If wi- was removed, check if remaining starts with ji-
//        if (wiResult.prefixRemoved && wiResult.result) {
//            println("Step 2: Apply Ji deconstruction to remaining: ${wiResult.result}")
//
//            def jiResult = prefixJi.deconstructFromSyllabary(wiResult.result as String, mockVerb)
//            println("After Ji deconstruction:")
//            println("  Removed: ${jiResult.prefixRemoved}")
//            println("  Detected: ${jiResult.detectedPrefix}")
//            println("  Result: ${jiResult.result}")
//            println("  Reason: ${jiResult.reason}")
//
//            // KEY ASSERTION: ji- should NOT be stripped because ᎪᏩᏘ looks like a known root
//            assertFalse(jiResult.prefixRemoved,
//                       "Should NOT strip ji- because ᎪᏩᏘ appears to be a known root!")
//
//            // The final stem should be ᎪᏩᏘ (with Ꭽ suffix), not something starting with Ꮵ
//            assertTrue(jiResult.result.contains("ᎪᏩᏘ"),
//                      "Final result should contain the root ᎪᏩᏘ")
//        } else {
//            fail("Wi- prefix should have been detected and stripped")
//        }
//    }
//
//    /**
//     * Test edge case: genuine ji- prefix vs fused
//     */
//    @Test
//    void testGenuineJiVsFused() {
//        // Case 1: Genuine ji- before simple syllable (should strip)
//        String genuineJi = "ᏥᎠ"  // ji- + a (simple, not a known root)
//        def genuineResult = prefixJi.deconstructFromSyllabary(genuineJi, mockVerb)
//        assertTrue(genuineResult.prefixRemoved, "Should strip genuine ji- from short form")
//
//        // Case 2: ji- before likely root (should NOT strip)
//        String fusedJi = "ᏥᎪᏩᏘ"  // ji- + gawati (looks like root)
//        def fusedResult = prefixJi.deconstructFromSyllabary(fusedJi, mockVerb)
//        assertFalse(fusedResult.prefixRemoved, "Should NOT strip ji- before root-like form")
//
//        System.out.println("\n--- Comparison ---")
//        System.out.println("Genuine ji- (ᏥᎠ): stripped=${genuineResult.prefixRemoved}")
//        System.out.println("Fused ji- (ᏥᎪᏩᏘ): stripped=${fusedResult.prefixRemoved}")
//    }
//
//    /**
//     * Test full pipeline: wi- then ji- in proper order
//     */
//    @Test
//    void testFullPipelineOrder() {
//        // Process prefixes in order: initial → pronominal → reflexive
//        String input = "ᏫᏥᎠᏬᏂᎯ"  // wi- + ji- + a-woni-hi
//
//        println("\n=== Full Pipeline Test: ${input} ===")
//
//        // Step 1: Remove wi- (if present)
//        def step1 = prefixWi.deconstructFromSyllabary(input, mockVerb)
//        println("Step 1 (Wi removal): ${step1.result}")
//
//        // Step 2: Remove ji- from remaining (context-aware)
//        def step2 = prefixJi.deconstructFromSyllabary(step1.result, mockVerb)
//        println("Step 2 (Ji removal): ${step2.result}")
//
//        // Final result depends on whether ji- was fused or genuine
//        println("\nFinal analysis:")
//        println("  Remaining: ${step2.result}")
//        println("  Was ji- stripped: ${step2.prefixRemoved}")
//
//        // Assert we get some meaningful stem back
//        assertNotNull(step2.result, "Should have a result after deconstruction")
//    }
}
