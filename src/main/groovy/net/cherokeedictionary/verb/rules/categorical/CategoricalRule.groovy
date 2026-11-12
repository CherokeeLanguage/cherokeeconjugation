package net.cherokeedictionary.verb.rules.categorical

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.Tense

/**
 * Interface for category-specific conjugation rules.
 */
interface CategoricalRule {
    String apply(Verb verb, String currentConjugation, Tense tense)
}
