package net.cherokeedictionary.deconstruct;

import net.cherokeedictionary.stem.lemma.FactoredForm;
import net.cherokeedictionary.stem.lemma.Lemmatizer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite to evaluate the effectiveness of the existing Lemmatizer
 * at breaking down conjugated Cherokee verbs.
 * 
 * This test uses known conjugated verbs as ground truth anchors to:
 * 1. Verify Lemmatizer breakdown accuracy
 * 2. Determine if we should reuse Lemmatizer or build a new approach
 * 3. Identify gaps and edge cases
 */
public class VerbDeconstructorTest {

    private Lemmatizer lemmatizer;

    @BeforeEach
    public void setUp() {
        lemmatizer = new Lemmatizer();
    }

    /**
     * Test data: Known conjugated verbs with expected morphological breakdown
     * Format: [surface_form, expected_stem, expected_aspect, expected_prefixes, expected_suffixes]
     */
    private List<TestCase> createTestCases() {
        List<TestCase> testCases = new ArrayList<>();

        // Simple intransitive verbs (baseline tests)
        testCases.add(new TestCase(
            "ᎠᏬᏂ",           // Surface form: "I sleep"
            "ᏬᏂ",             // Expected stem
            "present",         // Expected aspect
            Arrays.asList("Ꭰ"), // Expected prefixes: 1st person singular Set-A
            Collections.emptyList()
        ));

        testCases.add(new TestCase(
            "ᎡᏬᏂ",           // Surface form: "You sleep"
            "ᏬᏂ",
            "present",
            Arrays.asList("Ꭱ"), // 2nd person singular Set-A
            Collections.emptyList()
        ));

        testCases.add(new TestCase(
            "ᎢᏬᏂ",           // Surface form: "He/she sleeps"
            "ᏬᏂ",
            "present",
            Arrays.asList("Ꭲ"), // 3rd person singular Set-A
            Collections.emptyList()
        ));

        testCases.add(new TestCase(
            "ᎣᏬᏂ",           // Surface form: "We sleep"
            "ᏬᏂ",
            "present",
            Arrays.asList("Ꭳ"), // 1st person plural Set-A
            Collections.emptyList()
        ));

        testCases.add(new TestCase(
            "ᎤᏬᏂ",           // Surface form: "They sleep"
            "ᏬᏂ",
            "present",
            Arrays.asList("Ꭴ"), // 3rd person plural Set-A
            Collections.emptyList()
        ));

        testCases.add(new TestCase(
            "ᎥᏬᏂ",           // Surface form: "It sleeps"
            "ᏬᏂ",
            "present",
            Arrays.asList("Ꭵ"), // Neuter Set-A
            Collections.emptyList()
        ));

        // Transitive verbs with object markers
        testCases.add(new TestCase(
            "ᎠᎩᏬᏂᎯ",        // Surface form: "I sleep him"
            "ᏬᏂ",
            "present",
            Arrays.asList("Ꭰ", "Ꭹ"), // 1sgS + 3sgO (fusion)
            Arrays.asList("Ꭿ") // 3rd person object suffix
        ));

        testCases.add(new TestCase(
            "ᏣᏬᏂᎯ",         // Surface form: "You sleep him"
            "ᏬᏂ",
            "present",
            Arrays.asList("Ꮳ"), // 2sgS Set-B
            Arrays.asList("Ꭿ")
        ));

        testCases.add(new TestCase(
            "ᏱᏬᏂᎯ",         // Surface form: "He/she sleeps him/her" (potential ambiguity)
            "ᏬᏂ",
            "present",
            Arrays.asList("Ᏹ"), // Potential Set-B marker
            Arrays.asList("Ꭿ")
        ));

        // Past tense forms
        testCases.add(new TestCase(
            "ᎠᏬᏂᎩ",         // Surface form: "I slept"
            "ᏬᏂ",
            "past",
            Arrays.asList("Ꭰ"),
            Arrays.asList("Ꭹ")
        ));

        testCases.add(new TestCase(
            "ᎤᏬᏂᎩ",         // Surface form: "They slept"
            "ᏬᏂ",
            "past",
            Arrays.asList("Ꭴ"),
            Arrays.asList("Ꭹ")
        ));

        // Habitual forms
        testCases.add(new TestCase(
            "ᎠᏬᏂᎢ",         // Surface form: "I sleep (habitually)"
            "ᏬᏂ",
            "habitual",
            Arrays.asList("Ꭰ"),
            Arrays.asList("Ꭲ")
        ));

        testCases.add(new TestCase(
            "ᎤᏬᏂᎢ",         // Surface form: "They sleep (habitually)"
            "ᏬᏂ",
            "habitual",
            Arrays.asList("Ꭴ"),
            Arrays.asList("Ꭲ")
        ));

        // Immediate future
        testCases.add(new TestCase(
            "ᎠᏬᏂᏳᏍᏗ",      // Surface form: "I will sleep"
            "ᏬᏂ",
            "immediate",
            Arrays.asList("Ꭰ"),
            Arrays.asList("ᏳᏍᏗ")
        ));

        // Forms with directional prefixes
        testCases.add(new TestCase(
            "ᏫᎦᎸᎳᏗ",       // Surface form: "go upward" (example - needs verification)
            "ᎸᎳᏗ",
            "present",
            Arrays.asList("Ꮻ", "Ꭶ"),
            Collections.emptyList()
        ));

        // ⚠️ CONTEXT-SENSITIVE PREFIX DISAMBIGUATION CASES
        // User-provided example: ᏫᏥᎪᏩᏘᎭ
        // This tests the rule: if a potential prefix (like ji-) is followed by what looks 
        // like root/reflexive, we should NOT treat it as independent morpheme
        def testC = new TestCase(
                "ᏫᏥᎪᏩᏘᎭ",      // "I see him/her (in direction)" or similar
                "ᎪᏩᏘ",           // Expected stem (reflexive/see form)
                "present",
                Arrays.asList("Ꮻ"), // Only directional prefix - Ꮵ is NOT separate yi-
                Arrays.asList("Ꭽ")  // Present tense suffix
        )
        testCases.add(testC, "STEM_DISAMBIGUATION_TEST");

        return testCases;
    }

