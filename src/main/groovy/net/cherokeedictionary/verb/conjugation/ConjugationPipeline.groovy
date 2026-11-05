package net.cherokeedictionary.verb.conjugation

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.verb.rules.ConjugationRule

/**
 * Orchestrates the application of conjugation rules in a defined sequence.
 */
class ConjugationPipeline {
    private final List<ConjugationRule> rules = []

    def addRule(ConjugationRule rule) {
        rules.add(rule)
        return this
    }

    Verb execute(Verb verb) {
        for (ConjugationRule rule : rules) {
            verb = rule.apply(verb)
        }
        return verb
    }
}
