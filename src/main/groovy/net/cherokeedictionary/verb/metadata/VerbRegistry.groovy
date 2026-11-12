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

    // tio 12Nov26: the bridge. Categories/overrides are LOOKED UP by Cherokee
    // root (VerbConjugationProcessor sets verb.root = bare stem minus tense
    // ending, e.g. "gowati" for To See PRESENT), but the taxonomy seeds read
    // like the verb book (English names). nameIndex maps the English name to
    // its engine-verified root(s); registering a name re-keys anything already
    // filed under that English name onto the root so both views work.
    private static final Map<String, String> nameIndex = [:]

    // tio 12Nov26: English names seeded without a verified root. Kept visible
    // (project rule: missing data stays visible) until the category audit
    // supplies engine-verified roots -- never silently dropped.
    private static final List<String> unresolvedNames = []

    static void addCategory(String root, VerbCategory category) {
        if (!verbCategories.containsKey(root)) {
            verbCategories[root] = []
        }
        if (!verbCategories[root].contains(category)) {
            verbCategories[root].add(category)
        }
    }

    /** Indexes an English verb name to an engine-verified root and re-keys its data. -- tio 12Nov26 */
    static void registerVerbName(String englishName, String root) {
        if (!englishName || !root) return
        nameIndex[englishName.toLowerCase()] = root
        unresolvedNames.removeAll { it.equalsIgnoreCase(englishName) }
        // re-key anything seeded under the English name onto the root
        List<VerbCategory> cats = verbCategories[englishName]
        cats?.each { addCategory(root, it) }
        Map<String, String> overrides = verbOverrides[englishName]
        overrides?.each { tense, form -> registerOverride(root, tense, form) }
    }

    /** English name → Cherokee root, or null when not bridged. -- tio 12Nov26 */
    static String resolveRoot(String englishName) {
        return englishName ? nameIndex[englishName.toLowerCase()] : null
    }

    /**
     * True when this Cherokee root is bridged (has a verified English name).
     * Used by the stemmer's category report to accept an sg3-stripped root
     * variant ONLY on positive match -- never by blind stripping (the sg3
     * allomorph Ꭰ can be stem-initial, e.g. To Fish "asuhvs"). -- tio 12Nov26
     */
    static boolean isBridged(String root) {
        return root != null && nameIndex.containsValue(root)
    }

    /** Flags an English seed whose root is not yet engine-verified. -- tio 12Nov26 */
    static void markUnresolved(String englishName) {
        if (englishName && !unresolvedNames.contains(englishName)) {
            unresolvedNames << englishName
        }
    }

    /**
     * Read-only diagnostics: what the registry knows about a root. Used by the
     * stemmer's category report (Stemmer.getCategoryReport) so deconstruction
     * surfaces classification without touching any conjugation path.
     * -- tio 12Nov26
     */
    static String describe(String root) {
        List<VerbCategory> cats = getCategories(root)
        String name = nameIndex.find { it.value == root }?.key
        String shownRoot = root ? root : "<empty>"
        String shownName = name ? "'${name}'" : "<unbridged>"
        return "root=${shownRoot} name=${shownName} categories=${cats}"
    }

    /** Names still lacking a verified root; visible for the category audit. -- tio 12Nov26 */
    static List<String> getUnresolvedNames() {
        return new ArrayList(unresolvedNames)
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