    @Test
    public void testLemmatizerWithKnownSimpleVerbs() {
        List<TestCase> testCases = createTestCases();
        
        // Filter to simple intransitive verbs only
        List<TestCase> simpleTests = testCases.stream()
            .filter({ tc -> tc.expectedSuffixes.isEmpty() && tc.expectedPrefixes.size() == 1 })
            .toList();

        Map<String, Boolean> results = new HashMap<>();

        for (TestCase testCase : simpleTests) {
            String surfaceForm = testCase.surfaceForm;
            
            // Get Lemmatizer output
            String result = lemmatizer.processLine(surfaceForm);
            FactoredForm parsed = parseLemmatizerOutput(result);
            
            // Evaluate
            boolean stemMatch = testCase.expectedStem.equals(parsed.getStem());
            boolean prefixMatch = testCase.expectedPrefixes.containsAll(splitPrefixes(parsed.getPrefixes()));
            boolean suffixMatch = testCase.expectedSuffixes.containsAll(splitSuffixes(parsed.getSuffixes()));
            
            boolean passed = stemMatch && prefixMatch && suffixMatch;
            results.put(surfaceForm, passed);
            
            System.out.println("\n=== Testing: " + surfaceForm + " ===");
            System.out.println("Expected: stem=" + testCase.expectedStem + 
                             ", prefixes=" + testCase.expectedPrefixes + 
                             ", suffixes=" + testCase.expectedSuffixes);
            System.out.println("Lemmatizer got: stem=" + parsed.getStem() +
                             ", prefixes=" + parsed.getPrefixes() +
                             ", suffixes=" + parsed.getSuffixes());
            System.out.println("Result: " + (passed ? "PASS" : "FAIL"));
        }

        // Report overall statistics
        long passedCount = results.values().stream().filter(Boolean.&booleanValue).count();
        System.out.println("\n=== Summary ===");
        System.out.println("Total simple tests: " + simpleTests.size());
        System.out.println("Passed: " + passedCount);
        System.out.println("Failed: " + (simpleTests.size() - passedCount));
        System.out.println("Success rate: " + (passedCount * 100.0 / simpleTests.size()) + "%");
    }

