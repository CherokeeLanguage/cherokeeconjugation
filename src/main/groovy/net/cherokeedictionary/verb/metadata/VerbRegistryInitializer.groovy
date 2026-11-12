package net.cherokeedictionary.verb.metadata

/**
 * Registry initializer to be called at system boot.
 * Populates categories and overrides. -- tio 11Nov26
 *
 * tio 12Nov26: lookups happen by Cherokee root (verb.root = bare stem minus
 * tense ending, engine-computed; e.g. "gowati" for To See PRESENT). Seeds are
 * split by whether the root is verified:
 *
 *  - bridge(name, root, cats): root captured from a live engine conjugation
 *    (RootTrace, tio 12Nov26) -- data is re-keyed onto the root and the name
 *    resolves via VerbRegistry.resolveRoot.
 *  - pending(name, cats): English name only; registered under the name AND
 *    listed in VerbRegistry.unresolvedNames so the category audit can supply
 *    roots later. Missing data stays visible; nothing is silently dropped.
 *
 * RECHECK: roots are tense-stem-dependent (REMOTE_PAST of To See is "gohv",
 * not "gowati"). Today only PRESENT roots are bridged; cross-tense root
 * variants need seeding when overrides fire on non-present tenses.
 */
class VerbRegistryInitializer {
    static void init() {
        // --- Bridged verbs: root verified from the engine -- tio 12Nov26 ---
        bridge("to see", "gowati", [VerbCategory.NORMAL])
        bridge("to speak", "woni", [VerbCategory.NORMAL])
        bridge("to greet", "yoli", [VerbCategory.NORMAL])
        bridge("to hear", "advgi", [VerbCategory.NORMAL])
        bridge("to want", "aduli", [VerbCategory.IRREGULAR])
        bridge("to kill", "hi", [VerbCategory.NORMAL])
        bridge("to hit", "vni", [VerbCategory.NORMAL])
        // NOTE: "to have" is special-cased in the engine (empty root, fully
        // short-circuited); not bridgeable until root is non-empty.

        // --- Categorization based on verb taxonomy audit -- tio 11Nov26 ---
        // pending: root not yet captured from the engine -- tio 12Nov26

        // Motion verbs
        ["arriving", "coming", "climbing", "crawling", "driving", "entering", "exiting",
         "going", "running", "walking", "swimming"].each { pending(it, VerbCategory.MOTION) }

        // Liquid Handling
        ["drink", "spilling", "pouring"].each { pending(it, VerbCategory.LIQUID_HANDLING) }

        // Solid Handling (Flexible/Neutral)
        ["bake", "cook", "cut", "slicing", "fry", "wash"].each { pending(it, VerbCategory.SOLID_HANDLING) }

        // State/Position
        ["lying", "standing", "sitting", "hang"].each { pending(it, VerbCategory.STATE) }
        pending("lying", VerbCategory.POSITION)
        pending("standing", VerbCategory.POSITION)
        pending("sitting", VerbCategory.POSITION)

        // Irregular verbs (as identified in guide/tests)
        ["have", "be"].each { pending(it, VerbCategory.IRREGULAR) }
        // ("go" and "want" were double-seeded IRREGULAR here; "want" is bridged
        //  above, "go" is pending as MOTION from the motion list -- tio 12Nov26)
    }

    /** Seed under the English name, then re-key onto the verified root. -- tio 12Nov26 */
    static void bridge(String name, String root, List<VerbCategory> categories) {
        for (VerbCategory category : categories) {
            VerbRegistry.addCategory(name, category)
        }
        VerbRegistry.registerVerbName(name, root)
    }

    /** Seed under the English name only; surfaced via VerbRegistry.unresolvedNames. -- tio 12Nov26 */
    static void pending(String name, VerbCategory category) {
        VerbRegistry.addCategory(name, category)
        VerbRegistry.markUnresolved(name)
    }
}
