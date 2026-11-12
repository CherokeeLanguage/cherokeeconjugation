package net.cherokeedictionary.verb.metadata

import net.cherokeedictionary.core.Verb
import net.cherokeedictionary.util.Tense
import net.cherokeedictionary.verb.rules.categorical.CategoricalRule
import net.cherokeedictionary.verb.rules.categorical.RuleFactory

/**
 * Registry for Verb specific overrides and categorizations.
 * 
 * Each verb can have multiple categories (mixin approach).
 * Default category is NORMAL if none are assigned.
 */
class VerbRegistry {
    static {
        VerbRegistryInitializer.init() // -- tio 11Nov26
    }
    // Map of root to list of categories
    private static final Map<String, List<VerbCategory>> verbCategories = [:]
    
    // Map of root to specific conjugation overrides
    private static final Map<String, Map<String, String>> verbOverrides = [:]

    static void addCategory(String root, VerbCategory category) {
        if (!verbCategories.containsKey(root)) {
            verbCategories[root] = []
        }
        if (!verbCategories[root].contains(category)) {
            verbCategories[root].add(category)
        }
    }

    static List<VerbCategory> getCategories(String root) {
        return verbCategories.getOrDefault(root, [VerbCategory.NORMAL])
    }

    static void registerOverride(String root, String tense, String conjugation) {
        if (!verbOverrides.containsKey(root)) {
            verbOverrides[root] = [:]
        }
        verbOverrides[root][tense] = conjugation
    }

    static String getOverride(String root, String tense) {
        if (root == null) return null
        return verbOverrides.get(root)?.get(tense)
    }

    // Iterates through categories and applies rules
    static String applyCategoricalRules(Verb verb, String conjugation, Tense tense) {
        if (verb == null || verb.root == null) {
            return conjugation
        }
        
        String result = conjugation
        for (VerbCategory category : getCategories(verb.root)) {
            CategoricalRule rule = RuleFactory.getRule(category)
            if (rule) {
                result = rule.apply(verb, result, tense)
            }
        }
        return result
    }
}
