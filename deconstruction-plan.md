# Cherokee Verb Deconstruction System - Implementation Plan

## Overview

This document outlines the plan for implementing a **verb deconstruction system** that reverses the conjugation process. While conjugation builds outward from the center (root + aspect → add affixes), deconstruction works inward from the outside (full word → remove affixes → root + aspect).

---

## Current Architecture Understanding

### What Exists Already

1. **`FactoredForm`** (`net.cherokeedictionary.stem.lemma.FactoredForm`)
   - Stores: surface form, lemma, stem, prefixes, suffixes
   - Has `addPrefix()` and `addSuffix()` methods
   - Used by Lemmatizer for extraction

2. **`Lemmatizer`** (`net.cherokeedictionary.stem.lemma.Lemmatizer`)
   - Performs deconstruction using regex patterns
   - Extracts suffixes first, then prefixes
   - Uses `PatternMatchReplacement` rules
   - Output format: `surface|lemma|prefixes|suffixes`

3. **`NormalizedVerbEntry`** (`net.cherokeedictionary.stem.NormalizedVerbEntry`)
   - Contains all 6 conjugation forms: `pres3`, `pres1`, `past`, `imm`, `habit`, `imp`, `inf`
   - Has helper methods like `removeᏫprefix()`, `removeᏕprefix()`, etc.
   - These are used during normalization/decomposition

4. **`PatternMatchReplacement`** (`net.cherokeedictionary.stem.lemma.PatternMatchReplacement`)
   - Contains `regex_match`, `match[]`, `replacement[]` arrays
   - Used for pattern-based morpheme extraction

### How Conjugation Works (Center → Outward)

Based on the architecture:
- Start with: **stem + aspect + lexeme-specific rules**
- Add person markers (Set-A and Set-B prefixes)
- Add directional/tam markers
- Apply fusion/contraction rules
- Output: Full conjugated verb in syllabary

---

## Deconstruction Design: Outside → Inward

### Core Principle

**Input**: One conjugated Cherokee verb string (syllabary)  
**Output**: Structured object containing:
- Root/stem
- Aspect/mode marker
- All identified prefixes (in order)
- All identified suffixes (in order)
- Person/number/gender information (if determinable)
- Lexeme lookup key (optional)

---

## Proposed Architecture

### 1. Entry Point: `VerbDeconstructor` Class

```java
public class VerbDeconstructor {
    /**
     * Deconstruct a single Cherokee verb form.
     * Note: This is the primary API for MVP - starts with singular, batch support comes later.
     * @param input Surface form in syllabary
     * @return DeconstructedVerb object with structured data (most likely parse)
     */
    public DeconstructedVerb deconstruct(String input);
    
    /**
     * Deconstruct multiple verbs at once. (Future enhancement - not in initial release)
     * @param inputs Array of verb forms
     * @return List of DeconstructedVerb objects
     */
    public List<DeconstructedVerb> deconstructAll(String[] inputs);
}
```

### 2. Data Model: `DeconstructedVerb` Class

```java
public class DeconstructedVerb {
    // Original input
    private String surfaceForm;
    
    // Core components
    private String stem;              // Root consonant+vowel skeleton
    private String aspect;            // Aspect marker (e.g., present, past, habitual)
    private String lemma;             // Dictionary form (if determinable)
    
    // Morphological breakdown
    private List<String> prefixes;    // Ordered list of prefixes from outside-in
    private List<String> suffixes;    // Ordered list of suffixes
    
    // Derived information
    private String personMarkerA;     // Set-A pronoun prefix (subject)
    private String personMarkerB;     // Set-B pronoun prefix (object)
    private String directionMarker;   // Directional/templatic marker
    private String toneMarker;        // Tone/vowel length indicators
    
    // Classification
    private StemType stemType;        // PresentContinuous, RemotePast, etc.
    private boolean isTransitive;     // Whether it has an object marker
    private String lexemeKey;         // Lookup key into verbLexemes.json
    
    // Likelihood weights for ambiguity handling
    private List<Double> prefixLikelihoods;   // Weights for each prefix
    private List<Double> suffixLikelihoods;   // Weights for each suffix
    private double overallLikelihood;         // Overall parse confidence (0.0-1.0)
    
    // For alternative parsings when ambiguous
    private List<DeconstructedVerb> alternativeParses;  // Less likely interpretations
    
    // Getters...
}
```

