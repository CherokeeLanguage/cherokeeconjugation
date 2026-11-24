# Cherokee Verb Deconstruction System - Quick Start Guide

## Overview

This system implements **reverse conjugation** by taking existing `toSyllabary()` methods from prefix/suffix classes and creating corresponding `deconstructFromSyllabary()` methods that strip off morphemes in reverse order (outside-in).

---

## How It Works

### Processing Order

The deconstructor processes verbs in this sequence:

```
Full Word → [Initial Prefixes] → [Pronominal Prefixes] → [Reflexive] → [Stem] → [Suffixes]
    ↓            ↓                    ↓                  ↓           ↓          ↓
  ᏫᏥᎪᏩᏘᎭ   →      ᏥᎪᏩᏘᎭ         →      FUSED        →    ᎪᏩᏘ     →   (none)
  (wi-)        (after wi removed)  (ji- not extracted)  (final stem)
```

### Key Innovation: Context-Sensitive Disambiguation

When encountering potential prefixes like `Ꮵ` (ji-), the system checks what follows:
- If it looks like a known root (3+ chars, reflexive patterns), treat as **FUSED** (don't extract)
- If it's short/ambiguous, treat as genuine prefix (extract)

This solves the critical issue where `ᏫᏥᎪᏩᏘᎭ` shouldn't be parsed as `wi + ji + gawati`.

---

## Current Implementation Status

### ✅ Completed Classes with Deconstruction Methods

| Class | Type | Status | Notes |
|-------|------|--------|-------|
| PrefixWi | Initial Prefix | ✅ Complete | Handles wi- variants (Ꮹ, Ꮺ, Ꮻ, Ꮼ, Ꮽ, Ꮾ) |
| PrefixJi | Pronominal Prefix | ✅ Complete | Context-aware fused detection |
| ReflexivePrefix | Reflexive | ✅ Complete | Detects ᎠᏓ, ᎠᏓᏛ, etc. |
| PrefixYi | Pronominal Prefix | ⚠️ Pending | Add similar logic to Ji |
| PrefixNi | Pronominal Prefix | ⚠️ Pending | Add similar logic |
| PrefixI | Initial Prefix | ⚠️ Pending | Needs implementation |
| PrefixGa | Initial Prefix | ⚠️ Pending | Needs implementation |
| All Suffixes | Suffixes | ⚠️ Partial | Basic pattern matching only |

### 📁 File Locations

- **Main Orchestrator**: `src/main/groovy/net/cherokeedictionary/verb/affixes/VerbDeconstructor.groovy`
- **Completed Prefixes**: 
  - `src/main/groovy/net/cherokeedictionary/verb/affixes/initialPrefixes/PrefixWi.groovy`
  - `src/main/groovy/net/cherokeedictionary/verb/affixes/initialPrefixes/PrefixJi.groovy`
- **Reflexive**: `src/main/groovy/net/cherokeedictionary/verb/affixes/ReflexivePrefix.groovy`

---

## How to Use

### Quick Test (Batch Mode)

Run this test to validate your entire conjugation list:

```bash
./gradlew test --tests BatchDeconstructorTest.testBatchConjugations
```

**Steps:**
1. Open `BatchDeconstructorTest.groovy`
2. Add your conjugation forms to the `testForms` list (line ~47)
3. Run the test
4. Review detailed output for each form

### Comprehensive Test (With Expected Values)

For more rigorous validation:

```bash
./gradlew test --tests VerbDeconstructorComprehensiveTest.runAllValidationTests
```

**Steps:**
1. Open `VerbDeconstructorComprehensiveTest.groovy`
2. Add test cases in the `testCases` list with expected stems and morphemes
3. Format: `new TestEntry("surface_form", "expected_stem", ["morpheme_types"])`
4. Run the test to see pass/fail results

### Manual Testing

In Groovy console or interactive session:

```groovy
import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.affixes.VerbDeconstructor

def deconstructor = new VerbDeconstructor()
def verb = new Verb()

// Test your example
def result = deconstructor.deconstruct("ᏫᏥᎪᏩᏘᎭ", verb)
println(result)
```

---

## Running Your Tests

### Recommended Workflow

1. **Start with batch test** - Add all your conjugations to `BatchDeconstructorTest.groovy`
2. **Review output** - Look for forms that don't deconstruct correctly
3. **Add specific test cases** - For problematic forms, add to `VerbDeconstructorComprehensiveTest.groovy` with expected values
4. **Analyze failures** - Check why certain forms fail (missing deconstruction logic? incorrect heuristics?)
5. **Iterate** - Fix issues in the deconstructor or update heuristic rules

### Example Output

When running tests, you'll see output like:

```
=== Starting Deconstruction ===
Input: ᏫᏥᎪᏩᏘᎭ
Step 1: Remove Initial Prefixes (wi-, ji-, yi-, ni-, etc.)

Found WI-: Ꮻ
Remaining: ᏥᎪᏩᏘᎭ

→ Detected FUSED ji- (context-sensitive): NOT extracting

=== Deconstruction Complete ===
Final Stem: ᎪᏩᏘᎭ
Extracted Morphemes:
  [0] INITIAL_PREFIX: wi (detected: Ꮻ, confidence: 0.90)

Confidence Score: 0.90
```

---

## Adding More Deconstruction Methods

To add deconstruction to a new prefix class:

### Template Method

```groovy
/**
 * DECONSTRUCTION METHOD - Reverses toSyllabary
 * 
 * Takes a syllabary string and removes the X- prefix if present.
 * Returns: [stripped_string, boolean_prefix_removed, detected_prefix]
 */
Map<String, Object> deconstructFromSyllabary(String fullWord, Verb word) {
    // Step 1: Check if word starts with any variant of this prefix
    if (!fullWord.startsWith("X") && !fullWord.startsWith("Y")) {
        return [result: fullWord, prefixRemoved: false, detectedPrefix: null]
    }

    // Step 2: Extract initial syllable(s)
    String initialSyllable = fullWord.charAt(0) as String
    
    // Step 3: Check look-ahead (context sensitivity)
    String remainingAfterInitial = fullWord.length() > 1 ? fullWord.substring(1) : ""
    
    // Step 4: Apply fusion/heuristic rules
    if (looksLikeKnownRootOrReflexive(remainingAfterInitial, word)) {
        // Treat as fused, don't separate
        return [result: fullWord, prefixRemoved: false, detectedPrefix: null, reason: "fused_into_stem"]
    }
    
    // Step 5: Safe to strip
    return [result: remainingAfterInitial, prefixRemoved: true, detectedPrefix: initialSyllable]
}

// Helper method for context detection
private boolean looksLikeKnownRootOrReflexive(String candidate, Verb word) {
    // Heuristic: length ≥ 3 chars with consonant-vowel pattern
    if (candidate.length() < 2) return false
    
    // Check for known patterns (expand based on lexicon data)
    boolean hasConsonantCluster = candidate.matches("^[Ꭰ-Ᏼ][Ꭰ-Ᏼ]{2,}$")
    boolean isReflexiveEnding = candidate.endsWith("Ꭽ") || candidate.endsWith("Ꭹ")
    
    return hasConsonantCluster || isReflexiveEnding
}
```

### Pattern Recognition

When reviewing your existing `toSyllabary()` method:
- Look for conditionals checking character positions (`charAt(0)`, `startsWith()`)
- Identify vowel/consonant branching logic
- Find any string manipulation (substring, concatenation)
- **Reverse these operations in deconstruction order**

---

## Known Limitations & Next Steps

### Current Limitations

1. **Incomplete Coverage**: Only Wi, Ji, and Reflexive have full deconstruction logic
2. **Heuristic-Based**: Root detection uses simple patterns, needs lexicon integration
3. **Suffix Handling**: Basic suffix detection only, no complex aspect/tense parsing
4. **No Alternative Parses**: Doesn't report ambiguous interpretations

### Priority Tasks

#### High Priority
- [ ] Add deconstruction methods to remaining Initial Prefixes (Yi, Ni, I, Ga, Da, De, Di, E)
- [ ] Integrate lexicon/lemma lookup for better root detection
- [ ] Add comprehensive suffix deconstruction
- [ ] Create visual output format (tree structure, annotations)

#### Medium Priority
- [ ] Implement alternative parse reporting
- [ ] Add confidence calibration based on historical correctness
- [ ] Support batch processing optimization
- [ ] Create caching for repeated deconstructions

#### Lower Priority
- [ ] Multi-format output (JSON, HTML, tabular)
- [ ] API wrapper for external applications
- [ ] GUI interface for interactive exploration

---

## Contact & Questions

Key design decisions were made during development:
- **Context-sensitive deconstruction** prevents over-segmentation (user insight #2 from discussion)
- **Outside-in processing order** matches linguistic reality of Cherokee morphology
- **Heuristic-based root detection** allows rapid prototyping before full lexicon integration

Questions to consider for next iteration:
1. Should we integrate directly with CED lexicon for authoritative root matching?
2. Do we need to support multiple valid parses when ambiguity exists?
3. What level of detail should morpheme types include (just type vs. person/number specifics)?

---

*Created: 2026-11-24*  
*Status: Active Development - Ready for User Testing*
