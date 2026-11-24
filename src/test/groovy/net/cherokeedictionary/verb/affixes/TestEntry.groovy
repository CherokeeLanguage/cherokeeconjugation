package net.cherokeedictionary.verb.affixes

/**
 * Test entry data structure
 */
class TestEntry {
    String input
    String expectedStem
    List<String> expectedMorphemes

    TestEntry(String input, String expectedStem, List<String> expectedMorphemes) {
        this.input = input
        this.expectedStem = expectedStem
        this.expectedMorphemes = expectedMorphemes
    }
}