### 3. Core Data Model with toString() Output

For the MVP, we'll focus on a clean textual representation via `toString()` rather than multiple display strategies upfront. Display types can be added later using the Strategy Pattern if needed.

#### `DeconstructedVerb.toString()` Format

```java
@Override
public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("Surface: ").append(surfaceForm).append("\n");
    sb.append("Stem: ").append(stem).append("\n");
    sb.append("Aspect: ").append(aspect).append("\n");
    
    if (!prefixes.isEmpty()) {
        sb.append("Prefixes:\n");
        for (int i = 0; i < prefixes.size(); i++) {
            sb.append("  ").append(i + 1).append(". ").append(prefixes.get(i));
            if (prefixLikelihoods != null && i < prefixLikelihoods.size()) {
                double weight = prefixLikelihoods.get(i);
                sb.append(" (").append(String.format("%.2f", weight)).append(")\n");
            } else {
                sb.append("\n");
            }
        }
    }
    
    if (!suffixes.isEmpty()) {
        sb.append("Suffixes:\n");
        for (int i = 0; i < suffixes.size(); i++) {
            sb.append("  ").append(i + 1).append(". ").append(suffixes.get(i));
            if (suffixLikelihoods != null && i < suffixLikelihoods.size()) {
                double weight = suffixLikelihoods.get(i);
                sb.append(" (").append(String.format("%.2f", weight)).append(")\n");
            } else {
                sb.append("\n");
            }
        }
    }
    
    return sb.toString();
}
```

Example Output:
```
Surface: ᎠᎩᏬᏂᎯ
Stem: ᏬᏂ
Aspect: present
Prefixes:
  1. Ꭰ- (0.95)
  2. -Ꭹ (0.87)
Suffixes:
  1. -Ꭿ (0.92)
```

Alternative parse when ambiguous:
```
Surface: ᎠᎩᏬᏂᎯ
Stem: ᏬᏂ
Aspect: present
--- Alternative Parsing (likelihood: 0.23) ---
Prefixes:
  1. Ꭰ- (0.35)
  2. -Ꭹ (0.28)
Suffixes:
  1. -Ꭿ (0.60)
```

#### Handling Ambiguity with Weights

Each morpheme identification includes a likelihood score (0.0 to 1.0):
- **Higher weights** indicate more confident parses
- **Multiple parses**: If ambiguity exists, all alternatives shown with overall parsing likelihood
- **Sorting**: Most likely parse appears first in multi-parse scenarios

---

## Implementation Phases

### Phase 1: Core Deconstruction Engine

**Goal**: Extract morphemes from conjugated forms

**Steps**:
1. Create `DeconstructedVerb` data model class
2. Port existing prefix removal logic from `NormalizedVerbEntry` to work bidirectionally
3. Create `VerbDeconstructor` class with basic deconstruction logic
4. Implement reverse operations of conjugation rules:
   - Remove Set-A prefixes (Ꭰ-, Ꭱ-, Ꭲ-, Ꭳ-, Ꭴ-, Ꭵ-)
   - Remove Set-B prefixes (Ꮣ-, Ꮥ-, Ꮧ-, Ꮪ-, Ꮫ-, Ꮭ-, etc.)
   - Handle fusion cases (Ꮻ→Ꭿ, Ꮒ→Ꮎ, etc.)
   - Identify aspect markers (Ꮎ, Ꭲ, ᎢᏳ, etc.)
5. Extract stem using existing suffix removal rules from `Lemmatizer`

**Integration Points**:
- Reuse `PatternMatchReplacement` infrastructure
- Leverage existing `normalizedVerbEntry.remove*Prefix()` methods
- Use `Syllabary` mappings for roman/syllabary conversion

---

### Phase 2: Display Strategies

**Goal**: Implement multiple output formats via Strategy Pattern

