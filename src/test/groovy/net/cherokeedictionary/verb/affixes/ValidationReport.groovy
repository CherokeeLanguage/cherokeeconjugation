package net.cherokeedictionary.verb.affixes

/**
 * Validation report for individual test
 */
class ValidationReport {
    String input
    String expectedStem
    String gotStem
    boolean matches
    List<String> failureReasons
    Object result

    String getFailureReasons() {
        return failureReasons ?: ["No failures"]
    }
}