    @Test
    public void testLemmatizerWithTransitiveVerbs() {
        List<TestCase> testCases = createTestCases();
        
        List<TestCase> transitiveTests = testCases.stream()
            .filter({ tc -> !tc.expectedSuffixes.isEmpty() })
            .toList();

        int total = transitiveTests.size();
        int passed = 0;

        System.out.println("\n=== Testing Transitive Verbs ===");

        for (TestCase testCase : transitiveTests) {
            String surfaceForm = testCase.surfaceForm;
            String result = lemmatizer.processLine(surfaceForm);
            FactoredForm parsed = parseLemmatizerOutput(result);

            boolean stemMatch = testCase.expectedStem.equals(parsed.getStem());
            boolean hasCorrectStem = stemMatch;

            System.out.println("\nTesting: " + surfaceForm);
            System.out.println("  Expected stem: " + testCase.expectedStem);
            System.out.println("  Got stem: " + parsed.getStem());
            System.out.println("  Stem match: " + hasCorrectStem);
            
            // Also check prefixes/suffixes
            if (!hasCorrectStem) {
                System.out.println("  FAIL - Stem mismatch!");
            } else {
                System.out.println("  PASS - Stem correct");
                passed++;
            }
        }

        System.out.println("\nTransitive verb summary: " + passed + "/" + total + " correct on stem extraction");
    }

    @Test
    public void testLemmatizerWithPastTense() {
        List<TestCase> testCases = createTestCases();
        
        List<TestCase> pastTests = testCases.stream()
            .filter({ tc -> "past".equals(tc.expectedAspect) })
            .toList();

        System.out.println("\n=== Testing Past Tense Forms ===");

        for (TestCase testCase : pastTests) {
            String surfaceForm = testCase.surfaceForm;
            String result = lemmatizer.processLine(surfaceForm);
            FactoredForm parsed = parseLemmatizerOutput(result);

            System.out.println("\nSurface: " + surfaceForm);
            System.out.println("  Expected: " + testCase.expectedStem + " + past marker");
            System.out.println("  Lemmatizer stem: " + parsed.getStem());
            System.out.println("  Lemma: " + parsed.getLemma());
            System.out.println("  Prefixes: " + parsed.getPrefixes());
            System.out.println("  Suffixes: " + parsed.getSuffixes());

            assertTrue(testCase.expectedStem.equals(parsed.getStem()), 
                      "Stem should be " + testCase.expectedStem + " for " + surfaceForm);
        }
    }

    @Test
    public void testLemmatizerWithHabitualForms() {
        List<TestCase> testCases = createTestCases();
        
        List<TestCase> habitualTests = testCases.stream()
            .filter({ tc -> "habitual".equals(tc.expectedAspect) })
            .toList();

        System.out.println("\n=== Testing Habitual Forms ===");

        for (TestCase testCase : habitualTests) {
            String surfaceForm = testCase.surfaceForm;
            String result = lemmatizer.processLine(surfaceForm);
            FactoredForm parsed = parseLemmatizerOutput(result);

            System.out.println("\nSurface: " + surfaceForm);
            System.out.println("  Expected: " + testCase.expectedStem + " + habitual marker (-Ꭲ)");
            System.out.println("  Lemmatizer stem: " + parsed.getStem());
            System.out.println("  Suffixes: " + parsed.getSuffixes());

            assertTrue(testCase.expectedStem.equals(parsed.getStem()), 
                      "Stem should be " + testCase.expectedStem + " for " + surfaceForm);
        }
    }