**Steps**:
1. Define `DeconstructionDisplay` interface
2. Implement `TreeDisplay` (hierarchical visualization)
3. Implement `LinearDisplay` (flat annotated form)
4. Implement `JsonDisplay` (machine-readable)
5. Implement `LinguisticDisplay` (morpheme-level detail)
6. Create `DeconstructionDisplayFactory` with factory method

**Deliverables**:
- Working display strategies
- Unit tests for each format
- Example outputs for common verbs

---

### Phase 3: Integration & API

**Goal**: Provide clean one-in-one-out API

**Steps**:
1. Expose `VerbDeconstructor.deconstruct(String)` as public API
2. Add optional parameter for display type
3. Create convenience overloads:
   ```java
   public static DeconstructedVerb deconstruct(String verb)
   public static String deconstructAndFormat(String verb, DisplayType type)
   public static <T> T deconstructWithStrategy(String verb, DeconstructionDisplay strategy)
   ```
4. Add validation and error handling
5. Document API usage examples

---

### Phase 4: Advanced Features (Optional)

**Potential Enhancements**:
1. **Lexeme lookup**: Match extracted stem to `verbLexemes.json` for dictionary definitions
2. **Ambiguity detection**: Flag cases where multiple analyses possible
3. **Confidence scoring**: Indicate how certain each morpheme identification is
4. **Alternative parses**: Return multiple possible decompositions when ambiguous
5. **Comparison mode**: Show relationship between conjugated forms (all persons of same verb)
6. **Export options**: JSON, XML, CSV, Word-compatible formats

---

## Key Technical Challenges & Solutions

### Challenge 1: Prefix Fusion

Cherokee has extensive prefix fusion (e.g., `da + agi → Ꭹ`, `ni + a → Ꮎ`)

**Solution**: 
- Maintain fusion tables mapping fused forms to components
- Use context-aware matching (e.g., if following stem starts with vowel, certain fusions likely)
- Store both fused and component representations

### Challenge 2: Ambiguous Morpheme Boundaries

Some sequences could be parsed multiple ways

**Solution**:
- Implement priority ordering (longer matches first, more specific rules first)
- Track alternative parsings
- Use lexical knowledge (`verbLexemes.json`) to disambiguate

### Challenge 3: Context-Sensitive Prefix Disambiguation ⭐ NEW

Pattern: When a potential prefix (like Ꮵ/ji-) is followed by what appears to be a root or reflexive stem, it may be **fused into the root** rather than being an independent morpheme.

**Example**: ᏫᏥᎪᏩᏘᎭ
```
Incorrect analysis:    Ꮻ + Ꮵ + ᎪᏩᏘᎭ
Correct analysis:      Ꮻ + ᎪᏩᏘᎭ  (where ᎪᏩᏘ is reflexive, Ꮵ is fused)
```

**Solution - User's Rule**:
> "If we see a potential prefix but the next characters match a known root/reflexive pattern, then that 'prefix' is actually part of the stem."

**Implementation Strategy**:
1. Build list of known Cherokee verb roots (from lexicon)
2. Build list of known reflexive stems
3. When analyzing surface form:
   ```
   Step 1: Extract obvious directional prefixes (Ꮻ-, Ꭲ-, Ᏹ-)
   Step 2: Check if remaining form starts with potential prefix (Ꮵ, Ꮣ, etc.)
   Step 3: Look ahead: does next sequence match known root?
       IF YES → treat as fused, don't separate prefix
       IF NO → keep as independent prefix candidate
   ```

**Test Coverage**:
- `testContextSensitivePrefixDisambiguation()` in VerbDeconstructorTest
- Specific test case: ᏫᏥᎪᏩᏘᎭ → expect stem="ᎪᏩᏘ", not "ᏥᎪᏩᏘ"

---

## Testing Strategy

### Test Cases

1. **Simple transitive verbs**:
   - Input: `ᎠᎩᏬᏂᎯ` ("I sleep him")
   - Expected: 1sgS + 3sgO + present + stem(ᏬᏂ)

