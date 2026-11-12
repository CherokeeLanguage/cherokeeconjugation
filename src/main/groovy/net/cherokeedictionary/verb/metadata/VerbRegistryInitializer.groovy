package net.cherokeedictionary.verb.metadata

/**
 * Registry initializer to be called at system boot.
 * Populates categories and overrides. -- tio 11Nov26
 */
class VerbRegistryInitializer {
    static void init() {
        // --- Categorization based on verb taxonomy audit -- tio 11Nov26
        
        // Motion verbs
        ["arriving", "coming", "climbing", "crawling", "driving", "entering", "exiting", 
         "going", "running", "walking", "swimming"].each { VerbRegistry.addCategory(it, VerbCategory.MOTION) }
         
        // Liquid Handling
        ["drink", "spilling", "pouring"].each { VerbRegistry.addCategory(it, VerbCategory.LIQUID_HANDLING) }
        
        // Solid Handling (Flexible/Neutral)
        ["bake", "cook", "cut", "slicing", "fry", "wash"].each { VerbRegistry.addCategory(it, VerbCategory.SOLID_HANDLING) }
        
        // State/Position
        ["lying", "standing", "sitting", "hang"].each { VerbRegistry.addCategory(it, VerbCategory.STATE) }
        VerbRegistry.addCategory("lying", VerbCategory.POSITION)
        VerbRegistry.addCategory("standing", VerbCategory.POSITION)
        VerbRegistry.addCategory("sitting", VerbCategory.POSITION)

        // Irregular verbs (as identified in guide/tests)
        ["have", "want", "be", "go"].each { VerbRegistry.addCategory(it, VerbCategory.IRREGULAR) }
    }
}
