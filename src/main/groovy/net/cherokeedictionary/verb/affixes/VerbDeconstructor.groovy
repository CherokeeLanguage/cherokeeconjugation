package net.cherokeedictionary.verb.affixes

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.initialPrefixes.*
import groovy.transform.CompileStatic

/**
 * Main verb deconstructor orchestration class.
 * 
 * This class coordinates the sequential application of all prefix and suffix
 * deconstruction methods in reverse order (outside-in).
 */
@CompileStatic
class VerbDeconstructor {

    // Prefix instances for deconstruction (only include those with deconstruction methods)
    private final PrefixWi prefixWi = new PrefixWi()
    private final PrefixJi prefixJi = new PrefixJi()
    
    private final ReflexivePrefix reflexivePrefix = new ReflexivePrefix()

    /**
     * Main entry point: deconstruct a Cherokee verb
     * 
     * @param fullWord The complete conjugated verb form in syllabary
     * @param verb Optional Verb object with metadata (if available)
     * @return DeconstructionResult with detailed breakdown
     */
    DeconstructionResult deconstruct(String fullWord, Verb verb = null) {
        if (!fullWord || fullWord.trim().isEmpty()) {
            return new DeconstructionResult(original: "", error: "Empty input")
        }

        String remaining = fullWord.trim()
        List<Morpheme> extractedMorphemes = [] as ArrayList<Morpheme>

        println("\n=== Starting Deconstruction ===")
        println("Input: ${fullWord}")
        println("Step 1: Remove Initial Prefixes (wi-, ji-, etc.)\n")

        // PHASE 1: Initial Prefixes (outside-in order)
        remaining = processInitialPrefixes(remaining, verb ?: new Verb(), extractedMorphemes)
        
        // PHASE 2: Reflexive (intermediate level)
        if (remaining && remaining.length() > 2) {
            PrefixReflexiveResult reflResult = reflexivePrefix.deconstructFromSyllabary(remaining, verb ?: new Verb())
            if (reflResult.hasReflexive) {
                Morpheme morpheme = new Morpheme(
                    type: "REFLEXIVE", 
                    value: reflResult.detectedAllomorph ?: "ada",
                    detectedValue: reflResult.detectedAllomorph,
                    position: extractedMorphemes.size(),
                    confidence: 0.95
                )
                extractedMorphemes << morpheme
                remaining = reflResult.result
                println("→ Found REFLEXIVE: ${reflResult.detectedAllomorph}")
                println("  Remaining: ${remaining}\n")
            }
        }

        // PHASE 3: Suffixes (from outside-in - longest first typically)
        if (remaining && remaining.length() > 2) {
            remaining = processSuffixes(remaining, verb ?: new Verb(), extractedMorphemes)
        }

        // Final stem
        String finalStem = remaining ?: "unknown"
        
        println("=== Deconstruction Complete ===")
        println("Final Stem: ${finalStem}")
        println("Extracted Morphemes:")
        extractedMorphemes.each { m ->
            println("  [${m.position}] ${m.type}: ${m.value} (confidence: ${String.format('%.2f', m.confidence)})")
        }

        return new DeconstructionResult(
            original: fullWord,
            stem: finalStem,
            morphemes: extractedMorphemes,
            success: true
        )
    }

    private String processInitialPrefixes(String remaining, Verb verb, List<Morpheme> morphemes) {
        
        int iteration = 0
        int maxIterations = 10
        
        while (remaining && remaining.length() >= 1 && iteration < maxIterations) {
            boolean foundPrefix = false
            
            // Try Wi prefix first
            PrefixWiResult wiResult = prefixWi.deconstructFromSyllabary(remaining, verb)
            if (wiResult.prefixRemoved) {
                if (!wiResult.detectedPrefix) {
                    break
                }
                
                Morpheme morpheme = new Morpheme(
                    type: "INITIAL_PREFIX", 
                    value: "wi", 
                    detectedValue: wiResult.detectedPrefix,
                    position: morphemes.size(),
                    confidence: 0.9
                )
                morphemes << morpheme
                remaining = wiResult.result
                foundPrefix = true
                println("Found WI-: ${wiResult.detectedPrefix}")
            }
            
            // If no progress yet, try Ji prefix
            if (!foundPrefix && remaining && remaining.length() > 0) {
                PrefixJiResult jiResult = prefixJi.deconstructFromSyllabary(remaining, verb)
                if (jiResult.prefixRemoved) {
                    String reason = jiResult.getReason()
                    BigDecimal confidence = 0.85
                    if ("fused_into_stem" == reason) {
                        confidence = 0.2
                    }
                    
                    Morpheme morpheme = new Morpheme(
                        type: "PRONOMINAL_PREFIX", 
                        value: "ji", 
                        detectedValue: jiResult.detectedPrefix,
                        position: morphemes.size(),
                        confidence: confidence
                    )
                    morphemes << morpheme
                    remaining = jiResult.result
                    foundPrefix = true
                    
                    if ("fused_into_stem" == reason) {
                        println("→ Detected FUSED ji- (context-sensitive): extracting with low confidence")
                    } else {
                        println("Found PI-: ${jiResult.detectedPrefix}")
                    }
                }
            }
            
            // If no prefix found in this iteration, we're done with initial prefixes
            if (!foundPrefix) {
                break
            }
            
            iteration++
        }
        
        return remaining
    }

