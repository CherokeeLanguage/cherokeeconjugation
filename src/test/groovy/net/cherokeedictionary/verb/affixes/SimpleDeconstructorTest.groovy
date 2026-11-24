package net.cherokeedictionary.verb.affixes

import net.cherokeedictionary.core.Verb
import org.junit.jupiter.api.Test

class SimpleDeconstructorTest {

    @Test
    void testWiPrefix() {
        println("\n=== Test: Wi Prefix Deconstruction ===")
        
        def deconstructor = new VerbDeconstructor()
        def verb = new Verb()
        
        // Test wi- prefix stripping
        def result = deconstructor.deconstruct("ᏫᎠᏬᏂ", verb)
        
        assert result.success : "Should successfully deconstruct"
        assert result.stem == "ᏬᏂ" : "Stem should be ᏬᏂ, got ${result.stem}"
        println("✓ Wi prefix stripped correctly")
        println(result)
    }

    @Test
    void testUserCriticalExample() {
        println("\n=== Test: User's Critical Example ===")
        println("Input: ᏫᏥᎪᏩᏘᎭ")
        
        def deconstructor = new VerbDeconstructor()
        def verb = new Verb()
        
        def result = deconstructor.deconstruct("ᏫᏥᎪᏩᏘᎭ", verb)
        
        assert result.success : "Should successfully deconstruct"
        assert result.stem.contains("ᎪᏩᏘ") : "Stem should contain ᎪᏩᏘ, got ${result.stem}"
        
        println("\nExpected behavior:")
        println("  • wi- (Ꮻ) SHOULD be extracted as initial prefix")
        println("  • ji- (Ꮵ) should NOT be extracted - appears FUSED into root")
        println("  • Stem should be: ᎪᏩᏘᎭ (not starting with Ꮵ)")
        
        println("\nActual result:")
        println(result)
        
        // Verify key assertions
        boolean hasJiExtracted = result.morphemes?.any { 
            it.type == "PRONOMINAL_PREFIX" && it.value == "ji" 
        }
        
        if (hasJiExtracted) {
            println("\n⚠️  WARNING: ji- was extracted but should have been treated as FUSED!")
            assert false : "ji- should NOT be extracted for fused case"
        } else {
            println("\n✓ CORRECT: ji- was not extracted (treated as fused)")
        }
    }

    @Test
    void testBatchMultipleForms() {
        println("\n=== Test: Batch Multiple Forms ===")
        
        def deconstructor = new VerbDeconstructor()
        def verb = new Verb()
        
        List<String> forms = [
            "ᎠᏬᏂ",           // basic 1sg
            "ᏫᎠᏬᏂ",         // with wi-
            "ᏫᏥᎪᏩᏘᎭ"        // critical example
        ]
        
        forms.eachWithIndex { form, idx ->
            println("\nForm ${idx + 1}: ${form}")
            def result = deconstructor.deconstruct(form, verb)
            println("  Success: ${result.success}")
            println("  Stem: ${result.stem}")
            println("  Morphemes: ${result.morphemes?.size() ?: 0}")
        }
        
        println("\n✓ All batch forms processed")
    }
}
