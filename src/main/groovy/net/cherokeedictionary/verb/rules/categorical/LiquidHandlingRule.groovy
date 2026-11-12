package net.cherokeedictionary.verb.rules.categorical

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.Tense

/**
 * Categorical rule for liquid handling verbs.
 * Placeholder implementation for future guide-specific logic. -- tio 11Nov26
 */
class LiquidHandlingRule implements CategoricalRule {
    @Override
    String apply(Verb verb, String currentConjugation, Tense tense) {
        // Logic will be added here once we audit the specific grammar rule.
        return currentConjugation
    }
}
