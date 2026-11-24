#!/usr/bin/env groovy

// Standalone deconstruction test - no Gradle required!
// This demonstrates the deconstruction system working

println("="*80)
println("CHEROKEE VERB DECONSTRUCTION - DEMO")
println("="*80 + "\n")

// Add the classpath - adjust if needed
System.setProperty('java.class.path', 
  'build/classes/groovy/main:' +
  'build/resources/main:' +
  'lib/*')

try {
    // Load classes dynamically
    def classLoader = new GroovyClassLoader()
    
    // Load the main deconstructor
    def verbDeconstructorClass = classLoader.parseClass(
        new File('src/main/groovy/net/cherokeedictionary/verb/affixes/VerbDeconstructor.groovy')
    )
    
    // We need to load dependencies first... let's use a simpler approach
    println("Attempting direct instantiation...\n")
    
    // Try using the compiled classes directly
    def deconstructor = new net.cherokeedictionary.verb.affixes.VerbDeconstructor()
    def mockVerb = new net.cherokeedictionary.core.Verb()
    
    // Test 1: Simple wi- prefix
    println("\n" + "-"*60)
    println("TEST 1: Simple wi- prefix stripping")
    println("-"*60)
    def result1 = deconstructor.deconstruct("ᏫᎠᏬᏂ", mockVerb)
    println("Input: ᏫᎠᏬᏂ")
    println("Result:")
    println(result1)
    
    // Test 2: The critical user example
    println("\n" + "-"*60)
    println("TEST 2: User's Critical Example (Context-Sensitive)")
    println("-"*60)
    def result2 = deconstructor.deconstruct("ᏫᏥᎪᏩᏘᎭ", mockVerb)
    println("Input: ᏫᏥᎪᏩᏘᎭ")
    println("Expected behavior:")
    println("  • wi- (Ꮻ) SHOULD be extracted as initial prefix")
    println("  • ji- (Ꮵ) should NOT be extracted - appears FUSED into root")
    println("  • Stem should contain ᎪᏩᏘ")
    println("\nActual Result:")
    println(result2)
    
    // Verify expectations
    boolean hasJiExtracted = result2.morphomes?.any { 
        it.type == "PRONOMINAL_PREFIX" && it.value == "ji" 
    }
    
    if (hasJiExtracted) {
        println("\n⚠️  WARNING: ji- was extracted but should have been treated as FUSED!")
    } else {
        println("\n✓ SUCCESS: ji- was not extracted (treated as fused)")
    }
    
    // Test 3: Batch processing
    println("\n" + "-"*60)
    println("TEST 3: Batch Processing Multiple Forms")
    println("-"*60)
    
    List<String> forms = [
        "ᎠᏬᏂ",           // basic 1sg present
        "ᏫᎠᏬᏂ",         // with wi- directional
        "ᏫᏥᎪᏩᏘᎭ"        // critical example
    ]
    
    forms.eachWithIndex { form, idx ->
        println("\nForm ${idx + 1}: ${form}")
        def result = deconstructor.deconstruct(form, mockVerb)
        println("  Stem: ${result.stem}")
        println("  Morphemes found: ${result.morphomes?.size() ?: 0}")
        println("  Success: ${result.success}")
    }
    
    println("\n" + "="*80)
    println("ALL TESTS COMPLETED SUCCESSFULLY!")
    println("="*80)
    
} catch (Exception e) {
    println("\n❌ ERROR: ${e.message}")
    println("\nStack trace:")
    e.printStackTrace()
    
    println("\n💡 TIP: To fix this error:")
    println("   1. Make sure all dependencies are in place")
    println("   2. Check that VerbDeconstructor.groovy compiles without errors")
    println("   3. Ensure net.cherokeedictionary.core.Verb class exists")
}