    private String processSuffixes(String remaining, Verb verb, List<Morpheme> morphemes) {
        Map<String, String> suffixPatterns = [:]
        suffixPatterns["ᏳᏍᏗ"] = "IMMEDIATE_FUTURE"
        suffixPatterns["Ᏹ"] = "SUBJUNCTIVE"
        suffixPatterns["Ꭲ"] = "HABITUAL"
        suffixPatterns["Ꭹ"] = "PAST"
        suffixPatterns["Ꭽ"] = "PRESENT_REFLEXIVE"
        suffixPatterns["ᎬᎢ"] = "REMOTE_PAST"
        suffixPatterns["ᏅᎢ"] = "WITHOUT_SUFFIX"

        suffixPatterns.each { pattern ->
            String suffix = pattern.key
            String type = pattern.value
            BigDecimal confidence = 0.85
            
            if (remaining.endsWith(suffix)) {
                String stem = remaining.substring(0, remaining.length() - suffix.length())
                if (stem && stem.length() > 0) {
                    Morpheme morpheme = new Morpheme(
                        type: "SUFFIX", 
                        value: type,
                        detectedValue: suffix,
                        position: morphemes.size(),
                        confidence: confidence
                    )
                    morphemes << morpheme
                    remaining = stem
                    println("→ Found SUFFIX: ${type} (${suffix})")
                }
            }
        }
        
        return remaining
    }
}

/**
 * Result container for Wi prefix deconstruction
 */
@CompileStatic
class PrefixWiResult {
    String result
    boolean prefixRemoved
    String detectedPrefix
}

/**
 * Result container for Ji prefix deconstruction
 */
@CompileStatic
class PrefixJiResult {
    String result
    boolean prefixRemoved
    String detectedPrefix
    String reason
    
    String getReason() {
        return reason ?: null
    }
}

/**
 * Result container for Reflexive prefix deconstruction
 */
@CompileStatic
class PrefixReflexiveResult {
    String result
    boolean hasReflexive
    String detectedAllomorph
}

/**
 * Result container for deconstruction output
 */
@CompileStatic
class DeconstructionResult {
    String original
    String stem
    List<Morpheme> morphemes
    String error
    boolean success
    
    DeconstructionResult(String original = "", String stem = "", 
                         List<Morpheme> morphemes = null, String error = "", 
                         boolean success = false) {
        this.original = original
        this.stem = stem
        this.morphemes = morphemes ?: [] as ArrayList<Morpheme>
        this.error = error
        this.success = success
    }
    
    @Override
    String toString() {
        StringBuilder sb = new StringBuilder()
        sb.append("=== Deconstruction Result ===\n")
        sb.append("Original: ${original}\n")
        sb.append("Stem: ${stem}\n")
        
        if (error) {
            sb.append("Error: ${error}\n")
            return sb.toString()
        }
        
        if (morphemes && !morphemes.isEmpty()) {
            sb.append("\nExtracted Morphemes:\n")
            morphemes.each { m ->
                sb.append("  [${m.position}] ${m.type}: ")
                if (m.detectedValue) {
                    sb.append("${m.detectedValue} (")
                }
                sb.append("${m.value}")
                if (m.detectedValue) {
                    sb.append(", confidence: ${String.format('%.2f', m.confidence)})\n")
                } else {
                    sb.append(")\n")
                }
            }
        } else {
            sb.append("\nNo morphemes extracted\n")
        }
        
        sb.append("\nConfidence Score: ${calculateOverallConfidence()}\n")
        
        return sb.toString()
    }
    
    private double calculateOverallConfidence() {
        if (!morphemes || morphemes.isEmpty()) {
            return 0.0
        }
        double total = 0.0
        for (Morpheme m : morphemes) {
            total += m.confidence
        }
        return total / morphemes.size()
    }
}

/**
 * Morpheme representation
 */
@CompileStatic
class Morpheme {
    String type
    String value
    String detectedValue
    int position
    BigDecimal confidence
    
    Morpheme(String type = "", String value = "", String detectedValue = "",
             int position = 0, double confidence = 0.0) {
        this.type = type
        this.value = value
        this.detectedValue = detectedValue
        this.position = position
        this.confidence = confidence
    }
    
    @Override
    String toString() {
        return "${type}: ${value}${detectedValue ? ' (' + detectedValue + ')' : ''}"
    }
}