2. **Intransitive verbs**:
   - Input: `ᎠᏬᏂ` ("I sleep")
   - Expected: 1sgS + present + stem(ᏬᏂ)

3. **Reflexive/causative**:
   - Input: Variations with ᏍᏓ- or ᏅᏙ- prefixes

4. **Directional verbs**:
   - Input: Verbs with Ꮻ-, Ᏹ-, Ꭲ- directionals

5. **Complex fusions**:
   - Input: Forms with multiple fused prefixes

### Test Generation Strategy

**Primary approach**: Start with known conjugated verbs, then add prefixes/suffixes to create test cases for Lemmatizer/Stemmer validation:

1. **Base form extraction**: Identify clean verb stems from lexicon
2. **Constructive testing**: 
   - Take a known stem + aspect
   - Add prefixes according to paradigm tables
   - Verify Lemmatizer correctly strips them back
   
3. **Round-trip verification**: 
   ```
   Conjugate(stem + aspect) → full form
   Deconstruct(full form) → should recover stem + aspect
   ```

### Known Endpoint Tests

Use these as ground truth anchors:

| Test Type | Known Form | Expected Components |
|-----------|-----------|---------------------|
| Simple intransitive | `ᎠᏬᏂ` | 1sgS + ᏬᏂ(stem) + present |
| Transitive 1-3 | `ᎠᎩᏬᏂᎯ` | 1sgS + 3sgO + ᏬᏂ + present |
| Transitive 2-3 | `ᏣᏬᏂᎯ` | 2sgS + 3sgO + ᏬᏂ + present |
| Present habitual | `ᎤᏬᏂᎢ` | 3sg + ᏬᏂ + habitual |
| Past tense | `ᎠᏬᏂᎩ` | 1sgS + ᏬᏂ + past |

### Validation Approach

- **Prefix/Suffix stripping accuracy**: Measure how many morphemes correctly identified
- **Ambiguity handling**: All alternative parses shown with likelihood weights
- **Weight calibration**: Ensure likelihood scores correlate with actual correctness
- **Compare against existing `Lemmatizer` output**: Leverage its proven suffix extraction
- **Validate against known paradigms**: Use language guide paradigms as reference
- **Cross-check with CED**: Match lexeme keys to dictionary entries

---

## File Structure (Proposed)

```
src/main/java/net/cherokeedictionary/deconstruction/
├── VerbDeconstructor.java          # Main entry point (singular + batch)
├── DeconstructedVerb.java          # Data model with likelihood weights
│
├── analysis/                       # Core analysis logic
│   ├── PrefixAnalyzer.java         # Strip prefixes outside-in
│   ├── SuffixAnalyzer.java         # Strip suffixes using Lemmatizer patterns
│   ├── StemExtractor.java          # Extract root from remaining form
│   └── PersonMarkerResolver.java   # Identify Set-A/Set-B markers
│
├── data/                           # Supporting data
│   └── FusionTable.java            # Prefix fusion mappings & likelihoods
│
└── exceptions/                     # Custom exceptions
    └── DeconstructionException.java
```

**Future additions** (optional, if multiple display formats needed):
```
├── displays/                       # Strategy implementations (deferred)
│   └── DisplayStrategy.java        # Interface for output formats
└── factory/                        # Factory for display creation
```

---

## Relationship to Existing Code

### What to Reuse

- ✅ `FactoredForm` - Can be used as intermediate representation
- ✅ `PatternMatchReplacement` - Rule definition mechanism
- ✅ `Lemmatizer.suffix_matches/replacements` - Suffix extraction patterns
- ✅ `NormalizedVerbEntry.remove*Prefix()` methods - Prefix stripping logic
- ✅ `Syllabary` - Character encoding utilities
- ✅ `StemType` enum - Aspect categorization

### What to Extend

- ⚠️ `NormalizedVerbEntry` - Currently only goes one way (conjugation normalization)
  - Consider adding bidirectional methods or creating mirror class
- ⚠️ `Lemmatizer` - Currently focused on lemma extraction only
  - Could enhance to expose full morphological analysis

### What's New

