package net.cherokeedictionary.verb.rules.categorical

import net.cherokeedictionary.verb.metadata.VerbCategory

/**
 * Factory to retrieve the appropriate categorical rule. -- tio 11Nov26
 */
class RuleFactory {
    private static final Map<VerbCategory, CategoricalRule> rules = [
        (VerbCategory.LIQUID_HANDLING): new LiquidHandlingRule()
        // Add other category rules here as implemented
    ]

    static CategoricalRule getRule(VerbCategory category) {
        return rules[category]
    }
}
