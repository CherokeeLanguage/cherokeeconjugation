package net.cherokeedictionary.verb.affixes

import net.cherokeedictionary.core.Verb
import org.junit.jupiter.api.Test

/**
 * Quick batch testing utility for deconstruction.
 * 
 * Add your conjugation forms here in the list below, run this test,
 * and see detailed output for each one.
 */
class BatchDeconstructorTest {

    @Test
    void testBatchConjugations() {
        println("\n" + "="*80)
        println("BATCH DECONSTRUCTION TEST")
        println("="*80 + "\n")

        // ============================================================
        // ADD YOUR CONJUGATION FORMS HERE
        // Just add strings to this list - no expected values needed
        // ============================================================
        
        List<String> testForms = [
            "ᎠᏬᏂ",           // "I sleep" - basic 1sg present
            "ᎡᏬᏂ",           // "You sleep" - basic 2sg present  
            "ᎢᏬᏂ",           // "He/she sleeps" - basic 3sg present
            "ᎠᎩᏬᏂᎯ",       // "I sleep him" - transitive 1-3
            "ᎤᏬᏂᎩ",         // "They slept" - past
            "ᎠᏬᏂᎢ",         // "I sleep (habitually)"
            "ᎤᏬᏂᎢ",         // "They sleep (habitually)"
            "ᎠᏬᏂᏳᏍᏗ",      // "I will sleep" - immediate future
            
            // REFLEXIVE EXAMPLES - from your lexicon
            "ᎠᎪᏩᏘᎭ",        // reflexive present
            
            // THE CRITICAL USER EXAMPLE
            "ᏫᏥᎪᏩᏘᎭ",      // directional + fused ji + reflexive
            
            // ADD MORE FROM YOUR LIST BELOW...
            // "Your Example Here",
            // "Another Example",
        ]
        
        // ============================================================
        // END OF LIST
        // ============================================================

        def deconstructor = new VerbDeconstructor()
        def mockVerb = new Verb()
        
        int passed = 0
        int failed = 0
        
        testForms.eachWithIndex { form, idx ->
            println("\n" + "-"*70)
            println("FORM ${idx + 1}/${testForms.size()}: ${form}")
            println("-"*70)
            
            try {
                def result = deconstructor.deconstruct(form, mockVerb)
                
                println(result.toString())
                
                if (result.success && result.stem && !result.error) {
                    passed++
                } else {
                    failed++
                }
            } catch (Exception e) {
                println("💥 EXCEPTION: ${e.message}")
                e.printStackTrace()
                failed++
            }
        }

        println("\n" + "="*80)
        println("BATCH RESULTS")
        println("="*80)
        println("Total Forms: ${testForms.size()}")
        println("Successful: ${passed}")
        println("Failed: ${failed}")
        println("Success Rate: ${String.format('%.1f', (passed * 100.0 / testForms.size()))}%")
        println("="*80 + "\n")
    }

    /**
     * Alternative: Test only the critical user example
     */
    @Test
    void testUserCriticalExample() {
        println("\n" + "="*80)
        println("CRITICAL USER EXAMPLE TEST")
        println("="*80)
        println("\nTesting: ᏫᏥᎪᏩᏘᎭ")
        println("Expected behavior:")
        println("  • wi- (Ꮻ) SHOULD be extracted as initial prefix")
        println("  • ji- (Ꮵ) should NOT be extracted - appears FUSED into root")
        println("  • Stem should be: ᎪᏩᏘ (not starting with Ꮵ)")
        println("="*80 + "\n")

        def deconstructor = new VerbDeconstructor()
        def result = deconstructor.deconstruct("ᏫᏥᎪᏩᏘᎭ", new Verb())
        
        println(result)
        
        // Verify expectations
        assert result.success : "Deconstruction should succeed"
        assert result.stem.contains("ᎪᏩᏘ") : "Stem should contain ᎪᏩᏘ"
        
        // Check that ji- wasn't incorrectly extracted
        boolean jiExtracted = result.morphemes?.any { it.type == "PRONOMINAL_PREFIX" && it.value == "ji" }
        if (jiExtracted) {
            println("\n⚠️  WARNING: ji- was extracted but should have been treated as FUSED!")
            println("   This indicates the context-sensitive rule needs adjustment.")
        } else {
            println("\n✓ CORRECT: ji- was not extracted (treated as fused)")
        }
    }

    @Test
    void testSimple() {
        def deconstructor = new VerbDeconstructor()
        def result = deconstructor.deconstruct("ᏫᏥᎪᏩᏘᎭ", new Verb())
        println(result)
    }
}