- ✨ `DeconstructedVerb` - Complete morphological data structure with likelihood weights
- ✨ Plain text `toString()` output (display strategies deferred to future iteration)
- ✨ Clean one-in-one-out API (`deconstruct(String)` as primary entry point)
- ✨ Ambiguity handling with alternative parses and confidence scores

---

## Usage Examples

### Basic Usage

```java
VerbDeconstructor deconstructor = new VerbDeconstructor();
DeconstructedVerb result = deconstructor.deconstruct("ᎠᎩᏬᏂᎯ");

// Access components
System.out.println(result.getStem());           // "ᏬᏂ"
System.out.println(result.getAspects());        // "present"
System.out.println(result.getPersonMarkerA());  // "1sg"
System.out.println(result.getPersonMarkerB());  // "3sg"
```

### With Specific Display

```java
// Tree view
String tree = DeconstructionDisplayFactory.format(result, DisplayType.TREE);
// Output: hierarchical tree structure

// JSON output
String json = DeconstructionDisplayFactory.format(result, DisplayType.JSON);
// Output: {"surface":"ᎠᎩᏬᏂᎯ","stem":"ᏬᏂ",...}

// Linear annotation
String linear = DeconstructionDisplayFactory.format(result, DisplayType.LINEAR);
// Output: "[Ꭰ-Ꭹ]-[ᏬᏂ]-[Ꭿ]"
```

### With Custom Strategy

```java
DeconstructedVerb verb = deconstructor.deconstruct("ᎠᎩᏬᏂᎯ");
CustomDisplay myStrategy = new CustomDisplay();
String customOutput = myStrategy.format(verb);
```

---

## Key Decisions Made (From Initial Review)

The following points have been clarified based on initial feedback:

1. ✅ **Display types**: Deferred for future iteration - start with plain text `toString()` output only
2. ✅ **Testing approach**: Use known conjugated verbs as anchors, then add prefixes/suffixes to test Lemmatizer/Stemmer accuracy  
3. ✅ **API scope**: Start with singular verb deconstruction; batch support added in Phase 2
4. ✅ **Ambiguity handling**: Show all alternative parses with likelihood weights, most likely first

---

## Remaining Questions for Discussion

Before implementation begins, please review these questions:

1. **Scope**: Should deconstruction handle all conjugation types or start with a subset?
2. **Lexeme integration**: How much should we rely on `verbLexemes.json` for disambiguation?
3. **Error handling**: Should ambiguous cases throw exceptions, return null, or provide alternatives?
4. **Performance**: Do we need caching for frequently-deconstructed verbs?
5. **API design**: Should we use builder pattern for constructing complex queries?
6. **Testing resources**: Do you have access to complete conjugation paradigms for test cases?
7. **Likelihood calibration**: What methodology should we use to calculate morpheme identification confidence scores?

---

## Immediate Next Steps (Testing First Approach)

Based on recent discussions, we'll start by validating the existing Lemmatizer:

### Step 0: Lemmatizer Effectiveness Testing ⭐ CURRENT PHASE
- ✅ Created `VerbDeconstructorTest.java` with known verb anchors
- Run test suite to collect data on Lemmatizer accuracy
- Analyze which morphemes are correctly/incorrectly extracted
- **Decision point**: Based on results, choose:
  - Option A: Reuse/improve Lemmatizer (if >80% accurate)
  - Option B: Build new approach from scratch (if significant gaps found)

### Step 1: Core Engine Development
- Implement `VerbDeconstructor` using chosen approach
- Build `DeconstructedVerb` data model
- Create plain text `toString()` output
- Focus on most common conjugation patterns first

### Step 2: Validation & Refinement
- Expand test cases based on initial findings
- Calibrate likelihood weights
- Optimize prefix/suffix ordering logic

### Step 3: Future Enhancements
- Batch processing support
- Optional display strategies (Strategy Pattern)
- Advanced features (lexeme lookup, ambiguity reporting)

---

*Document updated: 2026-11-24*  
*Status: Ready for testing with known conjugated verbs*

---

*Document created: 2026-11-24*  
*Status: Ready for review and discussion*
