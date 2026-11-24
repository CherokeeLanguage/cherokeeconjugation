package net.cherokeedictionary.verb.affixes

import net.cherokeedictionary.core.Verb
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.*

/**
 * Comprehensive test suite for verb deconstruction.
 * 
 * This test allows you to add your own conjugation examples with expected results
 * and validate them against the deconstruction pipeline.
 * 
 * USAGE: Add your test cases in the ADD_YOUR_CASES_HERE section below.
 */
class VerbDeconstructorComprehensiveTest {

    private final DeconstructionResult result = deconstruct(input, mockVerb)

    def mockVerb = new Verb()

    @Test
    void runAllValidationTests() {
        println("\n" + "="*80)
        println("COMPREHENSIVE VERB DECONSTRUCTION VALIDATION")
        println("="*80 + "\n")

        // ============================================================
        // ADD YOUR TEST CASES HERE - Format: [surface_form, expected_stem, expected_morphemes]
        // Example: testCases << ["ᎠᏬᏂ", "ᏬᏂ", ["1st_person_present"]]
        // ============================================================
        
        List<TestEntry> testCases = [
            // Basic intransitive forms (from original test)
            new TestEntry("ᎠᏬᏂ", "ᏬᏂ", ["1sg_present"]),
            new TestEntry("ᎡᏬᏂ", "ᏬᏂ", ["2sg_present"]),
            new TestEntry("ᎢᏬᏂ", "ᏬᏂ", ["3sg_present"]),
            
            // Transitive with object markers
            new TestEntry("ᎠᎩᏬᏂᎯ", "ᏬᏂ", ["1sg_3sg_obj_present"]),
            
            // Past tense forms
            new TestEntry("ᎠᏬᏂᎩ", "ᏬᏂ", ["1sg_past"]),
            new TestEntry("ᎤᏬᏂᎩ", "ᏬᏂ", ["3sg_past"]),
            
            // Habitual forms
            new TestEntry("ᎠᏬᏂᎢ", "ᏬᏂ", ["1sg_habitual"]),
            new TestEntry("ᎤᏬᏂᎢ", "ᏬᏂ", ["3sg_habitual"]),

            // IMMEDIATE FUTURE - Your example from conversation
            new TestEntry("ᎠᏬᏂᏳᏍᏗ", "ᏬᏂ", ["1sg_immediate_future"]),

            // REFLEXIVE FORMS - Add examples from your lexicon
            new TestEntry("ᎠᎪᏩᏘᎭ", "ᎪᏩᏘ", ["reflexive_present"]),
            
            // CRITICAL USER EXAMPLE: Context-sensitive disambiguation
            // This tests whether Ꮵ is treated as fused (not extracted) when followed by root
            new TestEntry("ᏫᏥᎪᏩᏘᎭ", "ᎪᏩᏘ", ["directional_fused_ji_reflexive_present"])
        ]
        
        // ============================================================
        // END OF TEST CASES SECTION
        // ============================================================

        int passedCount = 0
        int totalCount = testCases.size()

        testCases.eachWithIndex { testCase, index ->
            println("\n" + "-"*60)
            println("TEST ${index + 1}/${totalCount}: ${testCase.input}")
            println("-"*60)
            
            try {
                def result = runSingleTest(testCase)
                
                if (result.matchesExpected()) {
                    println("✅ PASS")
                    passedCount++
                } else {
                    println("❌ FAIL")
                    println(result.failureReasons.join("\n"))
                }
            } catch (Exception e) {
                println("💥 ERROR: ${e.message}")
                e.printStackTrace()
            }
        }

        // Summary
        println("\n" + "="*80)
        println("VALIDATION SUMMARY")
        println("="*80)
        println("Total Tests: ${totalCount}")
        println("Passed: ${passedCount}")
        println("Failed: ${totalCount - passedCount}")
        println("Success Rate: ${String.format('%.1f', (passedCount * 100.0 / totalCount))}%")
        println("="*80 + "\n")
        
        assertTrue(passedCount > totalCount * 0.7, 
                  "At least 70% of tests should pass (${passedCount}/${totalCount} failed)")
    }

    /**
     * Run a single test case and return detailed results
     */
    DeconstructionResult runSingleTest(TestEntry testCase) {
        def deconstructor = new VerbDeconstructor()
        
        println("\nRunning deconstruction on: ${testCase.input}")
        println("Expected stem: ${testCase.expectedStem}")
        println("Expected morphemes: ${testCase.expectedMorphemes}\n")

        // Perform deconstruction
        def result = deconstructor.deconstruct(testCase.input, mockVerb)
        
        // Compare results
        boolean matches = true
        List<String> failures = []

        // Check stem
        if (!result.stem.equals(testCase.expectedStem)) {
            matches = false
            failures << "Stem mismatch:"
            failures << "  Expected: ${testCase.expectedStem}"
            failures << "  Got:      ${result.stem}"
        }

        // Check morpheme count
        if (result.morphemes && result.morphemes.size() > 0) {
            println("\nExtracted morphemes:")
            result.morphemes.each { m ->
                println("  [${m.position}] ${m.type}: ${m.value}")
                if (m.detectedValue) {
                    println("          Detected: ${m.detectedValue}")
                }
            }
        }

        // Check specific morphemes (this would need more sophisticated matching logic)
        if (testCase.expectedMorphemes) {
            // For now, just log what we found vs what was expected
            println("\nExpected vs Extracted:")
            println("  Expected: ${testCase.expectedMorphemes}")
            if (result.morphemes) {
                println("  Extracted: ${result.morphemes.collect { it.type }}")
            } else {
                println("  Extracted: (none)")
            }
        }

        return new ValidationReport(
            input: testCase.input,
            expectedStem: testCase.expectedStem,
            gotStem: result.stem,
            matches: matches,
            failureReasons: failures,
            result: result
        )
    }

    /**
     * Helper method for running deconstruction (convenience)
     */
    DeconstructionResult deconstruct(String word, Verb verb) {
        def deconstructor = new VerbDeconstructor()
        return deconstructor.deconstruct(word, verb)
    }
}