    @Test
    public void testLemmatizerEdgeCases() {
        // Test forms that might be ambiguous or challenging
        
        System.out.println("\n=== Testing Edge Cases ===");

        // Test case: forms that could have multiple parses
        String[] edgeCases = [
            "ᎠᎩᏬᏂᎯ",    // Could potentially be parsed differently
            "ᏣᎩᏬᏂᎯ",   // Complex prefix combination
            "ᎢᏃᏯᏙᏓ"     // Directional + habitual combination (example)
        ]

        for (String surfaceForm : edgeCases) {
            try {
                String result = lemmatizer.processLine(surfaceForm);
                FactoredForm parsed = parseLemmatizerOutput(result);

                System.out.println("\nEdge case: " + surfaceForm);
                System.out.println("  Result: " + result);
                System.out.println("  Stem: " + parsed.getStem());
                System.out.println("  Lemma: " + parsed.getLemma());
                
                assertNotNull(parsed.getStem(), "Stem should not be null");
            } catch (Exception e) {
                System.out.println("\nEdge case FAILED: " + surfaceForm);
                System.out.println("  Error: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }

    /**
     * TEST: Context-Sensitive Prefix Disambiguation
     * 
     * This tests the user's insight: if a potential prefix (like Ꮵ/ji-) is followed by
     * what looks like root or reflexive stem, we should NOT treat it as an independent morpheme.
     * 
     * Rule: "If the next character sequence matches known root/reflexive patterns, 
     * then the previous prefix candidate is actually fused into the stem."
     * 
     * Example: ᏫᏥᎪᏩᏘᎭ
     * - Surface analysis might suggest: Ꮻ + Ꮵ + ᎪᏩᏘᎭ
     * - But if ᎪᏩᏘ- is a known reflexive root, then Ꮵ is part of that root, not separate yi-
     */
    @Test
    public void testContextSensitivePrefixDisambiguation() {
        System.out.println("\n=== Testing Context-Sensitive Prefix Disambiguation ===");
        
        // Test case from user: ᏫᏥᎪᏩᏘᎭ
        String surfaceForm = "ᏫᏥᎪᏩᏘᎭ";
        String result = lemmatizer.processLine(surfaceForm);
        FactoredForm parsed = parseLemmatizerOutput(result);

        System.out.println("\nSurface form: " + surfaceForm);
        System.out.println("Lemmatizer output: " + result);
        System.out.println("  Stem extracted: " + parsed.getStem());
        System.out.println("  Prefixes found: " + parsed.getPrefixes());
        System.out.println("  Suffixes found: " + parsed.getSuffixes());

        // Expected correct deconstruction:
        // Ꮻ (directional) + ᎪᏩᏘᎭ (stem with reflexive marking, NOT Ꮵ + ᎪᏩᏘᎭ)
        
        boolean hasDirectional = parsed.getPrefixes().contains("Ꮻ") || parsed.getPrefixes().startsWith("Ꮻ-");
        String actualStem = parsed.getStem();
        
        // The key question: Did Lemmatizer correctly identify that Ꮵ is part of the stem?
        if (actualStem.startsWith("Ꮵ")) {
            System.out.println("\n⚠️ POTENTIAL ISSUE: Stem starts with 'Ꮵ' suggesting it wasn't recognized as fusional");
            System.out.println("   Current analysis treats this as: [prefixes] + Ꮵ + ᎪᏩᏘᎭ");
            System.out.println("   Should be: Ꮻ + ᎪᏩᏘᎭ (where ᎪᏩᏘ is reflexive stem)");
        } else {
            System.out.println("\n✓ Stem appears to have been correctly extracted without leading Ꮵ");
        }

        // Document the rule being tested:
        System.out.println("\n--- RULE BEING TESTED ---");
        System.out.println("IF potential_prefix == Ꮵ AND next_sequence_matches_known_root THEN");
        System.out.println("  Treat Ꮵ as FUSED into stem, NOT as independent yi-");
        System.out.println("ELSE IF potential_prefix == Ꮵ AND next_sequence_is_ambiguous THEN");
        System.out.println("  Keep as separate yi- prefix (Set-B marker)");
        
        // Store for later analysis
        System.out.println("\n=== RESULT FOR LATER REVIEW ===");
        System.out.println("surface: " + surfaceForm);
        System.out.println("lemmatizer_stem: " + actualStem);
        System.out.println("lemmatizer_prefixes: " + parsed.getPrefixes());
        System.out.println("expected_stem: ᎪᏩᏘ");
        System.out.println("expected_prefixes: Ꮻ");
    }

    /**
     * Extended test for multiple context-sensitive cases
     */
    @Test
    public void testMultipleFusionScenarios() {
        System.out.println("\n=== Testing Multiple Fusion Scenarios ===");
        
        // These are cases where we need to check if a prefix-like sequence is actually root
        String[] scenarios = [
            "ᏫᏥᎪᏩᏘᎭ",      // User example: directional + reflexive
            "ᏓᏁᎳ",          // Possibly da-nela vs da-ne-la (need lexicon lookup)
            "ᎠᏍᏆᏂ"         // Could be a-s-guani or a-squani
        ]

        for (String surface : scenarios) {
            String result = lemmatizer.processLine(surface);
            FactoredForm parsed = parseLemmatizerOutput(result);
            
            System.out.println("\nInput: " + surface);
            System.out.println("  Lemmatizer stem: " + parsed.getStem());
            System.out.println("  Lemmatizer prefixes: " + parsed.getPrefixes());
            System.out.println("  Raw output: " + result);
        }
    }

    /**
     * Parse the Lemmatizer's pipe-separated output format
     * Format: surface|lemma|prefixes|suffixes
     */
    private FactoredForm parseLemmatizerOutput(String line) {
        FactoredForm ff = new FactoredForm();
        
        String[] parts = line.split("\\|");
        if (parts.length >= 4) {
            ff.setSurfaceForm(parts[0]);
            ff.setLemma(parts[1]);
            ff.setPrefixes(parts[2]);
            ff.setSuffixes(parts[3]);
        }
        
        // Try to extract stem from lemma by removing aspect markers
        // This is where we'd need to know aspect-to-suffix mappings
        ff.setStem(extractStemFromLemma(ff.getLemma()));
        
        return ff;
    }

    /**
     * Helper to split prefix string into list
     * Prefixes are typically stored as "prefix1-prefix2-" (trailing hyphen)
     */
    private List<String> splitPrefixes(String prefixString) {
        List<String> prefixes = new ArrayList<>();
        if (prefixString == null || prefixString.isEmpty()) {
            return prefixes;
        }
        
        // Remove trailing hyphen if present
        String clean = prefixString.endsWith("-") ? prefixString.substring(0, prefixString.length() - 1) : prefixString;
        
        // Split on hyphens
        String[] parts = clean.split("-");
        for (String part : parts) {
            if (!part.isEmpty()) {
                prefixes.add(part);
            }
        }
        
        return prefixes;
    }

    /**
     * Helper to split suffix string into list
     * Suffixes are typically stored as "-suffix1-suffix2"
     */
    private List<String> splitSuffixes(String suffixString) {
        List<String> suffixes = new ArrayList<>();
        if (suffixString == null || suffixString.isEmpty()) {
            return suffixes;
        }
        
        // Remove leading hyphen if present
        String clean = suffixString.startsWith("-") ? suffixString.substring(1) : suffixString;
        
        // Split on hyphens
        String[] parts = clean.split("-");
        for (String part : parts) {
            if (!part.isEmpty()) {
                suffixes.add(part);
            }
        }
        
        return suffixes;
    }

    /**
     * Extract stem from lemma by removing common aspect suffixes
     * This is a simplified version - actual implementation would need complete mapping
     */
    private String extractStemFromLemma(String lemma) {
        if (lemma == null || lemma.isEmpty()) {
            return "";
        }
        
        // Common aspect suffixes to strip (this needs expansion based on testing)
        String[] aspectSuffixes = ["Ꭹ", "Ꭲ", "ᏳᏍᏗ", "Ꮎ", "ᎢᏳ", "Ꭽ"]
        
        String stem = lemma;
        for (String suffix : aspectSuffixes) {
            if (stem.endsWith(suffix)) {
                stem = stem.substring(0, stem.length() - suffix.length());
                break;
            }
        }
        
        return stem;
    }

    /**
     * Test case data structure
     */
    private static class TestCase {
        String surfaceForm;
        String expectedStem;
        String expectedAspect;
        List<String> expectedPrefixes;
        List<String> expectedSuffixes;

        public TestCase(String surfaceForm, String expectedStem, String expectedAspect,
                       List<String> expectedPrefixes, List<String> expectedSuffixes) {
            this.surfaceForm = surfaceForm;
            this.expectedStem = expectedStem;
            this.expectedAspect = expectedAspect;
            this.expectedPrefixes = expectedPrefixes;
            this.expectedSuffixes = expectedSuffixes;
        }
    }
}
