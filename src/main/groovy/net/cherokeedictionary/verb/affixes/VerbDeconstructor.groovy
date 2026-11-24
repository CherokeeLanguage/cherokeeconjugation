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

    // Initial Prefix instances for deconstruction
    private final PrefixWi prefixWi = new PrefixWi()
    private final PrefixYi prefixYi = new PrefixYi()
    private final PrefixNi prefixNi = new PrefixNi()
    private final PrefixI prefixI = new PrefixI()
    private final PrefixGa prefixGa = new PrefixGa()
    private final PrefixE prefixE = new PrefixE()
    private final PrefixDe prefixDe = new PrefixDe()
    private final PrefixDa prefixDa = new PrefixDa()
    private final PrefixDi prefixDi = new PrefixDi()
    
    // Pronominal prefixes
    private final PrefixJi prefixJi = new PrefixJi()
    
    private final ReflexivePrefix reflexivePrefix = new ReflexivePrefix()
    private final SuffixDeconstructor suffixDeconstructor = new SuffixDeconstructor()

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

        // PHASE 3: Suffixes (outside-in - longest first)
        if (remaining && remaining.length() >= 2) {
            println("\nStep 3: Remove Suffixes")
            remaining = suffixDeconstructor.processAllSuffixes(remaining, verb ?: new Verb(), extractedMorphemes)
        } else {
            println("\nNo suffixes to process (word too short)")
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
            
            // PHASE 1: Initial Prefixes (outside-in processing order)
            // Order matters: more specific patterns first, then general
            
            // 1. Try Wi prefix first
            PrefixWiResult wiResult = prefixWi.deconstructFromSyllabary(remaining, verb)
            if (wiResult.prefixRemoved && wiResult.detectedPrefix) {
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
                println("  Remaining: ${remaining}\n")
            }
            
            // 2. Try Yi prefix (after Wi checked)
            if (!foundPrefix && remaining && remaining.length() > 0) {
                PrefixYiResult yiResult = prefixYi.deconstructFromSyllabary(remaining, verb)
                if (yiResult.prefixRemoved) {
                    String reason = yiResult.getReason()
                    BigDecimal confidence = 0.85
                    if ("fused_into_stem" == reason) {
                        confidence = 0.3
                    }
                    
                    Morpheme morpheme = new Morpheme(
                        type: "INITIAL_PREFIX", 
                        value: "yi", 
                        detectedValue: yiResult.detectedPrefix,
                        position: morphemes.size(),
                        confidence: confidence
                    )
                    morphemes << morpheme
                    remaining = yiResult.result
                    foundPrefix = true
                    
                    if ("fused_into_stem" == reason) {
                        println("→ Detected FUSED yi-: skipping extraction")
                    } else {
                        println("Found YI-: ${yiResult.detectedPrefix}")
                        println("  Remaining: ${remaining}\n")
                    }
                }
            }
            
            // 3. Try Ni prefix
            if (!foundPrefix && remaining && remaining.length() > 0) {
                PrefixNiResult niResult = prefixNi.deconstructFromSyllabary(remaining, verb)
                if (niResult.prefixRemoved && niResult.detectedPrefix) {
                    Morpheme morpheme = new Morpheme(
                        type: "INITIAL_PREFIX", 
                        value: "ni", 
                        detectedValue: niResult.detectedPrefix,
                        position: morphemes.size(),
                        confidence: 0.85
                    )
                    morphemes << morpheme
                    remaining = niResult.result
                    foundPrefix = true
                    println("Found NI-: ${niResult.detectedPrefix}")
                    println("  Remaining: ${remaining}\n")
                }
            }
            
            // 4. Try I prefix
            if (!foundPrefix && remaining && remaining.length() > 0) {
                PrefixIGaDeDaDiResult iResult = prefixI.deconstructFromSyllabary(remaining, verb)
                if (iResult.prefixRemoved) {
                    BigDecimal confidence = 0.85
                    if ("likely_da_compound" == iResult.reason) {
                        confidence = 0.4
                    }
                    
                    Morpheme morpheme = new Morpheme(
                        type: "INITIAL_PREFIX", 
                        value: "i", 
                        detectedValue: iResult.detectedPrefix,
                        position: morphemes.size(),
                        confidence: confidence
                    )
                    morphemes << morpheme
                    remaining = iResult.result
                    foundPrefix = true
                    
                    if ("likely_da_compound" == iResult.reason) {
                        println("→ Likely DA compound, not separate I- prefix")
                    } else {
                        println("Found I-: ${iResult.detectedPrefix}")
                        println("  Remaining: ${remaining}\n")
                    }
                }
            }
            
            // 5. Try Ga prefix
            if (!foundPrefix && remaining && remaining.length() > 0) {
                PrefixIGaDeDaDiResult gaResult = prefixGa.deconstructFromSyllabary(remaining, verb)
                if (gaResult.prefixRemoved) {
                    Morpheme morpheme = new Morpheme(
                        type: "INITIAL_PREFIX", 
                        value: "ga", 
                        detectedValue: gaResult.detectedPrefix,
                        position: morphemes.size(),
                        confidence: 0.85
                    )
                    morphemes << morpheme
                    remaining = gaResult.result
                    foundPrefix = true
                    println("Found GA-: ${gaResult.detectedPrefix}")
                    println("  Remaining: ${remaining}\n")
                }
            }
            
            // 6. Try E prefix
            if (!foundPrefix && remaining && remaining.length() > 0) {
                PrefixIGaDeDaDiResult eResult = prefixE.deconstructFromSyllabary(remaining, verb)
                if (eResult.prefixRemoved) {
                    Morpheme morpheme = new Morpheme(
                        type: "INITIAL_PREFIX", 
                        value: "e", 
                        detectedValue: eResult.detectedPrefix,
                        position: morphemes.size(),
                        confidence: 0.85
                    )
                    morphemes << morpheme
                    remaining = eResult.result
                    foundPrefix = true
                    println("Found E-: ${eResult.detectedPrefix}")
                    println("  Remaining: ${remaining}\n")
                }
            }
            
            // 7. Try De prefix
            if (!foundPrefix && remaining && remaining.length() > 0) {
                PrefixIGaDeDaDiResult deResult = prefixDe.deconstructFromSyllabary(remaining, verb)
                if (deResult.prefixRemoved) {
                    Morpheme morpheme = new Morpheme(
                        type: "INITIAL_PREFIX", 
                        value: "de", 
                        detectedValue: deResult.detectedPrefix,
                        position: morphemes.size(),
                        confidence: 0.85
                    )
                    morphemes << morpheme
                    remaining = deResult.result
                    foundPrefix = true
                    
                    if ("h_contraction" == deResult.reason) {
                        println("→ Found DE- (h-contraction t- → Ꮨ)")
                    } else {
                        println("Found DE-: ${deResult.detectedPrefix}")
                    }
                    println("  Remaining: ${remaining}\n")
                }
            }
            
            // 8. Try Da prefix
            if (!foundPrefix && remaining && remaining.length() > 0) {
                PrefixIGaDeDaDiResult daResult = prefixDa.deconstructFromSyllabary(remaining, verb)
                if (daResult.prefixRemoved) {
                    Morpheme morpheme = new Morpheme(
                        type: "INITIAL_PREFIX", 
                        value: "da", 
                        detectedValue: daResult.detectedPrefix,
                        position: morphemes.size(),
                        confidence: 0.85
                    )
                    morphemes << morpheme
                    remaining = daResult.result
                    foundPrefix = true
                    
                    if ("h_contraction" == daResult.reason) {
                        println("→ Found DA- (h-contraction t- → Ꮨ)")
                    } else if ("vowel_merge_daᏲor_daᏳ" == daResult.reason) {
                        println("→ Found DA- (vowel merge form)")
                    } else {
                        println("Found DA-: ${daResult.detectedPrefix}")
                    }
                    println("  Remaining: ${remaining}\n")
                }
            }
            
            // 9. Try Di prefix
            if (!foundPrefix && remaining && remaining.length() > 0) {
                PrefixIGaDeDaDiResult diResult = prefixDi.deconstructFromSyllabary(remaining, verb)
                if (diResult.prefixRemoved) {
                    Morpheme morpheme = new Morpheme(
                        type: "INITIAL_PREFIX", 
                        value: "di", 
                        detectedValue: diResult.detectedPrefix,
                        position: morphemes.size(),
                        confidence: 0.85
                    )
                    morphemes << morpheme
                    remaining = diResult.result
                    foundPrefix = true
                    println("Found DI-: ${diResult.detectedPrefix}")
                    println("  Remaining: ${remaining}\n")
                }
            }
            
            // 10. Try Ji pronominal prefix
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
                        println("  Remaining: ${remaining}\n")
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
